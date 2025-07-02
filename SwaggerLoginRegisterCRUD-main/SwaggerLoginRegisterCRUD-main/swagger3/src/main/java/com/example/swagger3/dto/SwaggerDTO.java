package com.example.swagger3.dto;

import com.example.swagger3.enumurated.Enums;

public class SwaggerDTO {

	//SwaggerEntity 
	private String firstName;
	private String lastName;
	private String address;
	private long phone;

	//LoginRegister
	private String userName;
	private String email;
	private String password;
	private String phoneNumber;
	private Enums gender;

	public SwaggerDTO() {
	}

	public SwaggerDTO(String firstName, String lastName, String address, long phone) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
	}

	public SwaggerDTO(String userName, String email, String password, String phoneNumber, Enums gender) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Enums getGender() {
		return gender;
	}

	public void setGender(Enums gender) {
		this.gender = gender;
	}

}
