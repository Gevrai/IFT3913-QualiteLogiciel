package tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import parser.UcdSyntaxParser;
import parser.UmlParsingError;
import uml.UMLModel;
import util.FileReader;

public class ParserTest {
	
	// Very basic validation of entry model...
	public void validateModel(UMLModel m, String modelName, int nbClasses, int nbAssoc) {
		assertEquals(modelName, m.getModelName());
		assertEquals(nbClasses, m.getClasses().size());
		assertEquals(nbAssoc, m.getAssociations().size());
	}

	// Parse a file and validate some informations about it
	public void fileParse(String filePath, String modelName, int nbClasses, int nbAssoc) throws UmlParsingError {
		try {
			List<String> content = FileReader.getFileContent(filePath);
			UMLModel m = UcdSyntaxParser.parse(content);
			validateModel(m, modelName, nbClasses, nbAssoc);
		} catch (IOException e) { 
			fail(filePath + " does not exist -> Cannot test");
		}
		
	}

	@Test
	public void EmptyFileTest() {
		try { 
			fileParse("./tests/Empty.ucd", "", 0,0); 
		} catch (UmlParsingError e) { 
			e.printStackTrace();
			fail("Empty file should be a valid form");
		}
	}
	
	@Test
	public void BadFileTest() {
		try {
			fileParse("./tests/BadFile.ucd", "shouldnothappen", -1,-1);
		} catch (UmlParsingError e) { /*  This should happen ! ! */ }

	}

	@Test
	public void ValidFileTest() {
		try {
			fileParse("./tests/League.ucd", "Ligue", 5, 4);
		} catch (UmlParsingError e) { 
			e.printStackTrace();
			fail("Error parsing valid file League.ucd"); }
	}

	@Test
	public void ValidFileNoAttributesTest() {
		try {
			fileParse("./tests/LigueNoAttributes.ucd", "Ligue", 5, 4);
		} catch (UmlParsingError e) { 
			e.printStackTrace();
			fail("Error parsing valid file LigueNoAttributes.ucd"); }
	}

	@Test
	public void ValidFileBlanksBetweenTokensTest() {
		try {
			fileParse("./tests/LigueBlanks.ucd", "Ligue", 5, 4);
		} catch (UmlParsingError e) { 
			e.printStackTrace();
			fail("Error parsing valid file LigueBlanks.ucd"); }
	}

	@Test
	public void ValidFileLeagueMetriques() {
		try {
			fileParse("./tests/LeagueMetriques1.ucd", "Ligue", 5, 3);
		} catch (UmlParsingError e) { 
			e.printStackTrace();
			fail("Error parsing valid file LeagueMetriques.ucd"); }
	}
	
}
