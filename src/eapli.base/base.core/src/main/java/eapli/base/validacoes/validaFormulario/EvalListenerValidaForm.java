package eapli.base.validacoes.validaFormulario;

public class EvalListenerValidaForm extends validaFormBaseListener {

    @Override
    public void enterValido(validaFormParser.ValidoContext ctx) {
        System.out.println("Formulário válido");
    }

    @Override
    public void exitValido(validaFormParser.ValidoContext ctx) {
        System.out.println("Formulário válido");
    }

    @Override
    public void enterInvalido(validaFormParser.InvalidoContext ctx) {
        System.out.println("Formulário inválido");
    }

    @Override
    public void exitInvalido(validaFormParser.InvalidoContext ctx) {
        System.out.println("Formulário inválido");
    }

    @Override
    public void enterVazio(validaFormParser.VazioContext ctx) {
        System.out.println("Campo Vazio");
    }

    @Override
    public void exitVazio(validaFormParser.VazioContext ctx) {
        System.out.println("Campo Vazio");
    }

    @Override
    public void enterInvalido2(validaFormParser.Invalido2Context ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitInvalido2(validaFormParser.Invalido2Context ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterVazio1(validaFormParser.Vazio1Context ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitVazio1(validaFormParser.Vazio1Context ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterValido2(validaFormParser.Valido2Context ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitValido2(validaFormParser.Valido2Context ctx) {
    }
}
