package dal.dao;

import beans.Professeur;
import dal.DAOException;

public interface ProfesseurDao {
	
	int creer( Professeur classe ) throws DAOException;

	Professeur trouver( String id_prof ) throws DAOException;
	
	public Professeur trouver(String login, String mdp) throws DAOException;

	Professeur trouver(int idPersonne) throws DAOException;
	
	
}
