package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import metrics.MetricFactory;
import parser.UcdSyntaxParser;
import parser.UmlParsingError;
import uml.UMLModel;
import uml.uml_classes.UMLClass;
import util.FileReader;

public class MetricsTest1 {
	
	UMLModel leagueModel;
	UMLClass equipeClass;
	
	@Before
	public void setUp() throws Exception {
		List<String> content;
		try {
			// Setting up model for League.ucd (given by demonstrator)
			content = FileReader.getFileContent("./tests/League.ucd");
			leagueModel = UcdSyntaxParser.parse(content);
			equipeClass = leagueModel.getClassFromName("Equipe");
		} catch (IOException e) { fail("./tests/League.ucd inexistant -> Cannot test");
		} catch (UmlParsingError e) { 
			e.printStackTrace();
			fail("Error parsing valid file League.ucd"); }
	}

	// Helper function for tests
	public void assertMetric(String acronym, String expectedResult, UMLModel m, UMLClass c) {
		String result = MetricFactory.getMetric(acronym).computeToFormattedString(m, c);
		assertEquals("Failed for model " + m.getModelName() + " on class " + c.getClassName(),
				result , expectedResult);
	}

	@Test
	public void MetricsANA_Test() { 
		assertMetric("ANA", "0.33", leagueModel, equipeClass); 
	}

	@Test
	public void MetricsNOM_Test() {
		assertMetric("NOM", "3", leagueModel, equipeClass); 
	}

	@Test
	public void MetricsNOA_Test() {
		assertMetric("NOA", "1", leagueModel, equipeClass); 
	}

	@Test
	public void MetricsITC_Test() {
		assertMetric("ITC", "1", leagueModel, equipeClass); 
	}

	@Test
	public void MetricsETC_Test() {
		assertMetric("ETC", "1", leagueModel, equipeClass); 
	}

	@Test
	public void MetricsCAC_Test() {
		assertMetric("CAC", "3", leagueModel, equipeClass); 
	}

	@Test
	public void MetricsDIT_Test() {
		assertMetric("DIT", "0", leagueModel, equipeClass); 
	}

	@Test
	public void MetricsCLD_Test() {
		assertMetric("CLD", "0", leagueModel, equipeClass); 
	}

	@Test
	public void MetricsNOC_Test() {
		assertMetric("NOC", "0", leagueModel, equipeClass); 
	}

	@Test
	public void MetricsNOD_Test() {
		assertMetric("NOD", "0", leagueModel, equipeClass); 
	}

}
