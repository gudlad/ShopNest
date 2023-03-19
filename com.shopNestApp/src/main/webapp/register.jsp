<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Registration</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

	<h2>Register here</h2>
	<div class="register">
		<form method="post" action="register">
		
		<label><b>User Name :</b></label>
		<input type="text" name="uname" id="textBox" placeholder="username" required="required">
		<br><br>
		
		<label><b>Email :</b></label>
		<input type="email" name="mail" id="textBox" placeholder="mail">
		<br><br>
		
		<label><b>Password :</b></label>
		<input type="password" name="password" id="textBox" placeholder="password">
		<br><br>
		
		<label><b>Gender :</b></label>
		<input type="radio" name="gender" value="male">Male
		<input type="radio" name="gender" value="female">Female
		<input type="radio" name="gender" value="other">Other
		<br><br>
		
		<label><b>Address :</b></label>
		<textarea rows="2" cols="20" id="textBox" class="textarea" name="address"></textarea>
		<br><br>
		<input type="submit" id="sub" value="Register">
		<br><br>
		
		<a href="login.jsp">Already registered? Sign in instead</a>
		
		</form>
	</div>
</body>
</html>