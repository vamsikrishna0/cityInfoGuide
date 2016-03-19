/**
 * 
 */
package com.jet.cp.openweather.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Title: Sys.java<br>
 * Description: <br>
 * Created: 09-Feb-2016<br>
 * Copyright: Copyright (c) 2015<br>
 * @author Teja Sasank Gorthi (jet.sasank@gmail.com)
 */
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
