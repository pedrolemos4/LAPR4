// Generated from D:/2ANO/2SEMESTRE/LAPR4/LAPR4_PROJETO/src/eapli.base/base.core/src/main/java/eapli/base/validacoes/valida\validaForm.g4 by ANTLR 4.9.1
package eapli.base.validacoes.valida;
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

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 1:
			TITULO_action((RuleContext)_localctx, actionIndex);
			break;
		case 2:
			LABEL_action((RuleContext)_localctx, actionIndex);
			break;
		case 6:
			DESCRICAO_AJUDA_action((RuleContext)_localctx, actionIndex);
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
	private void LABEL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			1,30
			break;
		}
	}
	private void DESCRICAO_AJUDA_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:
			1,30
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\f\u0092\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\3\2\3\2\3\3\3\3\6\3\34\n\3\r\3\16\3\35\3\3\6\3!\n\3\r\3\16\3\"\3"+
		"\3\3\3\3\4\6\4(\n\4\r\4\16\4)\3\4\3\4\3\5\3\5\6\5\60\n\5\r\5\16\5\61\3"+
		"\6\3\6\3\6\6\6\67\n\6\r\6\16\68\5\6;\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\5\7F\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7O\n\7\3\b\6\bR\n\b\r\b"+
		"\16\bS\3\b\6\bW\n\b\r\b\16\bX\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tu"+
		"\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\5\n\u008a\n\n\3\13\6\13\u008d\n\13\r\13\16\13\u008e\3\13\3"+
		"\13\2\2\f\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\3\2\n\3\2C\\\3"+
		"\2c|\3\2\62;\3\2\63;\3\2\62\64\3\2\63\64\3\2\62\63\5\2\13\f\17\17\"\""+
		"\2\u00a1\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\3\27"+
		"\3\2\2\2\5\31\3\2\2\2\7\'\3\2\2\2\t-\3\2\2\2\13:\3\2\2\2\r<\3\2\2\2\17"+
		"Q\3\2\2\2\21t\3\2\2\2\23\u0089\3\2\2\2\25\u008c\3\2\2\2\27\30\7=\2\2\30"+
		"\4\3\2\2\2\31\33\t\2\2\2\32\34\t\3\2\2\33\32\3\2\2\2\34\35\3\2\2\2\35"+
		"\33\3\2\2\2\35\36\3\2\2\2\36 \3\2\2\2\37!\t\4\2\2 \37\3\2\2\2!\"\3\2\2"+
		"\2\" \3\2\2\2\"#\3\2\2\2#$\3\2\2\2$%\b\3\2\2%\6\3\2\2\2&(\t\3\2\2\'&\3"+
		"\2\2\2()\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*+\3\2\2\2+,\b\4\3\2,\b\3\2\2\2-"+
		"/\t\2\2\2.\60\t\3\2\2/.\3\2\2\2\60\61\3\2\2\2\61/\3\2\2\2\61\62\3\2\2"+
		"\2\62\n\3\2\2\2\63;\t\4\2\2\64\66\t\5\2\2\65\67\t\4\2\2\66\65\3\2\2\2"+
		"\678\3\2\2\28\66\3\2\2\289\3\2\2\29;\3\2\2\2:\63\3\2\2\2:\64\3\2\2\2;"+
		"\f\3\2\2\2<=\t\4\2\2=>\t\4\2\2>?\t\4\2\2?@\t\4\2\2@E\7\61\2\2AB\7\62\2"+
		"\2BF\t\5\2\2CD\7\63\2\2DF\t\6\2\2EA\3\2\2\2EC\3\2\2\2FG\3\2\2\2GN\7\61"+
		"\2\2HI\7\62\2\2IO\t\5\2\2JK\t\7\2\2KO\t\4\2\2LM\7\65\2\2MO\t\b\2\2NH\3"+
		"\2\2\2NJ\3\2\2\2NL\3\2\2\2O\16\3\2\2\2PR\t\3\2\2QP\3\2\2\2RS\3\2\2\2S"+
		"Q\3\2\2\2ST\3\2\2\2TV\3\2\2\2UW\t\4\2\2VU\3\2\2\2WX\3\2\2\2XV\3\2\2\2"+
		"XY\3\2\2\2YZ\3\2\2\2Z[\b\b\4\2[\20\3\2\2\2\\]\7K\2\2]^\7P\2\2^_\7V\2\2"+
		"_`\7G\2\2`a\7I\2\2ab\7G\2\2bu\7T\2\2cd\7U\2\2de\7V\2\2ef\7T\2\2fg\7K\2"+
		"\2gh\7P\2\2hu\7I\2\2ij\7D\2\2jk\7Q\2\2kl\7Q\2\2lm\7N\2\2mn\7G\2\2no\7"+
		"C\2\2ou\7P\2\2pq\7F\2\2qr\7C\2\2rs\7V\2\2su\7C\2\2t\\\3\2\2\2tc\3\2\2"+
		"\2ti\3\2\2\2tp\3\2\2\2u\22\3\2\2\2vw\7Q\2\2wx\7D\2\2xy\7T\2\2yz\7K\2\2"+
		"z{\7I\2\2{|\7C\2\2|}\7V\2\2}~\7Q\2\2~\177\7T\2\2\177\u0080\7K\2\2\u0080"+
		"\u008a\7Q\2\2\u0081\u0082\7Q\2\2\u0082\u0083\7R\2\2\u0083\u0084\7E\2\2"+
		"\u0084\u0085\7K\2\2\u0085\u0086\7Q\2\2\u0086\u0087\7P\2\2\u0087\u0088"+
		"\7C\2\2\u0088\u008a\7N\2\2\u0089v\3\2\2\2\u0089\u0081\3\2\2\2\u008a\24"+
		"\3\2\2\2\u008b\u008d\t\t\2\2\u008c\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e"+
		"\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0091\b\13"+
		"\5\2\u0091\26\3\2\2\2\20\2\35\")\618:ENSXt\u0089\u008e\6\3\3\2\3\4\3\3"+
		"\b\4\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}