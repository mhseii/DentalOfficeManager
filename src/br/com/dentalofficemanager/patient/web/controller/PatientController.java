package br.com.dentalofficemanager.patient.web.controller;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
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
import br.com.dentalofficemanager.patient.model.SocialSecurityTypeEnum;
import br.com.dentalofficemanager.patient.model.DTO.PatientDTO;
import br.com.dentalofficemanager.patient.service.PatientService;

@Controller
@RequestMapping(value = PatientConstants.PATIENT_CONTEXT_PATH)
public class PatientController implements SystemConstants, PatientConstants {

	private static final Logger logger = LoggerFactory.getLogger(PatientController.class);
	
	@Autowired
	protected PatientService patientService;

	@RequestMapping(value = URL_REGISTER_PATIENT, method = RequestMethod.GET)
	public String registerPatient() {
		return JSP_REGISTER_PATIENT;
	}

	@RequestMapping(value = PATIENT_REGISTRATION_FORM, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Patient patientRegistrationForm(@RequestBody PatientDTO patientDTO) throws ParseException {
		
		final String methodName = "patientRegistrationForm";
		logger.info(String.format("@%s METHOD START", methodName));
		logger.info("RequestBody: " + patientDTO.toString());

		Patient patient = new Patient();
		patient.setFirstName(patientDTO.getFirstName());
		patient.setLastName(patientDTO.getLastName());
		patient.setDateOfBirth(patientDTO.getDateOfBirth(), BR_DATE_FORMAT);
		patient.setGender(patientDTO.getGender());
		patient.setSsnType(patientDTO.getSsnType());
		patient.setSsnId(patientDTO.getSsnId());
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
		
		try {
			Long patientId = patientService.register(patient);
			logger.info(String.format("@%s METHOD END", methodName));
			return patientService.getPatientById(patientId);
			
		} catch(InvalidSocialSecurityNumberException ex) {
			logger.error("invalid social security number!", ex);
			return null;
		}
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String updatePatientDetails(@RequestBody PatientDTO patientDTO) {
		final String methodName = "updatePatientDetails";
		logger.info(String.format("@%s METHOD START", methodName));
		logger.info("RequestBody: " + patientDTO.toString());
		
		StringBuilder sb = new StringBuilder();
		if(null != patientDTO) {
			Long ssnType = SocialSecurityTypeEnum.getEnumFromName(patientDTO.getSsnType()).getCode();
			Patient original = patientService.getPatientBySSN(patientDTO.getSsnId(), ssnType);
			if(null != original) {
				if(!original.getPhoneNumber().equalsIgnoreCase(patientDTO.getPhoneNumber())) {
					original.setPhoneNumber(patientDTO.getPhoneNumber());
				}
				if(!original.getMobileNumber().equalsIgnoreCase(patientDTO.getMobileNumber())) {
					original.setMobileNumber(patientDTO.getMobileNumber());
				}
				if(!original.getEmail().equalsIgnoreCase(patientDTO.getEmail())) {
					original.setEmail(patientDTO.getEmail());
				}
				
				Iterator<Address> it = original.getAddress().iterator();
				Set<Address> address = new LinkedHashSet<Address>();
				while(it.hasNext()) {
					Address currentAddress = it.next();
					long addressId = 0L;
					if(null != patientDTO.getAddressId()) {
						addressId = Long.parseLong(patientDTO.getAddressId());
					}
					
					if(currentAddress.getId() == addressId) {
						if(!currentAddress.getStreet().equalsIgnoreCase(patientDTO.getAddressStreet())) {
							currentAddress.setStreet(patientDTO.getAddressStreet());
						}
						if(!currentAddress.getNumber().equalsIgnoreCase(patientDTO.getAddressNumber())) {
							currentAddress.setNumber(patientDTO.getAddressNumber());
						}
						if(!currentAddress.getComplements().equalsIgnoreCase(patientDTO.getAddressComplements())) {
							currentAddress.setComplements(patientDTO.getAddressComplements());
						}
						if(!currentAddress.getDistrict().equalsIgnoreCase(patientDTO.getAddressDistrict())) {
							currentAddress.setDistrict(patientDTO.getAddressDistrict());
						}
						if(!currentAddress.getCity().equalsIgnoreCase(patientDTO.getAddressCity())) {
							currentAddress.setCity(patientDTO.getAddressCity());
						}
						if(!currentAddress.getState().equalsIgnoreCase(patientDTO.getAddressState())) {
							currentAddress.setState(patientDTO.getAddressState());
						}
						if(!currentAddress.getZipcode().equalsIgnoreCase(patientDTO.getAddressZipCode())) {
							currentAddress.setZipcode(patientDTO.getAddressZipCode());
						}
					}
					address.add(currentAddress);
				}
				original.setAddress(address);
				patientService.update(original);
				sb.append("{");
				sb.append("success:").append(true).append(",");
				sb.append("data:").append(original.toString());
				sb.append("}");
			}
		}
		logger.info(String.format("@%s METHOD END", methodName));
		
		return sb.toString(); 
	}
	
	@RequestMapping(value = URL_LIST_PATIENT, method = RequestMethod.GET)
	public String listPatients(Model model) {
		model.addAttribute("patients", patientService.getPatientList());
		return JSP_LIST_PATIENTS;
	}

	@RequestMapping(value = URL_SEARCH_PATIENT, method = RequestMethod.GET)
	@ResponseBody
	public Set<Patient> searchPatient(@RequestParam(value = "term") String query) {
		Set<Patient> patients = patientService.searchPatient(query);
		logger.info(String.format("patients found with %s : %s", query, patients.toString()));
		return patients; 
	}

	@RequestMapping(value = URL_VIEW_PATIENT, method = RequestMethod.GET)
	public String viewPatientInformation(@RequestParam Long id, Model model) {
		model.addAttribute("patient", patientService.getPatientById(id));
		return JSP_VIEW_PATIENT;
	}
	
}
