package com.jet.cp.yelp.domain;

import java.io.Serializable;
import java.util.List;

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
