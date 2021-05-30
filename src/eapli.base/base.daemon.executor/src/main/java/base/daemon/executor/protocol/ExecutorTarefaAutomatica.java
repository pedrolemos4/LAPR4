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

import eapli.base.atividades.domain.Script;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;


public class ExecutorTarefaAutomatica extends ExecutorProtocolRequest {

    public ExecutorTarefaAutomatica(final String request) {
        super(request);
    }

    @Override
    public String execute() {
       // execution
        try {
            executarScript(request);
            //System.out.println("Executar o script");
        } catch (final Exception e) {
            System.out.println("Erro");
            return buildServerError(e.getMessage());
        }

        return "Sucesso";
    }

    private void executarScript(final String input) throws FileNotFoundException {
        //Scanner ler = new Scanner(new File(input));
        //ler.nextLine();
        //executa o script
        System.out.println("A executar o script");
    }

}
