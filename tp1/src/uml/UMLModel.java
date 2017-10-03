package uml;

import java.util.ArrayList;
import java.util.List;

import uml.uml_associations.UMLAssociation;
import uml.uml_classes.UMLClass;

public class UMLModel {

	public String modelName;
	public List<UMLClass> classes;
	public List<UMLAssociation> associations;
	
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
}