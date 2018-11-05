package org.bildit.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.bildit.model.entities.User;

public class UserDaoImpl implements UserDaoInterface {

	private Connection connection = ConnectionManager.getInstance().getConnection();

	@Override
	public int addUser(User user) throws SQLException {

		String query = "INSERT INTO users(password, first_name, surname, email,"
				+ " phone_number, dob, street_address, city, country ) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

		int rowsAffected = 0;
		try (PreparedStatement ps = connection.prepareStatement(query);) {

			ps.setString(1, user.getPassword());
			ps.setString(2, user.getPersonalInfo().getFirstName());
			ps.setString(3, user.getPersonalInfo().getSurname());
			ps.setString(4, user.getAddress().getEmail());
			ps.setString(5, user.getPersonalInfo().getPhoneNumber());
			ps.setDate(6, user.getPersonalInfo().getDob());
			ps.setString(7, user.getAddress().getStreetAddress());
			ps.setString(8, user.getAddress().getCity());
			ps.setString(9, user.getAddress().getCountry());

			rowsAffected = ps.executeUpdate();

		}

		return rowsAffected;
	}

	@Override
	public User getUser(String email) {

		String query = "SELECT * FROM users WHERE email=?";
		User user = null;

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = new User(rs.getString("email"), rs.getString("password"));
				user.setId(rs.getInt("user_id"));
				user.getPersonalInfo().setFirstName(rs.getString("first_name"));
				user.getPersonalInfo().setSurname(rs.getString("surname"));
				user.getPersonalInfo().setPhoneNumber(rs.getString("phone_number"));
				user.getPersonalInfo().setDob(rs.getDate("dob"));
				user.getAddress().setCity(rs.getString("city"));
				user.getAddress().setCountry(rs.getString("country"));
				user.getAddress().setStreetAddress(rs.getString("street_address"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public int editUser(User user) {
		
		int rowsAffected = 0;
		String query = "UPDATE users SET first_name = ?, surname = ?, email = ?, dob = ?,"
				+ " phone_number = ?, street_address = ?, city = ?, country = ? WHERE user_id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, user.getPersonalInfo().getFirstName());
			ps.setString(2, user.getPersonalInfo().getSurname());
			ps.setString(3, user.getAddress().getEmail());
			ps.setDate(4, user.getPersonalInfo().getDob());
			ps.setString(5, user.getPersonalInfo().getPhoneNumber());
			ps.setString(6, user.getAddress().getStreetAddress());
			ps.setString(7, user.getAddress().getCity());
			ps.setString(8, user.getAddress().getCountry());
			ps.setInt(9, user.getId());

			rowsAffected = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowsAffected;
	}

	@Override
	public int deleteUser(Integer id) {
		String query = "DELETE FROM users WHERE user_id = ?";
		int rowsAffected = 0;
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			rowsAffected = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowsAffected;
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer validateUser(String email, String password) {
	
		Integer userId = null;
		String sqlQuery="SELECT * FORM online_address_book.user WHERE email = ? and password = ?";
		ResultSet rs = null;
		
		try {
			PreparedStatement ps = connection.prepareStatement(sqlQuery);
			ps.setString(1, email);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			
			if (rs.next()) {
				userId = rs.getInt("user_id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return userId;
	}

}
