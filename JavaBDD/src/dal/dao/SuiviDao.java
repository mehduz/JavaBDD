package dal.dao;

import beans.Suivi;
import dal.DAOException;

public interface SuiviDao {
	
	void creer( Suivi classe ) throws DAOException;

	Suivi trouver( String email ) throws DAOException;
	

}
