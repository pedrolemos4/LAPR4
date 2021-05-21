// Generated from C:/Users/josec/Desktop/LPROG IMPORTANTE/src/validarAtividade\validarAtividade.g4 by ANTLR 4.9.1
package eapli.base.validacoes.validarAtividade;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link validarAtividadeParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface validarAtividadeVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code atvManual}
	 * labeled alternative in {@link validarAtividadeParser#regra}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtvManual(validarAtividadeParser.AtvManualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atvAuto}
	 * labeled alternative in {@link validarAtividadeParser#regra}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtvAuto(validarAtividadeParser.AtvAutoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code vazio}
	 * labeled alternative in {@link validarAtividadeParser#regra}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVazio(validarAtividadeParser.VazioContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valido}
	 * labeled alternative in {@link validarAtividadeParser#atv_manu}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValido(validarAtividadeParser.ValidoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code invalido}
	 * labeled alternative in {@link validarAtividadeParser#atv_manu}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInvalido(validarAtividadeParser.InvalidoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code vazio2}
	 * labeled alternative in {@link validarAtividadeParser#atv_manu}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVazio2(validarAtividadeParser.Vazio2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code valido2}
	 * labeled alternative in {@link validarAtividadeParser#atv_auto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValido2(validarAtividadeParser.Valido2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code invalido2}
	 * labeled alternative in {@link validarAtividadeParser#atv_auto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInvalido2(validarAtividadeParser.Invalido2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code vazio3}
	 * labeled alternative in {@link validarAtividadeParser#atv_auto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVazio3(validarAtividadeParser.Vazio3Context ctx);
}