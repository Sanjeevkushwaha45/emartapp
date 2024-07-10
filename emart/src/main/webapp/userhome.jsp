<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="userhome.css" rel="stylesheet">
</head>
<body>
   <h1>Welcome User Page</h1>
   
   
   <% 
   
   ResultSet rs= (ResultSet) request.getAttribute("rs"); %>
  
  
  <table>
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>PRICE</th>
        <th>BRAND</th>
        <th>DESCRIPTION</th>
    </tr>
    
    <%  while(rs.next()){ %>
    
    <tr>
      <td><%=rs.getInt(1) %></td>
      <td><%=rs.getString(2) %></td>
      <td><%=rs.getDouble(3) %></td>
      <td><%=rs.getString(4) %></td>
      <td><%=rs.getString(5) %></td>
      </tr>
      
    <%} %>
  </table>
  
  <a href="insta"> <button>Follow us on Instagram</button> </a>
  
  <script type="text/javascript">
        let msz=document.getElementById("msz");
       setTimeout(()=>{ msz.style.display="none" },2000);
       
  </script>
</body>
</html>