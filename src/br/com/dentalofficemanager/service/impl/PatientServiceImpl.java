package br.com.dentalofficemanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.dentalofficemanager.dao.jpa.PatientDao;
import br.com.dentalofficemanager.model.Patient;
import br.com.dentalofficemanager.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {
	
	@Autowired
	protected PatientDao patient;

	@Override
	@Transactional
	public boolean register(Patient p) {
		boolean result = false;
		Long patientId = patient.addPatient(p);
		if(null != patientId) {
			result = true;
		}
		return result;
	}
	
}
