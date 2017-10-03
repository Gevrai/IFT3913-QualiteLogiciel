package uml.uml_classes;

import java.util.List;

public class UMLClass {

	public String className;
	public List<Attribute> attributes;
	public List<Operation> operations;

	public UMLClass(String className, List<Attribute> attributes, List<Operation> operations) {
		this.className = className;
		this.attributes = attributes;
		this.operations = operations;
	}

	public String getClassName() {
		return className;
	}
	
	public String toString() {
		String s = "CLASS " + className + "\n\tATTRIBUTES";
		
		if (!attributes.isEmpty()) {
			s += "\n\t\t" + attributes.get(0).toString();
			for (int i = 1; i < attributes.size(); i++) { 
				s += ",\n\t\t" + attributes.get(i).toString();
				}
		}

		s += "\n\tOPERATIONS";
		if (!operations.isEmpty()) {
			s += "\n\t\t" + operations.get(0).toString();
			for (int i = 1; i < operations.size(); i++) { 
				s += ",\n\t\t" + operations.get(i).toString();
				}
		}
		return s + "\n";
	}
}