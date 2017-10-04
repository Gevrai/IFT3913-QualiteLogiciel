package uml;

import java.util.ArrayList;
import java.util.List;

import uml.uml_associations.Generalization;
import uml.uml_associations.UMLAssociation;
import uml.uml_classes.UMLClass;

public class UMLModel {

	private String modelName;
	private List<UMLClass> classes;
	private List<UMLAssociation> associations;
	
	public UMLModel(String modelName) {
		this.modelName = modelName;
		this.classes = new ArrayList<UMLClass>();
		this.associations = new ArrayList<UMLAssociation>();
	}

	public boolean addAssociation(UMLAssociation umlAssociation) {
		return associations.add(umlAssociation);
	}
	
	public boolean addClass(UMLClass umlClass) {
		return classes.add(umlClass);
	}
	
	public String toString() {
		String s = "MODEL " + modelName + "\n";
		for(UMLClass c : classes) 
			s += c.toString() + ";\n\n";
		for (UMLAssociation a : associations) 
			s += a.toString() + ";\n\n";
		return s;
	}

	public String getModelName() { return modelName; }

	public List<UMLClass> getClasses() { return classes; }

	public List<UMLAssociation> getAssociations() { return associations; }
	
	public UMLClass getClassFromName(String className) {
		for (UMLClass c : classes)
			if (c.getClassName().equals(className))
				return c;
		return null;
	}
	
	// TODO ark
	public List<UMLClass> getSubclasses(String superclass) {
		UMLClass c = getClassFromName(superclass);
		if (c == null) return new ArrayList<UMLClass>();
		return getSubclasses(getClassFromName(superclass));
	}

	// TODO ark
	public List<UMLClass> getSubclasses(UMLClass superclass) {
		List<String> subclassesStr = new ArrayList<String>();
		for (UMLAssociation c : this.associations) {
			if (c instanceof Generalization 
					&& ((Generalization)c).getSuperclass() == superclass.getClassName())
				subclassesStr.addAll(((Generalization)c).getSubclasses());
		}
		
		List<UMLClass> subclasses = new ArrayList<UMLClass>();
		subclassesStr.forEach(className -> subclasses.add(getClassFromName(className)));
		return subclasses;
	}
}