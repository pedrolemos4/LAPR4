package eapli.base.pedido.application;

import eapli.base.atividade.domain.Atividade;
import eapli.base.catalogo.domain.Catalogo;
import eapli.base.catalogo.repositories.CatalogoRepository;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.repositories.ColaboradorRepository;
import eapli.base.equipa.domain.CodigoUnico;
import eapli.base.equipa.domain.Equipa;
import eapli.base.formulario.domain.Label;
import eapli.base.formulario.domain.*;
import eapli.base.formulario.repositories.FormularioRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.pedido.domain.Pedido;
import eapli.base.pedido.domain.UrgenciaPedido;
import eapli.base.pedido.repositories.PedidoRepository;
import eapli.base.servico.domain.Servico;
import eapli.base.servico.repositories.ServicoRepository;
import eapli.base.validacoes.validaFormulario.ValidaForm;
import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.persistence.NoResultException;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;
import java.util.*;

@UseCaseController
public class SolicitarServicoController {

    static InetAddress serverIP;
    //static Socket sock;
    static SSLSocket sockSSL;
    static final String KEYSTORE_PASS = "forgotten";

    private static final int MOTOR_PORT = 32508;

    private static final String IPMOTOR = "10.8.0.82";

    private AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ColaboradorRepository repository = PersistenceContext.repositories().colaborador();
    private final CatalogoRepository catalogoRepository = PersistenceContext.repositories().catalogo();
    private final ServicoRepository servicoRepository = PersistenceContext.repositories().servicos();
    private final PedidoRepository pedidoRepository = PersistenceContext.repositories().pedidos();
    private final ColaboradorRepository colaboradorRepository = PersistenceContext.repositories().colaborador();
    private final FormularioRepository formularioRepository = PersistenceContext.repositories().formularios();

    private static final Logger LOGGER = LoggerFactory.getLogger(Pedido.class);

    private SystemUser currentUser() {
        return authz.session().get().authenticatedUser();
    }

    public Colaborador getUser(){
        final SystemUser user = currentUser();
        EmailAddress email = user.email();
        return this.repository.findEmailColaborador(email);
    }

    public List<Catalogo> displayAvailableCatalogos() {
        List<Catalogo> catalogosDisponiveis = new ArrayList<>();
        try {
            Colaborador loggedColaborador = repository.findEmailColaborador(this.authz.session().get().authenticatedUser().email());
            ArrayList<Equipa> associatedTeams = (ArrayList<Equipa>) repository.findAssociatedTeams(loggedColaborador.identity());
            for (Equipa e : associatedTeams) {
                catalogosDisponiveis.addAll((Collection<? extends Catalogo>) catalogoRepository.findCatalogoEquipa(e.identity()));
            }
            return (ArrayList<Catalogo>) catalogosDisponiveis;
        } catch (Exception e) {
            LOGGER.error("Unexpected error");
        }
        return new ArrayList<>();
    }

    public Iterable<Servico> getServicosCatalogo(long idCatalogo) {
        try {
            return servicoRepository.findServicosDoCatalogo(idCatalogo);
        } catch (NoResultException e) {
            LOGGER.error("Not found");
            return null;
        }
    }

    public synchronized Pedido efetuarPedido(Servico servicoSolicitado, UrgenciaPedido urgencia, Calendar dataLimiteRes,
                                             Formulario formulario, Set<Atributo> atributos, Set<Atividade> atividades) {
        try {
            formulario.copyAtributos(atributos);

            File file = new File("testForm.txt");
            FileWriter fw = new FileWriter(file);
            fw.write(formulario.toString());
            ValidaForm vf = new ValidaForm();
            boolean checkForm = vf.validaForm(file);

            //  if (checkForm == true) {
            Colaborador colab = colaboradorRepository.findEmailColaborador(this.authz.session().get().authenticatedUser().email());
            Pedido pedido = new Pedido(colab, Calendar.getInstance(), servicoSolicitado, urgencia, dataLimiteRes, formulario, atividades);
            return this.pedidoRepository.save(pedido);
            /*} else {
                System.out.println("Formulário inválido. Pedido não será efetuado.");
            }*/
        } catch (Exception e) {
            LOGGER.error("Something went wrong");
            return null;
        }
        //     return null;
    }

    public boolean atualizarDataAtividade(Atividade atividade, Calendar dataLimiteRes) {
        try {
            atividade.atualizarDataAtividade(dataLimiteRes);
            return true;
        } catch (Exception e) {
            LOGGER.error("Unexpected Error");
            return false;
        }
    }

    public List<Atributo> findAtributos(Long identity) {
        return formularioRepository.findAtributos(identity);
    }

    public String label(Atributo a) {
        return a.label().toString();
    }

    public TipoDados tipoDados(Atributo a) {
        return a.tipoDados();
    }

    public Obrigatoriedade obrigatoriedade(Atributo a) {
        return a.obrigatoriedade();
    }

    public String descricaoAjuda(Atributo a){
        return a.descricaoAjuda().toString();
    }

    public void annexFile(Pedido pedido) {
        Button button = new Button();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(button);
        File file = fileChooser.getSelectedFile();
        pedido.annexFile(file);
    }

    public Formulario findFormulario(CodigoUnico idServico) {
        try {
            return formularioRepository.getFormularioDoServico(idServico);
        } catch (Exception e) {
            LOGGER.error("Something went wrong");
            return null;
        }
    }

