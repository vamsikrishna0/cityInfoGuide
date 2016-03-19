package com.jet.cp.openweather.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class OpenweathermapForecastAPIResponse {

	@JsonProperty("city")
	private City city;
	@JsonProperty("list")
	private List<ForecastInfo> forcastInfo;

	/**
	 * @return the city
	 */
	public City getCity() {
		return city;
	}
	/**
	 * @return the forcastInfo
	 */
	public List<ForecastInfo> getForcastInfo() {
		return forcastInfo;
	}
	
	
}
