package dal.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import beans.Contact;
import dal.DAODataBaseManager;
import dal.DAOException;
import dal.DAOFactory;
import dal.dao.ContactDao;

public class ContactDaoImpl  extends SuperDaoImpl implements ContactDao {

//	/*Cr�ation de la personne*/
//	INSERT INTO personne (Nom, Prenom, Email, Tel_domicile, Tel_mobile) VALUES (?, ?, ?, ?, ?);
//	/*R�cup�ration de son ID_personne g�n�rer par auto_increment*/
//	SELECT ID_personne FROM personne WHERE Nom = ? AND Prenom = ? AND Email = ?;
//	/*Cr�ation du profil contact � l'aide de l'ID_personne pr�c�demment r�cup�r�*/
	
	final static String SQL_INSERT_CONTACT = "INSERT INTO contact (Adresse_contact, ID_personne) VALUES (?, ?)";
	
	public ContactDaoImpl(DAOFactory daoFactory) {
		super(daoFactory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int creer(Contact contact) throws DAOException {
		// TODO Auto-generated method stub
	
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;

        ResultSet valeursAutoGenerees = null;

	    try {
	        /* R�cup�ration d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	  	  preparedStatement = DAODataBaseManager.initialisationRequetePreparee( 
	  			  connexion, SQL_INSERT_CONTACT , true,  contact.getAdresse(), contact.getID_personne());
	  	  
	          int statut = preparedStatement.executeUpdate();
	        /* Analyse du statut retourn� par la requ�te d'insertion */
	        if ( statut == 0 ) {
	            throw new DAOException( "�chec de la cr�ation de l'utilisateur, aucune ligne ajout�e dans la table." );
	        }

	        /* R�cup�ration de l'id auto-g�n�r� par la requ�te d'insertion */
	        valeursAutoGenerees = preparedStatement.getGeneratedKeys();
	        if ( valeursAutoGenerees.next() ) {
	            /* Puis initialisation de la propri�t� id du bean Utilisateur avec sa valeur */
	        	
	           return valeursAutoGenerees.getInt( "ID_contact" );
	        } else {
	            throw new DAOException( "�chec de la cr�ation de l'utilisateur en base, aucun ID auto-g�n�r� retourn�." );
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        DAODataBaseManager.fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
	    }

	}

	@Override
	public Contact trouver(String id_contact) throws DAOException {
		// TODO Auto-generated method stub

		return null;
	}

}
