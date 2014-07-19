package gui;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Desktop;
import java.awt.Font;
import java.awt.Dimension;

import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.JPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;

import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.UIManager;
import javax.swing.ListSelectionModel;

import java.awt.ComponentOrientation;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Ihm_Professeur_ConsulterNotesTutores extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -684831082624221575L;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the frame.
	 */
	public Ihm_Professeur_ConsulterNotesTutores() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("University Manager");
		setSize(new Dimension(1280, 720));
		setResizable(false);
		setVisible(true);
		getContentPane().setLayout(null);
		
		JLabel lblVosMatires = new JLabel("Vos tutor\u00E9s");
		lblVosMatires.setForeground(Color.WHITE);
		lblVosMatires.setFont(new Font("Arial", Font.BOLD, 15));
		lblVosMatires.setBounds(8, 222, 142, 20);
		getContentPane().add(lblVosMatires);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setMaximumRowCount(10);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Romain", "Yann", "Simon", "Medhi"}));
		comboBox.setBounds(8, 243, 280, 25);
		getContentPane().add(comboBox);
		
		JButton btnConfirm = new JButton("Confirmer");
		btnConfirm.setFont(new Font("Arial", Font.BOLD, 12));
		btnConfirm.setBounds(77, 279, 130, 23);
		getContentPane().add(btnConfirm);
		
		JPanel panel = new JPanel();
		panel.setBounds(322, 20, 932, 651);
		getContentPane().add(panel);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(8, 577, 284, 2);
		getContentPane().add(separator_4);
		
		JButton button_2 = new JButton("Informations");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				URI uri = URI.create("http://www.efrei.fr/programme-cycle-ingenieur-par-apprentissage#.U8pn7vl_uBo");
				try {
					Desktop.getDesktop().browse(uri);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_2.setFont(new Font("Arial", Font.BOLD, 12));
		button_2.setBounds(174, 634, 120, 23);
		getContentPane().add(button_2);
		
		JButton button_1 = new JButton("Help");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				URI uri = URI.create("http://www.efrei.fr/");
				try {
					Desktop.getDesktop().browse(uri);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_1.setFont(new Font("Arial", Font.BOLD, 12));
		button_1.setBounds(94, 634, 70, 23);
		getContentPane().add(button_1);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				Ihm_Accueil frameAccueil = new Ihm_Accueil();
				frameAccueil.setVisible(true);
			}
		});
		btnLogout.setFont(new Font("Arial", Font.BOLD, 12));
		btnLogout.setBounds(8, 634, 76, 23);
		getContentPane().add(btnLogout);
		
		JLabel lblProfil = new JLabel("Profil");
		lblProfil.setFont(new Font("Arial", Font.BOLD, 12));
		lblProfil.setForeground(Color.WHITE);
		lblProfil.setBounds(8, 611, 46, 14);
		getContentPane().add(lblProfil);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Arial", Font.BOLD, 12));
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setBounds(8, 590, 46, 14);
		getContentPane().add(lblLogin);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		textField_1.setBounds(46, 611, 246, 15);
		getContentPane().add(textField_1);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(46, 590, 246, 15);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(8, 177, 284, 2);
		getContentPane().add(separator_3);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(302, 0, 2, 690);
		getContentPane().add(separator_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 130, 284, 2);
		getContentPane().add(separator);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Ihm_Accueil.class.getResource("/gui/ressources/logo-EFREI.png")));
		lblNewLabel.setBounds(10, 11, 280, 104);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("MAJ notes de vos mati\u00E8res");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				Ihm_Professeur_MajNotes frameProfesseur_MajNotes = new Ihm_Professeur_MajNotes();
				frameProfesseur_MajNotes.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton.setBounds(10, 143, 282, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Consulter notes de vos tutot\u00E9s");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				Ihm_Professeur frameProfesseur = new Ihm_Professeur();
				frameProfesseur.setVisible(true);
			}
		});		
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_1.setBounds(8, 190, 282, 23);
		getContentPane().add(btnNewButton_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 663, 284, 2);
		getContentPane().add(separator_1);
		
		JLabel lblUniversityManager = new JLabel("University Manager V.1.0");
		lblUniversityManager.setForeground(new Color(255, 255, 255));
		lblUniversityManager.setBounds(77, 666, 150, 14);
		getContentPane().add(lblUniversityManager);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Ihm_Accueil.class.getResource("/gui/ressources/fond.jpg")));
		lblNewLabel_2.setBounds(0, 0, 304, 691);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Ihm_Eleve.class.getResource("/gui/ressources/fond_principal.jpg")));
		lblNewLabel_3.setBounds(300, 0, 974, 691);
		getContentPane().add(lblNewLabel_3);

	}
	
	public void setPanelIdentification(String login, String profil) {
		textField.setText(login);
		textField_1.setText(profil);
	}
}
