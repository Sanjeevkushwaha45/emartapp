<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="loginform.css" rel="stylesheet">
</head>
<body>
     <div class="main">
      <h1>Login Page</h1>
     
     <form action="loginvalid" method="post">
           <input type="text" name="email" placeholder="Enter User Emai">
           <input type="text" name="pswd" placeholder="Enter password">
           <button type="submit">Login</button>
     </form>
     </div>
</body>
</html>