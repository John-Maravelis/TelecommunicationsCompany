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
	<form action="AdminUpdatePlan" method="get">
		<div align="center">
			<table>
				<tr>
					<td>Which plan would you like to update (Input plan ID) ?</td>
					<td><input type="text" name="planID" required></td>
				</tr>
				<tr>
					<td>Enter the new description:</td>
					<td><input type="text" name="Description" required></td>
				</tr>
				<tr>
					<td>Enter the new speech time: </td>
					<td><input type="text" name="SpeechTime" required></td>
				</tr>
				<tr>
					<td>Enter the new SMS number: </td>
					<td><input type="text" name="Sms" required></td>
				</tr>
				<tr>
					<td>Enter the new data number: </td>
					<td><input type="text" name="Data" required></td>
				</tr>
				<tr>
					<td>Enter the new price: </td>
					<td><input type="text" name="Price" required></td>
				</tr>
				<tr>
					<td><input type="submit" value="Update plan"></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>