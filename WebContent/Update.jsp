<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.n2s.miniproject.StudentDetail"%>
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
<title>Update</title>
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

int id = Integer.parseInt(request.getAttribute("id").toString());
StudentDetail stud = new StudentDetail();
stud = (StudentDetail) request.getAttribute("studentData");
String fname = stud.getFirst_name();
String lname = stud.getLast_name();
String phone = stud.getPhone_number();
String address = stud.getAddress();
String course = stud.getCourse();
String email = stud.getE_mail();

%>

<form action="Update" method="post" style="
    align-items: center;
    width: 300px;
    height: 390px;
">

<table>
<tr><td><b></b></td></tr>
<tr><td><input type="hidden" name="student_id" value="<%=id%>"></td></tr>
<tr><td>Enter all the details you want to update</td></tr>
<tr></tr>
<tr><td>First name</td></tr>
<tr><td><input type="text" name="first_name" value="<%=fname%>"></td></tr>
<tr><td>Last name</td></tr>
<tr><td><input type="text" name="last_name" value="<%=lname%>"></td></tr>
<tr><td>Phone number</td></tr>
<tr><td><input type="text" name="phone" value="<%=phone%>"></td></tr>
<tr><td>Address</td></tr>
<tr><td><input type="text" name="address" value="<%=address%>"></td></tr>
<tr><td>Course</td></tr>
<tr><td><input type="text" name="course" value="<%=course%>"></td></tr>
<tr><td>e-mail</td></tr>
<tr><td><input type="text" name="e_mail" value="<%=email%>"></td></tr>
<tr><th> </th></tr>
<tr><td><input type="submit" class="button" name="updateValue" value="update"></td></tr>
</table>
</form>

</body>
</html>