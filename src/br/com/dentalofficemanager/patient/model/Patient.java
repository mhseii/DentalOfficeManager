package br.com.dentalofficemanager.patient.model;

import java.io.Serializable;
import java.text.ParseException;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.dentalofficemanager.common.model.BaseEntity;
import br.com.dentalofficemanager.common.utils.DateFormatUtil;

@Entity
@Table(name = "PATIENT", uniqueConstraints = { 
		@UniqueConstraint(columnNames = "SSN_ID"),
		@UniqueConstraint(columnNames = "EMAIL")})
public class Patient extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -5838919615146544735L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long patientId;
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Calendar dateOfBirth;
	@Column(name = "SSN_TYPE")
	private long ssnType;
	@NotNull
	@Column(name = "SSN_ID")
	private String ssnId;
	@NotNull
	private String gender;
	@NotNull
	private String phoneNumber;
	@NotNull
	private String mobileNumber;
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
	@JsonIgnore
	private Set<Address> address;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "patient")
	@JsonIgnore
	private Set<Anamnesis> anamnesis;

	public Patient() {
	}

	public Patient(long patientId, String firstName, String lastName, Calendar dateOfBirth, String ssnId, String gender,
			String phoneNumber, String mobileNumber, String email, Set<Address> address) {
		super();
		this.patientId = patientId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.ssnId = ssnId;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.mobileNumber = mobileNumber;
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

	public Calendar getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(Calendar birthDate) {
		this.dateOfBirth = birthDate;
	}

	public void setDateOfBirth(String birthDate, String dateFormat) throws ParseException {
		setDateOfBirth(DateFormatUtil.formatDate(birthDate, dateFormat));
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
	
	public long getSsnType() {
		return ssnType;
	}

	public void setSsnType(String ssnType) {
		for (SocialSecurityTypeEnum type : SocialSecurityTypeEnum.values()) {
			if (type.getName().equalsIgnoreCase(ssnType)) {
				this.ssnType = type.getCode();
				break;
			}
		}
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
				.append(", lastName=").append(lastName).append(", dateOfBirth=").append(dateOfBirth != null ? dateOfBirth.getTime() : null)
				.append(", ssnType=").append(ssnType).append(", ssnId=").append(ssnId).append(", gender=")
				.append(gender).append(", phoneNumber=").append(phoneNumber).append(", mobileNumber=")
				.append(mobileNumber).append(", email=").append(email).append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((mobileNumber == null) ? 0 : mobileNumber.hashCode());
		result = prime * result + (int) (patientId ^ (patientId >>> 32));
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((ssnId == null) ? 0 : ssnId.hashCode());
		result = prime * result + (int) (ssnType ^ (ssnType >>> 32));
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
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
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
		if (mobileNumber == null) {
			if (other.mobileNumber != null)
				return false;
		} else if (!mobileNumber.equals(other.mobileNumber))
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
		if (ssnType != other.ssnType)
			return false;
		return true;
	}

}
