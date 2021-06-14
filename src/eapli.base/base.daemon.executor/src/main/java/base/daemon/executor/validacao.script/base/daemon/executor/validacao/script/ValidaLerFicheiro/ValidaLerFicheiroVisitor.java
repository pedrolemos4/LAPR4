// Generated from C:/Users/pedro/Documents/lapr4/lapr4/src/eapli.base/base.daemon.executor/src/main/java/base/daemon/executor/validacao.script\ValidaLerFicheiro.g4 by ANTLR 4.9.1
package base.daemon.executor.validacao.script.base.daemon.executor.validacao.script.ValidaLerFicheiro;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ValidaLerFicheiroParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ValidaLerFicheiroVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ValidaLerFicheiroParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(ValidaLerFicheiroParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidaLerFicheiroParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(ValidaLerFicheiroParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidaLerFicheiroParser#infoProduto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInfoProduto(ValidaLerFicheiroParser.InfoProdutoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidaLerFicheiroParser#infoCliente}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInfoCliente(ValidaLerFicheiroParser.InfoClienteContext ctx);
}