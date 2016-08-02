package br.com.dentalofficemanager.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.dentalofficemanager.domain.Appointment;

@Controller
public class AppointmentController {

	@RequestMapping(value = "arrange", method = RequestMethod.GET)
	public String arrangeAppointment(Appointment appointment) {
		return "/appointment/arrange_appointment";
	}
	
}
