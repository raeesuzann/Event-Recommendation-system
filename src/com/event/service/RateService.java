package com.event.service;

import java.sql.SQLException;
import java.util.List;

import com.event.model.Rate;

public interface RateService {
	int save(Rate rate) throws SQLException;
	int getRate(int rate) throws SQLException;
	int getRateByUser(int rate, int rate1) throws SQLException; 
	List<Rate> list() throws SQLException;
	List<Rate> getEventById(int id) throws SQLException;
	List<Rate> getUserById(int id) throws SQLException;
}
