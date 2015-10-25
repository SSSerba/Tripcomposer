package com.tripcomposer.controllers;

import java.util.List;

import com.tripcomposer.dataprocessing.Processing;
import com.tripcomposer.entities.Country;
import com.tripcomposer.services.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TripController {
	
	@Autowired
	private CountryService countryService;

	@Autowired
	private CityService cityService;


	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateBD() {
		for(Country country : getCountries()){
		countryService.saveOrUpdate(country);
		}
		return "redirect:/";
	}
	
	private List<Country> getCountries(){
		Processing process = new Processing();
		return process.getCountries();
		
	}

}
