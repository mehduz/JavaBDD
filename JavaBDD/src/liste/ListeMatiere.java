package liste;

import java.util.ArrayList;
import beans.Matiere;
import dal.DAOFactory;
import dal.daoImpl.MatiereDaoImpl;

public class ListeMatiere {

	public static ArrayList<Matiere> getListeMatiere() {

		MatiereDaoImpl el = (MatiereDaoImpl) DAOFactory.getInstance().getMatiereDao();
		ArrayList<Matiere> listeMatiere = el.getAll();

		return listeMatiere;
	}

}
