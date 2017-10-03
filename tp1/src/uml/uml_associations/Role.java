package uml.uml_associations;

public class Role {
	
	public enum Multiplicity {
		ONE, MANY, ONE_OR_MANY, OPTIONALLY_ONE, UNDEFINED
	}

	public static Multiplicity getMultFromString(String s) {
		switch (s) {
		case "ONE" : return Multiplicity.ONE;
		case "MANY" : return Multiplicity.MANY;
		case "ONE_OR_MANY" : return Multiplicity.ONE_OR_MANY;
		case "OPTIONALLY_ONE" : return Multiplicity.OPTIONALLY_ONE;
		default : return Multiplicity.UNDEFINED;
		}
	}

	private String affectedClass;
	private Multiplicity multiplicity;
	
	public Role(String affectedClass, Multiplicity multiplicity) {
		this.affectedClass = affectedClass;
		this.multiplicity = multiplicity;
	}
	
	public String getAffectedClass() { return this.affectedClass; }
	
	public Multiplicity getMultiplicity() { return this.multiplicity; }
	
	public String toString() {
		return "CLASS " + affectedClass + " " + multiplicity.toString();
	}
	
}
