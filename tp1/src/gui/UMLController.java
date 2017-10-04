package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import parser.UcdSyntaxParser;
import parser.UmlParsingError;
import uml.UMLModel;
import uml.uml_classes.Attribute;
import uml.uml_classes.Operation;
import uml.uml_classes.UMLClass;
import util.FileReader;

public class UMLController {
	
	private UMLView view;
	private UMLModel model;

	public UMLController() {
		this.view = new UMLView();
		this.view.setVisible(true);
		this.model = null;
		this.view.addBtnChargerFichierListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { searchFileDialogAndParse();}});
		this.view.addListClassSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) { showSelectedClassInfo();}});
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
	
	// Respond to selected item in Class box
	public void showSelectedClassInfo() {
		showAttributs();
		showOperations();
		showSubclasses();
		// TODO subclasses and associations
	}
	
	// Show the class list in UI
	public void showClasses() {
		List<UMLClass> listClasses = this.model.getClasses();
		String[] classes = new String[listClasses.size()];
		for (int i=0; i<classes.length;i++) {
			classes[i] = listClasses.get(i).getClassName();
		}
		this.view.setListClasses(classes);
	}
	
	// Show the attributes list in UI
	public void showAttributs() {
		String selectedClass = this.view.getSelectedClass();
		UMLClass c = this.model.getClassFromName(selectedClass);
		if (c == null) { return; }
		List<Attribute> listAttributs = c.getAttributes();
		String[] attributs = new String[listAttributs.size()];
		for (int i=0; i<attributs.length;i++) {
			attributs[i] = listAttributs.get(i).getName();
		}
		this.view.setListAttributs(attributs);
	}

	// Show the operations list in UI
	public void showOperations() {
		String selectedClass = this.view.getSelectedClass();
		UMLClass c = this.model.getClassFromName(selectedClass);
		if (c == null) { return; }
		List<Operation> listOperations = c.getOperations();
		String[] operations = new String[listOperations.size()];
		for (int i=0; i<operations.length;i++) {
			operations[i] = listOperations.get(i).getName();
		}
		this.view.setListMethodes(operations);
	}
	
	// Show the subclasses of currently selected class
	public void showSubclasses() {
		String selectedClass = this.view.getSelectedClass();
		List<UMLClass> subclasses = this.model.getSubclasses(selectedClass);
		String[] subclassesStr = new String[subclasses.size()];
		for (int i=0; i<subclassesStr.length;i++) {
			subclassesStr[i] = subclasses.get(i).getClassName();
		}
		this.view.setListSousClasses(subclassesStr);
	}
	

}
