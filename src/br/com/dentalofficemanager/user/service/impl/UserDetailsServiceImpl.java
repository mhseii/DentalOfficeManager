package br.com.dentalofficemanager.user.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import br.com.dentalofficemanager.user.model.Role;
import br.com.dentalofficemanager.user.model.User;
import br.com.dentalofficemanager.user.repository.UserDao;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	/**
	 * provides user's role to spring-security.xml
	 */

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUsername(username);
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		for(Role r : user.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(r.getRole()));
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				grantedAuthorities);
	}

}