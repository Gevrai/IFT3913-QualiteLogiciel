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
		boolean ChildClassPresent= false;
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
				
				if(!curentClass.getClassName().contains(c.getClassName()))
				{
					
					for(int j =0; j<listeSubClass.size();j++)
					{
						if(listeSubClass.get(j).getClassName().contains(c.getClassName()))
						{
							ChildClassPresent=true;
							System.out.println(m.getAssociatedClasses(listeSubClass.get(j)).size());
							CAC=iterativeRelation(m,curentClass,nbMaxIter,m.getAssociatedClasses(listeSubClass.get(j)).size());
							
							
						}
						
						
					}
				}
			}

			
		}
		/*if(!ChildClassPresent)
		{
			CAC=m.getAssociatedClasses(c).size();
			
		}
		
		*/
		CAC+=m.getAssociatedClasses(c).size();
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
						
						return m.getAssociatedClasses(c).size()+iterativeRelation(m,curentClass,nbIterationMAX,valeur+m.getAssociatedClasses(listeSubClass.get(i)).size());
						
						
					}
					
					
				}
			}
				
				
		}
			
			
		return valeur;
		
	}
	
}
