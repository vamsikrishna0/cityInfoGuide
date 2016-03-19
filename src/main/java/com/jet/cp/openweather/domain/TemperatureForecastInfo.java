package com.jet.cp.openweather.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
//"main":{"temp":22.676,"temp_min":22.676,"temp_max":22.676,"pressure":920.93,"sea_level":1015.88,"grnd_level":920.93,"humidity":81},
public class TemperatureForecastInfo {


   @JsonProperty("min")
   private float tempMin;

   @JsonProperty("max")
   private float tempMax;

   @JsonProperty("morn")
   private float morningTemp;

   @JsonProperty("eve")
   private float eveningTemp;

   @JsonProperty("night")
   private float nightTemp;

   @JsonProperty("day")
   private float dayTemp;
   /**
    * @return the tempMin as float
    */
   public float getTempMin() {
      return tempMin;
   }
   /**
    * @return the tempMax as float
    */
   public float getTempMax() {
      return tempMax;
   }
/**
 * @return the morningTemp
 */
public float getMorningTemp() {
	return morningTemp;
}
/**
 * @return the eveningTemp
 */
public float getEveningTemp() {
	return eveningTemp;
}
/**
 * @return the nightTemp
 */
public float getNightTemp() {
	return nightTemp;
}
/**
 * @return the dayTemp
 */
public float getDayTemp() {
	return dayTemp;
}


   
}
