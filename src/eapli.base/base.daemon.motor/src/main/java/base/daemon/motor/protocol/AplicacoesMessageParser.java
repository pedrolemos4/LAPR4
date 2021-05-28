package base.daemon.motor.protocol;

import eapli.base.atividades.application.AplicacoesController;
import eapli.framework.csv.util.CsvLineMarshaler;
import eapli.framework.util.Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;

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

    /* package */
    public static void injectController(final AplicacoesController controller) {
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
        //String[] tokens;
        try {
            if (3 == id) {//.equals(tokens[1])){
                request = parseControlFluxo(inputLine);
            } else if ("4".equals(tokens[1])) {
                request = parseGetFluxo(inputLine, tokens);
            } else if ("5".equals(tokens[1])) {
                request = parseGetNumeroTarefasPendentes(inputLine, tokens);
            }
        } catch (final ParseException e) {
            LOGGER.info("Unable to parse request: {}", inputLine);
            request = new ErrorInRequest(inputLine, "Unable to parse request");
        }

        return request;
    }

    private static AplicacoesRequest parseControlFluxo(String inputLine) {
        AplicacoesRequest request;
        int numberOfData = Integer.parseInt(tokens[2]);
        if (numberOfData != 0) {
            if (tokens.length != 4) {
                request = new ErrorInRequest(inputLine, "Wrong number of parameters");
            } else {
                request = new FluxoRequest(getController(), inputLine, CsvLineMarshaler.unquote(tokens[3]));
            }
        } else {
            request = new ErrorInRequest(inputLine, "Wrong number of parameters");
        }
        return request;
    }

    private static AplicacoesRequest parseGetNumeroTarefasPendentes(String inputLine, String[] tokens) {
        AplicacoesRequest request;
        int numberOfData = Integer.parseInt(tokens[2]);
        if (numberOfData != 0) {
            String[] array = tokens[3].split(" ");
            if (tokens.length != 3) {
                request = new ErrorInRequest(inputLine, "Wrong number of parameters");
            } else if (isStringParam(array[0])) {
                request = new ErrorInRequest(inputLine, "hours must not be inside quotes");
            } else if (isStringParam(array[1])) {
                request = new ErrorInRequest(inputLine, "user id must be inside quotes");
            } else {
                request = new NumeroTarefasPendentesRequest(getController(), inputLine, CsvLineMarshaler.unquote(tokens[1]),
                        CsvLineMarshaler.unquote(tokens[2]));
            }
            return request;
        } else {
            request = new ErrorInRequest(inputLine, "Wrong number of parameters");
        }
        return request;
    }

    private static AplicacoesRequest parseGetFluxo(final String inputLine, final String[] tokens) {
        AplicacoesRequest request;
        int numberOfData = Integer.parseInt(tokens[2]);
        if (numberOfData != 0) {
            String[] array = tokens[3].split(" ");
            if (tokens.length != 3) {
                request = new ErrorInRequest(inputLine, "Wrong number of parameters");
            } else if (isStringParam(array[0])) {
                request = new ErrorInRequest(inputLine, "servico id must not be inside quotes");
            } else if (isStringParam(array[1])) {
                request = new ErrorInRequest(inputLine, "user id must be inside quotes");
            } else {
                request = new FluxoRequest(getController(), inputLine, CsvLineMarshaler.unquote(tokens[1]),
                        CsvLineMarshaler.unquote(tokens[2]));
            }
            return request;
        } else {
            request = new ErrorInRequest(inputLine, "Wrong number of parameters");
        }
        return request;
    }

    // talvez dê porcaria porque o id do servico pode ser apenas um numero [0-9]
    private static boolean isStringParam(final String string) {
        return string.length() >= 2 && string.charAt(0) == '"' && string.charAt(string.length() - 1) == '"';
    }

}
