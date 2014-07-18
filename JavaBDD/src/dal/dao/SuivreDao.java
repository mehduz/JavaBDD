package dal.dao;

import beans.Suivre;
import dal.DAOException;

public interface SuivreDao {
	
	void creer( Suivre classe ) throws DAOException;

	Suivre trouver( String email ) throws DAOException;
	

}
