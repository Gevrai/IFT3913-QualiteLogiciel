package uml;

import java.util.ArrayList;
import java.util.List;

import uml.uml_associations.Aggregation;
import uml.uml_associations.Generalization;
import uml.uml_associations.Relation;
import uml.uml_associations.Role;
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

	// Returns all subclasses of a class
	public List<UMLClass> getSubclasses(UMLClass superclass) {
		List<String> subclassesStr = new ArrayList<String>();
		for (UMLAssociation a : this.associations) {
			if (a instanceof Generalization 
				&& ((Generalization)a).getSuperclassName().equals(superclass.getClassName())) {
					subclassesStr.addAll(((Generalization)a).getSubclassesNames());
			}
		}
		List<UMLClass> subclasses = new ArrayList<UMLClass>();
		subclassesStr.forEach(className -> subclasses.add(getClassFromName(className)));
		return subclasses;
	}

	// Returns all classes associated with a class, excluding generalization
	public List<UMLAssociation> getAssociatedClasses(UMLClass c) {
		List<UMLAssociation> associations = new ArrayList<UMLAssociation>();
		for (UMLAssociation a : this.associations) {
			if (a instanceof Relation) {
				Relation r = (Relation)a;
				if (r.getSource().getAffectedClass().equals(c.getClassName())
					|| r.getDestination().getAffectedClass().equals(c.getClassName())) {
						associations.add(a);
				}
			}
			if (a instanceof Aggregation) {
				Aggregation agr = (Aggregation)a;
				if(agr.getContainer().getAffectedClass().equals(c.getClassName()))
					associations.add(a);
				for(Role role : agr.getParts()) {
					if (role.getAffectedClass().equals(c.getClassName()))
						associations.add(a);
				}
			}
		}
		return associations;
	}
}