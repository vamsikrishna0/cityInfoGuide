package com.jet.cp.yelp.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Title: YelpResponse.java<br>
 * Description: <br>
 * Created: 17-Mar-2016<br>
 * Copyright: Copyright (c) 2015<br>
 * @author Teja Sasank Gorthi (jet.sasank@gmail.com)
 */
public class YelpResponse implements Serializable{

  private static final long serialVersionUID = 1L;
  private List<Business> businesses;
  private String source;

   public YelpResponse() {
   }

    /**
     * @return the businesses
     */
   public List<Business> getBusinesses() {
        return businesses;
        }

   /**
     * @param businesses the businesses to set
     */
   public void setBusinesses(List<Business> businesses) {
       this.businesses = businesses;
   }

   /**
   * @return the source
   */
  public String getSource() {
      return source;
   }

   /**
   * @param source the source to set
   */
  public void setSource(String source) {
     this.source = source;
 }

   
}
