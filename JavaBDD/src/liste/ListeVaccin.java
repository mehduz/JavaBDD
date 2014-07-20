package liste;

import java.util.ArrayList;
import beans.Vaccin;
import dal.DAOFactory;
import dal.daoImpl.VaccinDaoImpl;

public class ListeVaccin {

	public static ArrayList<Vaccin> getListeVaccin() {

		VaccinDaoImpl el = (VaccinDaoImpl) DAOFactory.getInstance()
				.getVaccinDao();
		ArrayList<Vaccin> listeVaccin = el.getAll();

		return listeVaccin;
	}

}
