package org.bildit.model.service;

import org.bildit.model.dao.ContactDaoImpl;
import org.bildit.model.entities.Contact;

public class ContactService {
	
	private static ContactDaoImpl contactDao = new ContactDaoImpl();
	
	public static String addContact(Contact contact, Integer userId) {
		
		String message;
		Integer rowsAffected = contactDao.addContact(contact, userId);
		
		if(rowsAffected != 1) {
			message = "Somethig went wrong. Please try again";
		}
		
		else {
			message = "This contact was successfully added to your contacts";
		}
		return message;
	}
			

}
