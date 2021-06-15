package base.daemon.executor.algorithms;

import base.daemon.executor.presentation.ExecutorServer;

import java.util.Map;

public class WorkloadTimeCounter implements Runnable {
    private Map<ExecutorServer, Integer> mapExecutores;
    private ExecutorServer es;

    public WorkloadTimeCounter(Map<ExecutorServer, Integer> mapExecutores, ExecutorServer executor) {
        this.mapExecutores = mapExecutores;
        this.es = executor;
    }

    @Override
    public void run() {
        synchronized (this) {
            if (es.tarefas().isEmpty()) {
                System.out.println(es.toString() + " Workload: " + 0);
                mapExecutores.put(es, 0);
            } else if (!mapExecutores.containsKey(es)) {
                System.out.println(es.toString() + " Workload: " + es.tarefas().size());
                mapExecutores.put(es, es.tarefas().size());
            }
        }
    }
}
