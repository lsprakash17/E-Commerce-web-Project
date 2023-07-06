<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
<%@include file="../jspf/Header.jspf" %>
<div class="container">
<a href="/admin/login" >Admin Login</a>
<a href="/merchant/login" >Merchant Login</a>
<a href="/customer/login" >Customer Login</a>
</div>
<%@include file="../jspf/Footer.jspf" %>
</body>
</html>