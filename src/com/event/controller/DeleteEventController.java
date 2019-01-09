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

@WebServlet("/DeleteEvent")
public class DeleteEventController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteEventController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("txtId"));
		EventService eventService = new EventServiceImpl();
		try {
			if(eventService.delete(id)>0) {
				response.sendRedirect("ViewEvent.jsp");
			}else {
				response.sendRedirect("DeleteEvent.jsp?id="+id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
