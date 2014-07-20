package dal.dao;

import java.util.ArrayList;

import beans.Classe;
import dal.DAOException;

public interface ClasseDao {

	 int creer( Classe classe ) throws DAOException;

	 Classe trouver( String nom_classe ) throws DAOException;

	ArrayList<Classe> getAll() throws DAOException;
	
}
