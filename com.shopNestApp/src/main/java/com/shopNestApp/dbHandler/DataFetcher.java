package com.shopNestApp.dbHandler;
import java.sql.*;

public class DataFetcher{
	
	public static String fetchPassword(String uname)
	{
	System.out.println(uname);
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user="system";
	String password="pwd";
	String sql="SELECT PASS FROM CUSTOMERS WHERE UNAME = ?"; 
	String dbPass="";
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection(url,user,password);
		System.out.println("db connection succesful");
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, uname);
		ResultSet rs=ps.executeQuery();
		rs.next(); // returns boolean value
		dbPass=rs.getString(1);
		con.close();
	}
	catch (Exception ex) {
		
		System.err.print("Login Issues");
		ex.printStackTrace();
		
	}
	System.out.println(dbPass);
	return dbPass;
}

	
}