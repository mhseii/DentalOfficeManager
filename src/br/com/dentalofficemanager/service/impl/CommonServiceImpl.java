package br.com.dentalofficemanager.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.dentalofficemanager.dao.jpa.CommonDao;
import br.com.dentalofficemanager.model.address.Country;
import br.com.dentalofficemanager.service.CommonService;

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
	
}
