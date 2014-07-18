package dal.dao;

import beans.Eleve;
import dal.DAOException;

public interface ClasseDao {

	 void creer( Classe classe ) throws DAOException;

	 Classe trouver( String email ) throws DAOException;
	
}
