package eapli.base.validacoes.validaFormulario;

public class EvalVisitorValidaForm extends validaFormBaseVisitor<String> {

    @Override
    public String visitValido(validaFormParser.ValidoContext ctx) {
        System.out.println("Formulario: " + ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public String visitInvalido(validaFormParser.InvalidoContext ctx) {
        System.out.println("Invalido");
        return ctx.getText();
    }

    @Override
    public String visitVazio(validaFormParser.VazioContext ctx) {
        System.out.println("Vazio");
        return ctx.getText();
    }

    @Override
    public String visitVazio1(validaFormParser.Vazio1Context ctx) {
        System.out.println("Vazio1");
        return ctx.getText();
    }

    @Override
    public String visitInvalido2(validaFormParser.Invalido2Context ctx) {
        System.out.println("Invalido");
        return ctx.getText();
    }

    @Override
    public String visitValidoString(validaFormParser.ValidoStringContext ctx) {
        String value = ctx.getText();
        System.out.println("Variavel String: " + value);
        return value;
    }


    @Override
    public String visitValidoInteger(validaFormParser.ValidoIntegerContext ctx) {
        int value = Integer.parseInt(ctx.getText());
        System.out.println("Variavel Integer: " + value);
        return ctx.getText();
    }

    @Override
    public String visitValidoData(validaFormParser.ValidoDataContext ctx) {
        String retorno;
        System.out.println("Linha 53");
        int dia = Integer.parseInt(ctx.dia.getText());
        int mes = Integer.parseInt(ctx.mes.getText());
        if (0 < mes && mes < 13 && 0 < dia && dia < 32) {
            retorno = "Data válida!";
        } else {
            retorno = "Data inválida";
        }
        return retorno;
    }

    @Override
    public String visitValidoBoolean(validaFormParser.ValidoBooleanContext ctx) {
        String value = ctx.getText();
        System.out.println("Variavel Boolean: " + value);
        return ctx.getText();
    }

    @Override
    public String visitValido2(validaFormParser.Valido2Context ctx) {
        String flag = "valido";
        if (ctx.obr.getText().equalsIgnoreCase("OBRIGATORIO")) {
            if (ctx.var.getText().isEmpty() || ctx.var.getText() == null) {
                System.out.println("Variável é Obrigatória!");
                flag = "invalido";
            } else {
                flag = validaVariavel(ctx);
            }
        } else if (ctx.obr.getText().equalsIgnoreCase("OPCIONAL") && !ctx.var.getText().isEmpty()) {
            flag = validaVariavel(ctx);
        }
        return flag;
    }

    public String validaVariavel(validaFormParser.Valido2Context ctx) {
        String flag = "valido";
        switch (ctx.tp.getText()) {
            case "INTEGER":
                System.out.println("VARINTEGER:: " + ctx.var.getText());
                if (!ctx.var.getText().matches("[0-9]|[1-9][0-9]+")) {
                    System.out.println("Nome de variavel nao tem formato Integer!");
                    flag = "invalido";
                }
                break;
            case "STRING":
                System.out.println("VAR:: " + ctx.var.getText());
                if (!ctx.var.getText().matches("[A-Z][a-z]+")) {
                    System.out.println("Nome de variavel nao tem formato String!");
                    flag = "invalido";
                }
                break;
            case "DATA":
                System.out.println("linha 104");

                if (!ctx.var.getText().matches("^\\d{4}/\\d{2}/\\d{2}$") &&
                        !ctx.var.getText().matches("^\\d{4}/\\d{1}/\\d{1}$")
                        && !ctx.var.getText().matches("^\\d{4}/\\d{2}/\\d{1}$")
                        && !ctx.var.getText().matches("^\\d{4}/\\d{1}/\\d{2}$")) {

                    System.out.println("Nome de variavel nao tem formato Data!");
                    flag = "invalido";
                }
                System.out.println(visitChildren(ctx.var));
                if (visitChildren(ctx.var).equalsIgnoreCase("Data inválida")) {
                    System.out.println("Data Invalida");
                    flag = "invalido";
                }

                break;
            case "BOOLEAN":
                if (!ctx.var.getText().equalsIgnoreCase("true") && !ctx.var.getText().equalsIgnoreCase("false")) {
                    System.out.println("Nome de variavel nao tem formato Boolean!");
                    flag = "invalido";
                }
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + ctx.tp.getText());
        }

        return flag;
    }
}

