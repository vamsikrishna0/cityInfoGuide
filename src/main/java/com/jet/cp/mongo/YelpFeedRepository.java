/**
 * 
 */
package com.jet.cp.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

import com.jet.cp.yelp.domain.YelpFeedDomain;

/**
 * Title: YelpFeedRepository.java
 * Description: FeedRepository.java<br>
 * Description: <br>
 * Created: 17-Mar-2016<br>
 * Copyright: Copyright (c) 2015<br>
 * @author Teja Sasank Gorthi (jet.sasank@gmail.com)
 */
public interface YelpFeedRepository extends MongoRepository<YelpFeedDomain, String> {

     public List<YelpFeedDomain> findByCityName(String cityName);
}
