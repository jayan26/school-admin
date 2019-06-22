package com.n2s.miniproject.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.n2s.miniproject.StudentDetail;
import com.n2s.miniproject.core.StudentDetailDAO;

@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname=null, lname = null;
		PrintWriter out = response.getWriter();
		boolean res = false;
		boolean set = false;
		int DBId;
		List <StudentDetail> list1 = null;
		
		if(request.getParameter("deleteValue").equals("delete")) {

			if(request.getParameter("student_id").toString().length()==0) {
				System.out.println("delete is null");
				response.sendRedirect("Delete.jsp");
			}else {
				StudentDetailDAO sdd = new StudentDetailDAO();
				int id = Integer.parseInt(request.getParameter("student_id"));
				try {
					list1=sdd.getAllStudentDetail();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
				
				for (StudentDetail studentDetail : list1) {
					DBId = studentDetail.getStudentID();
					
					if(DBId==id) {
						fname=studentDetail.getFirst_name();
						lname=studentDetail.getLast_name();
						res=true;
						break;
					}
				}
				
				if(res) {
				
					try {
						set = sdd.deleteStudentDetail(id);
					} catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
					}
					out.println("Successfully deleted the student detail of "+fname+" "+lname+" !");
					
				}else {
					response.sendRedirect("DeleteErroe.jsp");
				}
			}
		
		
		
	}

	}}
