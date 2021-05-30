package base.daemon.motor.protocol;

import eapli.base.atividades.application.AplicacoesController;
import eapli.framework.csv.util.CsvLineMarshaler;
import eapli.framework.util.Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Utility
public class AplicacoesMessageParser {
    // obtem o estado do server e estatisticas
    private static final Logger LOGGER = LogManager.getLogger(AplicacoesMessageParser.class);

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
        }

        return request;
    }

    private static AplicacoesRequest parseControlFluxo(String inputLine) {
        AplicacoesRequest request;
        /*int numberOfData = Integer.parseInt(tokens[2]);
        if (numberOfData != 0) {
            if (tokens.length != 4) {
                request = new ErrorInRequest(inputLine, "Wrong number of parameters");
            } else {
                request = new EstadoFluxoRequest(getController(), inputLine, CsvLineMarshaler.unquote(tokens[3]));
            }
            } else {*/
        request = new FluxoRequest(getController(), inputLine);
            /*}
        } else {
            request = new ErrorInRequest(inputLine, "Wrong number of parameters");
        }*/
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
