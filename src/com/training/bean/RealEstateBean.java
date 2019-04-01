package com.training.bean;

public class RealEstateBean {
	private String username;
	private String email;
	private String firstname;
	private String lastname;
	private String website;
	private String password;
	private String role;

	public RealEstateBean() {
	}

	public RealEstateBean(String username, String email, String firstname, String lastname, String website,
			String password, String role) {
		super();
		this.username = username;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.website = website;
		this.password = password;
		this.role = role;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstname;
	}

	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}

	public String getLastName() {
		return lastname;
	}

	public void setLastName(String lastname) {
		this.lastname = lastname;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "RealEstateBean [userName=" + username + ",email=" + email + ",FirstName=" + firstname + "Lastname="
				+ lastname + ",Website=" + website + "Password=" + password + ",Role=" + role + "]";
	}

}
