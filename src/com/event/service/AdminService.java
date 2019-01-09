package com.event.service;

import com.event.model.Admin;

public interface AdminService {
	int register(Admin admin);
	int checkAuthenticate(Admin admin);
	String getuserName(int id);
	String getuserAddress(int id);
	String getuserdob(int id);
	String getusersex(int id);
	String getuseremailAddress(int id);

}
