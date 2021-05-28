package eapli.base.atividades.application;

import eapli.base.atividades.domain.Atividade;
import eapli.base.atividades.domain.EstadoAtividade;
import eapli.base.atividades.domain.FluxoAtividade;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.repositories.ColaboradorRepository;
import eapli.base.pedido.domain.Pedido;
import eapli.base.pedido.repositories.PedidoRepository;
import eapli.base.servico.domain.Servico;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.Calendar;
import java.util.List;

@UseCaseController
public class ConsultarTarefasController {
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

    public List<Atividade> tarefasPendentes(FluxoAtividade fluxo, Colaborador colab) {
        return repo.findTarefasServico(fluxo.identity(), colab, EstadoAtividade.PENDENTE);
    }

    public List<Atividade> filtrarUrgencia(Long fluxo, Colaborador colab) {
        return null; //repo.ordenarUrgenciaCrescente(fluxo, colab.identity(), EstadoAtividade.PENDENTE.name());
    }

    public List<Atividade> filtrarData(FluxoAtividade fluxo, Colaborador colab, Calendar dataI, Calendar dataF) {
        return repo.filtrarData(fluxo.identity(), colab.identity(), dataI, dataF, EstadoAtividade.PENDENTE.name());
    }

    public List<Atividade> filtrarCriticidade(Long fluxo, Colaborador colab) {
        return null; //repo.ordenarUrgenciaCrescente(fluxo, colab.identity(), EstadoAtividade.PENDENTE.name());
    }

    public List<Atividade> ordenarUrgenciaCrescente(Long fluxo, Colaborador colab) {
        return null; //repo.ordenarUrgenciaCrescente(fluxo, colab.identity(), EstadoAtividade.PENDENTE.name());
    }

    public List<Atividade> ordenarUrgenciaDecrescente(Long fluxo, Colaborador colab) {
        return null; //repo.ordenarUrgenciaDecrescente(fluxo, colab.identity(), EstadoAtividade.PENDENTE.name());
    }

    public List<Atividade> ordenarDataCrescente(FluxoAtividade fluxo, Colaborador colab) {
        return repo.ordenarDataCrescente(fluxo.identity(), colab.identity(), EstadoAtividade.PENDENTE.name());
    }

    public List<Atividade> ordenarDataDecrescente(FluxoAtividade fluxo, Colaborador colab) {
        return repo.ordenarDataDecrescente(fluxo.identity(), colab.identity(), EstadoAtividade.PENDENTE.name());
    }

    public List<Atividade> ordenarCritCrescente(Long fluxo, String servico, Colaborador colab) {
        return repo.ordenarCritCrescente(fluxo, servico, colab.identity(), EstadoAtividade.PENDENTE.name());
    }

    public List<Atividade> ordenarCritDecrescente(Long fluxo, String servico, Colaborador colab) {
        return repo.ordenarCritDecrescente(fluxo, servico, colab.identity(), EstadoAtividade.PENDENTE.name());
    }

    public Servico getServico(Pedido p) {
        return repo.findPedidoServico(p.identity());
    }

    public FluxoAtividade getFluxo(Servico s) {
        return repo.findFluxoServico(s.identity());
    }

    public Iterable<Pedido> listPedidos() {
        final Iterable<Pedido> ls = repo.findAll();
        return ls;
    }

}
