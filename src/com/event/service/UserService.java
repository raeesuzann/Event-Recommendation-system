package com.event.service;

import java.sql.SQLException;

import com.event.model.User;

public interface UserService {
	int register(User user) throws SQLException;
	int checkAuthenticate(User user) throws SQLException;

	int getUserId(int id) throws SQLException;
	String getuserName(int id) throws SQLException;
	String getuserAddress(int id) throws SQLException;
	String getuserFaculty(int id) throws SQLException;
	String getusersemester(int id) throws SQLException;

}