    public Atributo createAtributo(String nomeVariavel, String label, TipoDados tipoDados, Obrigatoriedade obrigatoriedade,
                                   String descAjuda, Formulario formulario) {
        //TipoDados tipoDados1 = Enum.valueOf(TipoDados.class, tipoDados.toUpperCase());
        //Obrigatoriedade obr = Enum.valueOf(Obrigatoriedade.class, obrigatoriedade.toUpperCase());
        DescricaoAjuda descricaoAjuda = new DescricaoAjuda(descAjuda);
        final Atributo atributo = new Atributo(new Variavel(nomeVariavel), new Label(label), tipoDados, obrigatoriedade,
                descricaoAjuda, formulario);
        return atributo;
    }

    public void doConnection(Pedido pedido) throws IOException, InterruptedException {
        /*if (args.length != 2) {
        System.out.println("Server IPv4/IPv6 address/DNS name is required as first argument");
        System.out.println("Client name is required as second argument (a matching keystore must exist)");
        System.exit(1);
        }*/
        final String name = this.authz.session().get().authenticatedUser().username().toString();
        System.out.println("Name: " + name);
        // Trust these certificates provided by servers
        System.setProperty("javax.net.ssl.trustStore", name + ".jks");
        System.setProperty("javax.net.ssl.trustStorePassword", KEYSTORE_PASS);

        // Use this certificate and private key for client certificate when requested by the server
        System.setProperty("javax.net.ssl.keyStore", name + ".jks");
        System.setProperty("javax.net.ssl.keyStorePassword", KEYSTORE_PASS);

        SSLSocketFactory sf = (SSLSocketFactory) SSLSocketFactory.getDefault();

        try {
            serverIP = InetAddress.getByName(IPMOTOR);
        } catch (UnknownHostException ex) {
            System.out.println("Invalid server specified: " + IPMOTOR);
            System.exit(1);
        }


        try {
            sockSSL = (SSLSocket) sf.createSocket(serverIP, MOTOR_PORT);
        } catch (IOException ex) {
            System.out.println("Failed to connect to: " + IPMOTOR + ":" + MOTOR_PORT);
            System.out.println("Application aborted.");
            System.exit(1);
        }

        System.out.println("Connected to: " + IPMOTOR + ":" + MOTOR_PORT);


        sockSSL.startHandshake();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream sOut = new DataOutputStream(sockSSL.getOutputStream());
        DataInputStream sIn = new DataInputStream(sockSSL.getInputStream());

        /*
        String frase;
        long f,i,n,num;
        do {
            do {
                num=-1;
                while(num<0) {
                    System.out.print("Enter a positive integer to SUM (zero to terminate): ");
                    frase = in.readLine();
                    try { num=Integer.parseInt(frase); }
                    catch(NumberFormatException ex) {num=-1;}
                    if(num<0) System.out.println("Invalid number");
                }
                n=num; for(i=0;i<4;i++) {sOut.write((byte)(n%256)); n=n/256; }
            }
            while(num!=0);
            num=0; f=1;
            for(i=0;i<4;i++) {num=num+f*sIn.read(); f=f*256;}
            System.out.println("SUM RESULT = " + num);
        }
        while(num!=0);
        sock.close();
        */

        ///////////////////////////////
        byte[] data = new byte[258];
        /*try {
            serverIP = InetAddress.getLocalHost();//.getByName("endereçoIp");
        } catch (UnknownHostException ex) {
            LOGGER.error("Invalid server: " + serverIP);
            System.exit(1);
        }

        try {
            sock = new Socket(serverIP, 32507);
        } catch (IOException ex) {
            LOGGER.error("Failed to connect");
            System.exit(1);
        }
        DataOutputStream sOut = new DataOutputStream(sock.getOutputStream());*/
        LOGGER.warn("Connected to server");
        Thread serverConn = new Thread(new TcpChatCliConn(sockSSL));
        serverConn.start();

        data[0] = 0;
        data[1] = 3;
        byte[] idArray = pedido.identity().getBytes();
        int size = idArray.length;
        data[2] = (byte) size;
        double amount_of_times = size / 255;
        int p = 0;

        while (amount_of_times > 1) {

            byte[] info = new byte[258];
            info[0] = 0;
            info[1] = 10;
            for (int k = 0; k < 255; k++) {
                if (p < size) {
                    info[k + 2] = idArray[p];
                    p++;
                } else {
                    k = 255;
                }
            }
            sOut.write(info);
            size -= 255;
            amount_of_times--;
        }

        for (int i = 0; i < idArray.length; i++) {
            data[i + 2] = idArray[p];
            p++;
        }

        sOut.write(data);

        serverConn.join();
        sockSSL.close();
    }

    public synchronized boolean submeterPedido(Pedido pedido) {
        try {
            pedidoRepository.save(pedido);
            return true;
        } catch (Exception e) {
            LOGGER.error("Error saving Pedido");
            return false;
        }
    }

    public List<Atividade> getListAtividadesServico(CodigoUnico idServico) {
        try {
            return this.servicoRepository.findListAtividades(idServico);
        } catch (NoResultException e) {
            LOGGER.error("No result found");
            return new ArrayList<>();
        }
    }

    public Servico getServicoClone(CodigoUnico idServico) {
        Servico servicoSolicitado = servicoRepository.ofIdentity(idServico).get();
        Servico clone = servicoSolicitado;
        return clone;
    }
}

class TcpChatCliConn implements Runnable {
    private Socket s;
    private DataInputStream sIn;

    public TcpChatCliConn(Socket tcp_s) {
        s = tcp_s;
    }

    public void run() {
        byte[] data = new byte[258];

        try {
            sIn = new DataInputStream(s.getInputStream());
            sIn.read(data);
            if(data[1]==1) {
                System.out.println("Sucesso");
            }
        } catch (IOException ex) {
            System.out.println("Client disconnected.");
        }
    }
}

