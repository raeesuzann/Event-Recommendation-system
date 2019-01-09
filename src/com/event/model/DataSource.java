package com.event.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import com.event.dbutils.MySqlConnector;

public class DataSource {

	private int getUserEventRating ;
	int[] events ,user;
	private HashMap<Integer,HashMap<Integer,Integer>> rating;

	public DataSource(){		
		getUserEventRating=-1;
		events = null ;
		rating = null;

	}


	public int[] getEvents() {

		Connection conn=MySqlConnector.connectToDB();
		String sql="Select * from tbl_event";
		if(events==null){
			try {
				PreparedStatement preparedStatement=conn.prepareStatement(sql);

				ResultSet resultSet=preparedStatement.executeQuery();
				events=new int[5];
				int i=0;
				while(resultSet.next()){
					events[i]=resultSet.getInt(1);
					i++;
				}
				
				resultSet.close();


			}catch(Exception e) {
				System.out.println("ERROR:getting Events"+e);
			}
		}
		return events;
	}


	public int[] getUser() {

		Connection conn=MySqlConnector.connectToDB();
		String sql="Select * from tbl_user";
		if(user==null){
			try {
				PreparedStatement preparedStatement=conn.prepareStatement(sql);

				ResultSet resultSet=preparedStatement.executeQuery();
				user=new int[3];
				int i=0;
				while(resultSet.next()){
					user[i]=resultSet.getInt(1);
					i++;
				}			
				resultSet.close();			
			}catch(Exception e){
				System.out.println("ERROR:getting Users"+e);
			}
		}
		
		return user;
	}


	public double getRating(int u, int e) {

		Connection connection=MySqlConnector.connectToDB();
		String sql="SELECT tbl_rate.rate FROM tbl_rate where userId=" + u + " and eventId=" + e ;
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			
			if(resultSet.next()) {
				getUserEventRating=resultSet.getInt(1);
				
				resultSet.close();
				return getUserEventRating;
			}else {
				
				resultSet.close();
				return Double.NaN;

			}
		} catch (Exception exp) {
			System.out.println("ERROR:GETING RATE"+exp);
		}
	
		return Double.NaN;
	}


	public HashMap<Integer, HashMap<Integer, Integer>> getRating() {

		Connection connection=MySqlConnector.connectToDB();
		String sql="Select * from tbl_rate";
		if(rating==null) {
			try {
				PreparedStatement preparedStatement=connection.prepareStatement(sql);
				preparedStatement.setFetchSize(Integer.MIN_VALUE);
				ResultSet rs=preparedStatement.executeQuery();
				rating=new HashMap<Integer,HashMap<Integer,Integer>>();
				Integer event,user,rate;
				HashMap<Integer,Integer> innerHashMap=null;
				while(rs.next()){
					event=rs.getInt(2);
					user=rs.getInt(3);
					rate=rs.getInt(4);
					
					innerHashMap=rating.get(event);
					if(innerHashMap==null) {
						innerHashMap=new HashMap<Integer,Integer>();
					}
					innerHashMap.put(user, rate);
					rating.put(event, innerHashMap);

				}

				rs.close();

			} catch (Exception e) {
				System.out.println("ERROR:HASH MAP "+e);
			}
		}
		
		return rating;
	}


}









