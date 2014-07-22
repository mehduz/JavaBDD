package liste;

import java.util.ArrayList;

import beans.Personne;
import dal.DAOFactory;
import dal.daoImpl.PersonneDaoImpl;

public class ListePersonne {

	public static ArrayList<Personne> getListePersonne() {

		PersonneDaoImpl el = (PersonneDaoImpl) DAOFactory.getInstance().getPersonneDao();
		ArrayList<Personne> listePersonne = el.getAll();

		return listePersonne;
	}

}
