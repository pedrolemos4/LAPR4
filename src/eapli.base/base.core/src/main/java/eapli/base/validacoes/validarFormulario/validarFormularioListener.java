// Generated from C:/Users/josec/Desktop/LPROG IMPORTANTE/src/validarFormulario\validarFormulario.g4 by ANTLR 4.9.1
package eapli.base.validacoes.validarFormulario;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link validarFormularioParser}.
 */
public interface validarFormularioListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code valido}
	 * labeled alternative in {@link validarFormularioParser#regra}.
	 * @param ctx the parse tree
	 */
	void enterValido(validarFormularioParser.ValidoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valido}
	 * labeled alternative in {@link validarFormularioParser#regra}.
	 * @param ctx the parse tree
	 */
	void exitValido(validarFormularioParser.ValidoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code invalido}
	 * labeled alternative in {@link validarFormularioParser#regra}.
	 * @param ctx the parse tree
	 */
	void enterInvalido(validarFormularioParser.InvalidoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code invalido}
	 * labeled alternative in {@link validarFormularioParser#regra}.
	 * @param ctx the parse tree
	 */
	void exitInvalido(validarFormularioParser.InvalidoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code vazio}
	 * labeled alternative in {@link validarFormularioParser#regra}.
	 * @param ctx the parse tree
	 */
	void enterVazio(validarFormularioParser.VazioContext ctx);
	/**
	 * Exit a parse tree produced by the {@code vazio}
	 * labeled alternative in {@link validarFormularioParser#regra}.
	 * @param ctx the parse tree
	 */
	void exitVazio(validarFormularioParser.VazioContext ctx);
	/**
	 * Enter a parse tree produced by the {@code invalido2}
	 * labeled alternative in {@link validarFormularioParser#atributo}.
	 * @param ctx the parse tree
	 */
	void enterInvalido2(validarFormularioParser.Invalido2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code invalido2}
	 * labeled alternative in {@link validarFormularioParser#atributo}.
	 * @param ctx the parse tree
	 */
	void exitInvalido2(validarFormularioParser.Invalido2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code vazio2}
	 * labeled alternative in {@link validarFormularioParser#atributo}.
	 * @param ctx the parse tree
	 */
	void enterVazio2(validarFormularioParser.Vazio2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code vazio2}
	 * labeled alternative in {@link validarFormularioParser#atributo}.
	 * @param ctx the parse tree
	 */
	void exitVazio2(validarFormularioParser.Vazio2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code valido2}
	 * labeled alternative in {@link validarFormularioParser#atributo}.
	 * @param ctx the parse tree
	 */
	void enterValido2(validarFormularioParser.Valido2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code valido2}
	 * labeled alternative in {@link validarFormularioParser#atributo}.
	 * @param ctx the parse tree
	 */
	void exitValido2(validarFormularioParser.Valido2Context ctx);
}