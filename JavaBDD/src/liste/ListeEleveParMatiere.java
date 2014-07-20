package liste;

import java.util.ArrayList;
import javax.swing.JTable;
import beans.Suivi;
import dal.DAOFactory;
import dal.daoImpl.SuiviDaoImpl;

public class ListeEleveParMatiere {
	
	public static JTable getListeEleveParMatiere() {
		
		int taille = 1;
		
		SuiviDaoImpl el = (SuiviDaoImpl) DAOFactory.getInstance().getSuiviDao();
		ArrayList<Suivi> listeSuivi = el.getAll();

		JTable table = new JTable(listeSuivi.size(), taille);
		table.setEnabled(false);
		Object columnNames[] = {"Élève"};

		for (int i = 0; i <= (taille-1); i++) {
			table.getTableHeader().getColumnModel().getColumn(i).setHeaderValue(columnNames[i]);
		}
		
		for (int actualRow = 0; actualRow <= listeSuivi.size() - 1; actualRow++) {
			for (int actualColumn = 0; actualColumn <= (taille-1); actualColumn++) {
				switch (actualColumn) {
				case 0:
					table.setValueAt(listeSuivi.get(actualRow).getEleve().getMatricule(),actualRow, actualColumn);
					break;
				}
			}				
		}
		
		return table;
		
	}

}
