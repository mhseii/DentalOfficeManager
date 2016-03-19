package br.com.dentalofficemanager.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="patient", uniqueConstraints={@UniqueConstraint(columnNames="patient_id")})
public class Patient implements Serializable{

	private static final long serialVersionUID = -5838919615146544735L;
	@Id @Column(name="patient_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long patientId;
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	@NotNull
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Calendar birthDate;
	@NotNull
	private String cpf;
	@NotNull
	private String phoneNumber;
	@NotNull
	private String cellPhoneNumber;
	@NotNull
	private String email;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) // unidirectional relationship
	@PrimaryKeyJoinColumn // join the primary table of an entity subclass in the JOINED mapping strategy to the primary table 
	private Address address;
	
	public Patient() {
	}
	
	public Patient(String firstName, String lastName, Calendar birthDate,
			String cpf, String phoneNumber, String cellPhoneNumber, String email, Address address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.cpf = cpf;
		this.phoneNumber = phoneNumber;
		this.cellPhoneNumber = cellPhoneNumber;
		this.email = email;
		this.address = address;
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

	public Calendar getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Calendar birthDate) {
		this.birthDate = birthDate;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCellPhoneNumber() {
		return cellPhoneNumber;
	}

	public void setCellPhoneNumber(String cellPhoneNumber) {
		this.cellPhoneNumber = cellPhoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	// hibernate demands the method to be called getId()
	public long getId() {
		return patientId;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", birthDate=" + birthDate
				+ ", cpf=" + cpf + ", phoneNumber=" + phoneNumber
				+ ", cellPhoneNumber=" + cellPhoneNumber + ", email=" + email
				+ "]";
	}
	
}
