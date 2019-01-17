package org.bildit.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.bildit.model.entities.Contact;

public class ContactDaoImpl implements ContactDaoInterface {

	private Connection connection = ConnectionManager.getInstance().getConnection();

	@Override
	public Integer addContact(Contact contact, Integer userId) {
		String sqlQuery = "INSERT INTO contacts (first_name, surname, email, "
				+ "dob, phone_number, street_address, city, country, user_id) " + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Integer rowsAffected = 0;

		try {
			PreparedStatement ps = connection.prepareStatement(sqlQuery);
			ps.setString(1, contact.getPersonalInfo().getFirstName());
			ps.setString(2, contact.getPersonalInfo().getSurname());
			ps.setString(3, contact.getAddress().getEmail());
			ps.setDate(4, contact.getPersonalInfo().getDob(), Calendar.getInstance());
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
	public Integer removeContact(Integer contactId) {
		String query = "DELETE FROM online_address_book.contacts WHERE contact_id = ?";
		Integer rowsAffected = -1;

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, contactId);
			rowsAffected = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowsAffected;
	}

	@Override
	public Integer editContact(Contact contact) {

		String sqlQuery = "UPDATE contacts SET first_name = ?, surname = ?, dob = ?, phone_number = ?"
				+ ", email = ?, street_address = ?, city = ?, country = ? WHERE contact_id = ?";
		Integer rowsAffected = -1;
		
		try {
			PreparedStatement ps = connection.prepareStatement(sqlQuery);
			
			ps.setString(1, contact.getPersonalInfo().getFirstName());
			ps.setString(2, contact.getPersonalInfo().getSurname());
			ps.setDate(3, contact.getPersonalInfo().getDob(), Calendar.getInstance());
			ps.setString(4, contact.getPersonalInfo().getPhoneNumber());
			ps.setString(5, contact.getAddress().getEmail());
			ps.setString(6, contact.getAddress().getStreetAddress());
			ps.setString(7, contact.getAddress().getCity());
			ps.setString(8, contact.getAddress().getCountry());
			ps.setInt(9, contact.getId());
			
			rowsAffected = ps.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return rowsAffected;
	}

	@Override
	public List<Contact> getAllContacts(Integer userId) {

		String sqlQuery = "SELECT * FROM contacts WHERE user_id = ? ORDER BY first_name";
		Contact contact = null;
		ResultSet rs = null;
		List<Contact> contacts = new ArrayList<>();

		try {
			PreparedStatement ps = connection.prepareStatement(sqlQuery);
			ps.setInt(1, userId);
			rs = ps.executeQuery();

			while (rs.next()) {
				contact = new Contact();
				contact.setId(rs.getInt("contact_id"));
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

	@Override
	public List<Contact> searchContacts(String searchQuery, Integer userId) {

		String SqlQuery = "SELECT *  FROM contacts WHERE (first_name LIKE '%" + searchQuery + "%' OR surname LIKE '%"
				+ searchQuery + "%') AND user_id = ? ORDER BY first_name";

		Contact contact = null;
		List<Contact> contacts = null;
		ResultSet rs = null;

		try {
			PreparedStatement ps = connection.prepareStatement(SqlQuery);
			ps.setInt(1, userId);
			rs = ps.executeQuery();
			contacts = new ArrayList<>();

			while (rs.next()) {
				contact = new Contact();
				contact.setId(rs.getInt("contact_id"));
				contact.getPersonalInfo().setFirstName(rs.getString("first_name"));
				contact.getPersonalInfo().setSurname(rs.getString("surname"));
				contact.getPersonalInfo().setDob(rs.getDate("dob"));
				contact.getPersonalInfo().setPhoneNumber(rs.getString("phone_number"));
				contact.getAddress().setEmail(rs.getString("email"));
				contact.getAddress().setStreetAddress(rs.getString("street_address"));
				contact.getAddress().setCity(rs.getString("city"));
				contact.getAddress().setCountry(rs.getString("country"));
				contacts.add(contact);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return contacts;
	}

	@Override
	public Contact getContact(Integer contactId, Integer userId) {

		String query = "SELECT * FROM online_address_book.contacts WHERE contact_id = ? AND user_id = ?";
		Contact contact = null;
		ResultSet rs = null;

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, contactId);
			ps.setInt(2, userId);
			rs = ps.executeQuery();

			if (rs.next()) {
				contact = new Contact();
				contact.setId(rs.getInt("contact_id"));
				contact.getPersonalInfo().setFirstName(rs.getString("first_name"));
				contact.getPersonalInfo().setSurname(rs.getString("surname"));
				contact.getPersonalInfo().setPhoneNumber(rs.getString("phone_number"));
				contact.getPersonalInfo().setDob(rs.getDate("dob"));
				contact.getAddress().setEmail(rs.getString("email"));
				contact.getAddress().setStreetAddress(rs.getString("street_address"));
				contact.getAddress().setCity(rs.getString("city"));
				contact.getAddress().setStreetAddress(rs.getString("street_address"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return contact;
	}
}
