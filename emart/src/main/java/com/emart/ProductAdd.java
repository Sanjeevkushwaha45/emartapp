package com.emart;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = "/productadd")
public class ProductAdd extends HttpServlet{
   @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	String name=req.getParameter("name");
	double price=Double.parseDouble(req.getParameter("price"));
	String brand=req.getParameter("brand");
	String desc=req.getParameter("description");
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3303/emart","root","root");
		PreparedStatement ps=con.prepareStatement("insert into product values(?,?,?,?,?)");
		ps.setInt(1, id);
		ps.setString(2,name);
		ps.setDouble(3, price);
		ps.setString(4, brand);
		ps.setString(5, desc);
		int i=ps.executeUpdate();
		if(i>0) {
		ps=con.prepareStatement("select * from product");
		req.setAttribute("rs", ps.executeQuery());
		req.getRequestDispatcher("viewproduct.jsp").forward(req, resp);
		}
		else {
			req.getRequestDispatcher("addproduct.jsp").include(req, resp);
		}
	} catch (SQLException | ClassNotFoundException e) {
		e.printStackTrace();
	}
}
}
