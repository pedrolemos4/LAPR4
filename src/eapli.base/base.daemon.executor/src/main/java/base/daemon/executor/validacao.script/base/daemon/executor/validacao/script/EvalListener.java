package base.daemon.executor.validacao.script.base.daemon.executor.validacao.script;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class EvalListener extends ValidaScriptBaseListener {
    private int code;
    private final Stack<String> stack = new Stack<>();
    private Map<String, Integer> map = new HashMap<>();

    public String getResult() {
        return stack.peek();
    }

    public void enterStart(ValidaScriptParser.StartContext ctx) {

    }

    public void exitStart(ValidaScriptParser.StartContext ctx) {

    }

    /*public void enterScript(ValidaScriptParser.ScriptContext ctx) {

    }

    public void exitScript(ValidaScriptParser.ScriptContext ctx) {

    }

    public void enterInstrucao(ValidaScriptParser.InstrucaoContext ctx) {

    }

    public void exitInstrucao(ValidaScriptParser.InstrucaoContext ctx) {

    }*/

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

    //--------------------------------REALIZAR CALCULOS--------------------------------//

    public void enterAtribuir(ValidaScriptParser.AtribuirContext ctx) {
        stack.push(ctx.nameVar().getText());
    }

    public void exitAtribuir(ValidaScriptParser.AtribuirContext ctx) {
        String id = stack.pop();
        int value = Integer.parseInt(stack.pop()); //ta mal
        System.out.println("ID: " + id + " Value: " + value);
        map.put(id, value);
        stack.push("0");
    }

    public void enterProprioValor(ValidaScriptParser.ProprioValorContext ctx) {
        stack.push(ctx.INTEIRO().getText());
    }

    public void exitProprioValor(ValidaScriptParser.ProprioValorContext ctx) {

    }

    public void enterVariavel(ValidaScriptParser.VariavelContext ctx) {
        stack.push(ctx.nameVar().getText());
    }

    public void exitVariavel(ValidaScriptParser.VariavelContext ctx) {
        String id = stack.pop();
        if (map.containsKey(id)) {
            stack.push(Integer.toString(map.get(id)));
        }
        stack.push("0");
    }

    public void enterMultiDiv(ValidaScriptParser.MultiDivContext ctx) {
        stack.push(ctx.left.getText());
        stack.push(ctx.right.getText());
    }

    public void exitMultiDiv(ValidaScriptParser.MultiDivContext ctx) {
        String auxRight = stack.pop(), auxLeft = stack.pop();
        int right, left;

        if (map.containsKey(auxLeft)) {
            left = map.get(auxLeft);
        } else {
            left = Integer.parseInt(auxLeft);
        }

        if (map.containsKey(auxRight)) {
            right = map.get(auxRight);
        } else {
            right = Integer.parseInt(auxRight);
        }
        int valor;
        if (ctx.sinal.getText().equals("/")) {
            valor = left / right;
            stack.push(Integer.toString(valor));
        }
        valor = left * right;
        stack.push(Integer.toString(valor));
    }

    public void enterSomaSub(ValidaScriptParser.SomaSubContext ctx) {
        stack.push(ctx.left.getText());
        stack.push(ctx.right.getText());
    }

    public void exitSomaSub(ValidaScriptParser.SomaSubContext ctx) {
        String auxRight = stack.pop(), auxLeft = stack.pop();
        int right, left;

        if (map.containsKey(auxLeft)) {
            left = map.get(auxLeft);
        } else {
            left = Integer.parseInt(auxLeft);
        }

        if (map.containsKey(auxRight)) {
            right = map.get(auxRight);
        } else {
            right = Integer.parseInt(auxRight);
        }
        int valor;
        if (ctx.sinal.getText().equals("+")) {
            valor = left + right;
            stack.push(Integer.toString(valor));
        }
        valor = left - right;
        stack.push(Integer.toString(valor));
    }

    public void enterParenteses(ValidaScriptParser.ParentesesContext ctx) {

    }

    public void exitParenteses(ValidaScriptParser.ParentesesContext ctx) {

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
