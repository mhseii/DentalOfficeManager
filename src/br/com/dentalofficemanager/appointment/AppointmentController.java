package br.com.dentalofficemanager.appointment;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/appointment/")
public class AppointmentController {

	
	@RequestMapping(value = "arrange")
	public String arrange(@RequestBody Appointment appointment) {
		return null;
	}
	
}
