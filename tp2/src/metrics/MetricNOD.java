package metrics;

import uml.UMLModel;
import uml.uml_classes.UMLClass;

public class MetricNOD extends BaseMetric {

	public MetricNOD() {
		super( "NOD",
					 "",
					 "Nombre de sous-classes directes et indirectes de la classe.",
					 "###");
	}

	@Override
	public double compute(UMLModel m, UMLClass c) {
		return 0.0;
	}
}
