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
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, SOMA_SUB=33, MULT_DIV=34, SINAL_BOOLEANO=35, SOMA=36, SUBTRACAO=37, 
		MULT=38, BARRA=39, ESCALAO=40, PRECO=41, CATEGORIA=42, INTEIRO=43, DOUBLE=44, 
		PONTO_VIRGULA=45, PALAVRA=46, EMAIL=47, XML=48, WS=49;
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
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
			"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "SOMA_SUB", 
			"MULT_DIV", "SINAL_BOOLEANO", "SOMA", "SUBTRACAO", "MULT", "BARRA", "ESCALAO", 
			"PRECO", "CATEGORIA", "INTEIRO", "DOUBLE", "PONTO_VIRGULA", "PALAVRA", 
			"EMAIL", "XML", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Ler ficheiro'", "'if '", "' then:'", "'end if;'", "'Valor total'", 
			"'else'", "'CATEGORIA'", "'=='", "'!='", "'Aplicar Desconto->'", "'Send Email'", 
			"'->'", "'('", "')'", "'%'", "'#'", "'<File>'", "'</File>'", "'<Produto>'", 
			"'</Produto>'", "'<Cliente>'", "'</Cliente>'", "'<Codigo>'", "'</Codigo>'", 
			"'<Preco>'", "'</Preco>'", "'<Categoria>'", "'</Categoria>'", "'<Numero>'", 
			"'</Numero>'", "'<Escalao>'", "'</Escalao>'", null, null, null, "'+'", 
			"'-'", "'*'", "'/'", "'Escalao'", "'Preco'", "'Categoria'", null, null, 
			"';'", null, null, "'.xml'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "SOMA_SUB", "MULT_DIV", 
			"SINAL_BOOLEANO", "SOMA", "SUBTRACAO", "MULT", "BARRA", "ESCALAO", "PRECO", 
			"CATEGORIA", "INTEIRO", "DOUBLE", "PONTO_VIRGULA", "PALAVRA", "EMAIL", 
			"XML", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\63\u01e7\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20"+
		"\3\20\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3\"\3"+
		"\"\3#\3#\3$\3$\3$\3$\3$\3$\5$\u0178\n$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3"+
		")\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3"+
		",\6,\u019b\n,\r,\16,\u019c\3-\6-\u01a0\n-\r-\16-\u01a1\3-\3-\6-\u01a6"+
		"\n-\r-\16-\u01a7\5-\u01aa\n-\3.\3.\3/\6/\u01af\n/\r/\16/\u01b0\3\60\6"+
		"\60\u01b4\n\60\r\60\16\60\u01b5\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60"+
		"\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60"+
		"\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\5\60\u01da"+
		"\n\60\3\61\3\61\3\61\3\61\3\61\3\62\6\62\u01e2\n\62\r\62\16\62\u01e3\3"+
		"\62\3\62\2\2\63\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65"+
		"\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63\3"+
		"\2\b\4\2--//\4\2,,\61\61\4\2>>@@\3\2\62;\5\2\62;C\\c|\5\2\13\f\17\17\""+
		"\"\2\u01f2\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2"+
		"\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S"+
		"\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2"+
		"\2\2\2a\3\2\2\2\2c\3\2\2\2\3e\3\2\2\2\5r\3\2\2\2\7v\3\2\2\2\t}\3\2\2\2"+
		"\13\u0085\3\2\2\2\r\u0091\3\2\2\2\17\u0096\3\2\2\2\21\u00a0\3\2\2\2\23"+
		"\u00a3\3\2\2\2\25\u00a6\3\2\2\2\27\u00b9\3\2\2\2\31\u00c4\3\2\2\2\33\u00c7"+
		"\3\2\2\2\35\u00c9\3\2\2\2\37\u00cb\3\2\2\2!\u00cd\3\2\2\2#\u00cf\3\2\2"+
		"\2%\u00d6\3\2\2\2\'\u00de\3\2\2\2)\u00e8\3\2\2\2+\u00f3\3\2\2\2-\u00fd"+
		"\3\2\2\2/\u0108\3\2\2\2\61\u0111\3\2\2\2\63\u011b\3\2\2\2\65\u0123\3\2"+
		"\2\2\67\u012c\3\2\2\29\u0138\3\2\2\2;\u0145\3\2\2\2=\u014e\3\2\2\2?\u0158"+
		"\3\2\2\2A\u0162\3\2\2\2C\u016d\3\2\2\2E\u016f\3\2\2\2G\u0177\3\2\2\2I"+
		"\u0179\3\2\2\2K\u017b\3\2\2\2M\u017d\3\2\2\2O\u017f\3\2\2\2Q\u0181\3\2"+
		"\2\2S\u0189\3\2\2\2U\u018f\3\2\2\2W\u019a\3\2\2\2Y\u019f\3\2\2\2[\u01ab"+
		"\3\2\2\2]\u01ae\3\2\2\2_\u01b3\3\2\2\2a\u01db\3\2\2\2c\u01e1\3\2\2\2e"+
		"f\7N\2\2fg\7g\2\2gh\7t\2\2hi\7\"\2\2ij\7h\2\2jk\7k\2\2kl\7e\2\2lm\7j\2"+
		"\2mn\7g\2\2no\7k\2\2op\7t\2\2pq\7q\2\2q\4\3\2\2\2rs\7k\2\2st\7h\2\2tu"+
		"\7\"\2\2u\6\3\2\2\2vw\7\"\2\2wx\7v\2\2xy\7j\2\2yz\7g\2\2z{\7p\2\2{|\7"+
		"<\2\2|\b\3\2\2\2}~\7g\2\2~\177\7p\2\2\177\u0080\7f\2\2\u0080\u0081\7\""+
		"\2\2\u0081\u0082\7k\2\2\u0082\u0083\7h\2\2\u0083\u0084\7=\2\2\u0084\n"+
		"\3\2\2\2\u0085\u0086\7X\2\2\u0086\u0087\7c\2\2\u0087\u0088\7n\2\2\u0088"+
		"\u0089\7q\2\2\u0089\u008a\7t\2\2\u008a\u008b\7\"\2\2\u008b\u008c\7v\2"+
		"\2\u008c\u008d\7q\2\2\u008d\u008e\7v\2\2\u008e\u008f\7c\2\2\u008f\u0090"+
		"\7n\2\2\u0090\f\3\2\2\2\u0091\u0092\7g\2\2\u0092\u0093\7n\2\2\u0093\u0094"+
		"\7u\2\2\u0094\u0095\7g\2\2\u0095\16\3\2\2\2\u0096\u0097\7E\2\2\u0097\u0098"+
		"\7C\2\2\u0098\u0099\7V\2\2\u0099\u009a\7G\2\2\u009a\u009b\7I\2\2\u009b"+
		"\u009c\7Q\2\2\u009c\u009d\7T\2\2\u009d\u009e\7K\2\2\u009e\u009f\7C\2\2"+
		"\u009f\20\3\2\2\2\u00a0\u00a1\7?\2\2\u00a1\u00a2\7?\2\2\u00a2\22\3\2\2"+
		"\2\u00a3\u00a4\7#\2\2\u00a4\u00a5\7?\2\2\u00a5\24\3\2\2\2\u00a6\u00a7"+
		"\7C\2\2\u00a7\u00a8\7r\2\2\u00a8\u00a9\7n\2\2\u00a9\u00aa\7k\2\2\u00aa"+
		"\u00ab\7e\2\2\u00ab\u00ac\7c\2\2\u00ac\u00ad\7t\2\2\u00ad\u00ae\7\"\2"+
		"\2\u00ae\u00af\7F\2\2\u00af\u00b0\7g\2\2\u00b0\u00b1\7u\2\2\u00b1\u00b2"+
		"\7e\2\2\u00b2\u00b3\7q\2\2\u00b3\u00b4\7p\2\2\u00b4\u00b5\7v\2\2\u00b5"+
		"\u00b6\7q\2\2\u00b6\u00b7\7/\2\2\u00b7\u00b8\7@\2\2\u00b8\26\3\2\2\2\u00b9"+
		"\u00ba\7U\2\2\u00ba\u00bb\7g\2\2\u00bb\u00bc\7p\2\2\u00bc\u00bd\7f\2\2"+
		"\u00bd\u00be\7\"\2\2\u00be\u00bf\7G\2\2\u00bf\u00c0\7o\2\2\u00c0\u00c1"+
		"\7c\2\2\u00c1\u00c2\7k\2\2\u00c2\u00c3\7n\2\2\u00c3\30\3\2\2\2\u00c4\u00c5"+
		"\7/\2\2\u00c5\u00c6\7@\2\2\u00c6\32\3\2\2\2\u00c7\u00c8\7*\2\2\u00c8\34"+
		"\3\2\2\2\u00c9\u00ca\7+\2\2\u00ca\36\3\2\2\2\u00cb\u00cc\7\'\2\2\u00cc"+
		" \3\2\2\2\u00cd\u00ce\7%\2\2\u00ce\"\3\2\2\2\u00cf\u00d0\7>\2\2\u00d0"+
		"\u00d1\7H\2\2\u00d1\u00d2\7k\2\2\u00d2\u00d3\7n\2\2\u00d3\u00d4\7g\2\2"+
		"\u00d4\u00d5\7@\2\2\u00d5$\3\2\2\2\u00d6\u00d7\7>\2\2\u00d7\u00d8\7\61"+
		"\2\2\u00d8\u00d9\7H\2\2\u00d9\u00da\7k\2\2\u00da\u00db\7n\2\2\u00db\u00dc"+
		"\7g\2\2\u00dc\u00dd\7@\2\2\u00dd&\3\2\2\2\u00de\u00df\7>\2\2\u00df\u00e0"+
		"\7R\2\2\u00e0\u00e1\7t\2\2\u00e1\u00e2\7q\2\2\u00e2\u00e3\7f\2\2\u00e3"+
		"\u00e4\7w\2\2\u00e4\u00e5\7v\2\2\u00e5\u00e6\7q\2\2\u00e6\u00e7\7@\2\2"+
		"\u00e7(\3\2\2\2\u00e8\u00e9\7>\2\2\u00e9\u00ea\7\61\2\2\u00ea\u00eb\7"+
		"R\2\2\u00eb\u00ec\7t\2\2\u00ec\u00ed\7q\2\2\u00ed\u00ee\7f\2\2\u00ee\u00ef"+
		"\7w\2\2\u00ef\u00f0\7v\2\2\u00f0\u00f1\7q\2\2\u00f1\u00f2\7@\2\2\u00f2"+
		"*\3\2\2\2\u00f3\u00f4\7>\2\2\u00f4\u00f5\7E\2\2\u00f5\u00f6\7n\2\2\u00f6"+
		"\u00f7\7k\2\2\u00f7\u00f8\7g\2\2\u00f8\u00f9\7p\2\2\u00f9\u00fa\7v\2\2"+
		"\u00fa\u00fb\7g\2\2\u00fb\u00fc\7@\2\2\u00fc,\3\2\2\2\u00fd\u00fe\7>\2"+
		"\2\u00fe\u00ff\7\61\2\2\u00ff\u0100\7E\2\2\u0100\u0101\7n\2\2\u0101\u0102"+
		"\7k\2\2\u0102\u0103\7g\2\2\u0103\u0104\7p\2\2\u0104\u0105\7v\2\2\u0105"+
		"\u0106\7g\2\2\u0106\u0107\7@\2\2\u0107.\3\2\2\2\u0108\u0109\7>\2\2\u0109"+
		"\u010a\7E\2\2\u010a\u010b\7q\2\2\u010b\u010c\7f\2\2\u010c\u010d\7k\2\2"+
		"\u010d\u010e\7i\2\2\u010e\u010f\7q\2\2\u010f\u0110\7@\2\2\u0110\60\3\2"+
		"\2\2\u0111\u0112\7>\2\2\u0112\u0113\7\61\2\2\u0113\u0114\7E\2\2\u0114"+
		"\u0115\7q\2\2\u0115\u0116\7f\2\2\u0116\u0117\7k\2\2\u0117\u0118\7i\2\2"+
		"\u0118\u0119\7q\2\2\u0119\u011a\7@\2\2\u011a\62\3\2\2\2\u011b\u011c\7"+
		">\2\2\u011c\u011d\7R\2\2\u011d\u011e\7t\2\2\u011e\u011f\7g\2\2\u011f\u0120"+
		"\7e\2\2\u0120\u0121\7q\2\2\u0121\u0122\7@\2\2\u0122\64\3\2\2\2\u0123\u0124"+
		"\7>\2\2\u0124\u0125\7\61\2\2\u0125\u0126\7R\2\2\u0126\u0127\7t\2\2\u0127"+
		"\u0128\7g\2\2\u0128\u0129\7e\2\2\u0129\u012a\7q\2\2\u012a\u012b\7@\2\2"+
		"\u012b\66\3\2\2\2\u012c\u012d\7>\2\2\u012d\u012e\7E\2\2\u012e\u012f\7"+
		"c\2\2\u012f\u0130\7v\2\2\u0130\u0131\7g\2\2\u0131\u0132\7i\2\2\u0132\u0133"+
		"\7q\2\2\u0133\u0134\7t\2\2\u0134\u0135\7k\2\2\u0135\u0136\7c\2\2\u0136"+
		"\u0137\7@\2\2\u01378\3\2\2\2\u0138\u0139\7>\2\2\u0139\u013a\7\61\2\2\u013a"+
		"\u013b\7E\2\2\u013b\u013c\7c\2\2\u013c\u013d\7v\2\2\u013d\u013e\7g\2\2"+
		"\u013e\u013f\7i\2\2\u013f\u0140\7q\2\2\u0140\u0141\7t\2\2\u0141\u0142"+
		"\7k\2\2\u0142\u0143\7c\2\2\u0143\u0144\7@\2\2\u0144:\3\2\2\2\u0145\u0146"+
		"\7>\2\2\u0146\u0147\7P\2\2\u0147\u0148\7w\2\2\u0148\u0149\7o\2\2\u0149"+
		"\u014a\7g\2\2\u014a\u014b\7t\2\2\u014b\u014c\7q\2\2\u014c\u014d\7@\2\2"+
		"\u014d<\3\2\2\2\u014e\u014f\7>\2\2\u014f\u0150\7\61\2\2\u0150\u0151\7"+
		"P\2\2\u0151\u0152\7w\2\2\u0152\u0153\7o\2\2\u0153\u0154\7g\2\2\u0154\u0155"+
		"\7t\2\2\u0155\u0156\7q\2\2\u0156\u0157\7@\2\2\u0157>\3\2\2\2\u0158\u0159"+
		"\7>\2\2\u0159\u015a\7G\2\2\u015a\u015b\7u\2\2\u015b\u015c\7e\2\2\u015c"+
		"\u015d\7c\2\2\u015d\u015e\7n\2\2\u015e\u015f\7c\2\2\u015f\u0160\7q\2\2"+
		"\u0160\u0161\7@\2\2\u0161@\3\2\2\2\u0162\u0163\7>\2\2\u0163\u0164\7\61"+
		"\2\2\u0164\u0165\7G\2\2\u0165\u0166\7u\2\2\u0166\u0167\7e\2\2\u0167\u0168"+
		"\7c\2\2\u0168\u0169\7n\2\2\u0169\u016a\7c\2\2\u016a\u016b\7q\2\2\u016b"+
		"\u016c\7@\2\2\u016cB\3\2\2\2\u016d\u016e\t\2\2\2\u016eD\3\2\2\2\u016f"+
		"\u0170\t\3\2\2\u0170F\3\2\2\2\u0171\u0178\t\4\2\2\u0172\u0173\7>\2\2\u0173"+
		"\u0178\7?\2\2\u0174\u0175\7@\2\2\u0175\u0178\7?\2\2\u0176\u0178\7?\2\2"+
		"\u0177\u0171\3\2\2\2\u0177\u0172\3\2\2\2\u0177\u0174\3\2\2\2\u0177\u0176"+
		"\3\2\2\2\u0178H\3\2\2\2\u0179\u017a\7-\2\2\u017aJ\3\2\2\2\u017b\u017c"+
		"\7/\2\2\u017cL\3\2\2\2\u017d\u017e\7,\2\2\u017eN\3\2\2\2\u017f\u0180\7"+
		"\61\2\2\u0180P\3\2\2\2\u0181\u0182\7G\2\2\u0182\u0183\7u\2\2\u0183\u0184"+
		"\7e\2\2\u0184\u0185\7c\2\2\u0185\u0186\7n\2\2\u0186\u0187\7c\2\2\u0187"+
		"\u0188\7q\2\2\u0188R\3\2\2\2\u0189\u018a\7R\2\2\u018a\u018b\7t\2\2\u018b"+
		"\u018c\7g\2\2\u018c\u018d\7e\2\2\u018d\u018e\7q\2\2\u018eT\3\2\2\2\u018f"+
		"\u0190\7E\2\2\u0190\u0191\7c\2\2\u0191\u0192\7v\2\2\u0192\u0193\7g\2\2"+
		"\u0193\u0194\7i\2\2\u0194\u0195\7q\2\2\u0195\u0196\7t\2\2\u0196\u0197"+
		"\7k\2\2\u0197\u0198\7c\2\2\u0198V\3\2\2\2\u0199\u019b\t\5\2\2\u019a\u0199"+
		"\3\2\2\2\u019b\u019c\3\2\2\2\u019c\u019a\3\2\2\2\u019c\u019d\3\2\2\2\u019d"+
		"X\3\2\2\2\u019e\u01a0\t\5\2\2\u019f\u019e\3\2\2\2\u01a0\u01a1\3\2\2\2"+
		"\u01a1\u019f\3\2\2\2\u01a1\u01a2\3\2\2\2\u01a2\u01a9\3\2\2\2\u01a3\u01a5"+
		"\7\60\2\2\u01a4\u01a6\t\5\2\2\u01a5\u01a4\3\2\2\2\u01a6\u01a7\3\2\2\2"+
		"\u01a7\u01a5\3\2\2\2\u01a7\u01a8\3\2\2\2\u01a8\u01aa\3\2\2\2\u01a9\u01a3"+
		"\3\2\2\2\u01a9\u01aa\3\2\2\2\u01aaZ\3\2\2\2\u01ab\u01ac\7=\2\2\u01ac\\"+
		"\3\2\2\2\u01ad\u01af\t\6\2\2\u01ae\u01ad\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0"+
		"\u01ae\3\2\2\2\u01b0\u01b1\3\2\2\2\u01b1^\3\2\2\2\u01b2\u01b4\t\6\2\2"+
		"\u01b3\u01b2\3\2\2\2\u01b4\u01b5\3\2\2\2\u01b5\u01b3\3\2\2\2\u01b5\u01b6"+
		"\3\2\2\2\u01b6\u01d9\3\2\2\2\u01b7\u01b8\7B\2\2\u01b8\u01b9\7i\2\2\u01b9"+
		"\u01ba\7o\2\2\u01ba\u01bb\7c\2\2\u01bb\u01bc\7k\2\2\u01bc\u01bd\7n\2\2"+
		"\u01bd\u01be\7\60\2\2\u01be\u01bf\7e\2\2\u01bf\u01c0\7q\2\2\u01c0\u01da"+
		"\7o\2\2\u01c1\u01c2\7B\2\2\u01c2\u01c3\7j\2\2\u01c3\u01c4\7q\2\2\u01c4"+
		"\u01c5\7v\2\2\u01c5\u01c6\7o\2\2\u01c6\u01c7\7c\2\2\u01c7\u01c8\7k\2\2"+
		"\u01c8\u01c9\7n\2\2\u01c9\u01ca\7\60\2\2\u01ca\u01cb\7e\2\2\u01cb\u01cc"+
		"\7q\2\2\u01cc\u01da\7o\2\2\u01cd\u01ce\7B\2\2\u01ce\u01cf\7k\2\2\u01cf"+
		"\u01d0\7u\2\2\u01d0\u01d1\7g\2\2\u01d1\u01d2\7r\2\2\u01d2\u01d3\7\60\2"+
		"\2\u01d3\u01d4\7k\2\2\u01d4\u01d5\7r\2\2\u01d5\u01d6\7r\2\2\u01d6\u01d7"+
		"\7\60\2\2\u01d7\u01d8\7r\2\2\u01d8\u01da\7v\2\2\u01d9\u01b7\3\2\2\2\u01d9"+
		"\u01c1\3\2\2\2\u01d9\u01cd\3\2\2\2\u01da`\3\2\2\2\u01db\u01dc\7\60\2\2"+
		"\u01dc\u01dd\7z\2\2\u01dd\u01de\7o\2\2\u01de\u01df\7n\2\2\u01dfb\3\2\2"+
		"\2\u01e0\u01e2\t\7\2\2\u01e1\u01e0\3\2\2\2\u01e2\u01e3\3\2\2\2\u01e3\u01e1"+
		"\3\2\2\2\u01e3\u01e4\3\2\2\2\u01e4\u01e5\3\2\2\2\u01e5\u01e6\b\62\2\2"+
		"\u01e6d\3\2\2\2\f\2\u0177\u019c\u01a1\u01a7\u01a9\u01b0\u01b5\u01d9\u01e3"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}