package com.vastika.jdbc_demo_jdbc.service;

import java.util.List;

import com.vastika.jdbc_demo_jdbc.model.User;

public interface UserService {
	int saveUserInfo(User user);
	int updateUserInfo(User user);
	void deleteUserInfo(int id);
	User getUserById(int id);
	List<User> getAllUserInfo();
	

}
