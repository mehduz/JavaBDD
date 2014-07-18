package dal.dao;

import beans.Contact;
import dal.DAOException;

public interface ContactDao {
	
	void creer( Contact classe ) throws DAOException;

	Contact trouver( String id_contact ) throws DAOException;
	

}
