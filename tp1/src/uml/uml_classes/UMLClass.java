package uml.uml_classes;

import java.util.Map;

public class UMLClass {

	public String className;
	public Map<String, Attribute> attributes;
	public Map<String, Operation> operations;

	public UMLClass(String className, Map<String, Attribute> attributes, Map<String, Operation> operations) {
		this.className = className;
		this.attributes = attributes;
		this.operations = operations;
	}

	public String getClassName() {
		return className;
	}
                
}