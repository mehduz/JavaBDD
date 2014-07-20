package table;

import java.util.ArrayList;
import javax.swing.JTable;
import beans.Matiere;
import beans.Suivi;
import dal.DAOFactory;
import dal.daoImpl.MatiereDaoImpl;
import dal.daoImpl.SuiviDaoImpl;

public class TableMatiere {

	/*	public static JTable getTableMatiere() {
			int taille = 1;		
			MatiereDaoImpl el = new MatiereDaoImpl(new DAOFactory());
			ArrayList<Matiere> listeMatiere = el.getAll();

			JTable table = new JTable(listeMatiere.size(), taille);
			table.setEnabled(false);
			Object columnNames[] = { "Nom_matière" };

			for (int i = 0; i <= (taille-1); i++) {
				table.getTableHeader().getColumnModel().getColumn(i).setHeaderValue(columnNames[i]);
			}

			for (int actualRow = 0; actualRow <= listeMatiere.size() - 1; actualRow++) {
				for (int actualColumn = 0; actualColumn <= (taille-1); actualColumn++) {
					switch (actualColumn) {
						case 0:
							table.setValueAt(listeMatiere.get(actualRow).getNom_matiere(),actualRow, actualColumn);
							break;
					}
				}
			}
			
			return table;
		}*/
}