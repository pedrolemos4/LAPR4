package base.daemon.motor.protocol;

import eapli.base.atividade.application.AplicacoesController;
import eapli.base.atividade.domain.EstadoFluxo;
import eapli.base.equipa.domain.CodigoUnico;

public class EstadoFluxoRequest extends AplicacoesRequest {

    public EstadoFluxoRequest(final AplicacoesController controller, final String request) {
        super(controller, request);
    }

    @Override
    public byte[] execute() {
        // semantic validation
        CodigoUnico servico;
        servico = CodigoUnico.valueOf(request.trim());


        // execution
        try {
            final EstadoFluxo token = controller.getEstadoFluxoDoServico(servico);
            return buildResponse(token);
        } catch (NullPointerException n) {
            return buildBadResponse();
        }

    }

    private byte[] buildResponse(final EstadoFluxo token) {
        byte[] data = new byte[258];
        data[0] = 0;
        data[1] = 1;
        byte[] idArray = token.toString().getBytes();//pedido.servico().identity().toString().getBytes();
        data[2] = (byte) idArray.length;
        for (int i = 0; i < idArray.length; i++) {
            data[i] = idArray[i];
        }
        return data;
    }

    private byte[] buildBadResponse() {
        String resposta = "Não existem estados do fluxo neste momento!";
        byte[] data = new byte[258];
        data[0] = 0;
        data[1] = 1;
        byte[] idArray = resposta.getBytes();//pedido.servico().identity().toString().getBytes();
        data[2] = (byte) idArray.length;
        for (int i = 0; i < idArray.length; i++) {
            data[i] = idArray[i];
        }
        return data;
    }

}
