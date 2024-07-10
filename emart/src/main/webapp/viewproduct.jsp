
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>view product</title>
<link href="viewproduct.css" rel="stylesheet">
</head>
<body>
  <% ResultSet rs= (ResultSet) request.getAttribute("rs"); %>
  
  <h1 class="add1">ALL PRODUCTS</h1>
  <h2 class="add"><a href="add_product" ><button class="btna">Add Product</button></a></h2>
  <table>
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>PRICE</th>
        <th>BRAND</th>
        <th>DESCRIPTION</th>
        <th colspan="2">ACTION</th>
    </tr>
    <%while(rs.next()){ %>
    <tr>
      <td><%=rs.getInt(1) %></td>
      <td><%=rs.getString(2) %></td>
      <td><%=rs.getDouble(3) %></td>
      <td><%=rs.getString(4) %></td>
      <td><%=rs.getString(5) %></td>
      <td  ><a href="update_page?id=<%=rs.getInt(1)%>"><button class="up">UPDATE</button> </a></td>
      <td  ><a href="delete?id=<%=rs.getInt(1) %>"> <button class="dlt" >DELETE</button></a></td>
      <td></td>
    </tr>
    <%} %>
  </table>
  
  
</body>
</html>