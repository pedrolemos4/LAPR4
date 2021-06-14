package base.daemon.executor.validacao.script.base.daemon.executor.validacao.script;

import base.daemon.executor.validacao.script.base.daemon.executor.validacao.script.ValidaLerFicheiro.MainLerFicheiro;

import java.io.IOException;

public class EvalVisitorScript extends ValidaScriptBaseVisitor {

    private String args;

    public EvalVisitorScript(String args) {
        this.args = args;
    }

    @Override
    public Object visitStart(ValidaScriptParser.StartContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitScript(ValidaScriptParser.ScriptContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitInstrucao(ValidaScriptParser.InstrucaoContext ctx) {
        return visitChildren(ctx);
    }

    /*@Override
    public Object visitLerFicheiro(LabeledExpParser.LerFicheiroContext ctx) {
        return visitChildren(ctx);
    }*/

    @Override
    public Object visitInteiro(ValidaScriptParser.InteiroContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitFicheiro(ValidaScriptParser.FicheiroContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitPath(ValidaScriptParser.PathContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitLerFicheiro(ValidaScriptParser.LerFicheiroContext ctx) {
        //System.out.println("Identificador encontrado, a consultar o ficheiro...");
        final MainLerFicheiro mainLerFicheiro = new MainLerFicheiro();
        try {
            String[] file = new String[2];
            file[0] = ctx.possivel_id.getText();
            file[1] = ctx.ficheiro_script.getText();
            mainLerFicheiro.lerFicheiro(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 1;
    }

}
