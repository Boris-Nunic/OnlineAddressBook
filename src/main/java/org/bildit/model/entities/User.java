package org.bildit.model.entities;

public class User {

	private Integer id;
	private PersonalInfo personalInfo = new PersonalInfo();
	private Address address = new Address();
	private String password;
	
	public User() {
		
	}
	
	public User(String email, String password) {
		this.getAddress().setEmail(email);
		this.setPassword(password);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PersonalInfo getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(PersonalInfo peronalInfo) {
		this.personalInfo = peronalInfo;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
