package com.event.serviceImpl;

import java.sql.SQLException;
import java.util.List;

import com.event.dao.RateDAO;
import com.event.daoImpl.RateDAOImpl;
import com.event.model.Rate;
import com.event.service.RateService;

public class RateServiceImpl implements RateService {
	RateDAO rateDAO=(RateDAO) new RateDAOImpl();
	@Override
	public int save(Rate rate) throws SQLException{

		return rateDAO.save(rate);
	}

	@Override
	public List<Rate> list() throws SQLException {

		return rateDAO.list();
	}

	@Override
	public List<Rate> getEventById(int id) throws SQLException {

		return rateDAO.getEventById(id);
	}

	@Override
	public int getRate(int rate) throws SQLException {

		return rateDAO.getRate(rate);
	}

	@Override
	public List<Rate> getUserById(int id) throws SQLException {
		return rateDAO.getUserById(id);
	}

	@Override
	public int getRateByUser(int rate,int rate1) throws SQLException {
		return rateDAO.getRateByUser(rate,rate1);
	}

}
