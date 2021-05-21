// Generated from C:/Users/josec/Desktop/LPROG IMPORTANTE/src/validarFormulario\validarFormulario.g4 by ANTLR 4.9.1
package eapli.base.validacoes.validarFormulario;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class validarFormularioParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ID=1, PV=2, TITULO=3, NOME_VAR=4, LABEL=5, WS=6;
	public static final int
		RULE_regra = 0, RULE_atributo = 1;
	private static String[] makeRuleNames() {
		return new String[] {
			"regra", "atributo"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ID", "PV", "TITULO", "NOME_VAR", "LABEL", "WS"
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
	public String getGrammarFileName() { return "validarFormulario.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public validarFormularioParser(TokenStream input) {
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
		public TerminalNode ID() { return getToken(validarFormularioParser.ID, 0); }
		public List<TerminalNode> PV() { return getTokens(validarFormularioParser.PV); }
		public TerminalNode PV(int i) {
			return getToken(validarFormularioParser.PV, i);
		}
		public TerminalNode TITULO() { return getToken(validarFormularioParser.TITULO, 0); }
		public AtributoContext atributo() {
			return getRuleContext(AtributoContext.class,0);
		}
		public ValidoContext(RegraContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).enterValido(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).exitValido(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validarFormularioVisitor ) return ((validarFormularioVisitor<? extends T>)visitor).visitValido(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InvalidoContext extends RegraContext {
		public TerminalNode TITULO() { return getToken(validarFormularioParser.TITULO, 0); }
		public InvalidoContext(RegraContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).enterInvalido(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).exitInvalido(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validarFormularioVisitor ) return ((validarFormularioVisitor<? extends T>)visitor).visitInvalido(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VazioContext extends RegraContext {
		public VazioContext(RegraContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).enterVazio(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).exitVazio(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validarFormularioVisitor ) return ((validarFormularioVisitor<? extends T>)visitor).visitVazio(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RegraContext regra() throws RecognitionException {
		RegraContext _localctx = new RegraContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_regra);
		try {
			setState(11);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new ValidoContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(4);
				match(ID);
				setState(5);
				match(PV);
				setState(6);
				match(TITULO);
				setState(7);
				match(PV);
				setState(8);
				atributo(0);
				}
				break;
			case TITULO:
				_localctx = new InvalidoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(9);
				match(TITULO);
				}
				break;
			case EOF:
				_localctx = new VazioContext(_localctx);
				enterOuterAlt(_localctx, 3);
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
		public TerminalNode NOME_VAR() { return getToken(validarFormularioParser.NOME_VAR, 0); }
		public TerminalNode LABEL() { return getToken(validarFormularioParser.LABEL, 0); }
		public Invalido2Context(AtributoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).enterInvalido2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).exitInvalido2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validarFormularioVisitor ) return ((validarFormularioVisitor<? extends T>)visitor).visitInvalido2(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Vazio2Context extends AtributoContext {
		public Vazio2Context(AtributoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).enterVazio2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).exitVazio2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validarFormularioVisitor ) return ((validarFormularioVisitor<? extends T>)visitor).visitVazio2(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Valido2Context extends AtributoContext {
		public AtributoContext atributo() {
			return getRuleContext(AtributoContext.class,0);
		}
		public TerminalNode NOME_VAR() { return getToken(validarFormularioParser.NOME_VAR, 0); }
		public List<TerminalNode> PV() { return getTokens(validarFormularioParser.PV); }
		public TerminalNode PV(int i) {
			return getToken(validarFormularioParser.PV, i);
		}
		public TerminalNode LABEL() { return getToken(validarFormularioParser.LABEL, 0); }
		public Valido2Context(AtributoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).enterValido2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validarFormularioListener ) ((validarFormularioListener)listener).exitValido2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validarFormularioVisitor ) return ((validarFormularioVisitor<? extends T>)visitor).visitValido2(this);
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(17);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				_localctx = new Invalido2Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(14);
				match(NOME_VAR);
				}
				break;
			case 2:
				{
				_localctx = new Invalido2Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(15);
				match(LABEL);
				}
				break;
			case 3:
				{
				_localctx = new Vazio2Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(26);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Valido2Context(new AtributoContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_atributo);
					setState(19);
					if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
					setState(20);
					match(NOME_VAR);
					setState(21);
					match(PV);
					setState(22);
					match(LABEL);
					setState(23);
					match(PV);
					}
					} 
				}
				setState(28);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\b \4\2\t\2\4\3\t"+
		"\3\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\16\n\2\3\3\3\3\3\3\3\3\5\3\24\n\3\3"+
		"\3\3\3\3\3\3\3\3\3\7\3\33\n\3\f\3\16\3\36\13\3\3\3\2\3\4\4\2\4\2\2\2\""+
		"\2\r\3\2\2\2\4\23\3\2\2\2\6\7\7\3\2\2\7\b\7\4\2\2\b\t\7\5\2\2\t\n\7\4"+
		"\2\2\n\16\5\4\3\2\13\16\7\5\2\2\f\16\3\2\2\2\r\6\3\2\2\2\r\13\3\2\2\2"+
		"\r\f\3\2\2\2\16\3\3\2\2\2\17\20\b\3\1\2\20\24\7\6\2\2\21\24\7\7\2\2\22"+
		"\24\3\2\2\2\23\17\3\2\2\2\23\21\3\2\2\2\23\22\3\2\2\2\24\34\3\2\2\2\25"+
		"\26\f\6\2\2\26\27\7\6\2\2\27\30\7\4\2\2\30\31\7\7\2\2\31\33\7\4\2\2\32"+
		"\25\3\2\2\2\33\36\3\2\2\2\34\32\3\2\2\2\34\35\3\2\2\2\35\5\3\2\2\2\36"+
		"\34\3\2\2\2\5\r\23\34";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}