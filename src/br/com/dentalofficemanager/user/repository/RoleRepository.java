package br.com.dentalofficemanager.user.repository;

import java.util.List;
import java.util.Set;

import br.com.dentalofficemanager.user.model.Role;

public interface RoleRepository {
	public List<Role> findAllRoles();
	public List<Role> findRolesByIds(Set<Long> ids);
	public Role findRole(String role);
}
