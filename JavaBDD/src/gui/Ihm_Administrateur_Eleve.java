package gui;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Dimension;

import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.io.IOException;
import java.net.URI;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

import table.TableEleve;

import javax.swing.JTable;

import liste.ListeEleve;
import beans.Eleve;
import communication.ResponseEvent;
import communication.ResponseListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Ihm_Administrateur_Eleve extends JFrame implements ResponseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -684831082624221575L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTable table;
	private JComboBox <String> comboBox;
	

	/**
	 * Create the frame.
	 */
	public Ihm_Administrateur_Eleve() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("University Manager");
		setSize(new Dimension(1280, 720));
		setResizable(false);
		setVisible(true);
		getContentPane().setLayout(null);
		
		table = TableEleve.getTableEleve();
		table.setOpaque(false);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setOpaque(false);
		scrollPane.setBorder(null);
		scrollPane.getViewport().setOpaque(false);
		
		JButton btnRemarquesMdecin = new JButton("Valider notes");
		btnRemarquesMdecin.setFont(new Font("Arial", Font.BOLD, 10));
		btnRemarquesMdecin.setBounds(162, 416, 133, 23);
		getContentPane().add(btnRemarquesMdecin);
		scrollPane.setBounds(314, 11, 950, 669);
		
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JButton btnValider = new JButton("M\u00E9dical");
		btnValider.setFont(new Font("Arial", Font.BOLD, 8));
		btnValider.setBounds(225, 442, 70, 23);
		getContentPane().add(btnValider);
		
		JLabel lblClasse = new JLabel("Classe");
		lblClasse.setForeground(Color.WHITE);
		lblClasse.setFont(new Font("Arial", Font.BOLD, 12));
		lblClasse.setBounds(10, 295, 130, 20);
		getContentPane().add(lblClasse);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setMaximumRowCount(10);
		comboBox_2.setBounds(10, 315, 184, 20);
		getContentPane().add(comboBox_2);
		
		JLabel lblTelMobile = new JLabel("Tel mobile");
		lblTelMobile.setForeground(Color.WHITE);
		lblTelMobile.setFont(new Font("Arial", Font.BOLD, 12));
		lblTelMobile.setBounds(210, 255, 90, 20);
		getContentPane().add(lblTelMobile);
		
		JButton btnPhoto = new JButton("Photo");
		btnPhoto.setFont(new Font("Arial", Font.BOLD, 8));
		btnPhoto.setBounds(162, 442, 58, 23);
		getContentPane().add(btnPhoto);
		
		textField_13 = new JTextField();
		textField_13.setName("");
		textField_13.setEnabled(false);
		textField_13.setColumns(10);
		textField_13.setBounds(65, 436, 70, 20);
		getContentPane().add(textField_13);
		
		JLabel lblCodePostale = new JLabel("Cpostal");
		lblCodePostale.setForeground(Color.WHITE);
		lblCodePostale.setFont(new Font("Arial", Font.BOLD, 12));
		lblCodePostale.setBounds(10, 416, 74, 20);
		getContentPane().add(lblCodePostale);
		
		textField_12 = new JTextField();
		textField_12.setName("");
		textField_12.setEnabled(false);
		textField_12.setColumns(10);
		textField_12.setBounds(10, 436, 50, 20);
		getContentPane().add(textField_12);
		
		JLabel lblVille = new JLabel("Ville");
		lblVille.setForeground(Color.WHITE);
		lblVille.setFont(new Font("Arial", Font.BOLD, 12));
		lblVille.setBounds(65, 416, 70, 20);
		getContentPane().add(lblVille);
		
		JLabel lblRue = new JLabel("Rue");
		lblRue.setForeground(Color.WHITE);
		lblRue.setFont(new Font("Arial", Font.BOLD, 12));
		lblRue.setBounds(162, 374, 129, 20);
		getContentPane().add(lblRue);
		
		textField_11 = new JTextField();
		textField_11.setName("");
		textField_11.setEnabled(false);
		textField_11.setColumns(10);
		textField_11.setBounds(162, 394, 129, 20);
		getContentPane().add(textField_11);
		
		textField_10 = new JTextField();
		textField_10.setName("");
		textField_10.setEnabled(false);
		textField_10.setColumns(10);
		textField_10.setBounds(210, 315, 85, 20);
		getContentPane().add(textField_10);
		
		JLabel lblDateDinscription = new JLabel("Inscription");
		lblDateDinscription.setForeground(Color.WHITE);
		lblDateDinscription.setFont(new Font("Arial", Font.BOLD, 12));
		lblDateDinscription.setBounds(210, 295, 85, 20);
		getContentPane().add(lblDateDinscription);
		
		JLabel lblSexe = new JLabel("Sexe");
		lblSexe.setForeground(Color.WHITE);
		lblSexe.setFont(new Font("Arial", Font.BOLD, 12));
		lblSexe.setBounds(161, 335, 130, 20);
		getContentPane().add(lblSexe);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setMaximumRowCount(10);
		comboBox_1.setBounds(161, 356, 130, 20);
		getContentPane().add(comboBox_1);
		
		textField_9 = new JTextField();
		textField_9.setName("");
		textField_9.setEnabled(false);
		textField_9.setColumns(10);
		textField_9.setBounds(10, 355, 129, 20);
		getContentPane().add(textField_9);
		
		JLabel lblVilleNaissance_1 = new JLabel("Ville naissance");
		lblVilleNaissance_1.setForeground(Color.WHITE);
		lblVilleNaissance_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblVilleNaissance_1.setBounds(10, 335, 129, 20);
		getContentPane().add(lblVilleNaissance_1);
		
		textField_8 = new JTextField();
		textField_8.setName("");
		textField_8.setEnabled(false);
		textField_8.setColumns(10);
		textField_8.setBounds(210, 275, 84, 20);
		getContentPane().add(textField_8);
		
		JLabel lblVilleNaissance = new JLabel("Pays naissance");
		lblVilleNaissance.setForeground(Color.WHITE);
		lblVilleNaissance.setFont(new Font("Arial", Font.BOLD, 12));
		lblVilleNaissance.setBounds(10, 374, 129, 20);
		getContentPane().add(lblVilleNaissance);
		
		textField_7 = new JTextField();
		textField_7.setName("");
		textField_7.setEnabled(false);
		textField_7.setColumns(10);
		textField_7.setBounds(10, 394, 129, 20);
		getContentPane().add(textField_7);
		
		JLabel lblAjouterModifier_4 = new JLabel("Tel fixe");
		lblAjouterModifier_4.setForeground(Color.WHITE);
		lblAjouterModifier_4.setFont(new Font("Arial", Font.BOLD, 12));
		lblAjouterModifier_4.setBounds(110, 255, 90, 20);
		getContentPane().add(lblAjouterModifier_4);
		
		textField_6 = new JTextField();
		textField_6.setName("");
		textField_6.setEnabled(false);
		textField_6.setColumns(10);
		textField_6.setBounds(110, 275, 90, 20);
		getContentPane().add(textField_6);
		
		JLabel lblAjouterModifier_3 = new JLabel("Date naissance");
		lblAjouterModifier_3.setForeground(Color.WHITE);
		lblAjouterModifier_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblAjouterModifier_3.setBounds(10, 255, 129, 20);
		getContentPane().add(lblAjouterModifier_3);
		
		textField_5 = new JTextField();
		textField_5.setName("");
		textField_5.setEnabled(false);
		textField_5.setColumns(10);
		textField_5.setBounds(10, 275, 90, 20);
		getContentPane().add(textField_5);
		
		textField_4 = new JTextField();
		textField_4.setName("");
		textField_4.setEnabled(false);
		textField_4.setColumns(10);
		textField_4.setBounds(10, 233, 129, 20);
		getContentPane().add(textField_4);
		
		JLabel lblAjouterModifier_2 = new JLabel("Email");
		lblAjouterModifier_2.setForeground(Color.WHITE);
		lblAjouterModifier_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblAjouterModifier_2.setBounds(10, 213, 129, 20);
		getContentPane().add(lblAjouterModifier_2);
		
		textField_3 = new JTextField();
		textField_3.setName("");
		textField_3.setEnabled(false);
		textField_3.setColumns(10);
		textField_3.setBounds(160, 233, 130, 20);
		getContentPane().add(textField_3);
		
		JLabel lblAjouterModifier_1 = new JLabel("Prenom");
		lblAjouterModifier_1.setForeground(Color.WHITE);
		lblAjouterModifier_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblAjouterModifier_1.setBounds(160, 213, 129, 20);
		getContentPane().add(lblAjouterModifier_1);
		
		comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				int x = comboBox.getSelectedIndex();
				//textField_2.setText(table.getValueAt(x, 0).toString());			
			}
		});
		
		for (Eleve e : ListeEleve.getListeEleve()) {
			comboBox.addItem((e.getNom()) + " " + e.getPrenom());
		}
		comboBox.setMaximumRowCount(10);
		comboBox.setBounds(10, 193, 130, 20);
		getContentPane().add(comboBox);
		
		JLabel lblAjouterModifier = new JLabel("Nom");
		lblAjouterModifier.setForeground(Color.WHITE);
		lblAjouterModifier.setFont(new Font("Arial", Font.BOLD, 12));
		lblAjouterModifier.setBounds(160, 172, 129, 20);
		getContentPane().add(lblAjouterModifier);
		
		textField_2 = new JTextField();
		textField_2.setName("");
		textField_2.setEnabled(true);
		textField_2.setColumns(10);
		textField_2.setBounds(160, 192, 130, 20);
		getContentPane().add(textField_2);
		
		JLabel lblLesAlergies = new JLabel("Nom \u00E9l\u00E8ve");
		lblLesAlergies.setForeground(Color.WHITE);
		lblLesAlergies.setFont(new Font("Arial", Font.BOLD, 12));
		lblLesAlergies.setBounds(10, 172, 130, 20);
		getContentPane().add(lblLesAlergies);
		
		JButton btnMatire = new JButton("Retour");
		btnMatire.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				Ihm_Administrateur_AjoutModificationSupressionBDD frameAdministrateur_AjoutModificationSupressionBDD = new Ihm_Administrateur_AjoutModificationSupressionBDD();
				frameAdministrateur_AjoutModificationSupressionBDD.setVisible(true);
			}
		});
		btnMatire.setFont(new Font("Arial", Font.BOLD, 12));
		btnMatire.setBounds(164, 496, 130, 23);
		getContentPane().add(btnMatire);
		
		JButton btnlve = new JButton("Supprimer");
		btnlve.setFont(new Font("Arial", Font.BOLD, 12));
		btnlve.setBounds(164, 467, 130, 23);
		getContentPane().add(btnlve);
		
		JButton btnContact = new JButton("Modifier");
		btnContact.setFont(new Font("Arial", Font.BOLD, 12));
		btnContact.setBounds(10, 496, 130, 23);
		getContentPane().add(btnContact);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(10, 530, 284, 2);
		getContentPane().add(separator_5);
		
		JButton btnModeSql = new JButton("Mode SQL");
		btnModeSql.setEnabled(false);
		btnModeSql.setFont(new Font("Arial", Font.BOLD, 12));
		btnModeSql.setBounds(12, 543, 282, 23);
		getContentPane().add(btnModeSql);
		
		JButton btnAlergie = new JButton("Ajouter");
		btnAlergie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAlergie.setFont(new Font("Arial", Font.BOLD, 12));
		btnAlergie.setBounds(10, 467, 130, 23);
		getContentPane().add(btnAlergie);
		
		JButton btnAjouter = new JButton("Ajouter / Modifier / Supprimer");
		btnAjouter.setFont(new Font("Arial", Font.BOLD, 12));
		btnAjouter.setBounds(10, 143, 282, 23);
		getContentPane().add(btnAjouter);
		
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
		textField_1.setBounds(48, 611, 246, 15);
		getContentPane().add(textField_1);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(48, 590, 246, 15);
		getContentPane().add(textField);
		textField.setColumns(10);
		
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
