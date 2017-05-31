package wdsr.exercise5;

import java.sql.*;

public class Connect {

	String url = "jdbc:hsqldb:hsql://127.0.0.1:9001/test-db";
	String login = "SA";
	String password = "";
	Connection conn = null;
	
	public Connect() {
		
		try {
			conn = DriverManager.getConnection(url,login,password);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection(){
		return conn;
	}
	
}
