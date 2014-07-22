package gui;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.io.IOException;
import java.net.URI;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;

import dal.DAOFactory;
import dal.daoImpl.AllergieDaoImpl;
import dal.daoImpl.ContactDaoImpl;
import liste.ListeClasse;
import liste.ListeContact;
import beans.Allergie;
import beans.Classe;
import beans.Contact;
import table.TableContact;

public class Ihm_Administrateur_Contact extends JFrame {

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
	private JTable table;
	private JComboBox <String> comboBox;
	
	/**
	 * Create the frame.
	 */
	public Ihm_Administrateur_Contact() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("University Manager");
		setSize(new Dimension(1280, 720));
		setResizable(false);
		setVisible(true);
		getContentPane().setLayout(null);
		
		table = TableContact.getTableContact();
		table.setOpaque(false);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setOpaque(false);
		scrollPane.setBorder(null);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBounds(314, 11, 950, 669);
		
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JLabel lblTelFixe = new JLabel("Tel fixe");
		lblTelFixe.setForeground(Color.WHITE);
		lblTelFixe.setFont(new Font("Arial", Font.BOLD, 12));
		lblTelFixe.setBounds(160, 293, 130, 20);
		getContentPane().add(lblTelFixe);
		
		textField_7 = new JTextField();
		textField_7.setName("");
		textField_7.setEnabled(true);
		textField_7.setColumns(10);
		textField_7.setBounds(160, 313, 130, 20);
		getContentPane().add(textField_7);
		
		JLabel lblAjouterModifier_4 = new JLabel("Adresse");
		lblAjouterModifier_4.setForeground(Color.WHITE);
		lblAjouterModifier_4.setFont(new Font("Arial", Font.BOLD, 12));
		lblAjouterModifier_4.setBounds(10, 333, 280, 20);
		getContentPane().add(lblAjouterModifier_4);
		
		textField_6 = new JTextField();
		textField_6.setName("");
		textField_6.setEnabled(true);
		textField_6.setColumns(10);
		textField_6.setBounds(10, 353, 280, 20);
		getContentPane().add(textField_6);
		
		JLabel lblAjouterModifier_3 = new JLabel("Tel mobile");
		lblAjouterModifier_3.setForeground(Color.WHITE);
		lblAjouterModifier_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblAjouterModifier_3.setBounds(10, 293, 130, 20);
		getContentPane().add(lblAjouterModifier_3);
		
		textField_5 = new JTextField();
		textField_5.setName("");
		textField_5.setEnabled(true);
		textField_5.setColumns(10);
		textField_5.setBounds(10, 313, 130, 20);
		getContentPane().add(textField_5);
		
		textField_4 = new JTextField();
		textField_4.setName("");
		textField_4.setEnabled(true);
		textField_4.setColumns(10);
		textField_4.setBounds(10, 273, 280, 20);
		getContentPane().add(textField_4);
		
		JLabel lblAjouterModifier_2 = new JLabel("Email");
		lblAjouterModifier_2.setForeground(Color.WHITE);
		lblAjouterModifier_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblAjouterModifier_2.setBounds(10, 253, 185, 20);
		getContentPane().add(lblAjouterModifier_2);
		
		textField_3 = new JTextField();
		textField_3.setName("");
		textField_3.setEnabled(true);
		textField_3.setColumns(10);
		textField_3.setBounds(160, 233, 130, 20);
		getContentPane().add(textField_3);
		
		JLabel lblAjouterModifier_1 = new JLabel("Prenom");
		lblAjouterModifier_1.setForeground(Color.WHITE);
		lblAjouterModifier_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblAjouterModifier_1.setBounds(160, 213, 185, 20);
		getContentPane().add(lblAjouterModifier_1);
		
		comboBox = new JComboBox();
		for (Contact c : ListeContact.getListeContact()) {
			comboBox.addItem(c.getNom() + " " + c.getPrenom());
		}
		comboBox.setSelectedItem(null);
		comboBox.setMaximumRowCount(10);
		comboBox.setBounds(10, 193, 280, 20);
		getContentPane().add(comboBox);
		
		JLabel lblAjouterModifier = new JLabel("Nom");
		lblAjouterModifier.setForeground(Color.WHITE);
		lblAjouterModifier.setFont(new Font("Arial", Font.BOLD, 12));
		lblAjouterModifier.setBounds(10, 213, 185, 20);
		getContentPane().add(lblAjouterModifier);
		
		textField_2 = new JTextField();
		textField_2.setName("");
		textField_2.setEnabled(true);
		textField_2.setColumns(10);
		textField_2.setBounds(10, 233, 130, 20);
		getContentPane().add(textField_2);
		
		JLabel lblLesAlergies = new JLabel("Nom contact");
		lblLesAlergies.setForeground(Color.WHITE);
		lblLesAlergies.setFont(new Font("Arial", Font.BOLD, 12));
		lblLesAlergies.setBounds(10, 172, 142, 20);
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
		btnMatire.setBounds(164, 413, 130, 23);
		getContentPane().add(btnMatire);
		
		JButton btnlve = new JButton("Supprimer");
		btnlve.setFont(new Font("Arial", Font.BOLD, 12));
		btnlve.setBounds(164, 384, 130, 23);
		getContentPane().add(btnlve);
		
		JButton btnContact = new JButton("Modifier");
		btnContact.setFont(new Font("Arial", Font.BOLD, 12));
		btnContact.setBounds(10, 413, 130, 23);
		getContentPane().add(btnContact);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(10, 447, 284, 2);
		getContentPane().add(separator_5);
		
		JButton btnModeSql = new JButton("Mode SQL");
		btnModeSql.setEnabled(false);
		btnModeSql.setFont(new Font("Arial", Font.BOLD, 12));
		btnModeSql.setBounds(12, 460, 282, 23);
		getContentPane().add(btnModeSql);
		
		JButton btnAlergie = new JButton("Ajouter");
		btnAlergie.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
//				ContactDaoImpl el = (ContactDaoImpl) DAOFactory.getInstance().getContactDao();		
//				Contact newContact = new Contact(
//						//ID personne
//						
//						//nom prenom email
//						textField_2.getText(), textField_3.getText(), textField_4.getText(),
//						//tel fixe mobile
//						textField_7.getText(), textField_5.getText(), 
//						//ID cont
//						
//						//adresse
//						textField_6.getText());
//				
//				try {
//					el.creer(newContact);
//				} catch (Exception eA) {}
//				
//				myRepaint();
				
			}
		});
		btnAlergie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAlergie.setFont(new Font("Arial", Font.BOLD, 12));
		btnAlergie.setBounds(10, 384, 130, 23);
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
		textField_1.setEnabled(true);
		textField_1.setColumns(10);
		textField_1.setBounds(48, 611, 246, 15);
		getContentPane().add(textField_1);
		
		textField = new JTextField();
		textField.setEnabled(true);
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
		
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				int x = comboBox.getSelectedIndex();
				textField_2.setText(table.getValueAt(x, 1).toString());
				textField_7.setText(table.getValueAt(x, 5).toString());
				textField_6.setText(table.getValueAt(x, 3).toString());
				textField_5.setText(table.getValueAt(x, 6).toString());
				textField_4.setText(table.getValueAt(x, 4).toString());
				textField_3.setText(table.getValueAt(x, 2).toString());
				repaint();
			}
		});

	}
	
	public void myRepaint() {
		this.setVisible(false);
		Ihm_Administrateur_Allergie ihm = new Ihm_Administrateur_Allergie();
	}
	
	public void setPanelIdentification(String login, String profil) {
		textField.setText(login);
		textField_1.setText(profil);
	}
	
}
