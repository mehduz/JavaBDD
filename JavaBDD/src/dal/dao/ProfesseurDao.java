package dal.dao;

import beans.Professeur;
import dal.DAOException;

public interface ProfesseurDao {
	
	void creer( Professeur classe ) throws DAOException;

	Professeur trouver( String id_prof ) throws DAOException;
	

}
