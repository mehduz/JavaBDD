package dal.dao;

import java.util.ArrayList;

import beans.Matiere;
import dal.DAOException;

public interface MatiereDao {
	
	int creer( Matiere classe ) throws DAOException;

	Matiere trouver( String nom_matiere ) throws DAOException;

	ArrayList<Matiere> getAll() throws DAOException;
	

}
