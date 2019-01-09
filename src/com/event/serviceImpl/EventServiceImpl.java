package com.event.serviceImpl;

import java.sql.SQLException;
import java.util.List;

import com.event.dao.EventDAO;
import com.event.daoImpl.EventDAOImpl;
import com.event.model.Event;
import com.event.service.EventService;

public class EventServiceImpl implements EventService {
	EventDAO eventDAO=new EventDAOImpl();

	@Override
	public int save(Event event) throws SQLException{

		return eventDAO.save(event);
	}

	@Override
	public int update(Event event) throws SQLException{

		return eventDAO.update(event);
	}

	@Override
	public int delete(int id) throws SQLException{

		return eventDAO.delete(id);
	}

	@Override
	public int getEventId(int id) throws SQLException{

		return eventDAO.getEventId(id);
	}

	@Override
	public Event get(int id) throws SQLException{
		return eventDAO.get(id);
	}
	
	@Override
	public String getEventName(int id) throws SQLException{

		return eventDAO.getEventName(id);
	}

	@Override
	public String getEventCategory(int id) throws SQLException{
		return eventDAO.getEventCategory(id);
	}

	@Override
	public String proposedDate(int id) throws SQLException{

		return eventDAO.proposedDate(id);
	}

	@Override
	public String proposedTime(int id) throws SQLException{

		return eventDAO.proposedTime(id);
	}

	@Override
	public String getEventDate(int id) throws SQLException{

		return eventDAO.getEventDate(id);
	}

	@Override
	public String getEventTime(int id) throws SQLException{

		return eventDAO.getEventTime(id);
	}

	@Override
	public String getEventNotice(int id) throws SQLException{

		return eventDAO.getEventNotice(id);
	}

	@Override
	public String getEventAddress(int id) throws SQLException{

		return eventDAO.getEventAddress(id);
	}

	@Override
	public List<Event> getUserByid(int id) throws SQLException {

		return eventDAO.getUserByid(id);
	}

	@Override
	public List<Event> list() throws SQLException {

		return eventDAO.list();
	}

	@Override
	public List<Event> recommendedList() throws SQLException {

		return eventDAO.recommendedList();
	}

	@Override
	public List<Event> highestrating() throws SQLException {

		return eventDAO.highestrating();
	}

	@Override
	public List<Event> search(String eventCategory) throws SQLException {
		return eventDAO.search(eventCategory);
	}

	@Override
	public List<Event> LatestEvent() throws SQLException {
		return eventDAO.LatestEvent();
	}

}
