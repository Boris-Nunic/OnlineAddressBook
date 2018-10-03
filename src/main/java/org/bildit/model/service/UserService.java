package org.bildit.model.service;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import org.bildit.model.dao.UserDaoImpl;
import org.bildit.model.entities.User;

public class UserService {
	
	private static UserDaoImpl userDao = new UserDaoImpl();
	
	public static String registration(String email, String password, String repeatPassword) {
		
		String message = null;
		if (!password.equals(repeatPassword)) {
			message = "Password and reapeted password do not match. Please try again";
			return message;
		}
		
		try {
			User user = new User(email, password);
			userDao.addUser(user);
			message="Your registration was successful. Please login to continue";
			
		} catch (SQLIntegrityConstraintViolationException e) {
			message="Provided email adderss is already registered. Please enter anothor email address";
		} catch(SQLException e) {
			message="Something went wrong. Please try again";
		}
		return message;
	}

}