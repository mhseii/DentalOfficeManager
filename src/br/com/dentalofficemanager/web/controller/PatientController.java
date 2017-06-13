package br.com.dentalofficemanager.web.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.dentalofficemanager.dao.jpa.PatientDao;
import br.com.dentalofficemanager.model.Address;
import br.com.dentalofficemanager.model.Patient;
import br.com.dentalofficemanager.service.PatientService;
import br.com.dentalofficemanager.web.DTO.PatientDTO;

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
	
	@Autowired
	protected PatientService patientService; 
	
	private static Logger log = LoggerFactory.getLogger(PatientController.class);

	@RequestMapping(value = URL_REGISTER_PATIENT, method = RequestMethod.GET)
	public String registerPatient() {
		return JSP_REGISTER_PATIENT;
	}

	@RequestMapping(value = PATIENT_REGISTRATION_FORM, method = RequestMethod.POST)
	public String patientRegistrationForm(@RequestBody PatientDTO patientDTO) {
		log.info("PatientDTO: " + patientDTO.toString());

		Patient patient = new Patient();
		patient.setFirstName(patientDTO.getFirstName());
		patient.setLastName(patientDTO.getLastName());
		Calendar bday = Calendar.getInstance();
		bday.setTime(new Date(patientDTO.getBirthDate().getTimeInMillis()));
		patient.setBirthDate(bday);
		patient.setGender("MALE");
		patient.setSsnId(patientDTO.getCpf());
		patient.setPhoneNumber(patientDTO.getPhoneNumber());
		patient.setCellPhoneNumber(patientDTO.getCellPhoneNumber());
		patient.setEmail(patientDTO.getEmail());

		Set<Address> addressSet = new HashSet<Address>();
		
		Address address = new Address();
		address.setMainAddress(true);
		address.setStreet(patientDTO.getAddressStreet());
		address.setAdditionalAddressInfo(patientDTO.getAddressAdditionalInfo());
		address.setNumber(patientDTO.getAddressNumber());
		address.setDistrict(patientDTO.getAddressDistrict());
		address.setCity(patientDTO.getAddressCity());
		address.setState(patientDTO.getAddressState());
		address.setZipcode(patientDTO.getAddressZipCode());
		address.setCountry("Brazil");
		address.setPatient(patient);
		addressSet.add(address);
		patient.setAddress(addressSet);
		patientService.register(patient);

		return "redirect:list_patients";
	}
	
	@RequestMapping(value = URL_ADDITIONAL_INFO, method = RequestMethod.GET)
	public String additionalPatientInfo(){
		
		return "arrange";
	}

	@RequestMapping(value = URL_LIST_PATIENT, method = RequestMethod.GET)
	public String listPatients(Model model) {
		model.addAttribute("patients", dao.findAll());
		return JSP_LIST_PATIENTS;
	}

	@RequestMapping(value = URL_SEARCH_PATIENT, method = RequestMethod.GET)
	@ResponseBody
	public List<Patient> searchPatient(@RequestParam(value = "term") String query) {
		return dao.findPatientByFirstName(query);
	}

	@RequestMapping(value = URL_VIEW_PATIENT, method = RequestMethod.GET)
	public String viewPatientInformation(@RequestParam Long id, Model model) {
		Patient p = dao.findPatientById(id);
		model.addAttribute("patient", p);
		return JSP_VIEW_PATIENT;
	}

	@RequestMapping(value = "select_patient", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String selectPatient(@RequestParam String search) {

		String responseMessage;

		if (search != null && !search.isEmpty()) {
			List<Patient> matchingPatients = dao.findPatientByFirstName(search);
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
				responseMessage = "{\"success\":false,\"msg\":\"no patient with name " + search + " was found!\"}";
			}
		} else {
			responseMessage = "{\"success\":false,\"msg\":\"request param is null!\"}";
		}
		return responseMessage;
	}

}
