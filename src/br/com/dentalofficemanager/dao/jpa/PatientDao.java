package br.com.dentalofficemanager.dao.jpa;

import java.util.List;

import br.com.dentalofficemanager.domain.Patient;

public interface PatientDao {

	void addPatient(Patient patient);
	void updatePatient(Patient patient);
	List<Patient> listPatient();
	List<Patient> searchPatientByFirstName(String query);
	Patient viewPatientInformation(Long id);
}
