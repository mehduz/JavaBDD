package gui;

import server.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Dimension;
import java.awt.Window;

import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import communication.MessageIdentification;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.swing.JPasswordField;

public class Ihm_Accueil extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -684831082624221575L;
	private JTextField textField;
	private static Window frameAccueil;
	private Client client = Client.getInstance();
	private JPasswordField passwordField;

	public Client getClient() {
		return client;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frameAccueil = new Ihm_Accueil();
					frameAccueil.setVisible(true);
					} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 */
	public Ihm_Accueil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("University Manager");
		setSize(new Dimension(310, 720));
		setResizable(false);
		setVisible(true);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if("...".equals(textField.getText())) {
					textField.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if("".equals(textField.getText())) {
					textField.setText("...");
				}
			}
		});
		
		passwordField = new JPasswordField();
		passwordField.setBounds(10, 218, 280, 23);
		getContentPane().add(passwordField);
		textField.setName("");
		textField.setText("...");
		textField.setBounds(10, 163, 280, 25);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(new Color(255, 255, 255));
		lblLogin.setFont(new Font("Arial", Font.BOLD, 15));
		lblLogin.setBounds(10, 143, 100, 20);
		getContentPane().add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Arial", Font.BOLD, 15));
		lblPassword.setBounds(10, 199, 100, 20);
		getContentPane().add(lblPassword);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 130, 284, 2);
		getContentPane().add(separator);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Ihm_Accueil.class.getResource("/gui/ressources/logo-EFREI.png")));
		lblNewLabel.setBounds(10, 11, 280, 104);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				frameAccueil.setVisible(false);
				
				if("Simon".equals(textField.getText())) {
					Ihm_Eleve frameEleve = new Ihm_Eleve();
					frameEleve.setVisible(true);
					frameEleve.setPanelIdentification(textField.getText(), "Élève");
					
				} else if ("Yann".equals(textField.getText())) {
					Ihm_Professeur frameProfesseur = new Ihm_Professeur();
					frameProfesseur.setVisible(true);
					frameProfesseur.setPanelIdentification(textField.getText(), "Professeur");
					
				} else if ("Medhi".equals(textField.getText())) {
					Ihm_Administrateur frameAdministrateur = new Ihm_Administrateur();
					frameAdministrateur.setVisible(true);
					frameAdministrateur.setPanelIdentification(textField.getText(), "Administrateur");
				}				
				
				if("...".equals(textField.getText()) || "...".equals(passwordField.getText())) {
					JOptionPane.showMessageDialog(null, "Veuillez saisir votre identifiant et mot de passe.", "Erreur de connexion", JOptionPane.ERROR_MESSAGE);
				} else {
					try {
						MessageIdentification msgIdentification = new MessageIdentification(MessageIdentification.class.getName(), textField.getText(), passwordField.getText());
						client.connect(InetAddress.getByAddress(new byte[]{(byte) 192,(byte) 168,(byte)1,(byte)101}), 65530);
						client.sendMessage(msgIdentification);
						client.disconnect();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Erreur de connexion : " + e1, "Erreur de connexion", JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(10, 275, 70, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Help");
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(90, 275, 70, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Informations");
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_2.setBounds(170, 275, 120, 23);
		getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("Forgot password ? ");
		lblNewLabel_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1.setBounds(92, 250, 120, 14);
		getContentPane().add(lblNewLabel_1);
		
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

	}
}
