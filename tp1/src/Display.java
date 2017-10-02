import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Display {

	private JFrame frame;
	private JTextField TextClasse;
	private JTextField TextFichier;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
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
		
		TextClasse = new JTextField();
		TextClasse.setEditable(false);
		TextClasse.setBounds(23, 120, 113, 431);
		frame.getContentPane().add(TextClasse);
		TextClasse.setColumns(10);
		
		JButton btnChargerFichier = new JButton("Charger fichier");
		btnChargerFichier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnChargerFichier.setBounds(23, 33, 113, 23);
		frame.getContentPane().add(btnChargerFichier);
		
		TextFichier = new JTextField();
		TextFichier.setBounds(146, 34, 238, 20);
		frame.getContentPane().add(TextFichier);
		TextFichier.setColumns(10);
		
		JLabel LabelAttribut = new JLabel("Attributs");
		LabelAttribut.setBounds(146, 95, 46, 14);
		frame.getContentPane().add(LabelAttribut);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(146, 120, 143, 112);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(315, 95, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(315, 120, 143, 112);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(146, 263, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(315, 263, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(146, 288, 143, 87);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(315, 288, 143, 87);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(146, 394, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(146, 419, 312, 119);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
	}
}
