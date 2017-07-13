package br.com.dentalofficemanager.common.repository.jpa;

import java.util.Set;

import br.com.dentalofficemanager.common.model.address.Country;

public interface CommonDao {
	Set<Country> getCountries();
	Set<String> getStates(String country);
}
