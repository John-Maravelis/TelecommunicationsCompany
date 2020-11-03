package mainProject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 * This class is responsible for establishing the DB connectivity and handles</br>
 * any issues that might come up.
 * @return connection object
 * @author John Maravelis
 */
public class EstablishDBConnection {

	private final String username = "root";
	private final String password = "toor";
	private final String url = "jdbc:mysql://localhost:3306/telecommunications_db";

	public Connection DBConnection(){
		Connection connection =null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();;
		}
		return connection;
	}
}
