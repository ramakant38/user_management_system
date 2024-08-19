package com.org.controller;

import java.io.IOException;
import java.net.ResponseCache;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.UserDao;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet{
     
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id1 = Integer.parseInt(req.getParameter("id"));
		
		UserDao dao = new UserDao();
		dao.deleteById(id1);
		
		HttpSession session = req.getSession();
		session.setAttribute("deleted", "Deleted Successfully");
		
		resp.sendRedirect("home.jsp");
	}
}
