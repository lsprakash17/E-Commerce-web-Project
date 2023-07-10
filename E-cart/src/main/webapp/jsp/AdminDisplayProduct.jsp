<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@page import="java.util.List"%>
<%@page import="com.prjct.emarket.dto.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View all products</title>
</head>
<body>
<%List<Product> prod=(List<Product>)request.getAttribute("products");  %> 
	<table  style="2px solid black">
		<thead>
			<tr>
			    <th>Image</th>
				<th>ID</th>
				<th>Name</th>
				<th>Description</th>
				<th>Price</th>
				<th>quality</th>
				<th>Details</th>
				<th>Status</th>
				<th>Button</th>
			</tr>
		</thead>
		<tbody>
			<% for(Product product:prod){ %>
				<tr>
				    <td><%String base64 = Base64.encodeBase64String(product.getImage());%>
				     <img src="data:image/jpeg;base64,<%=base64%>" alt="Picture"
				style="width: 100px; height: auto;">
				</td>
					<td><%=product.getId() %></td>
					<td><%=product.getName() %></td>
					<td><%=product.getDescription() %></td>
					<td><%=product.getPrice() %></td>
					<td><%=product.getQuantity() %></td>
					<td><%=product.getDescription() %></td>
                   <td><%=product.isStatus()%></td>
                    <td><button>Change</button> </td>
				</tr>
			<% }%>
		</tbody>
	</table>
</body>
</body>
</html>