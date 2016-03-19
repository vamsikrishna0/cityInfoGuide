package com.jet.cp.user.domain;

import java.io.Serializable;

/**
 * Title: User.java<br>
 * Description: <br>
 * Created: 17-Mar-2016<br>
 * Copyright: Copyright (c) 2015<br>
 * @author Teja Sasank Gorthi (jet.sasank@gmail.com)
 */
public class User implements Serializable{
   private static final long serialVersionUID = 1L;

   private String userName;
   private String location;
   private String email;
   private String emailPref;

   /**
    * @return the userName
    */
   public String getUserName() {
      return userName;
   }
   /**
    * @param userName the userName to set
    */
   public void setUserName(String userName) {
      this.userName = userName;
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
    * @return the email
    */
   public String getEmail() {
      return email;
   }
   /**
    * @param email the email to set
    */
   public void setEmail(String email) {
      this.email = email;
   }

   /**
    * @return the emailPref
    */
   public String getEmailPref() {
     return emailPref;
  }

   /**
    * @param emailPref the emailPref to set
    */
   public void setEmailPref(String emailPref) {
      this.emailPref = emailPref;
  }
}
