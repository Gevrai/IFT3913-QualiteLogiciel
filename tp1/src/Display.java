import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.border.EmptyBorder;

import parser.UcdSyntaxParser;
import parser.UmlParsingError;
import uml.UMLModel;
import util.FileReader;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.ListSelectionModel;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class Display {

	public JFrame frame;
	private JTextField TextFichier;
	private JTextField textField_4;
	

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Display window = new Display();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 */
	/**
	 * Create the application.
	 */
	public Display() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setAutoRequestFocus(false);
		frame.setBounds(100, 100, 600, 601);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel LabelClasse = new JLabel("Classes");
		LabelClasse.setBounds(23, 95, 46, 14);
		frame.getContentPane().add(LabelClasse);
		

		
		TextFichier = new JTextField();
		TextFichier.setBounds(146, 34, 238, 20);
		frame.getContentPane().add(TextFichier);
		TextFichier.setColumns(10);
		
		JLabel LabelAttribut = new JLabel("Attributs");
		LabelAttribut.setBounds(146, 95, 143, 14);
		frame.getContentPane().add(LabelAttribut);
		
		JLabel labelMethode = new JLabel("Méthodes");
		labelMethode.setBounds(315, 95, 143, 14);
		frame.getContentPane().add(labelMethode);
		
		JLabel labelSousClasses = new JLabel("Sous-classes");
		labelSousClasses.setBounds(146, 263, 143, 14);
		frame.getContentPane().add(labelSousClasses);
		
		JLabel labelAssociation = new JLabel("Associations/agrégations");
		labelAssociation.setBounds(315, 263, 143, 14);
		frame.getContentPane().add(labelAssociation);
		
		JLabel lblDetails = new JLabel("Détails");
		lblDetails.setBounds(146, 394, 312, 14);
		frame.getContentPane().add(lblDetails);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(146, 419, 312, 119);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JPanel panelClasses = new JPanel();
		panelClasses.setBorder(UIManager.getBorder("TextField.border"));
		panelClasses.setBounds(23, 122, 113, 416);
		frame.getContentPane().add(panelClasses);
		
		JList listClasses = new JList();
		panelClasses.add(listClasses);
		listClasses.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listClasses.setBackground(Color.WHITE);
		listClasses.setBorder(UIManager.getBorder("TextPane.border"));
		
		JPanel panelAttributs = new JPanel();
		panelAttributs.setBorder(UIManager.getBorder("TextField.border"));
		panelAttributs.setBounds(146, 120, 143, 112);
		frame.getContentPane().add(panelAttributs);
		
		JList listAttributs = new JList();
		listAttributs.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panelAttributs.add(listAttributs);
		
		JPanel panelSousClasses = new JPanel();
		panelSousClasses.setBorder(UIManager.getBorder("TextField.border"));
		panelSousClasses.setBounds(146, 289, 143, 87);
		frame.getContentPane().add(panelSousClasses);
		
		JList listSousClasses = new JList();
		panelSousClasses.add(listSousClasses);
		
		JPanel panelMethodes = new JPanel();
		panelMethodes.setBorder(UIManager.getBorder("TextField.border"));
		panelMethodes.setBounds(315, 120, 143, 112);
		frame.getContentPane().add(panelMethodes);
		
		JList listMethodes = new JList();
		panelMethodes.add(listMethodes);
		
		JPanel panelAssociation = new JPanel();
		panelAssociation.setBorder(UIManager.getBorder("TextField.border"));
		panelAssociation.setBounds(315, 289, 143, 87);
		frame.getContentPane().add(panelAssociation);
		
		JList listAssociation = new JList();
		panelAssociation.add(listAssociation);
		
		JButton btnAjouterF = new JButton("Ajouter Fichier");
		
		
		btnAjouterF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final JFileChooser fc = new JFileChooser();
			    if (e.getSource() == btnAjouterF) {
			        int returnVal = fc.showOpenDialog(TextFichier);

			        if (returnVal == JFileChooser.APPROVE_OPTION) {
			            TextFichier.setText(fc.getSelectedFile().toPath().toString());
			        } 
			   }
				
				
				
			}
		});
		btnAjouterF.setBounds(394, 33, 119, 23);
		frame.getContentPane().add(btnAjouterF);
		JButton btnChargerFichier = new JButton("Charger fichier");
		btnChargerFichier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					List<String> fileContent = FileReader.getFileContentFormatted(TextFichier.getText());
					UMLModel model = UcdSyntaxParser.parse(fileContent);
					System.out.println(model.toString());
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("\n" + TextFichier.getText() + " is not a valid ucd file.");
				} catch (UmlParsingError e) {
					System.out.println(e.getMessage());
				}
				
			 
			
			}
				
		});
		btnChargerFichier.setBounds(23, 33, 113, 23);
		frame.getContentPane().add(btnChargerFichier);
		
	}
}
