package br.com.dentalofficemanager.patient.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "address")
public class Address implements Serializable {

	private static final long serialVersionUID = -2381570458534365590L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long addressId;
	@NotNull
	private boolean isMainAddress;
	@NotNull
	private String street;
	@NotNull
	private String district;
	@NotNull
	private String city;
	@NotNull
	private String state;
	@NotNull
	private String zipcode;
	@NotNull
	@Column(name = "ADDRESS_NUMBER")
	private String number;
	@NotNull
	private String country;
	private String complements;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "PATIENT_ID", nullable = false)
	@JsonIgnore
	private Patient patient;

	public Address() {
	}

	public Address(long addressId, boolean isMainAddress, String street, String district, String city, String state,
			String zipcode, String number, String country, String complements, Patient patient) {
		super();
		this.addressId = addressId;
		this.isMainAddress = isMainAddress;
		this.street = street;
		this.district = district;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.number = number;
		this.country = country;
		this.complements = complements;
		this.patient = patient;
	}

	public long getId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public boolean isMainAddress() {
		return isMainAddress;
	}

	public void setMainAddress(boolean isMainAddress) {
		this.isMainAddress = isMainAddress;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getComplements() {
		return complements;
	}

	public void setComplements(String complements) {
		this.complements = complements;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Address [addressId=").append(addressId).append(", isMainAddress=").append(isMainAddress)
				.append(", street=").append(street).append(", district=").append(district).append(", city=")
				.append(city).append(", state=").append(state).append(", zipcode=").append(zipcode).append(", number=")
				.append(number).append(", country=").append(country).append(", complements=")
				.append(complements).append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((complements == null) ? 0 : complements.hashCode());
		result = prime * result + (int) (addressId ^ (addressId >>> 32));
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((district == null) ? 0 : district.hashCode());
		result = prime * result + (isMainAddress ? 1231 : 1237);
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + ((zipcode == null) ? 0 : zipcode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (complements == null) {
			if (other.complements != null)
				return false;
		} else if (!complements.equals(other.complements))
			return false;
		if (addressId != other.addressId)
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (district == null) {
			if (other.district != null)
				return false;
		} else if (!district.equals(other.district))
			return false;
		if (isMainAddress != other.isMainAddress)
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		if (zipcode == null) {
			if (other.zipcode != null)
				return false;
		} else if (!zipcode.equals(other.zipcode))
			return false;
		return true;
	}

}
