package gui;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
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
import javax.swing.JComboBox;

import liste.ListeClasse;
import liste.ListeEleveParClasse;
import liste.ListeEleveParMatiere;
import liste.ListeMatiere;
import beans.Classe;
import beans.Matiere;
import communication.ResponseEvent;
import communication.ResponseListener;
import enums.GlobalProperties;

public class Ihm_Administrateur extends JFrame implements ResponseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -684831082624221575L;
	private JTextField textField;
	private JTextField textField_1;
	private JTable liste;
	private JComboBox comboBox, comboBox_1;
	private JScrollPane scrollPane;

	/**
	 * Create the frame.
	 */
	public Ihm_Administrateur() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("University Manager");
		setSize(new Dimension(1280, 720));
		setResizable(false);
		setVisible(true);
		getContentPane().setLayout(null);

		//
		comboBox = new JComboBox();
		for (Classe c : ListeClasse.getListeClasse()) {
			comboBox.addItem(c.getNom_classe());
		}
		
		JLabel lblListelvesPar = new JLabel("Liste \u00E9l\u00E8ves par mati\u00E8res");
		lblListelvesPar.setForeground(Color.WHITE);
		lblListelvesPar.setFont(new Font("Arial", Font.BOLD, 15));
		lblListelvesPar.setBounds(6, 259, 193, 20);
		getContentPane().add(lblListelvesPar);
		
		JLabel lblListelvesPas = new JLabel("Liste \u00E9l\u00E8ves pas classe");
		lblListelvesPas.setForeground(Color.WHITE);
		lblListelvesPas.setFont(new Font("Arial", Font.BOLD, 15));
		lblListelvesPas.setBounds(6, 190, 180, 20);
		getContentPane().add(lblListelvesPas);
		comboBox.setMaximumRowCount(10);
		comboBox.setBounds(6, 210, 280, 25);
		getContentPane().add(comboBox);
		comboBox.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
				
		    	liste = new JTable();
		    	liste = ListeEleveParClasse.getListeEleveParClasse(comboBox.getSelectedItem().toString());
				scrollPane.setViewportView(liste);
		    	
		    }
		});
		
		//
		comboBox_1 = new JComboBox();
		for (Matiere m : ListeMatiere.getListeMatiere()) {
			comboBox_1.addItem(m.getNom_matiere());
		}
		comboBox_1.setMaximumRowCount(10);
		comboBox_1.setBounds(6, 280, 280, 25);
		getContentPane().add(comboBox_1);
		comboBox_1.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
				
		    	liste = new JTable();
		    	liste = ListeEleveParMatiere.getListeEleveParMatiere(comboBox_1.getSelectedItem().toString());
				scrollPane.setViewportView(liste);
		    	
		    }
		});
		
		//
		liste = ListeEleveParClasse.getListeEleveParClasse(comboBox.getSelectedItem().toString());
		liste.setOpaque(false);
		
		scrollPane = new JScrollPane(liste);
		scrollPane.setBounds(314, 11, 950, 669);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		scrollPane.setBorder(null);
		getContentPane().add(scrollPane);
		
		//		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(6, 316, 284, 2);
		getContentPane().add(separator_6);
		
		JButton button_4 = new JButton("Mode SQL");
		button_4.setFont(new Font("Arial", Font.BOLD, 12));
		button_4.setEnabled(false);
		button_4.setBounds(8, 329, 282, 23);
		getContentPane().add(button_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(6, 246, 284, 2);
		getContentPane().add(separator_5);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(6, 177, 284, 2);
		getContentPane().add(separator_3);
		
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
		
		JButton btnNewButton = new JButton("Ajouter / Modifier / Supprimer");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				Ihm_Administrateur_AjoutModificationSupressionBDD frameAdministrateur_Ajout_Modification_SupressionBDD = new Ihm_Administrateur_AjoutModificationSupressionBDD();
				frameAdministrateur_Ajout_Modification_SupressionBDD.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(10, 143, 282, 23);
		getContentPane().add(btnNewButton);
		
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
