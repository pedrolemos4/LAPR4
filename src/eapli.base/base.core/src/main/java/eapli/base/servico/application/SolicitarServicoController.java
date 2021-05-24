package eapli.base.servico.application;

import eapli.base.catalogo.domain.Catalogo;
import eapli.base.catalogo.repositories.CatalogoRepository;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.repositories.ColaboradorRepository;
import eapli.base.criticidade.domain.Criticidade;
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
import java.util.*;

@UseCaseController
public class SolicitarServicoController {

    private AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ColaboradorRepository repository = PersistenceContext.repositories().colaborador();
    private final CatalogoRepository catalogoRepository = PersistenceContext.repositories().catalogo();
    private final ServicoRepository servicoRepository = PersistenceContext.repositories().servicos();
    private final PedidoRepository pedidoRepository = PersistenceContext.repositories().pedidos();
    private final ColaboradorRepository colaboradorRepository = PersistenceContext.repositories().colaborador();
    private final FormularioRepository formularioRepository = PersistenceContext.repositories().formularios();

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
        //try{
            Criticidade criticidade = servicoRepository.getCriticidade(servico.identity());
        System.out.println(criticidade);
            Colaborador colab = colaboradorRepository.findEmailColaborador(loggedUser.email());
            Pedido pedido = new Pedido(colab,Calendar.getInstance().getTime(),servico,criticidade,urgencia,dataLimiteRes);
            pedidoRepository.save(pedido);
            return true;
    //    }
        //catch (Exception e){
        //    LOGGER.error("Something went wrong");
        //    return false;
        //}

    }

    public boolean preencherFormulario(String idServico) {
        //try{
            servico = servicoRepository.ofIdentity(new CodigoUnico(idServico)).orElse(null);
            if (servico != null) {
                //Formulario formulario = servicoRepository.getAssociatedFormulario(idServico);
                //formularioRepository.save(formulario);
                return true;
            }
            return false;
        //}
        //catch (Exception e){
          //  LOGGER.error("Something went wrong");
            //return false;
       // }

    }
}
