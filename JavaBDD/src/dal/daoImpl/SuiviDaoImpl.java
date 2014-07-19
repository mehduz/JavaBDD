package dal.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import beans.Eleve;
import beans.Suivi;
import dal.DAODataBaseManager;
import dal.DAOException;
import dal.DAOFactory;
import dal.dao.SuiviDao;

public class SuiviDaoImpl extends SuperDaoImpl implements SuiviDao {
	
	
	private static final String SQL_INSERT_SUIVI = "INSERT INTO suivi (Note_CC, Note_examen, Matricule, ID_personne, Nom_matiere) VALUES (?, ?, ?, ?, ?)";
	private static final String SQL_SELECT_PAR_ID_PERSONNE = "SELECT * FROM Authentication WHERE ID_personne = ?";
		
	
	
	public SuiviDaoImpl(DAOFactory daoFactory) {
		super(daoFactory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int creer(Suivi suivi) throws DAOException {

		// TODO Auto-generated method stub
		
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;

        ResultSet valeursAutoGenerees = null;

	    try {

	        /* R�cup�ration d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	  	  preparedStatement = DAODataBaseManager.initialisationRequetePreparee( 
	  			  connexion, SQL_INSERT_SUIVI , true, suivi.getNote_CC(), suivi.getNote_examen(), suivi.getMatricule(),
	  			  suivi.getID_personne(), suivi.getNom_matiere());
	  	  
	          int statut = preparedStatement.executeUpdate();
	        /* Analyse du statut retourn� par la requ�te d'insertion */
	        if ( statut == 0 ) {
	            throw new DAOException( "�chec de la cr�ation de l'utilisateur, aucune ligne ajout�e dans la table." );
	        }

	        /* R�cup�ration de l'id auto-g�n�r� par la requ�te d'insertion */
	        valeursAutoGenerees = preparedStatement.getGeneratedKeys();
	        if ( valeursAutoGenerees.next() ) {
	            /* Puis initialisation de la propri�t� id du bean Utilisateur avec sa valeur */
	        	
	           return valeursAutoGenerees.getInt( "ID_suivi" );
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
	public Suivi trouver(int idPersonne) throws DAOException {

		 Connection connexion = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;
		    Suivi suivi = null;

		    try {
		        /* R�cup�ration d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement = DAODataBaseManager.initialisationRequetePreparee( connexion, SQL_SELECT_PAR_ID_PERSONNE, false, idPersonne);
		        resultSet = preparedStatement.executeQuery();
		        /* Parcours de la ligne de donn�es de l'�ventuel ResulSet retourn� */
		        if ( resultSet.next() ) {

		        		  suivi = map( resultSet );

		        }
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } finally {
		    	DAODataBaseManager.fermeturesSilencieuses( resultSet, preparedStatement, connexion );
		    }

		    return suivi;
		
	}
	
	private static Suivi map( ResultSet resultSet ) throws SQLException {
		Suivi suivi = new Suivi();

		suivi.setID_personne(resultSet.getInt("ID_personne"));
		suivi.setMatricule(resultSet.getInt("Matricule"));
		suivi.setNom_matiere(resultSet.getString("Nom_matiere"));
		suivi.setNote_CC(resultSet.getInt("Note_CC"));
		suivi.setNote_examen(resultSet.getInt("Note_examen"));
		
	    return suivi;
	}

}
 