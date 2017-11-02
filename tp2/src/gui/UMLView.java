package gui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionListener;


public class UMLView extends JFrame {

	private JTextField textFileName = new JTextField();
	private JTextArea textDetails = new JTextArea();

	private JLabel labelClasse = new JLabel("Classes");
	private JLabel labelAttribut = new JLabel("Attributs");
	private JLabel labelMethode = new JLabel("Méthodes");
	private JLabel labelSousClasses = new JLabel("Sous-classes");
	private JLabel labelAssociation = new JLabel("Associations/agrégations");
	private JLabel labelDetails = new JLabel("Détails");
	private JLabel labelMetriques = new JLabel("Métriques");

	private JList<String> listClasses = new JList<String>();
	private JList<String> listAttributs = new JList<String>();
	private JList<String> listSousClasses = new JList<String>();
	private JList<String> listMethodes = new JList<String>();
	private JList<String> listAssociations = new JList<String>();
	private JList<String> listMetriques = new JList<String>();

	private JPanel panelClasses = new JPanel(new BorderLayout());
	private JPanel panelAttributs = new JPanel(new BorderLayout());
	private JPanel panelSousClasses = new JPanel(new BorderLayout());
	private JPanel panelMethodes = new JPanel(new BorderLayout());
	private JPanel panelAssociations = new JPanel(new BorderLayout());
	private JPanel panelDetails = new JPanel(new BorderLayout());
	private JPanel panelMetriques = new JPanel(new BorderLayout());

	private JButton btnChargerFichier = new JButton("Charger fichier");
	private JButton btnCalculerMetriques = new JButton("Calculer métriques");

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
		
		// Basic frame setup
		setAutoRequestFocus(false);
		setBounds(100, 100, 800, 601);
		setMinimumSize(new Dimension (600,400));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		
		// Padding for everything
		constraints.insets = new Insets(8,8,8,8);
		
		// Top part
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 0;
		getContentPane().add(btnChargerFichier, constraints);

		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.gridwidth= 2;
		getContentPane().add(textFileName, constraints);
		
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 3;
		constraints.gridy = 0;
		getContentPane().add(btnCalculerMetriques, constraints);

		// All others should fill all vertical space available and be roughly same size
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weighty = 0.3;

		// Preferred sizes, bit of a hack, sizes of zero will make them all equal
		Dimension d = new Dimension(0,0);
		panelClasses.setPreferredSize(new Dimension(110, 0));
		panelMetriques.setPreferredSize(new Dimension(170, 0));
		panelAttributs.setPreferredSize(d);
		panelMethodes.setPreferredSize(d);
		panelSousClasses.setPreferredSize(d);
		panelAssociations.setPreferredSize(d);
		panelDetails.setPreferredSize(d);

		// Classes
		JScrollPane scrollPane = new JScrollPane(listClasses);
		scrollPane.setBorder(UIManager.getBorder("TextField.border"));
		panelClasses.add(labelClasse, BorderLayout.PAGE_START);
		panelClasses.add(scrollPane, BorderLayout.CENTER);
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridheight = 3;
		constraints.gridwidth= 1;
		constraints.weightx = 0;
		getContentPane().add(panelClasses, constraints);
		
		// Attributs
		scrollPane = new JScrollPane(listAttributs);
		scrollPane.setBorder(UIManager.getBorder("TextField.border"));
		panelAttributs.add(labelAttribut, BorderLayout.NORTH);
		panelAttributs.add(scrollPane, BorderLayout.CENTER);
		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.gridheight = 1;
		constraints.gridwidth= 1;
		constraints.weightx = 0.3;
		getContentPane().add(panelAttributs, constraints);
		
		// Sous-classes
		scrollPane = new JScrollPane(listSousClasses);
		scrollPane.setBorder(UIManager.getBorder("TextField.border"));
		panelSousClasses.add(labelSousClasses, BorderLayout.NORTH);
		panelSousClasses.add(scrollPane, BorderLayout.CENTER);
		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridx = 1;
		constraints.gridy = 2;
		constraints.gridheight = 1;
		constraints.gridwidth= 1;
		constraints.weightx = 0.3;
		getContentPane().add(panelSousClasses, constraints);

		// Methodes
		scrollPane = new JScrollPane(listMethodes);
		scrollPane.setBorder(UIManager.getBorder("TextField.border"));
		panelMethodes.add(labelMethode, BorderLayout.NORTH);
		panelMethodes.add(scrollPane, BorderLayout.CENTER);
		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridx = 2;
		constraints.gridy = 1;
		constraints.gridheight = 1;
		constraints.gridwidth= 1;
		constraints.weightx = 0.4;
		getContentPane().add(panelMethodes, constraints);

