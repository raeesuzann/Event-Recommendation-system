package com.event.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.event.model.Event;
import com.event.service.EventService;
import com.event.serviceImpl.EventServiceImpl;


@WebServlet("/EditEventController")
public class EditEventController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EditEventController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Event event = new Event();
		event.setId(Integer.parseInt(request.getParameter("eventId")));
		event.setEventName(request.getParameter("eventName"));
		event.setStatus(1);
		EventService  blogPostService = new EventServiceImpl();
		try {
			if(blogPostService.update(event)>0){
				response.sendRedirect("ViewEvent.jsp");
			}else{
				response.sendRedirect("edit.jsp?id="+event.getId());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
