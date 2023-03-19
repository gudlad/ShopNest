<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Login</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

	<h2 id="head">Login to Start shopping</h2>
	<div class="register_">
		<form method="post" action="login">
		
		<label><b>User Name :</b></label>
		<input type="text" name="uname" id="textBox" placeholder="username" required="required">
		<br><br>
		
		<label><b>Password :</b></label>
		<input type="password" name="password" id="textBox" placeholder="password">
		<br><br>
		<input type="submit" id="sub" value="Login">
		<br><br>
		<a id="a2" href="register.jsp">New user? Regiser here</a>
		</form>
	</div>
</body>
</html>
