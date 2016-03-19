package com.jet.cp.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import com.jet.cp.domain.CityInfoResponse;
import io.swagger.annotations.ApiOperation;

/**
 * Title: 
 * Description: MainController.java<br>
 * Description: <br>
 * Created: 16-Mar-2016<br>
 * Copyright: Copyright (c) 2015<br>
 * @author Teja Sasank Gorthi (jet.sasank@gmail.com)
 */

@RestController
public class MainController {
    private static final Logger logger = Logger.getLogger(MainController.class);
    @Autowired
    private ControllerHelper helper;
    /**
     * Returns the mapped html page
     * @param registry
     */
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/index.html");
        registry.addViewController("/profile").setViewName("forward:/profile.html");
    }

     @ApiOperation(value = "Get My Information", nickname = "Get My Information")
     @RequestMapping(value = "/loadInfo", method = RequestMethod.GET)
     public CityInfoResponse loadCityInfo(@RequestParam String cityName, @RequestParam String tempunits) {
        CityInfoResponse res = new CityInfoResponse();

        logger.info("Request Recieved for Location : " + cityName);

        String tempCityName = cityName;
        String temp[] = cityName.split(",");
        if (temp.length == 3) {
          StringBuffer sb = new StringBuffer();
          sb.append(temp[0]);
          sb.append(",");
          sb.append(temp[2]);
          tempCityName = sb.toString();
        }
        res.setAppWeatherResponse(helper.getCurrentWeatherInfo(tempCityName, tempunits));
        res.setGoogleFeedResponse(helper.getGoogleFeed(cityName));
        res.setYelpFeed(helper.getYelpFeed(cityName));

        logger.info("Request Processed for Location : " + cityName);

        return res;
     }



}
