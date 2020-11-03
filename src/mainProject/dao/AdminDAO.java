package mainProject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import mainProject.model.Admin;
import mainProject.model.Seller;

/**
 * This class is responsible for handling any request from the admin servlets that </br>
 * to input or output data from the DB.
 * @author John Maravelis
 */
public class AdminDAO {
	//creating an object of EstablishDBConnection Class
	EstablishDBConnection dbConObj = new EstablishDBConnection();
	boolean result;
	String query;
	int flag;
	
	/**
	 * This class is responsible for handling the authentication of an admin at login.
	 * @param admin
	 * @return <i>true</i> if no error has occured, <i>false</i> if an error has occured. 
	 * @throws SQLException
	 */
	public boolean adminAuthentication(Admin admin) throws SQLException {
		//Creating an instance of Connection class and
		//using the DBConnection method to establish database connectivity
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		result = false;

		query = "select password from admins where username='"+admin.getUsername()+"'";
		try {
			connection = dbConObj.DBConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			
			if(resultSet.next()) {
				String pass = resultSet.getString("password");
				if(pass.equals(admin.getPassword()))result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (connection!= null) connection.close();
			if (connection!= null) statement.close();
			if (connection!= null) resultSet.close();
		}
		return result;
	}
	
	/**
	 * This class is responsible for handling the registration of a new seller.
	 * @param seller
	 * @return <i>true</i> if no error has occured, <i>false</i> if an error has occured. 
	 * @throws SQLException
	 */
	public boolean newSeller(Seller seller) throws SQLException {
		// Creating an instance of Connection class and
		// using the DBConnection method to establish database connectivity
		Connection connection = dbConObj.DBConnection();
		PreparedStatement preparedStatement = null;
		
		result = false;
		flag = 0;
		
		query = "insert into sellers values(?,?,?,?,?,?);";
		try {
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, seller.getSellerID());
			preparedStatement.setString(2, seller.getUsername());
			preparedStatement.setString(3, seller.getPassword());
			preparedStatement.setString(4, seller.getFirstName());
			preparedStatement.setString(5, seller.getSurname());
			preparedStatement.setString(6, seller.getAdminUsername());
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
	 * This class is responsible for handling the creation of a new plan.
	 * @param  plan_id, description, speechTime, sms, data, price
	 * @return <i>true</i> if no error has occured, <i>false</i> if an error has occured. 
	 * @throws SQLException
	 */
	public boolean newPlan(String plan_id, String description, int speechTime, int sms, int data, double price) throws SQLException{
		// Creating an instance of Connection class and
		// using the DBConnection method to establish database connectivity
		Connection connection = dbConObj.DBConnection();
		PreparedStatement preparedStatement = null;
		
		query = "insert into plans values(?,?,?,?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, plan_id);
			preparedStatement.setString(2, description);
			preparedStatement.setInt(3, speechTime);
			preparedStatement.setInt(4, sms);
			preparedStatement.setInt(5, data);
			preparedStatement.setDouble(6, price);
			flag = preparedStatement.executeUpdate();
			if (flag == 1)result = true;	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(connection != null)connection.close();
			if(preparedStatement != null)preparedStatement.close();
		}
		return result;
	}
	
	/**
	 * This class is responsible for updating an existing plan.
	 * @param plan_id, description, speechTime, sms, data, price 
	 * @return <i>true</i> if no error has occured, <i>false</i> if an error has occured. 
	 * @throws SQLException
	 */
	public boolean updatePlan(String plan_id, String description, int speechTime, int sms, int data, double price) throws SQLException{
		// Creating an instance of Connection class and
		// using the DBConnection method to establish database connectivity
		Connection connection = dbConObj.DBConnection();
		PreparedStatement preparedStatement = null;
		
		query = "update plans set description=?, speech_time=?, sms=?, data=?, price=? where plan_id=?;";
		try {
			preparedStatement = connection.prepareStatement(query);
	
			preparedStatement.setString(1, description);
			preparedStatement.setInt(2, speechTime);
			preparedStatement.setInt(3, sms);
			preparedStatement.setInt(4, data);
			preparedStatement.setDouble(5, price);
			preparedStatement.setString(6, plan_id);
			flag = preparedStatement.executeUpdate();
			if (flag == 1)result = true;	
			System.out.println(flag);
		} catch (SQLException e) {
			e.printStackTrace();
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
		query = "select salt from admins where username='"+username+"'";
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
