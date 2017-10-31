package uml.uml_associations;

import java.util.List;

import uml.uml_classes.UMLClass;

public class Generalization extends UMLAssociation {

	public String superClassName;
	public List<String> subclassesNames;

	public Generalization(String superClass, List<String> subclasses) {
		this.superClassName = superClass;
		this.subclassesNames = subclasses;
	}

	public String toString() {
		String s = "GENERALIZATION " + superClassName + "\n\tSUBCLASSES ";
		s += subclassesNames.get(0);
		for (int i = 1; i < subclassesNames.size(); i++) {
			s += ", " + subclassesNames.get(i);
		}
		return s + "\n";
	}

	public String getSuperclassName() {
		return superClassName;
	}

	public List<String> getSubclassesNames() {
		return subclassesNames;
	}
}