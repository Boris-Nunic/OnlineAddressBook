package org.bildit.model.dao;

import java.util.List;

import org.bildit.model.entities.Contact;

public interface ContactDaoInterface {

	public Integer addContact(Contact contact, Integer userId);
	
	public Integer removeContact(Integer ContactId);
	
	public Integer editContact(Contact contact);
	
	public List<Contact> getAllContacts(Integer userId);

	public List<Contact> searchContacts(String searchQuery, Integer userId);
	
	public Contact getContact(Integer contactId, Integer userid);
}