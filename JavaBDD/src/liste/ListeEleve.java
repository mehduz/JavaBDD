package liste;

import java.util.ArrayList;
import beans.Eleve;
import dal.DAOFactory;
import dal.daoImpl.EleveDaoImpl;

public class ListeEleve {

	public static ArrayList<Eleve> getListeEleve() {

		EleveDaoImpl el = (EleveDaoImpl) DAOFactory.getInstance().getEleveDao();
		ArrayList<Eleve> listeEleve = el.getAll();

		return listeEleve;

	}

}
