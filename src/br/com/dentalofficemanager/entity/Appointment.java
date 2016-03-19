package br.com.dentalofficemanager.entity;

import java.util.Calendar;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

public class Appointment {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar appointmentDate;
	@DateTimeFormat(pattern="hh:mm:ss.SSS")
	private Calendar appointmentTime;
	private Patient patient;
	private Dentist dentist;
	private Boolean isAppointmentFulfilled;
	
	//Lista de Procedimentos
		// id
		// nome do procedimento
		// dente do procedimento
			// limpeza / clareamento /
		
	

	
	public Calendar getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(Calendar appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public Calendar getAppointmentTime() {
		return appointmentTime;
	}
	public void setAppointmentTime(Calendar appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Dentist getDentist() {
		return dentist;
	}
	public void setDentist(Dentist dentist) {
		this.dentist = dentist;
	}
	public Boolean getIsAppointmentFulfilled() {
		return isAppointmentFulfilled;
	}
	public void setIsAppointmentFulfilled(Boolean isAppointmentFulfilled) {
		this.isAppointmentFulfilled = isAppointmentFulfilled;
	}
	public Long getId() {
		return id;
	}
}
