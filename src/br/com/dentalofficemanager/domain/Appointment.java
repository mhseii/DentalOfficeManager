package br.com.dentalofficemanager.domain;

import java.io.Serializable;
import java.util.Calendar;

public class Appointment implements Serializable{

	private static final long serialVersionUID = 9134892603213090997L;

	private long id;
	private Calendar treatmentStartDate;
	private Calendar treatmentEndDate;
	private Patient patient;
	private Proceedings proceedings;
	
	public Calendar getTreatmentStartDate() {
		return treatmentStartDate;
	}
	public void setTreatmentStartDate(Calendar treatmentStartDate) {
		this.treatmentStartDate = treatmentStartDate;
	}
	public Calendar getTreatmentEndDate() {
		return treatmentEndDate;
	}
	public void setTreatmentEndDate(Calendar treatmentEndDate) {
		this.treatmentEndDate = treatmentEndDate;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Proceedings getProceedings() {
		return proceedings;
	}
	public void setProceedings(Proceedings proceedings) {
		this.proceedings = proceedings;
	}
	public long getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "Appointment [id=" + id + ", treatmentStartDate=" + treatmentStartDate + ", treatmentEndDate="
				+ treatmentEndDate + ", patient=" + patient + ", proceedings=" + proceedings + "]";
	}
	
}
