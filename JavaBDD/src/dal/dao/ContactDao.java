package dal.dao;

import beans.Classe;
import beans.Contact;
import dal.DAOException;

public interface ContactDao {
	
	void creer( Contact classe ) throws DAOException;

	Contact trouver( String email ) throws DAOException;
	

}
