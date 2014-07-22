package dal.dao;

import java.util.ArrayList;

import beans.Vaccin;
import dal.DAOException;

public interface VaccinDao {

	int creer( Vaccin vaccin ) throws DAOException;
	
	void supprimer(Vaccin vaccin) throws DAOException;

	Vaccin trouver( String nomVaccin ) throws DAOException;

	ArrayList<Vaccin> getAll() throws DAOException;

	ArrayList<Vaccin> getAllParEleve(int idPersonne) throws DAOException;
	
} 
