package com.jet.cp.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

/**
 * Title: SendEmail.java<br>
 * Description: <br>
 * Created: 17-Mar-2016<br>
 * Copyright: Copyright (c) 2015<br>
 * @author Teja Sasank Gorthi (jet.sasank@gmail.com)
 */
@Component
public class SendEmail {
   private static final Logger logger = Logger.getLogger(SendEmail.class);
   @Autowired
   private JavaMailSender javaMailSender;

   public void send(String to, String subject, String body)  {
      try {
      MimeMessage message = javaMailSender.createMimeMessage();
      MimeMessageHelper helper = new MimeMessageHelper(message, true); 

      logger.info("Sending email to user : " + to);
      helper.setSubject(subject);
      helper.setTo(to);
      helper.setText(body, true); 
      javaMailSender.send(message);

      } catch (MessagingException exp) {
    	  exp.printStackTrace();
      }
      
   }
}
