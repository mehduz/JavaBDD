package table;

import java.util.ArrayList;
import javax.swing.JTable;
import beans.Professeur;
import dal.DAOFactory;
import dal.daoImpl.ProfesseurDaoImpl;

public class TableProfesseur {

	public static JTable getTableProfesseur() {
		int taille = 6;
		ProfesseurDaoImpl el = (ProfesseurDaoImpl) DAOFactory.getInstance().getProfesseurDao();
		ArrayList<Professeur> listeProf = el.getAll();

		JTable table = new JTable(listeProf.size(), taille);
		table.setEnabled(false);
		Object columnNames[] = { "ID_prof", "Nom", "Prenom", "Email",
				"Tel_domicile", "Tel_mobile" };

		for (int i = 0; i <= (taille - 1); i++) {
			table.getTableHeader().getColumnModel().getColumn(i)
					.setHeaderValue(columnNames[i]);
		}

		for (int actualRow = 0; actualRow <= listeProf.size() - 1; actualRow++) {
			for (int actualColumn = 0; actualColumn <= (taille - 1); actualColumn++) {
				switch (actualColumn) {
				case 0:
					table.setValueAt(listeProf.get(actualRow).getID_prof(),
							actualRow, actualColumn);
					break;
				case 1:
					table.setValueAt(listeProf.get(actualRow).getNom(),
							actualRow, actualColumn);
					break;
				case 2:
					table.setValueAt(listeProf.get(actualRow).getPrenom(),
							actualRow, actualColumn);
					break;
				case 3:
					table.setValueAt(listeProf.get(actualRow).getEmail(),
							actualRow, actualColumn);
					break;
				case 4:
					table.setValueAt(
							listeProf.get(actualRow).getTel_domicile(),
							actualRow, actualColumn);
					break;
				case 5:
					table.setValueAt(listeProf.get(actualRow).getTel_mobile(),
							actualRow, actualColumn);
					break;
				}
			}
		}

		return table;
	}

}
