package testTableListe;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import liste.ListeEleve;
import liste.ListeEleveParClasse;
import liste.ListeEleveParMatiere;

import org.junit.Test;

import beans.Eleve;
import table.TableAllergie;
import table.TableClasse;
import table.TableContact;
import table.TableEleve;
import table.TableMatiere;
import table.TableMedecin;
import table.TableProfesseur;
import table.TableSuivi;
import table.TableVaccin;

public class TestDB {

	@Test
	public void test() {
		
	    JFrame frame = new JFrame();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
//	    JTable tableA = TableAllergie.getTableAllergie();
//	    JTable tableCl = TableClasse.getTableClasse();
//	    JTable tableCo = TableContact.getTableContact();
//	    JTable tableE = TableEleve.getTableEleve();
//	    JTable tableMa = TableMatiere.getTableMatiere();
//	    JTable tableMe = TableMedecin.getTableMedecin();
//	    JTable tableP = TableProfesseur.getTableProfesseur();
//	    JTable tableS = TableSuivi.getTableSuivi();
//	    JTable tableV = TableVaccin.getTableVaccin();
//		JTable tableListeEparC = ListeEleveParClasse.getListeEleveParClasse("L3 Asyria");
		JTable tableListeEparM = ListeEleveParMatiere.getListeEleveParMatiere("Informatique");
		
	    JScrollPane scrollPane = new JScrollPane(tableListeEparM);
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