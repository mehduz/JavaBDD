package Test;

import static org.junit.Assert.*;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.junit.Test;

import table.TableEleve;
import table.TableProfesseur;
import beans.Eleve;
import dal.DAOFactory;
import dal.daoImpl.EleveDaoImpl;

public class TestDB {

	@Test
	public void test() {
		
	    JFrame frame = new JFrame();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    JTable tableE = TableEleve.getTableEleve();
	    JTable tableP = TableProfesseur.getTableSuivi(6);
	    
	    JScrollPane scrollPane = new JScrollPane(tableP);
	    frame.add(scrollPane, BorderLayout.CENTER);
	    frame.setSize(932, 651);
	    frame.setVisible(true);
	    try {
			Thread.sleep(5000000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
