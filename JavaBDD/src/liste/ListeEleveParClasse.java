package liste;

import java.util.ArrayList;

import javax.swing.JTable;

import beans.Eleve;
import dal.DAOFactory;
import dal.daoImpl.EleveDaoImpl;

public class ListeEleveParClasse {

	public static JTable getListeEleveParClasse(String classe) {
		
		int taille = 1;
		
		EleveDaoImpl el = (EleveDaoImpl) DAOFactory.getInstance().getEleveDao();
		ArrayList<Eleve> listeEleve = el.getAllParClasse(classe);

		JTable table = new JTable(listeEleve.size(), taille);
		table.setEnabled(false);
		Object columnNames[] = {"Élève"};

		for (int i = 0; i <= (taille - 1); i++) {
			table.getTableHeader().getColumnModel().getColumn(i)
					.setHeaderValue(columnNames[i]);
		}

		for (int actualRow = 0; actualRow <= listeEleve.size() - 1; actualRow++) {
			for (int actualColumn = 0; actualColumn <= (taille - 1); actualColumn++) {
				switch (actualColumn) {
				case 0:
					table.setValueAt(listeEleve.get(actualRow).getNom(), actualRow, actualColumn);
					break;
				}
			}
		}

		return table;
		
	}

}
