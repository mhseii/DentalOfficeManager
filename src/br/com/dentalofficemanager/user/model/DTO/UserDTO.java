package br.com.dentalofficemanager.user.model.DTO;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTO {

	private String userGroup;
	private String username;
	private String email;
	private String password;
	private String passwordConfirmation;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String gender;
	private String phoneNumber;
	private String mobileNumber;
	@JsonProperty("userRoles")
	private Map<String,Object> userRoles;
	
	public UserDTO() {
		
	}

	public String getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(String userGroup) {
		this.userGroup = userGroup;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
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

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public Map<String,Object> getUserRoles() {
		return this.userRoles;
	}
	
	public void setUserRoles(Map<String, Object> userRoles) {
		this.userRoles = userRoles;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserDTO [userGroup=").append(userGroup).append(", username=").append(username)
				.append(", email=").append(email).append(", password=").append(password)
				.append(", passwordConfirmation=").append(passwordConfirmation).append(", firstName=").append(firstName)
				.append(", lastName=").append(lastName).append(", dateOfBirth=").append(dateOfBirth).append(", gender=")
				.append(gender).append(", phoneNumber=").append(phoneNumber).append(", mobileNumber=")
				.append(mobileNumber).append(", userRoles=").append(userRoles.toString()).append("]");
		return builder.toString();
	}

}
