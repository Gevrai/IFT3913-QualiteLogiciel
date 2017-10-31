package metrics;

import uml.UMLModel;
import uml.uml_classes.UMLClass;

public class MetricDIT extends BaseMetric {

	public MetricDIT() {
		super( "DIT",
					 "Depth of Inheritance Tree",
					 "Taille du chemin le plus long reliant la classe à une classe racine dans le graphe d'héritage.",
					 "###");
	}

	@Override
	public double compute(UMLModel m, UMLClass c) {
		return 0.0;
	}
}
