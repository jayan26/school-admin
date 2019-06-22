<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<script type="text/javascript" src="Style/LoginValidation.js"></script>
</head>

<body>

<form action="Login" method="post" name="loginform" onsubmit="return validateLoginForm()">
<table style="width:25%">

<tr>
<th>User Name</th>
<td><input type="text" name="uname"></td>
</tr>

<tr>
<th>Password</th>
<td><input type="password" name="pass"></td>
</tr>

<tr>
<th></th>
<td><input type="submit" name="login_selection" value="login"></td>
</tr>

<tr>
<th></th>
<td><input type="submit" name="login_selection" value="register"></td>
</tr>

</table>
</form>
</body>
</html>