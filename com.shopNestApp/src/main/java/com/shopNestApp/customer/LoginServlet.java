package com.shopNestApp.customer;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException
	{
		String uname=req.getParameter("uname");
		String pass=req.getParameter("password");
		System.out.println(uname+"\t"+pass);
		boolean valid=Validator.isValid(uname, pass);
		
		System.out.println(valid);
		if(valid==true && uname.equals("admin"))
		{
			resp.sendRedirect("admin.jsp");
		}
		else
		{
			resp.sendRedirect("home.jsp");
			
		}
	}
	
	
}


