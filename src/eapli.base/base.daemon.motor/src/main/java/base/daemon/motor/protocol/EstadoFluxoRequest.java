package base.daemon.motor.protocol;

import eapli.base.atividades.application.AplicacoesController;
import eapli.base.atividades.domain.EstadoFluxo;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.equipa.domain.CodigoUnico;

public class EstadoFluxoRequest extends AplicacoesRequest {

    private final String servicoId;
    private final int userid;

    public EstadoFluxoRequest(final AplicacoesController controller, final String request, final String servicoId,
                              final String user) {
        super(controller, request);
        this.servicoId = servicoId;
        this.userid = Integer.parseInt(user);
    }


    @Override
    public String execute() {
        // semantic validation
        CodigoUnico servico;
        try {
            servico = CodigoUnico.valueOf(servicoId);
        } catch (final NumberFormatException e) {
            return buildBadRequest("Invalid servico id");
        }

        MecanographicNumber user;
        try {
            user = MecanographicNumber.valueOf(userid);
        } catch (final IllegalArgumentException e) {
            return buildBadRequest("Invalid user id");
        }

        // execution
        try {
            final EstadoFluxo token = controller.getEstadoFluxoDoServico(servico, user);
            // response
            return buildResponse(token);
        } catch (final IllegalArgumentException e) {
            return buildBadRequest("Unknown servico and/or user id");
        } catch (final Exception e) {
            // we should be careful about exposing the Exception to the outside!
            return buildServerError(e.getMessage());
        }
    }

    private String buildResponse(final EstadoFluxo token) {
        return "Estado do Fluxo, \"" + token + "\"\n";
    }

}
