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
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, SOMA_SUB=35, MULT_DIV=36, SINAL_BOOLEANO=37, 
		SOMA=38, SUBTRACAO=39, MULT=40, BARRA=41, ESCALAO=42, PRECO=43, CATEGORIA=44, 
		INTEIRO=45, DOUBLE=46, PONTO_VIRGULA=47, PALAVRA=48, EMAIL=49, XML=50, 
		WS=51;
	public static final int
		RULE_prog = 0, RULE_start = 1, RULE_funcao = 2, RULE_else1 = 3, RULE_expressao_a_verificar = 4, 
		RULE_aplicar_desconto = 5, RULE_expressao = 6, RULE_calculosMatematicos = 7, 
		RULE_param = 8, RULE_valor_pretendido = 9, RULE_percentagem = 10, RULE_frase = 11, 
		RULE_nameVar = 12, RULE_ficheiro = 13, RULE_path = 14, RULE_progFile = 15, 
		RULE_startFile = 16, RULE_infoProduto = 17, RULE_infoCliente = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "start", "funcao", "else1", "expressao_a_verificar", "aplicar_desconto", 
			"expressao", "calculosMatematicos", "param", "valor_pretendido", "percentagem", 
			"frase", "nameVar", "ficheiro", "path", "progFile", "startFile", "infoProduto", 
			"infoCliente"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Ler ficheiro'", "'if '", "' then:'", "'end if;'", "'Valor total'", 
			"'Send Email to: '", "' Valor:'", "'else'", "'CATEGORIA'", "'=='", "'!='", 
			"'Aplicar Desconto->'", "'->'", "'('", "')'", "'%'", "' '", "'#'", "'<File>'", 
			"'</File>'", "'<Produto>'", "'</Produto>'", "'<Cliente>'", "'</Cliente>'", 
			"'<Codigo>'", "'</Codigo>'", "'<Preco>'", "'</Preco>'", "'<Categoria>'", 
			"'</Categoria>'", "'<Numero>'", "'</Numero>'", "'<Escalao>'", "'</Escalao>'", 
			null, null, null, "'+'", "'-'", "'*'", "'/'", "'Escalao'", "'Preco'", 
			"'Categoria'", null, null, "';'", null, null, "'.xml'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "SOMA_SUB", 
			"MULT_DIV", "SINAL_BOOLEANO", "SOMA", "SUBTRACAO", "MULT", "BARRA", "ESCALAO", 
			"PRECO", "CATEGORIA", "INTEIRO", "DOUBLE", "PONTO_VIRGULA", "PALAVRA", 
			"EMAIL", "XML", "WS"
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
			setState(38);
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
			setState(41);
			funcao();
			}
			_ctx.stop = _input.LT(-1);
			setState(47);
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
					setState(43);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(44);
					funcao();
					}
					} 
				}
				setState(49);
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
	public static class SendEmailContext extends FuncaoContext {
		public Token email;
		public TerminalNode EMAIL() { return getToken(ValidaScriptParser.EMAIL, 0); }
		public SendEmailContext(FuncaoContext ctx) { copyFrom(ctx); }
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
	public static class AplicarDescontoContext extends FuncaoContext {
		public Else1Context temElse;
		public Expressao_a_verificarContext expressao_a_verificar() {
			return getRuleContext(Expressao_a_verificarContext.class,0);
		}
		public Aplicar_descontoContext aplicar_desconto() {
			return getRuleContext(Aplicar_descontoContext.class,0);
		}
		public Else1Context else1() {
			return getRuleContext(Else1Context.class,0);
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
	public static class SendEmailCalculosContext extends FuncaoContext {
		public Token email;
		public NameVarContext varValor;
		public TerminalNode EMAIL() { return getToken(ValidaScriptParser.EMAIL, 0); }
		public NameVarContext nameVar() {
			return getRuleContext(NameVarContext.class,0);
		}
		public SendEmailCalculosContext(FuncaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).enterSendEmailCalculos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).exitSendEmailCalculos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptVisitor ) return ((ValidaScriptVisitor<? extends T>)visitor).visitSendEmailCalculos(this);
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
	public static class CalcularDescontoEPrecoContext extends FuncaoContext {
		public CalcularDescontoEPrecoContext(FuncaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).enterCalcularDescontoEPreco(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).exitCalcularDescontoEPreco(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptVisitor ) return ((ValidaScriptVisitor<? extends T>)visitor).visitCalcularDescontoEPreco(this);
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

	public final FuncaoContext funcao() throws RecognitionException {
		FuncaoContext _localctx = new FuncaoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_funcao);
		int _la;
		try {
			setState(76);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new LerFicheiroContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(50);
				match(T__0);
				setState(51);
				match(PONTO_VIRGULA);
				setState(52);
				((LerFicheiroContext)_localctx).possivel_id = match(INTEIRO);
				setState(53);
				match(PONTO_VIRGULA);
				setState(54);
				((LerFicheiroContext)_localctx).ficheiro_script = ficheiro();
				setState(57);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(55);
					match(PONTO_VIRGULA);
					setState(56);
					((LerFicheiroContext)_localctx).valor = valor_pretendido();
					}
					break;
				}
				}
				break;
			case 2:
				_localctx = new CalcularValorContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
				expressao();
				}
				break;
			case 3:
				_localctx = new AplicarDescontoContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(60);
				match(T__1);
				setState(61);
				expressao_a_verificar();
				setState(62);
				match(T__2);
				setState(63);
				aplicar_desconto();
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__7) {
					{
					setState(64);
					((AplicarDescontoContext)_localctx).temElse = else1();
					}
				}

				setState(67);
				match(T__3);
				}
				break;
			case 4:
				_localctx = new CalcularDescontoEPrecoContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(69);
				match(T__4);
				}
				break;
			case 5:
				_localctx = new SendEmailContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(70);
				match(T__5);
				setState(71);
				((SendEmailContext)_localctx).email = match(EMAIL);
				}
				break;
			case 6:
				_localctx = new SendEmailCalculosContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(72);
				match(T__5);
				setState(73);
				((SendEmailCalculosContext)_localctx).email = match(EMAIL);
				setState(74);
				match(T__6);
				setState(75);
				((SendEmailCalculosContext)_localctx).varValor = nameVar();
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

	public static class Else1Context extends ParserRuleContext {
		public Aplicar_descontoContext aplicar_desconto() {
			return getRuleContext(Aplicar_descontoContext.class,0);
		}
		public Else1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).enterElse1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).exitElse1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptVisitor ) return ((ValidaScriptVisitor<? extends T>)visitor).visitElse1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Else1Context else1() throws RecognitionException {
		Else1Context _localctx = new Else1Context(_ctx, getState());
		enterRule(_localctx, 6, RULE_else1);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(T__7);
			setState(79);
			aplicar_desconto();
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
		public ParamContext leftPortion;
		public Token sinal;
		public ParamContext rightPortion;
		public Token leftPortionCat;
		public Token rightPortionCat;
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public TerminalNode SINAL_BOOLEANO() { return getToken(ValidaScriptParser.SINAL_BOOLEANO, 0); }
		public TerminalNode PALAVRA() { return getToken(ValidaScriptParser.PALAVRA, 0); }
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
		int _la;
		try {
			setState(88);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__17:
			case INTEIRO:
			case DOUBLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(81);
				((Expressao_a_verificarContext)_localctx).leftPortion = param();
				setState(82);
				((Expressao_a_verificarContext)_localctx).sinal = match(SINAL_BOOLEANO);
				setState(83);
				((Expressao_a_verificarContext)_localctx).rightPortion = param();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(85);
				((Expressao_a_verificarContext)_localctx).leftPortionCat = match(T__8);
				setState(86);
				((Expressao_a_verificarContext)_localctx).sinal = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__9 || _la==T__10) ) {
					((Expressao_a_verificarContext)_localctx).sinal = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(87);
				((Expressao_a_verificarContext)_localctx).rightPortionCat = match(PALAVRA);
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

	public static class Aplicar_descontoContext extends ParserRuleContext {
		public ParamContext valorDesconto;
		public ParamContext param() {
			return getRuleContext(ParamContext.class,0);
		}
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
		enterRule(_localctx, 10, RULE_aplicar_desconto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(T__11);
			setState(91);
			((Aplicar_descontoContext)_localctx).valorDesconto = param();
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
		enterRule(_localctx, 12, RULE_expressao);
		try {
			_localctx = new AtribuirContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			nameVar();
			setState(94);
			match(T__12);
			setState(95);
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
	public static class AtribuiInteiroContext extends CalculosMatematicosContext {
		public TerminalNode INTEIRO() { return getToken(ValidaScriptParser.INTEIRO, 0); }
		public AtribuiInteiroContext(CalculosMatematicosContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).enterAtribuiInteiro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).exitAtribuiInteiro(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptVisitor ) return ((ValidaScriptVisitor<? extends T>)visitor).visitAtribuiInteiro(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AtribuiDoubleContext extends CalculosMatematicosContext {
		public TerminalNode DOUBLE() { return getToken(ValidaScriptParser.DOUBLE, 0); }
		public AtribuiDoubleContext(CalculosMatematicosContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).enterAtribuiDouble(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).exitAtribuiDouble(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptVisitor ) return ((ValidaScriptVisitor<? extends T>)visitor).visitAtribuiDouble(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CalculosMatematicosContext calculosMatematicos() throws RecognitionException {
		CalculosMatematicosContext _localctx = new CalculosMatematicosContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_calculosMatematicos);
		try {
			setState(111);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new MultiDivContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(97);
				((MultiDivContext)_localctx).left = param();
				setState(98);
				((MultiDivContext)_localctx).sinal = match(MULT_DIV);
				setState(99);
				((MultiDivContext)_localctx).right = param();
				}
				break;
			case 2:
				_localctx = new SomaSubContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(101);
				((SomaSubContext)_localctx).left = param();
				setState(102);
				((SomaSubContext)_localctx).sinal = match(SOMA_SUB);
				setState(103);
				((SomaSubContext)_localctx).right = param();
				}
				break;
			case 3:
				_localctx = new ParentesesContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(105);
				match(T__13);
				setState(106);
				calculosMatematicos();
				setState(107);
				match(T__14);
				}
				break;
			case 4:
				_localctx = new AtribuiInteiroContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(109);
				match(INTEIRO);
				}
				break;
			case 5:
				_localctx = new AtribuiDoubleContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(110);
				match(DOUBLE);
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
	public static class ValorDoubleContext extends ParamContext {
		public TerminalNode DOUBLE() { return getToken(ValidaScriptParser.DOUBLE, 0); }
		public ValorDoubleContext(ParamContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).enterValorDouble(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).exitValorDouble(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptVisitor ) return ((ValidaScriptVisitor<? extends T>)visitor).visitValorDouble(this);
			else return visitor.visitChildren(this);
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
		enterRule(_localctx, 16, RULE_param);
		try {
			setState(116);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__17:
				_localctx = new VariavelContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(113);
				nameVar();
				}
				break;
			case INTEIRO:
				_localctx = new ProprioValorContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(114);
				match(INTEIRO);
				}
				break;
			case DOUBLE:
				_localctx = new ValorDoubleContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(115);
				match(DOUBLE);
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
		enterRule(_localctx, 18, RULE_valor_pretendido);
		try {
			setState(122);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(118);
				match(ESCALAO);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(119);
				match(CATEGORIA);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(120);
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
		public TerminalNode INTEIRO() { return getToken(ValidaScriptParser.INTEIRO, 0); }
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
		enterRule(_localctx, 20, RULE_percentagem);
		try {
			setState(128);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOUBLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(124);
				match(DOUBLE);
				setState(125);
				match(T__15);
				}
				break;
			case INTEIRO:
				enterOuterAlt(_localctx, 2);
				{
				setState(126);
				match(INTEIRO);
				setState(127);
				match(T__15);
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

	public static class FraseContext extends ParserRuleContext {
		public TerminalNode PALAVRA() { return getToken(ValidaScriptParser.PALAVRA, 0); }
		public FraseContext frase() {
			return getRuleContext(FraseContext.class,0);
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
		return frase(0);
	}

	private FraseContext frase(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FraseContext _localctx = new FraseContext(_ctx, _parentState);
		FraseContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_frase, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(131);
			match(PALAVRA);
			}
			_ctx.stop = _input.LT(-1);
			setState(138);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new FraseContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_frase);
					setState(133);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(134);
					match(PALAVRA);
					setState(135);
					match(T__16);
					}
					} 
				}
				setState(140);
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
		enterRule(_localctx, 24, RULE_nameVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(T__17);
			setState(142);
			match(PALAVRA);
			setState(143);
			match(T__17);
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
		enterRule(_localctx, 26, RULE_ficheiro);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			path(0);
			setState(146);
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
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_path, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(149);
			match(PALAVRA);
			}
			_ctx.stop = _input.LT(-1);
			setState(156);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new PathContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_path);
					setState(151);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(152);
					match(BARRA);
					setState(153);
					match(PALAVRA);
					}
					} 
				}
				setState(158);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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
		enterRule(_localctx, 30, RULE_progFile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(T__18);
			setState(160);
			startFile(0);
			setState(161);
			match(T__19);
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
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_startFile, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			}
			_ctx.stop = _input.LT(-1);
			setState(176);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(174);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new StartFileContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_startFile);
						setState(164);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(165);
						match(T__20);
						setState(166);
						infoProduto();
						setState(167);
						match(T__21);
						}
						break;
					case 2:
						{
						_localctx = new StartFileContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_startFile);
						setState(169);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(170);
						match(T__22);
						setState(171);
						infoCliente();
						setState(172);
						match(T__23);
						}
						break;
					}
					} 
				}
				setState(178);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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
		enterRule(_localctx, 34, RULE_infoProduto);
		try {
			setState(198);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(179);
				match(T__24);
				setState(180);
				((InfoProdutoContext)_localctx).codigo = match(INTEIRO);
				setState(181);
				match(T__25);
				setState(182);
				match(T__26);
				setState(183);
				((InfoProdutoContext)_localctx).preco = match(INTEIRO);
				setState(184);
				match(T__27);
				setState(185);
				match(T__28);
				setState(186);
				((InfoProdutoContext)_localctx).categoria = match(PALAVRA);
				setState(187);
				match(T__29);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(188);
				match(T__24);
				setState(189);
				((InfoProdutoContext)_localctx).codigo = match(INTEIRO);
				setState(190);
				match(T__25);
				setState(191);
				match(T__26);
				setState(192);
				((InfoProdutoContext)_localctx).preco = match(DOUBLE);
				setState(193);
				match(T__27);
				setState(194);
				match(T__28);
				setState(195);
				((InfoProdutoContext)_localctx).categoria = match(PALAVRA);
				setState(196);
				match(T__29);
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
		enterRule(_localctx, 36, RULE_infoCliente);
		try {
			setState(207);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__30:
				enterOuterAlt(_localctx, 1);
				{
				setState(200);
				match(T__30);
				setState(201);
				((InfoClienteContext)_localctx).numero = match(INTEIRO);
				setState(202);
				match(T__31);
				setState(203);
				match(T__32);
				setState(204);
				((InfoClienteContext)_localctx).escalao = match(PALAVRA);
				setState(205);
				match(T__33);
				}
				break;
			case T__23:
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
		case 11:
			return frase_sempred((FraseContext)_localctx, predIndex);
		case 14:
			return path_sempred((PathContext)_localctx, predIndex);
		case 16:
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
	private boolean frase_sempred(FraseContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean path_sempred(PathContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean startFile_sempred(StartFileContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\65\u00d4\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\3\3\3\3\3\3\3\3\3\7\3\60\n\3\f\3\16\3\63"+
		"\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4<\n\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4"+
		"D\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4O\n\4\3\5\3\5\3\5\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\5\6[\n\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tr\n\t\3\n\3\n\3\n\5\n"+
		"w\n\n\3\13\3\13\3\13\3\13\5\13}\n\13\3\f\3\f\3\f\3\f\5\f\u0083\n\f\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\7\r\u008b\n\r\f\r\16\r\u008e\13\r\3\16\3\16\3\16"+
		"\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u009d\n\20\f\20"+
		"\16\20\u00a0\13\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\7\22\u00b1\n\22\f\22\16\22\u00b4\13\22\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\5\23\u00c9\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\5\24\u00d2\n\24\3\24\2\6\4\30\36\"\25\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&\2\3\3\2\f\r\2\u00da\2(\3\2\2\2\4*\3\2\2\2\6N\3\2\2\2\bP\3"+
		"\2\2\2\nZ\3\2\2\2\f\\\3\2\2\2\16_\3\2\2\2\20q\3\2\2\2\22v\3\2\2\2\24|"+
		"\3\2\2\2\26\u0082\3\2\2\2\30\u0084\3\2\2\2\32\u008f\3\2\2\2\34\u0093\3"+
		"\2\2\2\36\u0096\3\2\2\2 \u00a1\3\2\2\2\"\u00a5\3\2\2\2$\u00c8\3\2\2\2"+
		"&\u00d1\3\2\2\2()\5\4\3\2)\3\3\2\2\2*+\b\3\1\2+,\5\6\4\2,\61\3\2\2\2-"+
		".\f\4\2\2.\60\5\6\4\2/-\3\2\2\2\60\63\3\2\2\2\61/\3\2\2\2\61\62\3\2\2"+
		"\2\62\5\3\2\2\2\63\61\3\2\2\2\64\65\7\3\2\2\65\66\7\61\2\2\66\67\7/\2"+
		"\2\678\7\61\2\28;\5\34\17\29:\7\61\2\2:<\5\24\13\2;9\3\2\2\2;<\3\2\2\2"+
		"<O\3\2\2\2=O\5\16\b\2>?\7\4\2\2?@\5\n\6\2@A\7\5\2\2AC\5\f\7\2BD\5\b\5"+
		"\2CB\3\2\2\2CD\3\2\2\2DE\3\2\2\2EF\7\6\2\2FO\3\2\2\2GO\7\7\2\2HI\7\b\2"+
		"\2IO\7\63\2\2JK\7\b\2\2KL\7\63\2\2LM\7\t\2\2MO\5\32\16\2N\64\3\2\2\2N"+
		"=\3\2\2\2N>\3\2\2\2NG\3\2\2\2NH\3\2\2\2NJ\3\2\2\2O\7\3\2\2\2PQ\7\n\2\2"+
		"QR\5\f\7\2R\t\3\2\2\2ST\5\22\n\2TU\7\'\2\2UV\5\22\n\2V[\3\2\2\2WX\7\13"+
		"\2\2XY\t\2\2\2Y[\7\62\2\2ZS\3\2\2\2ZW\3\2\2\2[\13\3\2\2\2\\]\7\16\2\2"+
		"]^\5\22\n\2^\r\3\2\2\2_`\5\32\16\2`a\7\17\2\2ab\5\20\t\2b\17\3\2\2\2c"+
		"d\5\22\n\2de\7&\2\2ef\5\22\n\2fr\3\2\2\2gh\5\22\n\2hi\7%\2\2ij\5\22\n"+
		"\2jr\3\2\2\2kl\7\20\2\2lm\5\20\t\2mn\7\21\2\2nr\3\2\2\2or\7/\2\2pr\7\60"+
		"\2\2qc\3\2\2\2qg\3\2\2\2qk\3\2\2\2qo\3\2\2\2qp\3\2\2\2r\21\3\2\2\2sw\5"+
		"\32\16\2tw\7/\2\2uw\7\60\2\2vs\3\2\2\2vt\3\2\2\2vu\3\2\2\2w\23\3\2\2\2"+
		"x}\7,\2\2y}\7.\2\2z}\7-\2\2{}\3\2\2\2|x\3\2\2\2|y\3\2\2\2|z\3\2\2\2|{"+
		"\3\2\2\2}\25\3\2\2\2~\177\7\60\2\2\177\u0083\7\22\2\2\u0080\u0081\7/\2"+
		"\2\u0081\u0083\7\22\2\2\u0082~\3\2\2\2\u0082\u0080\3\2\2\2\u0083\27\3"+
		"\2\2\2\u0084\u0085\b\r\1\2\u0085\u0086\7\62\2\2\u0086\u008c\3\2\2\2\u0087"+
		"\u0088\f\4\2\2\u0088\u0089\7\62\2\2\u0089\u008b\7\23\2\2\u008a\u0087\3"+
		"\2\2\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d"+
		"\31\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u0090\7\24\2\2\u0090\u0091\7\62"+
		"\2\2\u0091\u0092\7\24\2\2\u0092\33\3\2\2\2\u0093\u0094\5\36\20\2\u0094"+
		"\u0095\7\64\2\2\u0095\35\3\2\2\2\u0096\u0097\b\20\1\2\u0097\u0098\7\62"+
		"\2\2\u0098\u009e\3\2\2\2\u0099\u009a\f\4\2\2\u009a\u009b\7+\2\2\u009b"+
		"\u009d\7\62\2\2\u009c\u0099\3\2\2\2\u009d\u00a0\3\2\2\2\u009e\u009c\3"+
		"\2\2\2\u009e\u009f\3\2\2\2\u009f\37\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1"+
		"\u00a2\7\25\2\2\u00a2\u00a3\5\"\22\2\u00a3\u00a4\7\26\2\2\u00a4!\3\2\2"+
		"\2\u00a5\u00b2\b\22\1\2\u00a6\u00a7\f\5\2\2\u00a7\u00a8\7\27\2\2\u00a8"+
		"\u00a9\5$\23\2\u00a9\u00aa\7\30\2\2\u00aa\u00b1\3\2\2\2\u00ab\u00ac\f"+
		"\4\2\2\u00ac\u00ad\7\31\2\2\u00ad\u00ae\5&\24\2\u00ae\u00af\7\32\2\2\u00af"+
		"\u00b1\3\2\2\2\u00b0\u00a6\3\2\2\2\u00b0\u00ab\3\2\2\2\u00b1\u00b4\3\2"+
		"\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3#\3\2\2\2\u00b4\u00b2"+
		"\3\2\2\2\u00b5\u00b6\7\33\2\2\u00b6\u00b7\7/\2\2\u00b7\u00b8\7\34\2\2"+
		"\u00b8\u00b9\7\35\2\2\u00b9\u00ba\7/\2\2\u00ba\u00bb\7\36\2\2\u00bb\u00bc"+
		"\7\37\2\2\u00bc\u00bd\7\62\2\2\u00bd\u00c9\7 \2\2\u00be\u00bf\7\33\2\2"+
		"\u00bf\u00c0\7/\2\2\u00c0\u00c1\7\34\2\2\u00c1\u00c2\7\35\2\2\u00c2\u00c3"+
		"\7\60\2\2\u00c3\u00c4\7\36\2\2\u00c4\u00c5\7\37\2\2\u00c5\u00c6\7\62\2"+
		"\2\u00c6\u00c9\7 \2\2\u00c7\u00c9\3\2\2\2\u00c8\u00b5\3\2\2\2\u00c8\u00be"+
		"\3\2\2\2\u00c8\u00c7\3\2\2\2\u00c9%\3\2\2\2\u00ca\u00cb\7!\2\2\u00cb\u00cc"+
		"\7/\2\2\u00cc\u00cd\7\"\2\2\u00cd\u00ce\7#\2\2\u00ce\u00cf\7\62\2\2\u00cf"+
		"\u00d2\7$\2\2\u00d0\u00d2\3\2\2\2\u00d1\u00ca\3\2\2\2\u00d1\u00d0\3\2"+
		"\2\2\u00d2\'\3\2\2\2\21\61;CNZqv|\u0082\u008c\u009e\u00b0\u00b2\u00c8"+
		"\u00d1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}