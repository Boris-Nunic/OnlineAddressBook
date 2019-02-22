package com.boris.model.service;

import java.util.ArrayList;

import com.boris.model.dao.ContactDaoImpl;
import com.boris.model.entities.Contact;

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

	public static Contact getContact(Integer contactId, Integer userId) {
		Contact contact = contactDao.getContact(contactId, userId);
		return contact;
	}
	
	public static int removeContact(Integer contactId) {
		int result;
		Integer rowsAffected = contactDao.removeContact(contactId);
		
		if(rowsAffected != 1) {
			result = 0;
		}
		
		else {
			result = 1;
		}
		
		return result;
	}
	
	public static int editContact(Contact contact) {
		
		int result;
		Integer rowsAffected = contactDao.editContact(contact);
		
		if(rowsAffected != 1) {
			result =0;
		}
		
		else {
			result = 1;
		}
		
		return result;
	}
}
