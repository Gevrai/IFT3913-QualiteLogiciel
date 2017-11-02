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
		int nbMaxIter=0;
		
		for(int z =0;z<m.getClasses().size();z++)
		{
			nbMaxIter+=m.getSubclasses(m.getClasses().get(z)).size();
			
		}
		
		if(listeSubClass.size()!=0)
		{
			int[] Depth=new int[listeSubClass.size()];
			int[] counter=new int[listeSubClass.size()];
			
			
			for(int i=0;i<listeSubClass.size();i++)
			{
				counter[i]=1;
				Depth[i]=1+DepthSearcClass(m,listeSubClass.get(i),nbMaxIter,counter[i]);
				if(Depth[i]<0)
				{
					return -1; 
					
				}
				else if(CLD<Depth[i])
				{
					CLD=Depth[i];
					
				}
			}
			
			}
			
		
		return CLD;
	}

	private int DepthSearcClass(UMLModel m , UMLClass c,int nbMaxIter,int currentIter)
	{
		
		
		int CLDTemp=0;
		List<UMLClass> listeSubClass= m.getSubclasses(c);
		if(nbMaxIter==currentIter)
		{
			return -1-nbMaxIter;
			
			
		}
		if(listeSubClass.size()!=0)
		{
			int[] Depth=new int[listeSubClass.size()];
			int[] counter=new int[listeSubClass.size()];
			
			for(int i=0;i<listeSubClass.size();i++)
			{
				counter[i]=currentIter+1;
				Depth[i]=1+DepthSearcClass(m,listeSubClass.get(i),nbMaxIter,counter[i]);
				
				if(Depth[i]<0)
				{
					return -1-nbMaxIter; 
					
				}
				else if(CLDTemp<Depth[i])
				{
					CLDTemp=Depth[i];
					
				}
				
				
			}
			
		}
		return CLDTemp;
		
	}
	
	
	
	
	
}
