package uml.types;

public class UserDefinedType implements IType {
	
	String name;

	public UserDefinedType(String name) {
		this.name = name;
	}

	@Override
	public String getTypeString() {
		return name;
	}
}