package base.daemon.motor.algorithms;

import eapli.base.atividade.domain.Atividade;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.pedido.repositories.PedidoRepository;

public class WorkloadController {
    private static final PedidoRepository repository = PersistenceContext.repositories().pedidos();

    public Atividade getTarefaByScript(String caminho) {
        return repository.getTarefaByScript(caminho);
    }

    public Double getTempoDeExecucaoTarefa(Atividade atividade) {
        return repository.getTempoDeExecucaoTarefa(atividade);
    }
}
