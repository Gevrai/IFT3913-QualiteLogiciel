package uml.uml_associations;

import java.util.List;

import uml.uml_classes.UMLClass;

public class Generalization extends UMLAssociation {

	public String superClass;
	public List<String> subclasses;

	public Generalization(String superClass, List<String> subclasses) {
		this.superClass = superClass;
		this.subclasses = subclasses;
	}

	public String toString() {
		String s = "GENERALIZATION " + superClass + "\n\tSUBCLASSES ";
		s += subclasses.get(0);
		for (int i = 1; i < subclasses.size(); i++) {
			s += ", " + subclasses.get(i);
		}
		return s + "\n";
	}
}