package com.event.model;

public class Event {
	private int id;
	private int adminId;
	private String eventName;
	private String eventCategory;
	private String proposedDate;	
	private String proposedTime;
	private String eventdate;
	private String eventTime;
	private String eventAddress;
	private String eventNotice;
	private int status;
	
	public Event() {
		
	}
	
	public Event(int id, int adminId, String eventName, String eventCategory, String proposedDate, String proposedTime,
			String eventdate, String eventTime, String eventAddress, String eventNotice, int status) {
		this.id = id;
		this.adminId = adminId;
		this.eventName = eventName;
		this.eventCategory = eventCategory;
		this.proposedDate = proposedDate;
		this.proposedTime = proposedTime;
		this.eventdate = eventdate;
		this.eventTime = eventTime;
		this.eventAddress = eventAddress;
		this.eventNotice = eventNotice;
		this.status = status;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventCategory() {
		return eventCategory;
	}
	public void setEventCategory(String eventCategory) {
		this.eventCategory = eventCategory;
	}
	public String getProposedDate() {
		return proposedDate;
	}
	public void setProposedDate(String proposedDate) {
		this.proposedDate = proposedDate;
	}
	public String getProposedTime() {
		return proposedTime;
	}
	public void setProposedTime(String proposedTime) {
		this.proposedTime = proposedTime;
	}
	public String getEventdate() {
		return eventdate;
	}
	public void setEventdate(String eventdate) {
		this.eventdate = eventdate;
	}
	public String getEventTime() {
		return eventTime;
	}
	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}
	public String getEventAddress() {
		return eventAddress;
	}
	public void setEventAddress(String eventAddress) {
		this.eventAddress = eventAddress;
	}
	public String getEventNotice() {
		return eventNotice;
	}
	public void setEventNotice(String eventNotice) {
		this.eventNotice = eventNotice;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Event [id=" + id + ", adminId=" + adminId + ", eventName=" + eventName + ", eventCategory="
				+ eventCategory + ", proposedDate=" + proposedDate + ", proposedTime=" + proposedTime + ", eventdate="
				+ eventdate + ", eventTime=" + eventTime + ", eventAddress=" + eventAddress + ", eventNotice="
				+ eventNotice + ", status=" + status + "]";
	}
	
	
}
	