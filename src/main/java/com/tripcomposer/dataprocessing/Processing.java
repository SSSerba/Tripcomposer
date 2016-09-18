package com.tripcomposer.dataprocessing;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;

import com.tripcomposer.entities.City;
import com.tripcomposer.entities.Country;
import com.tripcomposer.restClient.TripRestClient;

public class Processing {

	private  List<Country> getCountriesFromJsonArray(
			JSONArray jsonCountries) {
		List<Country> countries = new ArrayList<Country>();
		for (int index = 0; index < jsonCountries.length(); index++) {
			Country country = new Country();

			country.setCountryISOCode(jsonCountries.getJSONObject(index)
					.getString("countryISOCode"));
			country.setCountryName(jsonCountries.getJSONObject(index)
					.getString("countryName"));

			JSONArray jsonCities = jsonCountries.getJSONObject(index)
					.getJSONArray("cities");

			List<City> cities = getCitiesFromJsonArray(jsonCities);

			country.setCities(cities);

			countries.add(country);

		}
		return countries;
	}

	private  List<City> getCitiesFromJsonArray(
			JSONArray jsonCities) {
		List<City> cities = new ArrayList<City>();

		for (int index = 0; index < jsonCities.length(); index++) {
			City city = new City();
			city.setCityName(jsonCities.getJSONObject(index).getString(
					"cityName"));
			cities.add(city);

		}
		return cities;
	}

	public List<Country> getCountries() {
		TripRestClient rest = new TripRestClient();
		JSONArray countries= rest.getJsonCountries();
		return getCountriesFromJsonArray(countries);
	}

}
