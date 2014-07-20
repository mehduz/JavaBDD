package liste;

import java.util.ArrayList;
import beans.Medecin;
import dal.DAOFactory;
import dal.daoImpl.MedecinDaoImpl;

public class ListeMedecin {

	public static ArrayList<Medecin> getListeMedecin() {

		MedecinDaoImpl el = (MedecinDaoImpl) DAOFactory.getInstance()
				.getMedecinDao();
		ArrayList<Medecin> listeMedecin = el.getAll();

		return listeMedecin;
	}

}
