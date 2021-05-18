package eapli.base.gestaoservicoshelpdesk.application;

import eapli.base.atividades.domain.Atividade;
import eapli.base.atividades.domain.EstadoAtividade;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.servico.domain.Servico;
import eapli.base.servico.repositories.ServicoRepository;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.application.UseCaseController;

@UseCaseController
public class ConsultarTarefasController {
    private final ServicoRepository repo = PersistenceContext.repositories().servicos();

    public Iterable<Atividade> tarefasPendentes(Iterable<Servico> listaServicos, Colaborador colab) {
        for (Servico s : listaServicos) {

        }
        return repo.findTarefasServico(null, null, EstadoAtividade.PENDENTE.name());
    }

    public Iterable<Servico> listServicos() {
        final Iterable<Servico> ls = repo.findAll();
        return ls;
    }

}
