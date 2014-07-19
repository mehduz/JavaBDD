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
	 private static final String SQL_SELECT_ELEVE_PAR_ID_PERSONNE = "SELECT * FROM Eleve, Personne WHERE Eleve.ID_personne=? AND Eleve.ID_personne=Personne.ID_personne ";
	 
	 
//	 /*Infos de l'�l�ve */ 
//	 /*Infos globales */ 
//	 SELECT * FROM Personne WHERE ID_personne=3;
//	 /*Notes de l'�l�ve */ 
//	 SELECT (Note_CC, Note_examen) FROM Suivi WHERE ID_personne=3;
//	 /*Infos m�decin */ 
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
		        /* R�cup�ration d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement = DAODataBaseManager.initialisationRequetePreparee( connexion, SQL_SELECT_PAR_LOGIN_MDP, false, login, mdp);
		        resultSet = preparedStatement.executeQuery();
		        /* Parcours de la ligne de donn�es de l'�ventuel ResulSet retourn� */
		        if ( resultSet.next() ) {

		        	  preparedStatement = DAODataBaseManager.initialisationRequetePreparee( connexion, SQL_SELECT_PERSONNE_PAR_ID_PERSONNE, false, resultSet.getInt("ID_personne"));
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
	 * Simple m�thode utilitaire permettant de faire la correspondance (le
	 * mapping) entre une ligne issue de la table des utilisateurs (un
	 * ResultSet) et un bean Utilisateur.
	 */
	private static Eleve map( ResultSet resultSet ) throws SQLException {
		Eleve eleve = new Eleve();
//
//		eleve.setCode_postal(resultSet.getInt(""));
//		eleve.setContact(contact);
//		eleve.setDate_inscription(resultSet.getDate(columnLabel));
//		eleve.setDate_naissance(resultSet.getDate(columnLabel));
//		eleve.setEmail(resultSet.getString(""));
//		eleve.setEtablissement_prec(resultSet.getString(""));
//		eleve.setID_personne(resultSet.getInt(""));
//		eleve.setNom(nom);
//		eleve.setPays_naissance(resultSet.getString(""));
//		eleve.setPhoto(photo);
//		eleve.setPrenom(resultSet.getString(""))
//		eleve.setRemarques_medicale(resultSet.getString(""));
//		eleve.setRue(resultSet.getString(""));
//		eleve.setSexe(resultSet.getString(""));
//		eleve.setTel_domicile(resultSet.getInt(""));
//		eleve.setTel_mobile(resultSet.getInt(""));
//		eleve.setVille(resultSet.getString(""));
//		eleve.setVille_naissance(resultSet.getString(""));
//		
	    return eleve;
	}
	
	

}	
