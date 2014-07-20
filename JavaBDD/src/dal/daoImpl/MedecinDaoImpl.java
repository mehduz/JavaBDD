package dal.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import beans.Medecin;
import dal.DAODataBaseManager;
import dal.DAOException;
import dal.DAOFactory;
import dal.dao.MedecinDao;

public class MedecinDaoImpl extends SuperDaoImpl implements MedecinDao {

	
	private static final String SQL_SELECT_ALL = "select * from medecin, personne where medecin.ID_personne = personne.ID_personne";
	
	public MedecinDaoImpl(DAOFactory daoFactory) {
		super(daoFactory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int creer(Medecin medecin) throws DAOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Medecin trouver(int id_personne) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Medecin> getAll() throws DAOException {

		 Connection connexion = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;
		    Medecin medecin = null;
		    ArrayList<Medecin> listeMedecins = new ArrayList<Medecin>();
		    
		    try {
		        /* Récupération d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement = DAODataBaseManager.initialisationRequetePreparee( connexion, SQL_SELECT_ALL, false);
		        resultSet = preparedStatement.executeQuery();
		        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
		  
		        	  while ( resultSet.next() ) {
		        		
		        		  medecin = map( resultSet );
		        		  listeMedecins.add(medecin);
		        		   
		        	  }
		        	
		        	return listeMedecins;
		        
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } finally {
		    	DAODataBaseManager.fermeturesSilencieuses( resultSet, preparedStatement, connexion );
		    }
		
	}
	
	public static Medecin map( ResultSet resultSet ) throws SQLException {
		
		Medecin medecin = new Medecin();

		medecin.setNom(resultSet.getString("Nom"));
		medecin.setPrenom(resultSet.getString("Prenom"));
		medecin.setEmail(resultSet.getString("Email"));
		medecin.setTel_domicile(resultSet.getInt("Tel_domicile"));
		medecin.setTel_mobile(resultSet.getInt("Tel_mobile"));
		medecin.setID_medecin(resultSet.getInt("ID_medecin"));
		medecin.setID_personne(resultSet.getInt("ID_personne"));
		
		
	
	return medecin;
	}
	
	
	
	

}
