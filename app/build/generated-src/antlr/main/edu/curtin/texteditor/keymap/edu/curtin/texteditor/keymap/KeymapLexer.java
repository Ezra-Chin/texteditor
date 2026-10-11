// Generated from edu/curtin/texteditor/keymap/Keymap.g4 by ANTLR 4.13.2
package edu.curtin.texteditor.keymap;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class KeymapLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ALT=1, CTRL=2, SHIFT=3, INSERT=4, DELETE=5, AT=6, START=7, OF=8, LINE=9, 
		CARET=10, PLUS=11, EQUALS=12, LETTER=13, STRING=14, NEWLINE=15, WHITESPACE=16;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"ALT", "CTRL", "SHIFT", "INSERT", "DELETE", "AT", "START", "OF", "LINE", 
			"CARET", "PLUS", "EQUALS", "LETTER", "STRING", "NEWLINE", "WHITESPACE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'alt'", "'ctrl'", "'shift'", "'insert'", "'delete'", "'at'", "'start'", 
			"'of'", "'line'", "'caret'", "'+'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ALT", "CTRL", "SHIFT", "INSERT", "DELETE", "AT", "START", "OF", 
			"LINE", "CARET", "PLUS", "EQUALS", "LETTER", "STRING", "NEWLINE", "WHITESPACE"
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


	public KeymapLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Keymap.g4"; }

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
		"\u0004\u0000\u0010p\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0001\f\u0001\r\u0001\r\u0005\r^\b\r\n\r\f\ra\t\r\u0001\r\u0001\r\u0001"+
		"\u000e\u0003\u000ef\b\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0004"+
		"\u000fk\b\u000f\u000b\u000f\f\u000fl\u0001\u000f\u0001\u000f\u0000\u0000"+
		"\u0010\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006"+
		"\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e"+
		"\u001d\u000f\u001f\u0010\u0001\u0000\u0003\u0001\u0000az\u0003\u0000\n"+
		"\n\r\r\"\"\u0002\u0000\t\t  r\u0000\u0001\u0001\u0000\u0000\u0000\u0000"+
		"\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000"+
		"\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b"+
		"\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001"+
		"\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001"+
		"\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001"+
		"\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001"+
		"\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001"+
		"\u0000\u0000\u0000\u0001!\u0001\u0000\u0000\u0000\u0003%\u0001\u0000\u0000"+
		"\u0000\u0005*\u0001\u0000\u0000\u0000\u00070\u0001\u0000\u0000\u0000\t"+
		"7\u0001\u0000\u0000\u0000\u000b>\u0001\u0000\u0000\u0000\rA\u0001\u0000"+
		"\u0000\u0000\u000fG\u0001\u0000\u0000\u0000\u0011J\u0001\u0000\u0000\u0000"+
		"\u0013O\u0001\u0000\u0000\u0000\u0015U\u0001\u0000\u0000\u0000\u0017W"+
		"\u0001\u0000\u0000\u0000\u0019Y\u0001\u0000\u0000\u0000\u001b[\u0001\u0000"+
		"\u0000\u0000\u001de\u0001\u0000\u0000\u0000\u001fj\u0001\u0000\u0000\u0000"+
		"!\"\u0005a\u0000\u0000\"#\u0005l\u0000\u0000#$\u0005t\u0000\u0000$\u0002"+
		"\u0001\u0000\u0000\u0000%&\u0005c\u0000\u0000&\'\u0005t\u0000\u0000\'"+
		"(\u0005r\u0000\u0000()\u0005l\u0000\u0000)\u0004\u0001\u0000\u0000\u0000"+
		"*+\u0005s\u0000\u0000+,\u0005h\u0000\u0000,-\u0005i\u0000\u0000-.\u0005"+
		"f\u0000\u0000./\u0005t\u0000\u0000/\u0006\u0001\u0000\u0000\u000001\u0005"+
		"i\u0000\u000012\u0005n\u0000\u000023\u0005s\u0000\u000034\u0005e\u0000"+
		"\u000045\u0005r\u0000\u000056\u0005t\u0000\u00006\b\u0001\u0000\u0000"+
		"\u000078\u0005d\u0000\u000089\u0005e\u0000\u00009:\u0005l\u0000\u0000"+
		":;\u0005e\u0000\u0000;<\u0005t\u0000\u0000<=\u0005e\u0000\u0000=\n\u0001"+
		"\u0000\u0000\u0000>?\u0005a\u0000\u0000?@\u0005t\u0000\u0000@\f\u0001"+
		"\u0000\u0000\u0000AB\u0005s\u0000\u0000BC\u0005t\u0000\u0000CD\u0005a"+
		"\u0000\u0000DE\u0005r\u0000\u0000EF\u0005t\u0000\u0000F\u000e\u0001\u0000"+
		"\u0000\u0000GH\u0005o\u0000\u0000HI\u0005f\u0000\u0000I\u0010\u0001\u0000"+
		"\u0000\u0000JK\u0005l\u0000\u0000KL\u0005i\u0000\u0000LM\u0005n\u0000"+
		"\u0000MN\u0005e\u0000\u0000N\u0012\u0001\u0000\u0000\u0000OP\u0005c\u0000"+
		"\u0000PQ\u0005a\u0000\u0000QR\u0005r\u0000\u0000RS\u0005e\u0000\u0000"+
		"ST\u0005t\u0000\u0000T\u0014\u0001\u0000\u0000\u0000UV\u0005+\u0000\u0000"+
		"V\u0016\u0001\u0000\u0000\u0000WX\u0005=\u0000\u0000X\u0018\u0001\u0000"+
		"\u0000\u0000YZ\u0007\u0000\u0000\u0000Z\u001a\u0001\u0000\u0000\u0000"+
		"[_\u0005\"\u0000\u0000\\^\b\u0001\u0000\u0000]\\\u0001\u0000\u0000\u0000"+
		"^a\u0001\u0000\u0000\u0000_]\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000"+
		"\u0000`b\u0001\u0000\u0000\u0000a_\u0001\u0000\u0000\u0000bc\u0005\"\u0000"+
		"\u0000c\u001c\u0001\u0000\u0000\u0000df\u0005\r\u0000\u0000ed\u0001\u0000"+
		"\u0000\u0000ef\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000gh\u0005"+
		"\n\u0000\u0000h\u001e\u0001\u0000\u0000\u0000ik\u0007\u0002\u0000\u0000"+
		"ji\u0001\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000"+
		"\u0000lm\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000no\u0006\u000f"+
		"\u0000\u0000o \u0001\u0000\u0000\u0000\u0004\u0000_el\u0001\u0006\u0000"+
		"\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}