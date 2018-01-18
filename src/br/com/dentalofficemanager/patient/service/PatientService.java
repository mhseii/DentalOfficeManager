package br.com.dentalofficemanager.patient.service;

import java.util.Set;

import br.com.dentalofficemanager.common.exceptions.InvalidSocialSecurityNumberException;
import br.com.dentalofficemanager.patient.model.Patient;

public interface PatientService {
	
	Long register(Patient p) throws InvalidSocialSecurityNumberException ;
	void update(Patient p); 
	Patient getPatientById(Long id);
	Patient getPatientBySSN(String ssn, Long ssnType); 
	Set<Patient> searchPatient(String s);
	Set<Patient> getPatientList();

}
