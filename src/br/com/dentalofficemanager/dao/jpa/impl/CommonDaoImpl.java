package br.com.dentalofficemanager.dao.jpa.impl;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.dentalofficemanager.dao.jpa.CommonDao;
import br.com.dentalofficemanager.model.sys.Country;

@Repository
public class CommonDaoImpl implements CommonDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Set<Country> getCountries() {
		Set<Country> countries = new HashSet<Country>(em.createQuery("SELECT c FROM Country c", Country.class).getResultList());
		return countries;
	}

}
