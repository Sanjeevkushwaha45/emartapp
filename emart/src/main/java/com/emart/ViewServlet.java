package com.emart;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = "/viewproduct")
public class ViewServlet extends HttpServlet{
   @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3303/emart","root","root");
		PreparedStatement ps=con.prepareStatement("select * from product");
	ResultSet	rs=ps.executeQuery();
	req.setAttribute("rs", rs);
	req.getRequestDispatcher("viewproduct.jsp").forward(req, resp);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
