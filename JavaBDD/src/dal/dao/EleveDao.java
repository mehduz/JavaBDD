package dal.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dal.DAOException;
import beans.*;


public interface EleveDao {
	
	 int creer( Eleve eleve ) throws DAOException;

	 Eleve trouver( int idPersonne ) throws DAOException;

	 ArrayList<Eleve> getAll() throws DAOException ;
	 
	 ArrayList<Eleve> getAllParClasse(String nomClasse);

	 ArrayList<Eleve> getAllParMatiere(String nomMatiere) throws DAOException;
	
	 ArrayList<Eleve> getAllParIdProf(int idProf) throws DAOException;
	 
} 