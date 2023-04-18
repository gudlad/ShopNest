<%@page import="com.shopNestApp.cart.Cart"%>
<%@page import="com.shopNestApp.cart.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>ShopNest Cart</title>
		<link rel="stylesheet" href="home.css">
	</head>
	<body>
		
		<%	Cart c=(Cart)session.getAttribute("cart"); 
			List<Product> itemsList=c.getItems();
			System.out.print(itemsList);
		%>
		
		<header>
			<h1>ShopNest Cart</h1>
			<nav>
			  <ul>
			    <li>
			    	 
			    </li>
			  </ul>
			</nav>

		</header>
		<main>
		
			<%
				for(int i=0; i<itemsList.size(); i++) {
					String p=itemsList.get(i).getPname();
			%>
			<section class="product">
				<h2><%= p %></h2>
				<p><%= ((Product)(itemsList.get(i))).getPprice() %></p>
				<span class="price">Test</span>
			</section>
			<%
				  }                              
			%>
			
		</main>
		<br>
		<table>
				<tfoot>
		            <tr>
		                <td colspan="3">Total:</td>
		           
		                <td><h1><%= c.getTotal() %></h1></td>
		            </tr>
		        </tfoot>
		</table>
	</body>
</html>