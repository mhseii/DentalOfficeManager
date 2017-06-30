package br.com.dentalofficemanager.service;

import java.util.Set;

import br.com.dentalofficemanager.model.address.Country;

public interface CommonService {

	Set<Country> getCountries();
	Set<String> getStates(String country);
}
