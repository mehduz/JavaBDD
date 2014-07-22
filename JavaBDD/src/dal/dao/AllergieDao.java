package dal.dao;

import java.util.ArrayList;

import beans.Allergie;
import dal.DAOException;

public interface AllergieDao {

	int creer( Allergie allergie ) throws DAOException;
	
	void supprimer(Allergie allergie) throws DAOException;

	Allergie trouver( String nomAllergie ) throws DAOException;

	ArrayList<Allergie> getAll() throws DAOException;
	
}
