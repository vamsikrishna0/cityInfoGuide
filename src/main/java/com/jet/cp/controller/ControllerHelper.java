package com.jet.cp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.jet.cp.email.SendEmail;
import com.jet.cp.google.domain.GoogleFeedDomain;
import com.jet.cp.google.domain.GoogleFeedResponse;
import com.jet.cp.google.service.GetGoogleFeed;
import com.jet.cp.mongo.DBFeedService;
import com.jet.cp.openweather.service.GetWeatherInfo;
import com.jet.cp.user.UserService;
import com.jet.cp.user.domain.User;
import com.jet.cp.weather.domain.AppWeatherResponse;
import com.jet.cp.yelp.domain.YelpFeedDomain;
import com.jet.cp.yelp.domain.YelpResponse;
import com.jet.cp.yelp.service.GetYelpFeed;

/**
 * Title: ControllerHelper.java<br>
 * Description: <br>
 * Created: 17-Mar-2016<br>
 * Copyright: Copyright (c) 2015<br>
 * @author Teja Sasank Gorthi (jet.sasank@gmail.com)
 */
@Component
public class ControllerHelper {
    private static final Logger logger = Logger.getLogger(ControllerHelper.class);
    @Autowired
    private DBFeedService service;

    @Autowired
    private UserService userService;

    @Autowired
    private SendEmail sendEmail;

    @Autowired
    private VelocityEngine velocityEngine;

    private static final String yelpConsumerKey = "W6JbejAs_yIBpR2EeCz4mA";
    private static final String yelpConsumerSecret = "rEyDnR_L9Rm4tzTUVaActwbS7vE";
    private static final String yelpToken = "yDV8U1azMCj-TMgf9bt2HqM1qskNayAx";
    private static final String yelpTokenSecret = "nntI5WLcOUv-Sb0H7y__ZxCnQ0c";

    protected GoogleFeedResponse getGoogleFeed(String cityName) {
        List<GoogleFeedDomain> dbresponse = service.getGoogleFeed(cityName.split(",")[0].trim());
        GoogleFeedResponse googleFeedResponse = null;
        if (dbresponse != null) {
            for(GoogleFeedDomain response : dbresponse) {
                  if (response != null) {
                     googleFeedResponse = response.getResponse();
                     break;
                  }
            }
        }

        if (googleFeedResponse == null) {
            GetGoogleFeed getGoogleFeed = new GetGoogleFeed();
            logger.info("Fetching Google Feed for location " + cityName + " from external API");
            googleFeedResponse = getGoogleFeed.getFeed(cityName);

            if (googleFeedResponse != null) {
                logger.info("Succesfully recieved Google Feed for location " + cityName + " from external API");
                GoogleFeedDomain dbObj = new GoogleFeedDomain();
                googleFeedResponse.setSource("local_db");
                dbObj.setLocation(cityName.split(",")[0].trim());
                dbObj.setCityName(cityName.split(",")[0].trim());
                dbObj.setResponse(googleFeedResponse);

                logger.info("Saving Google Feed for location " + cityName.split(",")[0].trim() + " in local Mongodb cache");
                service.saveGoogleFeed(dbObj);
                logger.info("Succesfully saved Google Feed for location " + cityName.split(",")[0].trim() + " in local Mongodb cache");
                googleFeedResponse.setSource("google api");
            }
        }

               return googleFeedResponse;
      }

    protected YelpResponse getYelpFeed(String cityName) {
        List<YelpFeedDomain> dbresponse = service.getYelpFeed(cityName.split(",")[0].trim());
        YelpResponse yelpResponse = null;
        if (dbresponse != null) {
            for(YelpFeedDomain response : dbresponse) {
                  if (response != null) {
                        yelpResponse = response.getResponse();
                     break;
                  }
            }
        }

        if (yelpResponse == null) {

            GetYelpFeed yelp = new GetYelpFeed(yelpConsumerKey, yelpConsumerSecret, yelpToken, yelpTokenSecret);
            logger.info("Fetching Yelp Feed for location " + cityName.split(",")[0].trim() + " from external API");
            yelpResponse = yelp.getFeed(cityName.split(",")[0].trim());

            if (yelpResponse != null && yelpResponse.getBusinesses() != null) {
                logger.info("Succesfully recieved Yelp Feed for location " + cityName.split(",")[0].trim() + " from external API");
                YelpFeedDomain dbObj = new YelpFeedDomain();
                yelpResponse.setSource("local_db");
                dbObj.setLocation(cityName.split(",")[0].trim());
                dbObj.setCityName(cityName.split(",")[0].trim());
                dbObj.setResponse(yelpResponse);

                logger.info("Saving Yelp Feed for location " + cityName.split(",")[0].trim() + " in local Mongodb cache");
                service.saveYelpFeed(dbObj);
                logger.info("Succesfully saved Yelp Feed for location " + cityName.split(",")[0].trim() + " in local Mongodb cache");
                yelpResponse.setSource("google api");
            }
        }

        return yelpResponse;
     }

    protected AppWeatherResponse getCurrentWeatherInfo(String location, String tempUnits) {
        GetWeatherInfo getWeatherInfo = new GetWeatherInfo();
        return getWeatherInfo.getInfo(location, tempUnits);
    }

    @SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
    protected boolean insertUser(User user) {
       boolean created = userService.insertUser(user);
       if (created) {
          GetWeatherInfo getWeatherInfo = new GetWeatherInfo();
          AppWeatherResponse res = getWeatherInfo.getInfo(user.getLocation(), "Imperial");

          YelpResponse yelpfeed = getYelpFeed(user.getLocation());
          Map model = new HashMap();
          model.put("weatherInfo", res);
          model.put("yelp", yelpfeed);
          String body = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "templates/welcome.vm", model) ;

          sendEmail.send(user.getEmail(), "Congratulations Profile Created here is your first Update for " + user.getLocation(), body);
       }
       return created;
    }
    protected User getUserInfo(String username) {
        return userService.getUser(username);
     }

    protected boolean updatetUserInfo(String userName, String emailPref, String location) {
        return userService.UpdateUser(userName, emailPref, location);
     }

    protected List<String> getEmailIds(char type) {
      if (type == 'D') {
           return userService.getEmailsForDailyEmails();
      } else {
           return userService.getEmailsForWeeklyEmails();
      }
    }

    @Scheduled(cron="0 0 09 * * ?")
    public void clearMongoDBCache() {
      logger.info("Clearning MongoCache");
      service.clearGoogleFeedCache();
      service.clearYelpFeedCache();
      sendEmail.send("gteja231989@gmail.com", "Mongo Cache Cleared", "<html><body><p>Mongo Cache is cleared now!</p></body></html>");
      logger.info("MongoCache Cleared");
    }

    @Scheduled(cron="0 0 06 * * ?")
    @SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
    public void sendEmail() {
       List<String> emailIds = userService.getEmailsForDailyEmails();
       for (String emailId : emailIds) {
          User user = userService.getUser(emailId.split("@")[0]);
          GetWeatherInfo getWeatherInfo = new GetWeatherInfo();
          AppWeatherResponse res = getWeatherInfo.getInfo(user.getLocation(), "Imperial");
          YelpResponse yelpfeed = getYelpFeed(user.getLocation());

          Map model = new HashMap();
          model.put("weatherInfo", res);
          model.put("yelp", yelpfeed);
          String body = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "templates/dailyemail.vm", model) ;

          sendEmail.send(user.getEmail(), "City Info Guide : Todays Update", body);
       }
    }
}
