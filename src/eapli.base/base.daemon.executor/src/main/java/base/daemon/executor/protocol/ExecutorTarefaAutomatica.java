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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.channels.FileChannel;


public class ExecutorTarefaAutomatica extends ExecutorProtocolRequest {

    private static final Logger LOGGER = LogManager.getLogger(ExecutorTarefaAutomatica.class);

    public ExecutorTarefaAutomatica(final String request) {
        super(request);
    }

    @Override
    public byte[] execute() {
        File fileScript = new File(request);
        //ValidaScript vs = new ValidaScript();
        // boolean checkScript = vs.validaScript(fileScript);
        // if (checkScript) {
        try {
            executarScript(fileScript);
        } catch (final Exception e) {
            LOGGER.info("Erro");
            //return buildServerError(e.getMessage());
        }
        //} else {
        //   System.out.println("Script inválido. Não será executado.");
        // }
        byte[] retorno = new byte[3];
        retorno[0] = 1;
        retorno[1] = 1;
        retorno[2] = 0;

        return retorno;
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
        LOGGER.info("Script guardado para posterior execução");
    }

    private void executarScript(final File script) throws IOException {
        //String [] args = new String[2];
        //args[0]="DESCOBRIR";   //Descobrir qual o id (produto ou cliente) devo enviar
        //args[1]=script.getPath();

        //MainValidaScript valida = new MainValidaScript();
        //valida.main(script.getPath());
        
        //Scanner ler = new Scanner(new File(input));
        //ler.nextLine();
        //executa o script
        String[] cmd = {"sh", script.getName(), script.getPath()};
        Runtime.getRuntime().exec(cmd);
        LOGGER.info("A executar o script...");
    }

}
