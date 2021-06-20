package base.daemon.executor.protocol;

import base.daemon.executor.validacao.script.base.daemon.executor.validacao.script.MainValidaScript;
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
        String[] caminho = request.split("/");
        String[] variaveis = caminho[0].split(";");
        //File fileScript = new File(caminho[1]);
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
        System.out.println("FORM\n"+form);
        File f = new File(caminho[1]);
        //String caminhoFinal = f.getAbsolutePath();
        //ValidaScript vs = new ValidaScript();
        // boolean checkScript = vs.validaScript(fileScript);
        // if (checkScript) {
        try {
            executarScript(f, quantidade, form);
        } catch (final IOException e) {
            System.out.println(e.getMessage());
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

    private void executarScript(File script, String quantidade, String form) throws IOException {
        String[] args = new String[2];
        args[0] = quantidade;
        args[1] = form;
        MainValidaScript main = new MainValidaScript();
        main.main(args, script);
        //Scanner ler = new Scanner(new File(input));
        //ler.nextLine();
        //executa o script
        //String[] cmd = {"sh", script.getName(), script.getPath()};
        //Runtime.getRuntime().exec(cmd);
        //LOGGER.info("A executar o script...");
    }

}
