package uml.uml_associations;

public class Relation extends UMLAssociation { 

	public String name;
	public Role source; 
	public Role destination;

	public Relation(String name, Role source, Role destination) {
		this.name = name;
		this.source = source;
		this.destination = destination;
	}
	
	public String toString() {
		return "RELATION " + name + "\n\tROLES\n\t" + source + ",\n\t" + destination + "\n";
	}

}