package metrics;

import java.util.List;

import uml.UMLModel;
import uml.uml_classes.Operation;
import uml.uml_classes.UMLClass;

public class MetricNOM extends BaseMetric {

	public MetricNOM() {
		super("NOM",
				"Number of Methods",
				"Nombre de méthodes locales et héritées de la classe.",
				"###");
	}

	@Override
	public double compute(UMLModel m, UMLClass c) {
		
		List<Operation> listOperation=c.getOperations();
		List<UMLClass> listClass= m.getClasses();
		double NOM= listOperation.size();
		
			for(int j=0;j<listClass.size();j++)
			{
				List<UMLClass> listSubClass= m.getSubclasses(listClass.get(j));
				if(!listSubClass.isEmpty())
				{
					if(listOperation.size()!=0)
					{
						
						for(int k=0;k<listSubClass.size();k++)
						{
							
								if(listSubClass.get(k).getClassName()==c.getClassName())
								{
									NOM+=listClass.get(j).getOperations().size();
									for(int i=0;i<listOperation.size();i++)
									{
										
									
											for(int l=0 ; l<listClass.get(j).getOperations().size();l++)
											{
												if(listClass.get(j).getOperations().get(l).getArgs().toString().contains(listOperation.get(i).getArgs().toString())
														&& listClass.get(j).getOperations().get(l).getName()==listOperation.get(i).getName())
												{
													NOM-=1;
												}
												
												
											}
				
									}
									
								}
								
						}
					}
					else
					{
						
						for(int k=0;k<listSubClass.size();k++)
						{
							
								if(listSubClass.get(k).getClassName()==c.getClassName())
								{									
									NOM+=listClass.get(j).getOperations().size();
								}
						}
				
						
					}
				
							
				}
					

				}


			
		
		return NOM;

	}

}
