package dal.dao;

import beans.Suivi;
import dal.DAOException;

public interface SuiviDao {
	
	int creer( Suivi suivi ) throws DAOException;

	Suivi trouver( String email ) throws DAOException;
	

}
