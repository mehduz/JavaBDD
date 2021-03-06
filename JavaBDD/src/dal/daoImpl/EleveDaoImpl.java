package dal.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;

import dal.DAODataBaseManager;
import dal.DAOException;
import dal.DAOFactory;
import dal.dao.EleveDao;
import beans.Allergie;
import beans.Eleve;
import beans.Vaccin;

public class EleveDaoImpl  extends SuperDaoImpl implements EleveDao {

	 private static final String SQL_SELECT_ALL = "SELECT * FROM Eleve, Personne WHERE Eleve.ID_personne = Personne.ID_personne ";
	 private static final String SQL_SELECT_ALL_PAR_CLASSE = "SELECT * FROM Eleve, Personne WHERE Eleve.ID_personne = Personne.ID_personne AND Eleve.Nom_classe = ?";
	 private static final String SQL_SELECT_ELEVE_PAR_ID_PERSONNE = "SELECT * FROM Eleve, Personne WHERE Eleve.ID_personne = ? AND Eleve.ID_personne = Personne.ID_personne ";
	 private static final String SQL_INSERT_ELEVE = "INSERT INTO eleve (Date_naissance, Ville_naissance, Pays_naissance,Sexe,"+
			 "Date_inscription, Etablissement_prec, Photo, Rue,"+
			 "Code_postal, Ville, Email,Remarques_medicale, ID_personne, Nom_classe,"+
			 " ID_contact, ID_prof) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	 private static final String SQL_SELECT_ELEVE_MATIERE = "SELECT * FROM eleve, matieres";
	 private static final String SQL_SELECT_ALL_PAR_MATIERE = "SELECT DISTINCT ID_personne FROM suivi where Nom_matiere = ?";
	 private static final String SQL_SELECT_ALL_PAR_ID_PROF = "SELECT * FROM Eleve, Personne where ID_prof = ? AND Eleve.ID_personne = Personne.ID_personne";
	 
	 //romain
	 //private static final String SQL_SELECT_CLASSE_FOR_ONE_STUDENT = "SELECT Eleve.Nom_classe FROM Eleve, Personne WHERE Eleve.ID_personne = Personne.ID_personne AND Personne.Nom = ?";
	 
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
	        /* R�cup�ration d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	      
	  	  		 preparedStatement = DAODataBaseManager.initialisationRequetePreparee( connexion, SQL_INSERT_ELEVE, true, 
	  			 eleve.getDate_naissance(), eleve.getVille_naissance(), eleve.getPays_naissance(), eleve.getDate_inscription(), 
	 			 eleve.getEtablissement_prec(), eleve.getPhoto(), eleve.getRue(), eleve.getCode_postal(), eleve.getVille(),
	 			 eleve.getEmail(), eleve.getRemarques_medicale(), eleve.getID_personne(), eleve.getNom_classe(), eleve.getID_contact(),
	 			 eleve.getID_prof());
	  	  
	  	   int statut = preparedStatement.executeUpdate();
	        /* Analyse du statut retourn� par la requ�te d'insertion */
	        if ( statut == 0 ) {
	            throw new DAOException( "�chec de la cr�ation de l'utilisateur, aucune ligne ajout�e dans la table." );
	        }
	        
	        
	        /* R�cup�ration de l'id auto-g�n�r� par la requ�te d'insertion */
	        valeursAutoGenerees = preparedStatement.getGeneratedKeys();
	        if ( valeursAutoGenerees.next() ) {
	            /* Puis initialisation de la propri�t� id du bean Utilisateur avec sa valeur */
	            return valeursAutoGenerees.getInt( "ID_eleve" );
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
	public Eleve trouver(int idPersonne) throws DAOException {
		// TODO Auto-generated method stub
		
		 Connection connexion = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;
		    Eleve eleve = null;

		    try {
		        /* R�cup�ration d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement = DAODataBaseManager.initialisationRequetePreparee( connexion, SQL_SELECT_ELEVE_PAR_ID_PERSONNE, false, idPersonne);
		        resultSet = preparedStatement.executeQuery();
		        /* Parcours de la ligne de donn�es de l'�ventuel ResulSet retourn� */
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

	public ArrayList<Eleve> getAll() {

		 Connection connexion = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;
		    Eleve eleve = null;
		    ArrayList<Eleve> listeEleves = new ArrayList<Eleve>();
		    
		    try {
		        /* R�cup�ration d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement = DAODataBaseManager.initialisationRequetePreparee( connexion, SQL_SELECT_ALL, false);
		        resultSet = preparedStatement.executeQuery();
		        /* Parcours de la ligne de donn�es de l'�ventuel ResulSet retourn� */
		  
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
	 * Simple m�thode utilitaire permettant de faire la correspondance (le
	 * mapping) entre une ligne issue de la table des utilisateurs (un
	 * ResultSet) et un bean Utilisateur.
	 */
	public static Eleve map( ResultSet resultSet ) throws SQLException {
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
		eleve.setNom_classe(resultSet.getString("Nom_classe"));
		
	    return eleve;
	}
	
	@Override
	public ArrayList<Eleve> getAllParMatiere(String nomMatiere) {

		 Connection connexion = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;
		    Eleve eleve = null;
		    ArrayList<Eleve> listeEleves = new ArrayList<Eleve>();
		    
		    try {
		        /* R�cup�ration d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement = DAODataBaseManager.initialisationRequetePreparee( connexion, SQL_SELECT_ALL_PAR_MATIERE, false, nomMatiere);
		        resultSet = preparedStatement.executeQuery();
		        /* Parcours de la ligne de donn�es de l'�ventuel ResulSet retourn� */
		  
		        	  while ( resultSet.next() ) {

		        		  eleve = this.trouver(resultSet.getInt("ID_personne"));
		        		  
		        		  listeEleves.add(eleve);
		        		   
		        	  }
		        	
		        	return listeEleves;
		        
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } finally {
		    	DAODataBaseManager.fermeturesSilencieuses( resultSet, preparedStatement, connexion );
		    }
		
	}

	@Override
	public ArrayList<Eleve> getAllParClasse(String nomClasse) {

		 Connection connexion = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;
		    Eleve eleve = null;
		    ArrayList<Eleve> listeEleves = new ArrayList<Eleve>();
		    
		    try {
		        /* R�cup�ration d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement = DAODataBaseManager.initialisationRequetePreparee( connexion, SQL_SELECT_ALL_PAR_CLASSE, false, nomClasse);
		        resultSet = preparedStatement.executeQuery();
		        /* Parcours de la ligne de donn�es de l'�ventuel ResulSet retourn� */
		  
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

	public ArrayList<Eleve> getAllParIdProf(int idProf) throws DAOException {

		 Connection connexion = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;
		    Eleve eleve = null;
		    ArrayList<Eleve> listeEleves = new ArrayList<Eleve>();
		    
		    try {
		        /* R�cup�ration d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement = DAODataBaseManager.initialisationRequetePreparee( connexion, SQL_SELECT_ALL_PAR_ID_PROF, false, idProf);
		        resultSet = preparedStatement.executeQuery();
		        /* Parcours de la ligne de donn�es de l'�ventuel ResulSet retourn� */
		  
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

}	
