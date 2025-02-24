package com.org.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{
    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("logout");
		HttpSession session = req.getSession();
		
		session.removeAttribute("userId");
		
		Object objct = session.getAttribute("userId");
		
		System.out.println("Object not there"+objct);
		
		session.invalidate();
		
		resp.sendRedirect("login.jsp");
	}
}
