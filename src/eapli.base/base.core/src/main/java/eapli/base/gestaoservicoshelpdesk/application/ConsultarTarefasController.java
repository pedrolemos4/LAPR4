package eapli.base.gestaoservicoshelpdesk.application;

import eapli.base.servico.domain.Servico;
import eapli.base.servico.repositories.ServicoRepository;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.application.UseCaseController;


@UseCaseController
public class ConsultarTarefasController {
    private final ServicoRepository repo = PersistenceContext.repositories().servicos();

    public void tarefasPendentes(Iterable<Servico> listaServicos) {

    }

    public Iterable<Servico> listServicos() {
        final Iterable<Servico> ls = repo.findAll();
        return ls;
    }

}
