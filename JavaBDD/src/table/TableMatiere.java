package table;

import java.util.ArrayList;

import javax.swing.JTable;

import beans.Matiere;
import beans.Professeur;
import dal.DAOFactory;
import dal.daoImpl.MatiereDaoImpl;
import dal.daoImpl.ProfesseurDaoImpl;

public class TableMatiere {

	public static JTable getTableMatiere() {
		int taille = 2;
		MatiereDaoImpl el = (MatiereDaoImpl) DAOFactory.getInstance().getMatiereDao();
		ArrayList<Matiere> listeMatiere = el.getAll();

		JTable table = new JTable(listeMatiere.size(), taille);
		table.setEnabled(false);
		Object columnNames[] = { "Nom_matière", "Professeur associé" };

		for (int i = 0; i <= (taille - 1); i++) {
			table.getTableHeader().getColumnModel().getColumn(i)
					.setHeaderValue(columnNames[i]);
		}

		for (int actualRow = 0; actualRow <= listeMatiere.size() - 1; actualRow++) {
			for (int actualColumn = 0; actualColumn <= (taille - 1); actualColumn++) {
				switch (actualColumn) {
				case 0:
					table.setValueAt(listeMatiere.get(actualRow)
							.getNom_matiere(), actualRow, actualColumn);
					break;
				case 1:
					ProfesseurDaoImpl prof = (ProfesseurDaoImpl) DAOFactory.getInstance().getProfesseurDao();
					ArrayList<Professeur> listeProf = prof.getAllParMatiere(listeMatiere.get(actualRow).getNom_matiere());
					for (int i = 0; i < listeProf.size(); i++) {
						table.setValueAt(listeProf.get(i).getNom(), actualRow, actualColumn);
					}
					break;
				}
			}
		}

		return table;
	}
}