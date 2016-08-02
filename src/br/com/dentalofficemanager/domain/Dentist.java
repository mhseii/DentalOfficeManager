package br.com.dentalofficemanager.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class Dentist {

	@Id @Column(name="dentist_id")
	private Long id;
	@NotNull
	private String name;
	@NotNull
	private String lastname;
	@NotNull
	private String certificateNumber;
	@NotNull
	private String specialty;
	private enum workdays{
		SUNDAY, MONDAY, TUESDAY, WEDNESDAY,THURSDAY, FRIDAY, SATURDAY
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getCertificateNumber() {
		return certificateNumber;
	}
	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public Long getId() {
		return id;
	}
		
}
