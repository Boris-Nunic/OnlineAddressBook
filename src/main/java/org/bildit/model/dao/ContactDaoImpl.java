package org.bildit.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		
		String query = "SELECT * FROM contacts WHERE user_id = ? ORDER BY first_name";
		Contact contact = null;
		ResultSet rs = null;
		List<Contact> contacts = new ArrayList<>();
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, userId);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				contact = new Contact();
				contact.setId(rs.getInt("contacts_id"));
				contact.getPersonalInfo().setFirstName(rs.getString("first_name"));
				contact.getPersonalInfo().setSurname(rs.getString("surname"));
				contact.getPersonalInfo().setPhoneNumber(rs.getString("phone_number"));
				contact.getPersonalInfo().setDob(rs.getDate("dob"));
				contact.getAddress().setEmail(rs.getString("email"));
				contact.getAddress().setStreetAddress(rs.getString("street_address"));
				contact.getAddress().setCity(rs.getString("street_address"));
				contact.getAddress().setCountry("country");
				contacts.add(contact);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contacts;
	}
}
