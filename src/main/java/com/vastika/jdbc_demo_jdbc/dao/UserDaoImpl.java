package com.vastika.jdbc_demo_jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.vastika.jdbc_demo_jdbc.model.User;
import com.vastika.jdbc_demo_jdbc.util.DBUtil;
import com.vastika.jdbc_demo_jdbc.util.QueryUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public int saveUserInfo(User user) {
		
		int saved =0;
		try (Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(QueryUtil.INSERT_SQL);){
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setLong(3, user.getMobileNo());
			ps.setString(4, user.getAddress());
			ps.executeUpdate();
			saved = ps.executeUpdate();
			
			
		}catch (ClassNotFoundException| SQLException e) {
			e.printStackTrace(); }
		return saved;
		
	}

	@Override
	public int updateUserInfo(User user) {
		// TODO Auto-generated method stub
		return 0;
		
	}

	@Override
	public void deleteUserInfo(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUserInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
