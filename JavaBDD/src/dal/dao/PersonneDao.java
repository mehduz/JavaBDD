package dal.dao;

import beans.Personne;
import dal.DAOException;

public interface PersonneDao {

	int creer( Personne classe ) throws DAOException;

	Personne trouver( long l ) throws DAOException;

	void supprimer(Personne personne) throws DAOException;
	
}
