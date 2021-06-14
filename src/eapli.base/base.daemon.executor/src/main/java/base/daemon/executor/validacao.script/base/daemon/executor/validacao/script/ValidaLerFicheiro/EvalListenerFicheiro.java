package base.daemon.executor.validacao.script.base.daemon.executor.validacao.script.ValidaLerFicheiro;

public class EvalListenerFicheiro {

    public void enterProg(ValidaLerFicheiroParser.ProgContext ctx) { //mudar os contexts em todos
        System.out.println("teste");
    }

    public void exitProg(ValidaLerFicheiroParser.ProgContext ctx) {
        System.out.println("teste");
    }

    public void enterStart(ValidaLerFicheiroParser.StartContext ctx) { //mudar os contexts em todos
        System.out.println("teste");
    }

    public void exitStart(ValidaLerFicheiroParser.StartContext ctx) {
        System.out.println("teste");
    }

    public void enterInfoProduto(ValidaLerFicheiroParser.InfoProdutoContext ctx) {
        System.out.println("teste");
    }

    public void exitInfoProduto(ValidaLerFicheiroParser.InfoProdutoContext ctx) {
        System.out.println("teste");
    }

    public void enterInfoCliente(ValidaLerFicheiroParser.InfoClienteContext ctx) {
        System.out.println("teste");
    }

    public void exitInfoCliente(ValidaLerFicheiroParser.InfoClienteContext ctx) {
        System.out.println("teste");
    }
}
