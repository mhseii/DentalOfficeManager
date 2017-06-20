package br.com.dentalofficemanager.patient.web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.PersistenceException;

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

import br.com.dentalofficemanager.patient.model.Address;
import br.com.dentalofficemanager.patient.model.Patient;
import br.com.dentalofficemanager.patient.model.PatientDTO;
import br.com.dentalofficemanager.patient.model.enums.SocialSecurityTypeEnum;
import br.com.dentalofficemanager.patient.service.PatientService;

@Controller
public class PatientController implements PatientConstants {

	@Autowired
	protected PatientService patientService; 
	
	private static Logger log = LoggerFactory.getLogger(PatientController.class);

	@RequestMapping(value = URL_REGISTER_PATIENT, method = RequestMethod.GET)
	public String registerPatient() {
		return JSP_REGISTER_PATIENT;
	}

	@RequestMapping(value = PATIENT_REGISTRATION_FORM, method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String patientRegistrationForm(@RequestBody PatientDTO patientDTO) throws ParseException {
		log.info("PatientDTO: " + patientDTO.toString());

		Patient patient = new Patient();
		patient.setFirstName(patientDTO.getFirstName());
		patient.setLastName(patientDTO.getLastName());
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar bday = Calendar.getInstance();
		bday.setTime(sdf.parse(patientDTO.getDateOfBirth()));
		patient.setDateOfBirth(bday);
		patient.setGender(patientDTO.getGender());
		for(SocialSecurityTypeEnum ssnType : SocialSecurityTypeEnum.values()) {
			if(ssnType.getName().equalsIgnoreCase(patientDTO.getSsnType())) {
				patient.setSsnType(ssnType.getCode());
				break;
			}
		}
		patient.setSsnId(patientDTO.getSsn());
		patient.setPhoneNumber(patientDTO.getPhoneNumber());
		patient.setMobileNumber(patientDTO.getMobileNumber());
		patient.setEmail(patientDTO.getEmail());

		Set<Address> addressSet = new HashSet<Address>();
		
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
		addressSet.add(address);
		patient.setAddress(addressSet);
		
		boolean success = false;
		String redirectUrl = null;
		String msg = null;
		try {
			success = patientService.register(patient);
			if(success) {
				redirectUrl = REDIRECT_URL_ANAMNESIS;
				msg = "paciente registrado com sucesso!";
			} else {
				redirectUrl = REDIRECT_URL_LIST_PATIENT;
				msg = "o número de cpf !";
			}
		} catch (PersistenceException ex) {
			success = false;
			msg = ex.getMessage();
		}

		return ajaxResponseFormatter(success, redirectUrl, msg);
	}
	
	@RequestMapping(value = URL_LIST_PATIENT, method = RequestMethod.GET)
	public String listPatients(Model model) {
		model.addAttribute("patients", patientService.getPatientSet());
		return JSP_LIST_PATIENTS;
	}

	@RequestMapping(value = URL_SEARCH_PATIENT, method = RequestMethod.GET)
	@ResponseBody
	public Set<Patient> searchPatient(@RequestParam(value = "term") String query) {
		return patientService.search(query);
	}

	@RequestMapping(value = URL_VIEW_PATIENT, method = RequestMethod.GET)
	public String viewPatientInformation(@RequestParam Long id, Model model) {
		model.addAttribute("patient", patientService.getPatient(id));
		return JSP_VIEW_PATIENT;
	}

	private String ajaxResponseFormatter(boolean success, String redirectUrl, String msg) {
		return String.format("{\"success\": %b,\"redirectURL\":\"%s\", \"msg\":\"%s\"}", success, redirectUrl, msg);
	}
	
}
