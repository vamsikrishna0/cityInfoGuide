package com.jet.cp.openweather.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ForecastInfo {

	@JsonProperty("weather")
	private List<WeatherInfo> info;
	@JsonProperty("temp")
	private TemperatureForecastInfo temp;
	   @JsonProperty("humidity")
	   private float humidity;
	   @JsonProperty("dt")
	   private Long date;
	/**
	 * @return the info
	 */
	public List<WeatherInfo> getInfo() {
		return info;
	}
	/**
	 * @return the temp
	 */
	public TemperatureForecastInfo getTemp() {
		return temp;
	}
	/**
	 * @return the humidity
	 */
	public float getHumidity() {
		return humidity;
	}
	/**
	 * @return the date
	 */
	public Long getDate() {
		return date;
	}
	   
}
