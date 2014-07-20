package table;

import java.util.ArrayList;
import javax.swing.JTable;
import beans.Vaccin;
import dal.DAOFactory;
import dal.daoImpl.SuiviDaoImpl;
import dal.daoImpl.VaccinDaoImpl;

public class TableVaccin {

	public static JTable getTableVaccin() {
		int taille = 2;

		VaccinDaoImpl el = new VaccinDaoImpl(new DAOFactory());
		ArrayList<Vaccin> listeVaccin = el.getAll();

		JTable table = new JTable(listeVaccin.size(), taille);
		table.setEnabled(false);
		Object columnNames[] = { "ID_Vaccin", "Libellé" };

		for (int i = 0; i <= (taille - 1); i++) {
			table.getTableHeader().getColumnModel().getColumn(i)
					.setHeaderValue(columnNames[i]);
		}

		for (int actualRow = 0; actualRow <= listeVaccin.size() - 1; actualRow++) {
			for (int actualColumn = 0; actualColumn <= (taille - 1); actualColumn++) {
				switch (actualColumn) {
				case 0:
					table.setValueAt(listeVaccin.get(actualRow).getID_vaccin(),
							actualRow, actualColumn);
					break;
				case 1:
					table.setValueAt(listeVaccin.get(actualRow).getLibelle(),
							actualRow, actualColumn);
					break;
				}
			}
		}

		return table;
	}

}
