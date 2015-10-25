package com.tripcomposer.dao;

import org.springframework.stereotype.Repository;

import com.tripcomposer.entities.Country;

@Repository
public class CountryDAOImpl extends DefaultDAOImpl<Country, Integer>  implements CountryDAO{

	@Override
	public Class<Country> getClassOfCurrentObj() {
		return Country.class;
	}

}
