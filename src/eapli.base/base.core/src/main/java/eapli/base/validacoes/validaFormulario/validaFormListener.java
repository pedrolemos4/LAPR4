// Generated from C:/Users/Tiago/Desktop/LAPR4/lei20_21_s4_2di_04/src/eapli.base/base.core/src/main/java/eapli/base/validacoes/validaFormulario\validaForm.g4 by ANTLR 4.9.1
package eapli.base.validacoes.validaFormulario;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link validaFormParser}.
 */
public interface validaFormListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code valido}
	 * labeled alternative in {@link validaFormParser#regra}.
	 * @param ctx the parse tree
	 */
	void enterValido(validaFormParser.ValidoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valido}
	 * labeled alternative in {@link validaFormParser#regra}.
	 * @param ctx the parse tree
	 */
	void exitValido(validaFormParser.ValidoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code invalido}
	 * labeled alternative in {@link validaFormParser#regra}.
	 * @param ctx the parse tree
	 */
	void enterInvalido(validaFormParser.InvalidoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code invalido}
	 * labeled alternative in {@link validaFormParser#regra}.
	 * @param ctx the parse tree
	 */
	void exitInvalido(validaFormParser.InvalidoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code vazio}
	 * labeled alternative in {@link validaFormParser#regra}.
	 * @param ctx the parse tree
	 */
	void enterVazio(validaFormParser.VazioContext ctx);
	/**
	 * Exit a parse tree produced by the {@code vazio}
	 * labeled alternative in {@link validaFormParser#regra}.
	 * @param ctx the parse tree
	 */
	void exitVazio(validaFormParser.VazioContext ctx);
	/**
	 * Enter a parse tree produced by the {@code invalido2}
	 * labeled alternative in {@link validaFormParser#atributo}.
	 * @param ctx the parse tree
	 */
	void enterInvalido2(validaFormParser.Invalido2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code invalido2}
	 * labeled alternative in {@link validaFormParser#atributo}.
	 * @param ctx the parse tree
	 */
	void exitInvalido2(validaFormParser.Invalido2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code vazio1}
	 * labeled alternative in {@link validaFormParser#atributo}.
	 * @param ctx the parse tree
	 */
	void enterVazio1(validaFormParser.Vazio1Context ctx);
	/**
	 * Exit a parse tree produced by the {@code vazio1}
	 * labeled alternative in {@link validaFormParser#atributo}.
	 * @param ctx the parse tree
	 */
	void exitVazio1(validaFormParser.Vazio1Context ctx);
	/**
	 * Enter a parse tree produced by the {@code valido2}
	 * labeled alternative in {@link validaFormParser#atributo}.
	 * @param ctx the parse tree
	 */
	void enterValido2(validaFormParser.Valido2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code valido2}
	 * labeled alternative in {@link validaFormParser#atributo}.
	 * @param ctx the parse tree
	 */
	void exitValido2(validaFormParser.Valido2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code validoString}
	 * labeled alternative in {@link validaFormParser#nome}.
	 * @param ctx the parse tree
	 */
	void enterValidoString(validaFormParser.ValidoStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code validoString}
	 * labeled alternative in {@link validaFormParser#nome}.
	 * @param ctx the parse tree
	 */
	void exitValidoString(validaFormParser.ValidoStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code validoInteger}
	 * labeled alternative in {@link validaFormParser#nome}.
	 * @param ctx the parse tree
	 */
	void enterValidoInteger(validaFormParser.ValidoIntegerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code validoInteger}
	 * labeled alternative in {@link validaFormParser#nome}.
	 * @param ctx the parse tree
	 */
	void exitValidoInteger(validaFormParser.ValidoIntegerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code validoData}
	 * labeled alternative in {@link validaFormParser#nome}.
	 * @param ctx the parse tree
	 */
	void enterValidoData(validaFormParser.ValidoDataContext ctx);
	/**
	 * Exit a parse tree produced by the {@code validoData}
	 * labeled alternative in {@link validaFormParser#nome}.
	 * @param ctx the parse tree
	 */
	void exitValidoData(validaFormParser.ValidoDataContext ctx);
	/**
	 * Enter a parse tree produced by the {@code validoDesc}
	 * labeled alternative in {@link validaFormParser#desc}.
	 * @param ctx the parse tree
	 */
	void enterValidoDesc(validaFormParser.ValidoDescContext ctx);
	/**
	 * Exit a parse tree produced by the {@code validoDesc}
	 * labeled alternative in {@link validaFormParser#desc}.
	 * @param ctx the parse tree
	 */
	void exitValidoDesc(validaFormParser.ValidoDescContext ctx);
}