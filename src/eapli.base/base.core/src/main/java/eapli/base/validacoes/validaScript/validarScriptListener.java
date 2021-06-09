// Generated from C:/Users/josec/Documents/lei20_21_s4_2di_04/src/eapli.base/base.core/src/main/java/eapli/base/validacoes/validaScript\validarScript.g4 by ANTLR 4.9.1
package eapli.base.validacoes.validaScript;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link validarScriptParser}.
 */
public interface validarScriptListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code atvManual}
	 * labeled alternative in {@link validarScriptParser#regra}.
	 * @param ctx the parse tree
	 */
	void enterAtvManual(validarScriptParser.AtvManualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atvManual}
	 * labeled alternative in {@link validarScriptParser#regra}.
	 * @param ctx the parse tree
	 */
	void exitAtvManual(validarScriptParser.AtvManualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atvAuto}
	 * labeled alternative in {@link validarScriptParser#regra}.
	 * @param ctx the parse tree
	 */
	void enterAtvAuto(validarScriptParser.AtvAutoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atvAuto}
	 * labeled alternative in {@link validarScriptParser#regra}.
	 * @param ctx the parse tree
	 */
	void exitAtvAuto(validarScriptParser.AtvAutoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code vazio}
	 * labeled alternative in {@link validarScriptParser#regra}.
	 * @param ctx the parse tree
	 */
	void enterVazio(validarScriptParser.VazioContext ctx);
	/**
	 * Exit a parse tree produced by the {@code vazio}
	 * labeled alternative in {@link validarScriptParser#regra}.
	 * @param ctx the parse tree
	 */
	void exitVazio(validarScriptParser.VazioContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valido}
	 * labeled alternative in {@link validarScriptParser#atv_manu}.
	 * @param ctx the parse tree
	 */
	void enterValido(validarScriptParser.ValidoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valido}
	 * labeled alternative in {@link validarScriptParser#atv_manu}.
	 * @param ctx the parse tree
	 */
	void exitValido(validarScriptParser.ValidoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code invalido}
	 * labeled alternative in {@link validarScriptParser#atv_manu}.
	 * @param ctx the parse tree
	 */
	void enterInvalido(validarScriptParser.InvalidoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code invalido}
	 * labeled alternative in {@link validarScriptParser#atv_manu}.
	 * @param ctx the parse tree
	 */
	void exitInvalido(validarScriptParser.InvalidoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code vazio2}
	 * labeled alternative in {@link validarScriptParser#atv_manu}.
	 * @param ctx the parse tree
	 */
	void enterVazio2(validarScriptParser.Vazio2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code vazio2}
	 * labeled alternative in {@link validarScriptParser#atv_manu}.
	 * @param ctx the parse tree
	 */
	void exitVazio2(validarScriptParser.Vazio2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code valido2}
	 * labeled alternative in {@link validarScriptParser#atv_auto}.
	 * @param ctx the parse tree
	 */
	void enterValido2(validarScriptParser.Valido2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code valido2}
	 * labeled alternative in {@link validarScriptParser#atv_auto}.
	 * @param ctx the parse tree
	 */
	void exitValido2(validarScriptParser.Valido2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code invalido2}
	 * labeled alternative in {@link validarScriptParser#atv_auto}.
	 * @param ctx the parse tree
	 */
	void enterInvalido2(validarScriptParser.Invalido2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code invalido2}
	 * labeled alternative in {@link validarScriptParser#atv_auto}.
	 * @param ctx the parse tree
	 */
	void exitInvalido2(validarScriptParser.Invalido2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code vazio3}
	 * labeled alternative in {@link validarScriptParser#atv_auto}.
	 * @param ctx the parse tree
	 */
	void enterVazio3(validarScriptParser.Vazio3Context ctx);
	/**
	 * Exit a parse tree produced by the {@code vazio3}
	 * labeled alternative in {@link validarScriptParser#atv_auto}.
	 * @param ctx the parse tree
	 */
	void exitVazio3(validarScriptParser.Vazio3Context ctx);
}