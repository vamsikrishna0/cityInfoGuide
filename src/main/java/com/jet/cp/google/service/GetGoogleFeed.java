package com.jet.cp.google.service;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;

import org.json.JSONObject;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jet.cp.google.domain.GoogleFeedResponse;

@Component
@ComponentScan
@EnableAutoConfiguration
public class GetGoogleFeed {

     private static final Logger logger = Logger.getLogger(GetGoogleFeed.class);

     private static final String googleAPIURL = "https://ajax.googleapis.com/ajax/services/search/news?v=1.0&q=";

     public GoogleFeedResponse getFeed(String location) {
    URL url;
    try {
        logger.debug("Google news feed URL : " + googleAPIURL + URLEncoder.encode(location, "UTF-8"));
        url = new URL(googleAPIURL + URLEncoder.encode(location, "UTF-8"));
        logger.debug("Fetching news feed for location : " + location);
        URLConnection connection = url.openConnection();

       String line;
      StringBuilder builder = new StringBuilder();
      BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
          while((line = reader.readLine()) != null) {
               builder.append(line);
      }

          logger.debug("Google news feed response : " + builder.toString());
          JSONObject feedObject = new JSONObject(builder.toString());

          ObjectMapper objectMapper = new ObjectMapper();
          objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

          GoogleFeedResponse response = objectMapper.readValue(feedObject.toString(), GoogleFeedResponse.class);

          return response;
     } catch (Exception e) {
        e.printStackTrace();
      } return null;
   }
}

