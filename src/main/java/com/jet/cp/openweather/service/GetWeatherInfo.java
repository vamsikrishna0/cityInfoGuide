/**
 * All rights reserved.
 * This software is the confidential and proprietary information
 */
package com.jet.cp.openweather.service;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.jet.cp.openweather.domain.ForecastInfo;
import com.jet.cp.openweather.domain.OpenweathermapAPIResponse;
import com.jet.cp.openweather.domain.OpenweathermapForecastAPIResponse;
import com.jet.cp.weather.domain.AppForecastInfoResponse;
import com.jet.cp.weather.domain.AppWeatherResponse;
import com.jet.cp.weather.domain.DayWeather;

/**
 * Title: GetWeatherInfo.java.java<br>
 * Description: Gets the Weather Information using the API
 *              provided by http://openweathermap.org/
 * Created: 209-Feb-2016<br>
 * Copyright: Copyright (c) 2015<br>
 * @author Teja Sasank Gorthi (jet.sasank@gmail.com)
 */
@Component
public class GetWeatherInfo {

   private static final Logger logger = Logger.getLogger(GetWeatherInfo.class);

   private static final String api_key = "aeb6446b7d6d8a8c109cbb2575a63ef5";
   private static final String api_endpoint_day = "http://api.openweathermap.org/data/2.5/weather?";
   private static final String api_endpoint_forecast = "http://api.openweathermap.org/data/2.5/forecast/daily?";
   private static final String icon_url = "http://openweathermap.org/img/w/";

   /**
   * @param cityName
   * @return the OpenweathermapAPIResponse for a given location
   */
   public AppWeatherResponse getInfo(String cityName, String measurementunits) {
       OpenweathermapAPIResponse response = getAPIWeatherInfo(getURL(cityName, measurementunits));

       logger.debug(response.toString());
       AppWeatherResponse appWeatherResponse = new AppWeatherResponse();
       appWeatherResponse.setWeather(new DayWeather());

       appWeatherResponse.setCity(response.getCity());
       appWeatherResponse.setCountryCode(response.getSys().getCountry());

       appWeatherResponse.getWeather().setDate(response.getDate());
       appWeatherResponse.getWeather().setHumidity(response.getTemperatureInfo().getHumidity());
       appWeatherResponse.getWeather().setTemp(response.getTemperatureInfo().getTemp());
       appWeatherResponse.getWeather().setTempMax(response.getTemperatureInfo().getTempMax());
       appWeatherResponse.getWeather().setTempMin(response.getTemperatureInfo().getTempMin());
       appWeatherResponse.getWeather().setWeatherDesc(response.getWeatherInfo().get(0).getWeatherDesc());
       if (response.getWeatherInfo().get(0).getClouds() != null && !response.getWeatherInfo().get(0).getClouds().equals("")) {
           appWeatherResponse.getWeather().setClouds(response.getWeatherInfo().get(0).getClouds());
       }
       appWeatherResponse.getWeather().setMain_desc(response.getWeatherInfo().get(0).getShort_desc());

       String icon = response.getWeatherInfo().get(0).getWeatherIcon();

       appWeatherResponse.getWeather().setIconUrl(getIconUrl(icon));

       return appWeatherResponse;
   }

   /**
   * @param cityName
   * @return the OpenweathermapAPIResponse for a given location
   */
   public AppForecastInfoResponse getForecastInfo(String cityName, String measurementunits, int days) {
       OpenweathermapForecastAPIResponse response = getForecastAPIWeatherInfo(getForecastURL(cityName, measurementunits, days));
       logger.debug(response.toString());

       AppForecastInfoResponse appForecastInfoResponse = new AppForecastInfoResponse();
       appForecastInfoResponse.setCity(response.getCity().getCity());
       appForecastInfoResponse.setCountryCode(response.getCity().getCountry());

       appForecastInfoResponse.setForecastInfo(new ArrayList<DayWeather>());
       for(ForecastInfo info : response.getForcastInfo()) {
        DayWeather dayWeather = new DayWeather();
        dayWeather.setHumidity(info.getHumidity());

        dayWeather.setDate(info.getDate());
        dayWeather.setDayTemp(info.getTemp().getDayTemp());
        dayWeather.setEvenTemp(info.getTemp().getEveningTemp());
        dayWeather.setNightTemp(info.getTemp().getNightTemp());
        dayWeather.setMornTemp(info.getTemp().getMorningTemp());

        dayWeather.setTempMax(info.getTemp().getTempMax());
        dayWeather.setTempMin(info.getTemp().getTempMin());

        dayWeather.setWeatherDesc(info.getInfo().get(0).getWeatherDesc());
        dayWeather.setClouds(info.getInfo().get(0).getClouds());
        dayWeather.setMain_desc(info.getInfo().get(0).getShort_desc());
        dayWeather.setSnow(info.getInfo().get(0).getSnow());

        String icon = info.getInfo().get(0).getWeatherIcon();

        dayWeather.setIconUrl(getIconUrl(icon));

        appForecastInfoResponse.getForecastInfo().add(dayWeather);
       }


       return appForecastInfoResponse;
   }

   private OpenweathermapForecastAPIResponse getForecastAPIWeatherInfo(String url) {
      RestTemplate restTemplate = new RestTemplate();
      OpenweathermapForecastAPIResponse api_response = restTemplate.getForObject(url, OpenweathermapForecastAPIResponse.class);
      return api_response;
   }

   private OpenweathermapAPIResponse getAPIWeatherInfo(String url) {
      RestTemplate restTemplate = new RestTemplate();
      logger.info("Fetching weather info from " + url);
      OpenweathermapAPIResponse api_response = restTemplate.getForObject(url, OpenweathermapAPIResponse.class);
      return api_response;
   }

   /**
   * @param cityName
   * @return
   */
   private String getURL(String cityName, String measurement_units) {
    StringBuffer sb = new StringBuffer();
    sb.append(api_endpoint_day);
    sb.append("q=");
    sb.append(cityName);
    sb.append("&units=" + measurement_units);
    sb.append("&APPID=" + api_key);
     return sb.toString();
   }

   /**
   * @param cityName
   * @return
   */
   private String getForecastURL(String cityName, String measurement_units, int days) {
    StringBuffer sb = new StringBuffer();
    sb.append(api_endpoint_forecast);
    sb.append("q=");
    sb.append(cityName);
    sb.append("&units=" + measurement_units);
    sb.append("&APPID=" + api_key);
    sb.append("&cnt=" + days);
    System.out.println(sb.toString());
     return sb.toString();
   }

   private String getIconUrl(String icon) {
    StringBuffer sb = new StringBuffer();
    sb.append(icon_url);
    sb.append(icon);
    sb.append(".png");
    return sb.toString();
   }
}
