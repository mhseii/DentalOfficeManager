package br.com.dentalofficemanager.common.repository.jpa;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.dentalofficemanager.common.model.address.City;
import br.com.dentalofficemanager.common.model.address.Country;
import br.com.dentalofficemanager.common.model.address.District;
import br.com.dentalofficemanager.common.model.address.State;
import br.com.dentalofficemanager.common.model.address.Street;

@Repository
public class CommonDaoImpl implements CommonDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Set<Country> getCountries() {
		Set<Country> countries = new HashSet<Country>(em.createQuery("SELECT c FROM Country c", Country.class).getResultList());
		return countries;
	}

	@Override
	public Set<String> getStates(String country) {
		final String str = "SELECT s.abbr FROM State s "
					+ "INNER JOIN s.country c WHERE c.abbr = :country "
					+ "ORDER BY s.abbr";
		TypedQuery<String> query = em.createQuery(str, String.class);
		Set<String> states = new LinkedHashSet<String>(query.setParameter("country", country).getResultList());
		return states;
	}
	
	@Override
	public State getStateByZipCodeRange(String zipCode) {
		final String str = "SELECT t FROM State t "
				+ " where :zipCode BETWEEN t.zipcodeStart AND t.zipcodeEnd ";
		TypedQuery<State> query = em.createQuery(str, State.class);
		State state = null;
		try {
			state = query.setParameter("zipCode", zipCode).getSingleResult();
		} catch(NoResultException ex) {
		
		}
		return state;
	}
	
	@Override
	public City getCityByZipCodeRange(String zipCode) {
		final String str = "SELECT t FROM City t"
				+ " WHERE :zipCode between t.zipcodeStart and t.zipcodeEnd";
		TypedQuery<City> query = em.createQuery(str, City.class);
		City city = null;
		try {
			city = query.setParameter("zipCode", zipCode).getSingleResult();
		} catch(NoResultException ex) {
			
		}
		return city;
	}

	@Override
	public District getDistrictByZipCodeRange(String zipCode) {
		final String str = "SELECT t FROM District t "
				+ " WHERE :zipCode BETWEEN t.zipcodeStart AND t.zipcodeEnd ";
		TypedQuery<District> query = em.createQuery(str, District.class);
		District district = null;
		try {
			district = query.setParameter("zipCode", zipCode).getSingleResult();
		} catch(NoResultException ex) {
			
		}
		return district;
	}

	@Override
	public Street getStreetByZipCodeRange(String zipCode) {
		final String str = "SELECT t FROM Street t "
				+ "WHERE :zipCode BETWEEN t.zipcodeStart AND t.zipcodeEnd";
		TypedQuery<Street> query = em.createQuery(str, Street.class);
		Street street = null;
		try {
			street = query.setParameter("zipCode", zipCode).getSingleResult();
		} catch(NoResultException ex) {
			
		}
		return street;
	}

}
