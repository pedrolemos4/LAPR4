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
        try {
            servico = CodigoUnico.valueOf(request.trim());
        } catch (final NumberFormatException e) {
            return buildBadRequest("Invalid servico id").getBytes();
        }

        // execution
        try {
            final EstadoFluxo token = controller.getEstadoFluxoDoServico(servico);
            // response
            return buildResponse(token);
        } catch (final IllegalArgumentException e) {
            return buildBadRequest("Unknown servico id").getBytes();
        } catch (final Exception e) {
            // we should be careful about exposing the Exception to the outside!
            return buildServerError(e.getMessage()).getBytes();
        }
    }

    private byte[] buildResponse(final EstadoFluxo token) {
        byte[] data = new byte[258];
        data[0] = 0;
        data[1] = 1;
        byte[] idArray = token.toString().getBytes();//pedido.servico().identity().toString().getBytes();
        data[2] = (byte) idArray.length;
        for (int i = 0; i < idArray.length; i++) {
            data[i + 2] = idArray[i];
        }
        return data;
    }

}
