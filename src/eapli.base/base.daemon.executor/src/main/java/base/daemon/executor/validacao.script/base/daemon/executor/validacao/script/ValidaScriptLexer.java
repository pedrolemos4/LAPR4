// Generated from C:/Users/pedro/Documents/lapr4/lapr4/src/eapli.base/base.daemon.executor/src/main/java/base/daemon/executor/validacao.script\ValidaScript.g4 by ANTLR 4.9.1
package base.daemon.executor.validacao.script.base.daemon.executor.validacao.script;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ValidaScriptLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, SOMA_SUB=23, MULT_DIV=24, 
		SOMA=25, SUBTRACAO=26, MULT=27, BARRA=28, ESCALAO=29, PRECO=30, CATEGORIA=31, 
		INTEIRO=32, DOUBLE=33, PONTO_VIRGULA=34, PALAVRA=35, XML=36, WS=37;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "SOMA_SUB", "MULT_DIV", 
			"SOMA", "SUBTRACAO", "MULT", "BARRA", "ESCALAO", "PRECO", "CATEGORIA", 
			"INTEIRO", "DOUBLE", "PONTO_VIRGULA", "PALAVRA", "XML", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Ler ficheiro'", "'->QUANT->'", "'->'", "'('", "')'", "'#'", "'<File>'", 
			"'</File>'", "'<Produto>'", "'</Produto>'", "'<Cliente>'", "'</Cliente>'", 
			"'<Codigo>'", "'</Codigo>'", "'<Preco>'", "'</Preco>'", "'<Categoria>'", 
			"'</Categoria>'", "'<Numero>'", "'</Numero>'", "'<Escalao>'", "'</Escalao>'", 
			null, null, "'+'", "'-'", "'*'", "'/'", "'Escalao'", "'Preco'", "'Categoria'", 
			null, null, "';'", null, "'.xml'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "SOMA_SUB", 
			"MULT_DIV", "SOMA", "SUBTRACAO", "MULT", "BARRA", "ESCALAO", "PRECO", 
			"CATEGORIA", "INTEIRO", "DOUBLE", "PONTO_VIRGULA", "PALAVRA", "XML", 
			"WS"
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


	public ValidaScriptLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ValidaScript.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\'\u0154\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4"+
		"\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 "+
		"\3 \3 \3 \3 \3 \3 \3 \3!\6!\u0131\n!\r!\16!\u0132\3\"\6\"\u0136\n\"\r"+
		"\"\16\"\u0137\3\"\3\"\6\"\u013c\n\"\r\"\16\"\u013d\5\"\u0140\n\"\3#\3"+
		"#\3$\6$\u0145\n$\r$\16$\u0146\3%\3%\3%\3%\3%\3&\6&\u014f\n&\r&\16&\u0150"+
		"\3&\3&\2\2\'\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16"+
		"\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34"+
		"\67\359\36;\37= ?!A\"C#E$G%I&K\'\3\2\7\4\2--//\4\2,,\61\61\3\2\62;\5\2"+
		"\62;C\\c|\5\2\13\f\17\17\"\"\2\u0159\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2"+
		"\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2"+
		"\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3"+
		"\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2"+
		"\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\3M\3\2\2\2"+
		"\5Z\3\2\2\2\7d\3\2\2\2\tg\3\2\2\2\13i\3\2\2\2\rk\3\2\2\2\17m\3\2\2\2\21"+
		"t\3\2\2\2\23|\3\2\2\2\25\u0086\3\2\2\2\27\u0091\3\2\2\2\31\u009b\3\2\2"+
		"\2\33\u00a6\3\2\2\2\35\u00af\3\2\2\2\37\u00b9\3\2\2\2!\u00c1\3\2\2\2#"+
		"\u00ca\3\2\2\2%\u00d6\3\2\2\2\'\u00e3\3\2\2\2)\u00ec\3\2\2\2+\u00f6\3"+
		"\2\2\2-\u0100\3\2\2\2/\u010b\3\2\2\2\61\u010d\3\2\2\2\63\u010f\3\2\2\2"+
		"\65\u0111\3\2\2\2\67\u0113\3\2\2\29\u0115\3\2\2\2;\u0117\3\2\2\2=\u011f"+
		"\3\2\2\2?\u0125\3\2\2\2A\u0130\3\2\2\2C\u0135\3\2\2\2E\u0141\3\2\2\2G"+
		"\u0144\3\2\2\2I\u0148\3\2\2\2K\u014e\3\2\2\2MN\7N\2\2NO\7g\2\2OP\7t\2"+
		"\2PQ\7\"\2\2QR\7h\2\2RS\7k\2\2ST\7e\2\2TU\7j\2\2UV\7g\2\2VW\7k\2\2WX\7"+
		"t\2\2XY\7q\2\2Y\4\3\2\2\2Z[\7/\2\2[\\\7@\2\2\\]\7S\2\2]^\7W\2\2^_\7C\2"+
		"\2_`\7P\2\2`a\7V\2\2ab\7/\2\2bc\7@\2\2c\6\3\2\2\2de\7/\2\2ef\7@\2\2f\b"+
		"\3\2\2\2gh\7*\2\2h\n\3\2\2\2ij\7+\2\2j\f\3\2\2\2kl\7%\2\2l\16\3\2\2\2"+
		"mn\7>\2\2no\7H\2\2op\7k\2\2pq\7n\2\2qr\7g\2\2rs\7@\2\2s\20\3\2\2\2tu\7"+
		">\2\2uv\7\61\2\2vw\7H\2\2wx\7k\2\2xy\7n\2\2yz\7g\2\2z{\7@\2\2{\22\3\2"+
		"\2\2|}\7>\2\2}~\7R\2\2~\177\7t\2\2\177\u0080\7q\2\2\u0080\u0081\7f\2\2"+
		"\u0081\u0082\7w\2\2\u0082\u0083\7v\2\2\u0083\u0084\7q\2\2\u0084\u0085"+
		"\7@\2\2\u0085\24\3\2\2\2\u0086\u0087\7>\2\2\u0087\u0088\7\61\2\2\u0088"+
		"\u0089\7R\2\2\u0089\u008a\7t\2\2\u008a\u008b\7q\2\2\u008b\u008c\7f\2\2"+
		"\u008c\u008d\7w\2\2\u008d\u008e\7v\2\2\u008e\u008f\7q\2\2\u008f\u0090"+
		"\7@\2\2\u0090\26\3\2\2\2\u0091\u0092\7>\2\2\u0092\u0093\7E\2\2\u0093\u0094"+
		"\7n\2\2\u0094\u0095\7k\2\2\u0095\u0096\7g\2\2\u0096\u0097\7p\2\2\u0097"+
		"\u0098\7v\2\2\u0098\u0099\7g\2\2\u0099\u009a\7@\2\2\u009a\30\3\2\2\2\u009b"+
		"\u009c\7>\2\2\u009c\u009d\7\61\2\2\u009d\u009e\7E\2\2\u009e\u009f\7n\2"+
		"\2\u009f\u00a0\7k\2\2\u00a0\u00a1\7g\2\2\u00a1\u00a2\7p\2\2\u00a2\u00a3"+
		"\7v\2\2\u00a3\u00a4\7g\2\2\u00a4\u00a5\7@\2\2\u00a5\32\3\2\2\2\u00a6\u00a7"+
		"\7>\2\2\u00a7\u00a8\7E\2\2\u00a8\u00a9\7q\2\2\u00a9\u00aa\7f\2\2\u00aa"+
		"\u00ab\7k\2\2\u00ab\u00ac\7i\2\2\u00ac\u00ad\7q\2\2\u00ad\u00ae\7@\2\2"+
		"\u00ae\34\3\2\2\2\u00af\u00b0\7>\2\2\u00b0\u00b1\7\61\2\2\u00b1\u00b2"+
		"\7E\2\2\u00b2\u00b3\7q\2\2\u00b3\u00b4\7f\2\2\u00b4\u00b5\7k\2\2\u00b5"+
		"\u00b6\7i\2\2\u00b6\u00b7\7q\2\2\u00b7\u00b8\7@\2\2\u00b8\36\3\2\2\2\u00b9"+
		"\u00ba\7>\2\2\u00ba\u00bb\7R\2\2\u00bb\u00bc\7t\2\2\u00bc\u00bd\7g\2\2"+
		"\u00bd\u00be\7e\2\2\u00be\u00bf\7q\2\2\u00bf\u00c0\7@\2\2\u00c0 \3\2\2"+
		"\2\u00c1\u00c2\7>\2\2\u00c2\u00c3\7\61\2\2\u00c3\u00c4\7R\2\2\u00c4\u00c5"+
		"\7t\2\2\u00c5\u00c6\7g\2\2\u00c6\u00c7\7e\2\2\u00c7\u00c8\7q\2\2\u00c8"+
		"\u00c9\7@\2\2\u00c9\"\3\2\2\2\u00ca\u00cb\7>\2\2\u00cb\u00cc\7E\2\2\u00cc"+
		"\u00cd\7c\2\2\u00cd\u00ce\7v\2\2\u00ce\u00cf\7g\2\2\u00cf\u00d0\7i\2\2"+
		"\u00d0\u00d1\7q\2\2\u00d1\u00d2\7t\2\2\u00d2\u00d3\7k\2\2\u00d3\u00d4"+
		"\7c\2\2\u00d4\u00d5\7@\2\2\u00d5$\3\2\2\2\u00d6\u00d7\7>\2\2\u00d7\u00d8"+
		"\7\61\2\2\u00d8\u00d9\7E\2\2\u00d9\u00da\7c\2\2\u00da\u00db\7v\2\2\u00db"+
		"\u00dc\7g\2\2\u00dc\u00dd\7i\2\2\u00dd\u00de\7q\2\2\u00de\u00df\7t\2\2"+
		"\u00df\u00e0\7k\2\2\u00e0\u00e1\7c\2\2\u00e1\u00e2\7@\2\2\u00e2&\3\2\2"+
		"\2\u00e3\u00e4\7>\2\2\u00e4\u00e5\7P\2\2\u00e5\u00e6\7w\2\2\u00e6\u00e7"+
		"\7o\2\2\u00e7\u00e8\7g\2\2\u00e8\u00e9\7t\2\2\u00e9\u00ea\7q\2\2\u00ea"+
		"\u00eb\7@\2\2\u00eb(\3\2\2\2\u00ec\u00ed\7>\2\2\u00ed\u00ee\7\61\2\2\u00ee"+
		"\u00ef\7P\2\2\u00ef\u00f0\7w\2\2\u00f0\u00f1\7o\2\2\u00f1\u00f2\7g\2\2"+
		"\u00f2\u00f3\7t\2\2\u00f3\u00f4\7q\2\2\u00f4\u00f5\7@\2\2\u00f5*\3\2\2"+
		"\2\u00f6\u00f7\7>\2\2\u00f7\u00f8\7G\2\2\u00f8\u00f9\7u\2\2\u00f9\u00fa"+
		"\7e\2\2\u00fa\u00fb\7c\2\2\u00fb\u00fc\7n\2\2\u00fc\u00fd\7c\2\2\u00fd"+
		"\u00fe\7q\2\2\u00fe\u00ff\7@\2\2\u00ff,\3\2\2\2\u0100\u0101\7>\2\2\u0101"+
		"\u0102\7\61\2\2\u0102\u0103\7G\2\2\u0103\u0104\7u\2\2\u0104\u0105\7e\2"+
		"\2\u0105\u0106\7c\2\2\u0106\u0107\7n\2\2\u0107\u0108\7c\2\2\u0108\u0109"+
		"\7q\2\2\u0109\u010a\7@\2\2\u010a.\3\2\2\2\u010b\u010c\t\2\2\2\u010c\60"+
		"\3\2\2\2\u010d\u010e\t\3\2\2\u010e\62\3\2\2\2\u010f\u0110\7-\2\2\u0110"+
		"\64\3\2\2\2\u0111\u0112\7/\2\2\u0112\66\3\2\2\2\u0113\u0114\7,\2\2\u0114"+
		"8\3\2\2\2\u0115\u0116\7\61\2\2\u0116:\3\2\2\2\u0117\u0118\7G\2\2\u0118"+
		"\u0119\7u\2\2\u0119\u011a\7e\2\2\u011a\u011b\7c\2\2\u011b\u011c\7n\2\2"+
		"\u011c\u011d\7c\2\2\u011d\u011e\7q\2\2\u011e<\3\2\2\2\u011f\u0120\7R\2"+
		"\2\u0120\u0121\7t\2\2\u0121\u0122\7g\2\2\u0122\u0123\7e\2\2\u0123\u0124"+
		"\7q\2\2\u0124>\3\2\2\2\u0125\u0126\7E\2\2\u0126\u0127\7c\2\2\u0127\u0128"+
		"\7v\2\2\u0128\u0129\7g\2\2\u0129\u012a\7i\2\2\u012a\u012b\7q\2\2\u012b"+
		"\u012c\7t\2\2\u012c\u012d\7k\2\2\u012d\u012e\7c\2\2\u012e@\3\2\2\2\u012f"+
		"\u0131\t\4\2\2\u0130\u012f\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0130\3\2"+
		"\2\2\u0132\u0133\3\2\2\2\u0133B\3\2\2\2\u0134\u0136\t\4\2\2\u0135\u0134"+
		"\3\2\2\2\u0136\u0137\3\2\2\2\u0137\u0135\3\2\2\2\u0137\u0138\3\2\2\2\u0138"+
		"\u013f\3\2\2\2\u0139\u013b\7\60\2\2\u013a\u013c\t\4\2\2\u013b\u013a\3"+
		"\2\2\2\u013c\u013d\3\2\2\2\u013d\u013b\3\2\2\2\u013d\u013e\3\2\2\2\u013e"+
		"\u0140\3\2\2\2\u013f\u0139\3\2\2\2\u013f\u0140\3\2\2\2\u0140D\3\2\2\2"+
		"\u0141\u0142\7=\2\2\u0142F\3\2\2\2\u0143\u0145\t\5\2\2\u0144\u0143\3\2"+
		"\2\2\u0145\u0146\3\2\2\2\u0146\u0144\3\2\2\2\u0146\u0147\3\2\2\2\u0147"+
		"H\3\2\2\2\u0148\u0149\7\60\2\2\u0149\u014a\7z\2\2\u014a\u014b\7o\2\2\u014b"+
		"\u014c\7n\2\2\u014cJ\3\2\2\2\u014d\u014f\t\6\2\2\u014e\u014d\3\2\2\2\u014f"+
		"\u0150\3\2\2\2\u0150\u014e\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u0152\3\2"+
		"\2\2\u0152\u0153\b&\2\2\u0153L\3\2\2\2\t\2\u0132\u0137\u013d\u013f\u0146"+
		"\u0150\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}