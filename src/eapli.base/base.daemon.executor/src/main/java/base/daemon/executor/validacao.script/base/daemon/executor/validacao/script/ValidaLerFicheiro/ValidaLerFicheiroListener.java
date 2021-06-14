// Generated from C:/Users/pedro/Documents/lapr4/lapr4/src/eapli.base/base.daemon.executor/src/main/java/base/daemon/executor/validacao.script\ValidaLerFicheiro.g4 by ANTLR 4.9.1
package base.daemon.executor.validacao.script.base.daemon.executor.validacao.script.ValidaLerFicheiro;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ValidaLerFicheiroParser}.
 */
public interface ValidaLerFicheiroListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ValidaLerFicheiroParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(ValidaLerFicheiroParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidaLerFicheiroParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(ValidaLerFicheiroParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidaLerFicheiroParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(ValidaLerFicheiroParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidaLerFicheiroParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(ValidaLerFicheiroParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidaLerFicheiroParser#infoProduto}.
	 * @param ctx the parse tree
	 */
	void enterInfoProduto(ValidaLerFicheiroParser.InfoProdutoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidaLerFicheiroParser#infoProduto}.
	 * @param ctx the parse tree
	 */
	void exitInfoProduto(ValidaLerFicheiroParser.InfoProdutoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidaLerFicheiroParser#infoCliente}.
	 * @param ctx the parse tree
	 */
	void enterInfoCliente(ValidaLerFicheiroParser.InfoClienteContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidaLerFicheiroParser#infoCliente}.
	 * @param ctx the parse tree
	 */
	void exitInfoCliente(ValidaLerFicheiroParser.InfoClienteContext ctx);
}