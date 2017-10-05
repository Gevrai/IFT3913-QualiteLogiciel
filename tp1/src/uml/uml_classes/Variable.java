package uml.uml_classes;

import uml.types.IType;

public abstract class Variable {

	private String name;
    private IType  type;

	public Variable(String name, IType type) {
		this.name = name;
		this.type = type;
	}
	
	public String getName() { return this.name; }

	public IType getType() { return this.type; }

	@Override
	public String toString() {
		return this.name + " : " + this.type.getTypeString();
	}
	

}