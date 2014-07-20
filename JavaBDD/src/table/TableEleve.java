package table;

import java.util.ArrayList;
import javax.swing.JTable;
import beans.Eleve;
import dal.DAOFactory;
import dal.daoImpl.EleveDaoImpl;

public class TableEleve {

	public static JTable getTableEleve() {
		int taille = 15;
		EleveDaoImpl el = (EleveDaoImpl) DAOFactory.getInstance().getEleveDao();
		ArrayList<Eleve> listeEleve = el.getAll();

		JTable table = new JTable(listeEleve.size(), taille);
		table.setEnabled(false);
		Object columnNames[] = { "Nom", "Prenom", "Matricule", "Email",
				"Date_naissance", "Ville_naissance", "Pays_naissance", "Sexe",
				"Date_inscription", "Etablissement_prec", "Photo", "Rue",
				"Code_postal", "Ville", "Remarques_medicale" };

		for (int i = 0; i <= (taille - 1); i++) {
			table.getTableHeader().getColumnModel().getColumn(i)
					.setHeaderValue(columnNames[i]);
		}

		for (int actualRow = 0; actualRow <= listeEleve.size() - 1; actualRow++) {
			for (int actualColumn = 0; actualColumn <= (taille - 1); actualColumn++) {
				switch (actualColumn) {
				case 0:
					table.setValueAt(listeEleve.get(actualRow).getNom(),
							actualRow, actualColumn);
					break;
				case 1:
					table.setValueAt(listeEleve.get(actualRow).getPrenom(),
							actualRow, actualColumn);
					break;
				case 2:
					table.setValueAt(listeEleve.get(actualRow).getMatricule(),
							actualRow, actualColumn);
					break;
				case 3:
					table.setValueAt(listeEleve.get(actualRow).getEmail(),
							actualRow, actualColumn);
					break;
				case 4:
					table.setValueAt(listeEleve.get(actualRow)
							.getDate_naissance(), actualRow, actualColumn);
					break;
				case 5:
					table.setValueAt(listeEleve.get(actualRow)
							.getVille_naissance(), actualRow, actualColumn);
					break;
				case 6:
					table.setValueAt(listeEleve.get(actualRow)
							.getPays_naissance(), actualRow, actualColumn);
					break;
				case 7:
					table.setValueAt(listeEleve.get(actualRow).getSexe(),
							actualRow, actualColumn);
					break;
				case 8:
					table.setValueAt(listeEleve.get(actualRow)
							.getDate_inscription(), actualRow, actualColumn);
					break;
				case 9:
					table.setValueAt(listeEleve.get(actualRow)
							.getEtablissement_prec(), actualRow, actualColumn);
					break;
				case 10:
					table.setValueAt(listeEleve.get(actualRow).getPhoto(),
							actualRow, actualColumn);
					break;
				case 11:
					table.setValueAt(listeEleve.get(actualRow).getRue(),
							actualRow, actualColumn);
					break;
				case 12:
					table.setValueAt(
							listeEleve.get(actualRow).getCode_postal(),
							actualRow, actualColumn);
					break;
				case 13:
					table.setValueAt(listeEleve.get(actualRow).getVille(),
							actualRow, actualColumn);
					break;
				case 14:
					table.setValueAt(listeEleve.get(actualRow)
							.getRemarques_medicale(), actualRow, actualColumn);
					break;
				}
			}
		}

		return table;
	}
}
