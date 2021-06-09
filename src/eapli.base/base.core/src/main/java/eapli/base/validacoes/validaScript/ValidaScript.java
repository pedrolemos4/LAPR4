package eapli.base.validacoes.validaScript;

public class ValidaScript {
    /*
    public boolean validaScript(File script) {
        try {
            FileInputStream file = new FileInputStream(script);
            validarAtividadeLexer lexer = new validarAtividadeLexer((new ANTLRInputStream(file)));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            validarAtividadeParser parser = new validarAtividadeParser(tokens);
            ParseTree tree = parser.regra();
            EvalVisitorValidarAtividade eval = new EvalVisitorValidarAtividade();
            eval.visit(tree);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

     */
}
