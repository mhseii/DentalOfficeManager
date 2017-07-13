package br.com.dentalofficemanager.user.web.controller;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.dentalofficemanager.user.model.User;
import br.com.dentalofficemanager.user.model.DTO.UserDTO;
import br.com.dentalofficemanager.user.service.RoleService;
import br.com.dentalofficemanager.user.service.UserService;

@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	protected UserService usrService;
	
	@Autowired
	protected RoleService rService;
	
	@Autowired
	protected UserDetailsService userDetailsService;
	
	@Autowired
	protected AuthenticationManager authenticationManager;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@RequestMapping(value = "user/register", method = RequestMethod.GET)
	public String registerUser(Model model) {
		return "user/register_user";
	}
	
	@RequestMapping(value = "user/registration_form", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String registerUserForm(@RequestBody UserDTO userDto) throws ParseException { 
		logger.info(userDto.toString());

		User user = new User();
		user.setUsername(userDto.getEmail());
		user.setEmail(userDto.getEmail());
		if(userDto.getPassword().equals(userDto.getPasswordConfirmation())) {
			user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
		} else {
			return "user/list";
		}
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setDateOfBirth(userDto.getDateOfBirth());
		user.setGender(userDto.getGender());
		user.setPhoneNumber(userDto.getPhoneNumber());
		user.setMobileNumber(userDto.getMobileNumber());
		
		Set<Long> roles = new HashSet<Long>();
		for(Object roleId : userDto.getUserRoles().values()) {
			roles.add(Long.parseLong((String)roleId));
		}
		user.setRoles(rService.getRolesById(roles));
		
		usrService.register(user);
		return "user/list";
	}
	
	@RequestMapping(value = "user/list", method = RequestMethod.GET)
	public String userList(Model model) {
		//TODO get user list and pass as json through another controller
		model.addAttribute("users", usrService.findAllUsers());
		return "user/users_list";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "sign_in", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String signIn(@RequestBody UserDTO userDto) {
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(userDto.getUsername());
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				userDetails, userDto.getPassword(), userDetails.getAuthorities());
		
		try {
			authenticationManager.authenticate(usernamePasswordAuthenticationToken);
		} catch(BadCredentialsException e) {
			return ajaxResponseFormatter(false, "login", e.getMessage());
		}
		
		if (usernamePasswordAuthenticationToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            logger.info(String.format("successfully logged in as: %s", userDto.getUsername()));
			return ajaxResponseFormatter(true, "home", null);
		} else {
			return ajaxResponseFormatter(false, "login", null);
		}
	}
	
	@RequestMapping(value = "recover_password", method = RequestMethod.GET)
	public String recoverPassword(Model model) {
		model.addAttribute("recoverPassword", "inline-block");
		return "user/login";
	}
	
	private String ajaxResponseFormatter(boolean success, String redirectUrl, String msg) {
		return String.format("{\"success\": %b,\"redirectURL\":\"%s\", \"msg\":\"%s\"}", success, redirectUrl, msg);
	}
	
}
