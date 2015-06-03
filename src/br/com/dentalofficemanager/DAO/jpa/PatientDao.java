package br.com.dentalofficemanager.DAO.jpa;

import java.util.List;

import br.com.dentalofficemanager.entity.Patient;

public interface PatientDao {

	void addPatient(Patient patient);
	void updatePatient(Patient patient);
	List<Patient> listPatient();
	List<Patient> searchPatient(String query);
	Patient searchPatientId(Long id);
}
