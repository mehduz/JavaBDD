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
	 private static final String SQL_SELECT_ELEVE_PAR_ID_PERSONNE = "SELECT * FROM Eleve, Personne WHERE Eleve.ID_personne = ? AND Eleve.ID_personne = Personne.ID_personne ";
	 
	 
//	 /*Infos de l'élève */ 
//	 /*Infos globales */ 
//	 SELECT * FROM Personne WHERE ID_personne=3;
//	 /*Notes de l'élève */ 
//	 SELECT (Note_CC, Note_examen) FROM Suivi WHERE ID_personne=3;
//	 /*Infos médecin */ 
//	 SELECT * FROM Personne WHERE ID_personne = (SELECT ID_personne FROM Medecin WHERE ID_medecin =(SELECT ID_medecin FROM Eleve WHERE ID_personne=3));
//	 /*Infos contact */
//	 SELECT * FROM Personne WHERE ID_personne = (SELECT ID_personne FROM Contact WHERE ID_contact =(SELECT ID_contact FROM Eleve WHERE ID_personne=3));--Infos tuteur
//	 /*Infos tuteur*/ 
//	 SELECT * FROM Personne WHERE ID_personne = (SELECT ID_prof FROM Eleve WHERE ID_personne = 3);
// 
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

		        	  preparedStatement = DAODataBaseManager.initialisationRequetePreparee( connexion, SQL_SELECT_ELEVE_PAR_ID_PERSONNE, false, resultSet.getInt("ID_personne"));
		        	  resultSet = preparedStatement.executeQuery();
				     
		        	  if ( resultSet.next() ) {
		        		  
		        		  eleve = map( resultSet );
		        		  
		        	  }
		        	
		        	
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

		eleve.setCode_postal(resultSet.getInt("Code_postal"));
		eleve.setDate_inscription(resultSet.getDate("Date_inscription"));
		eleve.setDate_naissance(resultSet.getDate("Date_naissance"));
		eleve.setEmail(resultSet.getString("Email"));
		eleve.setEtablissement_prec(resultSet.getString("Etablissement_prec"));
		eleve.setID_personne(resultSet.getString("ID_personne"));
		eleve.setNom(resultSet.getString("Nom"));
		eleve.setPays_naissance(resultSet.getString("Pays_naissance"));
		eleve.setPhoto(resultSet.getString("Photo"));
		eleve.setPrenom(resultSet.getString("Prenom"));
		eleve.setRemarques_medicale(resultSet.getString("Remarques_medicale"));
		eleve.setRue(resultSet.getString("Rue"));
		eleve.setSexe(resultSet.getString("Sexe"));
		eleve.setTel_domicile(resultSet.getInt("Tel_domicile"));
		eleve.setTel_mobile(resultSet.getInt("Tel_mobile"));
    	eleve.setVille(resultSet.getString("Ville"));
		eleve.setVille_naissance(resultSet.getString("Ville_naissance"));
		
	    return eleve;
	}
	
	

}	
