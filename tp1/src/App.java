import java.io.File;
import java.util.Scanner;
import org.antlr.v4.runtime.tree.*;

public class App {
		public static void main(String[] args) throws Exception {

			if (args.length == 0) {
				System.out.println("Need a .ucd file to parse");
				return;
			}

			System.out.println("Parsing file" + args[0]);
			String fileContent = new Scanner(new File(args[0])).useDelimiter("\\Z").next();

			ParseTree tree = new UCDFileParser().run(fileContent);
		}
}
