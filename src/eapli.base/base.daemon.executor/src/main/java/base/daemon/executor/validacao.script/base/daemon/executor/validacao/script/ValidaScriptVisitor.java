// Generated from C:/Users/pedro/Documents/lapr4/lapr4/src/eapli.base/base.daemon.executor/src/main/java/base/daemon/executor/validacao.script\ValidaScript.g4 by ANTLR 4.9.1
package base.daemon.executor.validacao.script;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ValidaScriptParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ValidaScriptVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ValidaScriptParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(ValidaScriptParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidaScriptParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(ValidaScriptParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidaScriptParser#script}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScript(ValidaScriptParser.ScriptContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidaScriptParser#instrucao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstrucao(ValidaScriptParser.InstrucaoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lerFicheiro}
	 * labeled alternative in {@link ValidaScriptParser#funcao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLerFicheiro(ValidaScriptParser.LerFicheiroContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidaScriptParser#inteiro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteiro(ValidaScriptParser.InteiroContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidaScriptParser#ficheiro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFicheiro(ValidaScriptParser.FicheiroContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidaScriptParser#path}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPath(ValidaScriptParser.PathContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidaScriptParser#progFile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgFile(ValidaScriptParser.ProgFileContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidaScriptParser#startFile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStartFile(ValidaScriptParser.StartFileContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidaScriptParser#infoProduto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInfoProduto(ValidaScriptParser.InfoProdutoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidaScriptParser#infoCliente}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInfoCliente(ValidaScriptParser.InfoClienteContext ctx);
}