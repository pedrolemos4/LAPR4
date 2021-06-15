package eapli.base.validacoes.validaFormulario;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class validaFormLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PV=1, TITULO=2, LABEL=3, STRING=4, INTEGER=5, DATA=6, DESCRICAO_AJUDA=7, 
		TIPO_DADOS=8, OBRIGATORIO=9, WS=10;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PV", "TITULO", "LABEL", "STRING", "INTEGER", "DATA", "DESCRICAO_AJUDA", 
			"TIPO_DADOS", "OBRIGATORIO", "WS"
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
			null, "PV", "TITULO", "LABEL", "STRING", "INTEGER", "DATA", "DESCRICAO_AJUDA", 
			"TIPO_DADOS", "OBRIGATORIO", "WS"
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


	public validaFormLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "validaForm.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\f\u008c\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\3\2\3\2\3\3\3\3\6\3\34\n\3\r\3\16\3\35\3\3\6\3!\n\3\r\3\16\3\"\3"+
		"\4\6\4&\n\4\r\4\16\4\'\3\5\3\5\6\5,\n\5\r\5\16\5-\3\6\3\6\3\6\6\6\63\n"+
		"\6\r\6\16\6\64\5\6\67\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7B\n\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7K\n\7\3\b\6\bN\n\b\r\b\16\bO\3\b\6\bS"+
		"\n\b\r\b\16\bT\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\to\n\t\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0084\n\n"+
		"\3\13\6\13\u0087\n\13\r\13\16\13\u0088\3\13\3\13\2\2\f\3\3\5\4\7\5\t\6"+
		"\13\7\r\b\17\t\21\n\23\13\25\f\3\2\n\3\2C\\\3\2c|\3\2\62;\3\2\63;\3\2"+
		"\62\64\3\2\63\64\3\2\62\63\5\2\13\f\17\17\"\"\2\u009b\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2"+
		"\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\3\27\3\2\2\2\5\31\3\2\2\2\7%\3"+
		"\2\2\2\t)\3\2\2\2\13\66\3\2\2\2\r8\3\2\2\2\17M\3\2\2\2\21n\3\2\2\2\23"+
		"\u0083\3\2\2\2\25\u0086\3\2\2\2\27\30\7=\2\2\30\4\3\2\2\2\31\33\t\2\2"+
		"\2\32\34\t\3\2\2\33\32\3\2\2\2\34\35\3\2\2\2\35\33\3\2\2\2\35\36\3\2\2"+
		"\2\36 \3\2\2\2\37!\t\4\2\2 \37\3\2\2\2!\"\3\2\2\2\" \3\2\2\2\"#\3\2\2"+
		"\2#\6\3\2\2\2$&\t\3\2\2%$\3\2\2\2&\'\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(\b"+
		"\3\2\2\2)+\t\2\2\2*,\t\3\2\2+*\3\2\2\2,-\3\2\2\2-+\3\2\2\2-.\3\2\2\2."+
		"\n\3\2\2\2/\67\t\4\2\2\60\62\t\5\2\2\61\63\t\4\2\2\62\61\3\2\2\2\63\64"+
		"\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2\65\67\3\2\2\2\66/\3\2\2\2\66\60\3"+
		"\2\2\2\67\f\3\2\2\289\t\4\2\29:\t\4\2\2:;\t\4\2\2;<\t\4\2\2<A\7\61\2\2"+
		"=>\7\62\2\2>B\t\5\2\2?@\7\63\2\2@B\t\6\2\2A=\3\2\2\2A?\3\2\2\2BC\3\2\2"+
		"\2CJ\7\61\2\2DE\7\62\2\2EK\t\5\2\2FG\t\7\2\2GK\t\4\2\2HI\7\65\2\2IK\t"+
		"\b\2\2JD\3\2\2\2JF\3\2\2\2JH\3\2\2\2K\16\3\2\2\2LN\t\3\2\2ML\3\2\2\2N"+
		"O\3\2\2\2OM\3\2\2\2OP\3\2\2\2PR\3\2\2\2QS\t\4\2\2RQ\3\2\2\2ST\3\2\2\2"+
		"TR\3\2\2\2TU\3\2\2\2U\20\3\2\2\2VW\7K\2\2WX\7P\2\2XY\7V\2\2YZ\7G\2\2Z"+
		"[\7I\2\2[\\\7G\2\2\\o\7T\2\2]^\7U\2\2^_\7V\2\2_`\7T\2\2`a\7K\2\2ab\7P"+
		"\2\2bo\7I\2\2cd\7D\2\2de\7Q\2\2ef\7Q\2\2fg\7N\2\2gh\7G\2\2hi\7C\2\2io"+
		"\7P\2\2jk\7F\2\2kl\7C\2\2lm\7V\2\2mo\7C\2\2nV\3\2\2\2n]\3\2\2\2nc\3\2"+
		"\2\2nj\3\2\2\2o\22\3\2\2\2pq\7Q\2\2qr\7D\2\2rs\7T\2\2st\7K\2\2tu\7I\2"+
		"\2uv\7C\2\2vw\7V\2\2wx\7Q\2\2xy\7T\2\2yz\7K\2\2z\u0084\7Q\2\2{|\7Q\2\2"+
		"|}\7R\2\2}~\7E\2\2~\177\7K\2\2\177\u0080\7Q\2\2\u0080\u0081\7P\2\2\u0081"+
		"\u0082\7C\2\2\u0082\u0084\7N\2\2\u0083p\3\2\2\2\u0083{\3\2\2\2\u0084\24"+
		"\3\2\2\2\u0085\u0087\t\t\2\2\u0086\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088"+
		"\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008b\b\13"+
		"\2\2\u008b\26\3\2\2\2\20\2\35\"\'-\64\66AJOTn\u0083\u0088\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}