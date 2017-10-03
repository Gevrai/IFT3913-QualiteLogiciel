import java.io.IOException;
import java.util.List;

import parser.UcdSyntaxParser;
import parser.UmlParsingError;
import uml.UMLModel;
import util.FileReader;

public class App {
	public static void main(String[] args) {

		if (args.length == 0) {
			System.out.println("Need a .ucd file to parse");
			return;
		}

		System.out.println("Parsing file" + args[0]);

		try {
			List<String> fileContent = FileReader.getFileContentFormatted(args[0]);
			UMLModel model = UcdSyntaxParser.parse(fileContent);
			System.out.println(model.toString());
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("\n" + args[0] + " is not a valid ucd file.");
		} catch (UmlParsingError e) {
			System.out.println(e.getMessage());
		}
	}
}
