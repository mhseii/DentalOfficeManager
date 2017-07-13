package br.com.dentalofficemanager.user.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.dentalofficemanager.user.model.User;
import br.com.dentalofficemanager.user.repository.UserDao;
import br.com.dentalofficemanager.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;

	@Override
	@Transactional
	public void register(User user) {
		dao.save(user);
	}

	@Override
	@Transactional
	public Set<User> findAllUsers() {
		return new HashSet<User>(dao.findAll());
	}

	@Override
	@Transactional
	public User findByUsername(String username) {
		return dao.findByUsername(username);
	}

}
