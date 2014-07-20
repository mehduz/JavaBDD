package liste;

import java.util.ArrayList;
import beans.Contact;
import dal.DAOFactory;
import dal.daoImpl.ContactDaoImpl;

public class ListeContact {

	public static ArrayList<Contact> getListeContact() {

		ContactDaoImpl el = (ContactDaoImpl) DAOFactory.getInstance()
				.getContactDao();
		ArrayList<Contact> listeContact = el.getAll();

		return listeContact;
	}

}
