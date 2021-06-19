// Generated from C:/Users/pedro/Documents/lapr4/lapr4/src/eapli.base/base.daemon.executor/src/main/java/base/daemon/executor/validacao.script\ValidaScript.g4 by ANTLR 4.9.1
package base.daemon.executor.validacao.script.base.daemon.executor.validacao.script;
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
	 * Visit a parse tree produced by the {@code lerFicheiro}
	 * labeled alternative in {@link ValidaScriptParser#funcao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLerFicheiro(ValidaScriptParser.LerFicheiroContext ctx);
	/**
	 * Visit a parse tree produced by the {@code enviarEmail}
	 * labeled alternative in {@link ValidaScriptParser#funcao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnviarEmail(ValidaScriptParser.EnviarEmailContext ctx);
	/**
	 * Visit a parse tree produced by the {@code calcularValor}
	 * labeled alternative in {@link ValidaScriptParser#funcao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCalcularValor(ValidaScriptParser.CalcularValorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code aplicarDesconto}
	 * labeled alternative in {@link ValidaScriptParser#funcao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAplicarDesconto(ValidaScriptParser.AplicarDescontoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code calcularDescontoEPreco}
	 * labeled alternative in {@link ValidaScriptParser#funcao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCalcularDescontoEPreco(ValidaScriptParser.CalcularDescontoEPrecoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidaScriptParser#else1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElse1(ValidaScriptParser.Else1Context ctx);
	/**
	 * Visit a parse tree produced by {@link ValidaScriptParser#expressao_a_verificar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressao_a_verificar(ValidaScriptParser.Expressao_a_verificarContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidaScriptParser#aplicar_desconto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAplicar_desconto(ValidaScriptParser.Aplicar_descontoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidaScriptParser#sendEmail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSendEmail(ValidaScriptParser.SendEmailContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atribuir}
	 * labeled alternative in {@link ValidaScriptParser#expressao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtribuir(ValidaScriptParser.AtribuirContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiDiv}
	 * labeled alternative in {@link ValidaScriptParser#calculosMatematicos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiDiv(ValidaScriptParser.MultiDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code somaSub}
	 * labeled alternative in {@link ValidaScriptParser#calculosMatematicos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSomaSub(ValidaScriptParser.SomaSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenteses}
	 * labeled alternative in {@link ValidaScriptParser#calculosMatematicos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenteses(ValidaScriptParser.ParentesesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atribuiInteiro}
	 * labeled alternative in {@link ValidaScriptParser#calculosMatematicos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtribuiInteiro(ValidaScriptParser.AtribuiInteiroContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atribuiDouble}
	 * labeled alternative in {@link ValidaScriptParser#calculosMatematicos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtribuiDouble(ValidaScriptParser.AtribuiDoubleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variavel}
	 * labeled alternative in {@link ValidaScriptParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariavel(ValidaScriptParser.VariavelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code proprioValor}
	 * labeled alternative in {@link ValidaScriptParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProprioValor(ValidaScriptParser.ProprioValorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valorDouble}
	 * labeled alternative in {@link ValidaScriptParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValorDouble(ValidaScriptParser.ValorDoubleContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidaScriptParser#valor_pretendido}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValor_pretendido(ValidaScriptParser.Valor_pretendidoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidaScriptParser#percentagem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPercentagem(ValidaScriptParser.PercentagemContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidaScriptParser#frase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFrase(ValidaScriptParser.FraseContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidaScriptParser#nameVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNameVar(ValidaScriptParser.NameVarContext ctx);
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