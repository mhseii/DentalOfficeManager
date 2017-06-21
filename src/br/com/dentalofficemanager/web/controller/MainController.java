package br.com.dentalofficemanager.web.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.dentalofficemanager.service.CommonService;

@Controller
public class MainController {
	
	@Autowired
	protected CommonService service;
	

	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("countries", service.getCountries());
		return "index";
	}
	
	
	/*
	 * Retrieves federal units according to the country
	 * */
	@RequestMapping(value = "retrieveCountryStates", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Set<String> retrieveCountryStates() {
		Set<String> states = service.getStates("BR"); 
		return states;
	}
}
