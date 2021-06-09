package eapli.base.pedido.application;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.repositories.ColaboradorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.pedido.domain.EstadoPedido;
import eapli.base.pedido.domain.Pedido;
import eapli.base.pedido.repositories.PedidoRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

public class ConsultarHistoricoPedidosController {

    private AuthorizationService authz = AuthzRegistry.authorizationService();
    private PedidoRepository repository = PersistenceContext.repositories().pedidos();
    private ColaboradorRepository colaboradorRepo = PersistenceContext.repositories().colaborador();
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsultarHistoricoPedidosController.class);

    public List<Pedido> getUsersTaskHistory(){
        try{
            SystemUser user = authz.session().get().authenticatedUser();
            Colaborador colaborador = colaboradorRepo.findEmailColaborador(user.email());
            return repository.getPedidosPendentesOrdered(colaborador, EstadoPedido.CONCLUIDO);
        }catch (NoResultException e){
            LOGGER.warn("No task history found");
            return new ArrayList<>();
        }
    }

    public List<Pedido> getUsersOnGoingTaks() {
        try{
            SystemUser user = authz.session().get().authenticatedUser();
            Colaborador colaborador = colaboradorRepo.findEmailColaborador(user.email());
            return repository.getPedidosEmCurso(colaborador);
        }catch (NoResultException e){
            LOGGER.warn("No task history found");
            return new ArrayList<>();
        }
    }
}
