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

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import communication.ResponseEvent;
import communication.ResponseListener;
import enums.GlobalProperties;

public class Ihm_Professeur_MajNotes extends JFrame implements ResponseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -684831082624221575L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the frame.
	 */
	public Ihm_Professeur_MajNotes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("University Manager");
		setSize(new Dimension(1280, 720));
		setResizable(false);
		setVisible(true);
		getContentPane().setLayout(null);
		
		JButton button = new JButton("Convoquer ");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				Ihm_Professeur_Convoquer frameProfesseurConvoquer = new Ihm_Professeur_Convoquer();
				frameProfesseurConvoquer.setVisible(true);
			}
		});
		button.setFont(new Font("Arial", Font.BOLD, 12));
		button.setBounds(14, 484, 282, 23);
		getContentPane().add(button);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(12, 471, 284, 2);
		getContentPane().add(separator_5);
		
		JLabel lblVosMatires = new JLabel("Vos mati\u00E8res");
		lblVosMatires.setForeground(Color.WHITE);
		lblVosMatires.setFont(new Font("Arial", Font.BOLD, 15));
		lblVosMatires.setBounds(12, 177, 142, 20);
		getContentPane().add(lblVosMatires);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setMaximumRowCount(10);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"BDD", "JAVA", "SDD", "ADD"}));
		comboBox.setBounds(12, 198, 280, 25);
		getContentPane().add(comboBox);
		
		JButton btnConfirm = new JButton("Confirmer");
		btnConfirm.setFont(new Font("Arial", Font.BOLD, 12));
		btnConfirm.setBounds(84, 390, 130, 23);
		getContentPane().add(btnConfirm);
		
		textField_4 = new JTextField();
		textField_4.setText("...");
		textField_4.setName("");
		textField_4.setColumns(10);
		textField_4.setBounds(12, 354, 280, 25);
		getContentPane().add(textField_4);
		
		JLabel lblModifierValeur = new JLabel("Modifier valeur");
		lblModifierValeur.setForeground(Color.WHITE);
		lblModifierValeur.setFont(new Font("Arial", Font.BOLD, 15));
		lblModifierValeur.setBounds(12, 333, 142, 20);
		getContentPane().add(lblModifierValeur);
		
		JLabel lblValeurActuelle = new JLabel("Valeur actuelle");
		lblValeurActuelle.setForeground(Color.WHITE);
		lblValeurActuelle.setFont(new Font("Arial", Font.BOLD, 15));
		lblValeurActuelle.setBounds(12, 281, 142, 20);
		getContentPane().add(lblValeurActuelle);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setName("");
		textField_3.setColumns(10);
		textField_3.setBounds(12, 302, 280, 25);
		getContentPane().add(textField_3);
		
		JLabel lblChampSelection = new JLabel("Champ s\u00E9lectionn\u00E9");
		lblChampSelection.setForeground(Color.WHITE);
		lblChampSelection.setFont(new Font("Arial", Font.BOLD, 15));
		lblChampSelection.setBounds(12, 229, 142, 20);
		getContentPane().add(lblChampSelection);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setName("");
		textField_2.setColumns(10);
		textField_2.setBounds(12, 250, 280, 25);
		getContentPane().add(textField_2);
		
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
				Ihm_Accueil frameAccueil = (Ihm_Accueil) GlobalProperties.getProperty(enums.Properties.FRAME_ACCUEIL);
				if(frameAccueil == null)frameAccueil = new Ihm_Accueil();
				setVisible(false);
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
		separator_3.setBounds(12, 424, 284, 2);
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
				Ihm_Professeur frameProfesseur = new Ihm_Professeur();
				frameProfesseur.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(10, 143, 282, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Consulter notes de vos tutot\u00E9s");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				Ihm_Professeur_ConsulterNotesTutores frameProfesseurConsulterNotesTutores = new Ihm_Professeur_ConsulterNotesTutores();
				frameProfesseurConsulterNotesTutores.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(14, 437, 282, 23);
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

	@Override
	public void onResponseReceived(ResponseEvent re) {
		// TODO Auto-generated method stub
		
	}
}
