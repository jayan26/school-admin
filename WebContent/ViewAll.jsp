<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.n2s.miniproject.core.StudentDetailDAO" import="java.util.*" 
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
<title>View All</title>
</head>
<body>

<table style="
    align-items: center;
    width: 100%;
" >

<tr>
	<th>Student Id</th>
	<th>First Name</th>
	<th>Last Name</th>
	<th>Address</th>
	<th>Phone Number</th>
	<th>Course</th>
	<th>E-Mail</th>
	</tr>

<%

response.setHeader("Cache-Control", "no-cache, no-store must-revalidate"); 	//for HTTP 1.1
response.setHeader("parag", "no-cache");									//for HTTP 1.0
response.setHeader("expires", "0");
		
if(session.getAttribute("uname")==null){
	response.sendRedirect("Login.jsp");
}else{
		
}

List <StudentDetail> list1 = (List<StudentDetail>)request.getAttribute("allList");

for(StudentDetail st: list1){
	int id = st.getStudentID();
	String fname = st.getFirst_name();
	String lname = st.getLast_name();
	String address = st.getAddress();
	String phone = st.getPhone_number();
	String course = st.getCourse();
	String email = st.getE_mail(); 
	%>
	
	
	

	<tr>
	<td><%=id %></td>
	<td><%=fname %></td>
	<td><%=lname %></td>
	<td><%=address %></td>
	<td><%=phone %></td>
	<td><%=course %></td>
	<td><%=email %></td>
	</tr>
	
	
<%	}

%>
</table>
</body>
</html>