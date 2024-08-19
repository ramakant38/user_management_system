package com.org.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.UserDao;
import com.org.dto.User;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet{
    
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		long mobile1 = Long.parseLong(req.getParameter("mobile"));
		String email = req.getParameter("email");
		
		User user = new User();
		user.setName(name);
		user.setAge(age);
		user.setMobile(mobile1);
		user.setEmail(email);
		
		UserDao dao = new UserDao();
		dao.updateUserById(id, user);
		
		HttpSession session = req.getSession();
		session.setAttribute("success", "Updated Successfully");
		
		resp.sendRedirect("home.jsp");
	}
}
