package com.n2s.miniproject.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.n2s.miniproject.AdminRegister;
import com.n2s.miniproject.core.AdminDAO;

@WebServlet("/AdminRegisterServ")
public class AdminRegisterServ extends HttpServlet {
	static boolean created=false;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		if(request.getParameter("submit_button").equals("register")) {

		String admin_uname = request.getParameter("admin_uname");
		String admin_pass = request.getParameter("admin_pass");
		String con_pass = request.getParameter("admin_conf_pass");
		String f_name = request.getParameter("f_name");
		String l_name = request.getParameter("l_name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone_no");
		String ans1 = request.getParameter("ans_1");
		String ans2 = request.getParameter("ans_2");
		String cus_ques = request.getParameter("cus_ques");
		String cus_ans = request.getParameter("cus_ans");
		
		if(admin_pass.equals(con_pass) && phone.length()==10 && admin_pass.length()>=8) {
			AdminDAO addo = new AdminDAO();
			AdminRegister adr = new AdminRegister();
			adr.setAdmin_uname(admin_uname);
			adr.setAdmin_pass(admin_pass);
			adr.setFirst_name(f_name);
			adr.setLast_name(l_name);
			adr.setAddress(address);
			adr.setPhone_no(phone);
			adr.setAns1(ans1);
			adr.setAns2(ans2);
			adr.setCus_question(cus_ques);
			adr.setCus_answer(cus_ans);
			
			HttpSession session = request.getSession();
			session.setAttribute("uname", admin_uname);
			
			try {
				created = addo.createAdmin(adr);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			if(created) {
				System.out.println("created and sending to logout.java..............");
				response.sendRedirect("/Logout");
			}
		}else {
			response.sendRedirect("AdminRegister.jsp");
		}
	}else {
		response.sendRedirect("Login.jsp");
	}
	}

}
