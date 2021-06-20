package base.daemon.motor.algorithms;

import eapli.base.atividade.application.AplicacoesController;
import eapli.base.atividade.domain.Atividade;
import eapli.base.colaborador.domain.Colaborador;

import java.util.*;

public class FirstComeFirstServeAlgorithm implements Runnable {

    private List<Colaborador> list;

    private Atividade atividade;

    private Map<Long, Colaborador> mapColaboradores;


    public FirstComeFirstServeAlgorithm(List<Colaborador> list, Atividade atividade) {
        this.list = list;
        this.atividade = atividade;
        this.mapColaboradores = new TreeMap<>(Collections.reverseOrder());
    }

    public synchronized void addCol(long tempo, Colaborador col) throws Exception {
        mapColaboradores.put(tempo, col);
    }

    public synchronized void time(Colaborador col) throws Exception {
        AplicacoesController controller = new AplicacoesController();
        List<Calendar> list = controller.findDatas(col.identity());
        long maior = Long.MAX_VALUE;
        if (list.isEmpty()) {
            maior = Long.MAX_VALUE;
        } else {
            for (Calendar calendar : list) {
                long diferenca = Calendar.getInstance().getTime().getTime() - calendar.getTime().getTime();
                if (diferenca < maior) {
                    maior = diferenca;
                }
            }
        }
        addCol(maior, col);
    }

    @Override
    public void run() {
        String[] threadName = Thread.currentThread().getName().split("-");
        int index = Integer.parseInt(threadName[1].replaceAll("\\s+", ""));
        Colaborador colab = list.get(index);
        try {
            time(colab);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Colaborador getColaboradorEscolhido() {
        Map.Entry<Long, Colaborador> entry = mapColaboradores.entrySet().iterator().next();
        return entry.getValue();
    }

    public void createThreads() {
        Thread[] threads = new Thread[list.size()];
        for (int i = 0; i < list.size(); i++) {
            threads[i] = new Thread(this, "Thread -" + i + "- do fcfs");
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
