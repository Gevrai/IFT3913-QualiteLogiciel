package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import parser.UcdSyntaxParser;
import parser.UmlParsingError;
import uml.UMLModel;
import util.FileReader;

public class UMLController {
	
	private UMLView view;
	private UMLModel model;

	public UMLController() {
		this.view = new UMLView();
		this.view.setVisible(true);
		this.model = null;
		this.view.addBtnChargerFichierListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { searchFileDialogAndParse(); } });
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
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("\n" + filePath + " is not a valid ucd file.");
		} catch (UmlParsingError e) {
			// TODO maybe make this a popup for user?
			System.out.println(e.getMessage());
		}
	}
	
}
