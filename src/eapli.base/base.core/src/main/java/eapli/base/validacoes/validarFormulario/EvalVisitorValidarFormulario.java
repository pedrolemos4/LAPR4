package eapli.base.validacoes.validarFormulario;

public class EvalVisitorValidarFormulario extends validarFormularioBaseVisitor {
    public Object visitValido(validarFormularioParser.ValidoContext ctx) {
        System.out.println("Formulário Válido!");
        return visitChildren(ctx);
    }

    public Object visitInvalido(validarFormularioParser.InvalidoContext ctx) {
        System.out.println("Formulário Inválido!");
        return visitChildren(ctx);
    }

    public Object visitValido2(validarFormularioParser.Valido2Context ctx) {
        System.out.println("Atributo Válido!");
        return visitChildren(ctx);
    }

    public Object visitInvalido2(validarFormularioParser.Invalido2Context ctx) {
        System.out.println("Atributo Inválido!");
        return visitChildren(ctx);
    }

    public Object visitVazio(validarFormularioParser.VazioContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitVazio2(validarFormularioParser.Vazio2Context ctx) {
        return visitChildren(ctx);
    }
}
