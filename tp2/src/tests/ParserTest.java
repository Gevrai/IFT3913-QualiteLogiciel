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

	@Test
	public void EmptyFileTest() {
		try {
			List<String> content = FileReader.getFileContent("./testFiles/Empty.ucd");
			UcdSyntaxParser.parse(content);
		} catch (IOException e) { fail("./testFiles/Empty.ucd inexistant -> Cannot test");
		} catch (UmlParsingError e) { 
			e.printStackTrace();
			fail("Empty file should be a valid form");
		}
	}
	
	@Test
	public void BadFileTest() {
		try {
			List<String> content = FileReader.getFileContent("./testFiles/BadFile.ucd");
			UcdSyntaxParser.parse(content);
		} catch (IOException e) { fail("./testFiles/BadFile.ucd inexistant -> Cannot test");
		} catch (UmlParsingError e) { /* Very good ! */ }

	}

	@Test
	public void ValidFileTest() {
		try {
			List<String> content = FileReader.getFileContent("./testFiles/League.ucd");
			UMLModel m = UcdSyntaxParser.parse(content);
			validateModel(m);
		} catch (IOException e) { fail("./testFiles/League.ucd inexistant -> Cannot test");
		} catch (UmlParsingError e) { 
			e.printStackTrace();
			fail("Error parsing valid file League.ucd"); }

	}

	@Test
	public void ValidFileNoAttributesTest() {
		try {
			List<String> content = FileReader.getFileContent("./testFiles/LigueNoAttributes.ucd");
			UMLModel m = UcdSyntaxParser.parse(content);
			validateModel(m);
		} catch (IOException e) { fail("./testFiles/LigueNoAttributes.ucd inexistant -> Cannot test");
		} catch (UmlParsingError e) { 
			e.printStackTrace();
			fail("Error parsing valid file LigueNoAttributes.ucd"); }
	}

	@Test
	public void ValidFileBlanksBetweenTokensTest() {
		try {
			List<String> content = FileReader.getFileContent("./testFiles/LigueBlanks.ucd");
			UMLModel m = UcdSyntaxParser.parse(content);
			validateModel(m);
		} catch (IOException e) { fail("./testFiles/LigueBlanks.ucd inexistant -> Cannot test");
		} catch (UmlParsingError e) { 
			e.printStackTrace();
			fail("Error parsing valid file LigueBlanks.ucd"); }
	}
	
	// Very poor validation of entry model, IMPORTANT NOT TO CHANGE INPUT FILES !!!
	public void validateModel(UMLModel m) {
		assertEquals(m.getModelName(), "Ligue");
		assertEquals(m.getClasses().size(), 5);
		assertEquals(m.getAssociations().size(), 4);
	}

}
