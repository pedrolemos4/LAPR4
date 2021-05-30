package base.daemon.motor.protocol;

import eapli.base.atividades.application.AplicacoesController;
import eapli.base.atividades.domain.EstadoFluxo;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.equipa.domain.CodigoUnico;

public class EstadoFluxoRequest extends AplicacoesRequest {

    public EstadoFluxoRequest(final AplicacoesController controller, final String request) {
        super(controller, request);
    }

    @Override
    public String execute() {
        // semantic validation
        CodigoUnico servico;
        try {
            servico = CodigoUnico.valueOf(request.trim());
        } catch (final NumberFormatException e) {
            return buildBadRequest("Invalid servico id");
        }

        // execution
        try {
            final EstadoFluxo token = controller.getEstadoFluxoDoServico(servico);
            // response
            return buildResponse(token);
        } catch (final IllegalArgumentException e) {
            return buildBadRequest("Unknown servico id");
        } catch (final Exception e) {
            // we should be careful about exposing the Exception to the outside!
            return buildServerError(e.getMessage());
        }
    }

    private String buildResponse(final EstadoFluxo token) {
        return "Estado do Fluxo, \"" + token + "\"\n";
    }

}
