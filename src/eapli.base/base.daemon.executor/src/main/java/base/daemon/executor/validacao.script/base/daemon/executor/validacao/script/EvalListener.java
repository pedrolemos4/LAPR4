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
    private boolean bool;
    private String parametroLerFicheiro;
    private String categoria;
    private final Stack<Double> stack = new Stack<>();
    private Map<String, Double> map = new HashMap<>();

    public Double getResult() {
        return stack.peek();
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

    public void exitAtribuir(ValidaScriptParser.AtribuirContext ctx) {
        ctx.calculosMatematicos().enterRule(this);
        double valor = stack.pop();
        System.out.println("Valor da stack no exitAtribuir: " + valor);

        System.out.println("ID: " + ctx.nameVar().getText() + " Value: " + valor);
        map.put(ctx.nameVar().getText(), valor);
    }

    public void enterAtribuiInteiro(ValidaScriptParser.AtribuiInteiroContext ctx) {
        stack.push(Double.parseDouble(ctx.INTEIRO().getText()));
    }

    public void enterAtribuiDouble(ValidaScriptParser.AtribuiDoubleContext ctx) {
        stack.push(Double.parseDouble(ctx.DOUBLE().getText()));
    }


    public void enterProprioValor(ValidaScriptParser.ProprioValorContext ctx) {
        stack.push(Double.parseDouble(ctx.INTEIRO().getText()));
    }

    public void exitVariavel(ValidaScriptParser.VariavelContext ctx) {
        if (map.containsKey(ctx.nameVar().getText())) {
            stack.push(map.get(ctx.nameVar().getText()));
        }
    }

    public void exitMultiDiv(ValidaScriptParser.MultiDivContext ctx) {
        double right, left;

        if (map.containsKey(ctx.left.getText())) {
            left = map.get(ctx.left.getText());
        } else {
            left = Integer.parseInt(ctx.left.getText());
        }

        if (map.containsKey(ctx.right.getText())) {
            right = map.get(ctx.right.getText());
        } else {
            right = Integer.parseInt(ctx.left.getText());
        }
        double valor;
        if (ctx.sinal.getText().equals("/")) {
            valor = left / right;
            stack.push(valor);
        }
        valor = left * right;
        stack.push(valor);
    }

    public void exitSomaSub(ValidaScriptParser.SomaSubContext ctx) {
        double right, left;

        if (map.containsKey(ctx.left.getText())) {
            left = map.get(ctx.left.getText());
        } else {
            left = Integer.parseInt(ctx.left.getText());
        }

        if (map.containsKey(ctx.right.getText())) {
            right = map.get(ctx.right.getText());
        } else {
            right = Integer.parseInt(ctx.left.getText());
        }
        double valor;
        if (ctx.sinal.getText().equals("+")) {
            valor = left + right;
            stack.push(valor);
        }
        valor = left - right;
        stack.push(valor);
    }

    public void enterParenteses(ValidaScriptParser.ParentesesContext ctx) {
        ctx.calculosMatematicos().enterRule(this);
    }

    public void exitAplicar_desconto(ValidaScriptParser.Aplicar_descontoContext ctx) {
        double desconto = this.getDesconto();
        if (map.containsKey(ctx.valorDesconto.getText())) {
            desconto += map.get(ctx.valorDesconto.getText());
        } else {
            desconto += Double.parseDouble(ctx.valorDesconto.getText());
        }
        System.out.println("Desconto: " + desconto);
        this.desconto = desconto;
    }

    public void exitExpressao_a_verificar(ValidaScriptParser.Expressao_a_verificarContext ctx) {
        boolean bool = false;
        double left, right;
        int l = 0, r = 0;

        if (map.containsKey(ctx.leftPortion.getText())) {
            left = map.get(ctx.leftPortion.getText());
        } else if (ctx.leftPortion.getText().equals("#TOTAL#")) {
            left = precoTotal;
            l = 1;
        } else {
            left = Integer.parseInt(ctx.leftPortion.getText());
        }

        if (map.containsKey(ctx.rightPortion.getText())) {
            right = map.get(ctx.rightPortion.getText());
        } else if (ctx.rightPortion.getText().equals("#TOTAL#")) {
            right = precoTotal;
            r = 1;
        } else {
            right = Integer.parseInt(ctx.rightPortion.getText());
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
            this.bool = true;
        } else {
            this.bool = false;
        }
    }

    public void enterElse1(ValidaScriptParser.Else1Context ctx) {
        ctx.aplicar_desconto().enterRule(this);
    }

    public void exitAplicarDesconto(ValidaScriptParser.AplicarDescontoContext ctx) {
        ctx.expressao_a_verificar().enterRule(this);
        if (bool) {
            ctx.aplicar_desconto().enterRule(this);
        } else if (ctx.temElse.getText() != null && !ctx.temElse.getText().isEmpty() && bool == false) {
            ctx.else1().enterRule(this);
        }
        ctx.expressao_a_verificar().enterRule(this);
    }

    public void exitCalcularDescontoEPreco(ValidaScriptParser.CalcularDescontoEPrecoContext ctx) {
        System.out.println("Preco total: " + precoTotal);
        this.precoTotal = precoTotal - this.getDesconto() * precoTotal;
        System.out.println("Preco apos descontos: " + precoTotal);
    }

    //--------------------------------LER INFO PRODUTO--------------------------------//

    public void exitInfoProduto(ValidaScriptParser.InfoProdutoContext ctx) {
        if (code == Integer.parseInt(ctx.codigo.getText())) {
            this.preco = Integer.parseInt(ctx.preco.getText());
            if (parametroLerFicheiro != null) {
                if (parametroLerFicheiro.equals("Preco")) {
                    System.out.println("Preco: " + ctx.preco.getText());
                    this.parametroLerFicheiro = null;
                    //stack.push(1.0);
                } else if (parametroLerFicheiro.equals("Categoria")) {
                    System.out.println("Categoria: " + ctx.categoria.getText());
                    this.parametroLerFicheiro = null;
                    //stack.push(1.0);
                }
            } else {
                System.out.println("Codigo: " + ctx.codigo.getText());
                System.out.println("Preco: " + ctx.preco.getText());
                System.out.println("Categoria: " + ctx.categoria.getText());
                //stack.push(1.0);
            }
        }
        //stack.push(0.0);
    }

    public void exitInfoCliente(ValidaScriptParser.InfoClienteContext ctx) {
        if (code == Integer.parseInt(ctx.numero.getText())) {
            if (parametroLerFicheiro != null) {
                if (parametroLerFicheiro.equals("Escalao")) {
                    System.out.println("Escalao: " + ctx.escalao.getText());
                    this.parametroLerFicheiro = null;
                    //stack.push(1.0);
                }
            } else {
                System.out.println("Numero: " + ctx.numero.getText());
                System.out.println("Escalao: " + ctx.escalao.getText());
                //stack.push(1.0);
            }
        }
        //stack.push(0.0);
    }

    public void exitLerFicheiro(ValidaScriptParser.LerFicheiroContext ctx) {
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
            listener.setCode(Integer.parseInt(ctx.possivel_id.getText()));
            listener.setParametro(ctx.valor.getText());
            listener.setQuantidade(quant);
            walker.walk(listener, tree);
            setCategoria(listener.getCategoria());
            setPrecoTotal(listener.getPreco(), quant);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //--------------------------------ENVIAR EMAIL--------------------------------//

    public void exitEnviarEmail(ValidaScriptParser.EnviarEmailContext ctx) {
        System.out.println("Email: " + ctx.sendEmail().emailColab.getText());

        if (ctx.sendEmail().decisao.isEmpty()) {
            System.out.println("Tipo Cliente: " + ctx.sendEmail().tipoCliente.getText());
            System.out.println("Valor Desconto: " + ctx.sendEmail().valorDesconto.getText());
            System.out.println("Preço Final: " + ctx.sendEmail().valorFinal.getText());
        } else {
            System.out.println("Decisao: " + ctx.sendEmail().decisao.getText());
            System.out.println("Desconto: " + ctx.sendEmail().desconto.getText());
        }
    }
}
