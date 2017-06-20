package br.com.dentalofficemanager.patient.jpa;

import java.util.List;

import javax.persistence.PersistenceException;

import br.com.dentalofficemanager.patient.model.Patient;

public interface PatientDao {

	Long addPatient(Patient patient);
	void updatePatient(Patient patient);
	List<Patient> findAll();
	Patient findPatientById(Long id);
	Patient findPatientBySSN(String ssn, Long ssnType) throws PersistenceException;
	List<Patient> findPatientByFirstName(String query);
	List<Patient> findPatientByLastName(String query);
}
