<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
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
<head>
<meta charset="ISO-8859-1">
<title>View</title>
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
<form action="View" method="post" style="
    align-items: center;
    width: 100%;
">

<table>
<tr><td>enter the Student ID</td></tr>
<tr><td><input type="text" name="student_id"></td></tr>
<tr><td><input type="submit" class="button" name="viewValue" value="View Details"></td></tr>
</table>
</form>

<form action="View" method="post">
<table>
<tr>
<td><input type="submit" class="button" name="viewValue" value="View All Details"></td>
</tr>
</table>
</form>

</body>
</html>