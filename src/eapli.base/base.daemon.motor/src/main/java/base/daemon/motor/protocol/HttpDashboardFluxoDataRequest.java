package base.daemon.motor.protocol;

import eapli.base.atividade.application.AplicacoesController;
import eapli.base.servico.domain.Servico;

public class HttpDashboardFluxoDataRequest extends AplicacoesRequest {

    private AplicacoesController ctrl = new AplicacoesController();

    public HttpDashboardFluxoDataRequest(final AplicacoesController controller, final String request) {
        super(controller, request);
    }

    @Override
    public byte[] execute() {
        Iterable<Servico> serList = ctrl.getServicos();
        StringBuilder data = new StringBuilder();
        for (Servico ser : serList) {
            data.append("Servico: ").append(ser.identity()).append(" Estado Fluxo: ").append(ctrl.getEstadoFluxoDoServico(ser.identity()).toString()).append("\n");
        }

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