package com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE.model;

public class User {
	
	String valid;
	public String getValid() {
		return valid;
	}
	public void setValid(String valid) {
		this.valid = valid;
	}
	int userId;
	String userName;
	String emailId;
	String password;
	String phoneNo;
	String firstName;
	String lastName;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
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

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", emailId=" + emailId + ", password=" + password
				+ ", phoneNo=" + phoneNo + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
