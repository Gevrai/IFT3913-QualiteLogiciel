package metrics;

import java.util.List;

import uml.UMLModel;
import uml.uml_classes.Attribute;
import uml.uml_classes.Operation;
import uml.uml_classes.UMLClass;

public class MetricNOA extends BaseMetric {

	public MetricNOA() {
		super( "NOA",
					 "Number of Attributes",
					 "Nombre d'attributs locaux et héritées de la classe.",
					 "###");
	}

	@Override
	public double compute(UMLModel m, UMLClass c) {
		
		List<Attribute> listAttribute=c.getAttributes();
		List<UMLClass> listClass= m.getClasses();
		float NOA= listAttribute.size();
		
			for(int j=0;j<listClass.size();j++)
			{
				List<UMLClass> listSubClass= m.getSubclasses(listClass.get(j));
				if(!listSubClass.isEmpty())
				{
					if(listAttribute.size()!=0)
					{
						
						for(int k=0;k<listSubClass.size();k++)
						{
							
								if(listSubClass.get(k).getClassName()==c.getClassName())
								{
									NOA+=listClass.get(j).getAttributes().size();
									for(int i=0;i<listAttribute.size();i++)
									{
										
									
											for(int l=0 ; l<listClass.get(j).getAttributes().size();l++)
											{
												if(listClass.get(j).getAttributes().get(l).getName().contains(listAttribute.get(i).getName()))
														
												{
													NOA-=1;
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
									NOA+=listClass.get(j).getAttributes().size();
								}
						}
				
						
					}
				
							
				}
					

				}


			
		
		return NOA;

	
	}
}
