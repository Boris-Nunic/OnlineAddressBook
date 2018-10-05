package org.bildit.main;

import org.bildit.model.dao.ContactDaoImpl;
import org.bildit.model.dao.UserDaoImpl;
import org.bildit.model.entities.Contact;
import org.bildit.model.entities.User;
import org.bildit.model.service.UserService;

public class Main {

	public static void main(String[] args) {
		Contact contact = new Contact();
		contact.getPersonalInfo().setFirstName("firstName");
		contact.getPersonalInfo().setSurname("surname");
	
		ContactDaoImpl dao = new ContactDaoImpl();
		System.out.println(dao.addContact(contact, 1));

	}
}
