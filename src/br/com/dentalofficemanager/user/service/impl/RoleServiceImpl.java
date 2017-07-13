package br.com.dentalofficemanager.user.service.impl;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dentalofficemanager.user.model.Role;
import br.com.dentalofficemanager.user.repository.RoleRepository;
import br.com.dentalofficemanager.user.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	protected RoleRepository roleRepository;

	@Override
	@Transactional
	public Set<Role> getRoles() {
		Set<Role> roles = new HashSet<Role>(roleRepository.findAllRoles());
		return roles;
	}

	@Override
	@Transactional
	public Set<Role> getRolesById(Set<Long> ids) {
		Set<Role> roles = new HashSet<Role>(); 
		if(null != ids && ids.isEmpty()) {
			roles.addAll(roleRepository.findRolesByIds(ids));
		}
		return roles;
	}

}
