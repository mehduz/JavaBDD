package table;

import java.util.ArrayList;

import javax.swing.JTable;

import beans.Suivi;
import dal.DAOFactory;
import dal.daoImpl.SuiviDaoImpl;

public class TableBulletin {

	public static JTable getTableBulletin() {
		int taille = 3;

		SuiviDaoImpl el = (SuiviDaoImpl) DAOFactory.getInstance().getSuiviDao();
		ArrayList<Suivi> listSuivi = el.getAllParEleve(3);

		JTable table = new JTable(listSuivi.size(), taille);
		table.setEnabled(false);
		Object columnNames[] = { "Matière", "Note_cc", "Note_Examen" };

		for (int i = 0; i <= (taille - 1); i++) {
			table.getTableHeader().getColumnModel().getColumn(i)
					.setHeaderValue(columnNames[i]);
		}

		for (int actualRow = 0; actualRow <= listSuivi.size() - 1; actualRow++) {
			for (int actualColumn = 0; actualColumn <= (taille - 1); actualColumn++) {
				switch (actualColumn) {
				case 0:
					table.setValueAt(listSuivi.get(actualRow)
							.getNom_matiere(), actualRow, actualColumn);
					break;
				case 1:
					table.setValueAt(listSuivi.get(actualRow)
							.getNote_CC(), actualRow, actualColumn);
					break;
				case 2:
					table.setValueAt(listSuivi.get(actualRow)
							.getNote_examen(), actualRow, actualColumn);
					break;
				}
			}
		}

		return table;
	}

}
