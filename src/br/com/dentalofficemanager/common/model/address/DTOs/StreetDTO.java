package br.com.dentalofficemanager.common.model.address.DTOs;

import java.io.Serializable;

public class StreetDTO implements Serializable {

	private static final long serialVersionUID = -3217601689297235381L;
	
	private Long id;
	private String name;

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

}
