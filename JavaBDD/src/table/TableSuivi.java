package table;

import java.util.ArrayList;
import javax.swing.JTable;
import beans.Eleve;
import beans.Suivi;
import dal.DAOFactory;
import dal.daoImpl.EleveDaoImpl;
import dal.daoImpl.SuiviDaoImpl;

public class TableSuivi {
	
	public static JTable getTableSuivi() {
		
		int taille = 6;
		SuiviDaoImpl el = new SuiviDaoImpl(new DAOFactory());
		ArrayList<Suivi> listeSuivi = el.getAll();

		JTable table = new JTable(listeSuivi.size(), taille);
		table.setEnabled(false);
		Object columnNames[] = { "Matricule","Nom", "Prénom", "Matière", "Note CC", "Note Examen" };

		for (int i = 0; i <= (taille-1); i++) {
			table.getTableHeader().getColumnModel().getColumn(i).setHeaderValue(columnNames[i]);
		}

		for (int actualRow = 0; actualRow <= listeSuivi.size() - 1; actualRow++) {
			for (int actualColumn = 0; actualColumn <= (taille-1); actualColumn++) {
				switch (actualColumn) {
				case 0:
					table.setValueAt(listeSuivi.get(actualRow).getEleve().getMatricule(),actualRow, actualColumn);
					break;
				case 1:
					table.setValueAt(listeSuivi.get(actualRow).getEleve().getNom(),actualRow, actualColumn);
					break;
				case 2:
					table.setValueAt(listeSuivi.get(actualRow).getEleve().getPrenom(),actualRow, actualColumn);
					break;
				case 3:
					table.setValueAt(listeSuivi.get(actualRow).getNom_matiere(),actualRow, actualColumn);
					break;
				case 4:
					table.setValueAt(listeSuivi.get(actualRow).getNote_CC(),actualRow, actualColumn);
					break;
				case 5:
					table.setValueAt(listeSuivi.get(actualRow).getNote_examen(),actualRow, actualColumn);
					break;
				}
			}
		}
		
		return table;
	}

}
