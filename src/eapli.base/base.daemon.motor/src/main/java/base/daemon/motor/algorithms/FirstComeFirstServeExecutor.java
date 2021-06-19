package base.daemon.motor.algorithms;

import eapli.base.atividade.domain.Atividade;

import java.util.*;
import java.util.Map.Entry;

public class FirstComeFirstServeExecutor implements Runnable {

    private List<String> list;

    private Atividade atividade;

    private Map<String, List<Atividade>> mapExecutor;

    public FirstComeFirstServeExecutor(List<String> listServidores, Atividade atividade) {
        this.list = listServidores;
        this.atividade = atividade;
        this.mapExecutor = new TreeMap<>();
    }

    public synchronized void addTarefa(Atividade tarefa, String ipExecutor) throws Exception {
        mapExecutor.get(ipExecutor).add(tarefa);
    }

    public int getListAtividadesDoExecutor(String ipExecutor){
        int quantidadeTarefas = 0;
        for(Map.Entry<String, List<Atividade>> map: mapExecutor.entrySet()){
            if(map.getKey().equalsIgnoreCase(ipExecutor)){
                quantidadeTarefas = map.getValue().size();
            }
        }
        return quantidadeTarefas;
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
            addTarefa(this.atividade, ipExecutor);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

     public String getExecutorEscolhido() {
        Entry<String, List<Atividade>> entry = mapExecutor.entrySet().iterator().next();
        return entry.getKey();
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
