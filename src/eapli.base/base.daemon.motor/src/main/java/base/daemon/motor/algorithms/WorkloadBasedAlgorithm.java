package base.daemon.motor.algorithms;

import eapli.base.atividade.domain.Atividade;

import java.util.*;

public class WorkloadBasedAlgorithm implements Runnable {

    private List<String> list;

    private Atividade atividade;

    private Map<String, Integer> mapExecutor;

    private Map<Integer, String> sortedMap = new TreeMap<>();


    public WorkloadBasedAlgorithm(List<String> listServidores, Atividade atividade, Map<String, Integer> mapExecutor) {
        this.list = listServidores;
        this.atividade = atividade;
        this.mapExecutor = mapExecutor;
    }

    public synchronized void getListAtividadesDoExecutor(String ipExecutor) {
        for (Map.Entry<String, Integer> map : mapExecutor.entrySet()) {
            if (map.getKey().equalsIgnoreCase(ipExecutor)) {
                sortedMap.put(map.getValue(), map.getKey());
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
        Map.Entry<Integer, String> entry = sortedMap.entrySet().iterator().next();
        System.out.println("Executor com menor workload: " + entry.getValue() + " Workload: " + entry.getKey());
        return entry.getValue();
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
}

