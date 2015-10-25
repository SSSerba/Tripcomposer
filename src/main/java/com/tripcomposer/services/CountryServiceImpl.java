package com.tripcomposer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tripcomposer.dao.CountryDAO;
import com.tripcomposer.entities.Country;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryDAO contDAO; 
	
	@Transactional
	public Country get(int id) {
		
		return contDAO.getById(id);
	}


	@Transactional
	public void saveOrUpdate(Country country) {

		contDAO.saveOrUpdate(country);
	}

	@Transactional
	public List<Country> getCountries() {
		return	contDAO.getList();
	}
}
