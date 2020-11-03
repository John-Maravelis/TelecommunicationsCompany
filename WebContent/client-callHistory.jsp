<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<h1>Your call history</h1>
		<table>
			<tr>
				<th>Your ID</th>
				<th>Call duration</th>
				<th>Caller's phone number</th>
			</tr>
			
			<tr>
			<td>${clientID}</td>
			<td>${duration}</td>
			<td>${caller}</td>
			</tr>
		</table>
	</div>
</body>
</html>