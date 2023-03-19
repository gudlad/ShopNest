package com.shopNestApp.dbHandler;
import java.sql.*;

public class DataInjector{
	
	@SuppressWarnings("finally")
	public static String addCustomer(String uname,String mail,String pass,String gender,String address)
	{
		
//		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="system";
		String password="pwd";
		String sql="INSERT INTO CUSTOMERS VALUES(?,?,?,?,?)";
		String registerStatus="";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection(url,user,password);
			System.out.print("db connection succesful");
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, mail);
			ps.setString(3, pass);
			ps.setString(4, gender);
			ps.setString(5, address);
			ps.executeUpdate();
			con.close();
			registerStatus="success";
		}
		catch (Exception ex) {
			
			System.out.println("Problem in adding Customer!!!");
			ex.printStackTrace();
			registerStatus="failure";
		}
		finally {
			return registerStatus;
		}
			
	}
}