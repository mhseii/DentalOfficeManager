package br.com.dentalofficemanager.user.service;

import java.util.Set;

import br.com.dentalofficemanager.user.model.UserGroup;
import br.com.dentalofficemanager.user.model.UserGroupEnum;

public interface UserGroupService {

	public Set<UserGroup> getUserGroups();
	public UserGroup getUserGroupByCode(UserGroupEnum userGroup);
}
