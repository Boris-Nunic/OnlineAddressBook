package com.boris.model.service;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import com.boris.model.dao.UserDaoImpl;
import com.boris.model.entities.User;

public class UserService {

	private static UserDaoImpl userDao = new UserDaoImpl();

	// Registration logic
	public static int registration(String email, String password, String repeatPassword) {

		int result;
		String encryptedPassword = null;

		if (!password.equals(repeatPassword)) {
			result = 3;
			return result;
		}

		try {
			encryptedPassword = EncryptionService.encryptPassword(password);
		} catch (Exception e) {
			result = 1;
			return result;
		}

		try {
			User user = new User(email, encryptedPassword);
			userDao.addUser(user);
			result = 0;

		} catch (SQLIntegrityConstraintViolationException e) {
			result = 2;
		} catch (SQLException e) {
			result = 1;
		}
		return result;
	}

	// Login logic
	public static Integer login(String email, String password) {

//		String message = null;
		String encryptedPassword = null;
		try {
			encryptedPassword = EncryptionService.encryptPassword(password);
		} catch (Exception e) {
			e.printStackTrace();
//			message = "Somthing went wrong. Please try again";
//			user.setMessage(message);
//			return user;
		}

		Integer userId = userDao.validateUser(email, encryptedPassword);

		return userId;

//		if(user == null) {
//			user = new User();
//			message = "Provided e-mail address or password is not valid";
//			user.setMessage(message);
//			return user;
//		}
//		
//		
//
//		if (user == null || !user.getPassword().equals(encryptedPassword)) {
//			message = "Provided e-mail address or password is not valid";
//			user.setMessage(message);
//			return user;
//		}
//		
//		user.setPassword(null);
//		return user;
	}

	// Edit profile logic
	public static boolean editProfile(User user) {
		int rowsAffected = userDao.editUser(user);
		if (rowsAffected != 1) {
			return false;
		}
		return true;
	}

	// Delete profile logic
	public static String deleteProfile(Integer id) {
		String message = null;
		int rowsAffected = userDao.deleteUser(id);
		if (rowsAffected != 1) {
			message = "Somthing went wrong please try again";
			return message;
		}
		return message;
	}

	// Get user's info
	public static User getUserInfo(Integer userId) {
		User user = userDao.getUser(userId);
		return user;
	}
}