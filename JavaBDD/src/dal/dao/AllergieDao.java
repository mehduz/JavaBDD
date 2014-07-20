package dal.dao;

import java.util.ArrayList;

import beans.Allergie;
import beans.Vaccin;
import dal.DAOException;

public interface AllergieDao {

	int creer( Allergie allergie ) throws DAOException;

	Allergie trouver( String nomAllergie ) throws DAOException;

	ArrayList<Allergie> getAll() throws DAOException;
	
}
