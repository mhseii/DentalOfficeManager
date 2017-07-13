package br.com.dentalofficemanager.patient.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.dentalofficemanager.patient.constants.PatientConstants;
import br.com.dentalofficemanager.patient.model.Patient;
import br.com.dentalofficemanager.patient.repository.PatientDao;
import br.com.dentalofficemanager.patient.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService, PatientConstants {
	
	private static Logger LOG = LoggerFactory.getLogger(PatientServiceImpl.class);
	
	@Autowired
	protected PatientDao patient;
	
	@Override
	@Transactional
	public boolean register(Patient p) {
		final String methodName = "register"; 
		LOG.info(String.format("@ %s METHOD START", methodName));
		
		boolean result = false;
		if(null != patient.save(p)) {
			result = true;
		}
	
		LOG.info("patient: " + p.toString());
		LOG.info("patient registration success: " + result);
		LOG.info(String.format("@ %s METHOD END", methodName));
		return result;
	}
	
	@Override
	@Transactional
	public Patient findById(Long id) {
		return patient.findPatientById(id);
	}

	@Override
	@Transactional
	public Set<Patient> findPatient(String s) {
		Set<Patient> firstNameSet = new HashSet<Patient>(patient.findPatientByFirstName(s));
		Set<Patient> lastNameSet = new HashSet<Patient>(patient.findPatientByLastName(s));
		
		if(firstNameSet.size() > lastNameSet.size() && firstNameSet.containsAll(lastNameSet)) {
			return firstNameSet;
		} else if(firstNameSet.size() < lastNameSet.size() && lastNameSet.containsAll(firstNameSet)) {
			return lastNameSet;
		}
		return null;
	}

	@Override
	@Transactional
	public Set<Patient> findAllPatients() {
		Set<Patient> patients = new HashSet<Patient>(patient.findAll());
		return patients;
	}
}
