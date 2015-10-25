package com.tripcomposer.services;

import com.tripcomposer.entities.City;

public interface CityService {
	
	City getCity(int id);

	void saveOrUpdate(City city);
}
