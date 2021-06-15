package base.daemon.executor.validacao.script.base.daemon.executor.validacao.script;

import base.daemon.executor.validacao.script.base.daemon.executor.validacao.script.ValidaLerFicheiro.MainLerFicheiro;

import java.io.IOException;
import java.util.Stack;

public class EvalListenerScript extends ValidaScriptBaseListener {

    private final Stack<Integer> stack = new Stack<>();

    public int getResult() {
        return stack.peek();
    }

    public void enterStart(ValidaScriptParser.StartContext ctx) { //mudar os contexts em todos
        System.out.println("teste");
    }

    public void exitStart(ValidaScriptParser.StartContext ctx) {
        System.out.println("teste");
    }

    public void enterScript(ValidaScriptParser.ScriptContext ctx) { //mudar os contexts em todos
        System.out.println("teste");
    }

    public void exitScript(ValidaScriptParser.ScriptContext ctx) {
        System.out.println("teste");
    }

    public void enterInstrucao(ValidaScriptParser.InstrucaoContext ctx) { //mudar os contexts em todos
        System.out.println("teste");
    }

    public void exitInstrucao(ValidaScriptParser.InstrucaoContext ctx) {
        System.out.println("teste");
    }

    public void enterFicheiro(ValidaScriptParser.FicheiroContext ctx) {
        System.out.println("teste");
    }

    public void exitFicheiro(ValidaScriptParser.FicheiroContext ctx) {
        System.out.println("teste");
    }

    public void enterPath(ValidaScriptParser.PathContext ctx) {
        System.out.println("teste");
    }

    public void exitPath(ValidaScriptParser.PathContext ctx) {
        System.out.println("teste");
    }

    public void enterLerFicheiro(ValidaScriptParser.LerFicheiroContext ctx) {
        stack.push(Integer.valueOf(ctx.possivel_id.getText()));
    }

    public void exitLerFicheiro(ValidaScriptParser.LerFicheiroContext ctx) {
        final MainLerFicheiro mainLerFicheiro = new MainLerFicheiro();
        String possivelId = Integer.toString(stack.pop());
        try {
            String[] file = new String[2];
            file[0] = possivelId;
            file[1] = ctx.ficheiro_script.getText();
            mainLerFicheiro.lerFicheiro(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stack.push(1);
    }
}
