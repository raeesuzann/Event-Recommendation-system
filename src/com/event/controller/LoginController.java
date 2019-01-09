package com.event.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.event.model.User;
import com.event.service.UserService;
import com.event.serviceImpl.UserServiceImpl;

@WebServlet("/loginUser")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.sendRedirect("Login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user=new User();			
		user.setEmailAddress(request.getParameter("emailAddress"));
		user.setPassword(request.getParameter("password"));
		UserService userService=new UserServiceImpl();
		int id = 0;
		try {
			id = userService.checkAuthenticate(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		if(id>0) {
			HttpSession session=request.getSession();
			session.setAttribute("id", id);
			session.setAttribute("emailAddress", user.getEmailAddress());
			response.sendRedirect("UserHome.jsp");
		}else {
			response.sendRedirect("default.jsp?err=3");
		}
	}

}
