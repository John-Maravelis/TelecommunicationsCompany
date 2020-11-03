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
	<%if (session.getAttribute("username") == null)response.sendRedirect("index.html");%>
	<div align="center">
		<h1>Your current bill</h1>
		<table>
			<tr>
				<th>Your phone number</th>
				<th>Bill ID</th>
				<th>Month</th>
				<th>Plan</th>
				<th>Bill price</th>
				<th>Status</th>
			</tr>
			<tr>
				<td>${phoneNumber}</td>
				<td>${bill_id}</td>
				<td>${month}</td>
				<td>${plan}</td>
				<td>${price}</td>
				<td>${status}</td>
			</tr>
		</table>

		<form action="PayBill" method="get">
			<p>Would you like to pay your bill?></p>
			<input type="submit" name="Pay bill">
		</form>
	</div>
</body>
</html>