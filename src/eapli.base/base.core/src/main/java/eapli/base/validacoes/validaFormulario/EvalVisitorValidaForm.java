package eapli.base.validacoes.validaFormulario;

public class EvalVisitorValidaForm extends validaFormBaseVisitor<String> {

    @Override
    public String visitValido(validaFormParser.ValidoContext ctx) {
        System.out.println("Formulario: " + ctx.getText());
        int i, contador = 0;
        for (i = 0; i < ctx.atributo().size(); i++) {
            if (visit(ctx.atributo(i)) == "invalido") {
                contador++;
            }
        }

        if (contador > 0) {
            return "invalido";
        }
        return "valido";
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
        String retorno = "Data inválida";
        System.out.println("Variavel Data: " + ctx.getText());
        int dia = Integer.parseInt(ctx.dia.getText());
        int mes = Integer.parseInt(ctx.mes.getText());
        if (0 < mes && mes < 13 && 0 < dia && dia < 32) {
            retorno = "Data válida!";
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
                return "invalido";
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
        String variavel = visit(ctx.var);

        switch (ctx.tp.getText()) {
            case "INTEGER":
                if (!variavel.matches("[0-9]+")) {
                    System.out.println("cc");
                    System.out.println("Nome de variavel nao tem formato Integer!");
                    flag = "invalido";
                }
                break;
            case "STRING":
                if (!variavel.matches("[A-Z]?[a-z]+")) {
                    System.out.println("Nome de variavel nao tem formato String!");
                    flag = "invalido";
                }
                break;
            case "DATA":
                if (variavel.equalsIgnoreCase("Data válida!")) {
                    if (!ctx.var.getText().matches("^\\d{4}/\\d{2}/\\d{2}$") &&
                            !ctx.var.getText().matches("^\\d{4}/\\d{1}/\\d{1}$")
                            && !ctx.var.getText().matches("^\\d{4}/\\d{2}/\\d{1}$")
                            && !ctx.var.getText().matches("^\\d{4}/\\d{1}/\\d{2}$")) {
                        System.out.println("Nome de variavel nao tem formato Data!");
                        flag = "invalido";
                    }
                } else{
                    flag = "invalido";
                }
                break;
            case "BOOLEAN":
                if (!variavel.equalsIgnoreCase("true") && !variavel.equalsIgnoreCase("false")) {
                    System.out.println("Nome de variavel nao tem formato Boolean!");
                    flag = "invalido";
                }
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + ctx.tp.getText());
        }

        System.out.println("Atributo " + flag);
        return flag;
    }
}

