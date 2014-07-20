package dal.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Authentication;
import dal.DAODataBaseManager;
import dal.DAOException;
import dal.DAOFactory;
import dal.dao.AuthenticationDao;

public class AuthenticationDaoImpl extends SuperDaoImpl implements AuthenticationDao {

	private final static String SQL_SELECT_PAR_LOGIN_MDP = "SELECT ID_personne, Type_personne FROM Authentication WHERE Login = ? and MDP = ?";
	
	public AuthenticationDaoImpl(DAOFactory daoFactory) {
		super(daoFactory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Authentication trouver(String login, String mdp) {
	
		 Connection connexion = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;
		    Authentication auth = null;

		    try {
		        /* Récupération d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement = DAODataBaseManager.initialisationRequetePreparee( connexion, SQL_SELECT_PAR_LOGIN_MDP, false, login, mdp);
		        resultSet = preparedStatement.executeQuery();
		        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
		        if ( resultSet.next() ) {

		        		  
		        	auth = map( resultSet );

		            return auth;
		        }
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } finally {
		    	DAODataBaseManager.fermeturesSilencieuses( resultSet, preparedStatement, connexion );
		    }
		    
			return auth;

			
		
		
	}

	private static Authentication map( ResultSet resultSet ) throws SQLException {
		
		Authentication auth = new Authentication();

		auth.setID_personne(resultSet.getLong("ID_personne"));
		auth.setType_personne(resultSet.getInt("Type_personne"));
		
	    return auth;
	}
	
	
}
