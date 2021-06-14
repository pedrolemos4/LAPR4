package base.daemon.executor.algorithms;

import base.daemon.executor.presentation.ExecutorServer;
import eapli.base.atividade.domain.Atividade;

import java.util.Map;

public class WorkloadTimeCounter implements Runnable {
    private static final WorkloadController controller = new WorkloadController();
    private Map<ExecutorServer, Double> mapExecutores;
    private ExecutorServer es;

    public WorkloadTimeCounter(Map<ExecutorServer, Double> mapExecutores, ExecutorServer executor) {
        this.mapExecutores = mapExecutores;
        this.es = executor;
    }

    @Override
    public void run() {
        synchronized (this) {
            double tempo = 0.0;
            if (es.tarefas().isEmpty()) {
                System.out.println(es.toString() + " Workload: " + tempo);
                mapExecutores.put(es, 0.0);
            } else if (!mapExecutores.containsKey(es)) {
                for (Atividade a : es.tarefas()) {
                    tempo += controller.getTempoDeExecucaoTarefa(a);
                }
                System.out.println(es.toString() + " Workload: " + tempo);
                mapExecutores.put(es, tempo);
            }
        }
    }
}
