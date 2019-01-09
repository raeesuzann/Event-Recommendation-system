package com.event.service;

import java.sql.SQLException;

public interface AverageRateService {
	int getAvgRate(int eventId) throws SQLException;
}
