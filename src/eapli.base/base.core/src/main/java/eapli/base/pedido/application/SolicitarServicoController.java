package eapli.base.pedido.application;

import eapli.base.atividade.domain.Atividade;
import eapli.base.catalogo.domain.Catalogo;
import eapli.base.catalogo.repositories.CatalogoRepository;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.repositories.ColaboradorRepository;
import eapli.base.equipa.domain.CodigoUnico;
import eapli.base.equipa.domain.Equipa;
import eapli.base.formulario.domain.Atributo;
import eapli.base.formulario.domain.Formulario;
import eapli.base.formulario.repositories.FormularioRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.pedido.domain.Pedido;
import eapli.base.pedido.domain.UrgenciaPedido;
import eapli.base.pedido.repositories.PedidoRepository;
import eapli.base.servico.domain.Servico;
import eapli.base.servico.repositories.ServicoRepository;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.NoResultException;
import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.*;

@UseCaseController
public class SolicitarServicoController {

    static InetAddress serverIP;
    static Socket sock;

    private AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ColaboradorRepository repository = PersistenceContext.repositories().colaborador();
    private final CatalogoRepository catalogoRepository = PersistenceContext.repositories().catalogo();
    private final ServicoRepository servicoRepository = PersistenceContext.repositories().servicos();
    private final PedidoRepository pedidoRepository = PersistenceContext.repositories().pedidos();
    private final ColaboradorRepository colaboradorRepository = PersistenceContext.repositories().colaborador();
    private final FormularioRepository formularioRepository = PersistenceContext.repositories().formularios();

    private static final Logger LOGGER = LoggerFactory.getLogger(Pedido.class);


    public List<Catalogo> displayAvailableCatalogos(){
        List<Catalogo> catalogosDisponiveis = new ArrayList<>();
        try{
            Colaborador loggedColaborador = repository.findEmailColaborador(this.authz.session().get().authenticatedUser().email());
            ArrayList<Equipa> associatedTeams = (ArrayList<Equipa>) repository.findAssociatedTeams(loggedColaborador.identity());
            for (Equipa e : associatedTeams) {
                catalogosDisponiveis.addAll((Collection<? extends Catalogo>) catalogoRepository.findCatalogoEquipa(e.identity()));
            }
            return (ArrayList<Catalogo>) catalogosDisponiveis;
        }catch (Exception e){
            LOGGER.error("Unexpected error");
       }
        return new ArrayList<>();
    }

    public Iterable<Servico> getServicosCatalogo(long idCatalogo){
        try {
            return servicoRepository.findServicosDoCatalogo(idCatalogo);
        }catch (NoResultException e){
            LOGGER.error("Not found");
            return null;
        }
    }

    public synchronized Pedido efetuarPedido(Servico servicoSolicitado, UrgenciaPedido urgencia, Calendar dataLimiteRes, Formulario formulario, Set<Atributo> atributos){
        try{
            formulario.copyAtributos(atributos);
            Colaborador colab = colaboradorRepository.findEmailColaborador(this.authz.session().get().authenticatedUser().email());
            Pedido pedido = new Pedido(colab, Calendar.getInstance(),servicoSolicitado,urgencia,dataLimiteRes,formulario);
            return this.pedidoRepository.save(pedido);
        }
        catch (Exception e){
            LOGGER.error("Something went wrong");
            return null;
        }
    }

    public boolean atualizarDataAtividade(Servico clone, Atividade atividade,Calendar dataLimiteRes){
        try {
            clone.atualizarDataAtividade(atividade,dataLimiteRes);
            return true;
        }catch (Exception e){
            LOGGER.error("Unexpected Error");
            return false;
        }
    }

    public void annexFile(Pedido pedido) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.getUI();
        File file = fileChooser.getSelectedFile();
        pedido.annexFile(file);
    }

    public Formulario findFormulario(String idServico) {
        try{
            return formularioRepository.getFormularioDoServico(idServico);
        }
        catch (Exception e){
            LOGGER.error("Something went wrong");
            return null;
        }
    }

    public Atributo createAtributo(String nomeVariavel, String label) {
        final Atributo atributo = new Atributo(nomeVariavel, label);
        return atributo;
    }

    public void doConnection(Pedido pedido) throws IOException, InterruptedException {
        byte[] data = new byte[258];
        try {
            serverIP = InetAddress.getLocalHost();//.getByName("endereçoIp");
        } catch (UnknownHostException ex) {
            System.out.println("Invalid server: " + "endereçoIp");
            System.exit(1);
        }

        try {
            sock = new Socket(serverIP, 32507);
        } catch (IOException ex) {
            System.out.println("Failed to connect.");
            System.exit(1);
        }
        DataOutputStream sOut = new DataOutputStream(sock.getOutputStream());
        System.out.println("Connected to server");
        //Thread serverConn = new Thread(new TcpChatCliConn(sock));
        //serverConn.start();

        data[0] = 0;
        data[1] = 3;
        byte[] idArray = pedido.servico().identity().toString().getBytes();
        data[2] = (byte)idArray.length;
        for(int i = 0; i<idArray.length;i++){
            data[i+2] = idArray[i];
        }

        sOut.write(data);

        // serverConn.join();
        sock.close();
    }

    public synchronized boolean submeterPedido(Pedido pedido) {
        try{
            pedidoRepository.save(pedido);
            return true;
        }
        catch (Exception e){
            LOGGER.error("Error saving Pedido");
            return false;
        }
    }

    public List<Atividade> getListAtividadesServico(String idServico) {
        try {
            return this.servicoRepository.findListAtividades(idServico);
        }catch (NoResultException e){
            LOGGER.error("No result found");
            return new ArrayList<>();
        }
    }

    public Servico getServicoClone(String idServico) {
        Servico servicoSolicitado = servicoRepository.ofIdentity(new CodigoUnico(idServico)).get();
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
        int nChars;
        byte[] data = new byte[300];
        String frase;

        try {
            sIn = new DataInputStream(s.getInputStream());
            while (true) {
                nChars = sIn.read();
                if (nChars == 0) break;
                sIn.read(data, 0, nChars);
                frase = new String(data, 0, nChars);
                System.out.println(frase);
            }
        } catch (IOException ex) {
            System.out.println("Client disconnected.");
        }
    }
}

