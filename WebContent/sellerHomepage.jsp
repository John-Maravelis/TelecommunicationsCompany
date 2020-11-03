<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Seller Home Page</title>
</head>
<body>
	<%if(session.getAttribute("username")==null)response.sendRedirect("index.html");%>
	<div align="center">
		<h1>Welcome to the seller homepage!</h1>
		<h3>Which of the following would you like to do?</h3>
		<table>
			<tr>
				<td>Create new client? <a href="seller-newClient.jsp">Register new client.</a></td>
			</tr>
			<tr>
				<td>Give a plan to a client <a href="seller-planToClient.jsp">Allocate plan to client.</a></td>
			</tr>
			<tr>
			<tr>
				<td>Print client's bill <a href="seller-createBill.jsp" target="_blank">Client's bill.</a></td>
			</tr>
			<tr>
			<tr>
				<td>Show all active plans <a href="seller-activePlans.jsp" target="_blank">Active plans.</a></td>
			</tr>
		</table>
					
		<form action="ClientLogOut" method="get">
			<p>Would you like to sign out?</p>
			<input type="submit" value="Sign out">
		</form>
	</div>
</body>
</html>