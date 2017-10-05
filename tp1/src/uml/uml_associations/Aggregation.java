package uml.uml_associations;

import java.util.List;

public class Aggregation extends UMLAssociation {
	
	private Role container;
	public List<Role> parts;

	public Aggregation(Role baseElement, List<Role> components) {
		this.container = baseElement;
		this.parts = components;
	}
	
	public String toString() {
		String s = "AGGREGATION\nCONTAINER\n\t" + container.toString() + "\nPARTS\n";
		s += "\t" + this.parts.get(0);
		for (int i = 1; i<this.parts.size(); i++) 
			s += "\n\t" + this.parts.get(i);
		return s;
	}

	public Role getContainer() {
		return container;
	}

	public List<Role> getParts() {
		return parts;
	}
}