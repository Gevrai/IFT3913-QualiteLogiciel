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
		int nbMaxIter=0;
		int courrentIter=0;
		for(int z =0;z<m.getClasses().size();z++)
		{
			nbMaxIter+=m.getSubclasses(m.getClasses().get(z)).size();

			
			
		}
		
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
							courrentIter++;
							DIT=1+FindFather(m,curentClass,nbMaxIter,courrentIter);
							
							
						}
						
						
					}
				}
			}

			
		}
		
				
		return DIT;
	}
	
	private int FindFather(UMLModel m , UMLClass c, int maxIter,int iterCourent)
	{
		
		if(iterCourent==maxIter)
		{
			return -1-iterCourent;
			
		}
			
			
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
							iterCourent++;
							return 1+FindFather(m,curentClass,maxIter,iterCourent);
							
							
						}
						
						
					}
				}
			}

			
		}
		
		
		
		
		return 0;
	}
}
