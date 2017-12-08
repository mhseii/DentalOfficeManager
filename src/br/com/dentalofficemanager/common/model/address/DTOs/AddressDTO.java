package br.com.dentalofficemanager.common.model.address.DTOs;

import java.io.Serializable;

public class AddressDTO implements Serializable {

	private static final long serialVersionUID = 2965761402635037007L;
	
	private StateDTO state;
	private CityDTO city;
	private DistrictDTO district;
	private StreetDTO street;

	public StateDTO getState() {
		return state;
	}

	public void setState(StateDTO state) {
		this.state = state;
	}

	public CityDTO getCity() {
		return city;
	}

	public void setCity(CityDTO city) {
		this.city = city;
	}

	public DistrictDTO getDistrict() {
		return district;
	}

	public void setDistrict(DistrictDTO district) {
		this.district = district;
	}

	public StreetDTO getStreet() {
		return street;
	}

	public void setStreet(StreetDTO street) {
		this.street = street;
	}

}
