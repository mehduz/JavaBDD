package dal.dao;
import dal.DAOException;
import beans.*;


public interface EleveDao {
	

	 int creer( Eleve eleve ) throws DAOException;

	 Eleve trouver( int idPersonne ) throws DAOException;
	 
	 Eleve trouver(String login, String mdp) throws DAOException;


} 