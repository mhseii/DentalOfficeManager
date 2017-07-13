package br.com.dentalofficemanager.patient.web.controller;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.dentalofficemanager.common.constants.SystemConstants;
import br.com.dentalofficemanager.common.exceptions.InvalidSocialSecurityNumberException;
import br.com.dentalofficemanager.patient.constants.PatientConstants;
import br.com.dentalofficemanager.patient.model.Address;
import br.com.dentalofficemanager.patient.model.Patient;
import br.com.dentalofficemanager.patient.model.DTO.PatientDTO;
import br.com.dentalofficemanager.patient.service.PatientService;

@Controller
public class PatientController implements SystemConstants, PatientConstants {

	private static final Logger logger = LoggerFactory.getLogger(PatientController.class);
	
	@Autowired
	protected PatientService patientService;

	@RequestMapping(value = URL_REGISTER_PATIENT, method = RequestMethod.GET)
	public String registerPatient() {
		return JSP_REGISTER_PATIENT;
	}

	@RequestMapping(value = PATIENT_REGISTRATION_FORM, method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String patientRegistrationForm(@RequestBody PatientDTO patientDTO) throws ParseException {
		
		final String methodName = "patientRegistrationForm";
		logger.info(String.format("@%s METHOD START", methodName));
		logger.info("RequestBody: " + patientDTO.toString());

		boolean success = false;
		String redirectUrl = null;
		String msg = null;
		
		try {
			Patient patient = new Patient();
			patient.setFirstName(patientDTO.getFirstName());
			patient.setLastName(patientDTO.getLastName());
			patient.setDateOfBirth(patientDTO.getDateOfBirth(), BR_DATE_FORMAT);
			patient.setGender(patientDTO.getGender());
			patient.setSsnType(patientDTO.getSsnType());
			patient.setSsnId(patientDTO.getSsn(),patientDTO.getSsnType());
			patient.setPhoneNumber(patientDTO.getPhoneNumber());
			patient.setMobileNumber(patientDTO.getMobileNumber());
			patient.setEmail(patientDTO.getEmail());
	
			Address address = new Address();
			address.setMainAddress(true);
			address.setStreet(patientDTO.getAddressStreet());
			address.setComplements(patientDTO.getAddressComplements());
			address.setNumber(patientDTO.getAddressNumber());
			address.setDistrict(patientDTO.getAddressDistrict());
			address.setCity(patientDTO.getAddressCity());
			address.setState(patientDTO.getAddressState());
			address.setZipcode(patientDTO.getAddressZipCode());
			address.setCountry(patientDTO.getAddressCountry());
			address.setPatient(patient);
			
			Set<Address> addressSet = new HashSet<Address>();
			addressSet.add(address);
			patient.setAddress(addressSet);
			
			success = patientService.register(patient);
			if(success) {
				redirectUrl = REDIRECT_URL_ANAMNESIS;
				msg = "paciente " + patientDTO.getFirstName() + " " + patientDTO.getLastName() + " registrado com sucesso!";
			}
		} catch(InvalidSocialSecurityNumberException ex) {
			success = false;
			msg = ex.getMessage();
		}

		logger.info(String.format("@%s METHOD END", methodName));
		return ajaxResponseFormatter(success, redirectUrl, msg);
	}

	@RequestMapping(value = URL_LIST_PATIENT, method = RequestMethod.GET)
	public String listPatients(Model model) {
		//TODO get patient list and pass as json through another controller
		model.addAttribute("patients", patientService.findAllPatients());
		return JSP_LIST_PATIENTS;
	}

	@RequestMapping(value = URL_SEARCH_PATIENT, method = RequestMethod.GET)
	@ResponseBody
	public Set<Patient> searchPatient(@RequestParam(value = "term") String query) {
		Set<Patient> patients = patientService.findPatient(query);
		logger.info(String.format("patients found with %s : %s", query, patients.toString()));
		return patients; 
	}

	@RequestMapping(value = URL_VIEW_PATIENT, method = RequestMethod.GET)
	public String viewPatientInformation(@RequestParam Long id, Model model) {
		model.addAttribute("patient", patientService.findById(id));
		return JSP_VIEW_PATIENT;
	}

	private String ajaxResponseFormatter(boolean success, String redirectUrl, String msg) {
		return String.format("{\"success\": %b,\"redirectURL\":\"%s\", \"msg\":\"%s\"}", success, redirectUrl, msg);
	}
	
}
