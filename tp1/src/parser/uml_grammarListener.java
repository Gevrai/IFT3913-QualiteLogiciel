// Generated from parser/uml_grammar.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link uml_grammarParser}.
 */
public interface uml_grammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link uml_grammarParser#model}.
	 * @param ctx the parse tree
	 */
	void enterModel(uml_grammarParser.ModelContext ctx);
	/**
	 * Exit a parse tree produced by {@link uml_grammarParser#model}.
	 * @param ctx the parse tree
	 */
	void exitModel(uml_grammarParser.ModelContext ctx);
	/**
	 * Enter a parse tree produced by {@link uml_grammarParser#decls}.
	 * @param ctx the parse tree
	 */
	void enterDecls(uml_grammarParser.DeclsContext ctx);
	/**
	 * Exit a parse tree produced by {@link uml_grammarParser#decls}.
	 * @param ctx the parse tree
	 */
	void exitDecls(uml_grammarParser.DeclsContext ctx);
	/**
	 * Enter a parse tree produced by {@link uml_grammarParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(uml_grammarParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link uml_grammarParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(uml_grammarParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link uml_grammarParser#uml_class}.
	 * @param ctx the parse tree
	 */
	void enterUml_class(uml_grammarParser.Uml_classContext ctx);
	/**
	 * Exit a parse tree produced by {@link uml_grammarParser#uml_class}.
	 * @param ctx the parse tree
	 */
	void exitUml_class(uml_grammarParser.Uml_classContext ctx);
	/**
	 * Enter a parse tree produced by {@link uml_grammarParser#uml_class_content}.
	 * @param ctx the parse tree
	 */
	void enterUml_class_content(uml_grammarParser.Uml_class_contentContext ctx);
	/**
	 * Exit a parse tree produced by {@link uml_grammarParser#uml_class_content}.
	 * @param ctx the parse tree
	 */
	void exitUml_class_content(uml_grammarParser.Uml_class_contentContext ctx);
	/**
	 * Enter a parse tree produced by {@link uml_grammarParser#attributes}.
	 * @param ctx the parse tree
	 */
	void enterAttributes(uml_grammarParser.AttributesContext ctx);
	/**
	 * Exit a parse tree produced by {@link uml_grammarParser#attributes}.
	 * @param ctx the parse tree
	 */
	void exitAttributes(uml_grammarParser.AttributesContext ctx);
	/**
	 * Enter a parse tree produced by {@link uml_grammarParser#operations}.
	 * @param ctx the parse tree
	 */
	void enterOperations(uml_grammarParser.OperationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link uml_grammarParser#operations}.
	 * @param ctx the parse tree
	 */
	void exitOperations(uml_grammarParser.OperationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link uml_grammarParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterOperation(uml_grammarParser.OperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link uml_grammarParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitOperation(uml_grammarParser.OperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link uml_grammarParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(uml_grammarParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link uml_grammarParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(uml_grammarParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link uml_grammarParser#idTypePair}.
	 * @param ctx the parse tree
	 */
	void enterIdTypePair(uml_grammarParser.IdTypePairContext ctx);
	/**
	 * Exit a parse tree produced by {@link uml_grammarParser#idTypePair}.
	 * @param ctx the parse tree
	 */
	void exitIdTypePair(uml_grammarParser.IdTypePairContext ctx);
	/**
	 * Enter a parse tree produced by {@link uml_grammarParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(uml_grammarParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link uml_grammarParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(uml_grammarParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link uml_grammarParser#association}.
	 * @param ctx the parse tree
	 */
	void enterAssociation(uml_grammarParser.AssociationContext ctx);
	/**
	 * Exit a parse tree produced by {@link uml_grammarParser#association}.
	 * @param ctx the parse tree
	 */
	void exitAssociation(uml_grammarParser.AssociationContext ctx);
	/**
	 * Enter a parse tree produced by {@link uml_grammarParser#two_roles}.
	 * @param ctx the parse tree
	 */
	void enterTwo_roles(uml_grammarParser.Two_rolesContext ctx);
	/**
	 * Exit a parse tree produced by {@link uml_grammarParser#two_roles}.
	 * @param ctx the parse tree
	 */
	void exitTwo_roles(uml_grammarParser.Two_rolesContext ctx);
	/**
	 * Enter a parse tree produced by {@link uml_grammarParser#role}.
	 * @param ctx the parse tree
	 */
	void enterRole(uml_grammarParser.RoleContext ctx);
	/**
	 * Exit a parse tree produced by {@link uml_grammarParser#role}.
	 * @param ctx the parse tree
	 */
	void exitRole(uml_grammarParser.RoleContext ctx);
	/**
	 * Enter a parse tree produced by {@link uml_grammarParser#roles}.
	 * @param ctx the parse tree
	 */
	void enterRoles(uml_grammarParser.RolesContext ctx);
	/**
	 * Exit a parse tree produced by {@link uml_grammarParser#roles}.
	 * @param ctx the parse tree
	 */
	void exitRoles(uml_grammarParser.RolesContext ctx);
	/**
	 * Enter a parse tree produced by {@link uml_grammarParser#multiplicity}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicity(uml_grammarParser.MultiplicityContext ctx);
	/**
	 * Exit a parse tree produced by {@link uml_grammarParser#multiplicity}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicity(uml_grammarParser.MultiplicityContext ctx);
	/**
	 * Enter a parse tree produced by {@link uml_grammarParser#aggregation}.
	 * @param ctx the parse tree
	 */
	void enterAggregation(uml_grammarParser.AggregationContext ctx);
	/**
	 * Exit a parse tree produced by {@link uml_grammarParser#aggregation}.
	 * @param ctx the parse tree
	 */
	void exitAggregation(uml_grammarParser.AggregationContext ctx);
	/**
	 * Enter a parse tree produced by {@link uml_grammarParser#generalization}.
	 * @param ctx the parse tree
	 */
	void enterGeneralization(uml_grammarParser.GeneralizationContext ctx);
	/**
	 * Exit a parse tree produced by {@link uml_grammarParser#generalization}.
	 * @param ctx the parse tree
	 */
	void exitGeneralization(uml_grammarParser.GeneralizationContext ctx);
	/**
	 * Enter a parse tree produced by {@link uml_grammarParser#subclass_names}.
	 * @param ctx the parse tree
	 */
	void enterSubclass_names(uml_grammarParser.Subclass_namesContext ctx);
	/**
	 * Exit a parse tree produced by {@link uml_grammarParser#subclass_names}.
	 * @param ctx the parse tree
	 */
	void exitSubclass_names(uml_grammarParser.Subclass_namesContext ctx);
}