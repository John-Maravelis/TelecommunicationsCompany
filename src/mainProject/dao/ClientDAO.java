package mainProject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import mainProject.model.Client;

/**
 * This class is responsible for handling any request from the client servlets that </br>
 * to input or output data from the DB.
 * @author John Maravelis
 */
public class ClientDAO {
	//creating an object of EstablishDBConnection Class
	EstablishDBConnection dbConObj = new EstablishDBConnection();
	boolean result;
	String query;
	
	/**
	 * This class is responsible for handling the authentication of a client at login.
	 * @param client
	 * @return <i>true</i> if no error has occured, <i>false</i> if an error has occured. 
	 * @throws SQLException
	 */
	public boolean clientAuthentication(Client client) throws SQLException {
		//Creating an instance of Connection class and
		//using the DBConnection method to establish database connectivity
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		result = false;

		query = "select password from clients where username='"+client.getUsername()+"'";
		try {
			connection = dbConObj.DBConnection();			
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			if(resultSet.next()) {
				String pass = resultSet.getString("password");				
				if(pass.equals(client.getPassword()))result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (connection != null) connection.close();
			if (statement != null) statement.close();
			if (resultSet != null) resultSet.close();
		}
		return result;
	}
	
	/**
	 * This class is responsible for getting the bill a client.
	 * @param username, bill
	 * @return string array with client's bill values
	 * @throws SQLException
	 */
	public String[] clientBill(String username, String bill[]) throws SQLException {
		// Creating an instance of Connection class and
		// using the DBConnection method to establish database connectivity
		Connection connection = dbConObj.DBConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		
		query = "select * from bills where phone_number = (select phone_number from clients where username ='"+username+"');";
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			
			if(resultSet.next()) {
				bill[1] = resultSet.getString(1);
				bill[2] = resultSet.getString(2);
				bill[3] = resultSet.getString(3);
				bill[4] = resultSet.getString(4);
				bill[5] = resultSet.getString(5);
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(connection != null)connection.close();
			if(statement != null)statement.close();
			if(resultSet != null)resultSet.close();
		}
		return bill;
	}
	
	/**
	 * This class is responsible for the payment procedure for the bill of a client.
	 * @param status, username
	 * @return <i>true</i> if no error has occured, <i>false</i> if an error has occured.
	 * @throws SQLException
	 */
	public boolean payBill(String status, String username) throws SQLException{
		// Creating an instance of Connection class and
		// using the DBConnection method to establish database connectivity
		Connection connection = dbConObj.DBConnection();
		PreparedStatement preparedStatement = null;
		int flag = 0;
		
		query = "update bills set status=? where client_id=(select client_id from clients where username=?);";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, status);
			preparedStatement.setString(2, username);
			flag = preparedStatement.executeUpdate();
			if (flag == 1)result = true;
			
		} catch (SQLException e) {
		}finally {
			if(connection != null)connection.close();
			if(preparedStatement != null)preparedStatement.close();
		}
		return result;
	}
	
	/**
	 * This class is responsible for getting the call history of a client
	 * @param username, callHistory
	 * @return string array with client's call history values
	 * @throws SQLException
	 */
	public String[] callHistory(String username, String callHistory[]) throws SQLException {
		// Creating an instance of Connection class and
		// using the DBConnection method to establish database connectivity
		Connection connection = dbConObj.DBConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		
		query = "select * from call_history where client_id = (select client_id from clients where username ='"+username+"');";
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			
			if(resultSet.next()) {
				callHistory[1] = resultSet.getString(1);
				callHistory[2] = resultSet.getString(2);
				callHistory[3] = resultSet.getString(3);	
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(connection != null)connection.close();
			if(statement != null)statement.close();
			if(resultSet != null)resultSet.close();
		}
		return callHistory;
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
		String salt = "-" ;
		query = "select salt from clients where username='"+username+"'";
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
