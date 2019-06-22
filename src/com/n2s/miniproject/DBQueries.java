package com.n2s.miniproject;

public class DBQueries {

	private String insert="INSERT INTO students(first_name,last_name,phone_number,address,course,e_mail) VALUES(?,?,?,?,?,?)";
	private String select ="SELECT * FROM students WHERE student_id=?";
	private String update="UPDATE students SET first_name=?,last_name=?,phone_number=?,address=?,course=?,e_mail=? WHERE student_id=?";
	private String delete = "DELETE FROM students WHERE student_id=?";
	private String selectAll="SELECT * from students";
	private String getPassword ="SELECT admin_password FROM student_admin WHERE admin_uname=?";
	
	private String adminSelectAll = "SELECT * from student_admin";
	private String adminInsert = "INSERT INTO student_admin VALUES (?,?,?,?,?,?,?,?,?,?)";
	
	public String getAdminSelectAll() {
		return adminSelectAll;
	}
	public String getInsert() {
		return insert;
	}
	public String getSelect() {
		return select;
	}
	public String getUpdate() {
		return update;
	}
	public String getDelete() {
		return delete;
	}
	public String getSelectAll() {
		return selectAll;
	}
	public String getAdminInsert() {
		return adminInsert;
	}
	public String getGetPassword() {
		return getPassword;
	}
	
}
