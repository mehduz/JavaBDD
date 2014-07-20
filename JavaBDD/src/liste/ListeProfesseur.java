package liste;

import java.util.ArrayList;
import beans.Professeur;
import dal.DAOFactory;
import dal.daoImpl.ProfesseurDaoImpl;

public class ListeProfesseur {

	public static ArrayList<Professeur> getListeProfesseur() {

		ProfesseurDaoImpl el = (ProfesseurDaoImpl) DAOFactory.getInstance()
				.getProfesseurDao();
		ArrayList<Professeur> listeProfesseur = el.getAll();

		return listeProfesseur;
	}

}
