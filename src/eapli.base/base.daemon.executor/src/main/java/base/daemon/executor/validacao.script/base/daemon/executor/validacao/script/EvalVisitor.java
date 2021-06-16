package base.daemon.executor.validacao.script.base.daemon.executor.validacao.script;

import base.daemon.executor.validacao.script.ValidaScriptBaseVisitor;
import base.daemon.executor.validacao.script.ValidaScriptLexer;
import base.daemon.executor.validacao.script.ValidaScriptParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class EvalVisitor extends ValidaScriptBaseVisitor {

    private int code;

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
    public Object visitInfoProduto(ValidaScriptParser.InfoProdutoContext ctx) {

        if(code==Integer.parseInt(ctx.codigo.getText())){
            System.out.println("Codigo: "+ctx.codigo.getText());
            System.out.println("Preco: "+ctx.preco.getText());
            System.out.println("Categoria: "+ctx.categoria.getText());
        }
        return visitChildren(ctx);
    }

    @Override
    public Object visitInfoCliente(ValidaScriptParser.InfoClienteContext ctx) {
        if(code==Integer.parseInt(ctx.numero.getText())){
            System.out.println(ctx.numero.getText());
            System.out.println(ctx.escalao.getText());
        }
        return visitChildren(ctx);
    }
    /*
    @Override
    public Object visitInfoCliente(LabeledExpParser.InfoClienteContext ctx) {
        return visitChildren(ctx);
    }*/

    @Override
    public Integer visitLerFicheiro(ValidaScriptParser.LerFicheiroContext ctx) {
        FileInputStream fis;

        try {
            fis = new FileInputStream(new File("testeProdutos.xml"));
            ValidaScriptLexer lexer = new ValidaScriptLexer(new ANTLRInputStream(fis));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            ValidaScriptParser parser = new ValidaScriptParser(tokens);
            ParseTree tree = parser.progFile();
            EvalVisitor eval = new EvalVisitor();
            eval.setCode(Integer.parseInt(ctx.possivel_id.getText()));
            eval.visit(tree);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private void setCode(int code){
        this.code= code;
    }

}
