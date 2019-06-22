package com.n2s.miniproject.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.n2s.miniproject.AdminLogin;
import com.n2s.miniproject.AdminRegister;
import com.n2s.miniproject.DBQueries;

public class AdminDAO{
	
	private Connection conn=null;
	private PreparedStatement temp=null;
	private PreparedStatement pst;
	private ResultSet rs =null;
	
	public List<AdminLogin> allAdminLoginData() throws ClassNotFoundException, SQLException{
		List<AdminLogin> list1 = new ArrayList<>();
		DBQueries query = new DBQueries();
		conn=DBManager.getDBConnection();
		String select = query.getAdminSelectAll();
		pst=conn.prepareStatement(select);
		rs=pst.executeQuery();
		while(rs.next()) {
			AdminLogin adl = new AdminLogin();
			adl.setAdmin_username(rs.getString("admin_uname"));
			adl.setAdmin_password(rs.getString("admin_password"));
			list1.add(adl);
		}
		return list1;
	}
	
	public boolean createAdmin(AdminRegister adminRegister) throws ClassNotFoundException, SQLException {
		boolean set = false;
		
		DBQueries query = new DBQueries();
		conn=DBManager.getDBConnection();
		if(conn!=null) {
			System.out.println("connection created in admin create statement........");
			}
		
		String sql=query.getAdminInsert();
		pst=conn.prepareStatement(sql);
		pst.setString(1, adminRegister.getAdmin_uname());
		pst.setString(2, adminRegister.getAdmin_pass());
		pst.setString(3, adminRegister.getFirst_name());
		pst.setString(4, adminRegister.getLast_name());
		pst.setString(5, adminRegister.getAddress());
		pst.setString(6, adminRegister.getPhone_no());
		pst.setString(7, adminRegister.getAns1());
		pst.setString(8, adminRegister.getAns2());
		pst.setString(9, adminRegister.getCus_question());
		pst.setString(10, adminRegister.getCus_answer());		
		
		int a = pst.executeUpdate();
		
		if(a!=0) {
			set=true;
			}
			
		conn.commit();
		pst.close();
		conn.close();
		DBManager.dbDisconnect();
		return set;
	}
	
	public String getAdminPassword(String uname) throws ClassNotFoundException, SQLException {
		String password;
		DBQueries query = new DBQueries();
		conn=DBManager.getDBConnection();
		if(conn!=null) {
			System.out.println("connection created in admin getpassword statement........");
			}
		
		String sql = query.getGetPassword();
		pst=conn.prepareStatement(sql);
		pst.setString(1, uname);
		rs=pst.executeQuery();
		rs.next();
		password = rs.getString(1);
		return password;
	}
	
}
