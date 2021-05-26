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

import base.daemon.executor.application.ExecutorTarefaAutomaticaController;
import eapli.base.atividades.domain.Script;

/**
 *
 * @author Paulo Gandra Sousa 01/06/2020
 *
 */
public class ExecutorTarefaAutomatica extends ExecutorProtocolRequest {

    private final String tarefaAutomaticaId;

    public ExecutorTarefaAutomatica(final ExecutorTarefaAutomaticaController controller, final String request, final String tarefaAutomaticaId) {
        super(controller, request);
        this.tarefaAutomaticaId = tarefaAutomaticaId;
    }

    @Override
    public String execute() {
        // semantic validation
        Long tarefaAutomaticaIdAux;
        try {
            tarefaAutomaticaIdAux = Long.valueOf(tarefaAutomaticaId);
        } catch (final NumberFormatException e) {
            return buildBadRequest("Invalid tarefa automatica id");
        }

        // execution
        try {
            final Script script = controller.getScriptTarefaAutomatica(tarefaAutomaticaIdAux);//verificar se existe
            //executar o script
            // response
            //return buildResponse(token);
        } catch (final IllegalArgumentException e) {
            return buildBadRequest("Unknown meal and/or user mec. number");
        } catch (final Exception e) {
            // we should be careful about exposing the Exception to the outside!
            return buildServerError(e.getMessage());
        }
        return null; //retirar
    }

    /*private String buildResponse(final BookingToken token) {
        return "BOOKED, \"" + token + "\"\n";
    }*/
}
