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
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, SOMA_SUB=23, MULT_DIV=24, 
		SOMA=25, SUBTRACAO=26, MULT=27, BARRA=28, ESCALAO=29, PRECO=30, CATEGORIA=31, 
		INTEIRO=32, DOUBLE=33, PONTO_VIRGULA=34, PALAVRA=35, XML=36, WS=37;
	public static final int
		RULE_prog = 0, RULE_start = 1, RULE_funcao = 2, RULE_calcPrecoTotal = 3, 
		RULE_expressao = 4, RULE_calculosMatematicos = 5, RULE_param = 6, RULE_valor_pretendido = 7, 
		RULE_nameVar = 8, RULE_ficheiro = 9, RULE_path = 10, RULE_progFile = 11, 
		RULE_startFile = 12, RULE_infoProduto = 13, RULE_infoCliente = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "start", "funcao", "calcPrecoTotal", "expressao", "calculosMatematicos", 
			"param", "valor_pretendido", "nameVar", "ficheiro", "path", "progFile", 
			"startFile", "infoProduto", "infoCliente"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Ler ficheiro'", "'->QUANT->'", "'->'", "'('", "')'", "'#'", "'<File>'", 
			"'</File>'", "'<Produto>'", "'</Produto>'", "'<Cliente>'", "'</Cliente>'", 
			"'<Codigo>'", "'</Codigo>'", "'<Preco>'", "'</Preco>'", "'<Categoria>'", 
			"'</Categoria>'", "'<Numero>'", "'</Numero>'", "'<Escalao>'", "'</Escalao>'", 
			null, null, "'+'", "'-'", "'*'", "'/'", "'Escalao'", "'Preco'", "'Categoria'", 
			null, null, "';'", null, "'.xml'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "SOMA_SUB", 
			"MULT_DIV", "SOMA", "SUBTRACAO", "MULT", "BARRA", "ESCALAO", "PRECO", 
			"CATEGORIA", "INTEIRO", "DOUBLE", "PONTO_VIRGULA", "PALAVRA", "XML", 
			"WS"
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
			setState(30);
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
			setState(33);
			funcao();
			}
			_ctx.stop = _input.LT(-1);
			setState(39);
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
					setState(35);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(36);
					funcao();
					}
					} 
				}
				setState(41);
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

	public final FuncaoContext funcao() throws RecognitionException {
		FuncaoContext _localctx = new FuncaoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_funcao);
		try {
			setState(52);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new LerFicheiroContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(42);
				match(T__0);
				setState(43);
				match(PONTO_VIRGULA);
				setState(44);
				((LerFicheiroContext)_localctx).possivel_id = match(INTEIRO);
				setState(45);
				match(PONTO_VIRGULA);
				setState(46);
				((LerFicheiroContext)_localctx).ficheiro_script = ficheiro();
				setState(47);
				match(PONTO_VIRGULA);
				setState(48);
				((LerFicheiroContext)_localctx).valor = valor_pretendido();
				}
				break;
			case 2:
				_localctx = new CalcularValorContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(50);
				expressao();
				}
				break;
			case 3:
				_localctx = new Calcular_preco_totalContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(51);
				calcPrecoTotal();
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
		enterRule(_localctx, 6, RULE_calcPrecoTotal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			((CalcPrecoTotalContext)_localctx).var = nameVar();
			setState(55);
			match(T__1);
			setState(56);
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
		enterRule(_localctx, 8, RULE_expressao);
		try {
			_localctx = new AtribuirContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			nameVar();
			setState(59);
			match(T__2);
			setState(60);
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
		enterRule(_localctx, 10, RULE_calculosMatematicos);
		try {
			setState(74);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new MultiDivContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				((MultiDivContext)_localctx).left = param();
				setState(63);
				((MultiDivContext)_localctx).sinal = match(MULT_DIV);
				setState(64);
				((MultiDivContext)_localctx).right = param();
				}
				break;
			case 2:
				_localctx = new SomaSubContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				((SomaSubContext)_localctx).left = param();
				setState(67);
				((SomaSubContext)_localctx).sinal = match(SOMA_SUB);
				setState(68);
				((SomaSubContext)_localctx).right = param();
				}
				break;
			case 3:
				_localctx = new ParentesesContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(70);
				match(T__3);
				setState(71);
				calculosMatematicos();
				setState(72);
				match(T__4);
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
		enterRule(_localctx, 12, RULE_param);
		try {
			setState(78);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				_localctx = new VariavelContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				nameVar();
				}
				break;
			case INTEIRO:
				_localctx = new ProprioValorContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
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
		enterRule(_localctx, 14, RULE_valor_pretendido);
		try {
			setState(84);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(80);
				match(ESCALAO);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(81);
				match(CATEGORIA);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(82);
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
		enterRule(_localctx, 16, RULE_nameVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(T__5);
			setState(87);
			match(PALAVRA);
			setState(88);
			match(T__5);
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
		enterRule(_localctx, 18, RULE_ficheiro);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			path(0);
			setState(91);
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
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_path, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(94);
			match(PALAVRA);
			}
			_ctx.stop = _input.LT(-1);
			setState(101);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new PathContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_path);
					setState(96);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(97);
					match(BARRA);
					setState(98);
					match(PALAVRA);
					}
					} 
				}
				setState(103);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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
		enterRule(_localctx, 22, RULE_progFile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(T__6);
			setState(105);
			startFile(0);
			setState(106);
			match(T__7);
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
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_startFile, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			}
			_ctx.stop = _input.LT(-1);
			setState(121);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(119);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new StartFileContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_startFile);
						setState(109);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(110);
						match(T__8);
						setState(111);
						infoProduto();
						setState(112);
						match(T__9);
						}
						break;
					case 2:
						{
						_localctx = new StartFileContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_startFile);
						setState(114);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(115);
						match(T__10);
						setState(116);
						infoCliente();
						setState(117);
						match(T__11);
						}
						break;
					}
					} 
				}
				setState(123);
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
		enterRule(_localctx, 26, RULE_infoProduto);
		try {
			setState(143);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(124);
				match(T__12);
				setState(125);
				((InfoProdutoContext)_localctx).codigo = match(INTEIRO);
				setState(126);
				match(T__13);
				setState(127);
				match(T__14);
				setState(128);
				((InfoProdutoContext)_localctx).preco = match(INTEIRO);
				setState(129);
				match(T__15);
				setState(130);
				match(T__16);
				setState(131);
				((InfoProdutoContext)_localctx).categoria = match(PALAVRA);
				setState(132);
				match(T__17);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(133);
				match(T__12);
				setState(134);
				((InfoProdutoContext)_localctx).codigo = match(INTEIRO);
				setState(135);
				match(T__13);
				setState(136);
				match(T__14);
				setState(137);
				((InfoProdutoContext)_localctx).preco = match(DOUBLE);
				setState(138);
				match(T__15);
				setState(139);
				match(T__16);
				setState(140);
				((InfoProdutoContext)_localctx).categoria = match(PALAVRA);
				setState(141);
				match(T__17);
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
		enterRule(_localctx, 28, RULE_infoCliente);
		try {
			setState(152);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__18:
				enterOuterAlt(_localctx, 1);
				{
				setState(145);
				match(T__18);
				setState(146);
				((InfoClienteContext)_localctx).numero = match(INTEIRO);
				setState(147);
				match(T__19);
				setState(148);
				match(T__20);
				setState(149);
				((InfoClienteContext)_localctx).escalao = match(PALAVRA);
				setState(150);
				match(T__21);
				}
				break;
			case T__11:
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
		case 10:
			return path_sempred((PathContext)_localctx, predIndex);
		case 12:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\'\u009d\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\3\3\3\3\3"+
		"\3\3\3\3\7\3(\n\3\f\3\16\3+\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\5\4\67\n\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\5\7M\n\7\3\b\3\b\5\bQ\n\b\3\t\3\t\3\t\3\t\5\t"+
		"W\n\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\7\ff\n\f"+
		"\f\f\16\fi\13\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\7\16z\n\16\f\16\16\16}\13\16\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\5\17\u0092\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u009b\n\20\3"+
		"\20\2\5\4\26\32\21\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2\2\2\u009c"+
		"\2 \3\2\2\2\4\"\3\2\2\2\6\66\3\2\2\2\b8\3\2\2\2\n<\3\2\2\2\fL\3\2\2\2"+
		"\16P\3\2\2\2\20V\3\2\2\2\22X\3\2\2\2\24\\\3\2\2\2\26_\3\2\2\2\30j\3\2"+
		"\2\2\32n\3\2\2\2\34\u0091\3\2\2\2\36\u009a\3\2\2\2 !\5\4\3\2!\3\3\2\2"+
		"\2\"#\b\3\1\2#$\5\6\4\2$)\3\2\2\2%&\f\4\2\2&(\5\6\4\2\'%\3\2\2\2(+\3\2"+
		"\2\2)\'\3\2\2\2)*\3\2\2\2*\5\3\2\2\2+)\3\2\2\2,-\7\3\2\2-.\7$\2\2./\7"+
		"\"\2\2/\60\7$\2\2\60\61\5\24\13\2\61\62\7$\2\2\62\63\5\20\t\2\63\67\3"+
		"\2\2\2\64\67\5\n\6\2\65\67\5\b\5\2\66,\3\2\2\2\66\64\3\2\2\2\66\65\3\2"+
		"\2\2\67\7\3\2\2\289\5\22\n\29:\7\4\2\2:;\7\"\2\2;\t\3\2\2\2<=\5\22\n\2"+
		"=>\7\5\2\2>?\5\f\7\2?\13\3\2\2\2@A\5\16\b\2AB\7\32\2\2BC\5\16\b\2CM\3"+
		"\2\2\2DE\5\16\b\2EF\7\31\2\2FG\5\16\b\2GM\3\2\2\2HI\7\6\2\2IJ\5\f\7\2"+
		"JK\7\7\2\2KM\3\2\2\2L@\3\2\2\2LD\3\2\2\2LH\3\2\2\2M\r\3\2\2\2NQ\5\22\n"+
		"\2OQ\7\"\2\2PN\3\2\2\2PO\3\2\2\2Q\17\3\2\2\2RW\7\37\2\2SW\7!\2\2TW\7 "+
		"\2\2UW\3\2\2\2VR\3\2\2\2VS\3\2\2\2VT\3\2\2\2VU\3\2\2\2W\21\3\2\2\2XY\7"+
		"\b\2\2YZ\7%\2\2Z[\7\b\2\2[\23\3\2\2\2\\]\5\26\f\2]^\7&\2\2^\25\3\2\2\2"+
		"_`\b\f\1\2`a\7%\2\2ag\3\2\2\2bc\f\4\2\2cd\7\36\2\2df\7%\2\2eb\3\2\2\2"+
		"fi\3\2\2\2ge\3\2\2\2gh\3\2\2\2h\27\3\2\2\2ig\3\2\2\2jk\7\t\2\2kl\5\32"+
		"\16\2lm\7\n\2\2m\31\3\2\2\2n{\b\16\1\2op\f\5\2\2pq\7\13\2\2qr\5\34\17"+
		"\2rs\7\f\2\2sz\3\2\2\2tu\f\4\2\2uv\7\r\2\2vw\5\36\20\2wx\7\16\2\2xz\3"+
		"\2\2\2yo\3\2\2\2yt\3\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3\2\2\2|\33\3\2\2\2}"+
		"{\3\2\2\2~\177\7\17\2\2\177\u0080\7\"\2\2\u0080\u0081\7\20\2\2\u0081\u0082"+
		"\7\21\2\2\u0082\u0083\7\"\2\2\u0083\u0084\7\22\2\2\u0084\u0085\7\23\2"+
		"\2\u0085\u0086\7%\2\2\u0086\u0092\7\24\2\2\u0087\u0088\7\17\2\2\u0088"+
		"\u0089\7\"\2\2\u0089\u008a\7\20\2\2\u008a\u008b\7\21\2\2\u008b\u008c\7"+
		"#\2\2\u008c\u008d\7\22\2\2\u008d\u008e\7\23\2\2\u008e\u008f\7%\2\2\u008f"+
		"\u0092\7\24\2\2\u0090\u0092\3\2\2\2\u0091~\3\2\2\2\u0091\u0087\3\2\2\2"+
		"\u0091\u0090\3\2\2\2\u0092\35\3\2\2\2\u0093\u0094\7\25\2\2\u0094\u0095"+
		"\7\"\2\2\u0095\u0096\7\26\2\2\u0096\u0097\7\27\2\2\u0097\u0098\7%\2\2"+
		"\u0098\u009b\7\30\2\2\u0099\u009b\3\2\2\2\u009a\u0093\3\2\2\2\u009a\u0099"+
		"\3\2\2\2\u009b\37\3\2\2\2\f)\66LPVgy{\u0091\u009a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}