package org.bildit.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.bildit.model.entities.User;

public interface UserDaoInterface {

	int addUser(User user) throws SQLException;
	
	User getUser(String email);
	
	int editUser(User user);
	
	int deleteUser(Integer id);
	
	List<User> getUsers();
	
	
	
}
