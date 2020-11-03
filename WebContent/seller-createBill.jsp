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
	<form action="SellerCreateBill"  method="get">
		<div align="center">
			<h1>Create customer bill.</h1>
			<table>
				<tr>
					<td>Client's ID:</td>
					<td><input type="text" name="clientID" required></td>
				</tr>
				<tr>
					<td>Bill ID:</td>
					<td><input type="text" name="billID" required></td>
				</tr>
				<tr>
					<td>Plan ID:</td>
					<td><input type="text" name="planID" required></td>
				</tr>
				<tr>
					<td>Month:</td>
					<td><input type="text" name="month" required></td>
				</tr>
				<tr>
					<td>Status:</td>
					<td><input type="text" name="status" required></td>
				</tr>
				<tr>
					<td>Price:</td>
					<td><input type="text" name="price" required></td>
				</tr>
				<tr>
					<td><input type="submit" value="Create bill"></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>