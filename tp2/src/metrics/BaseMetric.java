package metrics;

import uml.UMLModel;
import uml.uml_classes.UMLClass;

public abstract class BaseMetric {

	protected String acronym;
	protected String fullName;
	protected String definition;

	public BaseMetric(String acronym, String fullName, String definition) {
		this.acronym = acronym;
		this.fullName = fullName;
		this.definition = definition;
	}

	public String getAcronym() { return this.acronym; }
	public String getFullName() { return this.fullName; }
	public String getDefinition() { return this.definition; }

	public String computeAndStringify(UMLModel m, UMLClass c) {
		return this.getAcronym() + " = " + this.compute(m, c);
	}

	public abstract double compute(UMLModel m, UMLClass c);

}
