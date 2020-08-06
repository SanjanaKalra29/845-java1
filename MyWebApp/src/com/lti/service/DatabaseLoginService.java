package com.lti.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * before we run DB version, we need to ensure that Driver jar file is ready
 * after locating the same (derbyclient.jar)
 * Copy the same in projects WebContent/WEB-INF/lib folder
 * then only run the application
 */
public class DatabaseLoginService {
	
	public boolean authenticate(String uname, String pwd) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");

			conn = DriverManager.getConnection("jdbc:derby://localhost:1527/trainingdb", "mj", "mj");
			
			System.out.println("Connection successful");
			// can you tell me the select query look like??
			String sql = "SELECT COUNT(user_id) FROM tbl_users WHERE user_name = ? AND user_pass = ? ";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, uname);  //1 means first ?
			stmt.setString(2, pwd);  // 2 means second ?
			rs = stmt.executeQuery();   //result set is like cursor
			if(rs.next()) {
				int count = rs.getInt(1);
				if(count == 1) //valid user
					return true;
			}
			return false; //something wrong person not authenticated
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace(); //
			return false;
		}
		finally {
			try { conn.close(); }  catch(Exception e) {}
		}
	}
}
