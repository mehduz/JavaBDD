package dal.dao;
import java.util.ArrayList;

import dal.DAOException;
import beans.*;


public interface EleveDao {
	

	 int creer( Eleve eleve ) throws DAOException;

	 Eleve trouver( int idPersonne ) throws DAOException;
	 
	 Eleve trouver(String login, String mdp) throws DAOException;

	 public ArrayList<Eleve> getAll() throws DAOException ;
	 
	 public ArrayList<Eleve> getAllParClasse(String nomClasse);
	 
	// public ArrayList<Vaccin> getVaccinsEleve(int idPersonne) throws DAOException;
	 
	// public ArrayList<Allergie> getAllergiesEleve(int idPersonne) throws DAOException;
	 
} 