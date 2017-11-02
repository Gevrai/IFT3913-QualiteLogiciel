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

public class CACTest {
	
	UMLModel leagueModel;
	UMLClass equipeClass;
	
	@Before
	public void setUp() throws Exception {
		try {
			// Setting up valid league model from file
			List<String> content = FileReader.getFileContent("./tests/JoueurTestCAC.ucd");
			leagueModel = UcdSyntaxParser.parse(content);
			equipeClass = leagueModel.getClassFromName("Joueur");
			// Setting up other valid models can be done here, needs to add new global variables though
		} catch (IOException e) { fail("./tests/JoueurTestCAC.ucd inexistant -> Cannot test");
		} catch (UmlParsingError e) { 
			e.printStackTrace();
			fail("Error parsing valid file JoueurTestCAC.ucd"); }
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
		assertMetric("NOA", "3", leagueModel, equipeClass); 
	}

	@Test
	public void MetricsITC_Test() {
		assertMetric("ITC", "1", leagueModel, equipeClass); 
	}

	@Test
	public void MetricsETC_Test() {
		assertMetric("ETC", "2", leagueModel, equipeClass); 
	}

	@Test
	public void MetricsCAC_Test() {
		assertMetric("CAC", "3", leagueModel, equipeClass); 
	}

	@Test
	public void MetricsDIT_Test() {
		assertMetric("DIT", "1", leagueModel, equipeClass); 
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

