package eapli.base.servico.application;

import eapli.base.catalogo.domain.Catalogo;
import eapli.base.catalogo.repositories.CatalogoRepository;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.repositories.ColaboradorRepository;
import eapli.base.equipa.domain.Equipa;
import eapli.base.infrastructure.persistence.PersistenceContext;
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
    private static final Logger LOGGER = LoggerFactory.getLogger(Colaborador.class);

    private static ArrayList<Catalogo> catalogosAutorizados = new ArrayList<>();

    public List<Catalogo> displayAvailableCatalogos(){
        SystemUser loggedUser = this.authz.session().get().authenticatedUser();
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


}
