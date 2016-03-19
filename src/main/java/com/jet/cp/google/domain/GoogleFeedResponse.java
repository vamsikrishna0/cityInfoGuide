package com.jet.cp.google.domain;

public class GoogleFeedResponse {

   private static final long serialVersionUID = 1L;
   private ResponseData responseData;
   private String source;
   public GoogleFeedResponse() {
      
   }
   /**
    * @return the responseData
    */
   public ResponseData getResponseData() {
      return responseData;
   }
   /**
    * @param responseData the responseData to set
    */
   public void setResponseData(ResponseData responseData) {
      this.responseData = responseData;
   }
   /**
    * @return the serialversionuid
    */
   public static long getSerialversionuid() {
      return serialVersionUID;
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
