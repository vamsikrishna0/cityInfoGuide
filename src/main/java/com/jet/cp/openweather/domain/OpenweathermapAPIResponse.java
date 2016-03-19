package com.jet.cp.openweather.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class OpenweathermapAPIResponse {

   @JsonProperty("main")
   private TemperatureInfo temperatureInfo;

   @JsonProperty("weather")
   private List<WeatherInfo> weatherInfo;

   @JsonProperty("sys")
   private Sys sys;

   @JsonProperty("dt")
   private Long date;
   

   @JsonProperty("name")
   private String city;
   /**
    * @return the temperatureInfo as TemperatureInfo
    */
   public TemperatureInfo getTemperatureInfo() {
   	return temperatureInfo;
   }

   /**
    * @param aTemperatureInfo the temperatureInfo to set
    */
   public void setTemperatureInfo(TemperatureInfo aTemperatureInfo) {
   	temperatureInfo = aTemperatureInfo;
   }

   /**
    * @return the weatherInfo as List<WeatherInfo>
    */
   public List<WeatherInfo> getWeatherInfo() {
   	return weatherInfo;
   }

   /**
    * @param aWeatherInfo the weatherInfo to set
    */
   public void setWeatherInfo(List<WeatherInfo> aWeatherInfo) {
   	weatherInfo = aWeatherInfo;
   }

/**
 * @return the sys
 */
public Sys getSys() {
	return sys;
}

/**
 * @return the date
 */
public Long getDate() {
	return date;
}

/**
 * @return the city
 */
public String getCity() {
	return city;
}

   
}
