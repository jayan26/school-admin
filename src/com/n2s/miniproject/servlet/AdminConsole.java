package com.n2s.miniproject.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.n2s.miniproject.StudentDetail;
import com.n2s.miniproject.core.StudentDetailDAO;


@WebServlet("/AdminConsole")
public class AdminConsole extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String adminSelect = request.getParameter("admin_sel");
		
		if(adminSelect.equals("create")) {
			response.sendRedirect("Create.jsp");
		} else if(adminSelect.equals("update")) {
			response.sendRedirect("UpdateStart.jsp");
		} else if(adminSelect.equals("view")) {
			response.sendRedirect("View.jsp");
		}else if(adminSelect.equals("delete")) {
			response.sendRedirect("Delete.jsp");
		}else if(adminSelect.equals("allData")){
			response.sendRedirect("AllData");
		}
//		else if(adminSelect.equals("logout")) {
//			System.out.println("sending the data to the logout.java....................");
//			RequestDispatcher rd = request.getRequestDispatcher("/Logout");
//			rd.forward(request, response);
//		}
		
	}

}
