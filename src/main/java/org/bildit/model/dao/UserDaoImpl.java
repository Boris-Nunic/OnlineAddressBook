package org.bildit.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.bildit.model.entities.User;

public class UserDaoImpl implements UserDaoInterface {

	Connection connection = ConnectionManager.getInstance().getConnection();

	@Override
	public int addUser(User user) throws SQLException{
		
		String query = "INSERT INTO users(password, first_name, surname, email," + 
				" phone_number, dob, street_address, city, country ) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		int rowsAffected = 0;
		try(PreparedStatement ps = connection.prepareStatement(query);) {
			
			ps.setString(1, user.getPassword());
			ps.setString(2, user.getPeronalInfo().getFirstName());
			ps.setString(3, user.getPeronalInfo().getSurname());
			ps.setString(4, user.getAddress().getEmail());
			ps.setString(5, user.getPeronalInfo().getPhoneNumber());
			ps.setDate(6, user.getPeronalInfo().getDob());
			ps.setString(7, user.getAddress().getStreetAddress());
			ps.setString(8, user.getAddress().getCity());
			ps.setString(9, user.getAddress().getCountry());
			
			rowsAffected =  ps.executeUpdate();
			
		} 
		
		return rowsAffected;
	}

	@Override
	public User getUser(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int editUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
