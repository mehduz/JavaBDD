package dal.dao;

import beans.Personne;
import dal.DAOException;

public interface PersonneDao {

	void creer( Personne classe ) throws DAOException;

	Personne trouver( String nom_matiere ) throws DAOException;
	
}
