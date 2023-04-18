package com.shopNestApp.dbHandler;
import java.sql.*;
import java.util.*;
import com.shopNestApp.cart.Product;

public class DataFetcher{
	
	// this method is used by login module
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
	
	// this method used by admin module to display users
	public static List<String> fetchUsersInfo()
	{
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user="system";
	String password="pwd";
	String sql="SELECT UNAME,MAIL,GENDER,ADDRESS FROM CUSTOMERS"; 
	List<String> ulist=new ArrayList<>();
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection(url,user,password);
		System.out.println("db connection succesful"); 
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next())
		{
			String temp=rs.getString(1)+":"+rs.getString(2)+":"+rs.getString(3)+":"+rs.getString(4);
			ulist.add(temp);
		}
		
		con.close();
	}
	catch (Exception ex) {
		
		System.err.print("Failed to fetch users info");
		ex.printStackTrace();
		
	}
	return ulist;
}

	// return products list
	public static List<String> fetchProductsInfo()
	{
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user="system";
	String password="pwd";
	String sql="SELECT PID,PNAME,PDESC,PPRICE,PIMG FROM PRODUCTS"; 
	List<String> plist=new ArrayList<>();
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection(url,user,password);
		System.out.println("db connection succesful"); 
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next())
		{
			String temp=rs.getString(1)+":"+rs.getString(2)+":"+rs.getString(3)+":"+rs.getString(4)+":"+rs.getString(5);
			plist.add(temp);
		}
		con.close();
	}
	catch (Exception ex) {
		
		System.err.print("Failed to fetch users info");
		ex.printStackTrace();
		
	}
	return plist;
}
	
	// return product object
	public static Product getProductById(int pid)
	{
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="system";
		String password="pwd";
		String sql="SELECT PNAME,PPRICE FROM PRODUCTS WHERE PID = ?";
		Product p=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection(url,user,password);
			System.out.println("db connection succesful"); 
			
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, pid);
			ResultSet rs=ps.executeQuery();
			rs.next();
			String pname=rs.getString(1);
			int pprice=rs.getInt(2);
			p=new Product(pid,pname,pprice);
			con.close();
		}
		catch (Exception ex) {
			
			System.err.print("Failed to fetch product info");
			ex.printStackTrace();
			
		}
		return p;
		
	}
	
}