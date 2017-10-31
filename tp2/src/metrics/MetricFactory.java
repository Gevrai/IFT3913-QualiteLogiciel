package metrics;

public class MetricFactory {
	
	public static BaseMetric getMetric(String metricAcronym) {
		switch (metricAcronym) {
		case "ANA": return new MetricANA();
		case "CAC": return new MetricCAC();
		case "CLD": return new MetricCLD();
		case "DIT": return new MetricDIT();
		case "ETC": return new MetricETC();
		case "ITC": return new MetricITC();
		case "NOA": return new MetricNOA();
		case "NOC": return new MetricNOC();
		case "NOD": return new MetricNOD();
		case "NOM": return new MetricNOM();
		default : return null;
		}
	}
}
