package eapli.base.validacoes.valida;

public class EvalVisitorValidaForm extends validaFormBaseVisitor {

    @Override
    public Object visitValido(validaFormParser.ValidoContext ctx) {
        System.out.println("Formulário Válido!");
        return visitChildren(ctx);
    }

    @Override
    public Object visitInvalido(validaFormParser.InvalidoContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitVazio(validaFormParser.VazioContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitInvalido2(validaFormParser.Invalido2Context ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitVazio2(validaFormParser.Vazio2Context ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitValidoString(validaFormParser.ValidoStringContext ctx) {
        return ctx.getText();
    }

    @Override
    public String visitValidoData(validaFormParser.ValidoDataContext ctx) {
        return ctx.getText();
    }

    @Override
    public Integer visitValidoInteger(validaFormParser.ValidoIntegerContext ctx) {
        return Integer.parseInt(ctx.getText());
    }

    @Override
    public Object visitValidoBoolean(validaFormParser.ValidoBooleanContext ctx) {
        return Boolean.parseBoolean(ctx.getText());
    }

    @Override
    public Object visitValido2(validaFormParser.Valido2Context ctx) {
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
                ;
            /*case "BOOLEAN" :
                if(!ctx.var.getText().matches("[0-9][0-9][0-9][0-9]'/'('0'[1-9]|'1'[0-2])'/'('0'[1-9]|[1-2][0-9]|'3'[0-1])")){
                    System.out.println("Nome de variavel nao tem formato Data!");
                };*/

        }

        // checkar apenas se for campo obrigatorio nada pode estar a null
        if (ctx.obr.getText().equalsIgnoreCase("OBRIGATORIO")) {
            if (ctx.var.getText().isEmpty() || ctx.var.getText() == null) {
                System.out.println("Nome da variável é Obrigatória!");
            } else if (ctx.des.getText().isEmpty() || ctx.des.getText() == null) {
                System.out.println("Descrição Ajuda é Obrigatória!");
            } else if (ctx.label.getText().isEmpty() || ctx.label.getText() == null) {
                System.out.println("Label é Obrigatória!");
            }
        }
        return visitChildren(ctx);
    }
}
