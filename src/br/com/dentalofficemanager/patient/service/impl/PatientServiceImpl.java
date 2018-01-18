package br.com.dentalofficemanager.patient.service.impl;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.dentalofficemanager.common.exceptions.InvalidSocialSecurityNumberException;
import br.com.dentalofficemanager.patient.constants.PatientConstants;
import br.com.dentalofficemanager.patient.model.Patient;
import br.com.dentalofficemanager.patient.model.SocialSecurityTypeEnum;
import br.com.dentalofficemanager.patient.repository.PatientDao;
import br.com.dentalofficemanager.patient.service.PatientService;
import br.com.dentalofficemanager.patient.utils.PatientValidationUtil;

@Service
public class PatientServiceImpl implements PatientService, PatientConstants {

	private static Logger logger = LoggerFactory.getLogger(PatientServiceImpl.class);

	@Autowired
	protected PatientDao patient;

	@Override
	@Transactional
	public Long register(Patient p) throws InvalidSocialSecurityNumberException {
		final String methodName = "register";
		logger.info(String.format("@ %s METHOD START", methodName));
		
		SocialSecurityTypeEnum ssnType = SocialSecurityTypeEnum.getEnumFromCode(p.getSsnType());
		boolean isSsnValid = PatientValidationUtil.ssnValidator(p.getSsnId(), ssnType); 
		if(!isSsnValid) {
			throw new InvalidSocialSecurityNumberException("Patient social security id is invalid !");
		}
		
		Long patientId = patient.save(p);
		logger.info(String.format("@ %s METHOD END", methodName));
		return patientId;
	}
	
	@Override
	@Transactional
	public void update(Patient p) {
		final String methodName = "update";
		logger.info(String.format("@ %s METHOD START", methodName));
		patient.update(p);
		logger.info(String.format("@ %s METHOD END", methodName));
	}

	@Override
	@Transactional
	public Patient getPatientById(Long id) {
		return patient.findPatientById(id);
	}
	
	@Override
	@Transactional
	public Patient getPatientBySSN(String ssn, Long ssnType) {
		Patient p = null;
		try {
			p = patient.findPatientBySSN(ssn, ssnType);
		} catch(PersistenceException ex) {
			if(ex instanceof NoResultException) {
				return p;
			}
		}
		return p;
	}

	@Override
	@Transactional
	public Set<Patient> searchPatient(String s) {
		Set<Patient> firstNameSet = new HashSet<Patient>(patient.findPatientByFirstName(s));
		Set<Patient> lastNameSet = new HashSet<Patient>(patient.findPatientByLastName(s));

		if (firstNameSet.size() > lastNameSet.size() && firstNameSet.containsAll(lastNameSet)) {
			return firstNameSet;
		} else if (firstNameSet.size() < lastNameSet.size() && lastNameSet.containsAll(firstNameSet)) {
			return lastNameSet;
		}
		return null;
	}

	@Override
	@Transactional
	public Set<Patient> getPatientList() {
		Set<Patient> patients = new HashSet<Patient>(patient.findAll());
		return patients;
	}

}
