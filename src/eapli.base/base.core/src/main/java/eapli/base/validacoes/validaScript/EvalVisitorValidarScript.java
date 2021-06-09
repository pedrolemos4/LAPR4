package eapli.base.validacoes.validaScript;

public class EvalVisitorValidarScript extends validarScriptBaseVisitor {
    public Object visitValido(validarScriptParser.ValidoContext ctx) {
        System.out.println("Atividade Válida!");
        return visitChildren(ctx);
    }

    public Object visitInvalido(validarScriptParser.InvalidoContext ctx) {
        System.out.println("Atividade Inválida!");
        return visitChildren(ctx);
    }

    public Object visitValido2(validarScriptParser.Valido2Context ctx) {
        System.out.println("Atividade Válida!");
        return visitChildren(ctx);
    }

    public Object visitInvalido2(validarScriptParser.Invalido2Context ctx) {
        System.out.println("Atividade Inválida!");
        return visitChildren(ctx);
    }

    public Object visitVazio(validarScriptParser.VazioContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitVazio2(validarScriptParser.Vazio2Context ctx) {
        return visitChildren(ctx);
    }

    public Object visitVazio3(validarScriptParser.Vazio3Context ctx) {
        return visitChildren(ctx);
    }
}
