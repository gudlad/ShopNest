package com.shopNestApp.cart;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shopNestApp.dbHandler.DataFetcher;

@WebServlet("/add-to-cart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  public void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException 
  {
	  int productId=Integer.parseInt(req.getParameter("productId"));
	  Product product = DataFetcher.getProductById(productId);
	  
	  HttpSession session=req.getSession();
	  Cart cart=(Cart)session.getAttribute("cart");
	  if(cart==null)
	  {
		  cart=new Cart();
		  session.setAttribute("cart", cart);
	  }
	  cart.addItem(product);
	  resp.sendRedirect("cart.jsp");
  }
}