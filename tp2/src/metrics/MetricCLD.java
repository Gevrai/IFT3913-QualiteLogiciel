package metrics;

import uml.UMLModel;
import uml.uml_classes.UMLClass;

public class MetricCLD extends BaseMetric {

	public MetricCLD() {
		super("CLD",
				"",
				"Taille du chemin le plus long reliant la classe à une classe feuille dans le graphe d'héritage.",
				"###");
	}

	@Override
	public double compute(UMLModel m, UMLClass c) {
		return 0.0;
	}

}
