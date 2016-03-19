package com.jet.cp.openweather.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Sys {
	   @JsonProperty("country")
	   private String country;

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}


}
