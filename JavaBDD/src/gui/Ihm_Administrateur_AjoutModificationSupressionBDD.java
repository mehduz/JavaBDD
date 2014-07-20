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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.io.IOException;
import java.net.URI;

import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JComboBox;

import liste.ListeAllergie;
import liste.ListeClasse;
import liste.ListeMatiere;
import beans.Allergie;
import beans.Classe;
import beans.Matiere;
import communication.ResponseEvent;
import communication.ResponseListener;

public class Ihm_Administrateur_AjoutModificationSupressionBDD extends JFrame implements ResponseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -684831082624221575L;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the frame.
	 */
	public Ihm_Administrateur_AjoutModificationSupressionBDD() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("University Manager");
		setSize(new Dimension(1280, 720));
		setResizable(false);
		setVisible(true);
		getContentPane().setLayout(null);
		
		JButton btnVaccin = new JButton("Vaccin");
		btnVaccin.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				Ihm_Administrateur_Vaccin frameAdministrateur_Vacin = new Ihm_Administrateur_Vaccin();
				frameAdministrateur_Vacin.setVisible(true);
			}
		});
		
		JButton button_3 = new JButton("Liste \u00E9l\u00E8ves par mati\u00E8res");
		button_3.setFont(new Font("Arial", Font.BOLD, 12));
		button_3.setBounds(12, 496, 282, 23);
		getContentPane().add(button_3);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 454, 284, 2);
		getContentPane().add(separator_3);
		
		JComboBox <String> comboBox_1 = new JComboBox();
		for (Matiere m : ListeMatiere.getListeMatiere()) {
			comboBox_1.addItem(m.getNom_matiere());
		}
		comboBox_1.setMaximumRowCount(10);
		comboBox_1.setBounds(10, 467, 280, 25);
		getContentPane().add(comboBox_1);
		
		JComboBox comboBox = new JComboBox();
		for (Classe c : ListeClasse.getListeClasse()) {
			comboBox.addItem(c.getNom_classe());
		}
		comboBox.setMaximumRowCount(10);
		comboBox.setBounds(10, 390, 280, 25);
		getContentPane().add(comboBox);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(10, 377, 284, 2);
		getContentPane().add(separator_6);
		
		JButton button = new JButton("Liste \u00E9l\u00E8ves pas classe");
		button.setFont(new Font("Arial", Font.BOLD, 12));
		button.setBounds(10, 420, 282, 23);
		getContentPane().add(button);
		btnVaccin.setFont(new Font("Arial", Font.BOLD, 12));
		btnVaccin.setBounds(84, 346, 130, 23);
		getContentPane().add(btnVaccin);
		
		JButton btnProfesseur = new JButton("Professeur");
		btnProfesseur.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				Ihm_Administrateur_Professeur frameAdministrateur_Professeur = new Ihm_Administrateur_Professeur();
				frameAdministrateur_Professeur.setVisible(true);
			}
		});
		btnProfesseur.setFont(new Font("Arial", Font.BOLD, 12));
		btnProfesseur.setBounds(84, 317, 130, 23);
		getContentPane().add(btnProfesseur);
		
		JButton btnMdecin = new JButton("M\u00E9decin");
		btnMdecin.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				Ihm_Administrateur_Medecin frameAdministrateur_Medecin = new Ihm_Administrateur_Medecin();
				frameAdministrateur_Medecin.setVisible(true);
			}
		});
		btnMdecin.setFont(new Font("Arial", Font.BOLD, 12));
		btnMdecin.setBounds(84, 288, 130, 23);
		getContentPane().add(btnMdecin);
		
		JButton btnMatire = new JButton("Mati\u00E8re");
		btnMatire.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				Ihm_Administrateur_Matiere frameAdministrateur_Matierre = new Ihm_Administrateur_Matiere();
				frameAdministrateur_Matierre.setVisible(true);
			}
		});
		btnMatire.setFont(new Font("Arial", Font.BOLD, 12));
		btnMatire.setBounds(84, 259, 130, 23);
		getContentPane().add(btnMatire);
		
		JButton btnlve = new JButton("\u00C9l\u00E8ve");
		btnlve.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				Ihm_Administrateur_Eleve frameAdministrateur_Eleve = new Ihm_Administrateur_Eleve();
				frameAdministrateur_Eleve.setVisible(true);
			}
		});
		btnlve.setFont(new Font("Arial", Font.BOLD, 12));
		btnlve.setBounds(84, 230, 130, 23);
		getContentPane().add(btnlve);
		
		JButton btnContact = new JButton("Contact");
		btnContact.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				Ihm_Administrateur_Contact frameAdministrateur_Contact = new Ihm_Administrateur_Contact();
				frameAdministrateur_Contact.setVisible(true);
			}
		});
		btnContact.setFont(new Font("Arial", Font.BOLD, 12));
		btnContact.setBounds(84, 201, 130, 23);
		getContentPane().add(btnContact);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(10, 530, 284, 2);
		getContentPane().add(separator_5);
		
		JButton btnModeSql = new JButton("Mode SQL");
		btnModeSql.setEnabled(false);
		btnModeSql.setFont(new Font("Arial", Font.BOLD, 12));
		btnModeSql.setBounds(12, 543, 282, 23);
		getContentPane().add(btnModeSql);
		
		JButton btnAlergie = new JButton("Allergie");
		btnAlergie.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				Ihm_Administrateur_Allergie frameAdministrateur_Allergie = new Ihm_Administrateur_Allergie();
				frameAdministrateur_Allergie.setVisible(true);
			}
		});
		btnAlergie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Ihm_Administrateur frameAdministrateur = new Ihm_Administrateur();
				frameAdministrateur.setVisible(true);
			}
		});
		btnAlergie.setFont(new Font("Arial", Font.BOLD, 12));
		btnAlergie.setBounds(84, 172, 130, 23);
		getContentPane().add(btnAlergie);
		
		JButton btnAjouter = new JButton("Ajouter / Modifier / Supprimer");
		btnAjouter.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				Ihm_Administrateur frameAdministrateur = new Ihm_Administrateur();
				frameAdministrateur.setVisible(true);
			}
		});
		btnAjouter.setFont(new Font("Arial", Font.BOLD, 12));
		btnAjouter.setBounds(10, 143, 282, 23);
		getContentPane().add(btnAjouter);
		
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
