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
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	int id=Integer.parseInt(req.getParameter("id"));
    	try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3303/emart","root","root");
			PreparedStatement ps=con.prepareStatement("delete from product where id=?");
			ps.setInt(1, id);
			int i=ps.executeUpdate();
			if(i>0) {
				ps=con.prepareStatement("select * from product");
				req.setAttribute("rs", ps.executeQuery());
				req.getRequestDispatcher("viewproduct.jsp").include(req, resp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
