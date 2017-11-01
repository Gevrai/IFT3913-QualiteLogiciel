package metrics;
import java.util.List;

import uml.UMLModel;
import uml.uml_classes.UMLClass;
import uml.uml_associations.*;

public class MetricCAC extends BaseMetric {

	public MetricCAC() {
		super( "CAC",
				"",
				"Nombre d'associations (incluant les agrégations) locales et héritées auxquelles participe la classe.",
				"###");
	}

	@Override
	public double compute(UMLModel m, UMLClass c) {
		double CAC=0;
		double nbMaxIter=0;
		
		for(int z =0;z<m.getClasses().size();z++)
		{
			nbMaxIter+=m.getAssociatedClasses(m.getClasses().get(z)).size();

			
			
		}
		for(int i=0;i<m.getClasses().size();i++)
		{
			UMLClass curentClass= m.getClasses().get(i);
			List<UMLClass> listeSubClass= m.getSubclasses(m.getClasses().get(i));
			
			if(!listeSubClass.isEmpty())
			{
				
				for(int j =0; j<listeSubClass.size();j++)
				{
					if(listeSubClass.get(i).getClassName().contains(c.getClassName()))
					{
						
						CAC=m.getAssociatedClasses(c).size()+iterativeRelation(m,curentClass,nbMaxIter,m.getAssociatedClasses(c).size());
						break;
						
					}
					
					
				}
			}
			
			
		}
				
		
		
		
		
		return CAC;
	}
	private double iterativeRelation(UMLModel m, UMLClass c , double nbIterationMAX, double valeur)
	{
		
		System.out.println(valeur);
		if(nbIterationMAX== valeur)
		{
			return valeur;
			
		}
		for(int i=0;i<m.getClasses().size();i++)
		{
			UMLClass curentClass= m.getClasses().get(i);
			List<UMLClass> listeSubClass= m.getSubclasses(m.getClasses().get(i));
			
			if(!listeSubClass.isEmpty())
			{
				for(int j =0; j<listeSubClass.size();j++)
				{
					if(listeSubClass.get(i).getClassName().contains(c.getClassName()))
					{
						return valeur+m.getAssociatedClasses(curentClass).size()+iterativeRelation(m,curentClass,nbIterationMAX,valeur);
						
						
					}
					
					
				}
			}
				
				
		}
			
			
		return valeur;
		
	}
	
}
