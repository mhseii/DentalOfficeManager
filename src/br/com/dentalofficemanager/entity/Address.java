package br.com.dentalofficemanager.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="address", uniqueConstraints={@UniqueConstraint(columnNames = "patient_id")})
public class Address implements Serializable {
	
	private static final long serialVersionUID = -2381570458534365590L;
	
	@Id	@Column(name="patient_id")
	@GeneratedValue
	@GenericGenerator(name="gen", strategy="foreign", 
	parameters = @Parameter(name="property", value="patient"))
	private long patientId;
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
	private String number;
	private String additionalAddressInfo;
	@OneToOne(mappedBy="address", cascade=CascadeType.ALL) // unidirectional relationship 
	@JsonIgnore private Patient patient; // stop hibernate from infinite recursion

	public Address() {
	}
	
	public Address(String street, String district, String city, String state,
			String zipcode, String number, String additionalAddressInfo) {
		super();
		this.street = street;
		this.district = district;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.number = number;
		this.additionalAddressInfo = additionalAddressInfo;
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
	public String getAdditionalAddressInfo() {
		return additionalAddressInfo;
	}
	public void setAdditionalAddressInfo(String additionalAddressInfo) {
		this.additionalAddressInfo = additionalAddressInfo;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	//hibernate demands the method to be called getId()
	public long getId() {
		return patientId;
	}

	@Override
	public String toString() {
		return "Address [patientId=" + patientId + ", street=" + street
				+ ", district=" + district + ", city=" + city + ", state="
				+ state + ", zipcode=" + zipcode + ", number=" + number
				+ ", additionalAddressInfo=" + additionalAddressInfo
				+ "]";
	}
	
}
