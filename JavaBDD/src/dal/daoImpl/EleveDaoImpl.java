package dal.daoImpl;

import java.beans.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dal.DAOException;
import dal.DAOFactory;
import dal.dao.EleveDao;
import beans.Eleve;

public class EleveDaoImpl implements EleveDao {

	 private DAOFactory   daoFactory;
	 
	    EleveDaoImpl( DAOFactory daoFactory ) {
	        this.daoFactory = daoFactory;
	    }
	
	@Override
	public void creer(Eleve eleve) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Eleve trouver(String email) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Eleve trouver(String login, String mdp) throws DAOException {
		return null;
	}
	
	/*
	 * Simple méthode utilitaire permettant de faire la correspondance (le
	 * mapping) entre une ligne issue de la table des utilisateurs (un
	 * ResultSet) et un bean Utilisateur.
	 */
	private static Eleve map( ResultSet resultSet ) throws SQLException {
		Eleve eleve = new Eleve();

	    return eleve;
	}
	
	

}	
