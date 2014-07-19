package dal.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import beans.Eleve;
import beans.Matiere;
import dal.DAODataBaseManager;
import dal.DAOException;
import dal.DAOFactory;
import dal.dao.MatiereDao;
 
public class MatiereDaoImpl  extends SuperDaoImpl implements MatiereDao {

	 private static final String SQL_INSERT_MATIERE = "INSERT INTO matiere (Nom_matiere) VALUES (?)";
		
	
	public MatiereDaoImpl(DAOFactory daoFactory) {
		super(daoFactory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int creer(Matiere matiere) throws DAOException {
		// TODO Auto-generated method stub


		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();

	  	  		 preparedStatement = DAODataBaseManager.initialisationRequetePreparee( connexion, SQL_INSERT_MATIERE, true, 
	  	  				matiere.getNom_matiere());
	  	  
	  	   int statut = preparedStatement.executeUpdate();
	        /* Analyse du statut retourné par la requête d'insertion */
	        if ( statut == 0 ) {
	            throw new DAOException( "Échec de la création de l'utilisateur, aucune ligne ajoutée dans la table." );
	        }
	        
	    
	        return 1;
	        
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	    	DAODataBaseManager.fermeturesSilencieuses( preparedStatement, connexion );
	    }
		
	}

	
	public static Matiere map( ResultSet resultSet ) throws SQLException {
		
		Matiere m = new Matiere();
		m.setNom_matiere(resultSet.getString("Nom_matiere"));
		
		return m;
	}
	
	@Override
	public Matiere trouver(String nom_matiere) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
