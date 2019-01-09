package com.event.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.event.model.Admin;
import com.event.service.AdminService;
import com.event.serviceImpl.AdminServiceImpl;

/**
 * Servlet implementation class LoginControllerAdmin
 */
@WebServlet("/loginAdmin")
public class LoginControllerAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginControllerAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admin admin=new Admin();
		admin.setEmailAddress(request.getParameter("emailAddress"));
		admin.setPassword(request.getParameter("password"));
		AdminService adminService=new AdminServiceImpl();
		int ida=adminService.checkAuthenticate(admin);
		if(ida>0) {
			HttpSession session=request.getSession();
			session.setAttribute("id", ida);
			session.setAttribute("emailAddress", admin.getEmailAddress());
			response.sendRedirect("AdminHome.jsp");
			
		}else {
			
			
	response.sendRedirect("default.jsp?err=4");
		}
	}

}
