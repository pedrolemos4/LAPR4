package base.daemon.executor.validacao.script.base.daemon.executor.validacao.script;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EvalVisitor extends ValidaScriptBaseVisitor<Double> {

    private int code;

    private double desconto;

    private int quantidade;

    private String categoria;

    private double preco;

    private double precoTotal;

    private String parametroLerFicheiro;

    private String form = "";

    private Map<String, Double> map = new HashMap<>();

    /*@Override
    public Integer visitFicheiro(ValidaScriptParser.FicheiroContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitPath(ValidaScriptParser.PathContext ctx) {
        return visitChildren(ctx);
    }*/

    //--------------------------------LER FICHEIRO--------------------------------//
    @Override
    public Double visitInfoProduto(ValidaScriptParser.InfoProdutoContext ctx) {
        if (code == Integer.parseInt(ctx.codigo.getText())) {
            this.preco = Double.parseDouble(ctx.preco.getText());
            this.categoria = ctx.categoria.getText();
            if (parametroLerFicheiro != null) {
                if (parametroLerFicheiro.equals("Preco")) {
                    System.out.println("Preco: " + ctx.preco.getText());
                    this.parametroLerFicheiro = null;
                    return 1.0;
                } else if (parametroLerFicheiro.equals("Categoria")) {
                    System.out.println("Categoria: " + ctx.categoria.getText());
                    this.parametroLerFicheiro = null;
                    return 1.0;
                }
            } else {
                System.out.println("Codigo: " + ctx.codigo.getText());
                System.out.println("Preco: " + ctx.preco.getText());
                System.out.println("Categoria: " + ctx.categoria.getText());
                return 1.0;
            }
        }
        return 0.0;
    }

    @Override
    public Double visitInfoCliente(ValidaScriptParser.InfoClienteContext ctx) {
        if (code == Integer.parseInt(ctx.numero.getText())) {
            if (parametroLerFicheiro != null) {
                if (parametroLerFicheiro.equals("Escalao")) {
                    System.out.println("Escalao: " + ctx.escalao.getText());
                    this.parametroLerFicheiro = null;
                    return 1.0;
                }
            } else {
                System.out.println("Numero: " + ctx.numero.getText());
                System.out.println("Escalao: " + ctx.escalao.getText());
                return 1.0;
            }
        }
        return 0.0;
    }

    @Override
    public Double visitLerFicheiro(ValidaScriptParser.LerFicheiroContext ctx) {
        FileInputStream fis;
        try {
            fis = new FileInputStream(new File(ctx.ficheiro_script.getText()));
            ValidaScriptLexer lexer = new ValidaScriptLexer(new ANTLRInputStream(fis));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            ValidaScriptParser parser = new ValidaScriptParser(tokens);
            ParseTree tree = parser.progFile(); // parse
            int quant = getQuantidade();
            EvalVisitor eval = new EvalVisitor();
            eval.setCode(Integer.parseInt(ctx.possivel_id.getText()));
            if (ctx.valor != null) {
                eval.setParametro(ctx.valor.getText());
            }
            eval.setQuantidade(quant);
            eval.visit(tree);
            setCategoria(eval.getCategoria());
            setPrecoTotal(eval.getPreco(), quant);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0.0;
    }

    //--------------------------------SETS E GETS--------------------------------//

    private double getDesconto() {
        return desconto;
    }

    private double getPreco() {
        return preco;
    }

    private int getQuantidade() {
        return quantidade;
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

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    private void setCode(int code) {
        this.code = code;
    }

    public void setForm(String form) {
        this.form = form;
    }

    private void setParametro(String parametro) {
        if (parametro.length() > 0) {
            this.parametroLerFicheiro = parametro;
        }
    }

    //--------------------------------REALIZAR CALCULOS--------------------------------//

    @Override
    public Double visitAtribuir(ValidaScriptParser.AtribuirContext ctx) {
        String id = ctx.nameVar().getText();
        double value = visit(ctx.calculosMatematicos());
        System.out.println("ID: " + id + " Value: " + value);
        map.put(id, value);
        return 0.0;
    }

    @Override
    public Double visitProprioValor(ValidaScriptParser.ProprioValorContext ctx) {
        return Double.parseDouble(ctx.INTEIRO().getText());
    }

    @Override
    public Double visitVariavel(ValidaScriptParser.VariavelContext ctx) {
        String id = ctx.nameVar().getText();
        if (map.containsKey(id)) {
            return map.get(id);
        }
        return 0.0;
    }

    @Override
    public Double visitMultiDiv(ValidaScriptParser.MultiDivContext ctx) {
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
        int valor;
        if (ctx.sinal.getText().equals("/")) {
            return left / right;
        }
        return left * right;
    }

    @Override
    public Double visitSomaSub(ValidaScriptParser.SomaSubContext ctx) {
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

        if (ctx.sinal.getText().equals("+")) {
            return left + right;
        }
        return left - right;
    }

    @Override
    public Double visitParenteses(ValidaScriptParser.ParentesesContext ctx) {
        return visit(ctx.calculosMatematicos());
    }

    /*
   @Override
   public Double visitCalcPrecoTotal(ValidaScriptParser.CalcPrecoTotalContext ctx) {
       int quantidade = Integer.parseInt(ctx.quantidade.getText());
       if (quantidade > 0) {
           double total = preco * quantidade;
           System.out.println("Preco total: " + total);
           map.put(ctx.var.getText(), total);
           return total;
       }
       return 0.0;
   }
*/
    @Override
    public Double visitAtribuiInteiro(ValidaScriptParser.AtribuiInteiroContext ctx) {
        return (double) Integer.parseInt(ctx.INTEIRO().getText());
    }


    @Override
    public Double visitAtribuiDouble(ValidaScriptParser.AtribuiDoubleContext ctx) {
        return Double.parseDouble(ctx.DOUBLE().getText());
    }
//*/
//--------------------------------APLICAR DESCONTOS--------------------------------//

    @Override
    public Double visitAplicarDesconto(ValidaScriptParser.AplicarDescontoContext ctx) {

        if (visit(ctx.expressao_a_verificar()) == 1.0) {
            visit(ctx.aplicar_desconto());
        } else {
            try {
                if (ctx.temElse.getText() != null && !ctx.temElse.getText().isEmpty() && visit(ctx.expressao_a_verificar()) == 0.0) {
                    visit(ctx.else1());
                }
            } catch (NullPointerException e) {
                System.out.println("Não há desconto para este tipo!");
            }
        }
        visit(ctx.expressao_a_verificar());

        return 0.0;
    }

    @Override
    public Double visitExpressao_a_verificar(ValidaScriptParser.Expressao_a_verificarContext ctx) {
        boolean bool = false;
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
                        System.exit(0);
                    }

                } else if (ctx.sinal.getText().equals("!=")) {
                    bool = !this.getCategoria().equals(ctx.rightPortionCat.getText());
                }
            }
            if (bool) {
                return 1.0;
            } else {
                return 0.0;
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
            return 1.0;
        } else {
            return 0.0;
        }

    }

    @Override
    public Double visitElse1(ValidaScriptParser.Else1Context ctx) {
        return visit(ctx.aplicar_desconto());
    }

    @Override
    public Double visitAplicar_desconto(ValidaScriptParser.Aplicar_descontoContext ctx) {
        double desconto = this.getDesconto();
        if (map.containsKey(ctx.valorDesconto.getText())) {
            desconto += map.get(ctx.valorDesconto.getText());
        } else {
            desconto += Double.parseDouble(ctx.valorDesconto.getText());
        }
        System.out.println("Desconto: " + desconto);
        this.desconto = desconto;
        return desconto;
    }

    //--------------------------------CALCULAR PRECO TOTAL E DESCONTOS--------------------------------//

    @Override
    public Double visitCalcularDescontoEPreco(ValidaScriptParser.CalcularDescontoEPrecoContext ctx) {
        System.out.println("Preco total: " + precoTotal);
        this.precoTotal = precoTotal - this.getDesconto() * precoTotal;
        System.out.println("Preco apos descontos: " + precoTotal);
        return precoTotal - this.getDesconto() * precoTotal;
    }

//--------------------------------ENVIAR EMAIL--------------------------------//

    @Override
    public Double visitSendEmail(ValidaScriptParser.SendEmailContext ctx) {
        System.out.println("Enviar email a " + ctx.email.getText()+ " com desconto de: " + desconto);
        return 0.0;
    }

    @Override
    public Double visitSendEmailCalculos(ValidaScriptParser.SendEmailCalculosContext ctx) {
        if(map.containsKey(ctx.varValor.getText())){
            System.out.println("Enviar email a " +ctx.email.getText()+" com desconto de: " + desconto+" com um preco de: "+map.get(ctx.varValor.getText()));
        }else{
            System.out.println("Nao existe essa variavel");
        }
        return 0.0;
    }

}