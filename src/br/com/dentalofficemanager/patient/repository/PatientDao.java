package br.com.dentalofficemanager.patient.repository;

import java.util.List;

import javax.persistence.PersistenceException;

import br.com.dentalofficemanager.patient.model.Patient;

public interface PatientDao {

	Long save(Patient patient);
	void update(Patient patient);
	List<Patient> findAll();
	Patient findPatientById(Long id);
	Patient findPatientBySSN(String ssn, Long ssnType) throws PersistenceException;
	List<Patient> findPatientByFirstName(String query);
	List<Patient> findPatientByLastName(String query);
}
