<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update page</title>
<link href="addproduct.css" rel="stylesheet">
</head>
<body>
    <% ResultSet rs=(ResultSet) request.getAttribute("rs"); 
     if(rs.next()){
    %>
    
    
    <div class="main">
      <h1>Update Products</h1>
     <form action="update2" method="post">
         <input type="text" name="id" readonly="readonly" value="<%=rs.getInt(1) %>" placeholder="Enter product id">
         <input type="text" name="name" value="<%= rs.getString(2) %>" placeholder="Enter product name">
         <input type="text" name="price" value="<%= rs.getDouble(3) %>" placeholder="Enter product price">
         <input type="text" name="brand" value="<%= rs.getString(4) %>" placeholder="Enter product brand">
         <input type="text" name="description" value="<%= rs.getString(5) %>" placeholder="Enter product description">
         <button type="submit">Update Product</button>
     </form>
    </div>
     <%} %>
</body>
</html>