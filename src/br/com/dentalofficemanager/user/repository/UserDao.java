package br.com.dentalofficemanager.user.repository;

import java.util.List;

import br.com.dentalofficemanager.user.model.User;

public interface UserDao {
	
	public void save(User user);
	public List<User> findAll();
	public User findByUsername(String username);
	
}
