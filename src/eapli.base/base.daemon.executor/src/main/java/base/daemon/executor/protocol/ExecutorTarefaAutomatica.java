package base.daemon.executor.protocol;

import base.daemon.executor.validacao.script.base.daemon.executor.validacao.script.MainValidaScript;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;


public class ExecutorTarefaAutomatica extends ExecutorProtocolRequest {

    private static final Logger LOGGER = LogManager.getLogger(ExecutorTarefaAutomatica.class);

    public ExecutorTarefaAutomatica(final String request) {
        super(request);
    }

    @Override
    public byte[] execute() {
        String[] caminho = request.split("/");
        String[] variaveis = caminho[0].split(";");
        String quantidade = null;
        String form = null;
        for (String s : variaveis) {
            if (s.contains("Quantidade:")){// | s.contains("NUM")) {
                String[] split = s.split(":");
                quantidade = split[1];
            }else if (s.contains("Nome:")){// | s.contains("NUM")) {
                form = form.concat(s + " ");
            }else if (s.contains("TipoDesconto:")){// | s.contains("NUM")) {
                form = form.concat(s + " ");
            }else if (s.contains("PercentagemDesconto:")){// | s.contains("NUM")) {
                form = form.concat(s + " ");
            }else if (s.contains("Fatura:")){// | s.contains("NUM")) {
                form = form.concat(s + " ");
            }else if (s.contains("DataLimite:")){// | s.contains("NUM")) {
                form = form.concat(s + " ");
            }else if (s.contains("Fundamentacao:")){// | s.contains("NUM")) {
                form = form.concat(s + " ");
            }
        }
        File f = new File(caminho[1]);
        try {
            executarScript(f, quantidade, form);
        } catch (final IOException e) {
            System.out.println(e.getMessage());
            LOGGER.info("Erro");
        }
        byte[] retorno = new byte[3];
        retorno[0] = 1;
        retorno[1] = 1;
        retorno[2] = 0;

        return retorno;
    }


    private void executarScript(File script, String quantidade, String form) throws IOException {
        String[] args = new String[2];
        args[0] = quantidade;
        args[1] = form;
        MainValidaScript main = new MainValidaScript();
        main.main(args, script);
    }

}
