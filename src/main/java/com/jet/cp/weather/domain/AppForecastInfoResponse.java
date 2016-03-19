/**
 * 
 */
package com.jet.cp.weather.domain;

import java.util.List;

/**
 * Title: AppForecastInfoResponse.java<br>
 * Description: <br>
 * Created: 09-Feb-2016<br>
 * Copyright: Copyright (c) 2015<br>
 * @author Teja Sasank Gorthi (jet.sasank@gmail.com)
 */
public class AppForecastInfoResponse {

 private String city;
 private String countryCode;
 private List<DayWeather> forecastInfo;
/**
 * @return the city
 */
public String getCity() {
	return city;
}
/**
 * @param city the city to set
 */
public void setCity(String city) {
	this.city = city;
}
/**
 * @return the countryCode
 */
public String getCountryCode() {
	return countryCode;
}
/**
 * @param countryCode the countryCode to set
 */
public void setCountryCode(String countryCode) {
	this.countryCode = countryCode;
}
/**
 * @return the forecastInfo
 */
public List<DayWeather> getForecastInfo() {
	return forecastInfo;
}
/**
 * @param forecastInfo the forecastInfo to set
 */
public void setForecastInfo(List<DayWeather> forecastInfo) {
	this.forecastInfo = forecastInfo;
}
 
}
