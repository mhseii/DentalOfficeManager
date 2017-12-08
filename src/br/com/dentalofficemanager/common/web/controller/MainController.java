package br.com.dentalofficemanager.common.web.controller;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.dentalofficemanager.common.service.CommonService;

@Controller
public class MainController {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	@Autowired
	protected CommonService service;

	@RequestMapping(value = "home",
			method = RequestMethod.GET)
	public String main(Model model, HttpServletRequest request) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			logger.info(auth.getName());
			logger.info(auth.getAuthorities().toString());
		}

		return "index";
	}

	@RequestMapping(value = "retrieveCountryStates", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Set<String> retrieveCountryStates() {
		Set<String> states = service.getStates("BR");
		return states;
	}

	@RequestMapping(value = "retrieveAddressData", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String retrieveAddressData(@RequestParam("zipCode") String zipCode) {
		String addressData = service.getAddressData(zipCode);
		return addressData;
	}
}
