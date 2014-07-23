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

import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.JPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import table.TableAllergie;
import table.TableSuivi;
import communication.ResponseEvent;
import communication.ResponseListener;
import dal.DAOFactory;
import enums.GlobalProperties;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Ihm_Professeur_ConsulterNotesTutores extends JFrame implements ResponseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -684831082624221575L;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JComboBox comboBox;
	private  ArrayList distinctList;

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
	
		table = TableSuivi.getTableSuivi(DAOFactory.getInstance().getSuiviDao().getAllParIdProf(2));
		table.setOpaque(false);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setOpaque(false);
		scrollPane.setBorder(null);
		scrollPane.getViewport().setOpaque(false);
		
		comboBox = new JComboBox();
		
		ArrayList list = new ArrayList() ;
		 
		for(int i = 0; i < table.getRowCount(); i++) {
			list.add((table.getValueAt(i, 1)) + " " + table.getValueAt(i, 2));
		}
		
		Set set = new HashSet() ;
	    set.addAll(list) ;
	    distinctList = new ArrayList(set) ;
	    Collections.sort(distinctList);
		
		for(int i = 0; i < distinctList.size(); i++) {
			comboBox.addItem(distinctList.get(i));
		}
		
		comboBox.setMaximumRowCount(10);
		comboBox.setBounds(8, 243, 280, 25);
		getContentPane().add(comboBox);
		
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				table = TableSuivi.getTableSuivi(DAOFactory.getInstance().getSuiviDao().getAllParIdProf(2));
				table.setOpaque(false);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				
			
				for(int i = 0; i < table.getRowCount(); i ++) {
					
					System.out.println(i);
					System.out.println(table.getRowCount());
					
					if(!comboBox.getSelectedItem().toString().equals(table.getValueAt(i, 1) + " " + table.getValueAt(i, 2))) {
						
						model.removeRow(i);
						i = -1;
						
					}
				}
				
				myRepaint(table);
				
			}
		});
		
		scrollPane.setBounds(314, 11, 950, 669);
		
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(8, 279, 284, 2);
		getContentPane().add(separator_5);
		
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
		button.setBounds(10, 292, 282, 23);
		getContentPane().add(button);
		
		JLabel lblVosMatires = new JLabel("Vos tutor\u00E9s");
		lblVosMatires.setForeground(Color.WHITE);
		lblVosMatires.setFont(new Font("Arial", Font.BOLD, 15));
		lblVosMatires.setBounds(8, 222, 142, 20);
		getContentPane().add(lblVosMatires);
		
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
		
		JButton btnNewButton_1 = new JButton("Consulter notes de vos tutor\u00E9s");
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
	
	public void myRepaint(JTable table) {
		this.setVisible(false);
		new Ihm_Professeur_ConsulterNotesTutoresMaj(table);
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
