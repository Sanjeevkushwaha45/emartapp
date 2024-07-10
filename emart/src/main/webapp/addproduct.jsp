<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="addproduct.css" rel="stylesheet">
</head>
<body>
    <div class="main">
      <h1>Add Products</h1>
     <form action="productadd" method="post">
         <input type="text" name="id" placeholder="Enter product id">
         <input type="text" name="name" placeholder="Enter product name">
         <input type="text" name="price" placeholder="Enter product price">
         <input type="text" name="brand" placeholder="Enter product brand">
         <input type="text" name="description" placeholder="Enter product description">
         <button type="submit">Add Product</button>
     </form>
    </div>
</body>
</html>