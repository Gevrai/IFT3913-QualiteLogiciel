import java.io.IOException;
import java.util.List;

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
				for (String s : fileContent) {
					System.out.println(s);
				}
			} catch (IOException e) {
				System.out.println(args[0] + " is not a valid ucd file.");
			}
		}
}
