package com.tripcomposer.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "country")
public class Country {

	public Country(){
		
	}
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(columnDefinition = "serial", name = "id")
	private int id;

	private String countryName;

	private String countryISOCode;

	@OneToMany(fetch=FetchType.LAZY)
    @JoinTable(name="Country_City", 
    				joinColumns={@JoinColumn(name="country_id")},
    				inverseJoinColumns={@JoinColumn(name="city_id")}
    		)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<City> cities;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryISOCode() {
		return countryISOCode;
	}

	public void setCountryISOCode(String countryISOCode) {
		this.countryISOCode = countryISOCode;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

}
