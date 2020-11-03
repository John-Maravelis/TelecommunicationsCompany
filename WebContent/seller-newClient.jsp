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

	<form action="SellerNewClient" method="post">
		<div align="center">
			<h1>Create new client.</h1>
			<table>
				<tr>
					<td>Enter client's ID</td>
					<td><input type="text" name="clientID" required></td>
				</tr>
				<tr>
					<td>Enter the client's username:</td>
					<td><input type="text" name="username" required></td>
				</tr>
				<tr>
					<td>Enter the client's password:</td>
					<td><input type="password" name="password" required></td>
				</tr>
				<tr>
					<td>Enter the client's name:</td>
					<td><input type="text" name="firstName" required></td>
				</tr>
				<tr>
					<td>Enter the client's surname:</td>
					<td><input type="text" name="surname" required></td>
				</tr>
				<tr>
				<tr>
					<td>Enter the client's phone number:</td>
					<td><input type="text" name="phoneNumber" required></td>
				</tr>
				<tr>
					<td>Enter the client's AFM:</td>
					<td><input type="text" name="AFM" required></td>
				</tr>
				<tr>
					<td>Enter the client's zip code:</td>
					<td><input type="text" name="zip"></td>
				</tr>
				<tr>
					<td>Enter your username:</td>
					<td><input type="text" name="sellerUsername" required></td>
				</tr>
				<tr>
					<td><input type="submit" value="Create client"></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>