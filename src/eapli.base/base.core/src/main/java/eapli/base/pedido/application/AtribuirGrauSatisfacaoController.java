package eapli.base.pedido.application;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.repositories.ColaboradorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.pedido.domain.EstadoPedido;
import eapli.base.pedido.domain.GrauSatisfacao;
import eapli.base.pedido.domain.Pedido;
import eapli.base.pedido.repositories.PedidoRepository;
import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.List;

@UseCaseController
public class AtribuirGrauSatisfacaoController {
    private final PedidoRepository repo = PersistenceContext.repositories().pedidos();
    private final ColaboradorRepository repo2 = PersistenceContext.repositories().colaborador();

    private SystemUser currentUser() {
        AuthorizationService authz = AuthzRegistry.authorizationService();
        return authz.session().get().authenticatedUser();
    }

    public Colaborador getUser(){
        final SystemUser user = currentUser();
        EmailAddress email = user.email();
        return this.repo2.findEmailColaborador(email);
    }

    public List<Pedido> pedidosPendentes(Colaborador colab) {
        return repo.getPedidosPendentes(colab, EstadoPedido.CONCLUIDO);
    }

    public Pedido atribuirGrau(Pedido p, GrauSatisfacao g) {
        p.atribuirGrau(g);
        return repo.save(p);
    }
}
