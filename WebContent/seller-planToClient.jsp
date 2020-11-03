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

	<form action="Seller-PlanToClient" method="get">
		<div align="center">
			<h1>Please enter the client's phone number and the plan's ID</h1>
			<table>
				<tr>
					<td>Phone number:</td>
					<td><input type="text" name="clientPhoneNumber" required></td>
				</tr>
				<tr>
					<td>Plan ID:</td>
					<td><input type="text" name="planID" required></td>
				</tr>
				<tr>
					<td><input type="submit" value="Submit"></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>