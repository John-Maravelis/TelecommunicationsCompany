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
	<div align="center">
		<h1>Welcome to the client homepage!</h1>
		<h3>Which of the following would you like to do?</h3>
		
			<form action="ShowBill" method="get">
				<p>See bill</p>
				<input type="submit" value="Bill">
			</form>
			<form action="CallHistory" method="get">
				<p>Show call history</p>
				<input type="submit" value="Call history">
			</form>
	
		<form action="ClientLogOut" method="get">
			<p>Would you like to sign out?</p>
			<input type="submit" value="Sign out">
		</form>
	</div>
</body>
</html>