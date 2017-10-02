package parser;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import uml.*;
import uml.uml_associations.*;
import uml.uml_classes.*;

public class UcdSyntaxParser {
	

	public static UMLModel parse(List<String> fileContent) throws UmlParsingError {

		// First entry must be of form "MODEL modelName"
		UMLModel model = parseModelRule(fileContent.remove(0).trim());
		
		// Parse every other entry
		for (String line : fileContent) {
			// FIXME Error handling in case of faulty entries
			if (line.contains("CLASS")) {
				model.addClass(parseClassRule(line));
			} 
			else {
				model.addAssociation(parseAssociationRule(line));
			}
		}
		
		return model;
	}

	private static UMLModel parseModelRule(String line) throws UmlParsingError {
		Pattern p = Pattern.compile("MODEL (\\S+)");
		Matcher m = p.matcher(line.trim());
		
		if (m.find()) {
			return new UMLModel(m.group(1));
		} else 
			throw new UmlParsingError("First line of file should be of form 'MODEL modelName'");
	}

	private static UMLClass parseClassRule(String line) throws UmlParsingError  {
		Pattern p = Pattern.compile("CLASS (.*) ATTRIBUTES (.*) OPERATIONS (.*)");
		Matcher m = p.matcher(line);
		
		if (!m.find()) throw new UmlParsingError("CLASS is ill formed");
		
		String className = m.group(1);
		Map<String, Attribute> attributes = parseAttributes(m.group(2));
		Map<String, Operation> operations = parseOperations(m.group(3));
		
		return new UMLClass(className, attributes, operations);
	}

}
