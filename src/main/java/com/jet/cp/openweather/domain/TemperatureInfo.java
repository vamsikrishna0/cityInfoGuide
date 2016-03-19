/**
 * All rights reserved.
 * This software is the confidential and proprietary information
 */
package com.jet.cp.openweather.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Title: TemperatureInfo.java.java<br>
 * Description: <br>
 * Created: 09-Feb-2016<br>
 * Copyright: Copyright (c) 2015<br>
 * @author Teja Sasank Gorthi (jet.sasank@gmail.com)
 */
@JsonIgnoreProperties(ignoreUnknown=true)
//"main":{"temp":22.676,"temp_min":22.676,"temp_max":22.676,"pressure":920.93,"sea_level":1015.88,"grnd_level":920.93,"humidity":81},
public class TemperatureInfo {

   @JsonProperty("temp")
   private float temp;

   @JsonProperty("temp_min")
   private float tempMin;

   @JsonProperty("temp_max")
   private float tempMax;

   @JsonProperty("humidity")
   private float humidity;

   /**
    * @return the temp as float
    */
   public float getTemp() {
      return temp;
   }
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
    * @return the humidity as float
    */
   public float getHumidity() {
      return humidity;
   }
   /**
    * @param aHumidity the humidity to set
    */
   public void setHumidity(float aHumidity) {
       humidity = aHumidity;
   }

   
}
