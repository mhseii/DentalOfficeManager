package br.com.dentalofficemanager.patient.service;

import java.util.Set;

import br.com.dentalofficemanager.patient.model.Patient;

public interface PatientService {
	
	boolean register(Patient p);
	Patient findById(Long id);
	Set<Patient> findPatient(String s);
	Set<Patient> findAllPatients();

}
