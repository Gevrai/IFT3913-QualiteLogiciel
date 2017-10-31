package metrics;

import uml.UMLModel;
import uml.uml_classes.UMLClass;

public class MetricNOA extends BaseMetric {

	public MetricNOA() {
		super( "NOA",
					 "Number of Attributes",
					 "Nombre d'attributs locaux et héritées de la classe.",
					 "###");
	}

	@Override
	public double compute(UMLModel m, UMLClass c) {
		return 0.0;
	}
}
