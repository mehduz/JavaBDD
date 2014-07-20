package dal.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.PreparedStatement;

import beans.Eleve;
import beans.Suivi;
import dal.DAODataBaseManager;
import dal.DAOException;
import dal.DAOFactory;
import dal.dao.SuiviDao;

public class SuiviDaoImpl extends SuperDaoImpl implements SuiviDao {
	
	
	private static final String SQL_INSERT_SUIVI = "INSERT INTO suivi (Note_CC, Note_examen, Matricule, ID_personne, Nom_matiere) VALUES (?, ?, ?, ?, ?)";
	private static final String SQL_SELECT_PAR_ID_PERSONNE = "SELECT * FROM Suivi WHERE ID_personne = ?";
	private	static final String SQL_SELECT_ALL = "SELECT * FROM Suivi";
	
	
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

	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	  	  preparedStatement = DAODataBaseManager.initialisationRequetePreparee( 
	  			  connexion, SQL_INSERT_SUIVI , true, suivi.getNote_CC(), suivi.getNote_examen(), suivi.getMatricule(),
	  			  suivi.getID_personne(), suivi.getNom_matiere());
	  	  
	          int statut = preparedStatement.executeUpdate();
	        /* Analyse du statut retourné par la requête d'insertion */
	        if ( statut == 0 ) {
	            throw new DAOException( "Échec de la création de l'utilisateur, aucune ligne ajoutée dans la table." );
	        }

	        /* Récupération de l'id auto-généré par la requête d'insertion */
	        valeursAutoGenerees = preparedStatement.getGeneratedKeys();
	        if ( valeursAutoGenerees.next() ) {
	            /* Puis initialisation de la propriété id du bean Utilisateur avec sa valeur */
	        	
	           return valeursAutoGenerees.getInt( "ID_suivi" );
	        } else {
	            throw new DAOException( "Échec de la création de l'utilisateur en base, aucun ID auto-généré retourné." );
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        DAODataBaseManager.fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
	    }	

	}

	
	
	public ArrayList<Suivi> getAll() {
		
		 Connection connexion = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;
		    Suivi suivi = null;
		    ArrayList<Suivi> listeSuivis = new ArrayList<Suivi>();
		    
		    try {
		        /* Récupération d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement = DAODataBaseManager.initialisationRequetePreparee( connexion, SQL_SELECT_ALL, false);
		        resultSet = preparedStatement.executeQuery();
		        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
		  
		        	  while ( resultSet.next() ) {
		        		
		        		  Eleve eleveCorrespondant = this.daoFactory.getEleveDao().trouver(resultSet.getInt("ID_personne"));
		        		  
		        		  suivi = mapAvecEleve( resultSet, eleveCorrespondant );
		        		  listeSuivis.add(suivi);
		        		   
		        	  }
		        	
		        	return listeSuivis;
		        
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } finally {
		    	DAODataBaseManager.fermeturesSilencieuses( resultSet, preparedStatement, connexion );
		    }

		
	}

	public ArrayList<Suivi> getAllParMatiere(String nomMatiere) {
		
		 Connection connexion = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;
		    Suivi suivi = null;
		    ArrayList<Suivi> listeSuivis = new ArrayList<Suivi>();
		    
		    try {
		        /* Récupération d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement = DAODataBaseManager.initialisationRequetePreparee( connexion, SQL_SELECT_ALL, false, nomMatiere);
		        resultSet = preparedStatement.executeQuery();
		        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
		  
		        	  while ( resultSet.next() ) {
		        		
		        		  Eleve eleveCorrespondant = this.daoFactory.getEleveDao().trouver(resultSet.getInt("ID_personne"));
		        		  
		        		  suivi = mapAvecEleve( resultSet, eleveCorrespondant );
		        		  listeSuivis.add(suivi);
		        		   
		        	  }
		        	
		        	return listeSuivis;
		        
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } finally {
		    	DAODataBaseManager.fermeturesSilencieuses( resultSet, preparedStatement, connexion );
		    }

		
	}
	

			
	public ArrayList<Suivi> getAllParEleve(int idPersonne) {
		
	 	Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    Suivi suivi = null;
	    ArrayList<Suivi> listeSuivis = new ArrayList<Suivi>();
	    
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = DAODataBaseManager.initialisationRequetePreparee( connexion, SQL_SELECT_PAR_ID_PERSONNE, false, idPersonne);
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	  
	        	  while ( resultSet.next() ) {

	        		  suivi = map( resultSet );
	        		  listeSuivis.add(suivi);
	        		   
	        	  }
	        	
	        	return listeSuivis;
	        
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	    	DAODataBaseManager.fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }
		
		
	}
	
	private static Suivi mapAvecEleve( ResultSet resultSet, Eleve eleve ) throws SQLException {
		Suivi suivi = new Suivi();

		suivi.setID_personne(resultSet.getInt("ID_personne"));
		suivi.setMatricule(resultSet.getInt("Matricule"));
		suivi.setNom_matiere(resultSet.getString("Nom_matiere"));
		suivi.setNote_CC(resultSet.getInt("Note_CC"));
		suivi.setNote_examen(resultSet.getInt("Note_examen"));
		suivi.setEleve(eleve);
		
	    return suivi;
	}
	
	private static Suivi map( ResultSet resultSet) throws SQLException {
		Suivi suivi = new Suivi();

		suivi.setID_personne(resultSet.getInt("ID_personne"));
		suivi.setMatricule(resultSet.getInt("Matricule"));
		suivi.setNom_matiere(resultSet.getString("Nom_matiere"));
		suivi.setNote_CC(resultSet.getInt("Note_CC"));
		suivi.setNote_examen(resultSet.getInt("Note_examen"));
		
	    return suivi;
	}

}
 