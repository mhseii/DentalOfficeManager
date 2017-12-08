package br.com.dentalofficemanager.common.model.address.DTOs;

import java.io.Serializable;

public class StateDTO implements Serializable {

	private static final long serialVersionUID = -4248848657122979192L;

	private Long id;
	private String name;
	private String abbreviation;

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

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

}
