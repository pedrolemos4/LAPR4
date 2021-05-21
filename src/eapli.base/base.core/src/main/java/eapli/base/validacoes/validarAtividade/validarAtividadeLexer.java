// Generated from C:/Users/josec/Desktop/LPROG IMPORTANTE/src/validarAtividade\validarAtividade.g4 by ANTLR 4.9.1
package eapli.base.validacoes.validarAtividade;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class validarAtividadeLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PV=1, DATA=2, ESTADO=3, TIPO=4, COLAB=5, EQUIPA=6, DECISAO=7, COMENTARIO=8, 
		FORM=9, WS=10;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PV", "DATA", "ESTADO", "TIPO", "COLAB", "EQUIPA", "DECISAO", "COMENTARIO", 
			"FORM", "WS"
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


	public validarAtividadeLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "validarAtividade.g4"; }

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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\f~\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\5\3+\n\3\5\3-\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\5\4?\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5T\n\5\3\6\6\6W\n\6\r\6\16\6"+
		"X\3\7\6\7\\\n\7\r\7\16\7]\3\7\6\7a\n\7\r\7\16\7b\3\b\6\bf\n\b\r\b\16\b"+
		"g\3\t\6\tk\n\t\r\t\16\tl\3\n\3\n\3\n\6\nr\n\n\r\n\16\ns\5\nv\n\n\3\13"+
		"\6\13y\n\13\r\13\16\13z\3\13\3\13\2\2\f\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\3\2\13\3\2\62;\3\2\63\63\3\2\62\64\3\2\64\64\3\2\65\65"+
		"\3\2\62\63\5\2C\\c|~~\3\2\63;\5\2\13\f\17\17\"\"\2\u008b\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\3\27\3\2\2\2\5,\3\2\2\2\7>\3"+
		"\2\2\2\tS\3\2\2\2\13V\3\2\2\2\r[\3\2\2\2\17e\3\2\2\2\21j\3\2\2\2\23u\3"+
		"\2\2\2\25x\3\2\2\2\27\30\7=\2\2\30\4\3\2\2\2\31\32\7\64\2\2\32\33\7\62"+
		"\2\2\33\34\7\64\2\2\34\35\3\2\2\2\35\36\t\2\2\2\36\37\7/\2\2\37-\t\2\2"+
		"\2 !\t\3\2\2!\"\t\4\2\2\"*\7/\2\2#+\t\2\2\2$%\t\3\2\2%+\t\2\2\2&\'\t\5"+
		"\2\2\'+\t\2\2\2()\t\6\2\2)+\t\7\2\2*#\3\2\2\2*$\3\2\2\2*&\3\2\2\2*(\3"+
		"\2\2\2+-\3\2\2\2,\31\3\2\2\2, \3\2\2\2-\6\3\2\2\2./\7r\2\2/\60\7g\2\2"+
		"\60\61\7p\2\2\61\62\7f\2\2\62\63\7g\2\2\63\64\7p\2\2\64\65\7v\2\2\65?"+
		"\7g\2\2\66\67\7e\2\2\678\7q\2\289\7o\2\29:\7r\2\2:;\7n\2\2;<\7g\2\2<="+
		"\7v\2\2=?\7q\2\2>.\3\2\2\2>\66\3\2\2\2?\b\3\2\2\2@A\7t\2\2AB\7g\2\2BC"+
		"\7c\2\2CD\7n\2\2DE\7k\2\2EF\7|\2\2FG\7c\2\2GH\7e\2\2HI\7c\2\2IT\7q\2\2"+
		"JK\7c\2\2KL\7r\2\2LM\7t\2\2MN\7q\2\2NO\7x\2\2OP\7c\2\2PQ\7e\2\2QR\7c\2"+
		"\2RT\7q\2\2S@\3\2\2\2SJ\3\2\2\2T\n\3\2\2\2UW\t\2\2\2VU\3\2\2\2WX\3\2\2"+
		"\2XV\3\2\2\2XY\3\2\2\2Y\f\3\2\2\2Z\\\t\b\2\2[Z\3\2\2\2\\]\3\2\2\2][\3"+
		"\2\2\2]^\3\2\2\2^`\3\2\2\2_a\t\2\2\2`_\3\2\2\2ab\3\2\2\2b`\3\2\2\2bc\3"+
		"\2\2\2c\16\3\2\2\2df\t\b\2\2ed\3\2\2\2fg\3\2\2\2ge\3\2\2\2gh\3\2\2\2h"+
		"\20\3\2\2\2ik\t\b\2\2ji\3\2\2\2kl\3\2\2\2lj\3\2\2\2lm\3\2\2\2m\22\3\2"+
		"\2\2nv\t\2\2\2oq\t\t\2\2pr\t\2\2\2qp\3\2\2\2rs\3\2\2\2sq\3\2\2\2st\3\2"+
		"\2\2tv\3\2\2\2un\3\2\2\2uo\3\2\2\2v\24\3\2\2\2wy\t\n\2\2xw\3\2\2\2yz\3"+
		"\2\2\2zx\3\2\2\2z{\3\2\2\2{|\3\2\2\2|}\b\13\2\2}\26\3\2\2\2\17\2*,>SX"+
		"]bglsuz\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}