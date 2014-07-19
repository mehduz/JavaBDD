package dal.dao;

import beans.Vaccin;
import dal.DAOException;

public interface VaccinDao {

	int creer( Vaccin classe ) throws DAOException;

	Vaccin trouver( int idPersonne ) throws DAOException;

	
}
