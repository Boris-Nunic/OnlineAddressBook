package org.bildit.model.service;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import org.bildit.model.dao.UserDaoImpl;
import org.bildit.model.entities.User;

public class UserService {

	private static UserDaoImpl userDao = new UserDaoImpl();

	// Registration logic
	public static String registration(String email, String password, String repeatPassword) {

		String message = null;
		String encryptedPassword = null;

		if (!password.equals(repeatPassword)) {
			message = "Password and reapeted password do not match. Please try again";
			return message;
		}

		try {
			encryptedPassword = EncryptionService.encryptPassword(password);
		} catch (Exception e) {
			message = "Something went wrong, please try again";
			return message;
		}

		try {
			User user = new User(email, encryptedPassword);
			userDao.addUser(user);
			message = "Your registration was successful. Please login to continue";

		} catch (SQLIntegrityConstraintViolationException e) {
			message = "Provided email adderss is already registered. Please enter anothor email address";
		} catch (SQLException e) {
			message = "Something went wrong. Please try again";
		}
		return message;
	}

	// Login logic
	public static User login(String email, String password) {

		String message = null;
		String encryptedPassword = null;
		User user = userDao.getUser(email);
		
		if(user == null) {
			user = new User();
			message = "Provided e-mail address or password is not valid";
			user.setMessage(message);
			return user;
		}
		
		try {
			encryptedPassword = EncryptionService.encryptPassword(password);
		} catch (Exception e) {
			message = "Somthing went wrong. Please try again";
			user.setMessage(message);
			return user;
		}

		if (user == null || !user.getPassword().equals(encryptedPassword)) {
			message = "Provided e-mail address or password is not valid";
			user.setMessage(message);
			return user;
		}
		
		user.setPassword(null);
		return user;
	}
	
	//Edit profile logic
	public static String editProfile(User user) {
		String message = null;
		int rowsAffected = userDao.editUser(user);
		if(rowsAffected !=1) {
			message = "Something went wrong. Please try again";
			return message;
		}
		return message;
	}
	
	// Delete profile logic
	public static String deleteProfile(Integer id) {
		String message = null;
		int rowsAffected = userDao.deleteUser(id);
		if(rowsAffected !=1) {
			message = "Somthing went wrong please try again";
			return message;
		}
		return message;
	}
}