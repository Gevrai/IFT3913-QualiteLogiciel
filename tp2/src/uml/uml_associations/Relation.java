package uml.uml_associations;

public class Relation extends UMLAssociation { 

	private String name;
	private Role source; 
	private Role destination;

	public Relation(String name, Role source, Role destination) {
		this.name = name;
		this.source = source;
		this.destination = destination;
	}
	
	public String toString() {
		return "RELATION " + name + "\n\tROLES\n\t" + source + ",\n\t" + destination + "\n";
	}

	public String getName() { return name; }

	public Role getSource() { return source; }

	public Role getDestination() { return destination; }
	
	

}