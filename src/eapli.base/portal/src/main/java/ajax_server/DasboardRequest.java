package ajax_server;

import base.daemon.motor.protocol.AplicacoesRequest;
import eapli.base.atividade.application.AplicacoesController;
import eapli.base.atividade.application.ConsultarTarefasController;
import eapli.base.atividade.domain.Atividade;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DasboardRequest extends AplicacoesRequest {

    private ConsultarTarefasController controller = new ConsultarTarefasController();

    protected DasboardRequest(AplicacoesController controller, String inputRequest) {
        super(controller, inputRequest);
    }

    @Override
    public byte[] execute() {
        List<Atividade> requestList = controller.tarefasPendentes(controller.getUser());
        int num = requestList.size();
        int overDLine = 0;
        int almostDLine = 0;
        int high = 0, low = 0, med = 0;
        int crit1 = 0, crit2 = 0, crit3 = 0, crit4 = 0, crit5 = 0;
        Date currentDate = Calendar.getInstance().getTime();
        StringBuilder data = new StringBuilder();
        data.append(num).append("-").append(overDLine).append("-").append(almostDLine).append("-")
                .append(high).append("-").append(med).append("-").append(low).append("-").append(crit1).append("-")
                .append(crit2).append("-").append(crit3).append("-").append(crit4).append("-").append(crit5);

        return buildResponse(data.toString());
    }

    private byte[] buildResponse(String data) {
        byte[] message = new byte[258];
        message[1] = 9;

        byte[] convertedData = data.getBytes();

        message[2] = (byte) convertedData.length;

        System.arraycopy(convertedData, 0, message, 3, convertedData.length);

        return message;
    }

}
