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
		BARRA=1, PV=2, ANO=3, DOIS_DIGITOS=4, DIGITO=5, TITULO=6, STRING=7, BOOLEAN=8, 
		TIPO_DADOS=9, OBRIGATORIO=10, WS=11;
	public static final int
		RULE_regra = 0, RULE_atributo = 1, RULE_nome = 2;
	private static String[] makeRuleNames() {
		return new String[] {
			"regra", "atributo", "nome"
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
			"BOOLEAN", "TIPO_DADOS", "OBRIGATORIO", "WS"
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
		public List<TerminalNode> PV() { return getTokens(validaFormParser.PV); }
		public TerminalNode PV(int i) {
			return getToken(validaFormParser.PV, i);
		}
		public List<AtributoContext> atributo() {
			return getRuleContexts(AtributoContext.class);
		}
		public AtributoContext atributo(int i) {
			return getRuleContext(AtributoContext.class,i);
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
		int _la;
		try {
			setState(16);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new ValidoContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(6);
				match(TITULO);
				setState(11);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==PV) {
					{
					{
					setState(7);
					match(PV);
					setState(8);
					atributo();
					}
					}
					setState(13);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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
	public static class Valido2Context extends AtributoContext {
		public NomeContext var;
		public Token label;
		public Token des;
		public Token tp;
		public Token obr;
		public List<TerminalNode> PV() { return getTokens(validaFormParser.PV); }
		public TerminalNode PV(int i) {
			return getToken(validaFormParser.PV, i);
		}
		public NomeContext nome() {
			return getRuleContext(NomeContext.class,0);
		}
		public TerminalNode TIPO_DADOS() { return getToken(validaFormParser.TIPO_DADOS, 0); }
		public TerminalNode OBRIGATORIO() { return getToken(validaFormParser.OBRIGATORIO, 0); }
		public List<TerminalNode> STRING() { return getTokens(validaFormParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(validaFormParser.STRING, i);
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

	public final AtributoContext atributo() throws RecognitionException {
		AtributoContext _localctx = new AtributoContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_atributo);
		int _la;
		try {
			setState(44);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new Valido2Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(18);
				((Valido2Context)_localctx).var = nome();
				setState(19);
				match(PV);
				setState(23);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==STRING) {
					{
					{
					setState(20);
					((Valido2Context)_localctx).label = match(STRING);
					}
					}
					setState(25);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(26);
				match(PV);
				setState(34);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PV || _la==STRING) {
					{
					setState(30);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==STRING) {
						{
						{
						setState(27);
						((Valido2Context)_localctx).des = match(STRING);
						}
						}
						setState(32);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(33);
					match(PV);
					}
				}

				setState(36);
				((Valido2Context)_localctx).tp = match(TIPO_DADOS);
				setState(37);
				match(PV);
				setState(38);
				((Valido2Context)_localctx).obr = match(OBRIGATORIO);
				}
				break;
			case 2:
				_localctx = new Invalido2Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(40);
				match(STRING);
				}
				break;
			case 3:
				_localctx = new Invalido2Context(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(41);
				match(TIPO_DADOS);
				}
				break;
			case 4:
				_localctx = new Invalido2Context(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(42);
				match(OBRIGATORIO);
				}
				break;
			case 5:
				_localctx = new Vazio1Context(_localctx);
				enterOuterAlt(_localctx, 5);
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
		public List<TerminalNode> DIGITO() { return getTokens(validaFormParser.DIGITO); }
		public TerminalNode DIGITO(int i) {
			return getToken(validaFormParser.DIGITO, i);
		}
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
	public static class ValidoBooleanContext extends NomeContext {
		public TerminalNode BOOLEAN() { return getToken(validaFormParser.BOOLEAN, 0); }
		public ValidoBooleanContext(NomeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validaFormListener ) ((validaFormListener)listener).enterValidoBoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validaFormListener ) ((validaFormListener)listener).exitValidoBoolean(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validaFormVisitor ) return ((validaFormVisitor<? extends T>)visitor).visitValidoBoolean(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NomeVazioContext extends NomeContext {
		public NomeVazioContext(NomeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validaFormListener ) ((validaFormListener)listener).enterNomeVazio(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validaFormListener ) ((validaFormListener)listener).exitNomeVazio(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validaFormVisitor ) return ((validaFormVisitor<? extends T>)visitor).visitNomeVazio(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ValidoDataContext extends NomeContext {
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
		int _la;
		try {
			setState(59);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				_localctx = new ValidoStringContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(46);
				match(STRING);
				}
				break;
			case DIGITO:
				_localctx = new ValidoIntegerContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(48); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(47);
					match(DIGITO);
					}
					}
					setState(50); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==DIGITO );
				}
				break;
			case ANO:
				_localctx = new ValidoDataContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(52);
				((ValidoDataContext)_localctx).ano = match(ANO);
				setState(53);
				match(BARRA);
				setState(54);
				((ValidoDataContext)_localctx).mes = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==DOIS_DIGITOS || _la==DIGITO) ) {
					((ValidoDataContext)_localctx).mes = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(55);
				match(BARRA);
				setState(56);
				((ValidoDataContext)_localctx).dia = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==DOIS_DIGITOS || _la==DIGITO) ) {
					((ValidoDataContext)_localctx).dia = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case BOOLEAN:
				_localctx = new ValidoBooleanContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(57);
				match(BOOLEAN);
				}
				break;
			case PV:
				_localctx = new NomeVazioContext(_localctx);
				enterOuterAlt(_localctx, 5);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\r@\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\3\2\3\2\3\2\7\2\f\n\2\f\2\16\2\17\13\2\3\2\3\2\5\2\23\n\2\3"+
		"\3\3\3\3\3\7\3\30\n\3\f\3\16\3\33\13\3\3\3\3\3\7\3\37\n\3\f\3\16\3\"\13"+
		"\3\3\3\5\3%\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3/\n\3\3\4\3\4\6\4\63"+
		"\n\4\r\4\16\4\64\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4>\n\4\3\4\2\2\5\2\4\6"+
		"\2\3\3\2\6\7\2K\2\22\3\2\2\2\4.\3\2\2\2\6=\3\2\2\2\b\r\7\b\2\2\t\n\7\4"+
		"\2\2\n\f\5\4\3\2\13\t\3\2\2\2\f\17\3\2\2\2\r\13\3\2\2\2\r\16\3\2\2\2\16"+
		"\23\3\2\2\2\17\r\3\2\2\2\20\23\7\b\2\2\21\23\3\2\2\2\22\b\3\2\2\2\22\20"+
		"\3\2\2\2\22\21\3\2\2\2\23\3\3\2\2\2\24\25\5\6\4\2\25\31\7\4\2\2\26\30"+
		"\7\t\2\2\27\26\3\2\2\2\30\33\3\2\2\2\31\27\3\2\2\2\31\32\3\2\2\2\32\34"+
		"\3\2\2\2\33\31\3\2\2\2\34$\7\4\2\2\35\37\7\t\2\2\36\35\3\2\2\2\37\"\3"+
		"\2\2\2 \36\3\2\2\2 !\3\2\2\2!#\3\2\2\2\" \3\2\2\2#%\7\4\2\2$ \3\2\2\2"+
		"$%\3\2\2\2%&\3\2\2\2&\'\7\13\2\2\'(\7\4\2\2()\7\f\2\2)/\3\2\2\2*/\7\t"+
		"\2\2+/\7\13\2\2,/\7\f\2\2-/\3\2\2\2.\24\3\2\2\2.*\3\2\2\2.+\3\2\2\2.,"+
		"\3\2\2\2.-\3\2\2\2/\5\3\2\2\2\60>\7\t\2\2\61\63\7\7\2\2\62\61\3\2\2\2"+
		"\63\64\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2\65>\3\2\2\2\66\67\7\5\2\2\67"+
		"8\7\3\2\289\t\2\2\29:\7\3\2\2:>\t\2\2\2;>\7\n\2\2<>\3\2\2\2=\60\3\2\2"+
		"\2=\62\3\2\2\2=\66\3\2\2\2=;\3\2\2\2=<\3\2\2\2>\7\3\2\2\2\n\r\22\31 $"+
		".\64=";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}