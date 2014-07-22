package dal.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import beans.Allergie;
import dal.DAODataBaseManager;
import dal.DAOException;
import dal.DAOFactory;
import dal.dao.AllergieDao;

public class AllergieDaoImpl extends SuperDaoImpl implements AllergieDao {

	
	final static String SQL_INSERT_ALLERGIE = "INSERT INTO allergies (Libelle) VALUES (?)";
	//RC Ajout requete suppression
	final static String SQL_SUPPR_ALLERGIE = "DELETE FROM allergies WHERE Libelle = (?)";
	final static String SQL_SELECT_ALLERGIE_PAR_LIBELLE = "SELECT * FROM allergies where libelle = ?";
	final static String SQL_SELECT_ALL = "SELECT * FROM allergies";
	private static final String SQL_SELECT_ALLERGIE_ELEVE = "SELECT Libelle, Allergies.ID_allergie from Allergies, Allergique where ID_personne = ? AND Allergies.ID_allergie = Allergique.ID_allergie"; 
	
	public AllergieDaoImpl(DAOFactory daoFactory) {
		super(daoFactory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Allergie trouver(String nomAllergie) throws DAOException {

		 Connection connexion = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;
		    Allergie allergie = null;

		    try {
		        /* Récupération d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement = DAODataBaseManager.initialisationRequetePreparee( connexion, SQL_SELECT_ALLERGIE_PAR_LIBELLE, false, nomAllergie);
		        resultSet = preparedStatement.executeQuery();
		        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
		        if ( resultSet.next() ) {

		        	allergie = map( resultSet );

		        	
		        }
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } finally {
		    	DAODataBaseManager.fermeturesSilencieuses( resultSet, preparedStatement, connexion );
		    }

		    return allergie;
		
	}
	
	@Override
	public int creer(Allergie allergie) throws DAOException {

		Connection connexion = null;
	    PreparedStatement preparedStatement = null;

        ResultSet valeursAutoGenerees = null;

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();

	  	  		 preparedStatement = DAODataBaseManager.initialisationRequetePreparee( connexion, SQL_INSERT_ALLERGIE, true, 
	  	  				 	allergie.getLibelle());
	  	  
	  	   int statut = preparedStatement.executeUpdate();
	        /* Analyse du statut retourné par la requête d'insertion */
	        if ( statut == 0 ) {
	            throw new DAOException( "Échec de la création de l'utilisateur, aucune ligne ajoutée dans la table." );
	        }
	        
	        
	        /* Récupération de l'id auto-généré par la requête d'insertion */
	        valeursAutoGenerees = preparedStatement.getGeneratedKeys();
	        if ( valeursAutoGenerees.next() ) {
	            /* Puis initialisation de la propriété id du bean Utilisateur avec sa valeur */
	            return valeursAutoGenerees.getInt( "ID_allergie" );
	        } else {
	            throw new DAOException( "Échec de la création de l'utilisateur en base, aucun ID auto-généré retourné." );
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        DAODataBaseManager.fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
	    }
		
		
	}
	
	//RC Ajout methode suppression
	@Override
	public void supprimer(Allergie allergie) throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {
			connexion = daoFactory.getConnection();
			preparedStatement = DAODataBaseManager.initialisationRequetePreparee(connexion,	SQL_SUPPR_ALLERGIE, true, allergie.getLibelle());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			//RC Ajout msg d'erreur sql graphique
			JFrame jf = new JFrame();
			JOptionPane.showMessageDialog(jf,"Erreur de suppression : \n\n" + e, "Erreur SQL", JOptionPane.WARNING_MESSAGE);
			throw new DAOException(e);			
		} finally {
			DAODataBaseManager.fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);
		}

	}
	
	@Override
	public ArrayList<Allergie> getAll() throws DAOException {

		 Connection connexion = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;
		    Allergie allergie = null;
		    ArrayList<Allergie> listeAllergies = new ArrayList<Allergie>();
		    
		    try {
		        /* Récupération d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement = DAODataBaseManager.initialisationRequetePreparee( connexion, SQL_SELECT_ALL, false);
		        resultSet = preparedStatement.executeQuery();
		        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
		  
		        	  while ( resultSet.next() ) {
		        		
		        		  allergie = map( resultSet );
		        		  listeAllergies.add(allergie);
		        		   
		        	  }
		        	
		        	return listeAllergies;
		        
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } finally {
		    	DAODataBaseManager.fermeturesSilencieuses( resultSet, preparedStatement, connexion );
		    }
	}
	
	public ArrayList<Allergie> getAllParEleve(int idPersonne) {
		
		 Connection connexion = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;
		    Allergie allergie = null;
		    ArrayList<Allergie> listeAllergies = new ArrayList<Allergie>();
		    
		    try {
		        /* Récupération d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement = DAODataBaseManager.initialisationRequetePreparee( connexion, SQL_SELECT_ALLERGIE_ELEVE, false);
		        resultSet = preparedStatement.executeQuery();
		        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
		  
		        	  while ( resultSet.next() ) {
		        		
		        		  allergie = map( resultSet );
		        		  listeAllergies.add(allergie);
		        		   
		        	  }
		        	
		        	return listeAllergies;
		        
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } finally {
		    	DAODataBaseManager.fermeturesSilencieuses( resultSet, preparedStatement, connexion );
		    }
			
		
		
	}
	
	public static Allergie map( ResultSet resultSet ) throws SQLException {
		
		//RC changement via le constructeur beans
		Allergie allergie = new Allergie(resultSet.getInt("ID_allergie"), resultSet.getString("Libelle"));		
	    return allergie;
	    
	}
	
}
