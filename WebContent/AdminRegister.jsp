<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.button {
  font: bold 11px Arial;
  text-decoration: none;
  background-color: #EEEEEE;
  color: #333333;
  padding: 2px 6px 2px 6px;
  border-top: 1px solid #CCCCCC;
  border-right: 1px solid #333333;
  border-bottom: 1px solid #333333;
  border-left: 1px solid #CCCCCC;
}
</style>
<meta charset="ISO-8859-1">
<title>Admin Register</title>
</head>
<body>

<%
response.setHeader("Cache-Control", "no-cache, no-store must-revalidate"); 	//for HTTP 1.1
response.setHeader("parag", "no-cache");									//for HTTP 1.0
response.setHeader("expires", "0");											//for proxy servers
%>

<form action="AdminRegisterServ" method="post">

<table>

<tr>
<th>User Name</th>
<td><input type="text" name="admin_uname"></td>
</tr>

<tr>
<th>Password</th>
<td><input type="password" name="admin_pass"></td>
</tr>

<tr>
<th>Confirm Password</th>
<td><input type="password" name="admin_conf_pass"></td>
</tr>

<tr>
<th>First name</th>
<td><input type="text" name="f_name"></td>
</tr>

<tr>
<th>Last name</th>
<td><input type="text" name="l_name"></td>
</tr>

<tr>
<th>Address</th>
<td><input type="text" name="address"></td>
</tr>

<tr>
<th>Phone Number</th>
<td><input type="text" name="phone_no"></td>
</tr>

<tr>
<th colspan="2">Please Answer these Security Questions</th>
<tr>

<th>what is your pet name</th>
<td><input type="text" name="ans_1"></td>
</tr>
<tr>
<th>Name of your Home town</th>
<td><input type="text" name="ans_2"></td>
</tr>

<tr>
<th>Enter a Custom Question</th>
<td><input type="text" name="cus_ques"></td>
</tr>

<tr>
<th>Enter the answer</th>
<td><input type="text" name="cus_ans"></td>
</tr>

<tr>
<th></th>
<td><input type="submit" class="button" value="register" name="submit_button"></td>
</tr>

<tr>
<th></th>
<td><input type="submit" class="button" value="login page" name="submit_button"></td>
</tr>

</table>


</form>
</body>
</html>