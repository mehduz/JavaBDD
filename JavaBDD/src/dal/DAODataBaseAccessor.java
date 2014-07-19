package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAODataBaseAccessor {

	private String dbName;
	private String user;
	private String password;
	
	public DAODataBaseAccessor () {
	
		 dbName = "universitymanagerdb";
		 user = "remoteuser";
		 password = "remote";
		
	}
	
	public  Connection getDataBaseConnection() {
		
		Connection conn = null;
		
		try {
		    conn =
		       DriverManager.getConnection("jdbc:mysql://192.168.1.103/?" +dbName+
		                                   "user="+user+"&password="+password);

		    return conn;

		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		
		return conn;
		
	}
	
}
