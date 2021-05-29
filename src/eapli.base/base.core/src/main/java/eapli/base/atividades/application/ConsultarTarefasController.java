package eapli.base.atividades.application;

import eapli.base.atividades.domain.Atividade;
import eapli.base.atividades.domain.EstadoAtividade;
import eapli.base.atividades.domain.FluxoAtividade;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.repositories.ColaboradorRepository;
import eapli.base.pedido.domain.Pedido;
import eapli.base.pedido.domain.UrgenciaPedido;
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

    public List<Atividade> tarefasPendentes(Colaborador colab) {
        return repo.findTarefasServico(colab, EstadoAtividade.PENDENTE);
    }

    public List<Atividade> filtrarUrgencia(Colaborador colab, String urgencia) {
        if(urgencia.compareToIgnoreCase("URGENTE") == 0){
            return repo.filtrarUrgencia(colab, EstadoAtividade.PENDENTE, UrgenciaPedido.URGENTE);
        }
        if(urgencia.compareToIgnoreCase("MODERADA") == 0){
            return repo.filtrarUrgencia(colab, EstadoAtividade.PENDENTE, UrgenciaPedido.MODERADA);
        }
        if(urgencia.compareToIgnoreCase("REDUZIDA") == 0){
            return repo.filtrarUrgencia(colab, EstadoAtividade.PENDENTE, UrgenciaPedido.REDUZIDA);
        }
        return null;
    }

    public List<Atividade> filtrarData(Colaborador colab, Calendar dataI, Calendar dataF) {
        return repo.filtrarData(colab, dataI, dataF, EstadoAtividade.PENDENTE);
    }

    public List<Atividade> filtrarCriticidade(FluxoAtividade fluxo, Colaborador colab) {
        return null; //repo.ordenarUrgenciaCrescente(fluxo.identity(), colab.identity(), EstadoAtividade.PENDENTE.name());
    }

    public List<Atividade> ordenarUrgenciaCrescente(FluxoAtividade fluxo, Colaborador colab) {
        return null; //repo.ordenarUrgenciaCrescente(fluxo.identity(), colab.identity(), EstadoAtividade.PENDENTE.name());
    }

    public List<Atividade> ordenarUrgenciaDecrescente(FluxoAtividade fluxo, Colaborador colab) {
        return null; //repo.ordenarUrgenciaDecrescente(fluxo.identity(), colab.identity(), EstadoAtividade.PENDENTE.name());
    }

    public List<Atividade> ordenarDataCrescente(Colaborador colab) {
        return repo.ordenarDataCrescente(colab, EstadoAtividade.PENDENTE);
    }

    public List<Atividade> ordenarDataDecrescente(Colaborador colab) {
        return repo.ordenarDataDecrescente(colab, EstadoAtividade.PENDENTE);
    }

    public List<Atividade> ordenarCritCrescente(FluxoAtividade fluxo, String servico, Colaborador colab) {
        return repo.ordenarCritCrescente(fluxo.identity(), servico, colab.identity(), EstadoAtividade.PENDENTE.name());
    }

    public List<Atividade> ordenarCritDecrescente(FluxoAtividade fluxo, String servico, Colaborador colab) {
        return repo.ordenarCritDecrescente(fluxo.identity(), servico, colab.identity(), EstadoAtividade.PENDENTE.name());
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

    public Pedido getPedidoByAtividade(Atividade a) {
        return repo.getPedidoByAtividade(a.identity());
    }
}
