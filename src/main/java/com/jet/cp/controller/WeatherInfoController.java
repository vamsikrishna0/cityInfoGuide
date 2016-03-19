package com.jet.cp.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jet.cp.openweather.service.GetWeatherInfo;
import com.jet.cp.weather.domain.AppForecastInfoResponse;
import com.jet.cp.weather.domain.AppWeatherResponse;

import io.swagger.annotations.ApiOperation;

@RestController
public class WeatherInfoController {
    private static final Logger logger = Logger.getLogger(WeatherInfoController.class);

   @ApiOperation(value = "Returns Current Weather Information", nickname = "Returns Current Weather Information")
   @RequestMapping(value = "/weatherinfo", method = RequestMethod.GET)
   AppWeatherResponse getWeatherInfo(@RequestParam String location, @RequestParam (defaultValue="imperial") String units) {
   logger.info("Request Recieved for Location : " + location);
   GetWeatherInfo getWeatherInfo = new GetWeatherInfo();
      return getWeatherInfo.getInfo(location, units);
   }

  @ApiOperation(value = "Returns Weather Forecast Information", nickname = "Returns Weather Forecast Information")
  @RequestMapping(value = "/forecastinfo", method = RequestMethod.GET)
   AppForecastInfoResponse getForecastInfo(@RequestParam String location, @RequestParam (defaultValue="imperial") String units) {
   logger.info("Request Recieved for Location : " + location);
   GetWeatherInfo getWeatherInfo = new GetWeatherInfo();
      return getWeatherInfo.getForecastInfo(location, units, 6);
   }
}
