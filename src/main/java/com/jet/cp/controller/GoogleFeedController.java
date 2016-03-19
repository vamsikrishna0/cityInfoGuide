
package com.jet.cp.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jet.cp.google.domain.GoogleFeedResponse;

import io.swagger.annotations.ApiOperation;

@RestController
public class GoogleFeedController {
    private static final Logger logger = Logger.getLogger(GoogleFeedController.class);
    @Autowired
    private ControllerHelper helper;

   @ApiOperation(value = "Returns Google Feed", nickname = "Returns Google Feed")
   @RequestMapping(value = "/googlefeed", method = RequestMethod.GET)
   GoogleFeedResponse getGoogleFeed(@RequestParam String location) {
       logger.info("Request Recieved for Location : " + location);
       return helper.getGoogleFeed(location);
   }
}
