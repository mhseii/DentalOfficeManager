package br.com.dentalofficemanager.patient.service.impl;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.dentalofficemanager.patient.jpa.PatientDao;
import br.com.dentalofficemanager.patient.model.Patient;
import br.com.dentalofficemanager.patient.model.enums.SocialSecurityTypeEnum;
import br.com.dentalofficemanager.patient.service.PatientService;
import br.com.dentalofficemanager.patient.utils.PatientValidation;
import br.com.dentalofficemanager.patient.web.controller.PatientConstants;

@Service
public class PatientServiceImpl implements PatientService, PatientConstants {
	
	@Autowired
	protected PatientDao patient;
	
	@Override
	@Transactional
	public boolean register(Patient p) throws PersistenceException {
		boolean result = false;
		boolean isValidSSN = PatientValidation.ssnValidator(p.getSsnId(), SocialSecurityTypeEnum.getEnumFromCode(p.getSsnType()));
		boolean isAlreadyRegistered = patient.findPatientBySSN(p.getSsnId(), p.getSsnType()) == null ? false : true;
		if(!isAlreadyRegistered && isValidSSN) {
			Long patientId = patient.addPatient(p);
			if(null != patientId) {
				result = true;
			}
		}
		return result;
	}
	
	@Override
	@Transactional
	public Patient getPatient(Long id) {
		return patient.findPatientById(id);
	}

	@Override
	@Transactional
	public Set<Patient> search(String s) {
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
	public Set<Patient> getPatientSet() {
		Set<Patient> patients = new HashSet<Patient>(patient.findAll());
		return patients;
	}
}
