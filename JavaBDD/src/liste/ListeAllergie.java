package liste;

import java.util.ArrayList;
import beans.Allergie;
import dal.DAOFactory;
import dal.daoImpl.AllergieDaoImpl;

public class ListeAllergie {

	public static ArrayList<Allergie> getListeAllergie() {

		AllergieDaoImpl el = (AllergieDaoImpl) DAOFactory.getInstance().getAllergieDao();
		ArrayList<Allergie> listeAllergie = el.getAll();

		return listeAllergie;
	}

}
