package base.daemon.motor.protocol;

import eapli.base.atividade.application.AplicacoesController;
import eapli.framework.util.Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Utility
public class AplicacoesMessageParser {

    private static AplicacoesController controller;

    private AplicacoesMessageParser() {
        // avoid instantiation
    }

    /**
     * To inject a different controller for testing purposes.
     *
     * @param controller
     */

    /* package */public static void injectController(final AplicacoesController controller) {
        synchronized (lock) {
            AplicacoesMessageParser.controller = controller;
        }
    }

    private static final Object lock = new Object();

    private static AplicacoesController getController() {
        synchronized (lock) {
            if (AplicacoesMessageParser.controller != null) {
                return AplicacoesMessageParser.controller;
            }
        }
        return new AplicacoesController();
    }

    /**
     * Parse and build the request.
     *
     * @param inputLine
     * @return
     */
    public static AplicacoesRequest parse(final String inputLine, final int id) {
        // as a fallback make sure we return unknown
        AplicacoesRequest request = new UnknownRequest(inputLine);

        // parse to determine which type of request and if it is sintactally valid
        if (3 == id) {
            request = parseControlFluxo(inputLine);
        } else if (4 == id) {
            request = parseGetFluxo(inputLine);
        } else if (5 == id) {
            request = parseGetNumeroTarefasPendentes(inputLine);
        }else{
            request = new ErrorInRequest(inputLine, "Codigo errado");
        }

        return request;
    }

    private static AplicacoesRequest parseControlFluxo(String inputLine) {
        AplicacoesRequest request;

        request = new FluxoRequest(getController(), inputLine);

        return request;
    }

    private static AplicacoesRequest parseGetNumeroTarefasPendentes(String inputLine) {
        AplicacoesRequest request;
        request = new NumeroTarefasPendentesRequest(getController(), inputLine);
        return request;
    }

    private static AplicacoesRequest parseGetFluxo(final String inputLine) {
        AplicacoesRequest request;
        request = new EstadoFluxoRequest(getController(), inputLine);
        return request;
    }


}
