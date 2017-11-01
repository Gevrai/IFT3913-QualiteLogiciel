package metrics;

import java.util.List;

import uml.UMLModel;
import uml.uml_classes.Operation;
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
		List<UMLClass> listClass= m.getClasses();
		double ETC=0;
		for(int i=0;i<listClass.size();i++)
		{
			List<Operation> listOperation=listClass.get(i).getOperations();
			if(listOperation.size()!=0 && listClass.get(i).getClassName() != c.getClassName())
					{
						for(int j=0; j<listOperation.size();j++)
						{
						
							
								for(int l =0; l<listOperation.get(j).getArgs().size();l++)
								{
									if(listOperation.get(j).getArgs().get(l).getType().getTypeString().contains(c.getClassName()))
									{
										
										
										ETC+=1;
									}
								}
							
							
							
						}
						
						
					}
		}
		
		
		return ETC;
	}
}
