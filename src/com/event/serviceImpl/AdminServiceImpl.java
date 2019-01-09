package com.event.serviceImpl;

import com.event.dao.AdminDAO;
import com.event.daoImpl.AdminDAOImpl;
import com.event.model.Admin;
import com.event.service.AdminService;

public class AdminServiceImpl implements AdminService{
	AdminDAO adminDAO=new AdminDAOImpl();

	@Override
	public int register(Admin admin) {
		return adminDAO.register(admin);
	}

	@Override
	public int checkAuthenticate(Admin admin) {
		return adminDAO.checkAuthenticate(admin);
	}

	@Override
	public String getuserName(int id) {
		return adminDAO.getuserName(id);
	}

	@Override
	public String getuserAddress(int id) {
		
		return adminDAO.getuserAddress(id);
	}

	@Override
	public String getuserdob(int id) {
		
		return adminDAO.getuserdob(id);
	}

	@Override
	public String getusersex(int id) {
		
		return adminDAO.getusersex(id);
	}

	@Override
	public String getuseremailAddress(int id) {
		
		return adminDAO.getuseremailAddress(id);
	}
	
	

}
