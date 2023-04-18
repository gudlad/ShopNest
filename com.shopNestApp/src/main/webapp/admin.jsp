<%@page import="java.util.*"%>
<%@page import="com.shopNestApp.dbHandler.DataFetcher"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Panel</title>
<link rel="stylesheet" href="adminStyle.css">
</head>
<body>

	<%
		List<String> ulist=DataFetcher.fetchUsersInfo(); 
		List<String> plist=DataFetcher.fetchProductsInfo();

	%>
	<div class="panel">
		<div class="button-container">
			<button class="active" data-tab="tab1">View customers</button>
			<button data-tab="tab2">View Products</button>
			<button data-tab="tab3">Add New Product</button>
		</div>
		<div class="content-cotainer">
			<div class="tab active" id="tab1">
				<table border>
					<thead>
						<tr>
							<th>Username</th>
							<th>Email</th>
							<th>Gender</th>
							<th>Address</th>
						</tr>
					</thead>
					<tbody>
					<%
						for(int i=0;i<ulist.size();i++)
						{
						String[] custArr=ulist.get(i).split(":");
					%>
					<tr>
					<td><%= custArr[0] %></td>
					<td><%= custArr[1] %></td>
					<td><%= custArr[2] %></td>
					<td><%= custArr[3] %></td>
					</tr>
					<% 
						}
					%>
					</tbody>
				</table>
			</div>
			
			
			<div class="tab" id="tab2">
				<table border>
					<thead>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Description</th>
							<th>Price</th>
							<th>Image</th>
						</tr>
					</thead>
					<tbody>
					<%
						for(int i=0;i<plist.size();i++)
						{
						String[] productArr=plist.get(i).split(":");
					%>
					<tr>
					<td><%= productArr[0] %></td>
					<td><%= productArr[1] %></td>
					<td><%= productArr[2] %></td>
					<td><%= productArr[3] %></td>
					<td><img src="prodImg/<%= productArr[4] %>" alt="Product 1"  width="350"></td>
					</tr>
					<% 
						}
					%>
					</tbody>
				</table>
			</div>
			
			
				<div class="tab" id="tab3">
			    <form action="addP" method="post">
			        <table>
			            <tr>
			                <td><label for="product-id">Product ID:</label></td>
			                <td><input type="text" id="product-id" name="product-id" required></td>
			            </tr>
			            <tr>
			                <td><label for="product-name">Product Name:</label></td>
			                <td><input type="text" id="product-name" name="product-name" required></td>
			            </tr>
			            <tr>
			                <td><label for="product-description">Product Description:</label></td>
			                <td><input type="text" id="product-description" name="product-description" required></td>
			            </tr>
			            <tr>
			                <td><label for="product-price">Product Price:</label></td>
			                <td><input type="text" id="product-price" name="product-price" required></td>
			            </tr>
			            <tr>
			                <td><label for="product-image">Product Image File:</label></td>
			                <td><input type="text" id="product-image" name="product-image" required></td>
			            </tr>
			        </table>
			        <br><br>
			        <button type="submit">Submit</button>
			    </form>
			</div>

		</div>
	</div>
	
		<script>
		  const buttons = document.querySelectorAll(".button-container button");
		  const contents = document.querySelectorAll(".content-cotainer .tab");
	
		  buttons.forEach((button, idx) => {
		  button.addEventListener("click", () => {
		      // Reset active button and content
		      buttons.forEach((btn) => btn.classList.remove("active"));
		      contents.forEach((content) => content.classList.remove("active"));
		
		      // Set new active button and content
		      button.classList.add("active");
		      contents[idx].classList.add("active");
		    });
		  });
		</script>
	
	
</body>
</html>
