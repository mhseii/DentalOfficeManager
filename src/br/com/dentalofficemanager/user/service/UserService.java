package br.com.dentalofficemanager.user.service;

import java.util.Set;

import br.com.dentalofficemanager.user.model.User;

public interface UserService {

	public void register(User user);
	public Set<User> findAllUsers();
	public User findByUsername(String username);
}
