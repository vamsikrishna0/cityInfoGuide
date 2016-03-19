package com.jet.cp.google.domain;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "googlefeed")
public class GoogleFeedDomain implements Serializable{

    private static final long serialVersionUID = 1L;
    private GoogleFeedResponse response;
    @Id
    private String location;
    private String cityName;

   /**
    * @return the response
    */
   public GoogleFeedResponse getResponse() {
      return response;
   }
   /**
    * @param response the response to set
    */
   public void setResponse(GoogleFeedResponse response) {
      this.response = response;
   }
   /**
    * @return the location
    */
   public String getLocation() {
      return location;
   }
   /**
    * @param location the location to set
    */
   public void setLocation(String location) {
      this.location = location;
   }
/**
 * @return the cityName
 */
public String getCityName() {
	return cityName;
}
/**
 * @param cityName the cityName to set
 */
public void setCityName(String cityName) {
	this.cityName = cityName;
}

   
}
