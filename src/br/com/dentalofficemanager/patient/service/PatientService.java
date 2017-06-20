package br.com.dentalofficemanager.patient.service;

import java.util.Set;

import br.com.dentalofficemanager.patient.model.Patient;

public interface PatientService {
	
	boolean register(Patient p);
	Patient getPatient(Long id);
	Set<Patient> search(String s);
	Set<Patient> getPatientSet();

}
