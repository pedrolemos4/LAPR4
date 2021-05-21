// Generated from C:/Users/josec/Desktop/LPROG IMPORTANTE/src/validarFormulario\validarFormulario.g4 by ANTLR 4.9.1
package eapli.base.validacoes.validarFormulario;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link validarFormularioParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface validarFormularioVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code valido}
	 * labeled alternative in {@link validarFormularioParser#regra}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValido(validarFormularioParser.ValidoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code invalido}
	 * labeled alternative in {@link validarFormularioParser#regra}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInvalido(validarFormularioParser.InvalidoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code vazio}
	 * labeled alternative in {@link validarFormularioParser#regra}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVazio(validarFormularioParser.VazioContext ctx);
	/**
	 * Visit a parse tree produced by the {@code invalido2}
	 * labeled alternative in {@link validarFormularioParser#atributo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInvalido2(validarFormularioParser.Invalido2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code vazio2}
	 * labeled alternative in {@link validarFormularioParser#atributo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVazio2(validarFormularioParser.Vazio2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code valido2}
	 * labeled alternative in {@link validarFormularioParser#atributo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValido2(validarFormularioParser.Valido2Context ctx);
}