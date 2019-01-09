package com.event.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.event.dao.EventDAO;
import com.event.dbutils.MySqlConnector;
import com.event.model.DataSource;
import com.event.model.Event;
import com.event.model.SlopeOneMatrix;
import com.event.model.SlopeOneRecommender;

public class EventDAOImpl implements EventDAO{
	@Override
	public int save(Event event) throws SQLException {
		int result =0;
		PreparedStatement ps = null;
		Connection conn = MySqlConnector.connectToDB();
		String sql="INSERT INTO tbl_event(adminId,eventName,eventCategory,proposedDate,proposedTime,eventDate,eventTime,eventAddress,eventNotice,status) VALUES(?,?,?,?,?,?,?,?,?,?)";
		try{
			ps= conn.prepareStatement(sql);
			ps.setInt(1, event.getAdminId());
			ps.setString(2, event.getEventName());
			ps.setString(3, event.getEventCategory());
			ps.setString(4, event.getProposedDate());
			ps.setString(5, event.getProposedTime());
			ps.setString(6, (event.getEventdate()));
			ps.setString(7, event.getEventTime());
			ps.setString(8,event.getEventAddress());
			ps.setString(9, event.getEventNotice());
			ps.setInt(10, event.getStatus());

			result = ps.executeUpdate();
			System.out.println("Event Save Successfully");
		}catch(Exception e){
			System.out.println("NEW Event : "+e);
		} finally {
			conn.close();
		}
		ps.close();
		return result;
	}

