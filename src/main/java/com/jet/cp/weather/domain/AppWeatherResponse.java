package com.jet.cp.weather.domain;

public class AppWeatherResponse {


   private String countryCode;
 
   private String city;

   private DayWeather weather;


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
 * @return the weather
 */
public DayWeather getWeather() {
	return weather;
}

/**
 * @param weather the weather to set
 */
public void setWeather(DayWeather weather) {
	this.weather = weather;
}

    
}
