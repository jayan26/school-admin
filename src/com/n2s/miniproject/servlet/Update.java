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

@WebServlet("/Update")
public class Update extends HttpServlet {
	static boolean cond = true;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		if (request.getParameter("updateValue").equals("update")) {

			String f_name = request.getParameter("first_name");
			String l_name = request.getParameter("last_name");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			String course = request.getParameter("course");
			String e_mail = request.getParameter("e_mail");
			int student_id = Integer.parseInt(request.getParameter("student_id"));

			StudentDetail sd = new StudentDetail();
			StudentDetailDAO sdao = new StudentDetailDAO();

			boolean created = false;

			if (cond) {
				sd.setFirst_name(f_name);
				sd.setLast_name(l_name);
				sd.setPhone_number(phone);
				sd.setAddress(address);
				sd.setCourse(course);
				sd.setE_mail(e_mail);
				sd.setStudentID(student_id);
				try {
					created = sdao.updateStudentDetail(sd);

				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}

				if (created) {
					out.println("Successfully updated!");
				} else {
					out.println("Error in updating");
				}

			}
		}

	}

}
