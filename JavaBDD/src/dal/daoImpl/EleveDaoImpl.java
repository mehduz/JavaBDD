package dal.daoImpl;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import dal.DAODataBaseManager;
import dal.DAOException;
import dal.DAOFactory;
import dal.dao.EleveDao;
import beans.Eleve;

public class EleveDaoImpl implements EleveDao {

	 private DAOFactory   daoFactory;
	 private static final String SQL_SELECT_PAR_EMAIL = "SELECT id, email, nom, mot_de_passe, date_inscription FROM Utilisateur WHERE email = ?";
	 private static final String SQL_SELECT_PAR_LOGIN_MDP = "SELECT ID_personne FROM Authentication WHERE Login = ? and MDP = ?";
		
	   public EleveDaoImpl( DAOFactory daoFactory ) {
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
		
		 Connection connexion = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;
		    Eleve eleve = null;

		    try {
		        /* Récupération d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement = DAODataBaseManager.initialisationRequetePreparee( connexion, SQL_SELECT_PAR_LOGIN_MDP, false, login, mdp);
		        resultSet = preparedStatement.executeQuery();
		        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
		        if ( resultSet.next() ) {
		        	eleve = map( resultSet );
		        }
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } finally {
		    	DAODataBaseManager.fermeturesSilencieuses( resultSet, preparedStatement, connexion );
		    }

		    return eleve;
	}
	
	/*
	 * Simple méthode utilitaire permettant de faire la correspondance (le
	 * mapping) entre une ligne issue de la table des utilisateurs (un
	 * ResultSet) et un bean Utilisateur.
	 */
	private static Eleve map( ResultSet resultSet ) throws SQLException {
		Eleve eleve = new Eleve();

		eleve.setCode_postal(resultSet.getInt("ID_personne"));
		
	    return eleve;
	}
	
	

}	
