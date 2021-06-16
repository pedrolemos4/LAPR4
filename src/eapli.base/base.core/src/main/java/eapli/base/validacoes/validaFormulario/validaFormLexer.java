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
		PR=1, PRD=2, PV=3, TITULO=4, STRING=5, INTEGER=6, DATA=7, TIPO_DADOS=8, 
		OBRIGATORIO=9, WS=10;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PR", "PRD", "PV", "TITULO", "STRING", "INTEGER", "DATA", "TIPO_DADOS", 
			"OBRIGATORIO", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\f\u0081\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\6\5 \n\5\r\5\16\5!\3\5\6\5%\n\5"+
		"\r\5\16\5&\3\6\3\6\6\6+\n\6\r\6\16\6,\3\7\3\7\3\7\6\7\62\n\7\r\7\16\7"+
		"\63\5\7\66\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bA\n\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\5\bJ\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\td\n\t\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\5\ny\n\n\3\13\6\13|\n\13\r\13\16\13}\3\13\3\13\2\2\f\3\3\5\4\7\5\t\6"+
		"\13\7\r\b\17\t\21\n\23\13\25\f\3\2\n\3\2C\\\3\2c|\3\2\62;\3\2\63;\3\2"+
		"\62\64\3\2\63\64\3\2\62\63\5\2\f\f\17\17\"\"\2\u008d\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\3\27\3\2\2\2\5\31\3\2\2\2\7\33\3"+
		"\2\2\2\t\35\3\2\2\2\13(\3\2\2\2\r\65\3\2\2\2\17\67\3\2\2\2\21c\3\2\2\2"+
		"\23x\3\2\2\2\25{\3\2\2\2\27\30\7]\2\2\30\4\3\2\2\2\31\32\7_\2\2\32\6\3"+
		"\2\2\2\33\34\7=\2\2\34\b\3\2\2\2\35\37\t\2\2\2\36 \t\3\2\2\37\36\3\2\2"+
		"\2 !\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\"$\3\2\2\2#%\t\4\2\2$#\3\2\2\2%&\3"+
		"\2\2\2&$\3\2\2\2&\'\3\2\2\2\'\n\3\2\2\2(*\t\2\2\2)+\t\3\2\2*)\3\2\2\2"+
		"+,\3\2\2\2,*\3\2\2\2,-\3\2\2\2-\f\3\2\2\2.\66\t\4\2\2/\61\t\5\2\2\60\62"+
		"\t\4\2\2\61\60\3\2\2\2\62\63\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64\66"+
		"\3\2\2\2\65.\3\2\2\2\65/\3\2\2\2\66\16\3\2\2\2\678\t\4\2\289\t\4\2\29"+
		":\t\4\2\2:;\t\4\2\2;@\7\61\2\2<=\7\62\2\2=A\t\5\2\2>?\7\63\2\2?A\t\6\2"+
		"\2@<\3\2\2\2@>\3\2\2\2AB\3\2\2\2BI\7\61\2\2CD\7\62\2\2DJ\t\5\2\2EF\t\7"+
		"\2\2FJ\t\4\2\2GH\7\65\2\2HJ\t\b\2\2IC\3\2\2\2IE\3\2\2\2IG\3\2\2\2J\20"+
		"\3\2\2\2KL\7K\2\2LM\7P\2\2MN\7V\2\2NO\7G\2\2OP\7I\2\2PQ\7G\2\2Qd\7T\2"+
		"\2RS\7U\2\2ST\7V\2\2TU\7T\2\2UV\7K\2\2VW\7P\2\2Wd\7I\2\2XY\7D\2\2YZ\7"+
		"Q\2\2Z[\7Q\2\2[\\\7N\2\2\\]\7G\2\2]^\7C\2\2^d\7P\2\2_`\7F\2\2`a\7C\2\2"+
		"ab\7V\2\2bd\7C\2\2cK\3\2\2\2cR\3\2\2\2cX\3\2\2\2c_\3\2\2\2d\22\3\2\2\2"+
		"ef\7Q\2\2fg\7D\2\2gh\7T\2\2hi\7K\2\2ij\7I\2\2jk\7C\2\2kl\7V\2\2lm\7Q\2"+
		"\2mn\7T\2\2no\7K\2\2oy\7Q\2\2pq\7Q\2\2qr\7R\2\2rs\7E\2\2st\7K\2\2tu\7"+
		"Q\2\2uv\7P\2\2vw\7C\2\2wy\7N\2\2xe\3\2\2\2xp\3\2\2\2y\24\3\2\2\2z|\t\t"+
		"\2\2{z\3\2\2\2|}\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\177\3\2\2\2\177\u0080\b"+
		"\13\2\2\u0080\26\3\2\2\2\r\2!&,\63\65@Icx}\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}