		// Associations
		scrollPane = new JScrollPane(listAssociations);
		scrollPane.setBorder(UIManager.getBorder("TextField.border"));
		panelAssociations.add(labelAssociation, BorderLayout.NORTH);
		panelAssociations.add(scrollPane, BorderLayout.CENTER);
		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridx = 2;
		constraints.gridy = 2;
		constraints.gridheight = 1;
		constraints.gridwidth= 1;
		constraints.weightx = 0.4;
		getContentPane().add(panelAssociations, constraints);

		// Details
		textDetails.setBorder(UIManager.getBorder("TextField.border"));
		textDetails.setEditable(false);
		textDetails.setTabSize(4);
		panelDetails.add(labelDetails, BorderLayout.NORTH);
		panelDetails.add(textDetails, BorderLayout.CENTER);
		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridx = 1;
		constraints.gridy = 3;
		constraints.gridheight = 1;
		constraints.gridwidth = 2;
		constraints.weightx = 0.7;
		getContentPane().add(panelDetails, constraints);
		
		// Metriques
		scrollPane = new JScrollPane(listMetriques);
		scrollPane.setBorder(UIManager.getBorder("TextField.border"));
		panelMetriques.add(labelMetriques, BorderLayout.NORTH);
		panelMetriques.add(scrollPane, BorderLayout.CENTER);
		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridx = 3;
		constraints.gridy = 1;
		constraints.gridheight = 3;
		constraints.gridwidth= 1;
		constraints.weightx = 0;
		getContentPane().add(panelMetriques, constraints);

		// Lists should only have one element selectable at a time
		listClasses.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listAttributs.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listMethodes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSousClasses.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listAssociations.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}

	// Functions to add a listener on UI objects
	public void addBtnChargerFichierListener(ActionListener listener) {
		btnChargerFichier.addActionListener(listener); }
	public void addBtnCalculerMetriquesListener(ActionListener listener) {
		btnCalculerMetriques.addActionListener(listener); }
	public void addListClassSelectionListener(ListSelectionListener listener) {
		listClasses.getSelectionModel().addListSelectionListener(listener); }
	public void addListSousClassesSelectionListener(ListSelectionListener listener) {
		listSousClasses.getSelectionModel().addListSelectionListener(listener); }
	public void addListAttributsSelectionListener(ListSelectionListener listener) {
		listAttributs.getSelectionModel().addListSelectionListener(listener); }
	public void addListMethodesSelectionListener(ListSelectionListener listener) {
		listMethodes.getSelectionModel().addListSelectionListener(listener); }
	public void addListAssociationSelectionListener(ListSelectionListener listener) {
		listAssociations.getSelectionModel().addListSelectionListener(listener); }
	public void addListMetriquesSelectionListener(ListSelectionListener listener) {
		listMetriques.getSelectionModel().addListSelectionListener(listener); }
	
	// Setter and getter of UI list objects
	public void setFilePathText(String filePath) { this.textFileName.setText(filePath); }
	public String getFilePathText() { return this.textFileName.getText(); }
	public void setListClasses(String[] classes) { listClasses.setListData(classes); }
	public int getSelectedClassIndex() { return listClasses.getSelectedIndex(); }
	public void setListSousClasses(String[] subclasses) { listSousClasses.setListData(subclasses); }
	public int getSelectedSubclassIndex() { return listSousClasses.getSelectedIndex(); }
	public void setListAttributs(String[] attributs) { listAttributs.setListData(attributs); }
	public int getSelectedAttributsIndex() { return listAttributs.getSelectedIndex(); }
	public void setListMethodes(String[] methodes) { listMethodes.setListData(methodes); }
	public int getSelectedMethodesIndex() { return listMethodes.getSelectedIndex(); }
	public void setListAssociation(String[] associations) { listAssociations.setListData(associations); }
	public int getSelectedAssociationIndex() { return listAssociations.getSelectedIndex(); }
	public void setListMetriques(String[] metriques) { listMetriques.setListData(metriques); }
	public int getSelectedMetriqueIndex() { return listMetriques.getSelectedIndex(); }

	// Setter for "detailed" text box
	public void setDetailedText(String detailedInfos) { this.textDetails.setText(detailedInfos); }
}
