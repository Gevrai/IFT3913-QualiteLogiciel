package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MessagePopup extends JFrame {
	
	String message;
	
	JTextArea txtMessage = new JTextArea(10, 3);
	JButton btnOkay = new JButton("OK");
	
	public MessagePopup(String message) {
		this.message = message;
		initialize();
		this.setVisible(true);
	}
	
	private void initialize() {
		// View size
		this.setSize(new Dimension(500, 200));
		// Components
		Container c = this.getContentPane();
		c.setLayout(new BorderLayout());
		c.add(txtMessage, BorderLayout.CENTER);
		this.txtMessage.setText(message);
		c.add(btnOkay, BorderLayout.SOUTH);
		// Dispose on close
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.btnOkay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { closeWindow(); }
		});
	}
	
	private void closeWindow() {
		this.dispose();
	}

}
