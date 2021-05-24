package eapli.base.atividades.application;

import eapli.base.atividades.domain.Atividade;
import eapli.base.atividades.domain.EstadoAtividade;
import eapli.base.atividades.domain.FluxoAtividade;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.repositories.ColaboradorRepository;
import eapli.base.pedido.domain.Pedido;
import eapli.base.pedido.repositories.PedidoRepository;
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
    private final PedidoRepository repo2 = PersistenceContext.repositories().pedidos();
    private final ColaboradorRepository repo3 = PersistenceContext.repositories().colaborador();

    private SystemUser currentUser() {
        AuthorizationService authz = AuthzRegistry.authorizationService();
        return authz.session().get().authenticatedUser();
    }

    public Colaborador getUser(){
        final SystemUser user = currentUser();
        EmailAddress email = user.email();
        return this.repo3.findEmailColaborador(email);
    }

    public List<Atividade> tarefasPendentes(FluxoAtividade fluxo, Colaborador colab) {
        return repo.findTarefasServico(null, colab.identity(), EstadoAtividade.PENDENTE.name());
    }

    public List<Atividade> ordenarUrgenciaCrescente(FluxoAtividade fluxo, Colaborador colab) {
        return null; //repo.ordenarUrgenciaCrescente(null, colab.identity(), EstadoAtividade.PENDENTE.name());
    }

    public List<Atividade> ordenarUrgenciaDecrescente(FluxoAtividade fluxo, Colaborador colab) {
        return null; //repo.ordenarUrgenciaDecrescente(null, colab.identity(), EstadoAtividade.PENDENTE.name());
    }

    public List<Atividade> ordenarDataCrescente(FluxoAtividade fluxo, Colaborador colab) {
        return null; //repo.ordenarDataCrescente(null, colab.identity(), EstadoAtividade.PENDENTE.name());
    }

    public List<Atividade> ordenarDataDecrescente(FluxoAtividade fluxo, Colaborador colab) {
        return null; //repo.ordenarDataDecrescente(null, colab.identity(), EstadoAtividade.PENDENTE.name());
    }

    public List<Atividade> ordenarCritCrescente(FluxoAtividade fluxo, Servico servico, Colaborador colab) {
        return repo.ordenarCritCrescente(fluxo.identity(), servico.identity(), colab.identity(), EstadoAtividade.PENDENTE.name());
    }

    public List<Atividade> ordenarCritDecrescente(FluxoAtividade fluxo, Servico servico, Colaborador colab) {
        return repo.ordenarCritDecrescente(fluxo.identity(), servico.identity(), colab.identity(), EstadoAtividade.PENDENTE.name());
    }

    public Servico getServico(Pedido p) {
        return repo.findPedidoServico(p.identity());
    }

    public FluxoAtividade getFluxo(Servico s) {
        return repo.findFluxoServico(s.identity());
    }

    public Iterable<Pedido> listPedidos() {
        final Iterable<Pedido> ls = repo2.findAll();
        return ls;
    }

}
