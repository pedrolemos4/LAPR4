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
    private int code, c = 0;
    private int quantidade;
    private double preco;
    private double precoTotal;
    private double desconto;
    private boolean bool;
    private String parametroLerFicheiro;
    private String form = "";
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

    public void setQuantidade(int quantidade) {
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

    private void setCode(int code) {
        this.code = code;
    }

    public void setForm(String form) {
        this.form = form;
    }

    //--------------------------------REALIZAR CALCULOS--------------------------------//

    public void exitAtribuir(ValidaScriptParser.AtribuirContext ctx) {
        ctx.calculosMatematicos().enterRule(this);
        double valor = stack.pop();

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
            left = Double.parseDouble(ctx.left.getText());
        }

        if (map.containsKey(ctx.right.getText())) {
            right = map.get(ctx.right.getText());
        } else {
            right = Double.parseDouble(ctx.right.getText());
        }
        double valor;
        if (ctx.sinal.getText().equals("/")) {
            valor = left / right;
            stack.push(valor);
        } else {
            valor = left * right;
            stack.push(valor);
        }
    }

    public void exitSomaSub(ValidaScriptParser.SomaSubContext ctx) {
        double right, left;

        if (map.containsKey(ctx.left.getText())) {
            left = map.get(ctx.left.getText());
        } else {
            left = Double.parseDouble(ctx.left.getText());
        }

        if (map.containsKey(ctx.right.getText())) {
            right = map.get(ctx.right.getText());
        } else {
            right = Double.parseDouble(ctx.left.getText());
        }
        double valor;
        if (ctx.sinal.getText().equals("+")) {
            valor = left + right;
            stack.push(valor);
        } else {
            valor = left - right;
            stack.push(valor);
        }
    }

    public void enterParenteses(ValidaScriptParser.ParentesesContext ctx) {
        ctx.calculosMatematicos().enterRule(this);
    }

    public void enterAplicar_desconto(ValidaScriptParser.Aplicar_descontoContext ctx) {
        if (c == 0) {
            double desconto = this.getDesconto();
            if (map.containsKey(ctx.valorDesconto.getText())) {
                desconto += map.get(ctx.valorDesconto.getText());
            } else {
                desconto += Double.parseDouble(ctx.valorDesconto.getText());
            }
            System.out.println("Desconto: " + desconto);
            this.desconto = desconto;
            c++;
        }
    }

    public void enterExpressao_a_verificar(ValidaScriptParser.Expressao_a_verificarContext ctx) {
        double left, right;
        int l = 0, r = 0;

        try {
            ctx.leftPortion.getText();
        } catch (NullPointerException e) {
            if (ctx.leftPortionCat.getText().equals("CATEGORIA")) {
                if (ctx.sinal.getText().equals("==")) {
                    try {
                        bool = this.getCategoria().equals(ctx.rightPortionCat.getText());
                    } catch (NullPointerException n) {
                        System.out.println("Este produto não existe.");
                        return;
                    }

                } else if (ctx.sinal.getText().equals("!=")) {
                    bool = !this.getCategoria().equals(ctx.rightPortionCat.getText());
                }
            }
            if (bool) {
                stack.push(1.0);
                return;
            } else {
                stack.push(0.0);
                return;
            }
        }

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
            stack.push(1.0);
        } else {
            stack.push(0.0);
        }
    }

    public void enterElse1(ValidaScriptParser.Else1Context ctx) {
        ctx.aplicar_desconto().enterRule(this);
    }

    public void exitAplicarDesconto(ValidaScriptParser.AplicarDescontoContext ctx) {
        ctx.expressao_a_verificar().enterRule(this);
        if (bool) {
            ctx.aplicar_desconto().enterRule(this);
        } else {
            try {
                if (ctx.temElse.getText() != null && !ctx.temElse.getText().isEmpty() && bool == false) {
                    System.out.println("entrou");
                    ctx.else1().enterRule(this);
                }
            } catch (NullPointerException e) {
                System.out.println("Não há desconto para este tipo!");
            }
        }
        c--;
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
            this.categoria = ctx.categoria.getText();
            if (parametroLerFicheiro != null) {
                if (parametroLerFicheiro.equals("Preco")) {
                    System.out.println("Preco: " + ctx.preco.getText());
                    this.parametroLerFicheiro = null;
                } else if (parametroLerFicheiro.equals("Categoria")) {
                    System.out.println("Categoria: " + ctx.categoria.getText());
                    this.parametroLerFicheiro = null;
                }
            } else {
                System.out.println("Codigo: " + ctx.codigo.getText());
                System.out.println("Preco: " + ctx.preco.getText());
                System.out.println("Categoria: " + ctx.categoria.getText());
            }
        }
    }

    public void exitInfoCliente(ValidaScriptParser.InfoClienteContext ctx) {
        if (code == Integer.parseInt(ctx.numero.getText())) {
            if (parametroLerFicheiro != null) {
                if (parametroLerFicheiro.equals("Escalao")) {
                    System.out.println("Escalao: " + ctx.escalao.getText());
                    this.parametroLerFicheiro = null;
                }
            } else {
                System.out.println("Numero: " + ctx.numero.getText());
                System.out.println("Escalao: " + ctx.escalao.getText());
            }
        }
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

    /*public void exitEnviarEmailProduto(ValidaScriptParser.EnviarEmailProdutoContext ctx) {
        System.out.println("Email: " + ctx.emailColab.getText());
        System.out.println("Caro " + ctx.tipoCliente.getText() + ",\n" +
                "O seu pedido foi efetuado com sucesso! O valor a pagar dos seus produtos será " + precoTotal + "€. Este valor foi obtido após aplicar o desconto de " + (desconto * 100) + "%");
    }

    public void exitEnviarEmailFormulario(ValidaScriptParser.EnviarEmailFormularioContext ctx) {
        if(form.isEmpty()){
            System.out.println("Não existem dados do formulário.");
        } else {
            System.out.println("Caro colaborador, aqui tem os dados do formulário que preencheu:\n" + form);
        }
    }*/
}
