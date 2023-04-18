package com.shopNestApp.customer;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.shopNestApp.dbHandler.DataInjector;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException
	{
		String uname=req.getParameter("uname");
		String mail=req.getParameter("mail");
		String pass=req.getParameter("password");
		String gender=req.getParameter("gender");
		String address=req.getParameter("address");
		
		
			String status=DataInjector.addCustomer(uname, mail, pass, gender, address);
			System.out.println("\nRegistration "+status);
//			resp.getWriter().print(status);
			resp.sendRedirect("login.jsp");
	}
	
}