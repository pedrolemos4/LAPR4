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
    private int quantidade;
    private double preco;
    private double precoTotal;
    private double desconto;
    private String parametroLerFicheiro;
    private String categoria;
    private final Stack<String> stack = new Stack<>();
    private Map<String, Double> map = new HashMap<>();

    public String getResult() {
        return stack.peek();
    }

    public void enterStart(ValidaScriptParser.StartContext ctx) {

    }

    public void exitStart(ValidaScriptParser.StartContext ctx) {

    }

    public void enterFicheiro(ValidaScriptParser.FicheiroContext ctx) {

    }

    public void exitFicheiro(ValidaScriptParser.FicheiroContext ctx) {

    }

    public void enterPath(ValidaScriptParser.PathContext ctx) {

    }

    public void exitPath(ValidaScriptParser.PathContext ctx) {

    }

    //--------------------------------GET E SET--------------------------------//

    private int getQuantidade() {
        return quantidade;
    }

    private double getPreco() {
        return preco;
    }

    private double getDesconto() {
        return desconto;
    }

    private void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    private void setParametro(String parametro) {
        if (parametro.length() > 0) {
            this.parametroLerFicheiro = parametro;
        }
    }

    private String getCategoria() {
        return categoria;
    }

    private void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    private void setPrecoTotal(double preco, int quant) {
        this.precoTotal = preco * quant;
    }

    private void setCode(int code){
        this.code = code;
    }

    //--------------------------------REALIZAR CALCULOS--------------------------------//

    public void enterAtribuir(ValidaScriptParser.AtribuirContext ctx) {
        stack.push(ctx.nameVar().getText());
    }

    public void exitAtribuir(ValidaScriptParser.AtribuirContext ctx) {
        /*String id = stack.pop();
        int value = Integer.parseInt(stack.pop());
        System.out.println("ID: " + id + " Value: " + value);
        map.put(id, (double) value);
        stack.push("0");*/
    }

    public void enterAtribuiInteiro(ValidaScriptParser.AtribuiInteiroContext ctx) {
        stack.push(ctx.INTEIRO().getText());
    }

    public void exitAtribuiInteiro(ValidaScriptParser.AtribuiInteiroContext ctx) {

    }

    public void enterAtribuiDouble(ValidaScriptParser.AtribuiDoubleContext ctx) {
        stack.push(ctx.DOUBLE().getText());
    }

    public void exitAtribuiDouble(ValidaScriptParser.AtribuiDoubleContext ctx) {

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
            stack.push(Double.toString(map.get(id)));
        }
        stack.push("0");
    }

    public void enterMultiDiv(ValidaScriptParser.MultiDivContext ctx) {
        stack.push(ctx.left.getText());
        stack.push(ctx.right.getText());
    }

    public void exitMultiDiv(ValidaScriptParser.MultiDivContext ctx) {
        String auxRight = stack.pop(), auxLeft = stack.pop();
        double right, left;

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
        double valor;
        if (ctx.sinal.getText().equals("/")) {
            valor = left / right;
            stack.push(Double.toString(valor));
        }
        valor = left * right;
        stack.push(Double.toString(valor));
    }

    public void enterSomaSub(ValidaScriptParser.SomaSubContext ctx) {
        stack.push(ctx.left.getText());
        stack.push(ctx.right.getText());
    }

    public void exitSomaSub(ValidaScriptParser.SomaSubContext ctx) {
        String auxRight = stack.pop(), auxLeft = stack.pop();
        double right, left;

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
        double valor;
        if (ctx.sinal.getText().equals("+")) {
            valor = left + right;
            stack.push(Double.toString(valor));
        }
        valor = left - right;
        stack.push(Double.toString(valor));
    }

    public void enterParenteses(ValidaScriptParser.ParentesesContext ctx) {

    }

    public void exitParenteses(ValidaScriptParser.ParentesesContext ctx) {

    }

    public void enterAplicar_desconto(ValidaScriptParser.Aplicar_descontoContext ctx) {
        stack.push(ctx.valorDesconto.getText());
    }

    public void exitAplicar_desconto(ValidaScriptParser.Aplicar_descontoContext ctx) {
        String valDesconto = stack.pop();
        double desconto = this.getDesconto();
        if (map.containsKey(valDesconto)) {
            desconto += map.get(valDesconto);
        } else {
            desconto += Double.parseDouble(valDesconto);
        }
        System.out.println("Desconto: " + desconto);
        this.desconto = desconto;
        stack.push(Double.toString(desconto));
    }

    public void enterExpressao_a_verificar(ValidaScriptParser.Expressao_a_verificarContext ctx) {
        stack.push(ctx.leftPortion.getText());
        stack.push(ctx.rightPortion.getText());
    }

    public void exitExpressao_a_verificar(ValidaScriptParser.Expressao_a_verificarContext ctx) {
        boolean bool = false;
        String auxRight = stack.pop(), auxLeft = stack.pop();
        double left, right;
        int l = 0, r = 0;

        if (map.containsKey(auxLeft)) {
            left = map.get(auxLeft);
        } else if (auxLeft.equals("#TOTAL#")) {
            left = precoTotal;
            l = 1;
        } else {
            left = Integer.parseInt(auxLeft);
        }

        if (map.containsKey(auxRight)) {
            right = map.get(auxRight);
        } else if (auxRight.equals("#TOTAL#")) {
            right = precoTotal;
            r = 1;
        } else {
            right = Integer.parseInt(auxRight);
        }

        if (ctx.sinal.getText().equals(">") && r == 1) {
            bool = left > right;
        } else if (ctx.sinal.getText().equals("<") && r == 1) {
            bool = left < right;
        } else if (ctx.sinal.getText().equals("<=") && r == 1) {
            bool = left <= right;
        } else if (ctx.sinal.getText().equals(">=") && r == 1) {
            bool = left >= right;
        } else if (ctx.sinal.getText().equals(">") && l == 1) {
            bool = left > right;
        } else if (ctx.sinal.getText().equals("<") && l == 1) {
            bool = left < right;
        } else if (ctx.sinal.getText().equals("<=") && l == 1) {
            bool = left <= right;
        } else if (ctx.sinal.getText().equals(">=") && l == 1) {
            bool = left >= right;
        }
        if (bool) {
            stack.push("1.0");
        } else {
            stack.push("0.0");
        }
    }

    public void enterElse1(ValidaScriptParser.Else1Context ctx) {

    }

    public void exitElse1(ValidaScriptParser.Else1Context ctx) {

    }

    public void enterAplicarDesconto(ValidaScriptParser.AplicarDescontoContext ctx) {

    }

    public void exitAplicarDesconto(ValidaScriptParser.AplicarDescontoContext ctx) {
        /*if (visit(ctx.expressao_a_verificar()) == 1.0) {
            visit(ctx.aplicar_desconto());
        } else if (ctx.temElse.getText() != null && !ctx.temElse.getText().isEmpty() && visit(ctx.expressao_a_verificar()) == 0.0) {
            visit(ctx.else1());
        }
        visit(ctx.expressao_a_verificar());*/
    }

    public void enterCalcularDescontoEPreco(ValidaScriptParser.CalcularDescontoEPrecoContext ctx) {

    }

    public void exitCalcularDescontoEPreco(ValidaScriptParser.CalcularDescontoEPrecoContext ctx) {
        System.out.println("Preco total: " + precoTotal);
        this.precoTotal = precoTotal - this.getDesconto() * precoTotal;
        System.out.println("Preco apos descontos: " + precoTotal);
        stack.push(Double.toString(precoTotal - this.getDesconto() * precoTotal));
    }

    public void enterProg(ValidaScriptParser.ProgContext ctx) {

    }

    public void exitProg(ValidaScriptParser.ProgContext ctx) {

    }

    //--------------------------------LER INFO PRODUTO--------------------------------//

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
            this.preco = Integer.parseInt(preco);
            if (parametroLerFicheiro != null) {
                if (parametroLerFicheiro.equals("Preco")) {
                    System.out.println("Preco: " + preco);
                    this.parametroLerFicheiro = null;
                    stack.push("1.0");
                } else if (parametroLerFicheiro.equals("Categoria")) {
                    System.out.println("Categoria: " + categoria);
                    this.parametroLerFicheiro = null;
                    stack.push("1.0");
                }
            } else {
                System.out.println("Codigo: " + codigo);
                System.out.println("Preco: " + preco);
                System.out.println("Categoria: " + categoria);
                stack.push("1.0");
            }
        }
        stack.push("0.0");
    }

    public void enterInfoCliente(ValidaScriptParser.InfoClienteContext ctx) {
        stack.push(ctx.escalao.getText());
        stack.push(ctx.numero.getText());
    }

    public void exitInfoCliente(ValidaScriptParser.InfoClienteContext ctx) {
        int numero = Integer.valueOf(stack.pop());
        String escalao = stack.pop();
        if (code == numero) {
            if (parametroLerFicheiro != null) {
                if (parametroLerFicheiro.equals("Escalao")) {
                    System.out.println("Escalao: " + escalao);
                    this.parametroLerFicheiro = null;
                    stack.push("1.0");
                }
            } else {
                System.out.println("Numero: " + numero);
                System.out.println("Escalao: " + escalao);
                stack.push("1.0");
            }
        }
        stack.push("0.0");
    }

    public void enterLerFicheiro(ValidaScriptParser.LerFicheiroContext ctx) {
        stack.push(ctx.possivel_id.getText());
        stack.push(ctx.valor.getText());
    }

    public void exitLerFicheiro(ValidaScriptParser.LerFicheiroContext ctx) {
        String valor = stack.pop();
        int code = Integer.parseInt(stack.pop());
        FileInputStream fis;

        try {
            fis = new FileInputStream("testeProdutos.xml");
            ValidaScriptLexer lexer = new ValidaScriptLexer(new ANTLRInputStream(fis));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            ValidaScriptParser parser = new ValidaScriptParser(tokens);
            ParseTree tree = parser.progFile();
            int quant = getQuantidade();
            ParseTreeWalker walker = new ParseTreeWalker();
            EvalListener listener = new EvalListener();
            listener.setCode(code);
            listener.setParametro(valor);
            listener.setQuantidade(quant);
            walker.walk(listener, tree);
            setCategoria(listener.getCategoria());
            setPrecoTotal(listener.getPreco(), quant);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //--------------------------------ENVIAR EMAIL--------------------------------//

    public void enterEnviarEmail(ValidaScriptParser.EnviarEmailContext ctx) {
        stack.push(ctx.sendEmail().emailColab.getText());
        stack.push(ctx.sendEmail().tipoCliente.getText());
        stack.push(ctx.sendEmail().valorDesconto.getText());
        stack.push(ctx.sendEmail().valorFinal.getText());
        stack.push(ctx.sendEmail().decisao.getText());
        stack.push(ctx.sendEmail().desconto.getText());
    }

    public void exitEnviarEmail(ValidaScriptParser.EnviarEmailContext ctx) {
        String desconto = stack.pop(), decisao = stack.pop(), valorFinal = stack.pop();
        String valDesconto = stack.pop(), tipoCliente = stack.pop(), email = stack.pop();

        System.out.println("Email: " + email);

        if (decisao.isEmpty()) {
            System.out.println("Tipo Cliente: " + tipoCliente);
            System.out.println("Valor Desconto: " + valDesconto);
            System.out.println("Preço Final: " + valorFinal);
        } else {
            System.out.println("Decisao: " + decisao);
            System.out.println("Desconto: " + desconto);
        }
    }
}
