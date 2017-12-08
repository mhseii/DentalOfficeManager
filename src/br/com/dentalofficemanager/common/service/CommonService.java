package br.com.dentalofficemanager.common.service;

import java.util.Set;

import br.com.dentalofficemanager.common.model.address.Country;

public interface CommonService {

	Set<Country> getCountries();
	Set<String> getStates(String country);
	String getAddressData(String zipCode);
}
