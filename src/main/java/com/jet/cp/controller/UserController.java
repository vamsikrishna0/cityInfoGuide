package com.jet.cp.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jet.cp.user.domain.User;

import io.swagger.annotations.ApiOperation;

@RestController
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class);
   @Autowired
   private ControllerHelper controllerHelper;

   @ApiOperation(value = "Creates a new user", nickname = "Creates a new user")
   @RequestMapping(value = "/createUser", method = RequestMethod.GET)
   private boolean createNewUser(@RequestParam String emailId, @RequestParam String location, @RequestParam String emailPref) {

      logger.info("Creating user for email id : " + emailId);
      return controllerHelper.insertUser(populateUserData(emailId, location, emailPref));
   }


   @ApiOperation(value = "Updates an existing user", nickname = "Updates an existing  user")
   @RequestMapping(value = "/updateUser", method = RequestMethod.GET)
   private boolean updateUser(@RequestParam String emailId, @RequestParam String location, @RequestParam String emailPref) {
      logger.info("update user for email id : " + emailId);
      User user = populateUserData(emailId, location, emailPref);
      return controllerHelper.updatetUserInfo(user.getUserName(),  user.getEmailPref(), user.getLocation());
   }

   @ApiOperation(value = "Returns the data for a requested user name", nickname = "Returns the data for a requested user name")
   @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
   private User getUser(@RequestParam String emailId) {
      logger.info("fetching user information for : " + emailId);
      return controllerHelper.getUserInfo(emailId.split("@")[0]);
   }

   @ApiOperation(value = "Returns email Ids of users", nickname = "Returns email Ids of users")
   @RequestMapping(value = "/getEmailIds", method = RequestMethod.GET)
   private List<String> getEmailIds(@RequestParam char frequencyType) {
      logger.info("fetching email ids for : " + frequencyType);
      return controllerHelper.getEmailIds(frequencyType);
   }

   private User populateUserData(String emailId, String location, String emailPref) {
      User user = new User();

      user.setEmail(emailId);
      user.setUserName(emailId.split("@")[0]);
      user.setLocation(location);
      user.setEmailPref(emailPref);

      return user;
   }
}
