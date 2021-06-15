package base.daemon.motor.algorithms;

import eapli.base.atividade.application.AplicacoesController;
import eapli.base.atividade.domain.Atividade;
import eapli.base.colaborador.domain.Colaborador;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class FirstComeFirstServeAlgorithm implements Runnable {

    private Colaborador colaborador;

    private Atividade atividade;

    private String idPedido;

    private static Map<Calendar, Colaborador> map;

    public FirstComeFirstServeAlgorithm(Colaborador colaborador, Atividade atividade, Map<Calendar, Colaborador> map,String idPedido) {
        this.colaborador = colaborador;
        this.atividade = atividade;
        this.map = map;
        this.idPedido = idPedido;
    }

    public static synchronized void addCol(Colaborador col) throws Exception {
        //map.put();
    }

    public static synchronized int time(Colaborador col,String idPedido) throws Exception{
        AplicacoesController controller = new AplicacoesController();
        List<Calendar> list = controller.findDatas(col.identity(),idPedido);
        return 1;
    }

    @Override
    public void run() {
        try {
            time(this.colaborador,this.idPedido);
            addCol(this.colaborador);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
