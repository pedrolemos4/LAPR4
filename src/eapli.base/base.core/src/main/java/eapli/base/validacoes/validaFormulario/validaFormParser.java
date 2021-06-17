// Generated from D:/2ANO/2SEMESTRE/LAPR4/LAPR4_PROJETO/src/eapli.base/base.core/src/main/java/eapli/base/validacoes/validaFormulario\validaForm.g4 by ANTLR 4.9.1
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
		BARRA=1, PV=2, ANO=3, DOIS_DIGITOS=4, DIGITO=5, TITULO=6, STRING=7, TIPO_DADOS=8, 
		OBRIGATORIO=9, WS=10, INTEGER=11;
	public static final int
		RULE_regra = 0, RULE_atributo = 1, RULE_nome = 2, RULE_data = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"regra", "atributo", "nome", "data"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'/'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "BARRA", "PV", "ANO", "DOIS_DIGITOS", "DIGITO", "TITULO", "STRING", 
			"TIPO_DADOS", "OBRIGATORIO", "WS", "INTEGER"
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
		public AtributoContext atributo() {
			return getRuleContext(AtributoContext.class,0);
		}
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
			setState(13);
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
				atributo(0);
				}
				break;
			case 2:
				_localctx = new InvalidoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(11);
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
		public Token des;
		public Token tp;
		public Token obr;
		public AtributoContext atributo() {
			return getRuleContext(AtributoContext.class,0);
		}
		public List<TerminalNode> PV() { return getTokens(validaFormParser.PV); }
		public TerminalNode PV(int i) {
			return getToken(validaFormParser.PV, i);
		}
		public List<TerminalNode> STRING() { return getTokens(validaFormParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(validaFormParser.STRING, i);
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
			setState(20);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				_localctx = new Invalido2Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(16);
				match(STRING);
				}
				break;
			case 2:
				{
				_localctx = new Invalido2Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(17);
				match(TIPO_DADOS);
				}
				break;
			case 3:
				{
				_localctx = new Invalido2Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(18);
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
			setState(41);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Valido2Context(new AtributoContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_atributo);
					setState(22);
					if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
					setState(24);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ANO) | (1L << STRING) | (1L << INTEGER))) != 0)) {
						{
						setState(23);
						((Valido2Context)_localctx).var = nome();
						}
					}

					setState(26);
					match(PV);
					setState(27);
					((Valido2Context)_localctx).label = match(STRING);
					setState(28);
					match(PV);
					setState(32);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==STRING) {
						{
						{
						setState(29);
						((Valido2Context)_localctx).des = match(STRING);
						}
						}
						setState(34);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(35);
					match(PV);
					setState(36);
					((Valido2Context)_localctx).tp = match(TIPO_DADOS);
					setState(37);
					match(PV);
					setState(38);
					((Valido2Context)_localctx).obr = match(OBRIGATORIO);
					}
					} 
				}
				setState(43);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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
		public DataContext data() {
			return getRuleContext(DataContext.class,0);
		}
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
			setState(47);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				_localctx = new ValidoStringContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				match(STRING);
				}
				break;
			case INTEGER:
				_localctx = new ValidoIntegerContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				match(INTEGER);
				}
				break;
			case ANO:
				_localctx = new ValidoDataContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(46);
				data();
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

	public static class DataContext extends ParserRuleContext {
		public DataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data; }
	 
		public DataContext() { }
		public void copyFrom(DataContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ValidoData1Context extends DataContext {
		public Token ano;
		public Token mes;
		public Token dia;
		public List<TerminalNode> BARRA() { return getTokens(validaFormParser.BARRA); }
		public TerminalNode BARRA(int i) {
			return getToken(validaFormParser.BARRA, i);
		}
		public TerminalNode ANO() { return getToken(validaFormParser.ANO, 0); }
		public List<TerminalNode> DOIS_DIGITOS() { return getTokens(validaFormParser.DOIS_DIGITOS); }
		public TerminalNode DOIS_DIGITOS(int i) {
			return getToken(validaFormParser.DOIS_DIGITOS, i);
		}
		public List<TerminalNode> DIGITO() { return getTokens(validaFormParser.DIGITO); }
		public TerminalNode DIGITO(int i) {
			return getToken(validaFormParser.DIGITO, i);
		}
		public ValidoData1Context(DataContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validaFormListener ) ((validaFormListener)listener).enterValidoData1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validaFormListener ) ((validaFormListener)listener).exitValidoData1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validaFormVisitor ) return ((validaFormVisitor<? extends T>)visitor).visitValidoData1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataContext data() throws RecognitionException {
		DataContext _localctx = new DataContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_data);
		int _la;
		try {
			_localctx = new ValidoData1Context(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			((ValidoData1Context)_localctx).ano = match(ANO);
			setState(50);
			match(BARRA);
			setState(51);
			((ValidoData1Context)_localctx).mes = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==DOIS_DIGITOS || _la==DIGITO) ) {
				((ValidoData1Context)_localctx).mes = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(52);
			match(BARRA);
			setState(53);
			((ValidoData1Context)_localctx).dia = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==DOIS_DIGITOS || _la==DIGITO) ) {
				((ValidoData1Context)_localctx).dia = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\r:\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\3\2\3\2\3\2\3\2\3\2\5\2\20\n\2\3\3\3\3\3\3\3\3\3\3"+
		"\5\3\27\n\3\3\3\3\3\5\3\33\n\3\3\3\3\3\3\3\3\3\7\3!\n\3\f\3\16\3$\13\3"+
		"\3\3\3\3\3\3\3\3\7\3*\n\3\f\3\16\3-\13\3\3\4\3\4\3\4\5\4\62\n\4\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\2\3\4\6\2\4\6\b\2\3\3\2\6\7\2?\2\17\3\2\2\2\4\26"+
		"\3\2\2\2\6\61\3\2\2\2\b\63\3\2\2\2\n\13\7\b\2\2\13\f\7\4\2\2\f\20\5\4"+
		"\3\2\r\20\7\b\2\2\16\20\3\2\2\2\17\n\3\2\2\2\17\r\3\2\2\2\17\16\3\2\2"+
		"\2\20\3\3\2\2\2\21\22\b\3\1\2\22\27\7\t\2\2\23\27\7\n\2\2\24\27\7\13\2"+
		"\2\25\27\3\2\2\2\26\21\3\2\2\2\26\23\3\2\2\2\26\24\3\2\2\2\26\25\3\2\2"+
		"\2\27+\3\2\2\2\30\32\f\7\2\2\31\33\5\6\4\2\32\31\3\2\2\2\32\33\3\2\2\2"+
		"\33\34\3\2\2\2\34\35\7\4\2\2\35\36\7\t\2\2\36\"\7\4\2\2\37!\7\t\2\2 \37"+
		"\3\2\2\2!$\3\2\2\2\" \3\2\2\2\"#\3\2\2\2#%\3\2\2\2$\"\3\2\2\2%&\7\4\2"+
		"\2&\'\7\n\2\2\'(\7\4\2\2(*\7\13\2\2)\30\3\2\2\2*-\3\2\2\2+)\3\2\2\2+,"+
		"\3\2\2\2,\5\3\2\2\2-+\3\2\2\2.\62\7\t\2\2/\62\7\r\2\2\60\62\5\b\5\2\61"+
		".\3\2\2\2\61/\3\2\2\2\61\60\3\2\2\2\62\7\3\2\2\2\63\64\7\5\2\2\64\65\7"+
		"\3\2\2\65\66\t\2\2\2\66\67\7\3\2\2\678\t\2\2\28\t\3\2\2\2\b\17\26\32\""+
		"+\61";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}