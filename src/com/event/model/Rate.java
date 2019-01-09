package com.event.model;

public class Rate {
	private int id;
	private int userId;
	private int eventId;
	private int rate;
	private int status;
	public Rate() {
		
	}
	public Rate(int id,int userId,int eventId, int rate, int status) {
		
		this.id = id;
		this.userId=userId;
		this.eventId=eventId;
		this.rate = rate;
		this.status = status;
	}
	@Override
	public String toString() {
		return "Rate [id=" + id + " , userId = " + userId + " , eventId = " + eventId + ", rate=" + rate + ", status=" + status + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

}
