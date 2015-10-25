package com.tripcomposer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tripcomposer.dao.CityDAO;
import com.tripcomposer.entities.City;

@Service
public class CityServiceImpl implements CityService {
	
	@Autowired
	private CityDAO cityDAO;
	
	@Transactional
	public City getCity(int id) {
		return cityDAO.getById(id);
	}


	@Transactional
	public void saveOrUpdate(City city) {
		cityDAO.saveOrUpdate(city);
	}


}
