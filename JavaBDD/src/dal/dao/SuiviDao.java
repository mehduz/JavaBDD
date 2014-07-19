package dal.dao;

import beans.Suivi;
import dal.DAOException;

public interface SuiviDao {
	
	int creer( Suivi suivi ) throws DAOException;

	Suivi trouver( int idPersonne ) throws DAOException;
	

}
