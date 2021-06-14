package base.daemon.executor.validacao.script.base.daemon.executor.validacao.script.ValidaLerFicheiro;

public class EvalVisitorFicheiro extends ValidaLerFicheiroBaseVisitor {

    private int id;

    public EvalVisitorFicheiro(int id) {
        this.id = id;
    }

    @Override
    public Object visitProg(ValidaLerFicheiroParser.ProgContext ctx) {
        return visitChildren(ctx);
    }


    @Override
    public Object visitStart(ValidaLerFicheiroParser.StartContext ctx) {
        return visitChildren(ctx);
    }


    @Override
    public Object visitInfoProduto(ValidaLerFicheiroParser.InfoProdutoContext ctx) {
        if (this.id == Integer.parseInt(ctx.codigo.getText())) {
            System.out.println("Codigo: "+ctx.codigo.getText());
            System.out.printf("Preco: "+ctx.preco.getText());
            System.out.println("Categoria: "+ctx.categoria.getText());
        }
        return visitChildren(ctx);
    }


    @Override
    public Object visitInfoCliente(ValidaLerFicheiroParser.InfoClienteContext ctx) {
        if (this.id == Integer.parseInt(ctx.numero.getText())) {
            System.out.println("Numero: " + ctx.numero.getText());
            System.out.println("Escalao: " + ctx.escalao.getText());
        }
        return visitChildren(ctx);
    }

}
