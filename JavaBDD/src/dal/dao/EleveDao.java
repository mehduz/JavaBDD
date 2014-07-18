package dal.dao;
import dal.DAOException;
import beans.*;


public interface EleveDao {
	

	 void creer( Eleve eleve ) throws DAOException;

	 Eleve trouver( String email ) throws DAOException;

} 