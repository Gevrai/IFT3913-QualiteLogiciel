package metrics;

import uml.UMLModel;
import uml.uml_classes.UMLClass;

public class MetricETC extends BaseMetric {

	public MetricETC() {
		super( "ETC",
					 "",
					 "Nombre de fois où la classe apparaît comme type des arguments dans les méthodes des autres classes du diagramme.",
					 "###");
	}

	@Override
	public double compute(UMLModel m, UMLClass c) {
		return 0.0;
	}
}
