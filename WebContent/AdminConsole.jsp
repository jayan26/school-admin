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
<title>Admin Console</title>
</head>
<body>

<%
response.setHeader("Cache-Control", "no-cache, no-store must-revalidate"); 	//for HTTP 1.1
response.setHeader("parag", "no-cache");									//for HTTP 1.0
response.setHeader("expires", "0");											//for proxy servers

if(session.getAttribute("uname")==null){
	response.sendRedirect("Login.jsp");
}else{
	String name = session.getAttribute("uname").toString();
	out.println("Welcome "+name+"!");
}
%>

<form action="Logout">
<input type="submit" class="button" name="logoutValue" value="logout">
</form>


<table>
<tr>
<th><a class="button" href="Create.jsp" target="activepage">Create</a></th>
<th><a class="button" href="UpdateStart.jsp" target="activepage">Update</a></th>
<th><a class="button" href="View.jsp" target="activepage">View</a></th>
<th><a class="button" href="Delete.jsp" target="activepage">Delete</a></th>
</tr>

<tr>
</tr>
</table>

<iframe src="Create.jsp" name="activepage" frameBorder="0" width="1000" height="800"></iframe>


</body>
</html>