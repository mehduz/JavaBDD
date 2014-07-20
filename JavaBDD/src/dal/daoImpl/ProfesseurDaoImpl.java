package dal.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;

import beans.Eleve;
import beans.Professeur;
import dal.DAODataBaseManager;
import dal.DAOException;
import dal.DAOFactory;
import dal.dao.ProfesseurDao;

public class ProfesseurDaoImpl extends SuperDaoImpl implements ProfesseurDao {

	
	 private static final String SQL_SELECT_PAR_LOGIN_MDP = "SELECT ID_personne FROM Authentication WHERE Login = ? and MDP = ?";
	 private static final String SQL_SELECT_PROFESSEUR_PAR_ID_PERSONNE = "SELECT * FROM Professeur, Personne WHERE Professeur.ID_personne = ? AND Professeur.ID_personne = Personne.ID_personne ";
	 private static final String SQL_INSERT_PROFESSEUR = "INSERT INTO personne (Nom, Prenom, Email, Tel_domicile, Tel_mobile) VALUES (?, ?, ?, ?, ?)";		
	 private static final String SQL_SELECT_PROFESSEUR_ALL = "SELECT * FROM Professeur, Personne WHERE  Professeur.ID_personne = Personne.ID_personne ";
	 
	 
	public ProfesseurDaoImpl(DAOFactory daoFactory) {
		super(daoFactory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int creer(Professeur professeur) throws DAOException {

		// TODO Auto-generated method stub
		
				Connection connexion = null;
			    PreparedStatement preparedStatement = null;

		        ResultSet valeursAutoGenerees = null;

			    try {
			        /* Récupération d'une connexion depuis la Factory */
			        connexion = daoFactory.getConnection();
			      
			  	  		 preparedStatement = DAODataBaseManager.initialisationRequetePreparee( connexion, 
			  	  				 SQL_INSERT_PROFESSEUR, true, professeur.getNom(), professeur.getPrenom(),
			  	  				 professeur.getEmail(), professeur.getTel_domicile(), professeur.getTel_mobile());
			  	  		 
			  	   int statut = preparedStatement.executeUpdate();
			        /* Analyse du statut retourné par la requête d'insertion */
			        if ( statut == 0 ) {
			            throw new DAOException( "Échec de la création de l'utilisateur, aucune ligne ajoutée dans la table." );
			        }
			        
			        
			        /* Récupération de l'id auto-généré par la requête d'insertion */
			        valeursAutoGenerees = preparedStatement.getGeneratedKeys();
			        if ( valeursAutoGenerees.next() ) {
			            /* Puis initialisation de la propriété id du bean Utilisateur avec sa valeur */
			            return valeursAutoGenerees.getInt( "ID_prof" );
			        } else {
			            throw new DAOException( "Échec de la création de l'utilisateur en base, aucun ID auto-généré retourné." );
			        }
			    } catch ( SQLException e ) {
			        throw new DAOException( e );
			    } finally {
			        DAODataBaseManager.fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
			    }
				
			    
		
		
	}

	@Override
	public Professeur trouver(String id_prof) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public Professeur trouver(String login, String mdp) throws DAOException {
		
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    Professeur professeur = null;

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = DAODataBaseManager.initialisationRequetePreparee( connexion, SQL_SELECT_PAR_LOGIN_MDP, false, login, mdp);
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        if ( resultSet.next() ) {

	        	  preparedStatement = DAODataBaseManager.initialisationRequetePreparee( connexion, SQL_SELECT_PROFESSEUR_PAR_ID_PERSONNE, false, resultSet.getInt("ID_personne"));
	        	  resultSet = preparedStatement.executeQuery();
			     
	        	  if ( resultSet.next() ) {
	        		  
	        		  professeur = map( resultSet );
	        		   
	        	  }
	        	
	        	
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	    	DAODataBaseManager.fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }

	    return professeur;
		
	}
	
	private static Professeur map( ResultSet resultSet ) throws SQLException {
		Professeur professeur = new Professeur();

		professeur.setEmail(resultSet.getString("Email"));
		professeur.setNom(resultSet.getString("Nom"));
		professeur.setPrenom(resultSet.getString("Prenom"));
		professeur.setTel_domicile(resultSet.getInt("Tel_domicile"));
		professeur.setTel_mobile(resultSet.getInt("Tel_mobile"));
		professeur.setID_prof(resultSet.getInt("ID_prof"));
		
	    return professeur;
	}
	
	public ArrayList<Professeur> getAll() {

		 Connection connexion = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;
		    Professeur professeur = null;
		    ArrayList<Professeur> listeProfesseurs = new ArrayList<Professeur>();
		    
		    try {
		        /* Récupération d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement = DAODataBaseManager.initialisationRequetePreparee( connexion, SQL_SELECT_PROFESSEUR_ALL, false);
		        resultSet = preparedStatement.executeQuery();
		        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
		  
		        	  while ( resultSet.next() ) {
		        		
		        		  professeur = map( resultSet );
		        		  listeProfesseurs.add(professeur);
		        		   
		        	  }
		        	
		        	return listeProfesseurs;
		        
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } finally {
		    	DAODataBaseManager.fermeturesSilencieuses( resultSet, preparedStatement, connexion );
		    }

	}
	
	
	@Override
	public Professeur trouver(int idPersonne) throws DAOException {
		// TODO Auto-generated method stub
		
		 Connection connexion = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;
		    Professeur professeur = null;

		    try {
		        /* Récupération d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement = DAODataBaseManager.initialisationRequetePreparee( connexion, SQL_SELECT_PROFESSEUR_PAR_ID_PERSONNE, false, idPersonne);
		        resultSet = preparedStatement.executeQuery();
		        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
		        if ( resultSet.next() ) {

		        	professeur = map( resultSet );

		        }
		        
		        return professeur;
		        
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } finally {
		    	DAODataBaseManager.fermeturesSilencieuses( resultSet, preparedStatement, connexion );
		    }

	}
	
}
