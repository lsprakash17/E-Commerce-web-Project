<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@page import="com.prjct.emarket.dto.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/merchant/product-update" method="post">
Id:<input type="text" name="id" value="${product.getId()}" readonly="readonly"><br>
Name:<input type="text" name="name" value="${product.getName()}"><br>
Price:<input type="text" name="price" value="${product.getPrice()}"><br>
Stock:<input type="text" name="quantity" value="${product.getStock()}"><br>
Description:<textarea rows="5" name="description" cols="30">${product.getDescription()}</textarea><br>
<button>Update</button><button type="reset">Reset</button>
<br>
</form>
<a href="/merchant/product-view"><button>Back</button> </a>
</body>
</body>
</html>