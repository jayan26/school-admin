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
<title>Update Error</title>
</head>
<body>
<%
response.setHeader("Cache-Control", "no-cache, no-store must-revalidate"); 	//for HTTP 1.1
response.setHeader("parag", "no-cache");									//for HTTP 1.0
response.setHeader("expires", "0");											//for proxy servers

if(session.getAttribute("uname")==null){
	response.sendRedirect("Login.jsp");
}else{
	
}
%>
<form action="UpdateStart" method="post" style="
    align-items: center;
    width: 100%;
">

<table>
<tr><td>Enter the student ID to be changed</td></tr>
<tr><td><input type="text" name="student_id"></td><td><b>Please enter a valid ID</b></td>
</tr>
<tr><td><input type="submit" class="button" name="updateValue" value="update"></td></tr>
</table>
</form>

</body>
</html>