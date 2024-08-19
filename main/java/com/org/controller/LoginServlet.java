package com.org.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.UserDao;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
    
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String pwd = req.getParameter("password");
		
		
		UserDao dao = new UserDao();
		int id= dao.login(email,pwd);
		
		HttpSession session = req.getSession();
		
		if(id > 0) {
		    session.setAttribute("userId", id);
		    resp.sendRedirect("home.jsp");
		}
		else {
			session.setAttribute("fail", "Invalid Credentials");
			resp.sendRedirect("login.jsp");
		}
	} 
}
