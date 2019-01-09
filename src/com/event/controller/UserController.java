package com.event.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.event.model.User;
import com.event.service.UserService;
import com.event.serviceImpl.UserServiceImpl;


@WebServlet("/inputUser")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public UserController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.sendRedirect("Signup.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user=new User();
		user.setFirstName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));
		user.setAddress(request.getParameter("address"));
		user.setDob(request.getParameter("dob").toString());
		user.setSex(request.getParameter("sex"));
		user.setRollNo(Integer.parseInt(request.getParameter("rollNo")));
		user.setFaculty(request.getParameter("faculty"));
		user.setSemester(request.getParameter("semester"));		
		user.setEmailAddress(request.getParameter("emailAddress"));
		user.setPassword(request.getParameter("password"));
		user.setConfirmPassword(request.getParameter("confirmPassword"));
		user.setStatus(1);
		UserService userService=new UserServiceImpl();
		try {
			if(userService.register(user)>0) {
				response.sendRedirect("default.jsp");
			}else {
				response.sendRedirect("UserRegistration.jsp?err01");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
