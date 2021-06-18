// Generated from C:/Users/pedro/Documents/lapr4/lapr4/src/eapli.base/base.daemon.executor/src/main/java/base/daemon/executor/validacao.script\ValidaScript.g4 by ANTLR 4.9.1
package base.daemon.executor.validacao.script.base.daemon.executor.validacao.script;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ValidaScriptParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, SOMA_SUB=30, MULT_DIV=31, 
		SINAL_BOOLEANO=32, SOMA=33, SUBTRACAO=34, MULT=35, BARRA=36, ESCALAO=37, 
		PRECO=38, CATEGORIA=39, INTEIRO=40, DOUBLE=41, PONTO_VIRGULA=42, PALAVRA=43, 
		EMAIL=44, XML=45, WS=46;
	public static final int
		RULE_prog = 0, RULE_start = 1, RULE_funcao = 2, RULE_aplicar_desconto = 3, 
		RULE_expressao_a_verificar = 4, RULE_sendEmail = 5, RULE_calcPrecoTotal = 6, 
		RULE_calcPrecoFinal = 7, RULE_expressao = 8, RULE_calculosMatematicos = 9, 
		RULE_param = 10, RULE_valor_pretendido = 11, RULE_percentagem = 12, RULE_frase = 13, 
		RULE_nameVar = 14, RULE_ficheiro = 15, RULE_path = 16, RULE_progFile = 17, 
		RULE_startFile = 18, RULE_infoProduto = 19, RULE_infoCliente = 20;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "start", "funcao", "aplicar_desconto", "expressao_a_verificar", 
			"sendEmail", "calcPrecoTotal", "calcPrecoFinal", "expressao", "calculosMatematicos", 
			"param", "valor_pretendido", "percentagem", "frase", "nameVar", "ficheiro", 
			"path", "progFile", "startFile", "infoProduto", "infoCliente"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Ler ficheiro'", "'if '", "' then:'", "'end if;'", "'Aplicar Desconto->'", 
			"'Send Email'", "'->QUANT->'", "'->DESCONTO->'", "'->'", "'('", "')'", 
			"'%'", "'#'", "'<File>'", "'</File>'", "'<Produto>'", "'</Produto>'", 
			"'<Cliente>'", "'</Cliente>'", "'<Codigo>'", "'</Codigo>'", "'<Preco>'", 
			"'</Preco>'", "'<Categoria>'", "'</Categoria>'", "'<Numero>'", "'</Numero>'", 
			"'<Escalao>'", "'</Escalao>'", null, null, null, "'+'", "'-'", "'*'", 
			"'/'", "'Escalao'", "'Preco'", "'Categoria'", null, null, "';'", null, 
			null, "'.xml'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "SOMA_SUB", "MULT_DIV", "SINAL_BOOLEANO", 
			"SOMA", "SUBTRACAO", "MULT", "BARRA", "ESCALAO", "PRECO", "CATEGORIA", 
			"INTEIRO", "DOUBLE", "PONTO_VIRGULA", "PALAVRA", "EMAIL", "XML", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "ValidaScript.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ValidaScriptParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public StartContext start() {
			return getRuleContext(StartContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptVisitor ) return ((ValidaScriptVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			start(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StartContext extends ParserRuleContext {
		public FuncaoContext funcao() {
			return getRuleContext(FuncaoContext.class,0);
		}
		public StartContext start() {
			return getRuleContext(StartContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptVisitor ) return ((ValidaScriptVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		return start(0);
	}

	private StartContext start(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StartContext _localctx = new StartContext(_ctx, _parentState);
		StartContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_start, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(45);
			funcao();
			}
			_ctx.stop = _input.LT(-1);
			setState(51);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StartContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_start);
					setState(47);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(48);
					funcao();
					}
					} 
				}
				setState(53);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class FuncaoContext extends ParserRuleContext {
		public FuncaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcao; }
	 
		public FuncaoContext() { }
		public void copyFrom(FuncaoContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AplicarDescontoContext extends FuncaoContext {
		public Aplicar_descontoContext aplicar_desconto() {
			return getRuleContext(Aplicar_descontoContext.class,0);
		}
		public Expressao_a_verificarContext expressao_a_verificar() {
			return getRuleContext(Expressao_a_verificarContext.class,0);
		}
		public AplicarDescontoContext(FuncaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).enterAplicarDesconto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).exitAplicarDesconto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptVisitor ) return ((ValidaScriptVisitor<? extends T>)visitor).visitAplicarDesconto(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Calcular_preco_finalContext extends FuncaoContext {
		public CalcPrecoFinalContext calcPrecoFinal() {
			return getRuleContext(CalcPrecoFinalContext.class,0);
		}
		public Calcular_preco_finalContext(FuncaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).enterCalcular_preco_final(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).exitCalcular_preco_final(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptVisitor ) return ((ValidaScriptVisitor<? extends T>)visitor).visitCalcular_preco_final(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LerFicheiroContext extends FuncaoContext {
		public Token possivel_id;
		public FicheiroContext ficheiro_script;
		public Valor_pretendidoContext valor;
		public List<TerminalNode> PONTO_VIRGULA() { return getTokens(ValidaScriptParser.PONTO_VIRGULA); }
		public TerminalNode PONTO_VIRGULA(int i) {
			return getToken(ValidaScriptParser.PONTO_VIRGULA, i);
		}
		public TerminalNode INTEIRO() { return getToken(ValidaScriptParser.INTEIRO, 0); }
		public FicheiroContext ficheiro() {
			return getRuleContext(FicheiroContext.class,0);
		}
		public Valor_pretendidoContext valor_pretendido() {
			return getRuleContext(Valor_pretendidoContext.class,0);
		}
		public LerFicheiroContext(FuncaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).enterLerFicheiro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).exitLerFicheiro(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptVisitor ) return ((ValidaScriptVisitor<? extends T>)visitor).visitLerFicheiro(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CalcularValorContext extends FuncaoContext {
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public CalcularValorContext(FuncaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).enterCalcularValor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).exitCalcularValor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptVisitor ) return ((ValidaScriptVisitor<? extends T>)visitor).visitCalcularValor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Calcular_preco_totalContext extends FuncaoContext {
		public CalcPrecoTotalContext calcPrecoTotal() {
			return getRuleContext(CalcPrecoTotalContext.class,0);
		}
		public Calcular_preco_totalContext(FuncaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).enterCalcular_preco_total(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).exitCalcular_preco_total(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptVisitor ) return ((ValidaScriptVisitor<? extends T>)visitor).visitCalcular_preco_total(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EnviarEmailContext extends FuncaoContext {
		public SendEmailContext sendEmail() {
			return getRuleContext(SendEmailContext.class,0);
		}
		public EnviarEmailContext(FuncaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).enterEnviarEmail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).exitEnviarEmail(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptVisitor ) return ((ValidaScriptVisitor<? extends T>)visitor).visitEnviarEmail(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncaoContext funcao() throws RecognitionException {
		FuncaoContext _localctx = new FuncaoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_funcao);
		try {
			setState(72);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new LerFicheiroContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				match(T__0);
				setState(55);
				match(PONTO_VIRGULA);
				setState(56);
				((LerFicheiroContext)_localctx).possivel_id = match(INTEIRO);
				setState(57);
				match(PONTO_VIRGULA);
				setState(58);
				((LerFicheiroContext)_localctx).ficheiro_script = ficheiro();
				setState(59);
				match(PONTO_VIRGULA);
				setState(60);
				((LerFicheiroContext)_localctx).valor = valor_pretendido();
				}
				break;
			case 2:
				_localctx = new EnviarEmailContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(62);
				sendEmail();
				}
				break;
			case 3:
				_localctx = new CalcularValorContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(63);
				expressao();
				}
				break;
			case 4:
				_localctx = new Calcular_preco_totalContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(64);
				calcPrecoTotal();
				}
				break;
			case 5:
				_localctx = new AplicarDescontoContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(65);
				match(T__1);
				setState(66);
				aplicar_desconto();
				setState(67);
				match(T__2);
				setState(68);
				expressao_a_verificar();
				setState(69);
				match(T__3);
				}
				break;
			case 6:
				_localctx = new Calcular_preco_finalContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(71);
				calcPrecoFinal();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Aplicar_descontoContext extends ParserRuleContext {
		public ParamContext leftPortion;
		public Token sinal;
		public ParamContext rightPortion;
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public TerminalNode SINAL_BOOLEANO() { return getToken(ValidaScriptParser.SINAL_BOOLEANO, 0); }
		public Aplicar_descontoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aplicar_desconto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).enterAplicar_desconto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).exitAplicar_desconto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptVisitor ) return ((ValidaScriptVisitor<? extends T>)visitor).visitAplicar_desconto(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Aplicar_descontoContext aplicar_desconto() throws RecognitionException {
		Aplicar_descontoContext _localctx = new Aplicar_descontoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_aplicar_desconto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			((Aplicar_descontoContext)_localctx).leftPortion = param();
			setState(75);
			((Aplicar_descontoContext)_localctx).sinal = match(SINAL_BOOLEANO);
			setState(76);
			((Aplicar_descontoContext)_localctx).rightPortion = param();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expressao_a_verificarContext extends ParserRuleContext {
		public Token valorDesconto;
		public TerminalNode DOUBLE() { return getToken(ValidaScriptParser.DOUBLE, 0); }
		public Expressao_a_verificarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressao_a_verificar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).enterExpressao_a_verificar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).exitExpressao_a_verificar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptVisitor ) return ((ValidaScriptVisitor<? extends T>)visitor).visitExpressao_a_verificar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expressao_a_verificarContext expressao_a_verificar() throws RecognitionException {
		Expressao_a_verificarContext _localctx = new Expressao_a_verificarContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_expressao_a_verificar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(T__4);
			setState(79);
			((Expressao_a_verificarContext)_localctx).valorDesconto = match(DOUBLE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SendEmailContext extends ParserRuleContext {
		public Token emailColab;
		public Token tipoCliente;
		public PercentagemContext valorDesconto;
		public Token valorFinal;
		public FraseContext decisao;
		public PercentagemContext desconto;
		public List<TerminalNode> PONTO_VIRGULA() { return getTokens(ValidaScriptParser.PONTO_VIRGULA); }
		public TerminalNode PONTO_VIRGULA(int i) {
			return getToken(ValidaScriptParser.PONTO_VIRGULA, i);
		}
		public TerminalNode EMAIL() { return getToken(ValidaScriptParser.EMAIL, 0); }
		public TerminalNode PALAVRA() { return getToken(ValidaScriptParser.PALAVRA, 0); }
		public PercentagemContext percentagem() {
			return getRuleContext(PercentagemContext.class,0);
		}
		public TerminalNode DOUBLE() { return getToken(ValidaScriptParser.DOUBLE, 0); }
		public FraseContext frase() {
			return getRuleContext(FraseContext.class,0);
		}
		public SendEmailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sendEmail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).enterSendEmail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).exitSendEmail(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptVisitor ) return ((ValidaScriptVisitor<? extends T>)visitor).visitSendEmail(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SendEmailContext sendEmail() throws RecognitionException {
		SendEmailContext _localctx = new SendEmailContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_sendEmail);
		try {
			setState(100);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(81);
				match(T__5);
				setState(82);
				match(PONTO_VIRGULA);
				setState(83);
				((SendEmailContext)_localctx).emailColab = match(EMAIL);
				setState(84);
				match(PONTO_VIRGULA);
				setState(85);
				((SendEmailContext)_localctx).tipoCliente = match(PALAVRA);
				setState(86);
				match(PONTO_VIRGULA);
				setState(87);
				((SendEmailContext)_localctx).valorDesconto = percentagem();
				setState(88);
				match(PONTO_VIRGULA);
				setState(89);
				((SendEmailContext)_localctx).valorFinal = match(DOUBLE);
				setState(90);
				match(PONTO_VIRGULA);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(92);
				match(T__5);
				setState(93);
				match(PONTO_VIRGULA);
				setState(94);
				((SendEmailContext)_localctx).emailColab = match(EMAIL);
				setState(95);
				match(PONTO_VIRGULA);
				setState(96);
				((SendEmailContext)_localctx).decisao = frase();
				setState(97);
				match(PONTO_VIRGULA);
				setState(98);
				((SendEmailContext)_localctx).desconto = percentagem();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CalcPrecoTotalContext extends ParserRuleContext {
		public NameVarContext var;
		public Token quantidade;
		public NameVarContext nameVar() {
			return getRuleContext(NameVarContext.class,0);
		}
		public TerminalNode INTEIRO() { return getToken(ValidaScriptParser.INTEIRO, 0); }
		public CalcPrecoTotalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_calcPrecoTotal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).enterCalcPrecoTotal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).exitCalcPrecoTotal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptVisitor ) return ((ValidaScriptVisitor<? extends T>)visitor).visitCalcPrecoTotal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CalcPrecoTotalContext calcPrecoTotal() throws RecognitionException {
		CalcPrecoTotalContext _localctx = new CalcPrecoTotalContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_calcPrecoTotal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			((CalcPrecoTotalContext)_localctx).var = nameVar();
			setState(103);
			match(T__6);
			setState(104);
			((CalcPrecoTotalContext)_localctx).quantidade = match(INTEIRO);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CalcPrecoFinalContext extends ParserRuleContext {
		public NameVarContext var;
		public Token desconto;
		public NameVarContext nameVar() {
			return getRuleContext(NameVarContext.class,0);
		}
		public TerminalNode DOUBLE() { return getToken(ValidaScriptParser.DOUBLE, 0); }
		public CalcPrecoFinalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_calcPrecoFinal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).enterCalcPrecoFinal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).exitCalcPrecoFinal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptVisitor ) return ((ValidaScriptVisitor<? extends T>)visitor).visitCalcPrecoFinal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CalcPrecoFinalContext calcPrecoFinal() throws RecognitionException {
		CalcPrecoFinalContext _localctx = new CalcPrecoFinalContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_calcPrecoFinal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			((CalcPrecoFinalContext)_localctx).var = nameVar();
			setState(107);
			match(T__7);
			setState(108);
			((CalcPrecoFinalContext)_localctx).desconto = match(DOUBLE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressaoContext extends ParserRuleContext {
		public ExpressaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressao; }
	 
		public ExpressaoContext() { }
		public void copyFrom(ExpressaoContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AtribuirContext extends ExpressaoContext {
		public NameVarContext nameVar() {
			return getRuleContext(NameVarContext.class,0);
		}
		public CalculosMatematicosContext calculosMatematicos() {
			return getRuleContext(CalculosMatematicosContext.class,0);
		}
		public AtribuirContext(ExpressaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).enterAtribuir(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).exitAtribuir(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptVisitor ) return ((ValidaScriptVisitor<? extends T>)visitor).visitAtribuir(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressaoContext expressao() throws RecognitionException {
		ExpressaoContext _localctx = new ExpressaoContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_expressao);
		try {
			_localctx = new AtribuirContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			nameVar();
			setState(111);
			match(T__8);
			setState(112);
			calculosMatematicos();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CalculosMatematicosContext extends ParserRuleContext {
		public CalculosMatematicosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_calculosMatematicos; }
	 
		public CalculosMatematicosContext() { }
		public void copyFrom(CalculosMatematicosContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MultiDivContext extends CalculosMatematicosContext {
		public ParamContext left;
		public Token sinal;
		public ParamContext right;
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public TerminalNode MULT_DIV() { return getToken(ValidaScriptParser.MULT_DIV, 0); }
		public MultiDivContext(CalculosMatematicosContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).enterMultiDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).exitMultiDiv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptVisitor ) return ((ValidaScriptVisitor<? extends T>)visitor).visitMultiDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SomaSubContext extends CalculosMatematicosContext {
		public ParamContext left;
		public Token sinal;
		public ParamContext right;
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public TerminalNode SOMA_SUB() { return getToken(ValidaScriptParser.SOMA_SUB, 0); }
		public SomaSubContext(CalculosMatematicosContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).enterSomaSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).exitSomaSub(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptVisitor ) return ((ValidaScriptVisitor<? extends T>)visitor).visitSomaSub(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParentesesContext extends CalculosMatematicosContext {
		public CalculosMatematicosContext calculosMatematicos() {
			return getRuleContext(CalculosMatematicosContext.class,0);
		}
		public ParentesesContext(CalculosMatematicosContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).enterParenteses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).exitParenteses(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptVisitor ) return ((ValidaScriptVisitor<? extends T>)visitor).visitParenteses(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CalculosMatematicosContext calculosMatematicos() throws RecognitionException {
		CalculosMatematicosContext _localctx = new CalculosMatematicosContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_calculosMatematicos);
		try {
			setState(126);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new MultiDivContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(114);
				((MultiDivContext)_localctx).left = param();
				setState(115);
				((MultiDivContext)_localctx).sinal = match(MULT_DIV);
				setState(116);
				((MultiDivContext)_localctx).right = param();
				}
				break;
			case 2:
				_localctx = new SomaSubContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(118);
				((SomaSubContext)_localctx).left = param();
				setState(119);
				((SomaSubContext)_localctx).sinal = match(SOMA_SUB);
				setState(120);
				((SomaSubContext)_localctx).right = param();
				}
				break;
			case 3:
				_localctx = new ParentesesContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(122);
				match(T__9);
				setState(123);
				calculosMatematicos();
				setState(124);
				match(T__10);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamContext extends ParserRuleContext {
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
	 
		public ParamContext() { }
		public void copyFrom(ParamContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VariavelContext extends ParamContext {
		public NameVarContext nameVar() {
			return getRuleContext(NameVarContext.class,0);
		}
		public VariavelContext(ParamContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).enterVariavel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).exitVariavel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptVisitor ) return ((ValidaScriptVisitor<? extends T>)visitor).visitVariavel(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ProprioValorContext extends ParamContext {
		public TerminalNode INTEIRO() { return getToken(ValidaScriptParser.INTEIRO, 0); }
		public ProprioValorContext(ParamContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).enterProprioValor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).exitProprioValor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptVisitor ) return ((ValidaScriptVisitor<? extends T>)visitor).visitProprioValor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_param);
		try {
			setState(130);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
				_localctx = new VariavelContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(128);
				nameVar();
				}
				break;
			case INTEIRO:
				_localctx = new ProprioValorContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(129);
				match(INTEIRO);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Valor_pretendidoContext extends ParserRuleContext {
		public TerminalNode ESCALAO() { return getToken(ValidaScriptParser.ESCALAO, 0); }
		public TerminalNode CATEGORIA() { return getToken(ValidaScriptParser.CATEGORIA, 0); }
		public TerminalNode PRECO() { return getToken(ValidaScriptParser.PRECO, 0); }
		public Valor_pretendidoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valor_pretendido; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).enterValor_pretendido(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).exitValor_pretendido(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptVisitor ) return ((ValidaScriptVisitor<? extends T>)visitor).visitValor_pretendido(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Valor_pretendidoContext valor_pretendido() throws RecognitionException {
		Valor_pretendidoContext _localctx = new Valor_pretendidoContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_valor_pretendido);
		try {
			setState(136);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(132);
				match(ESCALAO);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(133);
				match(CATEGORIA);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(134);
				match(PRECO);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PercentagemContext extends ParserRuleContext {
		public TerminalNode DOUBLE() { return getToken(ValidaScriptParser.DOUBLE, 0); }
		public PercentagemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_percentagem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).enterPercentagem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).exitPercentagem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptVisitor ) return ((ValidaScriptVisitor<? extends T>)visitor).visitPercentagem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PercentagemContext percentagem() throws RecognitionException {
		PercentagemContext _localctx = new PercentagemContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_percentagem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(DOUBLE);
			setState(139);
			match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FraseContext extends ParserRuleContext {
		public List<TerminalNode> PALAVRA() { return getTokens(ValidaScriptParser.PALAVRA); }
		public TerminalNode PALAVRA(int i) {
			return getToken(ValidaScriptParser.PALAVRA, i);
		}
		public FraseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_frase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).enterFrase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).exitFrase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptVisitor ) return ((ValidaScriptVisitor<? extends T>)visitor).visitFrase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FraseContext frase() throws RecognitionException {
		FraseContext _localctx = new FraseContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_frase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(141);
				match(PALAVRA);
				}
				}
				setState(144); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==PALAVRA );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NameVarContext extends ParserRuleContext {
		public TerminalNode PALAVRA() { return getToken(ValidaScriptParser.PALAVRA, 0); }
		public NameVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nameVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).enterNameVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).exitNameVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptVisitor ) return ((ValidaScriptVisitor<? extends T>)visitor).visitNameVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NameVarContext nameVar() throws RecognitionException {
		NameVarContext _localctx = new NameVarContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_nameVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(T__12);
			setState(147);
			match(PALAVRA);
			setState(148);
			match(T__12);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FicheiroContext extends ParserRuleContext {
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public TerminalNode XML() { return getToken(ValidaScriptParser.XML, 0); }
		public FicheiroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ficheiro; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).enterFicheiro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).exitFicheiro(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptVisitor ) return ((ValidaScriptVisitor<? extends T>)visitor).visitFicheiro(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FicheiroContext ficheiro() throws RecognitionException {
		FicheiroContext _localctx = new FicheiroContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_ficheiro);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			path(0);
			setState(151);
			match(XML);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PathContext extends ParserRuleContext {
		public TerminalNode PALAVRA() { return getToken(ValidaScriptParser.PALAVRA, 0); }
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public TerminalNode BARRA() { return getToken(ValidaScriptParser.BARRA, 0); }
		public PathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_path; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).enterPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).exitPath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptVisitor ) return ((ValidaScriptVisitor<? extends T>)visitor).visitPath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PathContext path() throws RecognitionException {
		return path(0);
	}

	private PathContext path(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PathContext _localctx = new PathContext(_ctx, _parentState);
		PathContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_path, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(154);
			match(PALAVRA);
			}
			_ctx.stop = _input.LT(-1);
			setState(161);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new PathContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_path);
					setState(156);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(157);
					match(BARRA);
					setState(158);
					match(PALAVRA);
					}
					} 
				}
				setState(163);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ProgFileContext extends ParserRuleContext {
		public StartFileContext startFile() {
			return getRuleContext(StartFileContext.class,0);
		}
		public ProgFileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_progFile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).enterProgFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).exitProgFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptVisitor ) return ((ValidaScriptVisitor<? extends T>)visitor).visitProgFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgFileContext progFile() throws RecognitionException {
		ProgFileContext _localctx = new ProgFileContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_progFile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			match(T__13);
			setState(165);
			startFile(0);
			setState(166);
			match(T__14);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StartFileContext extends ParserRuleContext {
		public StartFileContext startFile() {
			return getRuleContext(StartFileContext.class,0);
		}
		public InfoProdutoContext infoProduto() {
			return getRuleContext(InfoProdutoContext.class,0);
		}
		public InfoClienteContext infoCliente() {
			return getRuleContext(InfoClienteContext.class,0);
		}
		public StartFileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_startFile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).enterStartFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).exitStartFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptVisitor ) return ((ValidaScriptVisitor<? extends T>)visitor).visitStartFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartFileContext startFile() throws RecognitionException {
		return startFile(0);
	}

	private StartFileContext startFile(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StartFileContext _localctx = new StartFileContext(_ctx, _parentState);
		StartFileContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_startFile, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			}
			_ctx.stop = _input.LT(-1);
			setState(181);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(179);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new StartFileContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_startFile);
						setState(169);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(170);
						match(T__15);
						setState(171);
						infoProduto();
						setState(172);
						match(T__16);
						}
						break;
					case 2:
						{
						_localctx = new StartFileContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_startFile);
						setState(174);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(175);
						match(T__17);
						setState(176);
						infoCliente();
						setState(177);
						match(T__18);
						}
						break;
					}
					} 
				}
				setState(183);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class InfoProdutoContext extends ParserRuleContext {
		public Token codigo;
		public Token preco;
		public Token categoria;
		public List<TerminalNode> INTEIRO() { return getTokens(ValidaScriptParser.INTEIRO); }
		public TerminalNode INTEIRO(int i) {
			return getToken(ValidaScriptParser.INTEIRO, i);
		}
		public TerminalNode PALAVRA() { return getToken(ValidaScriptParser.PALAVRA, 0); }
		public TerminalNode DOUBLE() { return getToken(ValidaScriptParser.DOUBLE, 0); }
		public InfoProdutoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_infoProduto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).enterInfoProduto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).exitInfoProduto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptVisitor ) return ((ValidaScriptVisitor<? extends T>)visitor).visitInfoProduto(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InfoProdutoContext infoProduto() throws RecognitionException {
		InfoProdutoContext _localctx = new InfoProdutoContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_infoProduto);
		try {
			setState(203);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(184);
				match(T__19);
				setState(185);
				((InfoProdutoContext)_localctx).codigo = match(INTEIRO);
				setState(186);
				match(T__20);
				setState(187);
				match(T__21);
				setState(188);
				((InfoProdutoContext)_localctx).preco = match(INTEIRO);
				setState(189);
				match(T__22);
				setState(190);
				match(T__23);
				setState(191);
				((InfoProdutoContext)_localctx).categoria = match(PALAVRA);
				setState(192);
				match(T__24);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(193);
				match(T__19);
				setState(194);
				((InfoProdutoContext)_localctx).codigo = match(INTEIRO);
				setState(195);
				match(T__20);
				setState(196);
				match(T__21);
				setState(197);
				((InfoProdutoContext)_localctx).preco = match(DOUBLE);
				setState(198);
				match(T__22);
				setState(199);
				match(T__23);
				setState(200);
				((InfoProdutoContext)_localctx).categoria = match(PALAVRA);
				setState(201);
				match(T__24);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InfoClienteContext extends ParserRuleContext {
		public Token numero;
		public Token escalao;
		public TerminalNode INTEIRO() { return getToken(ValidaScriptParser.INTEIRO, 0); }
		public TerminalNode PALAVRA() { return getToken(ValidaScriptParser.PALAVRA, 0); }
		public InfoClienteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_infoCliente; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).enterInfoCliente(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).exitInfoCliente(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptVisitor ) return ((ValidaScriptVisitor<? extends T>)visitor).visitInfoCliente(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InfoClienteContext infoCliente() throws RecognitionException {
		InfoClienteContext _localctx = new InfoClienteContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_infoCliente);
		try {
			setState(212);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__25:
				enterOuterAlt(_localctx, 1);
				{
				setState(205);
				match(T__25);
				setState(206);
				((InfoClienteContext)_localctx).numero = match(INTEIRO);
				setState(207);
				match(T__26);
				setState(208);
				match(T__27);
				setState(209);
				((InfoClienteContext)_localctx).escalao = match(PALAVRA);
				setState(210);
				match(T__28);
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return start_sempred((StartContext)_localctx, predIndex);
		case 16:
			return path_sempred((PathContext)_localctx, predIndex);
		case 18:
			return startFile_sempred((StartFileContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean start_sempred(StartContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean path_sempred(PathContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean startFile_sempred(StartFileContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\60\u00d9\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\3\3\3\3\3\3\3\3\3\7"+
		"\3\64\n\3\f\3\16\3\67\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4K\n\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\5\7g\n\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0081\n\13\3\f"+
		"\3\f\5\f\u0085\n\f\3\r\3\r\3\r\3\r\5\r\u008b\n\r\3\16\3\16\3\16\3\17\6"+
		"\17\u0091\n\17\r\17\16\17\u0092\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\7\22\u00a2\n\22\f\22\16\22\u00a5\13\22\3\23"+
		"\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\7\24\u00b6\n\24\f\24\16\24\u00b9\13\24\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25"+
		"\u00ce\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u00d7\n\26\3\26\2"+
		"\5\4\"&\27\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*\2\2\2\u00d7\2"+
		",\3\2\2\2\4.\3\2\2\2\6J\3\2\2\2\bL\3\2\2\2\nP\3\2\2\2\ff\3\2\2\2\16h\3"+
		"\2\2\2\20l\3\2\2\2\22p\3\2\2\2\24\u0080\3\2\2\2\26\u0084\3\2\2\2\30\u008a"+
		"\3\2\2\2\32\u008c\3\2\2\2\34\u0090\3\2\2\2\36\u0094\3\2\2\2 \u0098\3\2"+
		"\2\2\"\u009b\3\2\2\2$\u00a6\3\2\2\2&\u00aa\3\2\2\2(\u00cd\3\2\2\2*\u00d6"+
		"\3\2\2\2,-\5\4\3\2-\3\3\2\2\2./\b\3\1\2/\60\5\6\4\2\60\65\3\2\2\2\61\62"+
		"\f\4\2\2\62\64\5\6\4\2\63\61\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66"+
		"\3\2\2\2\66\5\3\2\2\2\67\65\3\2\2\289\7\3\2\29:\7,\2\2:;\7*\2\2;<\7,\2"+
		"\2<=\5 \21\2=>\7,\2\2>?\5\30\r\2?K\3\2\2\2@K\5\f\7\2AK\5\22\n\2BK\5\16"+
		"\b\2CD\7\4\2\2DE\5\b\5\2EF\7\5\2\2FG\5\n\6\2GH\7\6\2\2HK\3\2\2\2IK\5\20"+
		"\t\2J8\3\2\2\2J@\3\2\2\2JA\3\2\2\2JB\3\2\2\2JC\3\2\2\2JI\3\2\2\2K\7\3"+
		"\2\2\2LM\5\26\f\2MN\7\"\2\2NO\5\26\f\2O\t\3\2\2\2PQ\7\7\2\2QR\7+\2\2R"+
		"\13\3\2\2\2ST\7\b\2\2TU\7,\2\2UV\7.\2\2VW\7,\2\2WX\7-\2\2XY\7,\2\2YZ\5"+
		"\32\16\2Z[\7,\2\2[\\\7+\2\2\\]\7,\2\2]g\3\2\2\2^_\7\b\2\2_`\7,\2\2`a\7"+
		".\2\2ab\7,\2\2bc\5\34\17\2cd\7,\2\2de\5\32\16\2eg\3\2\2\2fS\3\2\2\2f^"+
		"\3\2\2\2g\r\3\2\2\2hi\5\36\20\2ij\7\t\2\2jk\7*\2\2k\17\3\2\2\2lm\5\36"+
		"\20\2mn\7\n\2\2no\7+\2\2o\21\3\2\2\2pq\5\36\20\2qr\7\13\2\2rs\5\24\13"+
		"\2s\23\3\2\2\2tu\5\26\f\2uv\7!\2\2vw\5\26\f\2w\u0081\3\2\2\2xy\5\26\f"+
		"\2yz\7 \2\2z{\5\26\f\2{\u0081\3\2\2\2|}\7\f\2\2}~\5\24\13\2~\177\7\r\2"+
		"\2\177\u0081\3\2\2\2\u0080t\3\2\2\2\u0080x\3\2\2\2\u0080|\3\2\2\2\u0081"+
		"\25\3\2\2\2\u0082\u0085\5\36\20\2\u0083\u0085\7*\2\2\u0084\u0082\3\2\2"+
		"\2\u0084\u0083\3\2\2\2\u0085\27\3\2\2\2\u0086\u008b\7\'\2\2\u0087\u008b"+
		"\7)\2\2\u0088\u008b\7(\2\2\u0089\u008b\3\2\2\2\u008a\u0086\3\2\2\2\u008a"+
		"\u0087\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u0089\3\2\2\2\u008b\31\3\2\2"+
		"\2\u008c\u008d\7+\2\2\u008d\u008e\7\16\2\2\u008e\33\3\2\2\2\u008f\u0091"+
		"\7-\2\2\u0090\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0090\3\2\2\2\u0092"+
		"\u0093\3\2\2\2\u0093\35\3\2\2\2\u0094\u0095\7\17\2\2\u0095\u0096\7-\2"+
		"\2\u0096\u0097\7\17\2\2\u0097\37\3\2\2\2\u0098\u0099\5\"\22\2\u0099\u009a"+
		"\7/\2\2\u009a!\3\2\2\2\u009b\u009c\b\22\1\2\u009c\u009d\7-\2\2\u009d\u00a3"+
		"\3\2\2\2\u009e\u009f\f\4\2\2\u009f\u00a0\7&\2\2\u00a0\u00a2\7-\2\2\u00a1"+
		"\u009e\3\2\2\2\u00a2\u00a5\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2"+
		"\2\2\u00a4#\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a6\u00a7\7\20\2\2\u00a7\u00a8"+
		"\5&\24\2\u00a8\u00a9\7\21\2\2\u00a9%\3\2\2\2\u00aa\u00b7\b\24\1\2\u00ab"+
		"\u00ac\f\5\2\2\u00ac\u00ad\7\22\2\2\u00ad\u00ae\5(\25\2\u00ae\u00af\7"+
		"\23\2\2\u00af\u00b6\3\2\2\2\u00b0\u00b1\f\4\2\2\u00b1\u00b2\7\24\2\2\u00b2"+
		"\u00b3\5*\26\2\u00b3\u00b4\7\25\2\2\u00b4\u00b6\3\2\2\2\u00b5\u00ab\3"+
		"\2\2\2\u00b5\u00b0\3\2\2\2\u00b6\u00b9\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7"+
		"\u00b8\3\2\2\2\u00b8\'\3\2\2\2\u00b9\u00b7\3\2\2\2\u00ba\u00bb\7\26\2"+
		"\2\u00bb\u00bc\7*\2\2\u00bc\u00bd\7\27\2\2\u00bd\u00be\7\30\2\2\u00be"+
		"\u00bf\7*\2\2\u00bf\u00c0\7\31\2\2\u00c0\u00c1\7\32\2\2\u00c1\u00c2\7"+
		"-\2\2\u00c2\u00ce\7\33\2\2\u00c3\u00c4\7\26\2\2\u00c4\u00c5\7*\2\2\u00c5"+
		"\u00c6\7\27\2\2\u00c6\u00c7\7\30\2\2\u00c7\u00c8\7+\2\2\u00c8\u00c9\7"+
		"\31\2\2\u00c9\u00ca\7\32\2\2\u00ca\u00cb\7-\2\2\u00cb\u00ce\7\33\2\2\u00cc"+
		"\u00ce\3\2\2\2\u00cd\u00ba\3\2\2\2\u00cd\u00c3\3\2\2\2\u00cd\u00cc\3\2"+
		"\2\2\u00ce)\3\2\2\2\u00cf\u00d0\7\34\2\2\u00d0\u00d1\7*\2\2\u00d1\u00d2"+
		"\7\35\2\2\u00d2\u00d3\7\36\2\2\u00d3\u00d4\7-\2\2\u00d4\u00d7\7\37\2\2"+
		"\u00d5\u00d7\3\2\2\2\u00d6\u00cf\3\2\2\2\u00d6\u00d5\3\2\2\2\u00d7+\3"+
		"\2\2\2\16\65Jf\u0080\u0084\u008a\u0092\u00a3\u00b5\u00b7\u00cd\u00d6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}