package eapli.base.pedido.application;

import eapli.base.catalogo.domain.Catalogo;
import eapli.base.catalogo.repositories.CatalogoRepository;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.repositories.ColaboradorRepository;
import eapli.base.criticidade.repositories.CriticidadeRepository;
import eapli.base.equipa.domain.CodigoUnico;
import eapli.base.equipa.domain.Equipa;
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
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.NoResultException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
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
    private final CriticidadeRepository criticidadeRepository = PersistenceContext.repositories().criticidade();

    private static final Logger LOGGER = LoggerFactory.getLogger(Pedido.class);

    private static ArrayList<Catalogo> catalogosAutorizados = new ArrayList<>();

    private SystemUser loggedUser = this.authz.session().get().authenticatedUser();

    private Servico servico;

    public List<Catalogo> displayAvailableCatalogos(){
        List<Catalogo> catalogosDisponiveis = new ArrayList<>();
        try{
            Colaborador loggedColaborador = repository.findEmailColaborador(loggedUser.email());
            ArrayList<Equipa> associatedTeams = (ArrayList<Equipa>) repository.findAssociatedTeams(loggedColaborador.identity());
            for (Equipa e : associatedTeams) {
                catalogosDisponiveis.addAll((Collection<? extends Catalogo>) catalogoRepository.findCatalogoEquipa(e.identity()));
            }
            catalogosAutorizados = (ArrayList<Catalogo>) catalogosDisponiveis;
        }catch (Exception e){
            LOGGER.error("Unexpected error");
       }
        return catalogosDisponiveis;
    }

    public Iterable<Servico> getServicosCatalogo(long idCatalogo){
        try {
            Catalogo c = catalogoRepository.findById(idCatalogo);
            if(catalogosAutorizados.contains(c)){
                return servicoRepository.findServicosDoCatalogo(idCatalogo);
            }
            else{
                LOGGER.error("No authorization to access this catalog");
                return null;
            }
        }catch (NoResultException e){
            LOGGER.error("Not found");
            return null;
        }
    }

    public boolean efetuarPedido(UrgenciaPedido urgencia, Date dataLimiteRes){
       // try{
            Colaborador colab = colaboradorRepository.findEmailColaborador(loggedUser.email());
            Pedido pedido = new Pedido(colab,Calendar.getInstance().getTime(),servico,urgencia,dataLimiteRes);
            pedidoRepository.save(pedido);
            return true;
       // }
       // catch (Exception e){
       //     LOGGER.error("Something went wrong");
       //     return false;
       // }

    }

    public boolean preencherFormulario(String idServico) {
        try{
            servico = servicoRepository.ofIdentity(new CodigoUnico(idServico)).get();
            if (servico != null) {
                //Formulario formulario = servicoRepository.getAssociatedFormulario(idServico);
                //formularioRepository.save(formulario);
                return true;
            }
            return false;
        }
        catch (Exception e){
            LOGGER.error("Something went wrong");
            return false;
        }

    }

    public void doConnection(Pedido pedido) throws IOException, InterruptedException {
        byte[] data = new byte[300];
        String frase;
        try {
            serverIP = InetAddress.getByName("endereçoIp");
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

        //while(true) { // read messages from the console and send them to the server
        frase = pedido.servico().identity().toString();
        // if(frase.compareTo("exit")==0)
        //{ sOut.write(0); break;}
        data = frase.getBytes();
        //  sOut.write((byte)frase.length());
        //sOut.write(data,0,(byte)frase.length());
        sOut.write((byte) 0);
        sOut.write((byte) 3);
        sOut.write((byte) frase.length());
        sOut.write(data, 3, (byte) frase.length());
        //}

        // serverConn.join();
        sock.close();
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

