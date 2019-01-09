package com.event.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.event.dao.AverageRateDAO;
import com.event.dbutils.MySqlConnector;

public class AverageRateDAOImpl implements AverageRateDAO{

	@Override
	public int getAvgRate(int eventId) throws SQLException {
		int eventAvgRate=0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn=MySqlConnector.connectToDB();
		String sql="SELECT avg_rate FROM tbl_avg_rate WHERE eventId=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, eventId);
			rs=ps.executeQuery();
			while(rs.next()) {
				eventAvgRate=rs.getInt("avg_rate");
			}
		} catch (Exception e) {
			System.out.println("ERROR: getting eventRate"+e);
		} finally {
			conn.close();
		}
		rs.close();
		ps.close();
		return eventAvgRate;
	}

}
