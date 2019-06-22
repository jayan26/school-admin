package com.n2s.miniproject.core;

import java.sql.SQLException;
import java.util.List;

import com.n2s.miniproject.StudentDetail;

public interface StudentInfo {

	public int createStudentDetail(StudentDetail studentDetail) throws SQLException, ClassNotFoundException;
	public boolean updateStudentDetail(StudentDetail studentDetail) throws SQLException, ClassNotFoundException;
	public StudentDetail getStudentDetail(int studentId) throws ClassNotFoundException, SQLException;
	public boolean deleteStudentDetail(int studentId) throws ClassNotFoundException, SQLException;
	public List<StudentDetail> getAllStudentDetail() throws ClassNotFoundException, SQLException;
	
}
