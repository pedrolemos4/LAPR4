package eapli.base.validacoes.validaFormulario;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.Stack;

public class EvalListenerValidaForm extends validaFormBaseListener {

    private final Stack<String> stack = new Stack<>();

    @Override
    public void enterValido(validaFormParser.ValidoContext ctx) {
        //System.out.println("Formulário válido.");
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
        System.out.println("Campo Vazio1.");
    }

    @Override
    public void exitVazio(validaFormParser.VazioContext ctx) {
        System.out.println("Campo Vazio1.");
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
        System.out.println("Enter Campo Vazio1.");
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitVazio1(validaFormParser.Vazio1Context ctx) {
        System.out.println("Exit Campo Vazio1.");
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterValido2(validaFormParser.Valido2Context ctx) {

        if (ctx.obr.getText().equalsIgnoreCase("OBRIGATORIO")) {
            if (ctx.var.getText().isEmpty() || ctx.var.getText() == null) {
                System.out.println("Variável é Obrigatória!");
                try {
                    throw new Exception();
                } catch (Exception e) {
                    e.addSuppressed(e);
                }
            } else {
                validaVariavel(ctx);
            }
        } else if (ctx.obr.getText().equalsIgnoreCase("OPCIONAL") && !ctx.var.getText().isEmpty()) {
            validaVariavel(ctx);
        } else {
            stack.push("Variável vazia");
        }
    }

    public void validaVariavel(validaFormParser.Valido2Context ctx) {
        switch (ctx.tp.getText()) {
            case "INTEGER":
                if (!ctx.var.getText().matches("[0-9]|[1-9][0-9]+")) {
                    System.out.println("Nome de variavel nao tem formato Integer!");
                    try {
                        throw new Exception();
                    } catch (Exception e) {
                        e.addSuppressed(e);
                    }
                }
                break;
            case "STRING":
                if (!ctx.var.getText().matches("[A-Z][a-z]+")) {
                    System.out.println("Nome de variavel nao tem formato String!");
                    try {
                        throw new Exception();
                    } catch (Exception e) {
                        e.addSuppressed(e);
                    }
                }
                break;
            case "DATA":
                if (!ctx.var.getText().matches("^\\d{4}/\\d{2}/\\d{2}$") &&
                        !ctx.var.getText().matches("^\\d{4}/\\d{1}/\\d{1}$")
                        && !ctx.var.getText().matches("^\\d{4}/\\d{2}/\\d{1}$")
                        && !ctx.var.getText().matches("^\\d{4}/\\d{1}/\\d{2}$")) {

                    System.out.println("Nome de variavel nao tem formato Data!");
                    try {
                        throw new Exception();
                    } catch (Exception e) {
                        e.addSuppressed(e);
                    }
                }
                break;
            case "BOOLEAN":
                if (!ctx.var.getText().equalsIgnoreCase("true") && !ctx.var.getText().equalsIgnoreCase("false")) {
                    System.out.println("Nome de variavel nao tem formato Boolean!");
                    try {
                        throw new Exception();
                    } catch (Exception e) {
                        e.addSuppressed(e);
                    }
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + ctx.tp.getText());
        }

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitValido2(validaFormParser.Valido2Context ctx) {
        System.out.println(stack.pop());
    }

///    ///

    @Override
    public void enterValidoString(validaFormParser.ValidoStringContext ctx) {
        if (!ctx.getText().matches("[A-Z][a-z]+")) {
            System.out.println("Nome de variavel nao tem formato String!");
        }
    }

    @Override
    public void enterValidoBoolean(validaFormParser.ValidoBooleanContext ctx) {
        if (!ctx.getText().equalsIgnoreCase("true") && !ctx.getText().equalsIgnoreCase("false")) {
            System.out.println("Nome de variavel nao tem formato Boolean!");
        }
    }

    public void exitValidoBoolean(validaFormParser.ValidoBooleanContext ctx) {
        stack.push("Atributo válido");
    }

    @Override
    public void exitValidoString(validaFormParser.ValidoStringContext ctx) {
        stack.push("Atributo válido");
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterValidoInteger(validaFormParser.ValidoIntegerContext ctx) {
        if (!ctx.getText().matches("[0-9]+")) {
            System.out.println("Nome de variavel nao tem formato Integer!");
        }
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitValidoInteger(validaFormParser.ValidoIntegerContext ctx) {
        stack.push("Atributo válido.");
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterValidoData(validaFormParser.ValidoDataContext ctx) {
        int dia = Integer.parseInt(ctx.dia.getText());
        int mes = Integer.parseInt(ctx.mes.getText());
        if (mes <= 0 || mes >= 13 || dia <= 0 || dia >= 32) {
            System.out.println("Data inválida");
            try {
                throw new Exception();
            } catch (Exception e) {
                e.addSuppressed(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitValidoData(validaFormParser.ValidoDataContext ctx) {
        stack.push("Atributo válido");
    }

}
