package dal.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import beans.Contact;
import beans.Eleve;
import dal.DAODataBaseManager;
import dal.DAOException;
import dal.DAOFactory;
import dal.dao.ContactDao;

public class ContactDaoImpl  extends SuperDaoImpl implements ContactDao {

	
	final static String SQL_INSERT_CONTACT = "INSERT INTO contact (Adresse_contact, ID_personne) VALUES (?, ?)";
	 private static final String SQL_SELECT_CONTACT_PAR_ID_PERSONNE = "SELECT * FROM Contact, Personne WHERE Professeur.ID_personne = ? AND Contact.ID_personne = Personne.ID_personne ";
	 private static final String SQL_SELECT_ALL = "SELECT * FROM Contact, Personne WHERE  Contact.ID_personne = Personne.ID_personne ";


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
	public Contact trouver(int id_personne) throws DAOException {

		    Connection connexion = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;
		    Contact contact = null;

		    try {
		        /* R�cup�ration d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement = DAODataBaseManager.initialisationRequetePreparee( connexion, SQL_SELECT_CONTACT_PAR_ID_PERSONNE, false, id_personne);
		        resultSet = preparedStatement.executeQuery();
		        /* Parcours de la ligne de donn�es de l'�ventuel ResulSet retourn� */
		        if ( resultSet.next() ) {

		        		  
		        	contact = map( resultSet );
		        		   
		        	  

		        }
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } finally {
		    	DAODataBaseManager.fermeturesSilencieuses( resultSet, preparedStatement, connexion );
		    }

		    return contact;
	}
	
	public ArrayList<Contact> getAll() throws DAOException{

		 Connection connexion = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;
		    Contact contact = null;
		    ArrayList<Contact> listeContact = new ArrayList<Contact>();
		    
		    try {
		        /* R�cup�ration d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement = DAODataBaseManager.initialisationRequetePreparee( connexion, SQL_SELECT_ALL, false);
		        resultSet = preparedStatement.executeQuery();
		        /* Parcours de la ligne de donn�es de l'�ventuel ResulSet retourn� */
		  
		        	  while ( resultSet.next() ) {
		        		
		        		  contact = map( resultSet );
		        		  listeContact.add(contact);
		        		   
		        	  }
		        	
		        	return listeContact;
		        
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } finally {
		    	DAODataBaseManager.fermeturesSilencieuses( resultSet, preparedStatement, connexion );
		    }

	}
	
	public static Contact map(ResultSet resultSet) throws SQLException {
		
		Contact contact = new Contact();

	contact.setNom(resultSet.getString("Nom"));
	contact.setPrenom(resultSet.getString("Prenom"));
	contact.setEmail(resultSet.getString("Email"));
	contact.setTel_domicile(resultSet.getInt("Tel_domicile"));
	contact.setTel_mobile(resultSet.getInt("Tel_mobile"));
	contact.setID_contact(resultSet.getInt("ID_contact"));
	contact.setID_personne(resultSet.getInt("ID_personne"));
	
	return contact;
	
	}
	
	

}
