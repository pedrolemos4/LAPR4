// Generated from C:/Users/josec/Documents/lei20_21_s4_2di_04/src/eapli.base/base.core/src/main/java/eapli/base/validacoes/validaScript\validarScript.g4 by ANTLR 4.9.1
package eapli.base.validacoes.validaScript;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link validarScriptParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface validarScriptVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code atvManual}
	 * labeled alternative in {@link validarScriptParser#regra}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtvManual(validarScriptParser.AtvManualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atvAuto}
	 * labeled alternative in {@link validarScriptParser#regra}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtvAuto(validarScriptParser.AtvAutoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code vazio}
	 * labeled alternative in {@link validarScriptParser#regra}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVazio(validarScriptParser.VazioContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valido}
	 * labeled alternative in {@link validarScriptParser#atv_manu}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValido(validarScriptParser.ValidoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code invalido}
	 * labeled alternative in {@link validarScriptParser#atv_manu}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInvalido(validarScriptParser.InvalidoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code vazio2}
	 * labeled alternative in {@link validarScriptParser#atv_manu}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVazio2(validarScriptParser.Vazio2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code valido2}
	 * labeled alternative in {@link validarScriptParser#atv_auto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValido2(validarScriptParser.Valido2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code invalido2}
	 * labeled alternative in {@link validarScriptParser#atv_auto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInvalido2(validarScriptParser.Invalido2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code vazio3}
	 * labeled alternative in {@link validarScriptParser#atv_auto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVazio3(validarScriptParser.Vazio3Context ctx);
}