// Generated from D:/2ANO/2SEMESTRE/LAPR4/LAPR4_PROJETO/src/eapli.base/base.core/src/main/java/eapli/base/validacoes/valida\validaForm.g4 by ANTLR 4.9.1
package eapli.base.validacoes.valida;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link validaFormParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface validaFormVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code valido}
	 * labeled alternative in {@link validaFormParser#regra}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValido(validaFormParser.ValidoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code invalido}
	 * labeled alternative in {@link validaFormParser#regra}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInvalido(validaFormParser.InvalidoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code vazio}
	 * labeled alternative in {@link validaFormParser#regra}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVazio(validaFormParser.VazioContext ctx);
	/**
	 * Visit a parse tree produced by the {@code invalido2}
	 * labeled alternative in {@link validaFormParser#atributo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInvalido2(validaFormParser.Invalido2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code vazio1}
	 * labeled alternative in {@link validaFormParser#atributo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVazio1(validaFormParser.Vazio1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code valido2}
	 * labeled alternative in {@link validaFormParser#atributo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValido2(validaFormParser.Valido2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code validoString}
	 * labeled alternative in {@link validaFormParser#nome}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValidoString(validaFormParser.ValidoStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code validoInteger}
	 * labeled alternative in {@link validaFormParser#nome}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValidoInteger(validaFormParser.ValidoIntegerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code validoData}
	 * labeled alternative in {@link validaFormParser#nome}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValidoData(validaFormParser.ValidoDataContext ctx);
	/**
	 * Visit a parse tree produced by the {@code vazio2}
	 * labeled alternative in {@link validaFormParser#nome}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVazio2(validaFormParser.Vazio2Context ctx);
}