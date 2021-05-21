// Generated from C:/Users/josec/Desktop/LPROG IMPORTANTE/src/validarAtividade\validarAtividade.g4 by ANTLR 4.9.1
package eapli.base.validacoes.validarAtividade;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class validarAtividadeParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PV=1, DATA=2, ESTADO=3, TIPO=4, COLAB=5, EQUIPA=6, DECISAO=7, COMENTARIO=8, 
		FORM=9, WS=10;
	public static final int
		RULE_regra = 0, RULE_atv_manu = 1, RULE_atv_auto = 2;
	private static String[] makeRuleNames() {
		return new String[] {
			"regra", "atv_manu", "atv_auto"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PV", "DATA", "ESTADO", "TIPO", "COLAB", "EQUIPA", "DECISAO", "COMENTARIO", 
			"FORM", "WS"
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
	public String getGrammarFileName() { return "validarAtividade.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public validarAtividadeParser(TokenStream input) {
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
	public static class VazioContext extends RegraContext {
		public VazioContext(RegraContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validarAtividadeListener ) ((validarAtividadeListener)listener).enterVazio(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validarAtividadeListener ) ((validarAtividadeListener)listener).exitVazio(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validarAtividadeVisitor ) return ((validarAtividadeVisitor<? extends T>)visitor).visitVazio(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AtvManualContext extends RegraContext {
		public Atv_manuContext atv_manu() {
			return getRuleContext(Atv_manuContext.class,0);
		}
		public AtvManualContext(RegraContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validarAtividadeListener ) ((validarAtividadeListener)listener).enterAtvManual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validarAtividadeListener ) ((validarAtividadeListener)listener).exitAtvManual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validarAtividadeVisitor ) return ((validarAtividadeVisitor<? extends T>)visitor).visitAtvManual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AtvAutoContext extends RegraContext {
		public Atv_autoContext atv_auto() {
			return getRuleContext(Atv_autoContext.class,0);
		}
		public AtvAutoContext(RegraContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validarAtividadeListener ) ((validarAtividadeListener)listener).enterAtvAuto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validarAtividadeListener ) ((validarAtividadeListener)listener).exitAtvAuto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validarAtividadeVisitor ) return ((validarAtividadeVisitor<? extends T>)visitor).visitAtvAuto(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RegraContext regra() throws RecognitionException {
		RegraContext _localctx = new RegraContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_regra);
		try {
			setState(9);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new AtvManualContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(6);
				atv_manu();
				}
				break;
			case 2:
				_localctx = new AtvAutoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(7);
				atv_auto();
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

	public static class Atv_manuContext extends ParserRuleContext {
		public Atv_manuContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atv_manu; }
	 
		public Atv_manuContext() { }
		public void copyFrom(Atv_manuContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ValidoContext extends Atv_manuContext {
		public TerminalNode DATA() { return getToken(validarAtividadeParser.DATA, 0); }
		public List<TerminalNode> PV() { return getTokens(validarAtividadeParser.PV); }
		public TerminalNode PV(int i) {
			return getToken(validarAtividadeParser.PV, i);
		}
		public TerminalNode ESTADO() { return getToken(validarAtividadeParser.ESTADO, 0); }
		public TerminalNode TIPO() { return getToken(validarAtividadeParser.TIPO, 0); }
		public TerminalNode DECISAO() { return getToken(validarAtividadeParser.DECISAO, 0); }
		public TerminalNode COMENTARIO() { return getToken(validarAtividadeParser.COMENTARIO, 0); }
		public TerminalNode FORM() { return getToken(validarAtividadeParser.FORM, 0); }
		public TerminalNode COLAB() { return getToken(validarAtividadeParser.COLAB, 0); }
		public TerminalNode EQUIPA() { return getToken(validarAtividadeParser.EQUIPA, 0); }
		public ValidoContext(Atv_manuContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validarAtividadeListener ) ((validarAtividadeListener)listener).enterValido(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validarAtividadeListener ) ((validarAtividadeListener)listener).exitValido(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validarAtividadeVisitor ) return ((validarAtividadeVisitor<? extends T>)visitor).visitValido(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InvalidoContext extends Atv_manuContext {
		public TerminalNode DATA() { return getToken(validarAtividadeParser.DATA, 0); }
		public TerminalNode ESTADO() { return getToken(validarAtividadeParser.ESTADO, 0); }
		public TerminalNode TIPO() { return getToken(validarAtividadeParser.TIPO, 0); }
		public TerminalNode COLAB() { return getToken(validarAtividadeParser.COLAB, 0); }
		public TerminalNode EQUIPA() { return getToken(validarAtividadeParser.EQUIPA, 0); }
		public TerminalNode DECISAO() { return getToken(validarAtividadeParser.DECISAO, 0); }
		public TerminalNode COMENTARIO() { return getToken(validarAtividadeParser.COMENTARIO, 0); }
		public TerminalNode FORM() { return getToken(validarAtividadeParser.FORM, 0); }
		public InvalidoContext(Atv_manuContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validarAtividadeListener ) ((validarAtividadeListener)listener).enterInvalido(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validarAtividadeListener ) ((validarAtividadeListener)listener).exitInvalido(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validarAtividadeVisitor ) return ((validarAtividadeVisitor<? extends T>)visitor).visitInvalido(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Vazio2Context extends Atv_manuContext {
		public Vazio2Context(Atv_manuContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validarAtividadeListener ) ((validarAtividadeListener)listener).enterVazio2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validarAtividadeListener ) ((validarAtividadeListener)listener).exitVazio2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validarAtividadeVisitor ) return ((validarAtividadeVisitor<? extends T>)visitor).visitVazio2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Atv_manuContext atv_manu() throws RecognitionException {
		Atv_manuContext _localctx = new Atv_manuContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_atv_manu);
		int _la;
		try {
			setState(33);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new ValidoContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(11);
				match(DATA);
				setState(12);
				match(PV);
				setState(13);
				match(ESTADO);
				setState(14);
				match(PV);
				setState(15);
				match(TIPO);
				setState(16);
				match(PV);
				setState(17);
				_la = _input.LA(1);
				if ( !(_la==COLAB || _la==EQUIPA) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(18);
				match(PV);
				setState(19);
				match(DECISAO);
				setState(20);
				match(PV);
				setState(21);
				match(COMENTARIO);
				setState(22);
				match(PV);
				setState(23);
				match(FORM);
				}
				break;
			case 2:
				_localctx = new InvalidoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(24);
				match(DATA);
				}
				break;
			case 3:
				_localctx = new InvalidoContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(25);
				match(ESTADO);
				}
				break;
			case 4:
				_localctx = new InvalidoContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(26);
				match(TIPO);
				}
				break;
			case 5:
				_localctx = new InvalidoContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(27);
				match(COLAB);
				}
				break;
			case 6:
				_localctx = new InvalidoContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(28);
				match(EQUIPA);
				}
				break;
			case 7:
				_localctx = new InvalidoContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(29);
				match(DECISAO);
				}
				break;
			case 8:
				_localctx = new InvalidoContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(30);
				match(COMENTARIO);
				}
				break;
			case 9:
				_localctx = new InvalidoContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(31);
				match(FORM);
				}
				break;
			case 10:
				_localctx = new Vazio2Context(_localctx);
				enterOuterAlt(_localctx, 10);
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

	public static class Atv_autoContext extends ParserRuleContext {
		public Atv_autoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atv_auto; }
	 
		public Atv_autoContext() { }
		public void copyFrom(Atv_autoContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Invalido2Context extends Atv_autoContext {
		public TerminalNode DATA() { return getToken(validarAtividadeParser.DATA, 0); }
		public TerminalNode ESTADO() { return getToken(validarAtividadeParser.ESTADO, 0); }
		public TerminalNode TIPO() { return getToken(validarAtividadeParser.TIPO, 0); }
		public Invalido2Context(Atv_autoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validarAtividadeListener ) ((validarAtividadeListener)listener).enterInvalido2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validarAtividadeListener ) ((validarAtividadeListener)listener).exitInvalido2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validarAtividadeVisitor ) return ((validarAtividadeVisitor<? extends T>)visitor).visitInvalido2(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Vazio3Context extends Atv_autoContext {
		public Vazio3Context(Atv_autoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validarAtividadeListener ) ((validarAtividadeListener)listener).enterVazio3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validarAtividadeListener ) ((validarAtividadeListener)listener).exitVazio3(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validarAtividadeVisitor ) return ((validarAtividadeVisitor<? extends T>)visitor).visitVazio3(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Valido2Context extends Atv_autoContext {
		public TerminalNode DATA() { return getToken(validarAtividadeParser.DATA, 0); }
		public List<TerminalNode> PV() { return getTokens(validarAtividadeParser.PV); }
		public TerminalNode PV(int i) {
			return getToken(validarAtividadeParser.PV, i);
		}
		public TerminalNode ESTADO() { return getToken(validarAtividadeParser.ESTADO, 0); }
		public TerminalNode TIPO() { return getToken(validarAtividadeParser.TIPO, 0); }
		public Valido2Context(Atv_autoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validarAtividadeListener ) ((validarAtividadeListener)listener).enterValido2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validarAtividadeListener ) ((validarAtividadeListener)listener).exitValido2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validarAtividadeVisitor ) return ((validarAtividadeVisitor<? extends T>)visitor).visitValido2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Atv_autoContext atv_auto() throws RecognitionException {
		Atv_autoContext _localctx = new Atv_autoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_atv_auto);
		try {
			setState(44);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new Valido2Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(35);
				match(DATA);
				setState(36);
				match(PV);
				setState(37);
				match(ESTADO);
				setState(38);
				match(PV);
				setState(39);
				match(TIPO);
				}
				break;
			case 2:
				_localctx = new Invalido2Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(40);
				match(DATA);
				}
				break;
			case 3:
				_localctx = new Invalido2Context(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(41);
				match(ESTADO);
				}
				break;
			case 4:
				_localctx = new Invalido2Context(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(42);
				match(TIPO);
				}
				break;
			case 5:
				_localctx = new Vazio3Context(_localctx);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\f\61\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\3\2\3\2\3\2\5\2\f\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3$\n\3\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4/\n\4\3\4\2\2\5\2\4\6\2\3\3\2\7\b\2<\2"+
		"\13\3\2\2\2\4#\3\2\2\2\6.\3\2\2\2\b\f\5\4\3\2\t\f\5\6\4\2\n\f\3\2\2\2"+
		"\13\b\3\2\2\2\13\t\3\2\2\2\13\n\3\2\2\2\f\3\3\2\2\2\r\16\7\4\2\2\16\17"+
		"\7\3\2\2\17\20\7\5\2\2\20\21\7\3\2\2\21\22\7\6\2\2\22\23\7\3\2\2\23\24"+
		"\t\2\2\2\24\25\7\3\2\2\25\26\7\t\2\2\26\27\7\3\2\2\27\30\7\n\2\2\30\31"+
		"\7\3\2\2\31$\7\13\2\2\32$\7\4\2\2\33$\7\5\2\2\34$\7\6\2\2\35$\7\7\2\2"+
		"\36$\7\b\2\2\37$\7\t\2\2 $\7\n\2\2!$\7\13\2\2\"$\3\2\2\2#\r\3\2\2\2#\32"+
		"\3\2\2\2#\33\3\2\2\2#\34\3\2\2\2#\35\3\2\2\2#\36\3\2\2\2#\37\3\2\2\2#"+
		" \3\2\2\2#!\3\2\2\2#\"\3\2\2\2$\5\3\2\2\2%&\7\4\2\2&\'\7\3\2\2\'(\7\5"+
		"\2\2()\7\3\2\2)/\7\6\2\2*/\7\4\2\2+/\7\5\2\2,/\7\6\2\2-/\3\2\2\2.%\3\2"+
		"\2\2.*\3\2\2\2.+\3\2\2\2.,\3\2\2\2.-\3\2\2\2/\7\3\2\2\2\5\13#.";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}