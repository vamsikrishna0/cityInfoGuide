### Current Build Status
[![Build Status](https://travis-ci.org/jetsasank/CP.svg?branch=master)](https://travis-ci.org/jetsasank/CP)

##Developed on:
This is a web-service built using <br/>
1. [Java](https://www.oracle.com/java/index.html) <br/>
2. [Spring Boot](http://projects.spring.io/spring-boot/) <br/>
3. [Swagger UI](http://swagger.io/swagger-ui/) <br/>
4. [JSON](http://json.org) <br/>
5. [Velocity Template](https://velocity.apache.org/engine/releases/velocity-1.5/user-guide.html)<br/>
6. [AngularJS](https://angularjs.org)<br/>
7. [HTML5](https://developer.mozilla.org/en-US/docs/Web/Guide/HTML/HTML5) <br/>
8. [Bootstrap](http://getbootstrap.com/2.3.2/)<br/>
9. [Log4j](http://logging.apache.org/log4j/2.x/)<br/>

On database Layer the application uses :<br/>
1. [MongoDB](https://www.mongodb.org) for caching responses from third-party API's to reduce outgoing traffic from the server. <br/>
2. [Amazon RDS](https://aws.amazon.com/rds/) MySQL flavor for RDBMS services. <br/>

##Deployed on:
The Application is deployed on [AWS EC2](https://aws.amazon.com/ec2/) cloud server on t2.micro instance.

##Continuous Integration(CI)
The public git repository for this application is configured on cloud CI services offered by [Travis CI](https://travis-ci.org) for continuous build.

##Third Party API's:
The Application Connects to Third Party API's such as : <br/>
1.  [OpenWeatherMap](http://openweathermap.org)<br/>
2.  [Google News Feed] (https://developers.google.com/feed/v1/jsondevguide)<br/>
3.  [Yelp API] (https://www.yelp.com/developers/documentation/v2/overview)<br/>
4.  [Google Maps JavaScript API] (https://developers.google.com/maps/documentation/javascript/examples/places-autocomplete)<br/>

##What Does this Application Offer ?

<i>While, the UI of this application is quite intuitive. The UI offers services for providing information about a user entered location. The application consolidates information about a particular location from multiple third-party API's such as google, yelp, openweather and renders the UI page accordingly.</i>

<b>Snapshot :</b>

<img src="https://raw.githubusercontent.com/jetsasank/CP/master/screen%20shots/Screen%20Shot%202016-03-18%20at%209.25.33%20PM.png"/>

<i>It also provides a user-configured email serivce, that sends information to user about a his/her desired location on a daily or weekly basis. The User can sign-up by providing his email id and entering the location and email frequency preference.</i>

<b>Snapshot :</b>

<img src="https://raw.githubusercontent.com/jetsasank/CP/master/screen%20shots/Screen%20Shot%202016-03-18%20at%209.25.36%20PM.png"/>

<img src="https://raw.githubusercontent.com/jetsasank/CP/master/screen%20shots/Screen%20Shot%202016-03-18%20at%209.25.38%20PM.png"/>

<img src="https://raw.githubusercontent.com/jetsasank/CP/master/screen%20shots/Screen%20Shot%202016-03-18%20at%209.25.44%20PM.png"/>

<img src="https://raw.githubusercontent.com/jetsasank/CP/master/screen%20shots/Screen%20Shot%202016-03-18%20at%209.26.47%20PM.png"/>

<i>The Application also provides API services for developers to connect to this APP for querying information for a particular location, google feed news for any search string and yelp records. The application also provides a API documentation using [Swagger UI](http://swagger.io/swagger-ui/), thus  making life easier for any developer wanting to use this service/API.</b>

<b>Snapshot :</i>

<img src="https://raw.githubusercontent.com/jetsasank/CP/master/screen%20shots/Screen%20Shot%202016-03-18%20at%209.25.55%20PM.png"/>

