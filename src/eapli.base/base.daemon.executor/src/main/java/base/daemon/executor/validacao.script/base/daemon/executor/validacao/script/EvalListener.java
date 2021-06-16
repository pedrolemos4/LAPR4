package base.daemon.executor.validacao.script.base.daemon.executor.validacao.script;

import base.daemon.executor.validacao.script.ValidaScriptBaseListener;
import base.daemon.executor.validacao.script.ValidaScriptLexer;
import base.daemon.executor.validacao.script.ValidaScriptParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Stack;

public class EvalListener extends ValidaScriptBaseListener {
    private int code;
    private final Stack<String> stack = new Stack<>();

    public String getResult() {
        return stack.peek();
    }

    public void enterStart(ValidaScriptParser.StartContext ctx) {

    }

    public void exitStart(ValidaScriptParser.StartContext ctx) {

    }

    public void enterScript(ValidaScriptParser.ScriptContext ctx) {

    }

    public void exitScript(ValidaScriptParser.ScriptContext ctx) {

    }

    public void enterInstrucao(ValidaScriptParser.InstrucaoContext ctx) {

    }

    public void exitInstrucao(ValidaScriptParser.InstrucaoContext ctx) {

    }

    public void enterFicheiro(ValidaScriptParser.FicheiroContext ctx) {

    }

    public void exitFicheiro(ValidaScriptParser.FicheiroContext ctx) {

    }

    public void enterPath(ValidaScriptParser.PathContext ctx) {

    }

    public void exitPath(ValidaScriptParser.PathContext ctx) {

    }

    public void enterLerFicheiro(ValidaScriptParser.LerFicheiroContext ctx) {
        stack.push(ctx.possivel_id.getText());
    }

    public void exitLerFicheiro(ValidaScriptParser.LerFicheiroContext ctx) {
        int code = Integer.parseInt(stack.pop());
        FileInputStream fis;

        try {
            fis = new FileInputStream("testeProdutos.xml");
            ValidaScriptLexer lexer = new ValidaScriptLexer(new ANTLRInputStream(fis));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            ValidaScriptParser parser = new ValidaScriptParser(tokens);
            ParseTree tree = parser.progFile();
            ParseTreeWalker walker = new ParseTreeWalker();
            EvalListener listener = new EvalListener();
            listener.setCode(code);
            walker.walk(listener, tree);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void enterProg(ValidaScriptParser.ProgContext ctx) {

    }

    public void exitProg(ValidaScriptParser.ProgContext ctx) {

    }

    public void enterInfoProduto(ValidaScriptParser.InfoProdutoContext ctx) {
        stack.push(ctx.categoria.getText());
        stack.push(ctx.preco.getText());
        stack.push(ctx.codigo.getText());
    }

    public void exitInfoProduto(ValidaScriptParser.InfoProdutoContext ctx) {
        int codigo = Integer.valueOf(stack.pop());
        String preco = stack.pop();
        String categoria = stack.pop();
        if (code == codigo) {
            System.out.println("Codigo: " + codigo);
            System.out.printf("Preco: " + preco);
            System.out.println("Categoria: " + categoria);
        }
    }

    public void enterInfoCliente(ValidaScriptParser.InfoClienteContext ctx) {
        stack.push(ctx.escalao.getText());
        stack.push(ctx.numero.getText());
    }

    public void exitInfoCliente(ValidaScriptParser.InfoClienteContext ctx) {
        int numero = Integer.valueOf(stack.pop());
        String escalao = stack.pop();
        if (code == numero) {
            System.out.println("Numero: " + numero);
            System.out.println("Escalao: " + escalao);
        }
    }

    private void setCode(int code){
        this.code = code;
    }
}
