import gui.UMLController;

public class App {
	public static void main(String[] args) {
		
		UMLController controller = new UMLController();

		if (args.length == 1) {
			System.out.println("Parsing file '" + args[0] + "'");
			controller.parseUcdFileToModel(args[0]);
		}
	}
}
