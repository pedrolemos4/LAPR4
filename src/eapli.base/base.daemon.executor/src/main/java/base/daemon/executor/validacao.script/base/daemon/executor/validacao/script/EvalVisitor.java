package base.daemon.executor.validacao.script.base.daemon.executor.validacao.script;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EvalVisitor extends ValidaScriptBaseVisitor<Integer> {

    private int code;

    private int preco;

    private String parametroLerFicheiro;

    private Map<String, Integer> map = new HashMap<>();

    @Override
    public Integer visitFicheiro(ValidaScriptParser.FicheiroContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitPath(ValidaScriptParser.PathContext ctx) {
        return visitChildren(ctx);
    }

    //--------------------------------LER FICHEIRO--------------------------------//
    @Override
    public Integer visitInfoProduto(ValidaScriptParser.InfoProdutoContext ctx) {
        if (code == Integer.parseInt(ctx.codigo.getText())) {
            this.preco = Integer.parseInt(ctx.preco.getText());
            System.out.println("Preco atr: " + preco);
            if (parametroLerFicheiro != null) {
                if (parametroLerFicheiro.equals("Preco")) {
                    System.out.println("Preco: " + ctx.preco.getText());
                    this.parametroLerFicheiro = null;
                    return 1;
                } else if (parametroLerFicheiro.equals("Categoria")) {
                    System.out.println("Categoria: " + ctx.categoria.getText());
                    this.parametroLerFicheiro = null;
                    return 1;
                }
            } else {
                System.out.println("Codigo: " + ctx.codigo.getText());
                System.out.println("Preco: " + ctx.preco.getText());
                System.out.println("Categoria: " + ctx.categoria.getText());
                return 1;
            }
        }
        return 0;
    }

    @Override
    public Integer visitInfoCliente(ValidaScriptParser.InfoClienteContext ctx) {
        if (code == Integer.parseInt(ctx.numero.getText())) {
            if (parametroLerFicheiro != null) {
                if (parametroLerFicheiro.equals("Escalao")) {
                    System.out.println("Escalao: " + ctx.escalao.getText());
                    this.parametroLerFicheiro = null;
                    return 1;
                }
            } else {
                System.out.println("Numero: " + ctx.numero.getText());
                System.out.println("Escalao: " + ctx.escalao.getText());
                return 1;
            }
        }
        return 0;
    }

    @Override
    public Integer visitLerFicheiro(ValidaScriptParser.LerFicheiroContext ctx) {
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
        return 0;
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
    public Integer visitAtribuir(ValidaScriptParser.AtribuirContext ctx) {
        String id = ctx.nameVar().getText();
        int value = visit(ctx.calculosMatematicos());
        System.out.println("ID: " + id + " Value: " + value);
        map.put(id, value);
        return 0;
    }

    @Override
    public Integer visitProprioValor(ValidaScriptParser.ProprioValorContext ctx) {
        return Integer.parseInt(ctx.INTEIRO().getText());
    }

    @Override
    public Integer visitVariavel(ValidaScriptParser.VariavelContext ctx) {
        String id = ctx.nameVar().getText();
        if (map.containsKey(id)) {
            return map.get(id);
        }
        return 0;
    }

    @Override
    public Integer visitMultiDiv(ValidaScriptParser.MultiDivContext ctx) {
        int right, left;
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
    public Integer visitSomaSub(ValidaScriptParser.SomaSubContext ctx) {
        int right, left;
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
    public Integer visitParenteses(ValidaScriptParser.ParentesesContext ctx) {
        return visit(ctx.calculosMatematicos());
    }


    @Override
    public Integer visitCalcPrecoTotal(ValidaScriptParser.CalcPrecoTotalContext ctx) {
        System.out.println("Entra com preco a: " + preco);
        System.out.println("Quantidade: " + ctx.quantidade.getText());
        int quantidade = Integer.parseInt(ctx.quantidade.getText());
        if (quantidade > 0 && preco > 0) {
            int total = preco * quantidade;
            System.out.println("Preco total: " + total);
            map.put(ctx.var.getText(), total);
            return 1;
        }
        return 0;
    }

//--------------------------------APLICAR DESCONTOS--------------------------------//

}