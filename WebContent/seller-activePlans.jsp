<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Statement"%>	
<%@ page import="java.sql.ResultSet"%>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>My Company</title>
	<link rel="stylesheet" type="text/css" href="./style.css">
	</head>
	<body>
		<%if(session.getAttribute("username")==null)response.sendRedirect("index.html");%>
		<div align="center">
		<h1><b>Active Plans</b></h1>
		<table>
			<tr>
				<th>ID</th>
				<th>Description</th>
				<th>Speech Time</th>
				<th>SMS</th>
				<th>Data</th>
				<th>Price</th>
			</tr>
			<%!
				String username = "root";
				String password = "toor";
				String url = "jdbc:mysql://localhost:3306/telecommunications_db";
			%>	
			<%	
				Connection connection = null;
				Statement statement	= null;
				ResultSet resultSet = null;
				try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				}catch(Exception e){
					e.printStackTrace();
				}
			%>
			<%	
				try{
				connection = DriverManager.getConnection(url, username, password);
				String query = "Select * from plans";
				statement = connection.createStatement();
				resultSet = statement.executeQuery(query);
				while(resultSet.next()){	
			%>
			<tr>
				<td><%=resultSet.getString("plan_id")%></td>
				<td><%=resultSet.getString("description")%></td>
				<td><%=resultSet.getString("speech_time")%></td>
				<td><%=resultSet.getString("sms")%></td>
				<td><%=resultSet.getString("data")%></td>
				<td><%=resultSet.getString("price")%></td>
			</tr>
			<%
				}
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					if(connection != null)connection.close();
					if(statement != null)statement.close();
					if(resultSet != null)resultSet.close();
				}
			%>
		</table>
		</div>
	</body>
</html>