package com.boris.model.dao;

import java.util.List;

import com.boris.model.entities.Contact;

public interface ContactDaoInterface {

	public Integer addContact(Contact contact, Integer userId);
	
	public Integer removeContact(Integer contactId);
	
	public Integer editContact(Contact contact);
	
	public List<Contact> getAllContacts(Integer userId);

	public List<Contact> searchContacts(String searchQuery, Integer userId);
	
	public Contact getContact(Integer contactId, Integer userid);
}