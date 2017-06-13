package br.com.dentalofficemanager.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "PATIENT", uniqueConstraints = { 
		@UniqueConstraint(columnNames = "SSN_ID"),
		@UniqueConstraint(columnNames = "EMAIL")})
public class Patient implements Serializable {

	private static final long serialVersionUID = -5838919615146544735L;

	@Id
	@Column(name = "PATIENT_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long patientId;
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Calendar birthDate;
	@NotNull
	@Column(name = "SSN_ID")
	private String ssnId;
	@NotNull
	private String gender;
	@NotNull
	private String phoneNumber;
	@NotNull
	private String cellPhoneNumber;
	@NotNull
	@Column(name = "EMAIL")
	private String email;
	
	/*
	 * @ResponseBody ( through JacksonAPI ) fails to serialize the object, 
	 * because object serialization comes after transaction is closed 
	 * thus use of FetchType.EAGER.
	 * 
	 * ps: other solutions would be load the object and pass it into a DTO,
	 * or map the controller @Transactional ( not a good practice ),
	 * or use Jackson Faster XML (which I tried and could not bring it to work)
	 * 
	 * https://stackoverflow.com/questions/28857396/responsebody-as-a-list-of-objects-500-internal-server-error
	 * 
	 * */
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "patient")
	private Set<Address> address;

	public Patient() {
	}

	public Patient(long patientId, String firstName, String lastName, Calendar birthDate, String ssnId, String gender,
			String phoneNumber, String cellPhoneNumber, String email, Set<Address> address) {
		super();
		this.patientId = patientId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.ssnId = ssnId;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.cellPhoneNumber = cellPhoneNumber;
		this.email = email;
		this.address = address;
	}

	public long getId() {
		return patientId;
	}

	public void setPatientId(long patientId) {
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

	public Calendar getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Calendar birthDate) {
		this.birthDate = birthDate;
	}

	public String getSsnId() {
		return ssnId;
	}

	public void setSsnId(String ssnId) {
		this.ssnId = ssnId;
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

	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Patient [patientId=").append(patientId).append(", firstName=").append(firstName)
				.append(", lastName=").append(lastName).append(", birthDate=").append(birthDate).append(", ssnId=")
				.append(ssnId).append(", gender=").append(gender).append(", phoneNumber=").append(phoneNumber)
				.append(", cellPhoneNumber=").append(cellPhoneNumber).append(", email=").append(email).append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((cellPhoneNumber == null) ? 0 : cellPhoneNumber.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + (int) (patientId ^ (patientId >>> 32));
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((ssnId == null) ? 0 : ssnId.hashCode());
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
		Patient other = (Patient) obj;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (cellPhoneNumber == null) {
			if (other.cellPhoneNumber != null)
				return false;
		} else if (!cellPhoneNumber.equals(other.cellPhoneNumber))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (patientId != other.patientId)
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (ssnId == null) {
			if (other.ssnId != null)
				return false;
		} else if (!ssnId.equals(other.ssnId))
			return false;
		return true;
	}

}
