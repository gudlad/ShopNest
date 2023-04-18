<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="com.shopNestApp.cart.*"%>
<%@page import="com.shopNestApp.dbHandler.DataFetcher"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shopping Page</title>
<link rel="stylesheet" href="home.css">
</head>
<body>
		<%
			List<String> prodList=DataFetcher.fetchProductsInfo();
			Cart c=new Cart();
			session.setAttribute("cart", c);
			// Cart c=(Cart)session.getAttribute("cart"); 
		%>	
		
		
		<header>
			<h1>ShopNest</h1>
			<nav>
			  <ul>
			    <li>
			    	 <a href="#" class="view-cart">
				        <i class="fas fa-shopping-cart"></i>
				        <span>
				        	<a href="cart.jsp">
				        	<button class="add-to-cart" >View Cart</button>
				        	</a>
				        </span>
				      </a>
			    </li>
			  </ul>
			</nav>

		</header>
		

		<main>
			<%	String[] prodArr2=null;;
				for(int i=0; i<prodList.size(); i++) {
					String[] prodArr=((String)prodList.get(i)).split(":");  
					prodArr2=prodArr;
			%>
			<section class="product">
				<img src="prodImg/<%=prodArr[4]%>" alt="Product 1" width=400>
				<h2><%= prodArr[1] %></h2>
				<p><%= prodArr[2] %></p>
				<span class="price"><%= prodArr[3] %></span>
				<form method="post" action="add-to-cart">
		        <input type="hidden" name="productId" value="<%= Integer.parseInt(prodArr[0]) %>">
		        <input type="submit" value="Add to Cart">
		        </form>
			</section>
			
			<%
				}                              
			%>
		</main>
		
	</body>
	
</html>
