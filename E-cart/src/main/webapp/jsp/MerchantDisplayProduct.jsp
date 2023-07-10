<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@page import="com.prjct.emarket.dto.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${pass}
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
				<th>Delete</th>
				<th>Update</th>
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
					<td><%=product.getQuantity()%></td>
					<td><%=product.getDescription() %></td>
					<td><a href="/merchant/product-delete/<%=product.getId() %>"><button>Delete</button> </a></td>
					<td><a href="/merchant/product-update/<%=product.getId()%>"%><button>Update</button> </a></td>
				</tr>
			<% }%>
		</tbody>
	</table>
<a href="/logout"><button>Logout</button></a> <br> <a href="/merchant/product-view"><button>Back</button> </a>	
</body>
</html>