package table;

import java.util.ArrayList;

import javax.swing.JTable;

import beans.Medecin;
import dal.DAOFactory;
import dal.daoImpl.MedecinDaoImpl;

public class TableMedecin {

	public static JTable getTableMedecin() {
		int taille = 6;
		MedecinDaoImpl el = (MedecinDaoImpl) DAOFactory.getInstance().getMedecinDao();
		ArrayList<Medecin> listeMedecin = el.getAll();

		JTable table = new JTable(listeMedecin.size(), taille);
		table.setEnabled(false);
		Object columnNames[] = { "ID_medecin", "Nom", "Prenom", "Email", "Tel_domicile"
				, "Tel_mobile"};

		for (int i = 0; i <= (taille - 1); i++) {
			table.getTableHeader().getColumnModel().getColumn(i)
					.setHeaderValue(columnNames[i]);
		}

		for (int actualRow = 0; actualRow <= listeMedecin.size() - 1; actualRow++) {
			for (int actualColumn = 0; actualColumn <= (taille - 1); actualColumn++) {
				switch (actualColumn) {
				case 0:
					table.setValueAt(listeMedecin.get(actualRow).getID_medecin(),
							actualRow, actualColumn);
					break;
				case 1:
					table.setValueAt(listeMedecin.get(actualRow).getNom(),
							actualRow, actualColumn);
					break;
				case 2:
					table.setValueAt(listeMedecin.get(actualRow).getPrenom(),
							actualRow, actualColumn);
					break;
				case 3:
					table.setValueAt(listeMedecin.get(actualRow).getEmail(),
							actualRow, actualColumn);
					break;
				case 4:
					table.setValueAt(listeMedecin.get(actualRow).getTel_domicile(),
							actualRow, actualColumn);
					break;
				case 5:
					table.setValueAt(listeMedecin.get(actualRow).getTel_mobile(),
							actualRow, actualColumn);
					break;
				}
			}
		}

		return table;
	}

}
