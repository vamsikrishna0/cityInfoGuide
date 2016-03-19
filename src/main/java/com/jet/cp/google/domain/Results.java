package com.jet.cp.google.domain;

public class Results {

   private String content;
   private String unescapedUrl;
   private String url;
   private String title;
   private String titleNoFormatting;
   private String location;
   private String publisher;
   private String publishedDate;
   private String signedRedirectUrl;
   private String language;
   private String clusterUrl;
   private Image image;
   public Results() {
   } 

   /**
    * @return the content
    */
   public String getContent() {
      return content;
   } 

   /**
    * @param content the content to set
    */
   public void setContent(String content) {
      this.content = content;
   } 

   /**
    * @return the unescapedUrl
    */
   public String getUnescapedUrl() {
      return unescapedUrl;
   } 

   /**
    * @param unescapedUrl the unescapedUrl to set
    */
   public void setUnescapedUrl(String unescapedUrl) {
      this.unescapedUrl = unescapedUrl;
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
    * @return the title
    */
   public String getTitle() {
      return title;
   } 

   /**
    * @param title the title to set
    */
   public void setTitle(String title) {
      this.title = title;
   } 

   /**
    * @return the titleNoFormatting
    */
   public String getTitleNoFormatting() {
      return titleNoFormatting;
   } 

   /**
    * @param titleNoFormatting the titleNoFormatting to set
    */
   public void setTitleNoFormatting(String titleNoFormatting) {
      this.titleNoFormatting = titleNoFormatting;
   } 

   /**
    * @return the location
    */
   public String getLocation() {
      return location;
   } 

   /**
    * @param location the location to set
    */
   public void setLocation(String location) {
      this.location = location;
   } 

   /**
    * @return the publisher
    */
   public String getPublisher() {
      return publisher;
   } 

   /**
    * @param publisher the publisher to set
    */
   public void setPublisher(String publisher) {
      this.publisher = publisher;
   } 

   /**
    * @return the publishedDate
    */
   public String getPublishedDate() {
      return publishedDate;
   } 

   /**
    * @param publishedDate the publishedDate to set
    */
   public void setPublishedDate(String publishedDate) {
      this.publishedDate = publishedDate;
   } 

   /**
    * @return the signedRedirectUrl
    */
   public String getSignedRedirectUrl() {
      return signedRedirectUrl;
   } 

   /**
    * @param signedRedirectUrl the signedRedirectUrl to set
    */
   public void setSignedRedirectUrl(String signedRedirectUrl) {
      this.signedRedirectUrl = signedRedirectUrl;
   } 

   /**
    * @return the language
    */
   public String getLanguage() {
      return language;
   } 

   /**
    * @param language the language to set
    */
   public void setLanguage(String language) {
      this.language = language;
   } 

   /**
    * @return the clusterUrl
    */
   public String getClusterUrl() {
      return clusterUrl;
   } 

   /**
    * @param clusterUrl the clusterUrl to set
    */
   public void setClusterUrl(String clusterUrl) {
      this.clusterUrl = clusterUrl;
   } 

   /**
   * @return the image
  */
   public Image getImage() {
      return image;
  }

  /**
  * @param image the image to set
  */
  public void setImage(Image image) {
    this.image = image;
  }

class Image{
      private String url;

   public Image() {
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
   }
}
