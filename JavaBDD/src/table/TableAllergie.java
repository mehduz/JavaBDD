package table;

import java.util.ArrayList;
import javax.swing.JTable;
import beans.Allergie;
import dal.DAOFactory;
import dal.daoImpl.AllergieDaoImpl;
import dal.daoImpl.SuiviDaoImpl;
import dal.daoImpl.VaccinDaoImpl;

public class TableAllergie {

	public static JTable getTableVaccin() {
		int taille = 10;

		AllergieDaoImpl el = new AllergieDaoImpl(new DAOFactory());
		ArrayList<Allergie> listAllergie = el.getAll();

		JTable table = new JTable(listAllergie.size(), taille);
		table.setEnabled(false);
		Object columnNames[] = { "ID_Vaccin", "Libellé" };

		for (int i = 0; i <= (taille - 1); i++) {
			table.getTableHeader().getColumnModel().getColumn(i)
					.setHeaderValue(columnNames[i]);
		}

		for (int actualRow = 0; actualRow <= listAllergie.size() - 1; actualRow++) {
			for (int actualColumn = 0; actualColumn <= (taille - 1); actualColumn++) {
				switch (actualColumn) {
				case 0:
					table.setValueAt(listAllergie.get(actualRow)
							.getID_allergie(), actualRow, actualColumn);
					break;
				case 1:
					table.setValueAt(listAllergie.get(actualRow).getLibelle(),
							actualRow, actualColumn);
					break;
				}
			}
		}

		return table;
	}

}
