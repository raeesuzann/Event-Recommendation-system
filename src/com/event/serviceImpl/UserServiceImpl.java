package com.event.serviceImpl;

import java.sql.SQLException;

import com.event.dao.UserDAO;
import com.event.daoImpl.UserDAOImpl;
import com.event.model.User;
import com.event.service.UserService;

public class UserServiceImpl implements UserService{
	UserDAO userDAO=new UserDAOImpl();
	@Override
	public int register(User user) throws SQLException {
		return userDAO.register(user);
	}

	@Override
	public int checkAuthenticate(User user) throws SQLException {
		return userDAO.checkAuthenticate(user);
	}

	@Override
	public String getuserName(int id) throws SQLException {
		return userDAO.getuserName(id);
	}

	@Override
	public String getuserAddress(int id) throws SQLException {
		return userDAO.getuserAddress(id);
	}

	@Override
	public String getuserFaculty(int id) throws SQLException {
		return userDAO.getuserFaculty(id);
	}

	@Override
	public String getusersemester(int id) throws SQLException {
		return userDAO.getusersemester(id);
	}

	@Override
	public int getUserId(int id) throws SQLException {
		return userDAO.getUserId(id);
	}

}
