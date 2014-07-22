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

import dal.DAOFactory;
import beans.Contact;
import beans.Eleve;
import table.TableAllergie;
import table.TableClasse;
import table.TableContact;
import table.TableEleve;
import table.TableMatiere;
import table.TableMedecin;
import table.TableVaccin;

public class TestDB {

	@Test
	public void test() {
		

		Contact c = new Contact(1, "Labonasse", "Charlotte", "labonassec@gmail.com", 061521352, 023515412, 0, "1 pink road");
		
		System.out.println(DAOFactory.getInstance().getContactDao().creer(c));
		
	}
	
}
