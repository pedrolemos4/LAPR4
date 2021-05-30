package eapli.base.atividade.application;

import eapli.base.atividade.domain.Atividade;
import eapli.base.atividade.domain.EstadoAtividade;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.repositories.ColaboradorRepository;
import eapli.base.criticidade.domain.Escala;
import eapli.base.criticidade.domain.Etiqueta;
import eapli.base.pedido.domain.Pedido;
import eapli.base.pedido.domain.UrgenciaPedido;
import eapli.base.pedido.repositories.PedidoRepository;

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

    public List<Atividade> filtrarCriticidadeEscala(Colaborador colab, int escala) {
        return repo.filtrarCriticidadeEscala(colab, EstadoAtividade.PENDENTE, Escala.valueOf(escala));
    }

    public List<Atividade> filtrarCriticidadeEtiqueta(Colaborador colab, String etiqueta) {
        return repo.filtrarCriticidadeEtiqueta(colab, EstadoAtividade.PENDENTE, Etiqueta.valueOf(etiqueta));
    }

    public List<Atividade> ordenarDataCrescente(Colaborador colab) {
        return repo.ordenarDataCrescente(colab, EstadoAtividade.PENDENTE);
    }

    public List<Atividade> ordenarDataDecrescente(Colaborador colab) {
        return repo.ordenarDataDecrescente(colab, EstadoAtividade.PENDENTE);
    }

    public List<Atividade> ordenarEscalaCrescente(Colaborador colab) {
        return repo.ordenarEscalaCrescente(colab, EstadoAtividade.PENDENTE);
    }

    public List<Atividade> ordenarEscalaDecrescente(Colaborador colab) {
        return repo.ordenarEscalaDecrescente(colab, EstadoAtividade.PENDENTE);
    }

    public Pedido getPedidoByAtividade(Atividade a) {
        return repo.getPedidoByAtividade(a.identity());
    }
}
