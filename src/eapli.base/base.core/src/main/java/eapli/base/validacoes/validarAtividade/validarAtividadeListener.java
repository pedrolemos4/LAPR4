// Generated from C:/Users/josec/Desktop/LPROG IMPORTANTE/src/validarAtividade\validarAtividade.g4 by ANTLR 4.9.1
package eapli.base.validacoes.validarAtividade;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link validarAtividadeParser}.
 */
public interface validarAtividadeListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code atvManual}
	 * labeled alternative in {@link validarAtividadeParser#regra}.
	 * @param ctx the parse tree
	 */
	void enterAtvManual(validarAtividadeParser.AtvManualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atvManual}
	 * labeled alternative in {@link validarAtividadeParser#regra}.
	 * @param ctx the parse tree
	 */
	void exitAtvManual(validarAtividadeParser.AtvManualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atvAuto}
	 * labeled alternative in {@link validarAtividadeParser#regra}.
	 * @param ctx the parse tree
	 */
	void enterAtvAuto(validarAtividadeParser.AtvAutoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atvAuto}
	 * labeled alternative in {@link validarAtividadeParser#regra}.
	 * @param ctx the parse tree
	 */
	void exitAtvAuto(validarAtividadeParser.AtvAutoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code vazio}
	 * labeled alternative in {@link validarAtividadeParser#regra}.
	 * @param ctx the parse tree
	 */
	void enterVazio(validarAtividadeParser.VazioContext ctx);
	/**
	 * Exit a parse tree produced by the {@code vazio}
	 * labeled alternative in {@link validarAtividadeParser#regra}.
	 * @param ctx the parse tree
	 */
	void exitVazio(validarAtividadeParser.VazioContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valido}
	 * labeled alternative in {@link validarAtividadeParser#atv_manu}.
	 * @param ctx the parse tree
	 */
	void enterValido(validarAtividadeParser.ValidoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valido}
	 * labeled alternative in {@link validarAtividadeParser#atv_manu}.
	 * @param ctx the parse tree
	 */
	void exitValido(validarAtividadeParser.ValidoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code invalido}
	 * labeled alternative in {@link validarAtividadeParser#atv_manu}.
	 * @param ctx the parse tree
	 */
	void enterInvalido(validarAtividadeParser.InvalidoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code invalido}
	 * labeled alternative in {@link validarAtividadeParser#atv_manu}.
	 * @param ctx the parse tree
	 */
	void exitInvalido(validarAtividadeParser.InvalidoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code vazio2}
	 * labeled alternative in {@link validarAtividadeParser#atv_manu}.
	 * @param ctx the parse tree
	 */
	void enterVazio2(validarAtividadeParser.Vazio2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code vazio2}
	 * labeled alternative in {@link validarAtividadeParser#atv_manu}.
	 * @param ctx the parse tree
	 */
	void exitVazio2(validarAtividadeParser.Vazio2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code valido2}
	 * labeled alternative in {@link validarAtividadeParser#atv_auto}.
	 * @param ctx the parse tree
	 */
	void enterValido2(validarAtividadeParser.Valido2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code valido2}
	 * labeled alternative in {@link validarAtividadeParser#atv_auto}.
	 * @param ctx the parse tree
	 */
	void exitValido2(validarAtividadeParser.Valido2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code invalido2}
	 * labeled alternative in {@link validarAtividadeParser#atv_auto}.
	 * @param ctx the parse tree
	 */
	void enterInvalido2(validarAtividadeParser.Invalido2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code invalido2}
	 * labeled alternative in {@link validarAtividadeParser#atv_auto}.
	 * @param ctx the parse tree
	 */
	void exitInvalido2(validarAtividadeParser.Invalido2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code vazio3}
	 * labeled alternative in {@link validarAtividadeParser#atv_auto}.
	 * @param ctx the parse tree
	 */
	void enterVazio3(validarAtividadeParser.Vazio3Context ctx);
	/**
	 * Exit a parse tree produced by the {@code vazio3}
	 * labeled alternative in {@link validarAtividadeParser#atv_auto}.
	 * @param ctx the parse tree
	 */
	void exitVazio3(validarAtividadeParser.Vazio3Context ctx);
}