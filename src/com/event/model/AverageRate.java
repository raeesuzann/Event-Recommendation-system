package com.event.model;

public class AverageRate {
	int eventId;
	int avg_rate;
	
	public AverageRate() {
		
	}
	public AverageRate(int eventId, int avg_rate) {
		super();
		this.eventId = eventId;
		this.avg_rate = avg_rate;
	}
	
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public int getAvg_rate() {
		return avg_rate;
	}
	public void setAvg_rate(int avg_rate) {
		this.avg_rate = avg_rate;
	}
	@Override
	public String toString() {
		return "AverageRate [eventId=" + eventId + ", avg_rate=" + avg_rate + "]";
	}
	
}
