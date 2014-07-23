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
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;

import liste.ListeContact;
import liste.ListeMatiere;
import beans.Contact;
import beans.Eleve;
import beans.Matiere;
import beans.Professeur;
import communication.ResponseEvent;
import communication.ResponseListener;
import dal.DAOFactory;
import dal.daoImpl.EleveDaoImpl;
import dal.daoImpl.ProfesseurDaoImpl;
import enums.GlobalProperties;
import table.TableEleve;
import table.TableMatiere;

public class Ihm_Administrateur_Matiere extends JFrame implements ResponseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -684831082624221575L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	JComboBox <String> comboBox;
	
	/**
	 * Create the frame.
	 */
	public Ihm_Administrateur_Matiere() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("University Manager");
		setSize(new Dimension(1280, 720));
		setResizable(false);
		setVisible(true);
		getContentPane().setLayout(null);
		
		table = TableMatiere.getTableMatiere();
		table.setOpaque(false);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setOpaque(false);
		scrollPane.setBorder(null);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBounds(314, 11, 950, 669);
		
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		textField_3 = new JTextField();
		textField_3.setName("");
		textField_3.setEnabled(true);
		textField_3.setColumns(10);
		textField_3.setBounds(10, 285, 280, 25);
		getContentPane().add(textField_3);
		
		JLabel lblProfesseurAssoci = new JLabel("Professeur associ\u00E9");
		lblProfesseurAssoci.setForeground(Color.WHITE);
		lblProfesseurAssoci.setFont(new Font("Arial", Font.BOLD, 15));
		lblProfesseurAssoci.setBounds(10, 264, 185, 20);
		getContentPane().add(lblProfesseurAssoci);
		
		comboBox = new JComboBox();
		for (Matiere m : ListeMatiere.getListeMatiere()) {
			comboBox.addItem(m.getNom_matiere());
		}
		comboBox.setSelectedItem(null);
		comboBox.setMaximumRowCount(10);
		comboBox.setBounds(10, 193, 280, 25);
		getContentPane().add(comboBox);
		
		JLabel lblAjouterModifier = new JLabel("Mati\u00E8res");
		lblAjouterModifier.setForeground(Color.WHITE);
		lblAjouterModifier.setFont(new Font("Arial", Font.BOLD, 15));
		lblAjouterModifier.setBounds(10, 218, 185, 20);
		getContentPane().add(lblAjouterModifier);
		
		textField_2 = new JTextField();
		textField_2.setName("");
		textField_2.setEnabled(true);
		textField_2.setColumns(10);
		textField_2.setBounds(10, 239, 280, 25);
		getContentPane().add(textField_2);
		
		JLabel lblLesAlergies = new JLabel("Les mati\u00E8res");
		lblLesAlergies.setForeground(Color.WHITE);
		lblLesAlergies.setFont(new Font("Arial", Font.BOLD, 15));
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
		btnMatire.setBounds(164, 350, 130, 23);
		getContentPane().add(btnMatire);
		
		JButton btnlve = new JButton("Supprimer");
		btnlve.setFont(new Font("Arial", Font.BOLD, 12));
		btnlve.setBounds(164, 321, 130, 23);
		getContentPane().add(btnlve);
		
		JButton btnContact = new JButton("Modifier");
		btnContact.setFont(new Font("Arial", Font.BOLD, 12));
		btnContact.setBounds(10, 350, 130, 23);
		getContentPane().add(btnContact);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(10, 384, 284, 2);
		getContentPane().add(separator_5);
		
		JButton btnModeSql = new JButton("Mode SQL");
		btnModeSql.setEnabled(false);
		btnModeSql.setFont(new Font("Arial", Font.BOLD, 12));
		btnModeSql.setBounds(12, 397, 282, 23);
		getContentPane().add(btnModeSql);
		
		JButton btnAlergie = new JButton("Ajouter");
		btnAlergie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAlergie.setFont(new Font("Arial", Font.BOLD, 12));
		btnAlergie.setBounds(10, 321, 130, 23);
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
		
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				int x = comboBox.getSelectedIndex();
				textField_2.setText(table.getValueAt(x, 0).toString());
				
				ProfesseurDaoImpl prof = (ProfesseurDaoImpl) DAOFactory.getInstance().getProfesseurDao();
				ArrayList<Professeur> listeProf = prof.getAllParMatiere(table.getValueAt(x, 0).toString());		
				String profAssocie = "";
				for (int i = 0; i < listeProf.size(); i ++) {
					profAssocie += listeProf.get(i).getNom();
				}
				textField_3.setText(profAssocie);
				repaint();
			}
		});	

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
