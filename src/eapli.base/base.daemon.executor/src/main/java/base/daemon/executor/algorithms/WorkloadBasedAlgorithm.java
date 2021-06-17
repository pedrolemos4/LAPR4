package base.daemon.executor.algorithms;

import base.daemon.executor.ExecutorTarefaAutomaticaDaemon;
import base.daemon.executor.presentation.ExecutorServer;
import eapli.base.atividade.domain.Atividade;

import java.util.*;

public class WorkloadBasedAlgorithm implements Runnable {

    private static List<ExecutorServer> instances = new ArrayList<>();
    private static final Map<ExecutorServer, Integer> mapExecutores = new HashMap<>();
    private Atividade at;

    public WorkloadBasedAlgorithm(Atividade at, List<ExecutorServer> instances) {
        this.at = at;
        this.instances = instances;
    }

    public void run() {
        synchronized (this) {
            int i = 0;
            if (!instances.isEmpty()) {
                Thread[] threads = new Thread[instances.size()]; //talvez tenha de ser chamado noutro local

                for (ExecutorServer es : instances) {
                    WorkloadTimeCounter wtc = new WorkloadTimeCounter(mapExecutores, es);
                    threads[i] = new Thread(wtc);
                    threads[i].start();
                    i++;
                }

                for (Thread t : threads) {
                    t.interrupt();
                    try {
                        t.join();
                    } catch (InterruptedException e) {
                        System.out.println("Thread was interrupted!");
                    }
                }
                entriesSortedByValues(mapExecutores);

                Map.Entry<ExecutorServer, Integer> entry = mapExecutores.entrySet().iterator().next();
                System.out.println("Executor com menor workload: " + entry.getKey().toString() + " Com workload de: " + entry.getValue());  //instancia com menor workload
                entry.getKey().addTarefa(at);
            } else {
                System.out.println("Não tem instâncias do executor a correr!");
            }
        }
    }

    static <K, V extends Comparable<? super V>>
    SortedSet<Map.Entry<K, V>> entriesSortedByValues(Map<K, V> map) {
        SortedSet<Map.Entry<K, V>> sortedEntries = new TreeSet<>((e1, e2) -> {
            int res = e1.getValue().compareTo(e2.getValue());
            return res != 0 ? res : 1;
        }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }
}

