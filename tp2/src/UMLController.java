import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import gui.MessagePopup;
import gui.UMLView;
import metrics.BaseMetric;
import metrics.MetricFactory;
import parser.UcdSyntaxParser;
import parser.UmlParsingError;
import uml.UMLModel;
import uml.uml_associations.Aggregation;
import uml.uml_associations.Relation;
import uml.uml_associations.Role;
import uml.uml_associations.UMLAssociation;
import uml.uml_classes.Argument;
import uml.uml_classes.Attribute;
import uml.uml_classes.Operation;
import uml.uml_classes.UMLClass;
import util.FileReader;

public class UMLController {
	
	private UMLView view;
	private UMLModel model;
	
	// Keeping references to real objects that are shown in UI
	private List<UMLClass> classesShown;
	private List<Attribute> attributesShown;
	private List<Operation> operationsShown;
	private List<UMLClass> subclassesShown;
	private List<UMLAssociation> associationsShown;
	
	private String metricsOrder[] = {"ANA","NOM","NOA","ITC","ETC","CAC","DIT","CLD","NOC","NOD"};

	public UMLController() {
		this.view = new UMLView();
		this.view.setVisible(true);
		this.model = null;
		setUpListeners();
	}
	
	// Sets up all necessary listeners for user interaction with the program
	private void setUpListeners() {

		this.view.addBtnChargerFichierListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { searchFileDialogAndParse();}
			});

		this.view.addBtnCalculerMetriquesListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { saveMetricsFromDialog();}
			});

		this.view.addListClassSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) { showSelectedClassInfo();}
			});

		this.view.addListAttributsSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) { 
				int i = view.getSelectedAttributsIndex();
				if (i >= 0) showDetailedInfos(attributesShown.get(i).toString());}
			});
		
		this.view.addListMethodesSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) { 
				int i = view.getSelectedMethodesIndex();
				if (i >= 0) showDetailedInfos(operationsShown.get(i).toString());}
			});
		
		this.view.addListSousClassesSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) { 
				int i = view.getSelectedSubclassIndex();
				if (i >= 0) showDetailedInfos(subclassesShown.get(i).toString());}
			});
		
		this.view.addListAssociationSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) { 
				int i = view.getSelectedAssociationIndex();
				if (i >= 0) showDetailedInfos(associationsShown.get(i).toString());}
			});

		this.view.addListMetriquesSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) { 
				int i = view.getSelectedMetriqueIndex();
				String def = MetricFactory.getMetric(metricsOrder[i]).getDefinition();
				if (i >= 0) showDetailedInfos(def);}
			});

	}

	// Opens up a dialog for the user to find a file and parses it if he does
	public void searchFileDialogAndParse() {
		final JFileChooser fc = new JFileChooser();
		fc.setFileFilter(new FileNameExtensionFilter(".ucd", "ucd", "UCD"));
		String currentPath = this.view.getFilePathText();
		if (currentPath != null) {
			File currentFile = new File(currentPath);
			fc.setCurrentDirectory(currentFile);
		}
		int returnVal = fc.showDialog(null, "Charger");
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			parseUcdFileToModel(fc.getSelectedFile().toPath().toString());
		}
	}
	
	// Saves metrics to a csv file selected from a dialog
	public void saveMetricsFromDialog() {
		final JFileChooser fc = new JFileChooser();
		fc.setFileFilter(new FileNameExtensionFilter(".csv", "csv", "CSV"));
		String currentPath = this.view.getFilePathText();
		if (currentPath != null) {
			File currentFile = new File(currentPath);
			fc.setCurrentDirectory(currentFile);
		}
		int returnVal = fc.showDialog(null, "Sauvegarder");
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			try {
				FileWriter fw = new FileWriter(fc.getSelectedFile());
				fw.write(metricsToCSVString());
				fw.close();
			} catch (IOException e) {
				new MessagePopup("Error trying to save to " + fc.getSelectedFile().getName() + "\nCould not complete");
			}
		}
	}
	
	// Constructs string to be printed into csv file
	private String metricsToCSVString() {
		String csvString = "Classe";
		for (String s : metricsOrder)
			csvString += "," + s;
		
		for (UMLClass c : this.model.getClasses()) {
			csvString += "\n" + c.getClassName();
			for (String s : metricsOrder) {
				csvString += "," + MetricFactory.getMetric(s).compute(this.model, c);
			}
		}
		return csvString;
	}

	// Parsing of a file into a UMLModel
	public void parseUcdFileToModel(String filePath) {
		try {
			List<String> fileContent = FileReader.getFileContent(filePath);
			this.model = UcdSyntaxParser.parse(fileContent);
			this.view.setFilePathText(filePath);
			cleanUI();
			showClasses();
		} catch (IOException e) {
			new MessagePopup(filePath + " is not a valid ucd file.");
		} catch (UmlParsingError e) {
			new MessagePopup(e.getMessage());
		}
	}
	
	// Empties all boxes in UI
	private void cleanUI() {
		this.classesShown = new ArrayList<UMLClass>();
		this.view.setListClasses(new String[0]);
		this.attributesShown = new ArrayList<Attribute>();
		this.view.setListAttributs(new String[0]);
		this.operationsShown = new ArrayList<Operation>();
		this.view.setListMethodes(new String[0]);
		this.subclassesShown = new ArrayList<UMLClass>();
		this.view.setListSousClasses(new String[0]);
		this.associationsShown = new ArrayList<UMLAssociation>();
		this.view.setListAssociation(new String[0]);
		this.view.setDetailedText("");
		this.view.setListMetriques(new String[0]);
	}

	private UMLClass getSelectedClass() {
		if (classesShown == null) return null;
		int index = this.view.getSelectedClassIndex();
		return this.classesShown.get(index);
	}
	
	// Respond to selected item in Class box
	private void showSelectedClassInfo() {
		int i = view.getSelectedClassIndex();
		if (i < 0) return;
		showDetailedInfos(this.classesShown.get(i).toString());
		showAttributs();
		showOperations();
		showSubclasses();
		showAssociationsAggregations();
		showMetrics();
	}
	
	// Show the class list in UI
	private void showClasses() {
		List<UMLClass> listClasses = this.model.getClasses();
		String[] classes = new String[listClasses.size()];
		for (int i=0; i<classes.length;i++) {
			classes[i] = listClasses.get(i).getClassName();
		}
		this.classesShown = listClasses;
		this.view.setListClasses(classes);
	}
	
	// Show the attributes of currently selected class in UI
	private void showAttributs() {
		UMLClass c = getSelectedClass();
		List<Attribute> listAttributs;
		if (c == null) { return; }
		listAttributs = c.getAttributes();
		String[] attributs = new String[listAttributs.size()];
		for (int i=0; i<attributs.length;i++) {
			Attribute a = listAttributs.get(i);
			attributs[i] = a.getType().getTypeString() + " " + a.getName();
		}
		this.attributesShown = listAttributs;
		this.view.setListAttributs(attributs);
	}

	// Show the operations of currently selected class in UI
	private void showOperations() {
		UMLClass c = getSelectedClass();
		if (c == null) { return; }
		List<Operation> listOperations = c.getOperations();
		String[] operations = new String[listOperations.size()];
		for (int i=0; i<operations.length;i++) {
			Operation o = listOperations.get(i);
			operations[i] = o.getReturnType().getTypeString() + " " + o.getName() + "(";
			List<Argument> args = o.getArgs();
			// Special formatting for args
			if (!args.isEmpty()) {
				operations[i] += args.get(0).getName() + " : " + args.get(0).getType().getTypeString();
				for(int j=1;j<args.size();j++) {
					operations[i] += ", " + args.get(j).getName()+ " : " + args.get(j).getType().getTypeString();
				}
			}
			operations[i] += ")";
		}
		this.operationsShown = listOperations;
		this.view.setListMethodes(operations);
	}
	
	// Show the subclasses of currently selected class in UI
	private void showSubclasses() {
		UMLClass c = getSelectedClass();
		if (c == null) { return; }
		List<UMLClass> listSubclasses = this.model.getSubclasses(c);
		String[] subclasses = new String[listSubclasses.size()];
		for (int i=0; i<subclasses.length;i++) {
			subclasses[i] = listSubclasses.get(i).getClassName();
		}
		this.subclassesShown = listSubclasses;
		this.view.setListSousClasses(subclasses);
	}
	
	// Show association and aggregation of currently selected class in UI
	private void showAssociationsAggregations() {
		UMLClass c = getSelectedClass();
		if (c == null) { return; }
		List<UMLAssociation> listAssociations = this.model.getAssociatedClasses(c);
		String[] associations = new String[listAssociations.size()];
		for (int i=0; i<associations.length;i++) {
			// Relation 
			if (listAssociations.get(i) instanceof Relation) {
				Relation rel = (Relation)listAssociations.get(i);
				associations[i] = "(R) ";
				if(!c.getClassName().equals(rel.getSource().getAffectedClass()))
					associations[i] += "inv_";
				associations[i] += rel.getName();
			}
			// Aggregation
			else if (listAssociations.get(i) instanceof Aggregation) {
				Aggregation agr = (Aggregation)listAssociations.get(i);
				associations[i] = "(A) ";
				// Container
				if(c.getClassName().equals(agr.getContainer().getAffectedClass())) {
					for (Role role : agr.getParts()) {
						associations[i] += "P_" + role.getAffectedClass() + " ";
					}
				} 
				// Parts
				else {
					associations[i] += "C_" + agr.getContainer().getAffectedClass();
				}
			}
		}
		this.associationsShown = listAssociations;
		this.view.setListAssociation(associations);
	}
	
	// Show detailed view of last selected element
	private void showDetailedInfos(String detailedInfos) {
		this.view.setDetailedText(detailedInfos);
	}
	
	// Show calculated metrics for currently selected class
	private void showMetrics() {
		UMLClass c = getSelectedClass();
		String[] toShow = new String[metricsOrder.length];
		for (int i=0; i<toShow.length; i++) {
			BaseMetric metric = MetricFactory.getMetric(metricsOrder[i]);
			toShow[i] = metric.getAcronym() + " = " + metric.computeToFormattedString(this.model, c);
		}
		this.view.setListMetriques(toShow);
	}
}
