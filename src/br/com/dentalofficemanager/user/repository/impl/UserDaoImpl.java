package br.com.dentalofficemanager.user.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.dentalofficemanager.user.model.User;
import br.com.dentalofficemanager.user.repository.UserDao;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void save(User user) {
		em.merge(user);
		em.flush();
	}

	@Override
	public List<User> findAll() {
		return em.createQuery("select u from User u", User.class).getResultList();
	}

	@Override
	public User findByUsername(String username) {
		TypedQuery<User> query = em.createQuery("select u from User u where lower(u.username) = :username", User.class);
		query.setParameter("username", username.toLowerCase());
		return query.getSingleResult();
	}

}
