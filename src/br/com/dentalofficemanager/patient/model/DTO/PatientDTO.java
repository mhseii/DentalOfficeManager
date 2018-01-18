package br.com.dentalofficemanager.patient.model.DTO;

import java.io.Serializable;

public class PatientDTO implements Serializable {

	private static final long serialVersionUID = 8977910142425749151L;

	private String patientId;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String gender;
	private String ssnType;
	private String ssnId;
	private String phoneNumber;
	private String mobileNumber;
	private String email;
	private String addressId;
	private String addressStreet;
	private String addressComplements;
	private String addressNumber;
	private String addressDistrict;
	private String addressCity;
	private String addressState;
	private String addressZipCode;
	private String addressCountry;

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
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

	public String getSsnType() {
		return ssnType;
	}

	public void setSsnType(String ssnType) {
		this.ssnType = ssnType;
	}

	public String getSsnId() {
		return ssnId;
	}

	public void setSsnId(String ssnId) {
		this.ssnId = ssnId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getAddressStreet() {
		return addressStreet;
	}

	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}

	public String getAddressComplements() {
		return addressComplements;
	}

	public void setAddressComplements(String addressComplements) {
		this.addressComplements = addressComplements;
	}

	public String getAddressNumber() {
		return addressNumber;
	}

	public void setAddressNumber(String addressNumber) {
		this.addressNumber = addressNumber;
	}

	public String getAddressDistrict() {
		return addressDistrict;
	}

	public void setAddressDistrict(String addressDistrict) {
		this.addressDistrict = addressDistrict;
	}

	public String getAddressCity() {
		return addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public String getAddressState() {
		return addressState;
	}

	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}

	public String getAddressZipCode() {
		return addressZipCode;
	}

	public void setAddressZipCode(String addressZipCode) {
		this.addressZipCode = addressZipCode;
	}

	public String getAddressCountry() {
		return addressCountry;
	}

	public void setAddressCountry(String addressCountry) {
		this.addressCountry = addressCountry;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PatientDTO [patientId=").append(patientId).append(", firstName=").append(firstName)
				.append(", lastName=").append(lastName).append(", dateOfBirth=").append(dateOfBirth).append(", gender=")
				.append(gender).append(", ssnType=").append(ssnType).append(", ssnId=").append(ssnId)
				.append(", phoneNumber=").append(phoneNumber).append(", mobileNumber=").append(mobileNumber)
				.append(", email=").append(email).append(", addressId=").append(addressId).append(", addressStreet=")
				.append(addressStreet).append(", addressComplements=").append(addressComplements)
				.append(", addressNumber=").append(addressNumber).append(", addressDistrict=").append(addressDistrict)
				.append(", addressCity=").append(addressCity).append(", addressState=").append(addressState)
				.append(", addressZipCode=").append(addressZipCode).append(", addressCountry=").append(addressCountry)
				.append("]");
		return builder.toString();
	}

}
