package br.com.dentalofficemanager.dao.jpa;

import java.util.Set;

import br.com.dentalofficemanager.model.sys.Country;

public interface CommonDao {
	
	Set<Country> getCountries();
	Set<String> getStates(String country);

}
