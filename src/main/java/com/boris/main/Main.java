package com.boris.main;

import java.util.ArrayList;

import com.boris.model.dao.ContactDaoImpl;
import com.boris.model.dao.UserDaoImpl;
import com.boris.model.entities.Contact;
import com.boris.model.entities.User;
import com.boris.model.service.UserService;

public class Main {

	public static void main(String[] args) {
//		Contact contact = new Contact();
//		contact.getPersonalInfo().setFirstName("firstName");
//		contact.getPersonalInfo().setSurname("surname");
//	
//		ContactDaoImpl dao = new ContactDaoImpl();
////		System.out.println(dao.addContact(contact, 1));
//		ArrayList<Contact> contacts =(ArrayList<Contact>) dao.searchContacts("ok", 21);
//		System.out.println(contacts.get(0).getPersonalInfo().getFirstName());
		
		UserDaoImpl userDao = new UserDaoImpl();
		
		System.out.println(UserService.login("konjina@konj.com", "konjina"));

	}
}
