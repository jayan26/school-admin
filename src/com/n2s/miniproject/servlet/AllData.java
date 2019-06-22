package com.n2s.miniproject.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.n2s.miniproject.StudentDetail;
import com.n2s.miniproject.core.StudentDetailDAO;

@WebServlet("/AllData")
public class AllData extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		StudentDetailDAO sdd = new StudentDetailDAO();
		List<StudentDetail> list1 = new ArrayList<StudentDetail>();
		try {
			list1 = sdd.getAllStudentDetail();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		for (StudentDetail getView : list1) {
			
			out.println("Student Id: "+getView.getStudentID());
			out.println("First Name: "+getView.getFirst_name());
			out.println("Last name: "+getView.getLast_name());
			out.println("Address: "+getView.getAddress());
			out.println("Phone Number: "+getView.getPhone_number());
			out.println("Course: "+getView.getCourse());
			out.println("E Mail: "+getView.getE_mail());
			out.println();
			out.println();
		}
	}
	
	
}
