package metrics;

import uml.UMLModel;
import uml.uml_classes.UMLClass;

public class MetricNOC extends BaseMetric {

	public MetricNOC() {
		super( "NOC",
					 "",
					 "Nombre de sous-classe directes de la classe.",
					 "###");
	}

	@Override
	public double compute(UMLModel m, UMLClass c) {
		return 0.0;
	}
}
