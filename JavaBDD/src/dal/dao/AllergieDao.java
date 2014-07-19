package dal.dao;

import beans.Allergie;
import dal.DAOException;

public interface AllergieDao {

	int creer( Allergie allergie ) throws DAOException;

	Allergie trouver( String nomAllergie ) throws DAOException;
	
}
