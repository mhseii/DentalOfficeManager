package br.com.dentalofficemanager.user.repository;

import java.util.List;

import br.com.dentalofficemanager.user.model.UserGroup;

public interface UserGroupDao {
	
	public List<UserGroup> findAllUserGroups();
	public UserGroup findUserGroupByGroupCode(long groupCode);
	
}
