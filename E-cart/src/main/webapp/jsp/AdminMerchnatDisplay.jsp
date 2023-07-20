<!DOCTYPE html>
<%@page import="com.prjct.emarket.dto.Merchant"%>
<%@page import="org.apache.commons.codec.binary.Base64"%>

<%@page import="java.util.List"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="../jspf/Header.jspf" %>
<h1>${pass}</h1>
<%
  List<Merchant> merchants = (List<Merchant>) request.getAttribute("merchants");
%>
<h1>VIEW ALL THE MERCHANT</h1>
<table border="1px" cellpadding="25px">
  <tr>
    <th>Name</th>
     <th>Email</th>
    <th>Image</th>
    <th>Dob</th>
    <th>Gender</th>
    <th>address</th>  
  </tr>
  <% for (Merchant merchant: merchants) { %>
    <tr>
      <td><%=merchant.getName()%></td>
      <td><%=merchant.getEmail()%></td>
       <td>
        <% String base64 = Base64.encodeBase64String(merchant.getPicture()); %>
        <img src="data:image/jpeg;base64,<%= base64 %>" alt="Picture" style="width: 100px; height: auto;">
      </td>
      <td><%=merchant.getDob()%></td>
      <td><%=merchant.getGender()%></td>
      <td><%=merchant.getAddress()%></td>
    </tr>
  <% } %>
</table>

<a href="/jsp/AdminHome.jsp" class="button">
  <button>Back</button>
</a>
</body>
</html>