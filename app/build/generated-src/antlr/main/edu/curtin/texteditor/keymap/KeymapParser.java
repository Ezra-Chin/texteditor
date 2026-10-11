// Generated from Keymap.g4 by ANTLR 4.13.2
package edu.curtin.texteditor.keymap;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class KeymapParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ALT=1, CTRL=2, SHIFT=3, INSERT=4, DELETE=5, AT=6, START=7, OF=8, LINE=9, 
		CARET=10, PLUS=11, EQUALS=12, LETTER=13, STRING=14, NEWLINE=15, WHITESPACE=16;
	public static final int
		RULE_keymap = 0, RULE_binding = 1, RULE_threekeys = 2, RULE_modifier = 3, 
		RULE_action = 4, RULE_position = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"keymap", "binding", "threekeys", "modifier", "action", "position"
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

	@Override
	public String getGrammarFileName() { return "Keymap.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public KeymapParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class KeymapContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(KeymapParser.EOF, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(KeymapParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(KeymapParser.NEWLINE, i);
		}
		public List<BindingContext> binding() {
			return getRuleContexts(BindingContext.class);
		}
		public BindingContext binding(int i) {
			return getRuleContext(BindingContext.class,i);
		}
		public KeymapContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keymap; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KeymapListener ) ((KeymapListener)listener).enterKeymap(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KeymapListener ) ((KeymapListener)listener).exitKeymap(this);
		}
	}

	public final KeymapContext keymap() throws RecognitionException {
		KeymapContext _localctx = new KeymapContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_keymap);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(13);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 14L) != 0)) {
						{
						setState(12);
						binding();
						}
					}

					setState(15);
					match(NEWLINE);
					}
					} 
				}
				setState(20);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(22);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 14L) != 0)) {
				{
				setState(21);
				binding();
				}
			}

			setState(24);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BindingContext extends ParserRuleContext {
		public ThreekeysContext threekeys() {
			return getRuleContext(ThreekeysContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(KeymapParser.EQUALS, 0); }
		public ActionContext action() {
			return getRuleContext(ActionContext.class,0);
		}
		public TerminalNode STRING() { return getToken(KeymapParser.STRING, 0); }
		public PositionContext position() {
			return getRuleContext(PositionContext.class,0);
		}
		public BindingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binding; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KeymapListener ) ((KeymapListener)listener).enterBinding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KeymapListener ) ((KeymapListener)listener).exitBinding(this);
		}
	}

	public final BindingContext binding() throws RecognitionException {
		BindingContext _localctx = new BindingContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_binding);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			threekeys();
			setState(27);
			match(EQUALS);
			setState(28);
			action();
			setState(29);
			match(STRING);
			setState(30);
			position();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ThreekeysContext extends ParserRuleContext {
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(KeymapParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(KeymapParser.PLUS, i);
		}
		public TerminalNode LETTER() { return getToken(KeymapParser.LETTER, 0); }
		public ThreekeysContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_threekeys; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KeymapListener ) ((KeymapListener)listener).enterThreekeys(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KeymapListener ) ((KeymapListener)listener).exitThreekeys(this);
		}
	}

	public final ThreekeysContext threekeys() throws RecognitionException {
		ThreekeysContext _localctx = new ThreekeysContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_threekeys);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			modifier();
			setState(37);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(33);
					match(PLUS);
					setState(34);
					modifier();
					}
					} 
				}
				setState(39);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(40);
			match(PLUS);
			setState(41);
			match(LETTER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ModifierContext extends ParserRuleContext {
		public TerminalNode ALT() { return getToken(KeymapParser.ALT, 0); }
		public TerminalNode CTRL() { return getToken(KeymapParser.CTRL, 0); }
		public TerminalNode SHIFT() { return getToken(KeymapParser.SHIFT, 0); }
		public ModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KeymapListener ) ((KeymapListener)listener).enterModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KeymapListener ) ((KeymapListener)listener).exitModifier(this);
		}
	}

	public final ModifierContext modifier() throws RecognitionException {
		ModifierContext _localctx = new ModifierContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_modifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 14L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ActionContext extends ParserRuleContext {
		public TerminalNode INSERT() { return getToken(KeymapParser.INSERT, 0); }
		public TerminalNode DELETE() { return getToken(KeymapParser.DELETE, 0); }
		public ActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_action; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KeymapListener ) ((KeymapListener)listener).enterAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KeymapListener ) ((KeymapListener)listener).exitAction(this);
		}
	}

	public final ActionContext action() throws RecognitionException {
		ActionContext _localctx = new ActionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_action);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			_la = _input.LA(1);
			if ( !(_la==INSERT || _la==DELETE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PositionContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(KeymapParser.AT, 0); }
		public TerminalNode START() { return getToken(KeymapParser.START, 0); }
		public TerminalNode OF() { return getToken(KeymapParser.OF, 0); }
		public TerminalNode LINE() { return getToken(KeymapParser.LINE, 0); }
		public TerminalNode CARET() { return getToken(KeymapParser.CARET, 0); }
		public PositionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_position; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KeymapListener ) ((KeymapListener)listener).enterPosition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KeymapListener ) ((KeymapListener)listener).exitPosition(this);
		}
	}

	public final PositionContext position() throws RecognitionException {
		PositionContext _localctx = new PositionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_position);
		try {
			setState(53);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(47);
				match(AT);
				setState(48);
				match(START);
				setState(49);
				match(OF);
				setState(50);
				match(LINE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(51);
				match(AT);
				setState(52);
				match(CARET);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u00108\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0001\u0000\u0003\u0000\u000e\b\u0000\u0001\u0000\u0005"+
		"\u0000\u0011\b\u0000\n\u0000\f\u0000\u0014\t\u0000\u0001\u0000\u0003\u0000"+
		"\u0017\b\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0005\u0002$\b\u0002\n\u0002\f\u0002\'\t\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005"+
		"6\b\u0005\u0001\u0005\u0000\u0000\u0006\u0000\u0002\u0004\u0006\b\n\u0000"+
		"\u0002\u0001\u0000\u0001\u0003\u0001\u0000\u0004\u00056\u0000\u0012\u0001"+
		"\u0000\u0000\u0000\u0002\u001a\u0001\u0000\u0000\u0000\u0004 \u0001\u0000"+
		"\u0000\u0000\u0006+\u0001\u0000\u0000\u0000\b-\u0001\u0000\u0000\u0000"+
		"\n5\u0001\u0000\u0000\u0000\f\u000e\u0003\u0002\u0001\u0000\r\f\u0001"+
		"\u0000\u0000\u0000\r\u000e\u0001\u0000\u0000\u0000\u000e\u000f\u0001\u0000"+
		"\u0000\u0000\u000f\u0011\u0005\u000f\u0000\u0000\u0010\r\u0001\u0000\u0000"+
		"\u0000\u0011\u0014\u0001\u0000\u0000\u0000\u0012\u0010\u0001\u0000\u0000"+
		"\u0000\u0012\u0013\u0001\u0000\u0000\u0000\u0013\u0016\u0001\u0000\u0000"+
		"\u0000\u0014\u0012\u0001\u0000\u0000\u0000\u0015\u0017\u0003\u0002\u0001"+
		"\u0000\u0016\u0015\u0001\u0000\u0000\u0000\u0016\u0017\u0001\u0000\u0000"+
		"\u0000\u0017\u0018\u0001\u0000\u0000\u0000\u0018\u0019\u0005\u0000\u0000"+
		"\u0001\u0019\u0001\u0001\u0000\u0000\u0000\u001a\u001b\u0003\u0004\u0002"+
		"\u0000\u001b\u001c\u0005\f\u0000\u0000\u001c\u001d\u0003\b\u0004\u0000"+
		"\u001d\u001e\u0005\u000e\u0000\u0000\u001e\u001f\u0003\n\u0005\u0000\u001f"+
		"\u0003\u0001\u0000\u0000\u0000 %\u0003\u0006\u0003\u0000!\"\u0005\u000b"+
		"\u0000\u0000\"$\u0003\u0006\u0003\u0000#!\u0001\u0000\u0000\u0000$\'\u0001"+
		"\u0000\u0000\u0000%#\u0001\u0000\u0000\u0000%&\u0001\u0000\u0000\u0000"+
		"&(\u0001\u0000\u0000\u0000\'%\u0001\u0000\u0000\u0000()\u0005\u000b\u0000"+
		"\u0000)*\u0005\r\u0000\u0000*\u0005\u0001\u0000\u0000\u0000+,\u0007\u0000"+
		"\u0000\u0000,\u0007\u0001\u0000\u0000\u0000-.\u0007\u0001\u0000\u0000"+
		".\t\u0001\u0000\u0000\u0000/0\u0005\u0006\u0000\u000001\u0005\u0007\u0000"+
		"\u000012\u0005\b\u0000\u000026\u0005\t\u0000\u000034\u0005\u0006\u0000"+
		"\u000046\u0005\n\u0000\u00005/\u0001\u0000\u0000\u000053\u0001\u0000\u0000"+
		"\u00006\u000b\u0001\u0000\u0000\u0000\u0005\r\u0012\u0016%5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}