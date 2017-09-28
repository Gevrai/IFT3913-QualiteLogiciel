import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.File;
import java.util.Scanner;

public class UCDFileParser {
	public static void main(String[] args) throws Exception {

		if (args.length == 0) {
			System.out.println("Need a .ucd file to parse");
			return;
		}

		System.out.println("Parsing file" + args[0]);
		String fileContent = new Scanner(new File(args[0])).useDelimiter("\\Z").next();

		ANTLRInputStream input = new ANTLRInputStream(fileContent);
		uml_grammarLexer lexer = new uml_grammarLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		uml_grammarParser parser = new uml_grammarParser(tokens);
		ParseTree tree = parser.model(); // begin parsing at model rule
		System.out.println(tree.toStringTree(parser)); // print LISP-style tree
	}
}
