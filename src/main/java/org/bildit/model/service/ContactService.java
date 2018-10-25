package org.bildit.model.service;

import java.util.ArrayList;

import org.bildit.model.dao.ContactDaoImpl;
import org.bildit.model.entities.Contact;

public class ContactService {

	private static ContactDaoImpl contactDao = new ContactDaoImpl();

	public static String addContact(Contact contact, Integer userId) {

		String message;
		Integer rowsAffected = contactDao.addContact(contact, userId);

		if (rowsAffected != 1) {
			message = "Somethig went wrong. Please try again";
		}

		else {
			message = "This contact was successfully added to your contacts";
		}
		return message;
	}

	public static ArrayList<Contact> getAllContacts(Integer userId) {
		ArrayList<Contact> contacts = (ArrayList<Contact>) contactDao.getAllContacts(userId);
		return contacts;
	}
	
	public static ArrayList<Contact> searchContacts(String searchQuery, Integer userId){
		ArrayList<Contact> contacts = (ArrayList<Contact>)contactDao.searchContacts(searchQuery, userId);
		return contacts;
	}

}
