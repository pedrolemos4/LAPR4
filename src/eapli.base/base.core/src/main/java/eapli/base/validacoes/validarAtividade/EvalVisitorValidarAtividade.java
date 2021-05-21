package eapli.base.validacoes.validarAtividade;

public class EvalVisitorValidarAtividade extends validarAtividadeBaseVisitor {
    public Object visitValido(validarAtividadeParser.ValidoContext ctx) {
        System.out.println("Atividade Válida!");
        return visitChildren(ctx);
    }

    public Object visitInvalido(validarAtividadeParser.InvalidoContext ctx) {
        System.out.println("Atividade Inválida!");
        return visitChildren(ctx);
    }

    public Object visitValido2(validarAtividadeParser.Valido2Context ctx) {
        System.out.println("Atividade Válida!");
        return visitChildren(ctx);
    }

    public Object visitInvalido2(validarAtividadeParser.Invalido2Context ctx) {
        System.out.println("Atividade Inválida!");
        return visitChildren(ctx);
    }

    public Object visitVazio(validarAtividadeParser.VazioContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitVazio2(validarAtividadeParser.Vazio2Context ctx) {
        return visitChildren(ctx);
    }

    public Object visitVazio3(validarAtividadeParser.Vazio3Context ctx) {
        return visitChildren(ctx);
    }
}
