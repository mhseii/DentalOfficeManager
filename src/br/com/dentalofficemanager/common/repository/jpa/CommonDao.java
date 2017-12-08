package br.com.dentalofficemanager.common.repository.jpa;

import java.util.Set;

import br.com.dentalofficemanager.common.model.address.City;
import br.com.dentalofficemanager.common.model.address.Country;
import br.com.dentalofficemanager.common.model.address.District;
import br.com.dentalofficemanager.common.model.address.State;
import br.com.dentalofficemanager.common.model.address.Street;

public interface CommonDao {
	Set<Country> getCountries();
	Set<String> getStates(String country);
	State getStateByZipCodeRange(String zipCode);
	City getCityByZipCodeRange(String zipCode);
	District getDistrictByZipCodeRange(String zipCode);
	Street getStreetByZipCodeRange(String zipCode); 
}
