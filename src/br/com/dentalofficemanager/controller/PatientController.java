package br.com.dentalofficemanager.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.dentalofficemanager.DAO.jpa.PatientDao;
import br.com.dentalofficemanager.DTO.PatientDTO;
import br.com.dentalofficemanager.entity.Address;
import br.com.dentalofficemanager.entity.Patient;

@Transactional
@Controller
public class PatientController {
	
	@Autowired
	protected PatientDao dao;
	protected static Logger log = Logger.getLogger(PatientController.class);
//	private JdbcPatientDao dao;
	
/*	@Autowired
	public PatientController(JdbcPatientDao dao) {
		this.dao = dao;
	}
*/
	
	@RequestMapping(value = "register_patient", method = RequestMethod.GET)
	public String registerPatient() {
		return "/patient/register";
	}
	
	@RequestMapping(value = "patientRegistrationForm", method = RequestMethod.POST)
	public String patientRegistrationForm(PatientDTO patientDTO) {

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
		
		log.debug("PatientDTO: " + patientDTO);
		
		return "redirect:list_patients";
	}
	
	@RequestMapping(value = "list_patients", method = RequestMethod.GET)
	public String listPatients(Model model) {
		model.addAttribute("patients", dao.listPatient());
		return "/patient/list";
	}
	
	@RequestMapping(value = "searchPatient", method = RequestMethod.GET)
	public @ResponseBody List<Patient> listPatients(@RequestParam(value = "term")String query) {
		List<Patient> matchingPatients = dao.searchPatient(query);
		return matchingPatients;
	}
	
	@RequestMapping(value = "view_patient", method = RequestMethod.GET)
	public String viewPatientContent(Long id, Model model) {
		model.addAttribute("patient", dao.searchPatientId(id));
		return "/patient/view_patient";
	}
	
}
