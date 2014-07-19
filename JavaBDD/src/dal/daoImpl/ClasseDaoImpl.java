package dal.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import beans.Allergie;
import beans.Classe;
import dal.DAODataBaseManager;
import dal.DAOException;
import dal.DAOFactory;
import dal.dao.ClasseDao;

public class ClasseDaoImpl extends SuperDaoImpl implements ClasseDao  {

	 private static final String SQL_SELECT_PAR_LIBELLE = "SELECT * FROM Classe WHERE Nom_classe = ?";
	 private static final String SQL_INSERT_CLASSE = "INSERT INTO classe (Nom_classe) VALUES (?)";
	
	public ClasseDaoImpl(DAOFactory daoFactory) {
		super(daoFactory);
		// TODO Auto-generated constructor stub
	}


		@Override
		public int creer(Classe classe) throws DAOException {

			Connection connexion = null;
		    PreparedStatement preparedStatement = null;

		    try {
		        /* R�cup�ration d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();

		  	  		 preparedStatement = DAODataBaseManager.initialisationRequetePreparee( connexion, SQL_INSERT_CLASSE, false, 
		  	  				classe.getNom_classe());
		  	  
		  	   int statut = preparedStatement.executeUpdate();
		        /* Analyse du statut retourn� par la requ�te d'insertion */
		        if ( statut == 0 ) {
		            throw new DAOException( "�chec de la cr�ation de l'utilisateur, aucune ligne ajout�e dans la table." );
		        }
		        
		        return 1;
		        
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } finally {
		    	DAODataBaseManager.fermeturesSilencieuses( preparedStatement, connexion );
		    }
			
			
		}
	

	@Override
	public Classe trouver(String nom_classe) throws DAOException {

		 Connection connexion = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;
		    Classe classe = null;

		    try {
		        /* R�cup�ration d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement = DAODataBaseManager.initialisationRequetePreparee( connexion, SQL_SELECT_PAR_LIBELLE, false, nom_classe);
		        resultSet = preparedStatement.executeQuery();
		        /* Parcours de la ligne de donn�es de l'�ventuel ResulSet retourn� */
		        if ( resultSet.next() ) {

		        	classe = map( resultSet );

		        	
		        }
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } finally {
		    	DAODataBaseManager.fermeturesSilencieuses( resultSet, preparedStatement, connexion );
		    }

		    return classe;
		
	}
	
	private static Classe map( ResultSet resultSet ) throws SQLException {
		Classe classe = new Classe();

		classe.setNom_classe(resultSet.getString("Nom_classe"));
		
	    return classe;
	}

}
