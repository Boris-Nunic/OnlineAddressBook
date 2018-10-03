package org.bildit.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	public User getUser(String email) {
		
		String query = "SELECT * FROM users WHERE email=?";
		User user = null;
		
		try{
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				user = new User(rs.getString("email"), rs.getString("password"));
				user.setId(rs.getInt("user_id"));
				user.getPeronalInfo().setFirstName(rs.getString("first_name"));
				user.getPeronalInfo().setSurname(rs.getString("surname"));
				user.getPeronalInfo().setPhoneNumber(rs.getString("phone_number"));
				user.getPeronalInfo().setDob(rs.getDate("dob"));
				user.getAddress().setCity(rs.getString("city"));
				user.getAddress().setCountry(rs.getString("country"));
				user.getAddress().setStreetAddress(rs.getString("street_address"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
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
	
	public static void main(String[] args) {
		UserDaoImpl dao = new UserDaoImpl();
		User user = dao.getUser("email");
		System.out.println(user.getAddress().getEmail());
	}
}
