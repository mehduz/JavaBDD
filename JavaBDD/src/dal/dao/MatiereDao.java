package dal.dao;

import beans.Matiere;
import dal.DAOException;

public interface MatiereDao {
	
	int creer( Matiere classe ) throws DAOException;

	Matiere trouver( String nom_matiere ) throws DAOException;
	

}
