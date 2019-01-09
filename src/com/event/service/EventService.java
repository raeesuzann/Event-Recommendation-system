package com.event.service;

import java.sql.SQLException;
import java.util.List;

import com.event.model.Event;

public interface EventService {
	int save(Event event) throws SQLException;
	int update(Event event) throws SQLException;
	int delete(int id) throws SQLException;
	int getEventId(int id) throws SQLException;
	Event get(int id) throws SQLException;

	String getEventName(int id) throws SQLException;
	String getEventCategory(int id) throws SQLException;
	String proposedDate(int id) throws SQLException;
	String proposedTime(int id) throws SQLException;
	String getEventDate(int id) throws SQLException;
	String getEventTime(int id) throws SQLException;
	String getEventNotice(int id) throws SQLException;
	String getEventAddress(int id) throws SQLException;

	List<Event> list() throws SQLException;
	List<Event> recommendedList() throws SQLException;
	List<Event> highestrating() throws SQLException;
	List<Event> getUserByid(int id) throws SQLException;
	List<Event> search(String eventCategory) throws SQLException;
	List<Event> LatestEvent() throws SQLException;
}
