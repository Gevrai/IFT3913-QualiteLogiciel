package metrics;

import uml.UMLModel;
import uml.uml_classes.UMLClass;

public class MetricNOM extends BaseMetric {

	public MetricNOM() {
		super("NOM",
				"Number of Methods",
				"Nombre de méthodes locales et héritées de la classe.",
				"###");
	}

	@Override
	public double compute(UMLModel m, UMLClass c) {
	}

}
