package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JTableExample extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -684831082624221575L;

	/**
	 * Create the frame.
	 */
	public JTableExample() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("University Manager");
		setSize(new Dimension(1280, 720));
		setResizable(false);
		setVisible(true);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(322, 20, 932, 651);
		getContentPane().add(panel);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Ihm_Eleve.class.getResource("/gui/ressources/fond_principal.jpg")));
		lblNewLabel_3.setBounds(300, 0, 974, 691);
		getContentPane().add(lblNewLabel_3);

	}

}
