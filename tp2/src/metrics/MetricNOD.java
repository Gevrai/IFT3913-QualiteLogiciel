package metrics;

import java.util.List;

import uml.UMLModel;
import uml.uml_classes.UMLClass;

public class MetricNOD extends BaseMetric {

	public MetricNOD() {
		super( "NOD",
					 "",
					 "Nombre de sous-classes directes et indirectes de la classe.",
					 "###");
	}

	@Override
	public double compute(UMLModel m, UMLClass c) {
		double NOD=0;
		int nbMaxIter=0;
		int courrentIter=0;
		for(int z =0;z<m.getClasses().size();z++)
		{
			nbMaxIter+=m.getSubclasses(m.getClasses().get(z)).size();
			
		}
		
		
		
		if(m.getSubclasses(c).size()!=0)
		{
			NOD=searchChild( m, c, 0,nbMaxIter,0);	
		}
		
		return NOD;
	}
	private double searchChild(UMLModel m,UMLClass c, double v, int nbMaxIter, int currentIter)
	{
		if(nbMaxIter==currentIter)
		{
			return -1-currentIter;
			
		}
		
		if(m.getSubclasses(c).size()!=0)
		{
			List<UMLClass> listClass =m.getSubclasses(c);
			
			for (int i =0; i<listClass.size();i++)
			{
				return v+searchChild(m,listClass.get(i),v,nbMaxIter,currentIter+1)+m.getSubclasses(c).size();
				
			}
			
			
		}

			return 0;
	
		
	}
	
	
}
