package base.daemon.motor.protocol;

import eapli.base.pedido.application.SolicitarServicoController;
import eapli.framework.csv.util.CsvLineMarshaler;
import eapli.framework.util.Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;

@Utility
public class ServicosRhMessageParser {
    // obtem o estado do server
    private static final Logger LOGGER = LogManager.getLogger(ServicosRhMessageParser.class);

    private static SolicitarServicoController controller;

    private ServicosRhMessageParser() {
        // avoid instantiation
    }

    /**
     * To inject a different controller for testing purposes.
     *
     * @param controller
     */

    /* package */public static void injectController(final SolicitarServicoController controller) {
        synchronized (lock) {
            ServicosRhMessageParser.controller = controller;
        }
    }

    private static final Object lock = new Object();

    private static SolicitarServicoController getController() {
        synchronized (lock) {
            if (ServicosRhMessageParser.controller != null) {
                return ServicosRhMessageParser.controller;
            }
        }
        return new SolicitarServicoController();
    }

    /**
     * Parse and build the request.
     *
     * @param inputLine
     * @return
     */
    public static ServicosRhRequest parse(final String inputLine) {
        // as a fallback make sure we return unknown
        ServicosRhRequest request = new UnknownRequest(inputLine);

        // parse to determine which type of request and if it is sintactally valid
        String[] tokens;
        try {
            tokens = CsvLineMarshaler.tokenize(inputLine).toArray(new String[0]);
            if ("GET_AVAILABLE_MEALS".equals(tokens[0])) {
                //request = parseGetAvailableMeals(inputLine, tokens);
            } else if ("4".equals(tokens[1])) {
                request = parseGetFluxo(inputLine, tokens);
            }
        } catch (final ParseException e) {
            LOGGER.info("Unable to parse request: {}", inputLine);
            request = new ErrorInRequest(inputLine, "Unable to parse request");
        }

        return request;
    }

    private static ServicosRhRequest parseGetFluxo(final String inputLine, final String[] tokens) {
        ServicosRhRequest request;
        int numberOfData = Integer.parseInt(tokens[2]);
        if(numberOfData != 0) {
            String[] array = tokens[4].split(" ");
            if (tokens.length != 4) {
                request = new ErrorInRequest(inputLine, "Wrong number of parameters");
            } else if(isStringParam(array[0])){
                request = new ErrorInRequest(inputLine, "servico id must not be inside quotes");
            } else if(isStringParam(array[1])){
                request = new ErrorInRequest(inputLine, "user id must be inside quotes");
            } else {
                request = new FluxoRequest(getController(), inputLine, CsvLineMarshaler.unquote(tokens[1]),
                        CsvLineMarshaler.unquote(tokens[2]));
            }
            return request;
        } else{
            request = new ErrorInRequest(inputLine, "Wrong number of parameters");
        }
        /*if (tokens.length != 4) {
            request = new ErrorInRequest(inputLine, "Wrong number of parameters");
        } else if (isStringParam(tokens[1])) {
            request = new ErrorInRequest(inputLine, "servico id must not be inside quotes");
        } else if (!isStringParam(tokens[2])) {
            request = new ErrorInRequest(inputLine, "username must be inside quotes");
        } else {
            request = new FluxoRequest(getController(), inputLine, CsvLineMarshaler.unquote(tokens[1]),
                    CsvLineMarshaler.unquote(tokens[2]));
        }*/
        return request;
    }

    // talvez dê porcaria porque o id do servico pode ser apenas um numero [0-9]
    private static boolean isStringParam(final String string) {
        return string.length() >= 2 && string.charAt(0) == '"' && string.charAt(string.length() - 1) == '"';
    }

}
