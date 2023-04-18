package com.shopNestApp.admin;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import com.shopNestApp.dbHandler.DataInjector;

@WebServlet("/addP")
public class ProductServlet extends HttpServlet 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req,HttpServletResponse resp)
	{
		int pid=Integer.parseInt(req.getParameter("product-id"));
		String pname=req.getParameter("product-name");
		String pdesc=req.getParameter("product-description");
		long pprice=Integer.parseInt(req.getParameter("product-price"));
		String pimg=req.getParameter("product-image");
		
		DataInjector.addProduct(pid,pname,pdesc,pprice,pimg);

	}
}