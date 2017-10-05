package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionListener;


public class UMLView extends JFrame {

	private JTextField textFileName = new JTextField();
	private JTextField textDetails;

	private JLabel labelClasse = new JLabel("Classes");
	private JLabel labelAttribut = new JLabel("Attributs");
	private JLabel labelMethode = new JLabel("Méthodes");
	private JLabel labelSousClasses = new JLabel("Sous-classes");
	private JLabel labelAssociation = new JLabel("Associations/agrégations");
	private JLabel labelDetails = new JLabel("Détails");

	private JList<String> listClasses = new JList<String>();
	private JList<String> listAttributs = new JList<String>();
	private JList<String> listSousClasses = new JList<String>();
	private JList<String> listMethodes = new JList<String>();
	private JList<String> listAssociation = new JList<String>();

	private JPanel panelClasses = new JPanel(new BorderLayout());
	private JPanel panelAttributs = new JPanel(new BorderLayout());
	private JPanel panelSousClasses = new JPanel(new BorderLayout());
	private JPanel panelMethodes = new JPanel(new BorderLayout());
	private JPanel panelAssociation = new JPanel(new BorderLayout());

	private JButton btnChargerFichier = new JButton("Charger fichier");

	/**
	 * Create the application.
	 */
	public UMLView() {
		super("UML Model");
		initializeGUI();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initializeGUI() {
		
		setAutoRequestFocus(false);
		setBounds(100, 100, 600, 601);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		labelClasse.setBounds(23, 95, 46, 14);
		getContentPane().add(labelClasse);
		
		textFileName.setBounds(146, 34, 238, 20);
		getContentPane().add(textFileName);
		textFileName.setColumns(10);
		
		labelAttribut.setBounds(146, 95, 143, 14);
		getContentPane().add(labelAttribut);
		
		labelMethode.setBounds(315, 95, 143, 14);
		getContentPane().add(labelMethode);
		
		labelSousClasses.setBounds(146, 263, 143, 14);
		getContentPane().add(labelSousClasses);
		
		labelAssociation.setBounds(315, 263, 143, 14);
		getContentPane().add(labelAssociation);
		
		labelDetails.setBounds(146, 394, 312, 14);
		getContentPane().add(labelDetails);
		
		textDetails = new JTextField();
		textDetails.setEditable(false);
		textDetails.setBounds(146, 419, 312, 119);
		getContentPane().add(textDetails);
		textDetails.setColumns(10);
		
		panelClasses.setBorder(UIManager.getBorder("TextField.border"));
		panelClasses.setBounds(23, 122, 113, 416);
		getContentPane().add(panelClasses);
		panelClasses.add(new JScrollPane(listClasses), BorderLayout.CENTER);
		String[] test = {"fegeaweg","fegeaweg","fegeaweg"};
		setListClasses(test);

		listClasses.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listClasses.setBackground(Color.WHITE);
		listClasses.setBorder(UIManager.getBorder("TextPane.border"));
		
		panelAttributs.setBorder(UIManager.getBorder("TextField.border"));
		panelAttributs.setBounds(146, 120, 143, 112);
		getContentPane().add(panelAttributs);
		panelAttributs.add(new JScrollPane(listAttributs), BorderLayout.CENTER);
		listAttributs.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panelAttributs.add(listAttributs);
		
		panelSousClasses.setBorder(UIManager.getBorder("TextField.border"));
		panelSousClasses.setBounds(146, 289, 143, 87);
		getContentPane().add(panelSousClasses);
		panelSousClasses.add(new JScrollPane(listSousClasses), BorderLayout.CENTER);
		panelSousClasses.add(listSousClasses);
		
		panelMethodes.setBorder(UIManager.getBorder("TextField.border"));
		panelMethodes.setBounds(315, 120, 143, 112);
		getContentPane().add(panelMethodes);
		panelMethodes.add(new JScrollPane(listMethodes), BorderLayout.CENTER);
		panelMethodes.add(listMethodes);
		
		panelAssociation.setBorder(UIManager.getBorder("TextField.border"));
		panelAssociation.setBounds(315, 289, 143, 87);
		getContentPane().add(panelAssociation);
		panelAssociation.add(new JScrollPane(listAssociation), BorderLayout.CENTER);
		panelAssociation.add(listAssociation);
		
		btnChargerFichier.setBounds(23, 33, 113, 23);
		getContentPane().add(btnChargerFichier);
		
	}

	public void addBtnChargerFichierListener(ActionListener listener) {
		btnChargerFichier.addActionListener(listener); }
	
	public void addListClassSelectionListener(ListSelectionListener listener) {
		listClasses.getSelectionModel().addListSelectionListener(listener); }
	
	public void addListSousClassesSelectionListener(ListSelectionListener listener) {
		listSousClasses.getSelectionModel().addListSelectionListener(listener); }

	public void addListAttributsListener(ListSelectionListener listener) {
		listClasses.getSelectionModel().addListSelectionListener(listener); }

	public void addListMethodesSelectionListener(ListSelectionListener listener) {
		listClasses.getSelectionModel().addListSelectionListener(listener); }

	public void addListAssociationSelectionListener(ListSelectionListener listener) {
		listClasses.getSelectionModel().addListSelectionListener(listener); }

	public void setFilePathText(String filePath) { this.textFileName.setText(filePath); }
	public String getFilePathText() { return this.textFileName.getText(); }
	
	public void setListClasses(String[] classes) { listClasses.setListData(classes); }
	public int getSelectedClassIndex() { return listClasses.getSelectedIndex(); }
	
	public void setListSousClasses(String[] subclasses) { listSousClasses.setListData(subclasses); }
	public int getSelectedSubclassIndex() { return listSousClasses.getSelectedIndex(); }
	
	public void setListAttributs(String[] attributs) { listAttributs.setListData(attributs); }
	public int getSelectedAttributsIndex() { return listSousClasses.getSelectedIndex(); }
	
	public void setListMethodes(String[] methodes) { listMethodes.setListData(methodes); }
	public int getSelectedMethodesIndex() { return listMethodes.getSelectedIndex(); }

	public void setListAssociation(String[] associations) { listAssociation.setListData(associations); }
	public int getSelectedAssociationIndex() { return listAssociation.getSelectedIndex(); }
}