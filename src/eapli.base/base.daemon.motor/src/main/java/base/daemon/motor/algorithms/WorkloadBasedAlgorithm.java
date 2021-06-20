package base.daemon.motor.algorithms;

import eapli.base.atividade.domain.Atividade;

import java.util.*;

public class WorkloadBasedAlgorithm implements Runnable {

    private List<String> list;

    private Atividade atividade;

    private Map<String, Integer> mapExecutor;


    public WorkloadBasedAlgorithm(List<String> listServidores, Atividade atividade, Map<String, Integer> mapExecutor) {
        this.list = listServidores;
        this.atividade = atividade;
        this.mapExecutor = mapExecutor;
    }

    public synchronized void getListAtividadesDoExecutor(String ipExecutor) {
        for (Map.Entry<String, Integer> map : mapExecutor.entrySet()) {
            if (map.getKey().equalsIgnoreCase(ipExecutor)) {
                System.out.println("Executor: " + map.getKey() + " Workload: " + map.getValue());
            }
        }
    }

    public void run() {
        synchronized (this) {
            String[] threadName = Thread.currentThread().getName().split("-");
            int index = Integer.parseInt(threadName[1].replaceAll("\\s+", ""));
            String ipExecutor = list.get(index);
            try {
                getListAtividadesDoExecutor(ipExecutor);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String getExecutorEscolhido() {
        entriesSortedByValues(mapExecutor);
        Map.Entry<String, Integer> entry = mapExecutor.entrySet().iterator().next();
        System.out.println("Executor com menor workload: " + entry.getKey() + " Workload: " + entry.getValue());
        return entry.getKey();
    }

    public void createThreads() {
        Thread[] threads = new Thread[list.size()];
        for (int i = 0; i < list.size(); i++) {
            threads[i] = new Thread(this, "Thread -" + i + "- do workloadAlgorithm");
            threads[i].start();
        }
        for (Thread t : threads) {
            t.interrupt();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
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

