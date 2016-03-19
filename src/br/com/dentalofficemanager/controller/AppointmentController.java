package br.com.dentalofficemanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.dentalofficemanager.entity.Appointment;

@Controller
public class AppointmentController {

	@RequestMapping(value = "arrange_appointment", method = RequestMethod.GET)
	public String arrangeAppointment(Appointment appointment) {
		
		return "redirect:list_patients";
	}
	
}
