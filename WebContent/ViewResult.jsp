<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="com.n2s.miniproject.core.StudentDetailDAO" import="java.util.*" 
    import="com.n2s.miniproject.StudentDetail"%>
<!DOCTYPE html>
<html>
<head>
<style>
table,th,td{
border=1px solid black;
border-collapse: collapse;
}
th,td{
padding: 10px;
}
</style>
<meta charset="ISO-8859-1">
<title>View Result</title>
</head>
<body>

<%

response.setHeader("Cache-Control", "no-cache, no-store must-revalidate"); 	//for HTTP 1.1
response.setHeader("parag", "no-cache");									//for HTTP 1.0
response.setHeader("expires", "0");
		
if(session.getAttribute("uname")==null){
	response.sendRedirect("Login.jsp");
}else{
		
}

List <StudentDetail> list1 = (List<StudentDetail>)request.getAttribute("list");

int id=0;
String fname=null;
String lname=null;
String address=null;
String phone=null;
String course=null;
String email=null; 

for(StudentDetail st: list1){
	id = st.getStudentID();
	fname = st.getFirst_name();
	lname = st.getLast_name();
	address = st.getAddress();
	phone = st.getPhone_number();
	course = st.getCourse();
	email = st.getE_mail(); 
}
%>

<table>
<tr>
<th>Student Id</th>
<th>First Name</th>
<th>Last Name</th>
<th>Address</th>
<th>Phone Number</th>
<th>Course</th>
<th>E-Mail</th>
</tr>

<tr>
<td><%=id %></td>
<td><%=fname %></td>
<td><%=lname %></td>
<td><%=address %></td>
<td><%=phone %></td>
<td><%=course %></td>
<td><%=email %></td>
</tr>
</table>


</body>
</html>