package dal.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import beans.Eleve;
import beans.Professeur;
import dal.DAODataBaseManager;
import dal.DAOException;
import dal.DAOFactory;
import dal.dao.ProfesseurDao;

public class ProfesseurDaoImpl extends SuperDaoImpl implements ProfesseurDao {

	
	 private static final String SQL_SELECT_PAR_LOGIN_MDP = "SELECT ID_personne FROM Authentication WHERE Login = ? and MDP = ?";
	 private static final String SQL_SELECT_PROFESSEUR_PAR_ID_PERSONNE = "SELECT * FROM Professeur, Personne WHERE Professeur.ID_personne = ? AND Professeur.ID_personne = Personne.ID_personne ";
			
	
	public ProfesseurDaoImpl(DAOFactory daoFactory) {
		super(daoFactory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void creer(Professeur classe) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Professeur trouver(String id_prof) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public Professeur trouver(String login, String mdp) throws DAOException {
		
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    Professeur professeur = null;

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = DAODataBaseManager.initialisationRequetePreparee( connexion, SQL_SELECT_PAR_LOGIN_MDP, false, login, mdp);
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        if ( resultSet.next() ) {

	        	  preparedStatement = DAODataBaseManager.initialisationRequetePreparee( connexion, SQL_SELECT_PROFESSEUR_PAR_ID_PERSONNE, false, resultSet.getInt("ID_personne"));
	        	  resultSet = preparedStatement.executeQuery();
			     
	        	  if ( resultSet.next() ) {
	        		  
	        		  professeur = map( resultSet );
	        		   
	        	  }
	        	
	        	
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	    	DAODataBaseManager.fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }

	    return professeur;
		
	}
	
	private static Professeur map( ResultSet resultSet ) throws SQLException {
		Professeur professeur = new Professeur();

		professeur.setEmail(resultSet.getString("Email"));
		professeur.setNom(resultSet.getString("Nom"));
		professeur.setPrenom(resultSet.getString("Prenom"));
		professeur.setTel_domicile(resultSet.getInt("Tel_domicile"));
		professeur.setTel_mobile(resultSet.getInt("Tel_mobile"));
		professeur.setID_prof(resultSet.getInt("ID_prof"));
		
	    return professeur;
	}
	
	
}
