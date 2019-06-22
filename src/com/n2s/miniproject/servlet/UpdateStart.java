package com.n2s.miniproject.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.n2s.miniproject.StudentDetail;
import com.n2s.miniproject.core.StudentDetailDAO;

@WebServlet("/UpdateStart")
public class UpdateStart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean set = false;
		StudentDetail sddr = null;
		List<StudentDetail> list1 = null;
		int id;
		int DBId;
		StudentDetailDAO sdd = new StudentDetailDAO();
		
		if(request.getParameter("student_id").toString().length()==0) {
			System.out.println("update is null");
			response.sendRedirect("UpdateStart.jsp");
		}else {
			id = Integer.parseInt(request.getParameter("student_id").toString());
			try {
				list1 = sdd.getAllStudentDetail();
			} catch (ClassNotFoundException | SQLException e) {e.printStackTrace();}
			
			for (StudentDetail studentDetail : list1) {
				DBId = studentDetail.getStudentID();
				if(DBId==id) {
					set=true;
					break;
				}
			}
			
			if(set) {
				try {
					sddr = sdd.getStudentDetail(id);
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				request.setAttribute("studentData", sddr);
				request.setAttribute("id", id);
				RequestDispatcher rd = request.getRequestDispatcher("Update.jsp");
				rd.forward(request, response);
			}else {
				response.sendRedirect("UpdateError.jsp");
			}
		}
		
		
	}

}
