package br.com.dentalofficemanager.user.service.impl;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dentalofficemanager.user.model.UserGroup;
import br.com.dentalofficemanager.user.model.UserGroupEnum;
import br.com.dentalofficemanager.user.repository.UserGroupDao;
import br.com.dentalofficemanager.user.service.UserGroupService;

@Service
public class UserGroupServiceImpl implements UserGroupService {

	@Autowired
	protected UserGroupDao dao;
	
	@Override
	@Transactional
	public Set<UserGroup> getUserGroups() {
		return new HashSet<UserGroup>(dao.findAllUserGroups());
	}

	@Override
	@Transactional
	public UserGroup getUserGroupByCode(UserGroupEnum userGroup) {
		long code = userGroup.getCode();
		return dao.findUserGroupByGroupCode(code);
	}

}
