package metrics;

import uml.UMLModel;
import uml.uml_classes.UMLClass;

public class MetricCAC extends BaseMetric {

	public MetricCAC() {
		super( "CAC",
				"",
				"Nombre d'associations (incluant les agrégations) locales et héritées auxquelles participe la classe.",
				"###");
	}

	@Override
	public double compute(UMLModel m, UMLClass c) {
		return 0.0;
	}
}
