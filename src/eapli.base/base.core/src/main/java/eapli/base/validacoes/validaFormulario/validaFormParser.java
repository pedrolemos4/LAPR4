// Generated from C:/Users/Tiago/Desktop/LAPR4/lei20_21_s4_2di_04/src/eapli.base/base.core/src/main/java/eapli/base/validacoes/validaFormulario\validaForm.g4 by ANTLR 4.9.1
package eapli.base.validacoes.validaFormulario;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class validaFormParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PR=1, PRD=2, PV=3, TITULO=4, STRING=5, INTEGER=6, DATA=7, TIPO_DADOS=8, 
		OBRIGATORIO=9, WS=10;
	public static final int
		RULE_regra = 0, RULE_atributo = 1, RULE_nome = 2, RULE_desc = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"regra", "atributo", "nome", "desc"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'['", "']'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PR", "PRD", "PV", "TITULO", "STRING", "INTEGER", "DATA", "TIPO_DADOS", 
			"OBRIGATORIO", "WS"
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
	public String getGrammarFileName() { return "validaForm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public validaFormParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class RegraContext extends ParserRuleContext {
		public RegraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regra; }
	 
		public RegraContext() { }
		public void copyFrom(RegraContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ValidoContext extends RegraContext {
		public TerminalNode TITULO() { return getToken(validaFormParser.TITULO, 0); }
		public TerminalNode PV() { return getToken(validaFormParser.PV, 0); }
		public TerminalNode PR() { return getToken(validaFormParser.PR, 0); }
		public AtributoContext atributo() {
			return getRuleContext(AtributoContext.class,0);
		}
		public TerminalNode PRD() { return getToken(validaFormParser.PRD, 0); }
		public ValidoContext(RegraContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validaFormListener ) ((validaFormListener)listener).enterValido(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validaFormListener ) ((validaFormListener)listener).exitValido(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validaFormVisitor ) return ((validaFormVisitor<? extends T>)visitor).visitValido(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InvalidoContext extends RegraContext {
		public TerminalNode TITULO() { return getToken(validaFormParser.TITULO, 0); }
		public InvalidoContext(RegraContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validaFormListener ) ((validaFormListener)listener).enterInvalido(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validaFormListener ) ((validaFormListener)listener).exitInvalido(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validaFormVisitor ) return ((validaFormVisitor<? extends T>)visitor).visitInvalido(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VazioContext extends RegraContext {
		public VazioContext(RegraContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validaFormListener ) ((validaFormListener)listener).enterVazio(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validaFormListener ) ((validaFormListener)listener).exitVazio(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validaFormVisitor ) return ((validaFormVisitor<? extends T>)visitor).visitVazio(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RegraContext regra() throws RecognitionException {
		RegraContext _localctx = new RegraContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_regra);
		try {
			setState(16);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new ValidoContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(8);
				match(TITULO);
				setState(9);
				match(PV);
				setState(10);
				match(PR);
				setState(11);
				atributo(0);
				setState(12);
				match(PRD);
				}
				break;
			case 2:
				_localctx = new InvalidoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(14);
				match(TITULO);
				}
				break;
			case 3:
				_localctx = new VazioContext(_localctx);
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

	public static class AtributoContext extends ParserRuleContext {
		public AtributoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atributo; }
	 
		public AtributoContext() { }
		public void copyFrom(AtributoContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Invalido2Context extends AtributoContext {
		public TerminalNode STRING() { return getToken(validaFormParser.STRING, 0); }
		public TerminalNode TIPO_DADOS() { return getToken(validaFormParser.TIPO_DADOS, 0); }
		public TerminalNode OBRIGATORIO() { return getToken(validaFormParser.OBRIGATORIO, 0); }
		public Invalido2Context(AtributoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validaFormListener ) ((validaFormListener)listener).enterInvalido2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validaFormListener ) ((validaFormListener)listener).exitInvalido2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validaFormVisitor ) return ((validaFormVisitor<? extends T>)visitor).visitInvalido2(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Vazio1Context extends AtributoContext {
		public Vazio1Context(AtributoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validaFormListener ) ((validaFormListener)listener).enterVazio1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validaFormListener ) ((validaFormListener)listener).exitVazio1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validaFormVisitor ) return ((validaFormVisitor<? extends T>)visitor).visitVazio1(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Valido2Context extends AtributoContext {
		public NomeContext var;
		public Token label;
		public DescContext des;
		public Token tp;
		public Token obr;
		public AtributoContext atributo() {
			return getRuleContext(AtributoContext.class,0);
		}
		public List<TerminalNode> PV() { return getTokens(validaFormParser.PV); }
		public TerminalNode PV(int i) {
			return getToken(validaFormParser.PV, i);
		}
		public TerminalNode STRING() { return getToken(validaFormParser.STRING, 0); }
		public DescContext desc() {
			return getRuleContext(DescContext.class,0);
		}
		public TerminalNode TIPO_DADOS() { return getToken(validaFormParser.TIPO_DADOS, 0); }
		public TerminalNode OBRIGATORIO() { return getToken(validaFormParser.OBRIGATORIO, 0); }
		public NomeContext nome() {
			return getRuleContext(NomeContext.class,0);
		}
		public Valido2Context(AtributoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validaFormListener ) ((validaFormListener)listener).enterValido2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validaFormListener ) ((validaFormListener)listener).exitValido2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validaFormVisitor ) return ((validaFormVisitor<? extends T>)visitor).visitValido2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtributoContext atributo() throws RecognitionException {
		return atributo(0);
	}

	private AtributoContext atributo(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AtributoContext _localctx = new AtributoContext(_ctx, _parentState);
		AtributoContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_atributo, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(23);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				_localctx = new Invalido2Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(19);
				match(STRING);
				}
				break;
			case 2:
				{
				_localctx = new Invalido2Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(20);
				match(TIPO_DADOS);
				}
				break;
			case 3:
				{
				_localctx = new Invalido2Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(21);
				match(OBRIGATORIO);
				}
				break;
			case 4:
				{
				_localctx = new Vazio1Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(40);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Valido2Context(new AtributoContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_atributo);
					setState(25);
					if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
					setState(27);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING) | (1L << INTEGER) | (1L << DATA))) != 0)) {
						{
						setState(26);
						((Valido2Context)_localctx).var = nome();
						}
					}

					setState(29);
					match(PV);
					setState(30);
					((Valido2Context)_localctx).label = match(STRING);
					setState(31);
					match(PV);
					setState(32);
					((Valido2Context)_localctx).des = desc();
					setState(33);
					match(PV);
					setState(34);
					((Valido2Context)_localctx).tp = match(TIPO_DADOS);
					setState(35);
					match(PV);
					setState(36);
					((Valido2Context)_localctx).obr = match(OBRIGATORIO);
					}
					} 
				}
				setState(42);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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

	public static class NomeContext extends ParserRuleContext {
		public NomeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nome; }
	 
		public NomeContext() { }
		public void copyFrom(NomeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ValidoIntegerContext extends NomeContext {
		public TerminalNode INTEGER() { return getToken(validaFormParser.INTEGER, 0); }
		public ValidoIntegerContext(NomeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validaFormListener ) ((validaFormListener)listener).enterValidoInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validaFormListener ) ((validaFormListener)listener).exitValidoInteger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validaFormVisitor ) return ((validaFormVisitor<? extends T>)visitor).visitValidoInteger(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ValidoDataContext extends NomeContext {
		public TerminalNode DATA() { return getToken(validaFormParser.DATA, 0); }
		public ValidoDataContext(NomeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validaFormListener ) ((validaFormListener)listener).enterValidoData(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validaFormListener ) ((validaFormListener)listener).exitValidoData(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validaFormVisitor ) return ((validaFormVisitor<? extends T>)visitor).visitValidoData(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ValidoStringContext extends NomeContext {
		public TerminalNode STRING() { return getToken(validaFormParser.STRING, 0); }
		public ValidoStringContext(NomeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validaFormListener ) ((validaFormListener)listener).enterValidoString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validaFormListener ) ((validaFormListener)listener).exitValidoString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validaFormVisitor ) return ((validaFormVisitor<? extends T>)visitor).visitValidoString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NomeContext nome() throws RecognitionException {
		NomeContext _localctx = new NomeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_nome);
		try {
			setState(46);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				_localctx = new ValidoStringContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(43);
				match(STRING);
				}
				break;
			case INTEGER:
				_localctx = new ValidoIntegerContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(44);
				match(INTEGER);
				}
				break;
			case DATA:
				_localctx = new ValidoDataContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(45);
				match(DATA);
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

	public static class DescContext extends ParserRuleContext {
		public DescContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_desc; }
	 
		public DescContext() { }
		public void copyFrom(DescContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ValidoDescContext extends DescContext {
		public List<TerminalNode> STRING() { return getTokens(validaFormParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(validaFormParser.STRING, i);
		}
		public ValidoDescContext(DescContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validaFormListener ) ((validaFormListener)listener).enterValidoDesc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validaFormListener ) ((validaFormListener)listener).exitValidoDesc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validaFormVisitor ) return ((validaFormVisitor<? extends T>)visitor).visitValidoDesc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DescContext desc() throws RecognitionException {
		DescContext _localctx = new DescContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_desc);
		int _la;
		try {
			_localctx = new ValidoDescContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==STRING) {
				{
				{
				setState(48);
				match(STRING);
				}
				}
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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
			return atributo_sempred((AtributoContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean atributo_sempred(AtributoContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\f9\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\23\n\2\3\3\3\3"+
		"\3\3\3\3\3\3\5\3\32\n\3\3\3\3\3\5\3\36\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\7\3)\n\3\f\3\16\3,\13\3\3\4\3\4\3\4\5\4\61\n\4\3\5\7\5\64\n\5"+
		"\f\5\16\5\67\13\5\3\5\2\3\4\6\2\4\6\b\2\2\2>\2\22\3\2\2\2\4\31\3\2\2\2"+
		"\6\60\3\2\2\2\b\65\3\2\2\2\n\13\7\6\2\2\13\f\7\5\2\2\f\r\7\3\2\2\r\16"+
		"\5\4\3\2\16\17\7\4\2\2\17\23\3\2\2\2\20\23\7\6\2\2\21\23\3\2\2\2\22\n"+
		"\3\2\2\2\22\20\3\2\2\2\22\21\3\2\2\2\23\3\3\2\2\2\24\25\b\3\1\2\25\32"+
		"\7\7\2\2\26\32\7\n\2\2\27\32\7\13\2\2\30\32\3\2\2\2\31\24\3\2\2\2\31\26"+
		"\3\2\2\2\31\27\3\2\2\2\31\30\3\2\2\2\32*\3\2\2\2\33\35\f\7\2\2\34\36\5"+
		"\6\4\2\35\34\3\2\2\2\35\36\3\2\2\2\36\37\3\2\2\2\37 \7\5\2\2 !\7\7\2\2"+
		"!\"\7\5\2\2\"#\5\b\5\2#$\7\5\2\2$%\7\n\2\2%&\7\5\2\2&\'\7\13\2\2\')\3"+
		"\2\2\2(\33\3\2\2\2),\3\2\2\2*(\3\2\2\2*+\3\2\2\2+\5\3\2\2\2,*\3\2\2\2"+
		"-\61\7\7\2\2.\61\7\b\2\2/\61\7\t\2\2\60-\3\2\2\2\60.\3\2\2\2\60/\3\2\2"+
		"\2\61\7\3\2\2\2\62\64\7\7\2\2\63\62\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2"+
		"\2\65\66\3\2\2\2\66\t\3\2\2\2\67\65\3\2\2\2\b\22\31\35*\60\65";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}