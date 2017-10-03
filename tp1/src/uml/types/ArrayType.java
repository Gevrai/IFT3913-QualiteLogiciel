package uml.types;


public class ArrayType implements IType {

	public IType elementsType;

    public ArrayType(IType type) {
    	this.elementsType = type;
	}
    
    public IType getElementsType() { return elementsType; }

	@Override
	public String getTypeString() {
		return elementsType.getTypeString() + "[]";
	}

}