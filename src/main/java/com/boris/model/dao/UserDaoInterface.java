package com.boris.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.boris.model.entities.User;

public interface UserDaoInterface {

	int addUser(User user) throws SQLException;
	
	User getUser(Integer userId);
	
	int editUser(User user);
	
	int deleteUser(Integer id);
	
	List<User> getUsers();
	
	Integer validateUser(String email, String password);
	
}
