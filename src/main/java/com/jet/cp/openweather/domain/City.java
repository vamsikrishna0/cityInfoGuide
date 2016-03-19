package com.jet.cp.openweather.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class City {

	   @JsonProperty("country")
	   private String country;
	   @JsonProperty("name")
	   private String city;
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	   
}
