package dal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import dal.dao.ClasseDao;
import dal.dao.ContactDao;
import dal.dao.EleveDao;
import dal.dao.MatiereDao;
import dal.dao.PersonneDao;
import dal.dao.SuiviDao;
import dal.daoImpl.ClasseDaoImpl;
import dal.daoImpl.ContactDaoImpl;
import dal.daoImpl.EleveDaoImpl;
import dal.daoImpl.MatiereDaoImpl;
import dal.daoImpl.PersonneDaoImpl;
import dal.daoImpl.SuiviDaoImpl;

public class DAOFactory {

    private static final String FICHIER_PROPERTIES       = "/com/sdzee/dao/dao.properties";
    private static final String PROPERTY_URL             = "url";
    private static final String PROPERTY_DRIVER          = "driver";
    private static final String PROPERTY_NOM_UTILISATEUR = "nomutilisateur";
    private static final String PROPERTY_MOT_DE_PASSE    = "motdepasse";

    private String              url;
    private String              username;
    private String              password;

    public DAOFactory( String url, String username, String password ) {
        this.url = url;
        this.username = username;
        this.password = password;

    }

    public DAOFactory() {
    	
    	   this.url = "universitymanagerdb";
           this.username = "remoteuser";
           this.password = "remote";

    }
    
    /*
     * Méthode chargée de récupérer les informations de connexion à la base de
     * données, charger le driver JDBC et retourner une instance de la Factory
     */
    public static DAOFactory getInstance() throws DAOConfigurationException {
        Properties properties = new Properties();
        String url;
        String driver;
        String nomUtilisateur;
        String motDePasse;

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream fichierProperties = classLoader.getResourceAsStream( FICHIER_PROPERTIES );

        if ( fichierProperties == null ) {
            throw new DAOConfigurationException( "Le fichier properties " + FICHIER_PROPERTIES + " est introuvable." );
        }

        try {
            properties.load( fichierProperties );
            url = properties.getProperty( PROPERTY_URL );
            driver = properties.getProperty( PROPERTY_DRIVER );
            nomUtilisateur = properties.getProperty( PROPERTY_NOM_UTILISATEUR );
            motDePasse = properties.getProperty( PROPERTY_MOT_DE_PASSE );
        } catch ( IOException e ) {
            throw new DAOConfigurationException( "Impossible de charger le fichier properties " + FICHIER_PROPERTIES, e );
        }

        try {
            Class.forName( driver );
        } catch ( ClassNotFoundException e ) {
            throw new DAOConfigurationException( "Le driver est introuvable dans le classpath.", e );
        }

        DAOFactory instance = new DAOFactory( url, nomUtilisateur, motDePasse );
        return instance;
    }

    /* Méthode chargée de fournir une connexion à la base de données */
     /* package */
    public Connection getConnection() throws SQLException {

	Connection conn = null;

		try {
		    conn =
		       DriverManager.getConnection("jdbc:mysql://192.168.1.103:3306/"+this.url,
		       		 this.username,this.password);

		    return conn;

		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		
		return conn;
    	
    }

    public EleveDao getEleveDao() {
        return new EleveDaoImpl( this );
    }
    
    public ContactDao getContactDao() {
        return new ContactDaoImpl( this );
    }
    
    public ClasseDao getClasseDao() {
        return new ClasseDaoImpl( this );
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

}