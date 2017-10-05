import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import gui.UMLView;
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

	public UMLController() {
		this.view = new UMLView();
		this.view.setVisible(true);
		this.model = null;
		this.view.addBtnChargerFichierListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { searchFileDialogAndParse();}});
		this.view.addListClassSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) { showSelectedClassInfo();}});
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
		int returnVal = fc.showDialog(null, "Charger Fichier");

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			parseUcdFileToModel(fc.getSelectedFile().toPath().toString());
		}
	}
	
	// Parsing of a file into a UMLModel
	public void parseUcdFileToModel(String filePath) {
		try {
			List<String> fileContent = FileReader.getFileContentFormatted(filePath);
			this.model = UcdSyntaxParser.parse(fileContent);
			this.view.setFilePathText(filePath);
			showClasses();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("\n" + filePath + " is not a valid ucd file.");
		} catch (UmlParsingError e) {
			// TODO maybe make this a popup for user?
			System.out.println(e.getMessage());
		}
	}
	
	public UMLClass getSelectedClass() {
		if (classesShown == null)
			return null;
		int index = this.view.getSelectedClassIndex();
		return this.classesShown.get(index);
	}
	
	// Respond to selected item in Class box
	public void showSelectedClassInfo() {
		showAttributs();
		showOperations();
		showSubclasses();
		showAssociationsAggregations();
	}
	
	// Show the class list in UI
	public void showClasses() {
		List<UMLClass> listClasses = this.model.getClasses();
		String[] classes = new String[listClasses.size()];
		for (int i=0; i<classes.length;i++) {
			classes[i] = listClasses.get(i).getClassName();
		}
		this.classesShown = listClasses;
		this.view.setListClasses(classes);
	}
	
	// Show the attributes of currently selected class in UI
	public void showAttributs() {
		UMLClass c = getSelectedClass();
		if (c == null) { return; }
		List<Attribute> listAttributs = c.getAttributes();
		String[] attributs = new String[listAttributs.size()];
		for (int i=0; i<attributs.length;i++) {
			Attribute a = listAttributs.get(i);
			attributs[i] = a.getType().getTypeString() + " " + a.getName();
		}
		this.attributesShown = listAttributs;
		this.view.setListAttributs(attributs);
	}

	// Show the operations of currently selected class in UI
	public void showOperations() {
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
	public void showSubclasses() {
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
	public void showAssociationsAggregations() {
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
}
