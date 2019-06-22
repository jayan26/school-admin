package com.n2s.miniproject.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.n2s.miniproject.DBQueries;
import com.n2s.miniproject.StudentDetail;

public class StudentDetailDAO implements StudentInfo{
	
	private Connection conn=null;
	private PreparedStatement temp=null;
	private PreparedStatement pst=null;
	private ResultSet rs =null;
	
	@Override
	public int createStudentDetail(StudentDetail studentDetail) throws SQLException, ClassNotFoundException { //Creating Student
		int created;
		DBQueries query = new DBQueries();
		conn=DBManager.getDBConnection();
		if(conn!=null) {
			System.out.println("connection created in create statement");
			}
		
		String sql=query.getInsert();
		pst=conn.prepareStatement(sql);
		pst.setString(1, studentDetail.getFirst_name());
		pst.setString(2, studentDetail.getLast_name());
		pst.setString(3, studentDetail.getPhone_number());
		pst.setString(4, studentDetail.getAddress());
		pst.setString(5, studentDetail.getCourse());
		pst.setString(6, studentDetail.getE_mail());
		
		pst.executeUpdate();
		
		temp=conn.prepareStatement("select student_id from students where first_name=? AND last_name=?");
		temp.setString(1, studentDetail.getFirst_name());
		temp.setString(2, studentDetail.getLast_name());
		rs=temp.executeQuery();
		rs.next();
		created=rs.getInt(1);
		conn.commit();
		pst.close();
		conn.close();
		DBManager.dbDisconnect();
		return created;
	}

	@Override
	public boolean updateStudentDetail(StudentDetail studentDetail) throws SQLException, ClassNotFoundException {	//updating student
		boolean res=false;
		DBQueries query = new DBQueries();
		conn=DBManager.getDBConnection();
		if(conn!=null) {
			System.out.println("connection created in update statement");
			}
				
		String sql=query.getUpdate();
		pst=conn.prepareStatement(sql);
		pst.setString(1, studentDetail.getFirst_name());
		pst.setString(2, studentDetail.getLast_name());
		pst.setString(3, studentDetail.getPhone_number());
		pst.setString(4, studentDetail.getAddress());
		pst.setString(5, studentDetail.getCourse());
		pst.setString(6, studentDetail.getE_mail());
		pst.setInt(7, studentDetail.getStudentID());
				
		int ques = pst.executeUpdate();
		if(ques!=0) {
			res=true;
		}
		conn.commit();
		pst.close();
		conn.close();
		DBManager.dbDisconnect();
		return res;
	}

	@Override
	public StudentDetail getStudentDetail(int studentId) throws ClassNotFoundException, SQLException {	//get single student data
		DBQueries query = new DBQueries();
		StudentDetail stud = new StudentDetail();
		conn=DBManager.getDBConnection();
		if(conn!=null) {
			System.out.println("connection created in view statement");
			}
		String select = query.getSelect();
		pst=conn.prepareStatement(select);
		pst.setInt(1, studentId);
		rs=pst.executeQuery();
		rs.next();
		stud.setStudentID(rs.getInt(1));
		stud.setFirst_name(rs.getString(2));
		stud.setLast_name(rs.getString(3));
		stud.setPhone_number(rs.getString(4));
		stud.setAddress(rs.getString(5));
		stud.setCourse(rs.getString(6));
		stud.setE_mail(rs.getString(7));
		pst.close();
		conn.close();
		DBManager.dbDisconnect();
		return stud;
	}

	@Override
	public boolean deleteStudentDetail(int studentId) throws ClassNotFoundException, SQLException {	//delete student data
		boolean res= false;
		DBQueries query = new DBQueries();
		conn=DBManager.getDBConnection();
		if(conn!=null) {
			System.out.println("connection created in delete statement");
			}
		
		String select = query.getDelete();
		pst=conn.prepareStatement(select);
		pst.setInt(1, studentId);
		int ques = pst.executeUpdate();
		if(ques!=0) {
			res=true;
		}
		conn.commit();
		pst.close();
		conn.close();
		DBManager.dbDisconnect();
		return res;
	}

	@Override
	public List<StudentDetail> getAllStudentDetail() throws ClassNotFoundException, SQLException {	//get all student data
		List <StudentDetail> allStudents = new ArrayList<>();
		DBQueries query = new DBQueries();
		String selectAll = query.getSelectAll();
		conn=DBManager.getDBConnection();
		if(conn!=null) {
			System.out.println("connection created in all students statement");
			}
		pst = conn.prepareStatement(selectAll);
		rs = pst.executeQuery();
		
		while(rs.next()) {
			StudentDetail stud = new StudentDetail();
			stud.setStudentID(rs.getInt(1));
			stud.setFirst_name(rs.getString(2));
			stud.setLast_name(rs.getString(3));
			stud.setPhone_number(rs.getString(4));
			stud.setAddress(rs.getString(5));
			stud.setCourse(rs.getString(6));
			stud.setE_mail(rs.getString(7));
			
			allStudents.add(stud);
		}
		pst.close();
		conn.close();
		DBManager.dbDisconnect();
		return allStudents;
	}

}
