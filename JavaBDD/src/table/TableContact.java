package table;

import java.util.ArrayList;
import javax.swing.JTable;
import beans.Contact;
import beans.Suivi;
import dal.DAOFactory;
import dal.daoImpl.ContactDaoImpl;
import dal.daoImpl.SuiviDaoImpl;

public class TableContact {

	public static JTable getTableContact() {

		int taille = 7;
		ContactDaoImpl el = (ContactDaoImpl) DAOFactory.getInstance().getContactDao();
		ArrayList<Contact> listeContact = el.getAll();

		JTable table = new JTable(listeContact.size(), taille);
		table.setEnabled(false);
		Object columnNames[] = { "ID_Contact", "Nom", "Prenom", "Adresse",
				"Email", "Tel_domicile", "Tel_mobile" };

		for (int i = 0; i <= (taille - 1); i++) {
			table.getTableHeader().getColumnModel().getColumn(i)
					.setHeaderValue(columnNames[i]);
		}

		for (int actualRow = 0; actualRow <= listeContact.size() - 1; actualRow++) {
			for (int actualColumn = 0; actualColumn <= (taille - 1); actualColumn++) {
				switch (actualColumn) {
				case 0:
					table.setValueAt(listeContact.get(actualRow)
							.getID_contact(), actualRow, actualColumn);
					break;
				case 1:
					table.setValueAt(listeContact.get(actualRow).getNom(),
							actualRow, actualColumn);
					break;
				case 2:
					table.setValueAt(listeContact.get(actualRow).getPrenom(),
							actualRow, actualColumn);
					break;
				case 3:
					table.setValueAt(listeContact.get(actualRow).getAdresse(),
							actualRow, actualColumn);
					break;
				case 4:
					table.setValueAt(listeContact.get(actualRow).getEmail(),
							actualRow, actualColumn);
					break;
				case 5:
					table.setValueAt(listeContact.get(actualRow)
							.getTel_domicile(), actualRow, actualColumn);
					break;
				case 6:
					table.setValueAt(listeContact.get(actualRow)
							.getTel_mobile(), actualRow, actualColumn);
					break;
				}
			}
		}

		return table;
	}

}
