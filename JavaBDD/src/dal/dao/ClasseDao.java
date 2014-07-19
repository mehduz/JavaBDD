package dal.dao;

import beans.Classe;
import dal.DAOException;

public interface ClasseDao {

	 int creer( Classe classe ) throws DAOException;

	 Classe trouver( String nom_classe ) throws DAOException;
	
}
