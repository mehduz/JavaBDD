package table;

import java.util.ArrayList;

import javax.swing.JTable;

import beans.Eleve;
import beans.Suivi;
import dal.DAOFactory;
import dal.daoImpl.EleveDaoImpl;
import dal.daoImpl.SuiviDaoImpl;

public class TableSuivi {
	
	/*public static JTable getTableSuivi() {
		SuiviDaoImpl el = new SuiviDaoImpl(new DAOFactory());
		ArrayList<Suivi> listeSuivi = el.getAll();

		JTable table = new JTable(listeSuivi.size(), 15);
		table.setEnabled(false);
		Object columnNames[] = { "Nom", "Prenom", "Matricule", "Email",
				"Date_naissance", "Ville_naissance", "Pays_naissance", "Sexe",
				"Date_inscription", "Etablissement_prec", "Photo", "Rue",
				"Code_postal", "Ville", "Remarques_medicale" };

		for (int i = 0; i <= 14; i++) {
			table.getTableHeader().getColumnModel().getColumn(i)
					.setHeaderValue(columnNames[i]);
		}

		for (int actualRow = 0; actualRow <= listeSuivi.size() - 1; actualRow++) {
			for (int actualColumn = 0; actualColumn <= 14; actualColumn++) {
				switch (actualColumn) {
				case 0:
					table.setValueAt(listeSuivi.get(actualRow).getNom(),
							actualRow, actualColumn);
					break;
				case 1:
					table.setValueAt(listeSuivi.get(actualRow).getPrenom(),
							actualRow, actualColumn);
					break;
				case 2:
					table.setValueAt(listeSuivi.get(actualRow).getMatricule(),
							actualRow, actualColumn);
					break;
				case 3:
					table.setValueAt(listeSuivi.get(actualRow).getEmail(),
							actualRow, actualColumn);
					break;
				case 4:
					table.setValueAt(listeSuivi.get(actualRow)
							.getDate_naissance(), actualRow, actualColumn);
					break;
				case 5:
					table.setValueAt(listeSuivi.get(actualRow)
							.getVille_naissance(), actualRow, actualColumn);
					break;
				case 6:
					table.setValueAt(listeSuivi.get(actualRow)
							.getPays_naissance(), actualRow, actualColumn);
					break;
				case 7:
					table.setValueAt(listeSuivi.get(actualRow).getSexe(),
							actualRow, actualColumn);
					break;
				case 8:
					table.setValueAt(listeSuivi.get(actualRow)
							.getDate_inscription(), actualRow, actualColumn);
					break;
				case 9:
					table.setValueAt(listeSuivi.get(actualRow)
							.getEtablissement_prec(), actualRow, actualColumn);
					break;
				case 10:
					table.setValueAt(listeSuivi.get(actualRow).getPhoto(),
							actualRow, actualColumn);
					break;
				case 11:
					table.setValueAt(listeSuivi.get(actualRow).getRue(),
							actualRow, actualColumn);
					break;
				case 12:
					table.setValueAt(
							listeSuivi.get(actualRow).getCode_postal(),
							actualRow, actualColumn);
					break;
				case 13:
					table.setValueAt(listeSuivi.get(actualRow).getVille(),
							actualRow, actualColumn);
					break;
				case 14:
					table.setValueAt(listeSuivi.get(actualRow)
							.getRemarques_medicale(), actualRow, actualColumn);
					break;
				}
			}
		}
		
		return table;
	}*/

}
