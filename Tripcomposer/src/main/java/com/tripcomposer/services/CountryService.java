package com.tripcomposer.services;
import java.util.List;

import com.tripcomposer.entities.Country;

public interface CountryService {

	Country get(int id);
	
    void saveOrUpdate(Country country);
    
    public List<Country> getCountries();
}
