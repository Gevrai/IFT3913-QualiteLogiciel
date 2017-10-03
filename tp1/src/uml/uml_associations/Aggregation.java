package uml.uml_associations;

import java.util.List;

public class Aggregation extends UMLAssociation {
	
	public Role baseElement;
	public List<Role> components;

	public Aggregation(Role baseElement, List<Role> components) {
		this.baseElement = baseElement;
		this.components = components;
	}
	
	public String toString() {
		String s = "AGGREGATION\nCONTAINER\n\t" + baseElement.toString() + "\nPARTS\n";
		
		s += "\t" + components.get(0);
		for (int i = 1; i<components.size(); i++) 
			s += "\n\t" + components.get(i);
		return s;
	}

}