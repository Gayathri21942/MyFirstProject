package com.example.swagger3.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.swagger3.enumurated.Enums;

@Entity
@Table(name = "LoginAndRegister")
public class LoginRegister {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Employee_Id")
	private Integer id;
	@Column(name = "User_Name")
	private String userName;
	@Column(name = "Email_Id")
	private String email;
	@Column(name = "Password")
	private String password;
	@Column(name = "Phone_Number")
	private String phoneNumber;
	@Enumerated(EnumType.STRING)
	@Column(name = "Sex")
	private Enums gender;

	public LoginRegister() {
	}

	public LoginRegister(Integer id, String userName, String email, String password, String phoneNumber, Enums gender) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Enums getGender() {
		return gender;
	}

	public void setGender(Enums gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
