package com.tripcomposer.dao;

import org.springframework.stereotype.Repository;

import com.tripcomposer.entities.City;

@Repository
public class CityDAOImpl extends DefaultDAOImpl<City, Integer> implements CityDAO {

	@Override
	public Class<City> getClassOfCurrentObj() {
		return City.class;
	}
	
}
