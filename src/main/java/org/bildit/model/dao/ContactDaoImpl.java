package org.bildit.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import org.bildit.model.entities.Contact;

public class ContactDaoImpl implements ContactDaoInterface {

	private Connection connection = ConnectionManager.getInstance().getConnection();

	@Override
	public Integer addContact(Contact contact, Integer userId) {
		String query = "INSERT INTO contacts (first_name, surname, email, "
				+ "dob, phone_number, street_address, city, country, user_id) " 
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Integer rowsAffected = 0;
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, contact.getPersonalInfo().getFirstName());
			ps.setString(2, contact.getPersonalInfo().getSurname());
			ps.setString(3, contact.getAddress().getEmail());
			ps.setDate(4, contact.getPersonalInfo().getDob());
			ps.setString(5, contact.getPersonalInfo().getPhoneNumber());
			ps.setString(6, contact.getAddress().getStreetAddress());
			ps.setString(7, contact.getAddress().getCity());
			ps.setString(8, contact.getAddress().getCountry());
			ps.setInt(9, userId);
			
			rowsAffected = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rowsAffected;
	}

	@Override
	public Integer removeContact(Integer ContactId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer editContact(Contact contact) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contact> getAllContacts(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
