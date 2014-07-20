package liste;

import java.util.ArrayList;
import beans.Classe;
import dal.DAOFactory;
import dal.daoImpl.ClasseDaoImpl;

public class ListeClasse {

	public static ArrayList<Classe> getListeClasse() {

		ClasseDaoImpl el = (ClasseDaoImpl) DAOFactory.getInstance()
				.getClasseDao();
		ArrayList<Classe> listeClasse = el.getAll();

		return listeClasse;
	}

}
