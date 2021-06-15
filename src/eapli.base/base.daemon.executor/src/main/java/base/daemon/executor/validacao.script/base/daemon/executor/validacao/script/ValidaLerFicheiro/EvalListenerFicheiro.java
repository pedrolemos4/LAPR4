package base.daemon.executor.validacao.script.base.daemon.executor.validacao.script.ValidaLerFicheiro;

import java.util.Stack;

public class EvalListenerFicheiro extends ValidaLerFicheiroBaseListener {

    private int id;

    public EvalListenerFicheiro(int id) {
        this.id = id;
    }

    private final Stack<String> stack = new Stack<>();

    public String getResult() {
        return stack.peek();
    }

    public void enterProg(ValidaLerFicheiroParser.ProgContext ctx) {

    }

    public void exitProg(ValidaLerFicheiroParser.ProgContext ctx) {

    }

    public void enterStart(ValidaLerFicheiroParser.StartContext ctx) {

    }

    public void exitStart(ValidaLerFicheiroParser.StartContext ctx) {

    }

    public void enterInfoProduto(ValidaLerFicheiroParser.InfoProdutoContext ctx) {
        stack.push(ctx.codigo.getText());
        stack.push(ctx.preco.getText());
        stack.push(ctx.categoria.getText());
    }

    public void exitInfoProduto(ValidaLerFicheiroParser.InfoProdutoContext ctx) {
        int codigo = Integer.valueOf(stack.pop());
        String preco = stack.pop();
        String categoria = stack.pop();
        if (this.id == codigo) {
            System.out.println("Codigo: " + codigo);
            System.out.printf("Preco: " + preco);
            System.out.println("Categoria: " + categoria);
        }
    }

    public void enterInfoCliente(ValidaLerFicheiroParser.InfoClienteContext ctx) {
        stack.push(ctx.numero.getText());
        stack.push(ctx.escalao.getText());
    }

    public void exitInfoCliente(ValidaLerFicheiroParser.InfoClienteContext ctx) {
        int numero = Integer.valueOf(stack.pop());
        String escalao = stack.pop();
        if (this.id == numero) {
            System.out.println("Numero: " + numero);
            System.out.println("Escalao: " + escalao);
        }
    }
}
