/**
 * All rights reserved.
 * This software is the confidential and proprietary information
 */
package com.jet.cp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * Title: CPApplication.java<br>
 * Description: <br>
 * Created: 09-Feb-2016<br>
 * Copyright: Copyright (c) 2015<br>
 * @author Teja Sasank Gorthi (jet.sasank@gmail.com)
 */
@SpringBootApplication
@EnableSwagger2
@EnableMongoRepositories
@EnableScheduling
public class CPApplication {


  /**
   * @param args
   */
  public static void main(String[] args) {

    SpringApplication.run(CPApplication.class, args);
  }

    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("cityInfoGuide")
                .apiInfo(apiInfo())
                .select()
                .build();
    }

  private ApiInfo apiInfo() {
      return new ApiInfoBuilder()
              .title("City Info API")
              .description("Web App build using third party API's to create a user dashboard")
              .termsOfServiceUrl("Have Fun ... but please screw with my server!")
              .contact("Teja Sasank Gorthi")
              .build();
  }

}
