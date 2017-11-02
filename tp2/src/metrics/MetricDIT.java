package metrics;

import java.util.List;

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
		
		int DIT=0;
		
		for(int i=0;i<m.getClasses().size();i++)
		{
			UMLClass curentClass= m.getClasses().get(i);
			List<UMLClass> listeSubClass= m.getSubclasses(m.getClasses().get(i));
			
			if(!listeSubClass.isEmpty())
			{
				
				if(!curentClass.getClassName().contains(c.getClassName()))
				{
					
					for(int j =0; j<listeSubClass.size();j++)
					{
						if(listeSubClass.get(j).getClassName().contains(c.getClassName()))
						{
							
							DIT=1+FindFather(m,curentClass);
							
							
						}
						
						
					}
				}
			}

			
		}
		
				
		return DIT;
	}
	
	private int FindFather(UMLModel m , UMLClass c)
	{
		
		for(int i=0;i<m.getClasses().size();i++)
		{
			UMLClass curentClass= m.getClasses().get(i);
			List<UMLClass> listeSubClass= m.getSubclasses(m.getClasses().get(i));
			
			if(!listeSubClass.isEmpty())
			{
				
				if(!curentClass.getClassName().contains(c.getClassName()))
				{
					
					for(int j =0; j<listeSubClass.size();j++)
					{
						if(listeSubClass.get(j).getClassName().contains(c.getClassName()))
						{
							
							return 1+FindFather(m,curentClass);
							
							
						}
						
						
					}
				}
			}

			
		}
		
		
		
		
		return 0;
	}
}
