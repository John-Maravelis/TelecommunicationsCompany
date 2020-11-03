package mainProject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import mainProject.model.Client;
import mainProject.model.Seller;

/**
 * This class is responsible for handling any request from the seller servlets that </br>
 * to input or output data from the DB.
 * @author John Maravelis
 */
public class SellerDAO {
	// creating an object of EstablishDBConnection Class
	EstablishDBConnection dbConObj = new EstablishDBConnection();

	String query;
	boolean result;
	int flag;
	
	/**
	 * This class is responsible for handling the authentication of a seller at login.
	 * @param seller
	 * @return <i>true</i> if no error has occured, <i>false</i> if an error has occured. 
	 * @throws SQLException
	 */
	public boolean sellerAuthentication(Seller seller) throws SQLException {
		// Creating an instance of Connection class and
		// using the DBConnection method to establish database connectivity
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		result = false;
		flag = 0;

		query = "select password from sellers where username='"+seller.getUsername()+"'";
		try {
			connection = dbConObj.DBConnection();
			statement = connection.createStatement();			 
			resultSet = statement.executeQuery(query);
			if (resultSet.next()) {
				String pass = resultSet.getString("password");
				if(pass.equals(seller.getPassword()))result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (connection!= null) connection.close();
			if (statement!= null)statement.close();
			if (resultSet!= null)resultSet.close();
		}
		return result;
	}

	/**
	 * This class is responsible for handling the registration of a new client.
	 * @param client
	 * @return <i>true</i> if no error has occured, <i>false</i> if an error has occured. 
	 * @throws SQLException
	 */
	public boolean newClient(Client client) throws SQLException {
		// Creating an instance of Connection class and
		// using the DBConnection method to establish database connectivity
		Connection connection = dbConObj.DBConnection();
		PreparedStatement preparedStatement = null;
		
		result = false;
		flag = 0;
		
		query = "insert into clients(client_id, username, password, name, surname, phone_number, afm, zip_code, seller_username) values(?,?,?,?,?,?,?,?,?);";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, client.getClientID());
			preparedStatement.setString(2, client.getUsername());
			preparedStatement.setString(3, client.getPassword());
			preparedStatement.setString(4, client.getFirstName());
			preparedStatement.setString(5, client.getSurname());
			preparedStatement.setString(6, client.getPhoneNumber());
			preparedStatement.setString(7, client.getAfm());
			preparedStatement.setString(8, client.getZip());
			preparedStatement.setString(9, client.getSellerUsername());
			flag = preparedStatement.executeUpdate();
			if (flag == 1)result = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (connection != null) connection.close();
			if (preparedStatement != null) preparedStatement.close();
		}
		return result;
	}
	
	/**
	 * This class is responsible for handling the allocation of a plan to client.
	 * @param phoneNumber, planID 
	 * @return <i>true</i> if no error has occured, <i>false</i> if an error has occured. 
	 * @throws SQLException
	 */
	public boolean planToClient(String phoneNumber, String planID) throws SQLException {
		// Creating an instance of Connection class and
		// using the DBConnection method to establish database connectivity
		Connection connection = dbConObj.DBConnection();
		PreparedStatement preparedStatement = null;
		
		flag = 0;
		result = false;
		
		query = "update clients set plan_id=? where phone_number=?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, planID);
			preparedStatement.setString(2, phoneNumber);			
			flag = preparedStatement.executeUpdate();
			if(flag==1)result = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (connection != null) connection.close();
			if (preparedStatement != null) preparedStatement.close();
		}
		return result;
	}	
	
	/**
	 * This class is responsible for handling the creation of a new bill for a given client.
	 * @param billID, status, month, price, planID, clientID  
	 * @return <i>true</i> if no error has occured, <i>false</i> if an error has occured. 
	 * @throws SQLException
	 */
	public boolean createBill(int billID, String status, String month, double price, int planID, int clientID) throws SQLException{
		// Creating an instance of Connection class and
		// using the DBConnection method to establish database connectivity
		Connection connection = dbConObj.DBConnection();
		PreparedStatement preparedStatement = null;
		
		flag = 0;
		result = false;
		
		query = "insert into bills values(?,?,?,?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, billID);
			preparedStatement.setString(2, status);
			preparedStatement.setString(3, month);
			preparedStatement.setDouble(4, price);
			preparedStatement.setInt(5, planID);
			preparedStatement.setInt(6, clientID);
			flag = preparedStatement.executeUpdate();
			if(flag==1)result = true;
			
		} catch (SQLException e) {
		}finally {
			if(connection != null)connection.close();
			if(preparedStatement != null)preparedStatement.close();
		}
		return result;
	}
	
	/**
	 * This class is responsible for getting the string value of a user's salt number from the DB
	 * @param username
	 * @return string with user's salt number
	 * @throws SQLException
	 */
	public String getSalt(String username) throws SQLException {
		// Creating an instance of Connection class and
		// using the DBConnection method to establish database connectivity
		Connection connection = dbConObj.DBConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		String salt = "";
		query = "select salt from sellers where username='"+username+"'";
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				salt = resultSet.getString("salt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(connection != null)connection.close();
			if(statement != null)statement.close();
			if(resultSet != null)resultSet.close();
		}
		return salt;
	}	
}
