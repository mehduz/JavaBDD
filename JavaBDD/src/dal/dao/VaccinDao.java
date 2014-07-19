package dal.dao;

import beans.Vaccin;
import dal.DAOException;

public interface VaccinDao {

	int creer( Vaccin vaccin ) throws DAOException;

	Vaccin trouver( String nomVaccin ) throws DAOException;

	
}
