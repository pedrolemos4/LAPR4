package base.daemon.motor.algorithms;

import eapli.base.atividade.domain.Atividade;

import java.util.*;

public class FirstComeFirstServeExecutor implements Runnable {

    private List<String> list;

    private Atividade atividade;

    private Map<String, List<Atividade>> mapExecutor;

    private Map<Integer, String> mapAPreencher;

    public FirstComeFirstServeExecutor(List<String> listServidores, Atividade atividade, Map<String, List<Atividade>> mapExecutor) {
        this.list = listServidores;
        this.atividade = atividade;
        this.mapExecutor = mapExecutor;
        this.mapAPreencher = new TreeMap<>();
    }

    public synchronized void getListAtividadesDoExecutor(String ipExecutor){
        for(Map.Entry<String, List<Atividade>> map: mapExecutor.entrySet()){
            if(map.getKey().equalsIgnoreCase(ipExecutor)){
                mapAPreencher.put(map.getValue().size(),map.getKey());
            }
        }
    }

    @Override
    public void run() {
        String[] threadName = Thread.currentThread().getName().split("-");
        int index = Integer.parseInt(threadName[1].replaceAll("\\s+", ""));
        String ipExecutor = list.get(index);
        try {
            // isto retorna a quantidade de tarefas de cada executor
            getListAtividadesDoExecutor(ipExecutor);
            // problema é que nao posso adicionar logo uma tarefa sem percorrer todas as threads
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

     public String getExecutorEscolhido() {
        Map.Entry<Integer, String> entry = mapAPreencher.entrySet().iterator().next();
        return entry.getValue();
    }

    public void createThreads() {
        Thread[] threads = new Thread[list.size()];
        for (int i = 0; i < list.size(); i++) {
            threads[i] = new Thread(this, "Thread -" + i + " do fcfs");
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
