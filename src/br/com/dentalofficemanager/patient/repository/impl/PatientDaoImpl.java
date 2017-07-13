package br.com.dentalofficemanager.patient.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.dentalofficemanager.patient.model.Patient;
import br.com.dentalofficemanager.patient.repository.PatientDao;

@Repository
public class PatientDaoImpl implements PatientDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Long save(Patient patient) {
		em.persist(patient);
		em.flush();
		return patient.getId();
	}

	@Override
	public void update(Patient patient) {
		em.merge(patient);
	}

	@Override
	public List<Patient> findAll() {
		return em.createQuery("SELECT p FROM Patient p", Patient.class).getResultList();
	}

	@Override
	public Patient findPatientById(Long id) {
		return em.find(Patient.class, id);
	}

	@Override
	public Patient findPatientBySSN(String ssn, Long ssnType) throws PersistenceException{
		TypedQuery<Patient> query = em.createQuery("SELECT p FROM Patient p WHERE p.ssnId = :ssnId and p.ssnType = :ssnType", Patient.class);
		query.setParameter("ssnId", ssn);
		query.setParameter("ssnType", ssnType);
		
		Patient p = null;
		try {
			p = query.getSingleResult();
		} catch(PersistenceException ex) {
			if(ex instanceof NoResultException) {
				return p;
			}
		}
		return p;
	}
	
	@Override
	public List<Patient> findPatientByFirstName(String firstNameSubStr) {
		if(null == firstNameSubStr) {
			return null;
		}
		TypedQuery<Patient> query = em.createQuery("SELECT p FROM Patient p WHERE lower(p.firstName) LIKE :firstName", Patient.class);
		return query.setParameter("firstName", String.format("%%%s%%", firstNameSubStr.toLowerCase())).getResultList();
	}

	@Override
	public List<Patient> findPatientByLastName(String lastNameSubStr) {
		if(null == lastNameSubStr) {
			return null;
		}
		TypedQuery<Patient> query = em.createQuery("SELECT p FROM Patient p WHERE lower(p.lastName) LIKE :lastName", Patient.class);
		return query.setParameter("lastName", String.format("%%%s%%", lastNameSubStr.toLowerCase())).getResultList();
	}
}
