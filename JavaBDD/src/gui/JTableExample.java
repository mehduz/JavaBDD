package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import beans.Eleve;
import dal.DAOFactory;
import dal.daoImpl.EleveDaoImpl;

public class JTableExample extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -684831082624221575L;

	/**
	 * Create the frame.
	 */
	
	
	
	public JTableExample() {
		
		EleveDaoImpl test = (EleveDaoImpl) DAOFactory.getInstance().getEleveDao();
		ArrayList<Eleve> arrayEleve = test.getAll();
		System.out.println(arrayEleve.size());
				
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("University Manager");
		setSize(new Dimension(1280, 720));
		setResizable(false);
		setVisible(true);
		getContentPane().setLayout(null);
		
		//Create a Vector to store data of rows
		Vector rowData = new Vector();
		
		//Add data to vector
		for (int i = 0; i < 1; i++) {
			Vector colData = new Vector(Arrays.asList("qq"));
			rowData.add(colData);
		}
		
		//Do the same for column
		String[] columnNames = { "a" };
		Vector columnNamesV = new Vector(Arrays.asList(columnNames));
		
		//Create JTable
		JTable table = new JTable(rowData, columnNamesV);
		// Make the table vertically scrollable
		JScrollPane scrollPane = new JScrollPane(table);

		JPanel panel = new JPanel();
		panel.add(scrollPane);
		panel.setBounds(322, 20, 932, 651);
		getContentPane().add(panel);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Ihm_Eleve.class.getResource("/gui/ressources/fond_principal.jpg")));
		lblNewLabel_3.setBounds(300, 0, 974, 691);
		getContentPane().add(lblNewLabel_3);
		
	}

}
