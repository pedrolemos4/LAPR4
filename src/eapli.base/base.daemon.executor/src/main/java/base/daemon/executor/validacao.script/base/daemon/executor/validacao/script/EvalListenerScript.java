package base.daemon.executor.validacao.script.base.daemon.executor.validacao.script;

public class EvalListenerScript {

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
        System.out.println("teste");
    }

    public void exitLerFicheiro(ValidaScriptParser.LerFicheiroContext ctx) {
        System.out.println("teste");
    }
}
