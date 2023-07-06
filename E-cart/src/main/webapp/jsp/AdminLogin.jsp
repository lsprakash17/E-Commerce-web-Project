<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
</head>
<body>
	<div>
		<h1>${fail}</h1>
		<form action="/admin/login" method="post">
			<h2>This is Admin Login</h2>
			Email: <input type="text" name="email"> <br> Password: <input
				type="text" name="password">
			<button type="submit">Login</button>
			<button type="reset">Clear</button>
			<a href="/jsp/Home.jsp"><button type="button">Home</button></a>
		</form>
	</div>
</body>
</html>