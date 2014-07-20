package dal.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import beans.Contact;
import beans.Vaccin;
import dal.DAODataBaseManager;
import dal.DAOException;
import dal.DAOFactory;
import dal.dao.VaccinDao;

public class VaccinDaoImpl extends SuperDaoImpl implements VaccinDao {

	final static String SQL_INSERT_VACCIN = "INSERT INTO vaccins (Libelle) VALUES (?)";
	final static String SQL_SELECT_VACCIN_PAR_LIBELLE = "SELECT * FROM vaccins where libelle = ?";
	final static String SQL_SELECT_ALL = "SELECT * FROM vaccins";
	
	public VaccinDaoImpl(DAOFactory daoFactory) {
		super(daoFactory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int creer(Vaccin vaccin) throws DAOException {
		
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;

        ResultSet valeursAutoGenerees = null;

	    try {
	        /* R�cup�ration d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();

	  	  		 preparedStatement = DAODataBaseManager.initialisationRequetePreparee( connexion, SQL_INSERT_VACCIN, true, 
	  	  				 	vaccin.getLibelle());
	  	  
	  	   int statut = preparedStatement.executeUpdate();
	        /* Analyse du statut retourn� par la requ�te d'insertion */
	        if ( statut == 0 ) {
	            throw new DAOException( "�chec de la cr�ation de l'utilisateur, aucune ligne ajout�e dans la table." );
	        }
	        
	        
	        /* R�cup�ration de l'id auto-g�n�r� par la requ�te d'insertion */
	        valeursAutoGenerees = preparedStatement.getGeneratedKeys();
	        if ( valeursAutoGenerees.next() ) {
	            /* Puis initialisation de la propri�t� id du bean Utilisateur avec sa valeur */
	            return valeursAutoGenerees.getInt( "ID_vaccin" );
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
	public Vaccin trouver(String nomVaccin) throws DAOException {

		 Connection connexion = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;
		    Vaccin vaccin = null;

		    try {
		        /* R�cup�ration d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement = DAODataBaseManager.initialisationRequetePreparee( connexion, SQL_SELECT_VACCIN_PAR_LIBELLE, false, nomVaccin);
		        resultSet = preparedStatement.executeQuery();
		        /* Parcours de la ligne de donn�es de l'�ventuel ResulSet retourn� */
		        if ( resultSet.next() ) {

		        		  vaccin = map( resultSet );

		        	
		        }
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } finally {
		    	DAODataBaseManager.fermeturesSilencieuses( resultSet, preparedStatement, connexion );
		    }

		    return vaccin;
		
	}
	
	@Override
	public ArrayList<Vaccin> getAll() throws DAOException {

		 Connection connexion = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;
		    Vaccin vaccin = null;
		    ArrayList<Vaccin> listeVaccins = new ArrayList<Vaccin>();
		    
		    try {
		        /* R�cup�ration d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement = DAODataBaseManager.initialisationRequetePreparee( connexion, SQL_SELECT_ALL, false);
		        resultSet = preparedStatement.executeQuery();
		        /* Parcours de la ligne de donn�es de l'�ventuel ResulSet retourn� */
		  
		        	  while ( resultSet.next() ) {
		        		
		        		  vaccin = map( resultSet );
		        		  listeVaccins.add(vaccin);
		        		   
		        	  }
		        	
		        	return listeVaccins;
		        
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } finally {
		    	DAODataBaseManager.fermeturesSilencieuses( resultSet, preparedStatement, connexion );
		    }
	}
	
	
	private static Vaccin map( ResultSet resultSet ) throws SQLException {
		Vaccin vaccin = new Vaccin();

		vaccin.setLibelle(resultSet.getString("Libelle"));
		
	    return vaccin;
	}
	

}
