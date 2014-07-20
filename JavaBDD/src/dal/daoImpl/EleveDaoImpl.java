package dal.daoImpl;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.PreparedStatement;

import dal.DAODataBaseManager;
import dal.DAOException;
import dal.DAOFactory;
import dal.dao.EleveDao;
import beans.Eleve;
import beans.Matiere;

public class EleveDaoImpl  extends SuperDaoImpl implements EleveDao {

	

	 private static final String SQL_SELECT_ALL = "SELECT * FROM Eleve, Personne WHERE Eleve.ID_personne = Personne.ID_personne ";
	 private static final String SQL_SELECT_PAR_LOGIN_MDP = "SELECT ID_personne FROM Authentication WHERE Login = ? and MDP = ?";
	 private static final String SQL_SELECT_ELEVE_PAR_ID_PERSONNE = "SELECT * FROM Eleve, Personne WHERE Eleve.ID_personne = ? AND Eleve.ID_personne = Personne.ID_personne ";
	 private static final String SQL_INSERT_ELEVE = "INSERT INTO eleve (Date_naissance, Ville_naissance, Pays_naissance,Sexe,"+
			 "Date_inscription, Etablissement_prec, Photo, Rue,"+
			 "Code_postal, Ville, Email,Remarques_medicale, ID_personne, Nom_classe,"+
			 " ID_contact, ID_prof) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	 private static final String SQL_SELECT_ELEVE_MATIERE = "SELECT * FROM eleve, matieres";
	 

	 public EleveDaoImpl(DAOFactory daoFactory) {
			super(daoFactory);
			// TODO Auto-generated constructor stub
		}
	 
	@Override
	public int creer(Eleve eleve) throws DAOException {
		// TODO Auto-generated method stub
		
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;

        ResultSet valeursAutoGenerees = null;

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	      
	  	  		 preparedStatement = DAODataBaseManager.initialisationRequetePreparee( connexion, SQL_INSERT_ELEVE, true, 
	  			 eleve.getDate_naissance(), eleve.getVille_naissance(), eleve.getPays_naissance(), eleve.getDate_inscription(), 
	 			 eleve.getEtablissement_prec(), eleve.getPhoto(), eleve.getRue(), eleve.getCode_postal(), eleve.getVille(),
	 			 eleve.getEmail(), eleve.getRemarques_medicale(), eleve.getID_personne(), eleve.getNom_classe(), eleve.getID_contact(),
	 			 eleve.getID_prof());
	  	  
	  	   int statut = preparedStatement.executeUpdate();
	        /* Analyse du statut retourné par la requête d'insertion */
	        if ( statut == 0 ) {
	            throw new DAOException( "Échec de la création de l'utilisateur, aucune ligne ajoutée dans la table." );
	        }
	        
	        
	        /* Récupération de l'id auto-généré par la requête d'insertion */
	        valeursAutoGenerees = preparedStatement.getGeneratedKeys();
	        if ( valeursAutoGenerees.next() ) {
	            /* Puis initialisation de la propriété id du bean Utilisateur avec sa valeur */
	            return valeursAutoGenerees.getInt( "ID_eleve" );
	        } else {
	            throw new DAOException( "Échec de la création de l'utilisateur en base, aucun ID auto-généré retourné." );
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        DAODataBaseManager.fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
	    }
		
	    
	

	   // return eleve;
	    
		
	}

	@Override
	public Eleve trouver(int idPersonne) throws DAOException {
		// TODO Auto-generated method stub
		
		 Connection connexion = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;
		    Eleve eleve = null;

		    try {
		        /* Récupération d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement = DAODataBaseManager.initialisationRequetePreparee( connexion, SQL_SELECT_ELEVE_PAR_ID_PERSONNE, false, idPersonne);
		        resultSet = preparedStatement.executeQuery();
		        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
		        if ( resultSet.next() ) {

		        		  eleve = map( resultSet );

		        }
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } finally {
		    	DAODataBaseManager.fermeturesSilencieuses( resultSet, preparedStatement, connexion );
		    }

		    return eleve;
	}

	@Override
	public Eleve trouver(String login, String mdp) throws DAOException {
		
		 Connection connexion = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;
		    Eleve eleve = null;

		    try {
		        /* Récupération d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement = DAODataBaseManager.initialisationRequetePreparee( connexion, SQL_SELECT_PAR_LOGIN_MDP, false, login, mdp);
		        resultSet = preparedStatement.executeQuery();
		        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
		        if ( resultSet.next() ) {

		        	  preparedStatement = DAODataBaseManager.initialisationRequetePreparee( connexion, SQL_SELECT_ELEVE_PAR_ID_PERSONNE, false, resultSet.getInt("ID_personne"));
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
	
	
	public ArrayList<Eleve> getAll() {

		 Connection connexion = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;
		    Eleve eleve = null;
		    ArrayList<Eleve> listeEleves = new ArrayList<Eleve>();
		    
		    try {
		        /* Récupération d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement = DAODataBaseManager.initialisationRequetePreparee( connexion, SQL_SELECT_ALL, false);
		        resultSet = preparedStatement.executeQuery();
		        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
		  
		        	  while ( resultSet.next() ) {
		        		
		        		  eleve = map( resultSet );
		        		  listeEleves.add(eleve);
		        		   
		        	  }
		        	
		        	return listeEleves;
		        
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } finally {
		    	DAODataBaseManager.fermeturesSilencieuses( resultSet, preparedStatement, connexion );
		    }

	}
	
	/*
	 * Simple méthode utilitaire permettant de faire la correspondance (le
	 * mapping) entre une ligne issue de la table des utilisateurs (un
	 * ResultSet) et un bean Utilisateur.
	 */
	private static Eleve map( ResultSet resultSet ) throws SQLException {
		Eleve eleve = new Eleve();

		eleve.setCode_postal(resultSet.getInt("Code_postal"));
		eleve.setDate_inscription(resultSet.getDate("Date_inscription")); 
		eleve.setDate_naissance(resultSet.getDate("Date_naissance"));
		eleve.setEmail(resultSet.getString("Email"));
		eleve.setEtablissement_prec(resultSet.getString("Etablissement_prec"));
		eleve.setID_contact(resultSet.getInt("ID_personne"));
		eleve.setNom(resultSet.getString("Nom"));
		eleve.setPays_naissance(resultSet.getString("Pays_naissance"));
		eleve.setPhoto(resultSet.getString("Photo"));
		eleve.setPrenom(resultSet.getString("Prenom"));
		eleve.setRemarques_medicale(resultSet.getString("Remarques_medicale"));
		eleve.setRue(resultSet.getString("Rue"));
		eleve.setSexe(resultSet.getString("Sexe"));
		eleve.setTel_domicile(resultSet.getInt("Tel_domicile"));
		eleve.setTel_mobile(resultSet.getInt("Tel_mobile"));
    	eleve.setVille(resultSet.getString("Ville"));
		eleve.setVille_naissance(resultSet.getString("Ville_naissance"));
		eleve.setMatricule(resultSet.getLong("Matricule"));
		
	    return eleve;
	}


}	
