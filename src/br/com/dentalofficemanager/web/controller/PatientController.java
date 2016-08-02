package br.com.dentalofficemanager.web.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.dentalofficemanager.dao.jpa.PatientDao;
import br.com.dentalofficemanager.domain.Address;
import br.com.dentalofficemanager.domain.Patient;
import br.com.dentalofficemanager.web.DTO.PatientDTO;

@Transactional
@Controller
public class PatientController {

	// CONTORLLER URL CONSTANTS
	private static final String URL_REGISTER_PATIENT = "register_patient";
	private static final String URL_SEARCH_PATIENT = "search_patient";
	private static final String URL_VIEW_PATIENT = "view_patient";
	private static final String URL_LIST_PATIENT = "list_patients";
	private static final String URL_ADDITIONAL_INFO = "additional_info";
	// JSP URLs
	private static final String JSP_REGISTER_PATIENT = "/patient/register_patient";
	private static final String JSP_VIEW_PATIENT = "/patient/view_patient";
	private static final String JSP_LIST_PATIENTS = "/patient/list_patients";
	// FORM CONSTANTS
	private static final String PATIENT_REGISTRATION_FORM = "patientRegistrationForm";

	@Autowired
	protected PatientDao dao;
	private static Logger log = LoggerFactory.getLogger(PatientController.class);

	// private JdbcPatientDao dao;
	// Injection of Dao through Spring DI 
	// @Autowired
	// public PatientController(JdbcPatientDao dao) {
	// 	this.dao = dao;
	// }

	@RequestMapping(value = URL_REGISTER_PATIENT, method = RequestMethod.GET)
	public String registerPatient() {
		return JSP_REGISTER_PATIENT;
	}

	@RequestMapping(value = PATIENT_REGISTRATION_FORM, method = RequestMethod.POST)
	public String patientRegistrationForm(PatientDTO patientDTO) {
		log.info("PatientDTO: " + patientDTO.toString());

		Patient patient = new Patient();
		patient.setFirstName(patientDTO.getFirstName());
		patient.setLastName(patientDTO.getLastName());
		// setting bday
		Calendar bday = Calendar.getInstance();
		bday.setTime(new Date(patientDTO.getBirthDate().getTimeInMillis()));
		patient.setBirthDate(bday);

		patient.setCpf(patientDTO.getCpf());
		patient.setPhoneNumber(patientDTO.getPhoneNumber());
		patient.setCellPhoneNumber(patientDTO.getCellPhoneNumber());
		patient.setEmail(patientDTO.getEmail());

		// fill address object to be set on patient
		Address address = new Address();
		address.setStreet(patientDTO.getAddressStreet());
		address.setAdditionalAddressInfo(patientDTO.getAddressAdditionalInfo());
		address.setNumber(patientDTO.getAddressNumber());
		address.setDistrict(patientDTO.getAddressDistrict());
		address.setCity(patientDTO.getAddressCity());
		address.setState(patientDTO.getAddressState());
		address.setZipcode(patientDTO.getAddressZipCode());
		patient.setAddress(address);
		address.setPatient(patient);

		dao.addPatient(patient);

		// TODO: redirect to page which user list proceedings
		// return "redirect:list_patients";
		return "arrange";
	}
	
	@RequestMapping(value = URL_ADDITIONAL_INFO, method = RequestMethod.GET)
	public String additionalPatientInfo(){
		
		return "arrange";
	}

	@RequestMapping(value = URL_LIST_PATIENT, method = RequestMethod.GET)
	public String listPatients(Model model) {
		model.addAttribute("patients", dao.listPatient());
		return JSP_LIST_PATIENTS;
	}

	@RequestMapping(value = URL_SEARCH_PATIENT, method = RequestMethod.GET)
	@ResponseBody
	public List<Patient> searchPatientByFirstName(@RequestParam(value = "term") String query) {
		List<Patient> matchingPatients = dao.searchPatientByFirstName(query);
		return matchingPatients;
	}

	@RequestMapping(value = URL_VIEW_PATIENT, method = RequestMethod.GET)
	public String viewPatientInformation(Long id, Model model) {
		model.addAttribute("patient", dao.viewPatientInformation(id));
		return JSP_VIEW_PATIENT;
	}

	@RequestMapping(value = "select_patient", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String selectPatient(@RequestBody String patientName) {

		String responseMessage;

		if (patientName != null) {
			List<Patient> matchingPatients = dao.searchPatientByFirstName(patientName);
			StringBuffer jsonPatientList = new StringBuffer();
			if (!matchingPatients.isEmpty()) {
				jsonPatientList.append("\"patient\":[");
				for (Patient p : matchingPatients) {
					jsonPatientList.append(p.toString() + ",");
				}
				jsonPatientList.deleteCharAt(jsonPatientList.lastIndexOf(","));
				jsonPatientList.append("]");
				responseMessage = "{\"success\":true," + jsonPatientList + "}";
			} else {
				responseMessage = "{\"success\":false,\"msg\":\"no patient with name " + patientName + " was found!\"}";
			}
		} else {
			responseMessage = "{\"success\":false,\"msg\":\"request param is null!\"}";
		}
		return responseMessage;
	}

}
