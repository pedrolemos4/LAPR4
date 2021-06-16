package eapli.base.validacoes.validaFormulario;

public class EvalListenerValidaForm extends validaFormBaseListener {

    @Override
    public void enterValido(validaFormParser.ValidoContext ctx) {
        System.out.println("Formulário válido.");
    }

    @Override
    public void exitValido(validaFormParser.ValidoContext ctx) {
        System.out.println("Formulário válido.");
    }

    @Override
    public void enterInvalido(validaFormParser.InvalidoContext ctx) {
        System.out.println("Formulário inválido.");
    }

    @Override
    public void exitInvalido(validaFormParser.InvalidoContext ctx) {
        System.out.println("Formulário inválido.");
    }

    @Override
    public void enterVazio(validaFormParser.VazioContext ctx) {
        System.out.println("Campo Vazio.");
    }

    @Override
    public void exitVazio(validaFormParser.VazioContext ctx) {
        System.out.println("Campo Vazio.");
    }

    @Override
    public void enterInvalido2(validaFormParser.Invalido2Context ctx) {
        System.out.println("Atributo incompleto.");
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitInvalido2(validaFormParser.Invalido2Context ctx) {
        System.out.println("Atributo incompleto.");
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterVazio1(validaFormParser.Vazio1Context ctx) {
        System.out.println("Campo Vazio.");
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitVazio1(validaFormParser.Vazio1Context ctx) {
        System.out.println("Campo Vazio.");
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterValido2(validaFormParser.Valido2Context ctx) {
        switch (ctx.tp.getText()) {
            case "INTEGER":
                if (!ctx.var.getText().matches("[0-9]|[1-9][0-9]+")) {
                    System.out.println("Nome de variavel nao tem formato Integer!");
                }
                ;
            case "STRING":
                if (!ctx.var.getText().matches("[A-Z][a-z]+")) {
                    System.out.println("Nome de variavel nao tem formato String!");
                }
                ;
            case "DATA":
                if (!ctx.var.getText().matches("[0-9][0-9][0-9][0-9]'/'('0'[1-9]|'1'[0-2])'/'('0'[1-9]|[1-2][0-9]|'3'[0-1])")) {
                    System.out.println("Nome de variavel nao tem formato Data!");
                }
        }
    }

        /**
         * {@inheritDoc}
         *
         * <p>The default implementation does nothing.</p>
         */
        @Override
        public void exitValido2 (validaFormParser.Valido2Context ctx){
            System.out.println("Atributo válido.");
        }
    }
