package br.com.dentalofficemanager.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.dentalofficemanager.DAO.JdbcPatientDao;
import br.com.dentalofficemanager.entity.Patient;

@Controller
public class PatientController {
	private JdbcPatientDao dao;
	
	@Autowired
	public PatientController(JdbcPatientDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(value = "patient_management", method = RequestMethod.GET)
	public String managePatients() {
		return "/patient/management";
	}
	
	@RequestMapping(value = "register_patient", method = RequestMethod.GET)
	public String registerPatient() {
		return "/patient/register";
	}
	
	@RequestMapping(value = "patientRegistrationForm", method = RequestMethod.POST)
	public String patientRegistrationForm(@Valid Patient p) {
		dao.addPatient(p);
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
