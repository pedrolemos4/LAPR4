package eapli.base.atividade.application;

import eapli.base.atividade.domain.Atividade;
import eapli.base.atividade.domain.EstadoAtividade;
import eapli.base.atividade.domain.FluxoAtividade;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.repositories.ColaboradorRepository;
import eapli.base.criticidade.domain.Escala;
import eapli.base.criticidade.domain.Etiqueta;
import eapli.base.equipa.domain.Equipa;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.pedido.domain.Pedido;
import eapli.base.pedido.domain.UrgenciaPedido;
import eapli.base.pedido.repositories.PedidoRepository;
import eapli.base.servico.domain.Servico;
import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.Calendar;
import java.util.List;

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

    public Atividade getTarefaById(long idAtividade) {
        return this.pRepo.getTarefaById(idAtividade);
    }

    public List<Atividade> getListaTarefasPendentes(MecanographicNumber identity) {
        return this.pRepo.getListaTarefasPendentes(identity);
    }

    public Pedido getPedidoByTarefa(long idAtividade) {
        return this.pRepo.getPedidoByTarefa(idAtividade);
    }

    public void saveAtualizacao(Pedido pedido) {
        this.pRepo.save(pedido);
    }

    public Pedido getPedidoByAtividade(Atividade a) {
        return this.pRepo.getPedidoByAtividade(a.identity());
    }

    public List<Atividade> filtrarUrgenciaPendentes(Colaborador colab, String urgencia) {
        return this.pRepo.filtrarUrgenciaPendentes(colab.identity(), EstadoAtividade.PENDENTE, UrgenciaPedido.valueOf(urgencia));
    }

    public List<Atividade> filtrarDataPendentes(Colaborador colab, Calendar data1, Calendar data2) {
        return this.pRepo.filtrarDataPendentes(colab.identity(), data1, data2, EstadoAtividade.PENDENTE);
    }

    public List<Atividade> filtrarCriticidadeEscalaPendentes(Colaborador colab, int escala) {
        return this.pRepo.filtrarCriticidadeEscalaPendentes(colab.identity(), Escala.valueOf(escala), EstadoAtividade.PENDENTE);
    }

    public List<Atividade> filtrarCriticidadeEtiquetaPendentes(Colaborador colab, String r2) {
        return this.pRepo.filtrarCriticidadeEtiquetaPendentes(colab.identity(), Etiqueta.valueOf(r2), EstadoAtividade.PENDENTE);
    }

    public List<Atividade> ordenarDataCrescentePendentes(Colaborador colab) {
        return this.pRepo.ordenarDataCrescentePendentes(colab.identity(), EstadoAtividade.PENDENTE);
    }

    public List<Atividade> ordenarDataDecrescentePendentes(Colaborador colab) {
        return this.pRepo.ordenarDataDecrescentePendentes(colab.identity(), EstadoAtividade.PENDENTE);
    }

    public void adicionaColaborador(Pedido pedido, Colaborador colab, Atividade manual) {
        pedido.adicionaColaborador(colab, manual);
    }
}
