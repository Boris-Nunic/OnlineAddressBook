package org.bildit.main;

import org.bildit.model.dao.UserDaoImpl;
import org.bildit.model.entities.User;
import org.bildit.model.service.UserService;

public class Main {

	public static void main(String[] args) {
		UserDaoImpl dao = new UserDaoImpl();
		User user = new User();
		user.setId(1);
		user.getPersonalInfo().setFirstName("firstName");
		user.getAddress().setEmail("somthing@something.som");
		System.out.println(dao.editUser(user));

	}
}
