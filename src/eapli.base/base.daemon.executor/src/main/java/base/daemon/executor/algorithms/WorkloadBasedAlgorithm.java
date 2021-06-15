package base.daemon.executor.algorithms;

import base.daemon.executor.presentation.ExecutorServer;
import eapli.base.atividade.domain.Atividade;

import java.util.*;

public class WorkloadBasedAlgorithm implements Runnable {

    private static final Queue<ExecutorServer> instances = new LinkedList<>();
    private static final Map<ExecutorServer, Double> mapExecutores = new HashMap<>();
    private Atividade at;

    public WorkloadBasedAlgorithm(Atividade at) {
        this.at = at;
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

                Map.Entry<ExecutorServer, Double> entry = mapExecutores.entrySet().iterator().next();
                System.out.println("Executor com menor workload: " + entry.getKey().toString() + " Com workload de: " + entry.getValue());  //instancia com menor workload
            }
        }
    }

    public static boolean addInstance(ExecutorServer executorServer) {
        return instances.add(executorServer);
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

