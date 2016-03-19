/**
 * All rights reserved.
 * This software is the confidential and proprietary information
 */
package com.jet.cp.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jet.cp.yelp.domain.YelpResponse;

import io.swagger.annotations.ApiOperation;

/**
 * Title: GoogleFeedController.java<br>
 * Description: <br>
 * Created: 09-Feb-2016<br>
 * Copyright: Copyright (c) 2015<br>
 * @author Teja Sasank Gorthi (jet.sasank@gmail.com)
 */

@RestController
public class YelpController {
    private static final Logger logger = Logger.getLogger(YelpController.class);
    @Autowired
    private ControllerHelper helper;

   @ApiOperation(value = "Returns Yelp Feed", nickname = "Returns Yelp Feed")
   @RequestMapping(value = "/yelpfeed", method = RequestMethod.GET)
    YelpResponse getYelpFeed(@RequestParam String location) {
        logger.info("Request Recieved for Location : " + location);
        return helper.getYelpFeed(location);
   }
}
