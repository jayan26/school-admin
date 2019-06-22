package com.n2s.miniproject.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.n2s.miniproject.URL;

public class DBManager {

	private static Connection con=null;
	
	public static Connection getDBConnection() throws SQLException, ClassNotFoundException {
		URL u = new URL();
		Class.forName("oracle.jdbc.OracleDriver");
		String DBurl=u.getUrl();
		con=DriverManager.getConnection(DBurl,"system" , "password");
		return con;
	}
	
	public static void dbDisconnect() throws SQLException {
		con.close();
	}
	
}
