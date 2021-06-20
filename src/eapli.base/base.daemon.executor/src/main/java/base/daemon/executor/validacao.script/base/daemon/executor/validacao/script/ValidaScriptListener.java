// Generated from C:/Users/pedro/Documents/lapr4/lapr4/src/eapli.base/base.daemon.executor/src/main/java/base/daemon/executor/validacao.script\ValidaScript.g4 by ANTLR 4.9.1
package base.daemon.executor.validacao.script.base.daemon.executor.validacao.script;
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
	 * Enter a parse tree produced by the {@code enviarEmailProduto}
	 * labeled alternative in {@link ValidaScriptParser#funcao}.
	 * @param ctx the parse tree
	 */
	void enterEnviarEmailProduto(ValidaScriptParser.EnviarEmailProdutoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code enviarEmailProduto}
	 * labeled alternative in {@link ValidaScriptParser#funcao}.
	 * @param ctx the parse tree
	 */
	void exitEnviarEmailProduto(ValidaScriptParser.EnviarEmailProdutoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code enviarEmailFormulario}
	 * labeled alternative in {@link ValidaScriptParser#funcao}.
	 * @param ctx the parse tree
	 */
	void enterEnviarEmailFormulario(ValidaScriptParser.EnviarEmailFormularioContext ctx);
	/**
	 * Exit a parse tree produced by the {@code enviarEmailFormulario}
	 * labeled alternative in {@link ValidaScriptParser#funcao}.
	 * @param ctx the parse tree
	 */
	void exitEnviarEmailFormulario(ValidaScriptParser.EnviarEmailFormularioContext ctx);
	/**
	 * Enter a parse tree produced by the {@code calcularValor}
	 * labeled alternative in {@link ValidaScriptParser#funcao}.
	 * @param ctx the parse tree
	 */
	void enterCalcularValor(ValidaScriptParser.CalcularValorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code calcularValor}
	 * labeled alternative in {@link ValidaScriptParser#funcao}.
	 * @param ctx the parse tree
	 */
	void exitCalcularValor(ValidaScriptParser.CalcularValorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code aplicarDesconto}
	 * labeled alternative in {@link ValidaScriptParser#funcao}.
	 * @param ctx the parse tree
	 */
	void enterAplicarDesconto(ValidaScriptParser.AplicarDescontoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code aplicarDesconto}
	 * labeled alternative in {@link ValidaScriptParser#funcao}.
	 * @param ctx the parse tree
	 */
	void exitAplicarDesconto(ValidaScriptParser.AplicarDescontoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code calcularDescontoEPreco}
	 * labeled alternative in {@link ValidaScriptParser#funcao}.
	 * @param ctx the parse tree
	 */
	void enterCalcularDescontoEPreco(ValidaScriptParser.CalcularDescontoEPrecoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code calcularDescontoEPreco}
	 * labeled alternative in {@link ValidaScriptParser#funcao}.
	 * @param ctx the parse tree
	 */
	void exitCalcularDescontoEPreco(ValidaScriptParser.CalcularDescontoEPrecoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidaScriptParser#else1}.
	 * @param ctx the parse tree
	 */
	void enterElse1(ValidaScriptParser.Else1Context ctx);
	/**
	 * Exit a parse tree produced by {@link ValidaScriptParser#else1}.
	 * @param ctx the parse tree
	 */
	void exitElse1(ValidaScriptParser.Else1Context ctx);
	/**
	 * Enter a parse tree produced by {@link ValidaScriptParser#expressao_a_verificar}.
	 * @param ctx the parse tree
	 */
	void enterExpressao_a_verificar(ValidaScriptParser.Expressao_a_verificarContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidaScriptParser#expressao_a_verificar}.
	 * @param ctx the parse tree
	 */
	void exitExpressao_a_verificar(ValidaScriptParser.Expressao_a_verificarContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidaScriptParser#aplicar_desconto}.
	 * @param ctx the parse tree
	 */
	void enterAplicar_desconto(ValidaScriptParser.Aplicar_descontoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidaScriptParser#aplicar_desconto}.
	 * @param ctx the parse tree
	 */
	void exitAplicar_desconto(ValidaScriptParser.Aplicar_descontoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atribuir}
	 * labeled alternative in {@link ValidaScriptParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterAtribuir(ValidaScriptParser.AtribuirContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atribuir}
	 * labeled alternative in {@link ValidaScriptParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitAtribuir(ValidaScriptParser.AtribuirContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiDiv}
	 * labeled alternative in {@link ValidaScriptParser#calculosMatematicos}.
	 * @param ctx the parse tree
	 */
	void enterMultiDiv(ValidaScriptParser.MultiDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiDiv}
	 * labeled alternative in {@link ValidaScriptParser#calculosMatematicos}.
	 * @param ctx the parse tree
	 */
	void exitMultiDiv(ValidaScriptParser.MultiDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code somaSub}
	 * labeled alternative in {@link ValidaScriptParser#calculosMatematicos}.
	 * @param ctx the parse tree
	 */
	void enterSomaSub(ValidaScriptParser.SomaSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code somaSub}
	 * labeled alternative in {@link ValidaScriptParser#calculosMatematicos}.
	 * @param ctx the parse tree
	 */
	void exitSomaSub(ValidaScriptParser.SomaSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenteses}
	 * labeled alternative in {@link ValidaScriptParser#calculosMatematicos}.
	 * @param ctx the parse tree
	 */
	void enterParenteses(ValidaScriptParser.ParentesesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenteses}
	 * labeled alternative in {@link ValidaScriptParser#calculosMatematicos}.
	 * @param ctx the parse tree
	 */
	void exitParenteses(ValidaScriptParser.ParentesesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atribuiInteiro}
	 * labeled alternative in {@link ValidaScriptParser#calculosMatematicos}.
	 * @param ctx the parse tree
	 */
	void enterAtribuiInteiro(ValidaScriptParser.AtribuiInteiroContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atribuiInteiro}
	 * labeled alternative in {@link ValidaScriptParser#calculosMatematicos}.
	 * @param ctx the parse tree
	 */
	void exitAtribuiInteiro(ValidaScriptParser.AtribuiInteiroContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atribuiDouble}
	 * labeled alternative in {@link ValidaScriptParser#calculosMatematicos}.
	 * @param ctx the parse tree
	 */
	void enterAtribuiDouble(ValidaScriptParser.AtribuiDoubleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atribuiDouble}
	 * labeled alternative in {@link ValidaScriptParser#calculosMatematicos}.
	 * @param ctx the parse tree
	 */
	void exitAtribuiDouble(ValidaScriptParser.AtribuiDoubleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variavel}
	 * labeled alternative in {@link ValidaScriptParser#param}.
	 * @param ctx the parse tree
	 */
	void enterVariavel(ValidaScriptParser.VariavelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variavel}
	 * labeled alternative in {@link ValidaScriptParser#param}.
	 * @param ctx the parse tree
	 */
	void exitVariavel(ValidaScriptParser.VariavelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code proprioValor}
	 * labeled alternative in {@link ValidaScriptParser#param}.
	 * @param ctx the parse tree
	 */
	void enterProprioValor(ValidaScriptParser.ProprioValorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code proprioValor}
	 * labeled alternative in {@link ValidaScriptParser#param}.
	 * @param ctx the parse tree
	 */
	void exitProprioValor(ValidaScriptParser.ProprioValorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valorDouble}
	 * labeled alternative in {@link ValidaScriptParser#param}.
	 * @param ctx the parse tree
	 */
	void enterValorDouble(ValidaScriptParser.ValorDoubleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valorDouble}
	 * labeled alternative in {@link ValidaScriptParser#param}.
	 * @param ctx the parse tree
	 */
	void exitValorDouble(ValidaScriptParser.ValorDoubleContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidaScriptParser#valor_pretendido}.
	 * @param ctx the parse tree
	 */
	void enterValor_pretendido(ValidaScriptParser.Valor_pretendidoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidaScriptParser#valor_pretendido}.
	 * @param ctx the parse tree
	 */
	void exitValor_pretendido(ValidaScriptParser.Valor_pretendidoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidaScriptParser#percentagem}.
	 * @param ctx the parse tree
	 */
	void enterPercentagem(ValidaScriptParser.PercentagemContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidaScriptParser#percentagem}.
	 * @param ctx the parse tree
	 */
	void exitPercentagem(ValidaScriptParser.PercentagemContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidaScriptParser#frase}.
	 * @param ctx the parse tree
	 */
	void enterFrase(ValidaScriptParser.FraseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidaScriptParser#frase}.
	 * @param ctx the parse tree
	 */
	void exitFrase(ValidaScriptParser.FraseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidaScriptParser#nameVar}.
	 * @param ctx the parse tree
	 */
	void enterNameVar(ValidaScriptParser.NameVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidaScriptParser#nameVar}.
	 * @param ctx the parse tree
	 */
	void exitNameVar(ValidaScriptParser.NameVarContext ctx);
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