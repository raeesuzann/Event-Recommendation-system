package com.event.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.event.model.Event;
import com.event.service.EventService;
import com.event.serviceImpl.EventServiceImpl;



/**
 * Servlet implementation class EventController
 */
@WebServlet("/addEvent")
public class EventController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EventController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("CreateEvent.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date dd=new Date();

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		String date=simpleDateFormat.format(dd);
		String time=timeFormat.format(dd);
		Event event = new Event();


		HttpSession session = request.getSession();
		String id =session.getAttribute("id").toString();
		String proposedDate=request.getParameter("eventDate").toString();
		String proposedTime=request.getParameter("eventTime").toString();
		
		event.setAdminId(Integer.parseInt(id));
		event.setEventName(request.getParameter("eventName"));
		event.setEventCategory(request.getParameter("eventCategory"));
		event.setEventAddress(request.getParameter("eventAddress"));
		event.setProposedDate(proposedDate);;
		event.setProposedTime(proposedTime);
		event.setEventNotice(request.getParameter("eventNotice"));
		event.setEventdate(date);

		event.setEventTime(time);
		event.setStatus(1);
		EventService  service = new EventServiceImpl();
		try {
			if(service.save(event)>0){
				response.sendRedirect("AdminHome.jsp");
			}else{
				response.sendRedirect("CreateEvent.jsp?err=1");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



}
