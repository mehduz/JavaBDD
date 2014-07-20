package dal.dao;

import java.util.ArrayList;

import beans.Medecin;
import dal.DAOException;

public interface MedecinDao {

	int creer( Medecin medecin ) throws DAOException;

	Medecin trouver( int id_personne ) throws DAOException;

	ArrayList<Medecin> getAll() throws DAOException;
	
}
