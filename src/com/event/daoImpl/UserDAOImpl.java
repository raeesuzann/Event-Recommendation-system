package com.event.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.event.dao.UserDAO;
import com.event.dbutils.MySqlConnector;
import com.event.model.User;

public class UserDAOImpl implements UserDAO{

	@Override
	public int register(User user) throws SQLException {
		int registered=0;
		PreparedStatement ps = null;
		Connection conn=MySqlConnector.connectToDB();
		String sql="INSERT INTO tbl_user(firstName,lastName,address,dob,sex,faculty,semester,rollNo,emailAddress,password, confirmPassword,status) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getAddress());
			ps.setString(4, user.getDob());
			ps.setString(5, user.getSex());
			ps.setString(6, user.getFaculty());
			ps.setString(7, user.getSemester());
			ps.setInt(8, user.getRollNo());
			ps.setString(9, user.getEmailAddress());
			ps.setString(10,user.getPassword());
			ps.setString(11, user.getConfirmPassword());
			ps.setInt(12, user.getStatus());
			registered=ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("ERROR:REGISTER "+e);
		}finally {
			conn.close();
		}
		ps.close();
		return registered;
	}

	@Override
	public int checkAuthenticate(User user) throws SQLException {
		int authenticate=0;
		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection conn=MySqlConnector.connectToDB();
		String sql="SELECT id FROM tbl_user WHERE emailAddress=? AND password=? AND status='1'";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1,user.getEmailAddress());
			ps.setString(2, user.getPassword());
			rs=ps.executeQuery();
			while(rs.next()) {
				authenticate=rs.getInt("id");
			}
		} catch (Exception exp) {
			System.out.println("ERROR:Authentication"+exp);
		}finally {
			conn.close();
		}
		rs.close();
		ps.close();
		return authenticate;
	}

	@Override
	public String getuserName(int id) throws SQLException {
		String userName="";
		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection conn=MySqlConnector.connectToDB();
		String sql="SELECT firstName,lastName FROM tbl_user WHERE id=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()) {
				userName=rs.getString("firstName");
				userName+=" "+rs.getString("lastName");
			}
		} catch (Exception e) {
			System.out.println("ERROR: getting username"+e);
		}finally {
			conn.close();
		}
		rs.close();
		ps.close();
		return userName;
	}

	@Override
	public String getuserAddress(int id) throws SQLException {
		String userAddress="";
		PreparedStatement ps = null;
		ResultSet rs = null; 
		Connection conn=MySqlConnector.connectToDB();
		String sql="SELECT address FROM tbl_user WHERE id=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()) {
				userAddress=rs.getString("address");
			}

		} catch (Exception e) {
			System.out.println("ERROR:Extraction Address"+e);
		}finally {
			conn.close();
		}
		rs.close();
		ps.close();
		return userAddress;
	}

	@Override
	public String getuserFaculty(int id) throws SQLException{
		String userFaculty="";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn=MySqlConnector.connectToDB();
		String sql="SELECT faculty FROM tbl_user WHERE id=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()) {
				userFaculty=rs.getString("faculty");

			}
		} catch (Exception e) {
			System.out.println("ERROR: getting userfaculty"+e);
		}finally {
			conn.close();
		}
		rs.close();
		ps.close();
		return userFaculty;
	}

	@Override
	public String getusersemester(int id) throws SQLException {
		String userSemester="";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn=MySqlConnector.connectToDB();
		String sql="SELECT semester FROM tbl_user WHERE id=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()) {
				userSemester=rs.getString("semester");

			}
		} catch (Exception e) {
			System.out.println("ERROR: getting usersemester"+e);
		} finally {
			conn.close();
		}
		rs.close();
		ps.close();
		return userSemester;
	}

	@Override
	public String getuserdob(int id) throws SQLException {
		String userdob="";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn=MySqlConnector.connectToDB();
		String sql="SELECT dob FROM tbl_user WHERE id=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()) {
				userdob=rs.getString("dob");

			}
		} catch (Exception e) {
			System.out.println("ERROR: getting userdob"+e);
		} finally {
			conn.close();
		}
		rs.close();
		ps.close();
		return userdob;
	}

	@Override
	public String getusersex(int id) throws SQLException {
		String userSex="";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn=MySqlConnector.connectToDB();
		String sql="SELECT sex FROM tbl_user WHERE id=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()) {
				userSex=rs.getString("semester");

			}
		} catch (Exception e) {
			System.out.println("ERROR: getting usersemester"+e);
		} finally {
			conn.close();
		}
		rs.close();
		ps.close();
		return userSex;
	}

	@Override
	public String getuseremailAddress(int id) throws SQLException{
		String userEmailAddress="";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn=MySqlConnector.connectToDB();
		String sql="SELECT emailAddress FROM tbl_user WHERE id=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()) {
				userEmailAddress=rs.getString("emailAddress");

			}
		} catch (Exception e) {
			System.out.println("ERROR: getting usersemester"+e);
		} finally {
			conn.close();
		}
		rs.close();
		ps.close();
		return userEmailAddress;
	}

	@Override
	public int getUserId(int id) throws SQLException {
		int userId=0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn=MySqlConnector.connectToDB();
		String sql="SELECT id FROM tbl_user WHERE id=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()) {
				userId=rs.getInt("id");

			}
		} catch (Exception e) {
			System.out.println("ERROR: getting user Id"+e);
		}finally {
			conn.close();
		}
		rs.close();
		ps.close();
		return userId;
	}

}
