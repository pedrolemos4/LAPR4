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
    private int preco;
    private double desconto;

    private String parametroLerFicheiro;

    private Map<String, Double> map = new HashMap<>();

    @Override
    public Double visitFicheiro(ValidaScriptParser.FicheiroContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Double visitPath(ValidaScriptParser.PathContext ctx) {
        return visitChildren(ctx);
    }

    //--------------------------------LER FICHEIRO--------------------------------//
    @Override
    public Double visitInfoProduto(ValidaScriptParser.InfoProdutoContext ctx) {
        if (code == Integer.parseInt(ctx.codigo.getText())) {
            this.preco = Integer.parseInt(ctx.preco.getText());
            System.out.println("Preco atr: " + preco);
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
            fis = new FileInputStream(new File("testeProdutos.xml"));
            ValidaScriptLexer lexer = new ValidaScriptLexer(new ANTLRInputStream(fis));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            ValidaScriptParser parser = new ValidaScriptParser(tokens);
            ParseTree tree = parser.progFile(); // parse
            EvalVisitor eval = new EvalVisitor();
            eval.setCode(Integer.parseInt(ctx.possivel_id.getText()));
            eval.setParametro(ctx.valor.getText());
            eval.visit(tree);
            this.preco=eval.getPreco();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0.0;
    }

    private int getPreco() {
        return preco;
    }

    private void setCode(int code) {
        this.code = code;
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
            left = Integer.parseInt(ctx.left.getText());
        }

        if (map.containsKey(ctx.right.getText())) {
            right = map.get(ctx.right.getText());
        } else {
            right = Integer.parseInt(ctx.right.getText());
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
            left = Integer.parseInt(ctx.left.getText());
        }

        if (map.containsKey(ctx.right.getText())) {
            right = map.get(ctx.right.getText());
        } else {
            right = Integer.parseInt(ctx.right.getText());
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


    @Override
    public Double visitCalcPrecoTotal(ValidaScriptParser.CalcPrecoTotalContext ctx) {
        System.out.println("Entra com preco a: " + preco);
        System.out.println("Quantidade: " + ctx.quantidade.getText());
        int quantidade = Integer.parseInt(ctx.quantidade.getText());
        if (quantidade > 0 && preco > 0) {
            int total = preco * quantidade;
            System.out.println("Preco total: " + total);
            map.put(ctx.var.getText(), (double) total);
            return (double) total;
        }
        return 0.0;
    }

    @Override
    public Double visitAdicionarDesconto(ValidaScriptParser.AdicionarDescontoContext ctx) {
        if (map.containsKey(ctx.categoria.getText()) && ctx.categoria.getText().equals(ctx.var.getText())) {
            desconto = desconto + 0.5;
        }
        return 0.0;
    }

//--------------------------------APLICAR DESCONTOS--------------------------------//

    @Override
    public Double visitCalcPrecoFinal(ValidaScriptParser.CalcPrecoFinalContext ctx) {
        double valorFinal, desconto, valor;

        valor = Double.parseDouble(ctx.var.getText());
        desconto = Double.parseDouble(ctx.desconto.getText());

        valorFinal = valor - (valor * desconto);
        System.out.println("Valor Final: " + valorFinal);

        return valorFinal;
    }

//--------------------------------ENVIAR EMAIL--------------------------------//

    @Override
    public Double visitEnviarEmail(ValidaScriptParser.EnviarEmailContext ctx) {
        System.out.println("Email: " + ctx.sendEmail().emailColab.getText());
        if (ctx.sendEmail().decisao.getText().isEmpty()) {
            System.out.println("Tipo Cliente: " + ctx.sendEmail().tipoCliente.getText());
            System.out.println("Valor Desconto: " + ctx.sendEmail().valorDesconto.getText());
            System.out.println("Preço Final: " + ctx.sendEmail().valorFinal.getText());
        } else {
            System.out.println("Decisao: " + ctx.sendEmail().decisao.getText());
            System.out.println("Desconto: " + ctx.sendEmail().desconto.getText());
        }
        return 0.0;
    }

}