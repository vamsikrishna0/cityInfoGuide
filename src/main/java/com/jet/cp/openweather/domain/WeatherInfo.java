package com.jet.cp.openweather.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
//"weather":[{"id":804,"main":"Clouds","description":"overcast clouds","icon":"04n"}],
public class WeatherInfo {

   @JsonProperty("description")
   private String weatherDesc;

   @JsonProperty("icon")
   private String weatherIcon;

   @JsonProperty("clouds")
   private String clouds;
   
   @JsonProperty("main")
   private String short_desc;

   @JsonProperty("snow")
   private String snow;
   /**
    * @return the weatherDesc as String
    */
   public String getWeatherDesc() {
      return weatherDesc;
   }



   /**
    * @return the weatherIcon as String
    */
   public String getWeatherIcon() {
      return weatherIcon;
   }

/**
 * @return the clouds
 */
public String getClouds() {
	return clouds;
}


/**
 * @return the short_desc
 */
public String getShort_desc() {
	return short_desc;
}



/**
 * @return the snow
 */
public String getSnow() {
	return snow;
}

}
