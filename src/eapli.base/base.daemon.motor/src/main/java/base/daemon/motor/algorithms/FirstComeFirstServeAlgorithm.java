package base.daemon.motor.algorithms;

import eapli.base.atividade.application.AplicacoesController;
import eapli.base.atividade.domain.Atividade;
import eapli.base.colaborador.domain.Colaborador;

import java.util.*;

public class FirstComeFirstServeAlgorithm implements Runnable {

    private List<Colaborador> list;

    private Atividade atividade;

    private String idPedido;

    private  Map<Long, Colaborador> mapColaboradores;

    private static int incrementoColaboradores=0;


    public FirstComeFirstServeAlgorithm(List<Colaborador> list, Atividade atividade,String idPedido) {
        this.list = list;
        this.atividade = atividade;
        this.idPedido = idPedido;
        this.mapColaboradores = new TreeMap<>(Collections.reverseOrder());
    }

    public synchronized void addCol(long tempo,Colaborador col) throws Exception {
        mapColaboradores.put(tempo,col);
    }

    public static long time(Colaborador col,String idPedido) throws Exception{
        AplicacoesController controller = new AplicacoesController();
        List<Calendar> list = controller.findDatas(col.identity(),idPedido);
        long maior = 0;
        for(Calendar calendar : list){
            long diferenca = Calendar.getInstance().getTime().getTime() - calendar.getTime().getTime();
            if(diferenca > maior){
                maior = diferenca;
            }
        }
        return maior;
    }

    @Override
    public void run() {
        synchronized (this){
            Colaborador colab = list.get(incrementoColaboradores);
            getIncrement();
            try {
                long tempo = time(colab,this.idPedido);
                addCol(tempo,colab);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private synchronized void getIncrement(){
        incrementoColaboradores++;
    }

    public  Colaborador getColaboradorEscolhido(){
        Map.Entry<Long, Colaborador> entry = mapColaboradores.entrySet().iterator().next();
        return entry.getValue();
    }

    public void createThreads() {
        Thread[] threads = new Thread[list.size()];
        for (int i = 0; i < list.size(); i++) {
            threads[i] = new Thread(this, "Thread" + i + " do fcfs");
            threads[i].start();
        }
        for(Thread t : threads){
            t.interrupt();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
