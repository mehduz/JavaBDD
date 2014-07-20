package dal.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import beans.Eleve;
import beans.Personne;
import beans.Professeur;
import dal.DAODataBaseManager;
import dal.DAOException;
import dal.DAOFactory;
import dal.dao.PersonneDao;

public class PersonneDaoImpl extends SuperDaoImpl implements PersonneDao {

//	/*Cr�ation de la personne*/
//	INSERT INTO personne (Nom, Prenom, Email, Tel_domicile, Tel_mobile) VALUES (?, ?, ?, ?, ?);
//	/*R�cup�ration de son ID_personne g�n�rer par auto_increment*/
//	SELECT ID_personne FROM personne WHERE Nom = ? AND Prenom = ? AND Email = ?;
//	/*Cr�ation du profil contact � l'aide de l'ID_personne pr�c�demment r�cup�r�*/
//	INSERT INTO contact (Adresse_contact, ID_personne) VALUES (?, ?);
	
	
	final static String SQL_INSERT_PERSONNE = "INSERT INTO personne (Nom, Prenom, Email, Tel_domicile, Tel_mobile) VALUES (?, ?, ?, ?, ?)";
	final static String SQL_SELECT_PERSONNE_PAR_ID = "SELECT * FROM Personne where ID_personne = ?";
	
	public PersonneDaoImpl(DAOFactory daoFactory) {
		super(daoFactory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int creer(Personne personne) throws DAOException {

		
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;

        ResultSet valeursAutoGenerees = null;

	    try {
	        /* R�cup�ration d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	  	  preparedStatement = DAODataBaseManager.initialisationRequetePreparee( 
	  			  connexion, SQL_INSERT_PERSONNE , true,  personne.getNom(), 
	  			  personne.getPrenom() , personne.getEmail() , personne.getTel_domicile() , personne.getTel_mobile());
	  	  
	          int statut = preparedStatement.executeUpdate();
	        /* Analyse du statut retourn� par la requ�te d'insertion */
	        if ( statut == 0 ) {
	            throw new DAOException( "�chec de la cr�ation de l'utilisateur, aucune ligne ajout�e dans la table." );
	        }
	        
	        
	        
	        /* R�cup�ration de l'id auto-g�n�r� par la requ�te d'insertion */
	        valeursAutoGenerees = preparedStatement.getGeneratedKeys();
	        if ( valeursAutoGenerees.next() ) {
	            /* Puis initialisation de la propri�t� id du bean Utilisateur avec sa valeur */
	        	
	           return valeursAutoGenerees.getInt( "ID_personne" );
	        } else {
	            throw new DAOException( "�chec de la cr�ation de l'utilisateur en base, aucun ID auto-g�n�r� retourn�." );
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        DAODataBaseManager.fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
	    }
	    
	
	

	   // return eleve;
		
		
	}

	@Override
	public Personne trouver(int idPersonne) throws DAOException {


		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    Personne personne = null;

	    try {
	        /* R�cup�ration d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = DAODataBaseManager.initialisationRequetePreparee( connexion, SQL_SELECT_PERSONNE_PAR_ID, false, idPersonne);
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de donn�es de l'�ventuel ResulSet retourn� */
	        if ( resultSet.next() ) {

	        	personne = map( resultSet );
	        		   
	        	  
	        	
	        	
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	    	DAODataBaseManager.fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }

	    return personne;
		
		
	}
	
	/*
	 * Simple m�thode utilitaire permettant de faire la correspondance (le
	 * mapping) entre une ligne issue de la table des utilisateurs (un
	 * ResultSet) et un bean Utilisateur.
	 */
	private static Personne map( ResultSet resultSet ) throws SQLException {
		Personne personne = new Personne();

		personne.setEmail(resultSet.getString("Email"));
		personne.setID_personne(resultSet.getInt("ID_personne"));
		personne.setNom(resultSet.getString("Nom"));
		personne.setPrenom(resultSet.getString("Prenom"));
		personne.setTel_domicile(resultSet.getInt("Tel_domicile"));
		personne.setTel_mobile(resultSet.getInt("Tel_mobile"));

	    return personne;
	}

	


}
