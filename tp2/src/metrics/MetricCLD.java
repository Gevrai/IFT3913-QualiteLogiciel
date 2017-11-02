package metrics;

import java.util.List;

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
		int CLD=0;
		List<UMLClass> listeSubClass= m.getSubclasses(c);
		if(listeSubClass.size()!=0)
		{
			int[] Depth=new int[listeSubClass.size()];
			
			
			
			for(int i=0;i<listeSubClass.size();i++)
			{
				
				Depth[i]=1+DepthSearcClass(m,listeSubClass.get(i));
				if(CLD<Depth[i])
				{
					CLD=Depth[i];
					
				}
			}
			
			}
			
		
		return CLD;
	}

	private int DepthSearcClass(UMLModel m , UMLClass c)
	{
		int CLDTemp=0;
		List<UMLClass> listeSubClass= m.getSubclasses(c);
		if(listeSubClass.size()!=0)
		{
			int[] Depth=new int[listeSubClass.size()];
			
			
			for(int i=0;i<listeSubClass.size();i++)
			{
				Depth[i]=1+DepthSearcClass(m,listeSubClass.get(i));
				if(CLDTemp<Depth[i])
				{
					CLDTemp=Depth[i];
					
				}
				
			}
			
		}
		return CLDTemp;
		
	}
	
	
	
	
	
}
