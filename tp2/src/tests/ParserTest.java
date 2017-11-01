package tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import parser.UcdSyntaxParser;
import parser.UmlParsingError;
import util.FileReader;

public class ParserTest {

	@Test
	public void EmptyFileTest() {
		try {
			List<String> content = FileReader.getFileContent("../../testFiles/Empty.ucd");
			UcdSyntaxParser.parse(content);
		} catch (IOException e) { fail("./testFiles/Empty.ucd inexistant -> Cannot test");
		} catch (UmlParsingError e) { /* Very good ! */ }
	}
	
	@Test
	public void BadFileTest() {
		try {
			List<String> content = FileReader.getFileContent("../../testFiles/BadFile.ucd");
			UcdSyntaxParser.parse(content);
		} catch (IOException e) { fail("./testFiles/BadFile.ucd inexistant -> Cannot test");
		} catch (UmlParsingError e) { /* Very good ! */ }

	}

	@Test
	public void ValidFileTest() {
		try {
			List<String> content = FileReader.getFileContent("../../testFiles/League.ucd");
			UcdSyntaxParser.parse(content);
		} catch (IOException e) { fail("./testFiles/League.ucd inexistant -> Cannot test");
		} catch (UmlParsingError e) { /* Very good ! */ }

	}

	@Test
	public void ValidFileNoAttributesTest() {
		try {
			List<String> content = FileReader.getFileContent("../../testFiles/LigueNoAttributes.ucd");
			UcdSyntaxParser.parse(content);
		} catch (IOException e) { fail("./testFiles/LigueNoAttributes.ucd inexistant -> Cannot test");
		} catch (UmlParsingError e) { /* Very good ! */ }
	}

	@Test
	public void ValidFileBlanksBetweenTokensTest() {
		try {
			List<String> content = FileReader.getFileContent("../../testFiles/LigueBlanks.ucd");
			UcdSyntaxParser.parse(content);
		} catch (IOException e) { fail("./testFiles/LigueBlanks.ucd inexistant -> Cannot test");
		} catch (UmlParsingError e) { /* Very good ! */ }
	}

}
