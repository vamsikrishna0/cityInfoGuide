package com.jet.cp.yelp.domain;


/**
 * Title: Business.java<br>
 * Description: <br>
 * Created: 17-Mar-2016<br>
 * Copyright: Copyright (c) 2015<br>
 * @author Teja Sasank Gorthi (jet.sasank@gmail.com)
 */
public class Business {
   private float rating;
   private String name;
   private String rating_img_url_small;
   private String url;
   private String image_url;
   private String phone;
   private String snippet_text;
   public Business() {
   }

   
   /**
 * @return the rating
 */
public float getRating() {
	return rating;
}


/**
 * @param rating the rating to set
 */
public void setRating(float rating) {
	this.rating = rating;
}


/**
 * @return the name
 */
public String getName() {
	return name;
}


/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}


/**
 * @return the rating_img_url_small
 */
public String getRating_img_url_small() {
	return rating_img_url_small;
}


/**
 * @param rating_img_url_small the rating_img_url_small to set
 */
public void setRating_img_url_small(String rating_img_url_small) {
	this.rating_img_url_small = rating_img_url_small;
}


/**
 * @return the url
 */
public String getUrl() {
	return url;
}


/**
 * @param url the url to set
 */
public void setUrl(String url) {
	this.url = url;
}


/**
 * @return the image_url
 */
public String getImage_url() {
	return image_url;
}


/**
 * @param image_url the image_url to set
 */
public void setImage_url(String image_url) {
	this.image_url = image_url;
}


/**
 * @return the phone
 */
public String getPhone() {
	return phone;
}


/**
 * @param phone the phone to set
 */
public void setPhone(String phone) {
	this.phone = phone;
}


/**
 * @return the snippet_text
 */
public String getSnippet_text() {
	return snippet_text;
}


/**
 * @param snippet_text the snippet_text to set
 */
public void setSnippet_text(String snippet_text) {
	this.snippet_text = snippet_text;
}


class Location {
    private String display_address;

    public Location() {
    }

   /**
    * @return the display_address
    */
   public String getDisplay_address() {
      return display_address;
   }
   /**
    * @param display_address the display_address to set
    */
   public void setDisplay_address(String display_address) {
      this.display_address = display_address;
   }

    
   }
}
