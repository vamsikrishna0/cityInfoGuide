/**
 * All rights reserved.
 * This software is the confidential and proprietary information
 */
package com.jet.cp.openweather.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Title: OpenweathermapForecastAPIResponse.java<br>
 * Description: <br>
 * Created: 09-Feb-2016<br>
 * Copyright: Copyright (c) 2015<br>
 * @author Teja Sasank Gorthi (jet.sasank@gmail.com)
 */
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
