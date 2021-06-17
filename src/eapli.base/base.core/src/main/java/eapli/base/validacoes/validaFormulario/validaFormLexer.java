// Generated from D:/2ANO/2SEMESTRE/LAPR4/LAPR4_PROJETO/src/eapli.base/base.core/src/main/java/eapli/base/validacoes/validaFormulario\validaForm.g4 by ANTLR 4.9.1
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
		BARRA=1, PV=2, ANO=3, DOIS_DIGITOS=4, DIGITO=5, TITULO=6, STRING=7, TIPO_DADOS=8, 
		OBRIGATORIO=9, WS=10;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"BARRA", "PV", "ANO", "DOIS_DIGITOS", "DIGITO", "TITULO", "STRING", "TIPO_DADOS", 
			"OBRIGATORIO", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\fl\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\7\3\7\6"+
		"\7(\n\7\r\7\16\7)\3\7\6\7-\n\7\r\7\16\7.\3\b\3\b\6\b\63\n\b\r\b\16\b\64"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tO\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\nd\n\n\3\13\6\13g\n\13\r"+
		"\13\16\13h\3\13\3\13\2\2\f\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\3\2\6\3\2\62;\3\2C\\\3\2c|\5\2\13\f\17\17\"\"\2s\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\3\27\3\2\2\2\5\31\3\2\2\2\7\33\3"+
		"\2\2\2\t \3\2\2\2\13#\3\2\2\2\r%\3\2\2\2\17\60\3\2\2\2\21N\3\2\2\2\23"+
		"c\3\2\2\2\25f\3\2\2\2\27\30\7\61\2\2\30\4\3\2\2\2\31\32\7=\2\2\32\6\3"+
		"\2\2\2\33\34\t\2\2\2\34\35\t\2\2\2\35\36\t\2\2\2\36\37\t\2\2\2\37\b\3"+
		"\2\2\2 !\t\2\2\2!\"\t\2\2\2\"\n\3\2\2\2#$\t\2\2\2$\f\3\2\2\2%\'\t\3\2"+
		"\2&(\t\4\2\2\'&\3\2\2\2()\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*,\3\2\2\2+-\t\2"+
		"\2\2,+\3\2\2\2-.\3\2\2\2.,\3\2\2\2./\3\2\2\2/\16\3\2\2\2\60\62\t\3\2\2"+
		"\61\63\t\4\2\2\62\61\3\2\2\2\63\64\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2"+
		"\65\20\3\2\2\2\66\67\7K\2\2\678\7P\2\289\7V\2\29:\7G\2\2:;\7I\2\2;<\7"+
		"G\2\2<O\7T\2\2=>\7U\2\2>?\7V\2\2?@\7T\2\2@A\7K\2\2AB\7P\2\2BO\7I\2\2C"+
		"D\7D\2\2DE\7Q\2\2EF\7Q\2\2FG\7N\2\2GH\7G\2\2HI\7C\2\2IO\7P\2\2JK\7F\2"+
		"\2KL\7C\2\2LM\7V\2\2MO\7C\2\2N\66\3\2\2\2N=\3\2\2\2NC\3\2\2\2NJ\3\2\2"+
		"\2O\22\3\2\2\2PQ\7Q\2\2QR\7D\2\2RS\7T\2\2ST\7K\2\2TU\7I\2\2UV\7C\2\2V"+
		"W\7V\2\2WX\7Q\2\2XY\7T\2\2YZ\7K\2\2Zd\7Q\2\2[\\\7Q\2\2\\]\7R\2\2]^\7E"+
		"\2\2^_\7K\2\2_`\7Q\2\2`a\7P\2\2ab\7C\2\2bd\7N\2\2cP\3\2\2\2c[\3\2\2\2"+
		"d\24\3\2\2\2eg\t\5\2\2fe\3\2\2\2gh\3\2\2\2hf\3\2\2\2hi\3\2\2\2ij\3\2\2"+
		"\2jk\b\13\2\2k\26\3\2\2\2\t\2).\64Nch\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}