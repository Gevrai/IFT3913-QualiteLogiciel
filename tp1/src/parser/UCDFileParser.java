import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class UCDFileParser {
	public static ParseTree run(String content) throws Exception {

		ANTLRInputStream input = new ANTLRInputStream(content);
		uml_grammarLexer lexer = new uml_grammarLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		uml_grammarParser parser = new uml_grammarParser(tokens);
		ParseTree tree = parser.model(); // begin parsing at model rule
		System.out.println(tree.toStringTree(parser));
		return tree;
	}
}
