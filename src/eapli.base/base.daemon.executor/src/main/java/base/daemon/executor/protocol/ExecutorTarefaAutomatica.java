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


import eapli.base.validacoes.validaScript.ValidaScript;

import java.io.*;
import java.nio.channels.FileChannel;


public class ExecutorTarefaAutomatica extends ExecutorProtocolRequest {

    public ExecutorTarefaAutomatica(final String request) {
        super(request);
    }

    @Override
    public String execute() {
        File fileScript = new File(request);
        ValidaScript vs = new ValidaScript();
        boolean checkScript = vs.validaScript(fileScript);
        if (checkScript) {
            try {
                executarScript(fileScript);
            } catch (final Exception e) {
                System.out.println("Erro");
                return buildServerError(e.getMessage());
            }
        } else {
            System.out.println("Script inválido. Não será executado.");
        }
        return "Sucesso";
    }

    private void guardarScript(final String input, final String output) throws IOException {
        File sourceFile = new File(input);
        File destFile = new File(output);
        if (!destFile.exists()) {
            destFile.createNewFile();
        }
        FileChannel source = new FileInputStream(input).getChannel();
        FileChannel destination = new FileOutputStream(output).getChannel();
        if (destination != null && source != null) {
            destination.transferFrom(source, 0, source.size());
            sourceFile.delete();
        }
        if (source != null) {
            source.close();
        }
        if (destination != null) {
            destination.close();
        }
        System.out.println("Script guardado para posterior execução");
    }

    private void executarScript(final File script) throws IOException {
        //Scanner ler = new Scanner(new File(input));
        //ler.nextLine();
        //executa o script
        String[] cmd = { "sh", script.getName(), script.getPath() };
        Runtime.getRuntime().exec(cmd);
        System.out.println("A executar o script...");
    }

}