	@Override
	public Event get(int id) throws SQLException{
		Event event = new Event();
		Statement stmt = null;
		ResultSet rs = null;
		Connection conn = MySqlConnector.connectToDB();
		String sql="SELECT * FROM tbl_event WHERE id="+id;
		try{
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				event.setId(rs.getInt("id"));
				event.setAdminId(rs.getInt("adminId"));
				event.setEventName(rs.getString("eventName"));
				event.setEventCategory(rs.getString("eventCategory"));
				event.setProposedDate(rs.getString("proposedDate"));
				event.setProposedTime(rs.getString("proposedTime"));
				event.setEventdate(rs.getString("eventDate"));
				event.setEventTime(rs.getString("eventTime"));
				event.setEventAddress(rs.getString("eventAddress"));
				event.setEventNotice(rs.getString("eventNotice"));
				event.setStatus(rs.getInt("status"));
			}
		}catch(Exception e){
			System.out.println("Event READING BY Admin ID: "+e);
		} finally {
			conn.close();
		}
		rs.close();
		stmt.close();
		return event;
	}

	@Override
	public int update(Event event) throws SQLException {
		int result =0;
		PreparedStatement ps = null;
		Connection conn = MySqlConnector.connectToDB();
		String sql="UPDATE tbl_event SET eventName=?,status=? WHERE id=?";
		try{
			ps = conn.prepareStatement(sql);
			ps.setString(1, event.getEventName());		
			ps.setInt(2, event.getStatus());
			ps.setInt(3, event.getId());
			result = ps.executeUpdate();

		}catch(Exception e){
			System.out.println("NEW BLOG POST : "+e);
		}finally {
			conn.close();
		}
		ps.close();
		return result;
	}

	@Override
	public int delete(int id) throws SQLException{
		int result =0;
		PreparedStatement ps = null;
		Connection conn = MySqlConnector.connectToDB();
		String sql="DELETE FROM tbl_event WHERE id=?";
		try{
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			result = ps.executeUpdate();

		}catch(Exception e){
			System.out.println("Delete Event : "+e);
		} finally {
			conn.close();
		}
		ps.close();
		return result;
	}



	@Override
	public String getEventName(int id) throws SQLException{
		String eventName="";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn=MySqlConnector.connectToDB();
		String sql="SELECT eventName FROM tbl_event WHERE id=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()) {
				eventName=rs.getString("eventName");
			}
		} catch (Exception e) {
			System.out.println("ERROR: getting eventname"+e);
		} 
		rs.close();
		ps.close();
		return eventName;
	}

	@Override
	public String getEventCategory(int id) throws SQLException{
		String eventCategory="";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn=MySqlConnector.connectToDB();
		String sql="SELECT eventCategory FROM tbl_event WHERE id=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()) {
				eventCategory=rs.getString("eventCategory");

			}
		} catch (Exception e) {
			System.out.println("ERROR: getting eventCategory"+e);
		} finally {
			conn.close();
		}
		rs.close();
		ps.close();
		return eventCategory;
	}

	@Override
	public String proposedDate(int id) throws SQLException {
		String proposedDate="";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn=MySqlConnector.connectToDB();
		String sql="SELECT proposedDate FROM tbl_event WHERE id=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()) {
				proposedDate=rs.getString("proposedDate");

			}
		} catch (Exception e) {
			System.out.println("ERROR: getting username"+e);
		} finally {
			conn.close();
		}
		rs.close();
		ps.close();
		return proposedDate;
	}

	@Override
	public String proposedTime(int id) throws SQLException{
		String proposedTime="";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn=MySqlConnector.connectToDB();
		String sql="SELECT proposedTime FROM tbl_event WHERE id=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()) {
				proposedTime=rs.getString("proposedTime");

			}
		} catch (Exception e) {
			System.out.println("ERROR: getting proposedtime"+e);
		} finally {
			conn.close();
		}
		rs.close();
		ps.close();
		return proposedTime;
	}

	@Override
	public String getEventDate(int id) throws SQLException{
		String eventDate="";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn=MySqlConnector.connectToDB();
		String sql="SELECT eventDate FROM tbl_event WHERE id=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()) {
				eventDate=rs.getString("eventDate");
			}
		} catch (Exception e) {
			System.out.println("ERROR: getting eventDate"+e);
		} finally {
			conn.close();
		}
		rs.close();
		ps.close();
		return eventDate;
	}

	@Override
	public String getEventTime(int id) throws SQLException{
		String eventTime="";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn=MySqlConnector.connectToDB();
		String sql="SELECT eventTime FROM tbl_event WHERE id=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()) {
				eventTime=rs.getString("eventTime");

			}
		} catch (Exception e) {
			System.out.println("ERROR: getting eventTime"+e);
		} finally {
			conn.close();
		}
		rs.close();
		ps.close();
		return eventTime;
	}

	@Override
	public String getEventNotice(int id) throws SQLException{
		String eventNotice="";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn=MySqlConnector.connectToDB();
		String sql="SELECT eventNotice FROM tbl_event WHERE id=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()) {
				eventNotice=rs.getString("eventNotice");
			}
		} catch (Exception e) {
			System.out.println("ERROR: getting username"+e);
		} finally {
			conn.close();
		}
		rs.close();
		ps.close();
		return eventNotice;
	}

	@Override
	public String getEventAddress(int id) throws SQLException{
		String eventAddress="";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn=MySqlConnector.connectToDB();
		String sql="SELECT eventAddress FROM tbl_user WHERE id=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()) {
				eventAddress=rs.getString("eventAddress");
			}
		} catch (Exception e) {
			System.out.println("ERROR: getting eventAddress"+e);
		}finally {
			conn.close();
		}
		rs.close();
		ps.close();
		return eventAddress;
	}

	@Override
	public int getEventId(int id) throws SQLException{
		int eventId=0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn=MySqlConnector.connectToDB();
		String sql="SELECT id FROM tbl_event WHERE id=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()) {
				eventId=rs.getInt("id");

			}
		} catch (Exception e) {
			System.out.println("ERROR: getting eventAddress"+e);
		}finally {
			conn.close();
		}
		rs.close();
		ps.close();
		return eventId;
	}

	@Override
	public List<Event> list() throws SQLException  {
		Statement stmt = null;
		ResultSet rs= null;
		List<Event> allEvent = new ArrayList<>();
		Connection conn = MySqlConnector.connectToDB();
		String sql="SELECT * FROM tbl_event ORDER BY id DESC";
		try{
			stmt= conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Event event = new Event();
				event.setId(rs.getInt("id"));
				event.setAdminId(rs.getInt("adminId"));
				event.setEventName(rs.getString("eventName"));
				event.setEventCategory(rs.getString("eventCategory"));
				event.setProposedDate(rs.getString("proposedDate"));
				event.setProposedTime(rs.getString("proposedTime"));
				event.setEventdate(rs.getString("eventDate"));
				event.setEventTime(rs.getString("eventTime"));
				event.setEventAddress(rs.getString("eventAddress"));
				event.setEventNotice(rs.getString("eventNotice"));
				event.setStatus(rs.getInt("status"));
				allEvent.add(event);
			}
		}catch(Exception e){
			System.out.println("Event Selection: "+e);
		}finally{
			conn.close();
			System.out.println("Connection Closed");
		}
		rs.close();
		stmt.close();
		return allEvent;
	}
	
	@Override
	public List<Event> LatestEvent() throws SQLException  {
		Statement stmt = null;
		ResultSet rs= null;
		List<Event> latestEvent = new ArrayList<>();
		Connection conn = MySqlConnector.connectToDB();
		String sql="SELECT * FROM tbl_event ORDER BY id DESC LIMIT 5";
		try{
			stmt= conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Event event = new Event();
				event.setId(rs.getInt("id"));
				event.setAdminId(rs.getInt("adminId"));
				event.setEventName(rs.getString("eventName"));
				event.setEventCategory(rs.getString("eventCategory"));
				event.setProposedDate(rs.getString("proposedDate"));
				event.setProposedTime(rs.getString("proposedTime"));
				event.setEventdate(rs.getString("eventDate"));
				event.setEventTime(rs.getString("eventTime"));
				event.setEventAddress(rs.getString("eventAddress"));
				event.setEventNotice(rs.getString("eventNotice"));
				event.setStatus(rs.getInt("status"));
				latestEvent.add(event);
			}
		}catch(Exception e){
			System.out.println("Event Selection: "+e);
		}finally{
			conn.close();
			System.out.println("Connection Closed");
		}
		rs.close();
		stmt.close();
		return latestEvent;
	}


	@Override
	public List<Event> search(String eventCategory) throws SQLException {
		PreparedStatement ps =null;
		ResultSet rs = null;
		List<Event> allsearch = new ArrayList<>();
		Connection conn = MySqlConnector.connectToDB();
		String sql="SELECT * FROM tbl_event WHERE eventCategory=?";
		try{
			ps=conn.prepareStatement(sql);
			ps.setString(1,eventCategory);
			rs=ps.executeQuery();
			while(rs.next()){
				Event event = new Event();
				event.setId(rs.getInt("id"));
				event.setAdminId(rs.getInt("adminId"));
				event.setEventName(rs.getString("eventName"));
				event.setEventCategory(rs.getString("eventCategory"));
				event.setProposedDate(rs.getString("proposedDate"));
				event.setProposedTime(rs.getString("proposedTime"));
				event.setEventdate(rs.getString("eventDate"));
				event.setEventTime(rs.getString("eventTime"));
				event.setEventAddress(rs.getString("eventAddress"));
				event.setEventNotice(rs.getString("eventNotice"));
				event.setStatus(rs.getInt("status"));
				allsearch.add(event);
			}
		}catch(Exception e){
			System.out.println("Event Searching: "+e);
		}finally {
			conn.close();
			System.out.println("Connection Closed");
		}
		rs.close();
		ps.close();
		return allsearch;
	}

	@Override
	public List<Event> recommendedList() throws SQLException{
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Event> recommendedList = new ArrayList<>();
		Connection connection=MySqlConnector.connectToDB();
		try{
			DataSource dataSRC = new DataSource();
			SlopeOneMatrix avgDiff = new SlopeOneMatrix(dataSRC,true) ;	
			SlopeOneRecommender slopeOne = new SlopeOneRecommender(dataSRC,true,avgDiff);
			double prediction=0.0 ;
			double rating=0.0;
			ArrayList<Double> ratings = new ArrayList <Double>() ;		
			for(int userId:dataSRC.getUser()){		
				for(int i=1;i<=3;i++){		
					prediction=slopeOne.recommendOne(userId,i);				
					rating=dataSRC.getRating(userId,i);	
					if(!Double.isNaN(rating)&&!Double.isNaN(prediction)){
						ratings.add(rating);
						if(prediction>=4) {
							String sql="SELECT tbl_event.id,tbl_event.adminId, tbl_event.eventName, tbl_event.proposedDate, tbl_event.proposedTime, tbl_event.eventDate, tbl_event.eventTime, tbl_event.eventAddress, tbl_event.eventNotice FROM tbl_event JOIN tbl_rate ON tbl_rate.eventId=tbl_event.id WHERE tbl_rate.rate="+rating;
							ps=connection.prepareStatement(sql);
							System.out.println("SQL"+ps);
							rs=ps.executeQuery();
							while(rs.next()){
								Event event = new Event();
								event.setId(rs.getInt("id"));
								event.setAdminId(rs.getInt("adminId"));
								event.setEventName(rs.getString("eventName"));
								event.setProposedDate(rs.getString("proposedDate"));
								event.setProposedTime(rs.getString("proposedTime"));
								event.setEventdate(rs.getString("eventDate"));
								event.setEventTime(rs.getString("eventTime"));
								event.setEventAddress(rs.getString("eventAddress"));
								event.setEventNotice(rs.getString("eventNotice"));
								recommendedList.add(event);
							}
						}
					}
				}
			}
		}catch(Exception e){
			System.out.println("Recommended Event Selection: "+e);
		}

		return recommendedList;
	}

	@Override
	public List<Event> highestrating() throws SQLException  {
		PreparedStatement ps= null;
		ResultSet rs = null;
		List<Event> highrateevent = new ArrayList<>();
		Connection conn = MySqlConnector.connectToDB();
		String sql="SELECT tbl_event.id, tbl_event.adminId, tbl_event.eventName, tbl_event.proposedDate, tbl_event.proposedTime, tbl_event.eventDate, tbl_event.eventTime, tbl_event.eventAddress, tbl_event.eventNotice FROM tbl_event JOIN tbl_avg_rate ON tbl_avg_rate.eventId=tbl_event.id ORDER BY tbl_avg_rate.avg_rate DESC LIMIT 5";
		try{
			ps= conn.prepareStatement(sql);
			rs =ps.executeQuery(sql);
			while(rs.next()){
				Event event = new Event();
				event.setId(rs.getInt("id"));
				event.setAdminId(rs.getInt("adminId"));
				event.setEventName(rs.getString("eventName"));
				event.setProposedDate(rs.getString("proposedDate"));
				event.setProposedTime(rs.getString("proposedTime"));
				event.setEventdate(rs.getString("eventDate"));
				event.setEventTime(rs.getString("eventTime"));
				event.setEventAddress(rs.getString("eventAddress"));
				event.setEventNotice(rs.getString("eventNotice"));
				highrateevent.add(event);
			}
		}catch(Exception e){
			System.out.println("Highest Rated Event Selection: "+e);
		}finally {

		}
		rs.close();
		ps.close();
		return highrateevent;
	}

	@Override
	public List<Event> getUserByid(int id) throws SQLException{
		Statement stmt = null;
		ResultSet rs = null;
		List<Event> allEventPostByadminId = new ArrayList<>();
		Connection conn = MySqlConnector.connectToDB();
		String sql="SELECT * FROM tbl_event WHERE adminId="+id;
		try{
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Event event = new Event();
				event.setId(rs.getInt("id"));
				event.setAdminId(rs.getInt("adminId"));
				event.setEventName(rs.getString("eventName"));
				event.setEventCategory(rs.getString("eventCategory"));
				event.setEventdate(rs.getString("eventDate"));
				event.setEventTime(rs.getString("eventTime"));
				event.setEventAddress(rs.getString("eventAddress"));
				event.setEventNotice(rs.getString("eventNotice"));
				event.setStatus(rs.getInt("status"));
				allEventPostByadminId.add(event);
			}
		}catch(Exception e){
			System.out.println("Event READING BY USER ID: "+e);
		}finally {
			conn.close();
			System.out.println("Connection Closed");
		}
		rs.close();
		stmt.close();
		return allEventPostByadminId;
	}

}




