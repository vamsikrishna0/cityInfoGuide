/**
 * All rights reserved.
 * This software is the confidential and proprietary information
 */
package com.jet.cp.yelp.service;

import org.json.JSONObject;
import org.scribe.builder.ServiceBuilder;
import org.scribe.model.*;
import org.scribe.oauth.*;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jet.cp.yelp.domain.YelpResponse;

/**
 * Title: GetYelpFeed.java<br>
 * Description: <br>
 * Created: 09-Feb-2016<br>
 * Copyright: Copyright (c) 2015<br>
 * @author Teja Sasank Gorthi (jet.sasank@gmail.com)
 */
public class GetYelpFeed {

  OAuthService service;
  Token accessToken;

  public GetYelpFeed(String consumerKey, String consumerSecret, String token, String tokenSecret) {
    this.service = new ServiceBuilder().provider(TwoStepOAuth.class).apiKey(consumerKey).apiSecret(consumerSecret).build();
    this.accessToken = new Token(token, tokenSecret);
  }

  public YelpResponse getFeed(String location) {
    OAuthRequest request = new OAuthRequest(Verb.GET, "http://api.yelp.com/v2/search");
    request.addQuerystringParameter("location", location);
    request.addQuerystringParameter("limit", "10");
    request.addQuerystringParameter("category_filter", "restaurants");
    this.service.signRequest(this.accessToken, request);

    Response response = request.send();

    JSONObject feedObject = new JSONObject(response.getBody());

    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    try {
        return objectMapper.readValue(feedObject.toString(), YelpResponse.class);
     } catch (Exception e) {
       return null;
    } 
  }

}
