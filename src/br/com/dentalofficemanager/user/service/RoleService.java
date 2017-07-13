package br.com.dentalofficemanager.user.service;

import java.util.Set;

import br.com.dentalofficemanager.user.model.Role;

public interface RoleService {
	public Set<Role> getRoles();
	public Set<Role> getRolesById(Set<Long> ids);
}
