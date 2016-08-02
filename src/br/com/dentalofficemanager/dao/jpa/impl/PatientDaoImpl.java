package br.com.dentalofficemanager.dao.jpa.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.dentalofficemanager.dao.jpa.PatientDao;
import br.com.dentalofficemanager.domain.Patient;

@Repository
public class PatientDaoImpl implements PatientDao {

	@PersistenceContext
	private EntityManager em;
	
	public void addPatient(Patient patient) {
		em.persist(patient);
	}

	public void updatePatient(Patient patient) {
		em.merge(patient);
	}

	public List<Patient> listPatient() {
		return em.createQuery("SELECT p FROM Patient p", Patient.class).getResultList();
	}

	public List<Patient> searchPatientByFirstName(String patientFirstName) {
		String searchPatientQuery = "SELECT p FROM Patient p WHERE p.firstName LIKE '" + patientFirstName.toLowerCase() + "%'";
		//String searchPatientQuery = "SELECT p FROM Patient p WHERE p.firstName LIKE :patientName";
		return em.createQuery(searchPatientQuery, Patient.class).getResultList();
	}

	public Patient viewPatientInformation(Long id) {
		return em.find(Patient.class, id);
	}

}
