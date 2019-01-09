package com.event.dao;

import java.sql.SQLException;

public interface AverageRateDAO {
	int getAvgRate(int eventId) throws SQLException;
}
