<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Company</title>
</head>
<body>
	<%if(session.getAttribute("username")==null)response.sendRedirect("index.html");%>
	<form action="AdminNewSeller" method="post">
		<div align="center">
			<h1>Sign Up.</h1>
			<table>
				<tr>
					<td>Enter the seller's ID:</td>
					<td><input type="text" name="sellerID" required></td>
				</tr>
				<tr>
				<tr>
					<td>Enter the seller's username:</td>
					<td><input type="text" name="username" required></td>
				</tr>
				<tr>
					<td>Enter the seller's password:</td>
					<td><input type="password" name="password" required></td>
				</tr>
				<tr>
					<td>Enter the seller's name:</td>
					<td><input type="text" name="firstName" required></td>
				</tr>
				<tr>
					<td>Enter the seller's surname:</td>
					<td><input type="text" name="surname" required></td>
				</tr>
				<tr>
					<td>Enter your username:</td>
					<td><input type="text" name="adminUsername" required></td>
				</tr>				
				<tr>
					<td><input type="submit" value="Sign Up"></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>