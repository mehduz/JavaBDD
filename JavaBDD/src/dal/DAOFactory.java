package dal;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

import beans.Allergie;
import beans.Authentication;

import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;

import dal.dao.AllergieDao;
import dal.dao.AuthenticationDao;
import dal.dao.ClasseDao;
import dal.dao.ContactDao;
import dal.dao.EleveDao;
import dal.dao.MatiereDao;
import dal.dao.MedecinDao;
import dal.dao.PersonneDao;
import dal.dao.ProfesseurDao;
import dal.dao.SuiviDao;
import dal.dao.VaccinDao;
import dal.daoImpl.AllergieDaoImpl;
import dal.daoImpl.AuthenticationDaoImpl;
import dal.daoImpl.ClasseDaoImpl;
import dal.daoImpl.ContactDaoImpl;
import dal.daoImpl.EleveDaoImpl;
import dal.daoImpl.MatiereDaoImpl;
import dal.daoImpl.MedecinDaoImpl;
import dal.daoImpl.PersonneDaoImpl;
import dal.daoImpl.ProfesseurDaoImpl;
import dal.daoImpl.SuiviDaoImpl;
import dal.daoImpl.VaccinDaoImpl;

public class DAOFactory {
	
	private static Logger LOGGER = Logger.getLogger(DAOFactory.class.getName());
	private static final String FICHIER_PROPERTIES ="dal.dao.properties";
	private static final String PROPERTY_URL = "url";
	private static final String PROPERTY_DRIVER = "driver";
	private static final String PROPERTY_NOM_UTILISATEUR = "username";
	private static final String PROPERTY_MOT_DE_PASSE = "password";
	

	private String url;
	private String username;
	private String password;
	private BoneCP connectionPool = null;

	private DAOFactory(BoneCP connectionPool) {
		this.connectionPool = connectionPool;
	}

	/*
	 * Méthode chargée de récupérer les informations de connexion à la base de
	 * données, charger le driver JDBC et retourner une instance de la Factory
	 */
	public static DAOFactory getInstance() throws DAOConfigurationException {
		Properties properties = new Properties();
		String url;
		String driver;
		String username;
		String password;
		BoneCP connectionPool = null;

		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream fichierProperties = classLoader.getResourceAsStream(FICHIER_PROPERTIES);

		if (fichierProperties == null) {
			LOGGER.severe(
					"ce fichier est introuvable : "
							+ FICHIER_PROPERTIES);
			url = "jdbc:mysql://192.168.1.103:3306/universitymanagerdb";
		    driver = "com.mysql.jdbc.Driver";
		    username = "remoteuser";
		    password = "remote"; 
		}

		try {
			properties.load(fichierProperties);
			url = properties.getProperty(PROPERTY_URL);
			driver = properties.getProperty(PROPERTY_DRIVER);
			username = properties.getProperty(PROPERTY_NOM_UTILISATEUR);
			password = properties.getProperty(PROPERTY_MOT_DE_PASSE);
		} catch (Exception e) {
			
			LOGGER.severe(
					"Impossible de charger le fichier properties "
							+ FICHIER_PROPERTIES);
			url = "jdbc:mysql://192.168.1.103:3306/universitymanagerdb";
		    driver = "com.mysql.jdbc.Driver";
		    username = "remoteuser";
		    password = "remote"; 	
		}

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new DAOConfigurationException(
					"Le driver est introuvable dans le classpath.", e);
		}

		try {
			/*
			 * Création d'une configuration de pool de connexions via l'objet
			 * BoneCPConfig et les différents setters associés.
			 */
			BoneCPConfig config = new BoneCPConfig();
			/* Mise en place de l'URL, du nom et du mot de passe */
			config.setJdbcUrl(url);
			config.setUsername(username);
			config.setPassword(password);
			/* Paramétrage de la taille du pool */
			config.setMinConnectionsPerPartition(5);
			config.setMaxConnectionsPerPartition(2);
			config.setPartitionCount(2);
			/* Création du pool à partir de la configuration, via l'objet BoneCP */
			connectionPool = new BoneCP(config);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOConfigurationException(
					"Erreur de configuration du pool de connexions.", e);
		}

		/*
		 * Enregistrement du pool créé dans une variable d'instance via un appel
		 * au constructeur de DAOFactory
		 */
		DAOFactory instance = new DAOFactory(connectionPool);
		return instance;
	}

	/* Méthode chargée de fournir une connexion à la base de données */
	/* package */
	public Connection getConnection() throws SQLException {
		return connectionPool.getConnection();
	}

	public void closeConnectionPool(){
		connectionPool.close();
	}
	
	/*
	 * Méthodes de récupération de l'implémentation des différents DAO (un seul
	 * pour le moment)
	 */
	public EleveDao getEleveDao() {
		return new EleveDaoImpl(this);
	}
	
	public ContactDao getContactDao() {
        return new ContactDaoImpl( this );
    }
    
    public ClasseDao getClasseDao() {
        return new ClasseDaoImpl( this); 
    }
    
    public MatiereDao getMatiereDao() {
        return new MatiereDaoImpl( this );
    }
    
    public PersonneDao getPersonneDao() {
        return new PersonneDaoImpl( this );
    }
    
    public SuiviDao getSuiviDao() {
        return new SuiviDaoImpl( this );
    }
    
    public AllergieDao getAllergieDao() {
        return new AllergieDaoImpl( this );
    }

    public VaccinDao getVaccinDao() {
        return new VaccinDaoImpl( this );
    }

    public ProfesseurDao getProfesseurDao() {
        return new ProfesseurDaoImpl( this );
    }
    
    public MedecinDao getMedecinDao() {
        return new MedecinDaoImpl( this );
    }
    
    public AuthenticationDao getAuthenticationDao(){
    	return new AuthenticationDaoImpl(this) ;
    }
}