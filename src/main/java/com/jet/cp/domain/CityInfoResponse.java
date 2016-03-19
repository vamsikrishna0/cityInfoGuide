package com.jet.cp.domain;

import com.jet.cp.google.domain.GoogleFeedResponse;
import com.jet.cp.weather.domain.AppWeatherResponse;
import com.jet.cp.yelp.domain.YelpResponse;

public class CityInfoResponse {

   private GoogleFeedResponse googleFeedResponse;
   private YelpResponse yelpFeed;
   private AppWeatherResponse appWeatherResponse;
/**
 * @return the googleFeedResponse
 */
public GoogleFeedResponse getGoogleFeedResponse() {
	return googleFeedResponse;
}
/**
 * @param googleFeedResponse the googleFeedResponse to set
 */
public void setGoogleFeedResponse(GoogleFeedResponse googleFeedResponse) {
	this.googleFeedResponse = googleFeedResponse;
}
/**
 * @return the yelpFeed
 */
public YelpResponse getYelpFeed() {
	return yelpFeed;
}
/**
 * @param yelpFeed the yelpFeed to set
 */
public void setYelpFeed(YelpResponse yelpFeed) {
	this.yelpFeed = yelpFeed;
}
/**
 * @return the appWeatherResponse
 */
public AppWeatherResponse getAppWeatherResponse() {
	return appWeatherResponse;
}
/**
 * @param appWeatherResponse the appWeatherResponse to set
 */
public void setAppWeatherResponse(AppWeatherResponse appWeatherResponse) {
	this.appWeatherResponse = appWeatherResponse;
}

   
}
