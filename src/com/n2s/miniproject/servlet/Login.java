package com.n2s.miniproject.servlet;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.n2s.miniproject.AdminLogin;
import com.n2s.miniproject.core.AdminDAO;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static boolean set=false;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminDAO adm = new AdminDAO();
		AdminLogin adml = new AdminLogin();
		
		if(request.getParameter("login_selection").equals("login")) {
			
		
		
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		
		HttpSession session = request.getSession();
		session.setAttribute("uname", uname);
		
		try {
			String dbPassword = adm.getAdminPassword(uname);
				if(dbPassword.equals(pass)) {
					response.sendRedirect("AdminConsole.jsp");
				}else {
					response.sendRedirect("Login.jsp");
				}	
		} catch (ClassNotFoundException | SQLException e) {e.printStackTrace();}
		}else {
		
		response.sendRedirect("AdminRegister.jsp");
		
	}
	}
}
