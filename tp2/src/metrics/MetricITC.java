package metrics;

import java.util.List;

import uml.UMLModel;
import uml.uml_classes.Operation;
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
		List<UMLClass> listClass= m.getClasses();
		List<Operation> listOperation=c.getOperations();
		double ITC=0;
		for(int i=0;i<listOperation.size();i++)
		{
			if(listOperation.get(i).getArgs().size()!=0)
			{
				for(int j=0; j<listOperation.get(i).getArgs().size();j++)
				{
					for(int k =0; k<listClass.size();k++)
					{

						if(listOperation.get(i).getArgs().get(j).getType().getTypeString().contains(listClass.get(k).getClassName()))
						{
							
							ITC++;
						}
						
					}
					
					
				}
				
				
			}
			
		}
		
		
		return ITC;
	}
}
