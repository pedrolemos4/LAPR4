package eapli.base.atividades.application;

import eapli.base.atividades.domain.Atividade;
import eapli.base.atividades.domain.EstadoAtividade;
import eapli.base.atividades.domain.FluxoAtividade;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.repositories.ColaboradorRepository;
import eapli.base.servico.domain.Servico;
import eapli.base.servico.repositories.ServicoRepository;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.List;

@UseCaseController
public class ConsultarTarefasController {
    private final ServicoRepository repo = PersistenceContext.repositories().servicos();
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

    public List<Atividade> tarefasPendentes(FluxoAtividade fluxo, Colaborador colab) {
        return repo.findTarefasServico(null, colab.identity(), EstadoAtividade.PENDENTE.name());
    }

    public FluxoAtividade getFluxo(Servico s) {
        return repo.findFluxoServico(s.identity());
    }

    public Iterable<Servico> listServicos() {
        final Iterable<Servico> ls = repo.findAll();
        return ls;
    }

}
