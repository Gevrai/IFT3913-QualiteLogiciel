// Generated from parser/uml_grammar.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class uml_grammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, LPAREN=17, 
		RPAREN=18, COLON=19, SEMICOLON=20, COMMA=21, ID=22, WHITESPACE=23;
	public static final int
		RULE_model = 0, RULE_decls = 1, RULE_decl = 2, RULE_uml_class = 3, RULE_uml_class_content = 4, 
		RULE_attributes = 5, RULE_operations = 6, RULE_operation = 7, RULE_args = 8, 
		RULE_idTypePair = 9, RULE_type = 10, RULE_association = 11, RULE_two_roles = 12, 
		RULE_role = 13, RULE_roles = 14, RULE_multiplicity = 15, RULE_aggregation = 16, 
		RULE_generalization = 17, RULE_subclass_names = 18;
	public static final String[] ruleNames = {
		"model", "decls", "decl", "uml_class", "uml_class_content", "attributes", 
		"operations", "operation", "args", "idTypePair", "type", "association", 
		"two_roles", "role", "roles", "multiplicity", "aggregation", "generalization", 
		"subclass_names"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'MODEL'", "'CLASS'", "'ATTRIBUTES'", "'OPERATIONS'", "'RELATION'", 
		"'ROLES'", "'ONE'", "'MANY'", "'ONE_OR_MANY'", "'OPTIONALLY_ONE'", "'UNDEFINED'", 
		"'AGGREGATION'", "'CONTAINER'", "'PARTS'", "'GENERALIZATION'", "'SUBCLASSES'", 
		"'('", "')'", "':'", "';'", "','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, "LPAREN", "RPAREN", "COLON", "SEMICOLON", 
		"COMMA", "ID", "WHITESPACE"
	};
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
	public String getGrammarFileName() { return "uml_grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public uml_grammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ModelContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(uml_grammarParser.ID, 0); }
		public DeclsContext decls() {
			return getRuleContext(DeclsContext.class,0);
		}
		public ModelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_model; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uml_grammarListener ) ((uml_grammarListener)listener).enterModel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uml_grammarListener ) ((uml_grammarListener)listener).exitModel(this);
		}
	}

	public final ModelContext model() throws RecognitionException {
		ModelContext _localctx = new ModelContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_model);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			match(T__0);
			setState(39);
			match(ID);
			setState(40);
			decls();
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

	public static class DeclsContext extends ParserRuleContext {
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public DeclsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decls; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uml_grammarListener ) ((uml_grammarListener)listener).enterDecls(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uml_grammarListener ) ((uml_grammarListener)listener).exitDecls(this);
		}
	}

	public final DeclsContext decls() throws RecognitionException {
		DeclsContext _localctx = new DeclsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decls);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__4) | (1L << T__11) | (1L << T__14))) != 0)) {
				{
				{
				setState(42);
				decl();
				}
				}
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class DeclContext extends ParserRuleContext {
		public Uml_classContext uml_class() {
			return getRuleContext(Uml_classContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(uml_grammarParser.SEMICOLON, 0); }
		public AssociationContext association() {
			return getRuleContext(AssociationContext.class,0);
		}
		public GeneralizationContext generalization() {
			return getRuleContext(GeneralizationContext.class,0);
		}
		public AggregationContext aggregation() {
			return getRuleContext(AggregationContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uml_grammarListener ) ((uml_grammarListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uml_grammarListener ) ((uml_grammarListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_decl);
		try {
			setState(60);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(48);
				uml_class();
				setState(49);
				match(SEMICOLON);
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(51);
				association();
				setState(52);
				match(SEMICOLON);
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 3);
				{
				setState(54);
				generalization();
				setState(55);
				match(SEMICOLON);
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 4);
				{
				setState(57);
				aggregation();
				setState(58);
				match(SEMICOLON);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Uml_classContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(uml_grammarParser.ID, 0); }
		public Uml_class_contentContext uml_class_content() {
			return getRuleContext(Uml_class_contentContext.class,0);
		}
		public Uml_classContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_uml_class; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uml_grammarListener ) ((uml_grammarListener)listener).enterUml_class(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uml_grammarListener ) ((uml_grammarListener)listener).exitUml_class(this);
		}
	}

	public final Uml_classContext uml_class() throws RecognitionException {
		Uml_classContext _localctx = new Uml_classContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_uml_class);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(T__1);
			setState(63);
			match(ID);
			setState(64);
			uml_class_content();
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

	public static class Uml_class_contentContext extends ParserRuleContext {
		public AttributesContext attributes() {
			return getRuleContext(AttributesContext.class,0);
		}
		public OperationsContext operations() {
			return getRuleContext(OperationsContext.class,0);
		}
		public Uml_class_contentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_uml_class_content; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uml_grammarListener ) ((uml_grammarListener)listener).enterUml_class_content(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uml_grammarListener ) ((uml_grammarListener)listener).exitUml_class_content(this);
		}
	}

	public final Uml_class_contentContext uml_class_content() throws RecognitionException {
		Uml_class_contentContext _localctx = new Uml_class_contentContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_uml_class_content);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(T__2);
			setState(68);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(67);
				attributes();
				}
			}

			setState(70);
			match(T__3);
			setState(72);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(71);
				operations();
				}
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

	public static class AttributesContext extends ParserRuleContext {
		public List<IdTypePairContext> idTypePair() {
			return getRuleContexts(IdTypePairContext.class);
		}
		public IdTypePairContext idTypePair(int i) {
			return getRuleContext(IdTypePairContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(uml_grammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(uml_grammarParser.COMMA, i);
		}
		public AttributesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uml_grammarListener ) ((uml_grammarListener)listener).enterAttributes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uml_grammarListener ) ((uml_grammarListener)listener).exitAttributes(this);
		}
	}

	public final AttributesContext attributes() throws RecognitionException {
		AttributesContext _localctx = new AttributesContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_attributes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			idTypePair();
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(75);
				match(COMMA);
				setState(76);
				idTypePair();
				}
				}
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class OperationsContext extends ParserRuleContext {
		public List<OperationContext> operation() {
			return getRuleContexts(OperationContext.class);
		}
		public OperationContext operation(int i) {
			return getRuleContext(OperationContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(uml_grammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(uml_grammarParser.COMMA, i);
		}
		public OperationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uml_grammarListener ) ((uml_grammarListener)listener).enterOperations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uml_grammarListener ) ((uml_grammarListener)listener).exitOperations(this);
		}
	}

	public final OperationsContext operations() throws RecognitionException {
		OperationsContext _localctx = new OperationsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_operations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			operation();
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(83);
				match(COMMA);
				setState(84);
				operation();
				}
				}
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class OperationContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(uml_grammarParser.ID, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public TerminalNode COLON() { return getToken(uml_grammarParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public OperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uml_grammarListener ) ((uml_grammarListener)listener).enterOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uml_grammarListener ) ((uml_grammarListener)listener).exitOperation(this);
		}
	}

	public final OperationContext operation() throws RecognitionException {
		OperationContext _localctx = new OperationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_operation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(ID);
			setState(91);
			args();
			setState(92);
			match(COLON);
			setState(93);
			type();
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

	public static class ArgsContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(uml_grammarParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(uml_grammarParser.RPAREN, 0); }
		public List<IdTypePairContext> idTypePair() {
			return getRuleContexts(IdTypePairContext.class);
		}
		public IdTypePairContext idTypePair(int i) {
			return getRuleContext(IdTypePairContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(uml_grammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(uml_grammarParser.COMMA, i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uml_grammarListener ) ((uml_grammarListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uml_grammarListener ) ((uml_grammarListener)listener).exitArgs(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(LPAREN);
			setState(97);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(96);
				idTypePair();
				}
			}

			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(99);
				match(COMMA);
				setState(100);
				idTypePair();
				}
				}
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(106);
			match(RPAREN);
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

	public static class IdTypePairContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(uml_grammarParser.ID, 0); }
		public TerminalNode COLON() { return getToken(uml_grammarParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdTypePairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idTypePair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uml_grammarListener ) ((uml_grammarListener)listener).enterIdTypePair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uml_grammarListener ) ((uml_grammarListener)listener).exitIdTypePair(this);
		}
	}

	public final IdTypePairContext idTypePair() throws RecognitionException {
		IdTypePairContext _localctx = new IdTypePairContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_idTypePair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(ID);
			setState(109);
			match(COLON);
			setState(110);
			type();
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(uml_grammarParser.ID, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uml_grammarListener ) ((uml_grammarListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uml_grammarListener ) ((uml_grammarListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(ID);
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

	public static class AssociationContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(uml_grammarParser.ID, 0); }
		public Two_rolesContext two_roles() {
			return getRuleContext(Two_rolesContext.class,0);
		}
		public AssociationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_association; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uml_grammarListener ) ((uml_grammarListener)listener).enterAssociation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uml_grammarListener ) ((uml_grammarListener)listener).exitAssociation(this);
		}
	}

	public final AssociationContext association() throws RecognitionException {
		AssociationContext _localctx = new AssociationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_association);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(T__4);
			setState(115);
			match(ID);
			setState(116);
			match(T__5);
			setState(117);
			two_roles();
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

	public static class Two_rolesContext extends ParserRuleContext {
		public List<RoleContext> role() {
			return getRuleContexts(RoleContext.class);
		}
		public RoleContext role(int i) {
			return getRuleContext(RoleContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(uml_grammarParser.COMMA, 0); }
		public Two_rolesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_two_roles; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uml_grammarListener ) ((uml_grammarListener)listener).enterTwo_roles(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uml_grammarListener ) ((uml_grammarListener)listener).exitTwo_roles(this);
		}
	}

	public final Two_rolesContext two_roles() throws RecognitionException {
		Two_rolesContext _localctx = new Two_rolesContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_two_roles);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			role();
			setState(120);
			match(COMMA);
			setState(121);
			role();
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

	public static class RoleContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(uml_grammarParser.ID, 0); }
		public MultiplicityContext multiplicity() {
			return getRuleContext(MultiplicityContext.class,0);
		}
		public RoleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_role; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uml_grammarListener ) ((uml_grammarListener)listener).enterRole(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uml_grammarListener ) ((uml_grammarListener)listener).exitRole(this);
		}
	}

	public final RoleContext role() throws RecognitionException {
		RoleContext _localctx = new RoleContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_role);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(T__1);
			setState(124);
			match(ID);
			setState(125);
			multiplicity();
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

	public static class RolesContext extends ParserRuleContext {
		public List<RoleContext> role() {
			return getRuleContexts(RoleContext.class);
		}
		public RoleContext role(int i) {
			return getRuleContext(RoleContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(uml_grammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(uml_grammarParser.COMMA, i);
		}
		public RolesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_roles; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uml_grammarListener ) ((uml_grammarListener)listener).enterRoles(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uml_grammarListener ) ((uml_grammarListener)listener).exitRoles(this);
		}
	}

	public final RolesContext roles() throws RecognitionException {
		RolesContext _localctx = new RolesContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_roles);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			role();
			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(128);
				match(COMMA);
				setState(129);
				role();
				}
				}
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class MultiplicityContext extends ParserRuleContext {
		public MultiplicityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicity; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uml_grammarListener ) ((uml_grammarListener)listener).enterMultiplicity(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uml_grammarListener ) ((uml_grammarListener)listener).exitMultiplicity(this);
		}
	}

	public final MultiplicityContext multiplicity() throws RecognitionException {
		MultiplicityContext _localctx = new MultiplicityContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_multiplicity);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class AggregationContext extends ParserRuleContext {
		public RoleContext role() {
			return getRuleContext(RoleContext.class,0);
		}
		public RolesContext roles() {
			return getRuleContext(RolesContext.class,0);
		}
		public AggregationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggregation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uml_grammarListener ) ((uml_grammarListener)listener).enterAggregation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uml_grammarListener ) ((uml_grammarListener)listener).exitAggregation(this);
		}
	}

	public final AggregationContext aggregation() throws RecognitionException {
		AggregationContext _localctx = new AggregationContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_aggregation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(T__11);
			setState(138);
			match(T__12);
			setState(139);
			role();
			setState(140);
			match(T__13);
			setState(141);
			roles();
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

	public static class GeneralizationContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(uml_grammarParser.ID, 0); }
		public Subclass_namesContext subclass_names() {
			return getRuleContext(Subclass_namesContext.class,0);
		}
		public GeneralizationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_generalization; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uml_grammarListener ) ((uml_grammarListener)listener).enterGeneralization(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uml_grammarListener ) ((uml_grammarListener)listener).exitGeneralization(this);
		}
	}

	public final GeneralizationContext generalization() throws RecognitionException {
		GeneralizationContext _localctx = new GeneralizationContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_generalization);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(T__14);
			setState(144);
			match(ID);
			setState(145);
			match(T__15);
			setState(146);
			subclass_names();
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

	public static class Subclass_namesContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(uml_grammarParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(uml_grammarParser.ID, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(uml_grammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(uml_grammarParser.COMMA, i);
		}
		public Subclass_namesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subclass_names; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uml_grammarListener ) ((uml_grammarListener)listener).enterSubclass_names(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uml_grammarListener ) ((uml_grammarListener)listener).exitSubclass_names(this);
		}
	}

	public final Subclass_namesContext subclass_names() throws RecognitionException {
		Subclass_namesContext _localctx = new Subclass_namesContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_subclass_names);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(ID);
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(149);
				match(COMMA);
				setState(150);
				match(ID);
				}
				}
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\31\u009f\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\2\3\3\7\3.\n\3\f\3\16\3\61\13\3\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4?\n\4\3\5\3\5\3\5\3\5"+
		"\3\6\3\6\5\6G\n\6\3\6\3\6\5\6K\n\6\3\7\3\7\3\7\7\7P\n\7\f\7\16\7S\13\7"+
		"\3\b\3\b\3\b\7\bX\n\b\f\b\16\b[\13\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\5\nd"+
		"\n\n\3\n\3\n\7\nh\n\n\f\n\16\nk\13\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3"+
		"\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3"+
		"\20\3\20\7\20\u0085\n\20\f\20\16\20\u0088\13\20\3\21\3\21\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\7\24\u009a"+
		"\n\24\f\24\16\24\u009d\13\24\3\24\2\2\25\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&\2\3\3\2\t\r\u0097\2(\3\2\2\2\4/\3\2\2\2\6>\3\2\2\2\b@\3"+
		"\2\2\2\nD\3\2\2\2\fL\3\2\2\2\16T\3\2\2\2\20\\\3\2\2\2\22a\3\2\2\2\24n"+
		"\3\2\2\2\26r\3\2\2\2\30t\3\2\2\2\32y\3\2\2\2\34}\3\2\2\2\36\u0081\3\2"+
		"\2\2 \u0089\3\2\2\2\"\u008b\3\2\2\2$\u0091\3\2\2\2&\u0096\3\2\2\2()\7"+
		"\3\2\2)*\7\30\2\2*+\5\4\3\2+\3\3\2\2\2,.\5\6\4\2-,\3\2\2\2.\61\3\2\2\2"+
		"/-\3\2\2\2/\60\3\2\2\2\60\5\3\2\2\2\61/\3\2\2\2\62\63\5\b\5\2\63\64\7"+
		"\26\2\2\64?\3\2\2\2\65\66\5\30\r\2\66\67\7\26\2\2\67?\3\2\2\289\5$\23"+
		"\29:\7\26\2\2:?\3\2\2\2;<\5\"\22\2<=\7\26\2\2=?\3\2\2\2>\62\3\2\2\2>\65"+
		"\3\2\2\2>8\3\2\2\2>;\3\2\2\2?\7\3\2\2\2@A\7\4\2\2AB\7\30\2\2BC\5\n\6\2"+
		"C\t\3\2\2\2DF\7\5\2\2EG\5\f\7\2FE\3\2\2\2FG\3\2\2\2GH\3\2\2\2HJ\7\6\2"+
		"\2IK\5\16\b\2JI\3\2\2\2JK\3\2\2\2K\13\3\2\2\2LQ\5\24\13\2MN\7\27\2\2N"+
		"P\5\24\13\2OM\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2R\r\3\2\2\2SQ\3\2\2"+
		"\2TY\5\20\t\2UV\7\27\2\2VX\5\20\t\2WU\3\2\2\2X[\3\2\2\2YW\3\2\2\2YZ\3"+
		"\2\2\2Z\17\3\2\2\2[Y\3\2\2\2\\]\7\30\2\2]^\5\22\n\2^_\7\25\2\2_`\5\26"+
		"\f\2`\21\3\2\2\2ac\7\23\2\2bd\5\24\13\2cb\3\2\2\2cd\3\2\2\2di\3\2\2\2"+
		"ef\7\27\2\2fh\5\24\13\2ge\3\2\2\2hk\3\2\2\2ig\3\2\2\2ij\3\2\2\2jl\3\2"+
		"\2\2ki\3\2\2\2lm\7\24\2\2m\23\3\2\2\2no\7\30\2\2op\7\25\2\2pq\5\26\f\2"+
		"q\25\3\2\2\2rs\7\30\2\2s\27\3\2\2\2tu\7\7\2\2uv\7\30\2\2vw\7\b\2\2wx\5"+
		"\32\16\2x\31\3\2\2\2yz\5\34\17\2z{\7\27\2\2{|\5\34\17\2|\33\3\2\2\2}~"+
		"\7\4\2\2~\177\7\30\2\2\177\u0080\5 \21\2\u0080\35\3\2\2\2\u0081\u0086"+
		"\5\34\17\2\u0082\u0083\7\27\2\2\u0083\u0085\5\34\17\2\u0084\u0082\3\2"+
		"\2\2\u0085\u0088\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087"+
		"\37\3\2\2\2\u0088\u0086\3\2\2\2\u0089\u008a\t\2\2\2\u008a!\3\2\2\2\u008b"+
		"\u008c\7\16\2\2\u008c\u008d\7\17\2\2\u008d\u008e\5\34\17\2\u008e\u008f"+
		"\7\20\2\2\u008f\u0090\5\36\20\2\u0090#\3\2\2\2\u0091\u0092\7\21\2\2\u0092"+
		"\u0093\7\30\2\2\u0093\u0094\7\22\2\2\u0094\u0095\5&\24\2\u0095%\3\2\2"+
		"\2\u0096\u009b\7\30\2\2\u0097\u0098\7\27\2\2\u0098\u009a\7\30\2\2\u0099"+
		"\u0097\3\2\2\2\u009a\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2"+
		"\2\2\u009c\'\3\2\2\2\u009d\u009b\3\2\2\2\f/>FJQYci\u0086\u009b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}