package uml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uml.uml_associations.*;
import uml.uml_classes.*;

public class UMLModel {

	public String modelName;
	public Map<String, UMLClass> classes;
	public List<UMLAssociation> associations;
	
	public UMLModel(String modelName) {
		this.modelName = modelName;
		this.classes = new HashMap<String, UMLClass>();
		this.associations = new ArrayList<UMLAssociation>();
	}

	public boolean addAssociation(UMLAssociation umlAssociation) {
		return associations.add(umlAssociation);
	}
	
	public boolean addClass(UMLClass umlClass) {
		return classes.put(umlClass.getClassName(), umlClass) == null;
	}
}