package br.com.dentalofficemanager.dao.jpa.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.dentalofficemanager.dao.jpa.PatientDao;
import br.com.dentalofficemanager.model.Patient;

@Repository
public class PatientDaoImpl implements PatientDao {

	@PersistenceContext
	private EntityManager em;

	public Long addPatient(Patient patient) {
		em.persist(patient);
		em.flush();
		return patient.getId();
	}

	public void updatePatient(Patient patient) {
		em.merge(patient);
	}

	public List<Patient> findAll() {
		return em.createQuery("SELECT p FROM Patient p", Patient.class).getResultList();
	}

	public Patient findPatientBySSN(String ssn) {
		TypedQuery<Patient> query = em.createQuery("SELECT p.patient_id FROM Patient p WHERE p.cpf = :cpf", Patient.class);
		return query.setParameter("cpf", ssn).getSingleResult();
	}

	public Patient findPatientById(Long id) {
		return em.find(Patient.class, id);
	}

	public List<Patient> findPatientByFirstName(String firstNameSubStr) {
		if(null == firstNameSubStr) {
			return null;
		}
		TypedQuery<Patient> query = em.createQuery("SELECT p FROM Patient p WHERE lower(p.firstName) LIKE :firstName", Patient.class);
		return query.setParameter("firstName", String.format("%%%s%%", firstNameSubStr.toLowerCase())).getResultList();
	}

	public List<Patient> findPatientByLastName(String lastNameSubStr) {
		if(null == lastNameSubStr) {
			return null;
		}
		TypedQuery<Patient> query = em.createQuery("SELECT p FROM Patient p WHERE lower(p.lastName) LIKE :lastName", Patient.class);
		return query.setParameter("lastName", String.format("%%%s%%", lastNameSubStr.toLowerCase())).getResultList();
	}
}
