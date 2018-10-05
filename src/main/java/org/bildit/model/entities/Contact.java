package org.bildit.model.entities;

public class Contact {

	private PersonalInfo personalInfo = new PersonalInfo();
	private Address address = new Address();
	
	public Contact() {
		
	}

	public PersonalInfo getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(PersonalInfo personalInfo) {
		this.personalInfo = personalInfo;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
