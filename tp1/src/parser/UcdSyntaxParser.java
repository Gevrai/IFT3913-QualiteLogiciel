package parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import uml.UMLModel;
import uml.types.ArrayType;
import uml.types.IType;
import uml.types.IntegerType;
import uml.types.NumberType;
import uml.types.StringType;
import uml.types.UserDefinedType;
import uml.types.VoidType;
import uml.uml_associations.Aggregation;
import uml.uml_associations.Generalization;
import uml.uml_associations.Relation;
import uml.uml_associations.Role;
import uml.uml_associations.UMLAssociation;
import uml.uml_classes.Argument;
import uml.uml_classes.Attribute;
import uml.uml_classes.Operation;
import uml.uml_classes.UMLClass;

public class UcdSyntaxParser {

	public static UMLModel parse(List<String> fileContent) throws UmlParsingError {
		// First entry must be of form "MODEL modelName"
		UMLModel model = parseModel(fileContent.remove(0).trim());
		
		// Parse every other entry
		for (String line : fileContent) {
			// FIXME Error handling in case of faulty entries
			if (line.trim().startsWith("CLASS")) {
				model.addClass(parseClass(line));
			} 
			else {
				model.addAssociation(parseAssociation(line.trim()));
			}
		}
		return model;
	}

	private static UMLModel parseModel(String line) throws UmlParsingError {
		Pattern p = Pattern.compile("MODEL ([_\\w]+)");
		Matcher m = p.matcher(line.trim());
		
		if (m.find()) {
			return new UMLModel(m.group(1));
		} else 
			throw new UmlParsingError("First line of file should be of form 'MODEL modelName': \n\t" + line);
	}

	private static UMLClass parseClass(String line) throws UmlParsingError  {
		Pattern p = Pattern.compile("CLASS (.*) ATTRIBUTES( .*)? OPERATIONS( .*)?");
		Matcher m = p.matcher(line);
		
		if (!m.find()) throw new UmlParsingError("CLASS is ill formed: \n\t" + line);
		
		String className = m.group(1);
		List<Attribute> attributes = parseAttributes(m.group(2));
		List<Operation> operations = parseOperations(m.group(3));
		
		return new UMLClass(className, attributes, operations);
	}

	// FIXME Assumes that the input has no errors
	private static List<Attribute> parseAttributes(String attributes) throws UmlParsingError {
		List<Attribute> attributesMap = new ArrayList<Attribute>();
		// Possible for a class to have no attributes
		if (attributes == null || attributes.trim().length() == 0)
			return attributesMap;

		// Matches "ID : type"
		Pattern p = Pattern.compile("([_\\w]+)\\s*:\\s*([_\\w]+)\\s*,?");
		Matcher m = p.matcher(attributes.trim());

		while (m.find()) {
			String attributeName = m.group(1);
			IType attributeType = parseType(m.group(2));
			attributesMap.add(new Attribute(attributeName, attributeType));
		}
		return attributesMap;
	}

	private static IType parseType(String type) throws UmlParsingError {
		type = type.trim();
		// Array type
		if (type.contains("[")) {
			Matcher m = Pattern.compile("([_\\w]+)[]").matcher(type);
			if (!m.find()) throw new UmlParsingError("Array type is ill formed");
			return new ArrayType(parseType(m.group(1)));
		}
		
		// Other Base types
		switch (type) {
			case "Integer" : return new IntegerType();
			case "Number" : return new NumberType();
			case "String" : return new StringType();
			case "Void" : return new VoidType();
		}
		
		//User-defined type, no verifications if it indeed exists is done
		return new UserDefinedType(type);
	}

	private static List<Operation> parseOperations(String operations) throws UmlParsingError {
		List<Operation> operationsMap = new ArrayList<Operation>();
		// Possible for a class to have no operations
		if (operations == null || operations.trim().length() == 0)
			return operationsMap;
		
		// Matches "opname(args) : type"
		Matcher m = Pattern.compile("([_\\w]+)[(](.*?)[)]\\s*:\\s*([_\\w]+)").matcher(operations.trim());
		while (m.find()) {
			String operationName = m.group(1);
			List<Argument> args = parseArgs(m.group(2));
			IType returnType = parseType(m.group(3));
			operationsMap.add(new Operation(operationName, args, returnType));
		}
		
		return operationsMap;

	}

