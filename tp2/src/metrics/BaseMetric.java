package metrics;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import uml.UMLModel;
import uml.uml_classes.UMLClass;

public abstract class BaseMetric {

	protected String acronym;
	protected String fullName;
	protected String definition;
	protected NumberFormat formatter;

	public BaseMetric(String acronym, String fullName, String definition, String format) {
		this.acronym = acronym;
		this.fullName = fullName;
		this.definition = definition;
		this.formatter = new DecimalFormat(format);
	}

	public String getAcronym() { return this.acronym; }
	public String getFullName() { return this.fullName; }
	public String getDefinition() { return this.definition; }

	public String computeAndStringify(UMLModel m, UMLClass c) {
		double result = this.compute(m, c);
		return this.getAcronym() + " = " + formatter.format(result);
	}

	public abstract double compute(UMLModel m, UMLClass c);

}
