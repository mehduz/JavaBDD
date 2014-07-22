package dal.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import beans.Vaccin;
import dal.DAODataBaseManager;
import dal.DAOException;
import dal.DAOFactory;
import dal.dao.VaccinDao;

public class VaccinDaoImpl extends SuperDaoImpl implements VaccinDao {

	final static String SQL_INSERT_VACCIN = "INSERT INTO vaccins (Libelle) VALUES (?)";
	final static String SQL_SUPPR_VACCIN = "DELETE FROM vaccins WHERE Libelle = (?)";
	final static String SQL_SELECT_VACCIN_PAR_LIBELLE = "SELECT * FROM vaccins where libelle = ?";
	final static String SQL_SELECT_ALL = "SELECT * FROM vaccins";
	private static final String SQL_SELECT_VACCIN_ELEVE = "SELECT Libelle, Vaccins.ID_vaccin from Vaccins, Vaccine where Vaccine.ID_personne = ? AND  Vaccins.ID_vaccin = Vaccine.ID_vaccin;"; 

	@Override
	public Vaccin trouver(String nomVaccin) throws DAOException {

		 Connection connexion = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;
		    Vaccin vaccin = null;

		    try {
		        /* Récupération d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement = DAODataBaseManager.initialisationRequetePreparee( connexion, SQL_SELECT_VACCIN_PAR_LIBELLE, false, nomVaccin);
		        resultSet = preparedStatement.executeQuery();
		        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
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
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();

	  	  		 preparedStatement = DAODataBaseManager.initialisationRequetePreparee( connexion, SQL_INSERT_VACCIN, true, 
	  	  				 	vaccin.getLibelle());
	  	  
	  	   int statut = preparedStatement.executeUpdate();
	        /* Analyse du statut retourné par la requête d'insertion */
	        if ( statut == 0 ) {
	            throw new DAOException( "Échec de la création de l'utilisateur, aucune ligne ajoutée dans la table." );
	        }

	        /* Récupération de l'id auto-généré par la requête d'insertion */
	        valeursAutoGenerees = preparedStatement.getGeneratedKeys();
	        if ( valeursAutoGenerees.next() ) {
	            /* Puis initialisation de la propriété id du bean Utilisateur avec sa valeur */
	            return valeursAutoGenerees.getInt( "ID_vaccin" );
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
	public void supprimer(Vaccin vaccin) throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {
			connexion = daoFactory.getConnection();
			preparedStatement = DAODataBaseManager.initialisationRequetePreparee(connexion,	SQL_SUPPR_VACCIN, true, vaccin.getLibelle());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			JFrame jf = new JFrame();
			JOptionPane.showMessageDialog(jf,"Erreur de suppression : \n\n" + e, "Erreur SQL", JOptionPane.WARNING_MESSAGE);
			throw new DAOException(e);			
		} finally {
			DAODataBaseManager.fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);
		}

	}
	
	@Override
	public ArrayList<Vaccin> getAll() throws DAOException {

		 Connection connexion = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;
		    Vaccin vaccin = null;
		    ArrayList<Vaccin> listeVaccins = new ArrayList<Vaccin>();
		    
		    try {
		        /* Récupération d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement = DAODataBaseManager.initialisationRequetePreparee( connexion, SQL_SELECT_ALL, false);
		        resultSet = preparedStatement.executeQuery();
		        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
		  
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
	
	public ArrayList<Vaccin> getAllParEleve(int idPersonne) {
		
		 Connection connexion = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;
		    Vaccin vaccin = null;
		    ArrayList<Vaccin> listeVaccins = new ArrayList<Vaccin>();
		    
		    try {
		        /* Récupération d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement = DAODataBaseManager.initialisationRequetePreparee( connexion, SQL_SELECT_VACCIN_ELEVE, false);
		        resultSet = preparedStatement.executeQuery();
		        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
		  
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
		
	public static Vaccin map( ResultSet resultSet ) throws SQLException {
		Vaccin vaccin = new Vaccin(resultSet.getInt("ID_vaccin"), resultSet.getString("Libelle"));
		return vaccin;
	}
	
}