	private static List<Argument> parseArgs(String args) throws UmlParsingError {
		List<Argument> argsMap = new ArrayList<Argument>();
		// Possible for a class to have no attributes
		if (args.trim().length() == 0)
			return argsMap;

		// Matches "ID : type"
		Pattern p = Pattern.compile("([_\\w]+)\\s*:\\s*([_\\w]+)\\s*,?");
		Matcher m = p.matcher(args.trim());

		while (m.find()) {
			String argName = m.group(1);
			IType argType = parseType(m.group(2));
			argsMap.add(new Argument(argName, argType));
		}
		return argsMap;
	}

	private static UMLAssociation parseAssociation(String line) throws UmlParsingError {
		UMLAssociation association;
		if (line.startsWith("AGGREGATION"))
			association = parseAggregation(line);
		else if (line.startsWith("GENERALIZATION"))
			association = parseGeneralization(line);
		else if (line.startsWith("RELATION"))
			association = parseRelation(line);
		else 
			throw new UmlParsingError("Association is ill formed : \n\t" + line);
		return association;
	}

	private static UMLAssociation parseGeneralization(String line) throws UmlParsingError {
		// Matches "GENERALIZATION id SUBCLASSES subclasses"
		Pattern p = Pattern.compile("GENERALIZATION ([_\\w]+) SUBCLASSES (.*)");
		Matcher m = p.matcher(line);

		if (!m.find())
			throw new UmlParsingError("Problem parsing generalization : \n\t" + line);
		
		String superClass = m.group(1);
		List<String> subclasses = parseSubclasses(m.group(2));
		
		return new Generalization(superClass, subclasses);

	}

	private static List<String> parseSubclasses(String subclasses) {
		return Arrays.asList(subclasses.split(" ?, ?"));
	}

	private static UMLAssociation parseAggregation(String line) throws UmlParsingError {
		// Matches "AGGREGATION CONTAINER role PARTS roles"
		Pattern p = Pattern.compile("AGGREGATION CONTAINER (.*?) PARTS (.*)");
		Matcher m = p.matcher(line);
		
		if (!m.find())
			throw new UmlParsingError("Problem parsing aggregation : \n\t" + line);

		Role baseElement = parseRole(m.group(1));
		List<Role> components = parseRoles(m.group(2));
		
		return new Aggregation(baseElement, components);
	}

	private static UMLAssociation parseRelation(String line) throws UmlParsingError {
		// Matches "RELATION id ROLES role1, role2"
		Pattern p = Pattern.compile("RELATION ([_\\w]+) ROLES ([^,]+) ?, ?([^,]+)");
		Matcher m = p.matcher(line);
		
		if (!m.find())
			throw new UmlParsingError("Problem parsing relation : \n\t" + line);

		return new Relation( m.group(1), parseRole(m.group(2)), parseRole(m.group(3)));
	}

	private static Role parseRole(String role) throws UmlParsingError {
		// Matches "CLASS id multiplicity"
		Pattern p = Pattern.compile("CLASS ([_\\w]+) ([_\\w]+)");
		Matcher m = p.matcher(role);
		
		if (!m.find())
			throw new UmlParsingError("Problem parsing role : \n\t" + role);
		
		return new Role(m.group(1), Role.getMultFromString(m.group(2)));
	}

	private static List<Role> parseRoles(String roles) throws UmlParsingError {
		List<Role> roleList = new ArrayList<Role>();
		// Matches "CLASS id multiplicity"
		Pattern p = Pattern.compile("([ _\\w]+)");
		Matcher m = p.matcher(roles);
		
		while (m.find()) {
			roleList.add(parseRole(m.group(1).trim()));
		}
		
		return roleList;
	}
}
