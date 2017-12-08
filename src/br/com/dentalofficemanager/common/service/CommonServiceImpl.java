package br.com.dentalofficemanager.common.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import br.com.dentalofficemanager.common.model.address.City;
import br.com.dentalofficemanager.common.model.address.Country;
import br.com.dentalofficemanager.common.model.address.District;
import br.com.dentalofficemanager.common.model.address.State;
import br.com.dentalofficemanager.common.model.address.Street;
import br.com.dentalofficemanager.common.model.address.DTOs.AddressDTO;
import br.com.dentalofficemanager.common.model.address.DTOs.CityDTO;
import br.com.dentalofficemanager.common.model.address.DTOs.DistrictDTO;
import br.com.dentalofficemanager.common.model.address.DTOs.StateDTO;
import br.com.dentalofficemanager.common.model.address.DTOs.StreetDTO;
import br.com.dentalofficemanager.common.repository.jpa.CommonDao;

@Service
public class CommonServiceImpl implements CommonService {

	@Autowired
	private CommonDao dao;
	
	@Override
	@Transactional
	public Set<Country> getCountries() {
		return dao.getCountries();
	}

	@Override
	@Transactional
	public Set<String> getStates(String country) {
		return dao.getStates(country);
	}
	
	@Override
	@Transactional
	public String getAddressData(String zipCode) {
		
		if(!validateZipCode(zipCode)) {
			return null;
		}
		
		String trimmedZipCode = zipCode.replaceAll("-","");
		AddressDTO address = new AddressDTO();
		
		retrieveStateData(trimmedZipCode, address);
		retrieveCityData(trimmedZipCode, address);
		retrieveDistrictData(trimmedZipCode, address);
		retrieveStreetData(trimmedZipCode, address);
		
		String result = null;
		try {
			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			result = ow.writeValueAsString(address);
		} catch(JsonProcessingException ex) {
			// logs
		}
		
		return result;
	}
	
	private boolean validateZipCode(String zipCode) {
		String pattern = "[0-9]{5}[-]{1}[0-9]{3}";
		return zipCode.matches(pattern);
	}
	
	private void retrieveStateData(String zipCode, AddressDTO address) {
		State state = dao.getStateByZipCodeRange(zipCode);
		if(null != state) {
			StateDTO stateDTO = new StateDTO();
			stateDTO.setId(state.getStateId());
			stateDTO.setName(state.getName());
			stateDTO.setAbbreviation(state.getAbbr());
			address.setState(stateDTO);
		}
	}
	
	private void retrieveCityData(String zipCode, AddressDTO address) {
		City city = dao.getCityByZipCodeRange(zipCode);
		if(null != city) {
			CityDTO cityDTO = new CityDTO();
			cityDTO.setId(city.getCityId());
			cityDTO.setName(city.getName());
			address.setCity(cityDTO);
		}
	}
	
	private void retrieveDistrictData(String zipCode, AddressDTO address) {
		District district = dao.getDistrictByZipCodeRange(zipCode);
		if(null != district) {
			DistrictDTO districtDTO = new DistrictDTO();
			districtDTO.setId(district.getDistrictId());
			districtDTO.setName(district.getName());
			address.setDistrict(districtDTO);
		}
	}
	
	private void retrieveStreetData(String zipCode, AddressDTO address) {
		Street street = dao.getStreetByZipCodeRange(zipCode);
		if(null != street) {
			StreetDTO streetDTO = new StreetDTO();
			streetDTO.setId(street.getStreetId());
			streetDTO.setName(street.getName());
			address.setStreet(streetDTO);
		}
	}
	
}
