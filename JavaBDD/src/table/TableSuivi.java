package table;

import java.util.ArrayList;

import javax.swing.JTable;

import beans.Classe;
import beans.Suivi;
import dal.DAOFactory;
import dal.daoImpl.ClasseDaoImpl;
import dal.daoImpl.SuiviDaoImpl;

public class TableSuivi {
	
	public static JTable getTableSuivi(ArrayList<Suivi> listeSuivi) {
		
		int taille = 7;

		JTable table = new JTable(listeSuivi.size(), taille);
		table.setEnabled(false);
		Object columnNames[] = { "Matricule","Nom", "Prénom", "Matière", "Note CC", "Note Examen", "Moyenne matiere" };

		for (int i = 0; i <= (taille-1); i++) {
			table.getTableHeader().getColumnModel().getColumn(i).setHeaderValue(columnNames[i]);
		}

		long valCC = 0;
		long valexamen = 0;
		
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
					valCC = listeSuivi.get(actualRow).getNote_CC();
					break;
				case 5:
					table.setValueAt(listeSuivi.get(actualRow).getNote_examen(),actualRow, actualColumn);
					valexamen = listeSuivi.get(actualRow).getNote_examen();
					break;
				case 6 :
					long valMoyenne = (valCC + valexamen)/2;
					table.setValueAt(valMoyenne,actualRow, actualColumn);
					break;
				}
			}
		}
		
		return table;
	}
	
}
