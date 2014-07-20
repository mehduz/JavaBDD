package dal.dao;

import java.util.ArrayList;

import beans.Suivi;
import dal.DAOException;

public interface SuiviDao {
	
	int creer( Suivi suivi ) throws DAOException;

	 ArrayList<Suivi> getAll();
		 ArrayList<Suivi> getAllParMatiere(String nomMatiere);
	
		 ArrayList<Suivi> getAllParEleve(int idPersonne);
	
	

}
