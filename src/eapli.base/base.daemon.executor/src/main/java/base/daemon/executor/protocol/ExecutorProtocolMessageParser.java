/*
 * Copyright (c) 2013-2020 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package base.daemon.executor.protocol;

import eapli.framework.util.Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The message parser for the Booking protocol.
 *
 * @author Paulo Gandra Sousa 01/06/2020
 */
@Utility
public class ExecutorProtocolMessageParser {

    private static final Logger LOGGER = LogManager.getLogger(ExecutorProtocolMessageParser.class);
    private static final int TAREFA_AUTOMATICA = 9;

    private ExecutorProtocolMessageParser() {
        // avoid instantiation
    }

    /**
     * Parse and build the request.
     *
     * @param inputLine
     * @return
     */
    public static ExecutorProtocolRequest parse(final String inputLine, final int codigo) {
        ExecutorProtocolRequest request = new UnknownRequest(inputLine);

        if (TAREFA_AUTOMATICA == codigo) { //verifica o codigo
            request = TarefaAutomatica(inputLine);
        }else {
            request = new ErrorInRequest(inputLine, "Codigo errado");
        }
        return request;
    }

    private static ExecutorProtocolRequest TarefaAutomatica(final String inputLine) {
        /*if (tokens.length != 4) {
            request = new ErrorInRequest(inputLine, "Wrong number of parameters");
        } else if (isStringParam(tokens[1])) {
            request = new ErrorInRequest(inputLine, "meal id must not be inside quotes");
        } else if (!isStringParam(tokens[2])) {
            request = new ErrorInRequest(inputLine, "user id must be inside quotes");
        } else {*/
        ExecutorProtocolRequest request = new ExecutorTarefaAutomatica(inputLine);
        //}
        return request;
    }

    /*private static boolean isStringParam(final String string) {
        return string.length() >= 2 && string.charAt(0) == '"' && string.charAt(string.length() - 1) == '"';
    }*/
}
