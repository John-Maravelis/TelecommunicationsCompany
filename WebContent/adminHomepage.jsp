<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Company</title>
</head>
<body>
	<%if (session.getAttribute("username") == null)response.sendRedirect("index.html");%>
	<div align="center">
		<h1>Welcome to the administrator homepage!</h1>
		<h3>Which of the following would you like to do?</h3>
		
		<table>
			<tr>
				<td>Create new seller?<a href="admin-newSeller.jsp">Register new seller.</a></td>
			</tr>
			<tr>
				<td>Create a new plan.<a href="admin-newPlan.jsp">Create plan.</a></td>
			</tr>
			<tr>
				<td>Update a current plan.<a href="admin-updatePlan.jsp">Update plan.</a></td>
			</tr>			
		</table>

		<form action="ClientLogOut" method="get">
			<p>Would you like to sign out?</p>
			<input type="submit" value="Sign out">
		</form>
	</div>
</body>
</html>