package br.com.dentalofficemanager.dao.jpa;

import java.util.List;

import br.com.dentalofficemanager.model.Patient;

public interface PatientDao {

	Long addPatient(Patient patient);
	void updatePatient(Patient patient);
	List<Patient> findAll();
	List<Patient> findPatientByFirstName(String query);
	Patient findPatientById(Long id);
}
