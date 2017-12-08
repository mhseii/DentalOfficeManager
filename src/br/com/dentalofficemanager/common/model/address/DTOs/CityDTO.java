package br.com.dentalofficemanager.common.model.address.DTOs;

import java.io.Serializable;

public class CityDTO implements Serializable {

	private static final long serialVersionUID = 4758779384750710145L;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private Long id;
	private String name;
	
}
