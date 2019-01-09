package com.event.serviceImpl;

import java.sql.SQLException;

import com.event.dao.AverageRateDAO;
import com.event.daoImpl.AverageRateDAOImpl;
import com.event.service.AverageRateService;

public class AverageRateServiceImpl implements AverageRateService {
	AverageRateDAO averageRateDAO = new AverageRateDAOImpl();

	@Override
	public int getAvgRate(int eventId) throws SQLException {
		return averageRateDAO.getAvgRate(eventId);
	}
	
	
}
