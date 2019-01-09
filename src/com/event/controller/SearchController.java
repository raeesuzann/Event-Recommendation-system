package com.event.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.event.service.EventService;
import com.event.serviceImpl.EventServiceImpl;

@WebServlet("/searchevent")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String eevent = request.getParameter("eventCategory");
		EventService eventService=new EventServiceImpl();
		try {
			if(eventService.search(eevent)!=null) {
				request.setAttribute("eventCategory",eevent);
				request.getRequestDispatcher("SearchEvent.jsp").forward(request, response); 
			}else {
				response.sendRedirect("UserHome.jsp?error=");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
