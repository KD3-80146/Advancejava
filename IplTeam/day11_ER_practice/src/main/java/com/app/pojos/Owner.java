package com.app.pojos;

import javax.persistence.*;

@Entity
public class Owner extends BaseEntity {
	@Column(name="first_name",length = 40)
	private String firstName;
	@Column(name="last_name",length = 40)
	private String lastName;
	@Column(length = 40)
	private String email;
	
	
	
	public Owner() {
		super();
	}
	public Owner(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Owner [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
	

	
	
	
}
