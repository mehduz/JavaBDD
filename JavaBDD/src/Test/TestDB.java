package Test;

import static org.junit.Assert.*;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.junit.Test;

import table.TableAllergie;
import table.TableClasse;
import table.TableContact;
import table.TableEleve;
import table.TableMatiere;
import table.TableMedecin;
import table.TableProfesseur;
import table.TableSuivi;
import table.TableVaccin;
import beans.Eleve;
import dal.DAOFactory;
import dal.daoImpl.EleveDaoImpl;

public class TestDB {

	@Test
	public void test() {
		
	    JFrame frame = new JFrame();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    JTable tableA = TableAllergie.getTableAllergie();
	    JTable tableCl = TableClasse.getTableClasse();
	    JTable tableCo = TableContact.getTableContact();
	    JTable tableE = TableEleve.getTableEleve();
	    JTable tableMa = TableMatiere.getTableMatiere();
	    JTable tableMe = TableMedecin.getTableMedecin();
	    JTable tableP = TableProfesseur.getTableProfesseur();
	    JTable tableS = TableSuivi.getTableSuivi();
	    JTable tableV = TableVaccin.getTableVaccin();
	    
	    JScrollPane scrollPane = new JScrollPane(tableS);
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
