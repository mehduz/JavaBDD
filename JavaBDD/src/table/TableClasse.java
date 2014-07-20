package table;

import java.util.ArrayList;

import javax.swing.JTable;

import beans.Allergie;
import beans.Classe;
import dal.DAOFactory;
import dal.daoImpl.AllergieDaoImpl;
import dal.daoImpl.ClasseDaoImpl;
import dal.daoImpl.SuiviDaoImpl;
import dal.daoImpl.VaccinDaoImpl;

public class TableClasse {

	public static JTable getTableClasse() {
		int taille = 1;

		ClasseDaoImpl el = (ClasseDaoImpl) DAOFactory.getInstance().getClasseDao();
		ArrayList<Classe> listClasse = el.getAll();

		JTable table = new JTable(listClasse.size(), taille);
		table.setEnabled(false);
		Object columnNames[] = { "Nom_Classe" };

		for (int i = 0; i <= (taille - 1); i++) {
			table.getTableHeader().getColumnModel().getColumn(i)
					.setHeaderValue(columnNames[i]);
		}

		for (int actualRow = 0; actualRow <= listClasse.size() - 1; actualRow++) {
			for (int actualColumn = 0; actualColumn <= (taille - 1); actualColumn++) {
				switch (actualColumn) {
				case 0:
					table.setValueAt(listClasse.get(actualRow).getNom_classe(),
							actualRow, actualColumn);
					break;
				}
			}
		}

		return table;
	}

}