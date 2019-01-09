package com.event.model;

public class Admin {
	private int id;
	private String firstName;
	private String lastName;
	private String address;
	private String dob;
	private String sex;
	private String emailAddress;
	private String password;
	private String confirmPassword;
	private int status;
	
	public Admin() {
		
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", dob=" + dob + ", sex=" + sex + ", emailAddress=" + emailAddress + ", password=" + password
				+ ", confirmPassword=" + confirmPassword + ", status=" + status + "]";
	}

	public Admin(int id, String firstName, String lastName, String address, String dob, String sex, String emailAddress,
			String password, String confirmPassword, int status) {
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.dob = dob;
		this.sex = sex;
		this.emailAddress = emailAddress;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
		
	

}
