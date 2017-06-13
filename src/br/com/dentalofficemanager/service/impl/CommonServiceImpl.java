package br.com.dentalofficemanager.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dentalofficemanager.dao.jpa.CommonDao;
import br.com.dentalofficemanager.model.sys.Country;
import br.com.dentalofficemanager.service.CommonService;

@Service
public class CommonServiceImpl implements CommonService {

	@Autowired
	private CommonDao dao;
	
	@Override
	public Set<Country> getCountries() {
		return dao.getCountries();
	}

}
