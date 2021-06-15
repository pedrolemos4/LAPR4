// Generated from C:/Users/pedro/Documents/lapr4/lapr4/src/eapli.base/base.daemon.executor/src/main/java/base/daemon/executor/validacao.script\ValidaScript.g4 by ANTLR 4.9.1
package base.daemon.executor.validacao.script;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ValidaScriptParser}.
 */
public interface ValidaScriptListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ValidaScriptParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(ValidaScriptParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidaScriptParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(ValidaScriptParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidaScriptParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(ValidaScriptParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidaScriptParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(ValidaScriptParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidaScriptParser#script}.
	 * @param ctx the parse tree
	 */
	void enterScript(ValidaScriptParser.ScriptContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidaScriptParser#script}.
	 * @param ctx the parse tree
	 */
	void exitScript(ValidaScriptParser.ScriptContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidaScriptParser#instrucao}.
	 * @param ctx the parse tree
	 */
	void enterInstrucao(ValidaScriptParser.InstrucaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidaScriptParser#instrucao}.
	 * @param ctx the parse tree
	 */
	void exitInstrucao(ValidaScriptParser.InstrucaoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lerFicheiro}
	 * labeled alternative in {@link ValidaScriptParser#funcao}.
	 * @param ctx the parse tree
	 */
	void enterLerFicheiro(ValidaScriptParser.LerFicheiroContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lerFicheiro}
	 * labeled alternative in {@link ValidaScriptParser#funcao}.
	 * @param ctx the parse tree
	 */
	void exitLerFicheiro(ValidaScriptParser.LerFicheiroContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidaScriptParser#inteiro}.
	 * @param ctx the parse tree
	 */
	void enterInteiro(ValidaScriptParser.InteiroContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidaScriptParser#inteiro}.
	 * @param ctx the parse tree
	 */
	void exitInteiro(ValidaScriptParser.InteiroContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidaScriptParser#ficheiro}.
	 * @param ctx the parse tree
	 */
	void enterFicheiro(ValidaScriptParser.FicheiroContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidaScriptParser#ficheiro}.
	 * @param ctx the parse tree
	 */
	void exitFicheiro(ValidaScriptParser.FicheiroContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidaScriptParser#path}.
	 * @param ctx the parse tree
	 */
	void enterPath(ValidaScriptParser.PathContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidaScriptParser#path}.
	 * @param ctx the parse tree
	 */
	void exitPath(ValidaScriptParser.PathContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidaScriptParser#progFile}.
	 * @param ctx the parse tree
	 */
	void enterProgFile(ValidaScriptParser.ProgFileContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidaScriptParser#progFile}.
	 * @param ctx the parse tree
	 */
	void exitProgFile(ValidaScriptParser.ProgFileContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidaScriptParser#startFile}.
	 * @param ctx the parse tree
	 */
	void enterStartFile(ValidaScriptParser.StartFileContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidaScriptParser#startFile}.
	 * @param ctx the parse tree
	 */
	void exitStartFile(ValidaScriptParser.StartFileContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidaScriptParser#infoProduto}.
	 * @param ctx the parse tree
	 */
	void enterInfoProduto(ValidaScriptParser.InfoProdutoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidaScriptParser#infoProduto}.
	 * @param ctx the parse tree
	 */
	void exitInfoProduto(ValidaScriptParser.InfoProdutoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidaScriptParser#infoCliente}.
	 * @param ctx the parse tree
	 */
	void enterInfoCliente(ValidaScriptParser.InfoClienteContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidaScriptParser#infoCliente}.
	 * @param ctx the parse tree
	 */
	void exitInfoCliente(ValidaScriptParser.InfoClienteContext ctx);
}