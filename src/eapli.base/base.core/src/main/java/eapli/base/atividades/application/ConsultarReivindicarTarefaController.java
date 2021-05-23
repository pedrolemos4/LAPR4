package eapli.base.atividades.application;

import eapli.base.atividades.domain.Atividade;
import eapli.base.atividades.domain.AtividadeManual;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.repositories.ColaboradorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.pedido.domain.Pedido;
import eapli.base.pedido.repositories.PedidoRepository;
import eapli.base.servico.domain.Servico;
import eapli.base.servico.repositories.ServicoRepository;
import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

@UseCaseController
public class ConsultarReivindicarTarefaController {

    private AuthorizationService authz = AuthzRegistry.authorizationService();
    private ColaboradorRepository colabRepo= PersistenceContext.repositories().colaborador();
    private PedidoRepository pRepo= PersistenceContext.repositories().pedidos();

    private SystemUser currentUser() {
        return authz.session().get().authenticatedUser();
    }

    public Colaborador getUser(){
        final SystemUser user = currentUser();
        EmailAddress email = user.email();
        return this.colabRepo.findEmailColaborador(email);
    }

    public Atividade getTarefaById(int idAtividade) {
        return this.pRepo.getTarefaById(idAtividade);
    }

    public Iterable<Atividade> getListaTarefasPendentes(MecanographicNumber identity, String atividade) {
        return this.pRepo.getListaTarefasPendentes(identity, atividade);
    }

    public Pedido getPedidoByTarefa(int idAtividade) {
        return this.pRepo.getPedidoByTarefa(idAtividade);
    }

    public void saveAtualizacao(Pedido pedido) {
        this.pRepo.save(pedido);
    }
}
