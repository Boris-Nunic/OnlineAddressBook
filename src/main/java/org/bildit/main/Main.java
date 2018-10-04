package org.bildit.main;

import org.bildit.model.service.UserService;

public class Main {

	public static void main(String[] args) {
		UserService.login("email", "password");
	}
}
