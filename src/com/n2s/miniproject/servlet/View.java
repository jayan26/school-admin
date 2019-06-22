package com.n2s.miniproject.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.n2s.miniproject.StudentDetail;
import com.n2s.miniproject.core.StudentDetailDAO;


@WebServlet("/View")
public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		List<StudentDetail> list1 = new ArrayList<>();
		StudentDetailDAO sdd = new StudentDetailDAO();
		
		if(request.getParameter("viewValue").equals("View Details")) {
			
		
		if(request.getParameter("student_id").toString().length()==0) {
			System.out.println("view is null");
			response.sendRedirect("View.jsp");
			
		}else {
			int student_id = Integer.parseInt(request.getParameter("student_id"));
		
		try {
			StudentDetail getView = sdd.getStudentDetail(student_id);	
			list1.add(getView);
			request.setAttribute("list", list1);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		if(list1 == null || !list1.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("ViewResult.jsp");
			rd.forward(request, response);
			response.sendRedirect("View.jsp");
		}else {
			response.sendRedirect("ViewIDError.jsp");
		}
		}
		}else {
		try {
			list1 = sdd.getAllStudentDetail();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("allList", list1);
		RequestDispatcher rd = request.getRequestDispatcher("ViewAll.jsp");
		rd.forward(request, response);
	}
	}

}
