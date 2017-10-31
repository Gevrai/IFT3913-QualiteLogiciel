package metrics;

import uml.UMLModel;
import uml.uml_classes.UMLClass;

public class MetricITC extends BaseMetric {

	public MetricITC() {
		super( "ITC",
					 "",
					 "Nombre de fois où d'autres classes du diagramme apparaissent comme types des arguments dans les méthodes de la classe.",
					 "###");
	}

	@Override
	public double compute(UMLModel m, UMLClass c) {
		return 0.0;
	}
}
