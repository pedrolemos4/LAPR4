// Generated from C:/Users/Tiago/Desktop/LAPR4/lei20_21_s4_2di_04/src/eapli.base/base.core/src/main/java/eapli/base/validacoes/validaFormulario\validaForm.g4 by ANTLR 4.9.1
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
		BARRA=1, PV=2, ANO=3, DOIS_DIGITOS=4, DIGITO=5, TITULO=6, STRING=7, BOOLEAN=8, 
		TIPO_DADOS=9, OBRIGATORIO=10, WS=11;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"BARRA", "PV", "ANO", "DOIS_DIGITOS", "DIGITO", "TITULO", "STRING", "BOOLEAN", 
			"TIPO_DADOS", "OBRIGATORIO", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\ry\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3"+
		"\7\3\7\6\7*\n\7\r\7\16\7+\3\7\6\7/\n\7\r\7\16\7\60\3\b\3\b\6\b\65\n\b"+
		"\r\b\16\b\66\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tB\n\t\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\5\n\\\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13q\n\13\3\f\6\f"+
		"t\n\f\r\f\16\fu\3\f\3\f\2\2\r\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\3\2\6\3\2\62;\3\2C\\\3\2c|\5\2\13\f\17\17\"\"\2\u0081\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\3\31\3"+
		"\2\2\2\5\33\3\2\2\2\7\35\3\2\2\2\t\"\3\2\2\2\13%\3\2\2\2\r\'\3\2\2\2\17"+
		"\62\3\2\2\2\21A\3\2\2\2\23[\3\2\2\2\25p\3\2\2\2\27s\3\2\2\2\31\32\7\61"+
		"\2\2\32\4\3\2\2\2\33\34\7=\2\2\34\6\3\2\2\2\35\36\t\2\2\2\36\37\t\2\2"+
		"\2\37 \t\2\2\2 !\t\2\2\2!\b\3\2\2\2\"#\t\2\2\2#$\t\2\2\2$\n\3\2\2\2%&"+
		"\t\2\2\2&\f\3\2\2\2\')\t\3\2\2(*\t\4\2\2)(\3\2\2\2*+\3\2\2\2+)\3\2\2\2"+
		"+,\3\2\2\2,.\3\2\2\2-/\t\2\2\2.-\3\2\2\2/\60\3\2\2\2\60.\3\2\2\2\60\61"+
		"\3\2\2\2\61\16\3\2\2\2\62\64\t\3\2\2\63\65\t\4\2\2\64\63\3\2\2\2\65\66"+
		"\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\67\20\3\2\2\289\7v\2\29:\7t\2\2:"+
		";\7w\2\2;B\7g\2\2<=\7h\2\2=>\7c\2\2>?\7n\2\2?@\7u\2\2@B\7g\2\2A8\3\2\2"+
		"\2A<\3\2\2\2B\22\3\2\2\2CD\7K\2\2DE\7P\2\2EF\7V\2\2FG\7G\2\2GH\7I\2\2"+
		"HI\7G\2\2I\\\7T\2\2JK\7U\2\2KL\7V\2\2LM\7T\2\2MN\7K\2\2NO\7P\2\2O\\\7"+
		"I\2\2PQ\7D\2\2QR\7Q\2\2RS\7Q\2\2ST\7N\2\2TU\7G\2\2UV\7C\2\2V\\\7P\2\2"+
		"WX\7F\2\2XY\7C\2\2YZ\7V\2\2Z\\\7C\2\2[C\3\2\2\2[J\3\2\2\2[P\3\2\2\2[W"+
		"\3\2\2\2\\\24\3\2\2\2]^\7Q\2\2^_\7D\2\2_`\7T\2\2`a\7K\2\2ab\7I\2\2bc\7"+
		"C\2\2cd\7V\2\2de\7Q\2\2ef\7T\2\2fg\7K\2\2gq\7Q\2\2hi\7Q\2\2ij\7R\2\2j"+
		"k\7E\2\2kl\7K\2\2lm\7Q\2\2mn\7P\2\2no\7C\2\2oq\7N\2\2p]\3\2\2\2ph\3\2"+
		"\2\2q\26\3\2\2\2rt\t\5\2\2sr\3\2\2\2tu\3\2\2\2us\3\2\2\2uv\3\2\2\2vw\3"+
		"\2\2\2wx\b\f\2\2x\30\3\2\2\2\n\2+\60\66A[pu\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}