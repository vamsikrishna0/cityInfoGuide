/**
 * All rights reserved.
 * This software is the confidential and proprietary information
 */
package com.jet.cp.openweather.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Title: OpenweathermapAPIResponse.java.java<br>
 * Description: <br>
 * Created: 09-Feb-2016<br>
 * Copyright: Copyright (c) 2015<br>
 * @author Teja Sasank Gorthi (jet.sasank@gmail.com)
 */
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
