// Generated from C:/Users/josec/Desktop/LPROG IMPORTANTE/src/validarFormulario\validarFormulario.g4 by ANTLR 4.9.1
package eapli.base.validacoes.validarFormulario;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class validarFormularioLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ID=1, PV=2, TITULO=3, NOME_VAR=4, LABEL=5, WS=6;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"ID", "PV", "TITULO", "NOME_VAR", "LABEL", "WS"
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


	public validarFormularioLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "validarFormulario.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 2:
			TITULO_action((RuleContext)_localctx, actionIndex);
			break;
		case 3:
			NOME_VAR_action((RuleContext)_localctx, actionIndex);
			break;
		case 4:
			LABEL_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void TITULO_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			1,50
			break;
		}
	}
	private void NOME_VAR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			1,30
			break;
		}
	}
	private void LABEL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:
			1,30
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\b?\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\6\2\23\n\2\r\2\16\2"+
		"\24\5\2\27\n\2\3\3\3\3\3\4\3\4\6\4\35\n\4\r\4\16\4\36\3\4\7\4\"\n\4\f"+
		"\4\16\4%\13\4\3\4\3\4\3\5\3\5\6\5+\n\5\r\5\16\5,\3\5\3\5\3\6\3\6\6\6\63"+
		"\n\6\r\6\16\6\64\3\6\3\6\3\7\6\7:\n\7\r\7\16\7;\3\7\3\7\2\2\b\3\3\5\4"+
		"\7\5\t\6\13\7\r\b\3\2\7\3\2\62;\3\2\63;\3\2C\\\3\2c|\5\2\13\f\17\17\""+
		"\"\2E\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r"+
		"\3\2\2\2\3\26\3\2\2\2\5\30\3\2\2\2\7\32\3\2\2\2\t(\3\2\2\2\13\60\3\2\2"+
		"\2\r9\3\2\2\2\17\27\t\2\2\2\20\22\t\3\2\2\21\23\t\2\2\2\22\21\3\2\2\2"+
		"\23\24\3\2\2\2\24\22\3\2\2\2\24\25\3\2\2\2\25\27\3\2\2\2\26\17\3\2\2\2"+
		"\26\20\3\2\2\2\27\4\3\2\2\2\30\31\7=\2\2\31\6\3\2\2\2\32\34\t\4\2\2\33"+
		"\35\t\5\2\2\34\33\3\2\2\2\35\36\3\2\2\2\36\34\3\2\2\2\36\37\3\2\2\2\37"+
		"#\3\2\2\2 \"\t\2\2\2! \3\2\2\2\"%\3\2\2\2#!\3\2\2\2#$\3\2\2\2$&\3\2\2"+
		"\2%#\3\2\2\2&\'\b\4\2\2\'\b\3\2\2\2(*\t\4\2\2)+\t\5\2\2*)\3\2\2\2+,\3"+
		"\2\2\2,*\3\2\2\2,-\3\2\2\2-.\3\2\2\2./\b\5\3\2/\n\3\2\2\2\60\62\t\4\2"+
		"\2\61\63\t\5\2\2\62\61\3\2\2\2\63\64\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2"+
		"\2\65\66\3\2\2\2\66\67\b\6\4\2\67\f\3\2\2\28:\t\6\2\298\3\2\2\2:;\3\2"+
		"\2\2;9\3\2\2\2;<\3\2\2\2<=\3\2\2\2=>\b\7\5\2>\16\3\2\2\2\n\2\24\26\36"+
		"#,\64;\6\3\4\2\3\5\3\3\6\4\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}