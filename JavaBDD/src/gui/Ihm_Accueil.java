package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Desktop;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Window;

import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import beans.Personne;
import communication.MessageIdentification;
import communication.Reponse;
import communication.ReponseIdentification;
import communication.ResponseEvent;
import communication.ResponseListener;
import enums.GlobalProperties;
import enums.Properties;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.util.logging.Logger;

public class Ihm_Accueil extends JFrame implements ResponseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -684831082624221575L;
	private static Logger LOGGER = Logger.getLogger(Ihm_Accueil.class.getName());

	private JTextField textField;
	private JPasswordField textField_1;
	private static Window frameAccueil;
	public Ihm_Accueil currentInstance = this;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				frameAccueil = new Ihm_Accueil();
				GlobalProperties.registerProperty(Properties.FRAME_ACCUEIL, frameAccueil);
				frameAccueil.setVisible(true);
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
				if ("...".equals(textField.getText())) {
					textField.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if ("".equals(textField.getText())) {
					textField.setText("...");
				}
			}
		});
		textField.setName("");
		textField.setText("...");
		textField.setBounds(10, 163, 280, 25);
		getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JPasswordField();
		textField_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if ("...".equals(textField_1.getText())) {
					textField_1.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if ("".equals(textField_1.getText())) {
					textField_1.setText("...");
				}
			}
		});
		textField_1.setText("...");
		textField_1.setColumns(10);
		textField_1.setBounds(10, 219, 280, 25);
		getContentPane().add(textField_1);

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
		lblNewLabel.setIcon(new ImageIcon(Ihm_Accueil.class
				.getResource("/gui/ressources/logo-EFREI.png")));
		lblNewLabel.setBounds(10, 11, 280, 104);
		getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
	
				if ("...".equals(textField.getText()) || "...".equals(textField_1.getText())) {
					JOptionPane.showMessageDialog(null,	"Veuillez saisir votre identifiant et mot de passe.",
												"Erreur de connexion", JOptionPane.ERROR_MESSAGE);
				} else {
					try {
						String passwordMD5 = MD5.encryptMD5(textField_1.getText());
						MessageIdentification msgIdentification = new MessageIdentification(
								MessageIdentification.class.getName(), textField.getText(), passwordMD5);
						Client client = Client.getInstance();
						client.sendMessage(msgIdentification);
						client.disconnect();
					} catch (Exception e1) {
						LOGGER.severe(LOGGER.getName()+ " Erreur de connexion : " + e1);
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
		btnNewButton_1.setBounds(90, 275, 70, 23);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
		@Override
			public void mousePressed(MouseEvent e) {
				URI uri = URI.create("http://www.efrei.fr/");
				try {
					Desktop.getDesktop().browse(uri);
				} catch (IOException e1) {
					LOGGER.severe("URI error : " + e);
				}
			}
		});
		getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Informations");
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_2.setBounds(170, 275, 120, 23);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				URI uri = URI.create("http://www.efrei.fr/programme-cycle-ingenieur-par-apprentissage#.U8pn7vl_uBo");
				try {
					Desktop.getDesktop().browse(uri);
				} catch (IOException e1) {
					LOGGER.severe("URI error : " + e);
				}
			}
		});
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
		lblNewLabel_2.setIcon(new ImageIcon(Ihm_Accueil.class
				.getResource("/gui/ressources/fond.jpg")));
		lblNewLabel_2.setBounds(0, 0, 304, 691);
		getContentPane().add(lblNewLabel_2);
		Client.getInstance().addListener(this);
	}

	@Override
	public void onResponseReceived(ResponseEvent re) {
		Reponse r = (Reponse) re.getSource();
		if(!r.getType().equals(ReponseIdentification.class.getName()))return;
		ReponseIdentification ri = (ReponseIdentification)r;
		if(!ri.isLogged()){
			JOptionPane.showMessageDialog(this,"Informations de login incorrectes", "Utilisateur non reconnu", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		Personne p = ri.getPersonne();
		GlobalProperties.registerProperty(Properties.LOGGED_USER, p);
		frameAccueil.setVisible(false);
		
		switch(ri.getPermission()) {
			case ELEVE :
				
				Ihm_Eleve frameEleve;
				if( GlobalProperties.getProperty(Properties.FRAME_ELEVE) == null){
					frameEleve = new Ihm_Eleve();
					GlobalProperties.registerProperty(Properties.FRAME_ELEVE, frameEleve);
				}
				else{
					frameEleve = (Ihm_Eleve)GlobalProperties.getProperty(Properties.FRAME_ELEVE);
				}
				frameEleve.setVisible(true);
				break;
				
			case PROF :
				
			
				Ihm_Professeur frameProf;
				if( GlobalProperties.getProperty(Properties.FRAME_PROF) == null){
					frameProf = new Ihm_Professeur();
					GlobalProperties.registerProperty(Properties.FRAME_PROF, frameProf);
				}
				else{
					frameProf = (Ihm_Professeur)GlobalProperties.getProperty(Properties.FRAME_PROF);
				}
				frameProf.setVisible(true);
				
			case ADMIN :
				
				
				Ihm_Administrateur frameAdmin;
				if( GlobalProperties.getProperty(Properties.FRAME_ADMIN) == null){
					frameAdmin = new Ihm_Administrateur();
					GlobalProperties.registerProperty(Properties.FRAME_ADMIN, frameAdmin);
				}
				else{
					 frameAdmin = (Ihm_Administrateur)GlobalProperties.getProperty(Properties.FRAME_ADMIN);
				}
				 frameAdmin.setVisible(true);
				
			default:
				break;
		}
	}
}
