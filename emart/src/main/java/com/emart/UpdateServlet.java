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
@WebServlet(urlPatterns = "/update2")
public class UpdateServlet extends HttpServlet{
   @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		double price=Double.parseDouble(req.getParameter("price"));
		String brand=req.getParameter("brand");
		String desc=req.getParameter("description");
		
	 try {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3303/emart","root","root");
		PreparedStatement ps=con.prepareStatement("update product set name=?, price=?, brand=?,description=? where id=?");
		ps.setString(1, name);
		ps.setDouble(2, price);
		ps.setString(3, brand);
		ps.setString(4, desc);
		ps.setInt(5, id);
		int i=ps.executeUpdate();
		if(i>0) {
			ps=con.prepareStatement("select * from product");
			req.setAttribute("rs", ps.executeQuery());
			req.getRequestDispatcher("viewproduct.jsp").forward(req, resp);
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
}
