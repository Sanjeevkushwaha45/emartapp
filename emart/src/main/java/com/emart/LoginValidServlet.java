package com.emart;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(urlPatterns = "/loginvalid")
public class LoginValidServlet extends HttpServlet{    
	@Override   
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String email=req.getParameter("email");
	String pswd=req.getParameter("pswd");
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3303/emart","root","root");
		PreparedStatement ps=con.prepareStatement("select * from user where email=? and password=?");
		ps.setString(1,email);
		ps.setString(2,pswd);
		ResultSet rs=ps.executeQuery();
		
		
		if(rs.next()) {
			
			if(rs.getString(5).equalsIgnoreCase("Admin")) {
				 resp.getWriter().write("<html><body><h2 id='msz'>Login Successfull</h2></body></html>");
				 ps=con.prepareStatement("select * from product");
			req.getRequestDispatcher("HomePage.jsp").include(req, resp);
			}
			else if(rs.getString(5).equalsIgnoreCase("user")) {
				 ps=con.prepareStatement("select * from product");
				  req.setAttribute("rs",ps.executeQuery());
				  resp.getWriter().write("<html><body><h2 id='msz'>Login Successfull</h2></body></html>");
					 
				req.getRequestDispatcher("userhome.jsp").include(req, resp);
				}
			else {
				PrintWriter pw=resp.getWriter();
				pw.write("you not match credential");
				req.getRequestDispatcher("LoginForm.jsp").include(req, resp);
			}
		}
		else {
			PrintWriter pr=resp.getWriter();
			pr.write("<h1>Something went Wrong...!</h1>");
			req.getRequestDispatcher("LoginForm.jsp").include(req, resp);
		}
		
		
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	
}
}
