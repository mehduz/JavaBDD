package dal.dao;

import beans.Contact;
import dal.DAOException;

public interface ContactDao {
	
	int creer( Contact contact ) throws DAOException;

	Contact trouver( int id_personne ) throws DAOException;
	

}
