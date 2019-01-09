package com.event.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.event.dao.AdminDAO;
import com.event.dbutils.MySqlConnector;
import com.event.model.Admin;

public class AdminDAOImpl implements AdminDAO{

	@Override
	public int register(Admin admin) {
		int registered=0;
		Connection connection=MySqlConnector.connectToDB();
		String sql="INSERT INTO tbl_admin(firstName,lastName,address,dob,sex,emailAddress,password,confirmPassword,status) VALUES (?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, admin.getFirstName());
			preparedStatement.setString(2, admin.getLastName());
			preparedStatement.setString(3, admin.getAddress());
			preparedStatement.setString(4, admin.getDob());
			preparedStatement.setString(5, admin.getSex());
			preparedStatement.setString(6, admin.getEmailAddress());
			preparedStatement.setString(7,admin.getPassword());
			preparedStatement.setString(8, admin.getConfirmPassword());
			preparedStatement.setInt(9, admin.getStatus());
			registered=preparedStatement.executeUpdate();
		} catch (Exception exp) {
			System.out.println("ERROR:Register"+exp);
		}
		return registered;
	}

	@Override
	public int checkAuthenticate(Admin admin) {
		int authenticate=0;
		Connection connection=MySqlConnector.connectToDB();
		String sql="SELECT id FROM tbl_admin WHERE emailAddress=? AND password=? AND status='1'";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,admin.getEmailAddress());
			preparedStatement.setString(2, admin.getPassword());
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next()) {
				authenticate=rs.getInt("id");
			}
		} catch (SQLException exp) {
			System.out.println("ERROR:Authentication"+exp);
		}
		return authenticate;
	}

	@Override
	public String getuserName(int id) {
		String userName="";
		Connection connection=MySqlConnector.connectToDB();
		String sql="SELECT firstName,lastName FROM tbl_admin WHERE id=?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next()) {
				userName=rs.getString("firstName");
				userName+=" "+rs.getString("lastName");
			}
		} catch (Exception e) {
			System.out.println("ERROR: getting username"+e);
		}
		return userName;
	}

	@Override
	public String getuserAddress(int id) {
		String userAddress="";
		Connection connection=MySqlConnector.connectToDB();
		String sql="SELECT address FROM tbl_admin WHERE id=?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next()) {
				userAddress=rs.getString("address");
			}	
		} catch (Exception e) {
			System.out.println("ERROR:Extraction Address"+e);
		}
		return userAddress;
	}

	@Override
	public String getuserdob(int id) {
		String userdob="";
		Connection connection=MySqlConnector.connectToDB();
		String sql="SELECT dob FROM tbl_user WHERE id=?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next()) {
				userdob=rs.getString("dob");
			}
		} catch (Exception e) {
			System.out.println("ERROR: getting userdob"+e);
		}
		return userdob;
	}

	@Override
	public String getusersex(int id) {
		String userSex="";
		Connection connection=MySqlConnector.connectToDB();
		String sql="SELECT sex FROM tbl_user WHERE id=?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next()) {
				userSex=rs.getString("sex");
			}
		} catch (Exception e) {
			System.out.println("ERROR: getting userdob"+e);
		}
		return userSex;
	}

	@Override
	public String getuseremailAddress(int id) {
		String userEmailAddress="";
		Connection connection=MySqlConnector.connectToDB();
		String sql="SELECT emailAddress FROM tbl_user WHERE id=?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next()) {
				userEmailAddress=rs.getString("emailAddress");
			}
		} catch (Exception e) {
			System.out.println("ERROR: getting userdob"+e);
		}
		return userEmailAddress;
	}
	

}
