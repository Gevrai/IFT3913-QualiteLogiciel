package metrics;

import uml.UMLModel;
import uml.uml_classes.Operation;
import uml.uml_classes.UMLClass;

public class MetricANA extends BaseMetric {

	public MetricANA() {
		super( "ANA",
				"Average number of arguments",
				"Nombre moyen d'arguments des méthodes locales pour la classe.");
	}

	@Override
	public double compute(UMLModel m, UMLClass c) {
		int sum = 0;
		if (c.getOperations().isEmpty())
			return 0.0;
		for (Operation op : c.getOperations()) {
			sum += op.getArgs().size();
		}
		return (double) sum/ c.getOperations().size();
	}
}
