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

@WebServlet("/Create")
public class Create extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static boolean cond = true;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int created = 0;
		PrintWriter out = response.getWriter();

		String f_name = request.getParameter("first_name");
		String l_name = request.getParameter("last_name");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String course = request.getParameter("course");
		String e_mail = request.getParameter("e_mail");

		StudentDetail sd = new StudentDetail();
		StudentDetailDAO sdao = new StudentDetailDAO();

		try {
			List<StudentDetail> list1 = new ArrayList<StudentDetail>();
			list1 = sdao.getAllStudentDetail();

			for (StudentDetail studentDetail : list1) {
				if (studentDetail.getFirst_name().equals(f_name) && studentDetail.getLast_name().equals(l_name)) {
					response.sendRedirect("CreateNameError.jsp");
					break;
				}else if(phone.length()!=10) {
					System.out.println("executing and moving to phone error...........");
					response.sendRedirect("CreatePhoneError.jsp");
					break;
				}else {
					System.out.println("executing the normal update.................");
					sd.setFirst_name(f_name);
					sd.setLast_name(l_name);
					sd.setPhone_number(phone);
					sd.setAddress(address);
					sd.setCourse(course);
					sd.setE_mail(e_mail);

					try {
						created = sdao.createStudentDetail(sd);
						out.println("Student has been created!");
						out.println(" Created Id of the student " + f_name + " " + l_name + " is " + created);
					} catch (SQLException e) {
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}