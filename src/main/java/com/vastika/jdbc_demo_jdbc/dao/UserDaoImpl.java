package com.vastika.jdbc_demo_jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vastika.jdbc_demo_jdbc.model.User;
import com.vastika.jdbc_demo_jdbc.util.DBUtil;
import com.vastika.jdbc_demo_jdbc.util.QueryUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public int saveUserInfo(User user) {
		
		int input =0;
		try (Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(QueryUtil.INSERT_SQL);){
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setLong(3, user.getMobileNo());
			ps.setString(4, user.getAddress());
			ps.executeUpdate();
			input = ps.executeUpdate();
			
			
		}catch (ClassNotFoundException| SQLException e) {
			e.printStackTrace(); }
		return input;
		
	}

	@Override
	public int updateUserInfo(User user) {
		int update =0;
		try (Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(QueryUtil.UPDATE_SQL);){
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setLong(3, user.getMobileNo());
			ps.setString(4, user.getAddress());
			ps.setInt(5, user.getId());
			
			ps.executeUpdate();
			update = ps.executeUpdate();
			
			
		}catch (ClassNotFoundException| SQLException e) {
			e.printStackTrace(); }
		return update;
		
	}

	@Override
	public void deleteUserInfo(int id) {
		try (Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(QueryUtil.DELETE_SQL);){
			ps.setInt(1,id);
			ps.executeUpdate();
		}catch (ClassNotFoundException| SQLException e) {
			e.printStackTrace(); }
		
		
	}
		

	@Override
	public User getUserById(int id) {
	User user = new User();
		
		try (Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(QueryUtil.GET_BY_ID_SQL);){
			ps.setInt(1, id);
			
			ResultSet rs =ps.executeQuery();
			if(rs.next()) {
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("User_name"));
				user.setPassword(rs.getString("password"));
				user.setAddress(rs.getString("address"));
				user.setMobileNo(rs.getLong("mobile_no"));
			
					
			}
					
		}catch (ClassNotFoundException| SQLException e) {
			e.printStackTrace(); 
			}
		return user;
	}
		
	
	@Override
	public List<User> getAllUserInfo() {
    List <User> userList = new ArrayList<>();
		
		try (Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(QueryUtil.LIST_SQL);){
		  ResultSet rs =ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("User_name"));
				user.setPassword(rs.getString("password"));
				user.setAddress(rs.getString("address"));
				user.setMobileNo(rs.getLong("mobile_no"));
				userList.add(user);
					
			}
					
		}catch (ClassNotFoundException| SQLException e) {
			e.printStackTrace(); 
			}
		return userList;
	}
}