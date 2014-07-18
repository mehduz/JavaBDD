package dal.dao;

import beans.Matiere;
import dal.DAOException;

public interface MatiereDao {
	
	void creer( Matiere classe ) throws DAOException;

	Matiere trouver( String email ) throws DAOException;
	

}
