package uml.uml_classes;

import java.util.List;

import uml.types.IType;

public class Operation {

	public String name;
    public List<Argument>  args;
	public IType  returnType;

	public Operation(String name, List<Argument> args, IType returnType) {
		this.name = name;
		this.args = args;
		this.returnType = returnType;
	}

	public String getName() { return name; }
	public List<Argument> getArgs() { return args; }
	public IType getReturnType() { return returnType; }
	
	public String toString() {
		String s = name +"(";
		for (Argument a : this.args) {
			s += a.toString() + ", ";
		}
		if (!args.isEmpty())
			s = s.substring(0, s.length()-2);
		return s + ") : " + returnType.getTypeString();
	}

}