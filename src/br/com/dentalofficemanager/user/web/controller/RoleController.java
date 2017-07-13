package br.com.dentalofficemanager.user.web.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.dentalofficemanager.user.model.Role;
import br.com.dentalofficemanager.user.service.RoleService;

@Controller
public class RoleController {
	
	@Autowired
	protected RoleService service;
	
	@RequestMapping(value = "role/list", method = RequestMethod.GET)
	@ResponseBody
	public Set<Role> getRoles() {
		return service.getRoles(); 
	}

}
