import java.io.IOException;
import java.util.List;

import uml.UMLModel;
import parser.UcdSyntaxParser;
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
			} catch (IOException e) {
				System.out.println(args[0] + " is not a valid ucd file.");
			}
		}
}
