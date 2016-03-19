package com.jet.cp.mongo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jet.cp.google.domain.GoogleFeedDomain;

/**
 * Title: FeedRepository.java
 * Description: FeedRepository.java<br>
 * Description: <br>
 * Created: 17-Mar-2016<br>
 * Copyright: Copyright (c) 2015<br>
 * @author Teja Sasank Gorthi (jet.sasank@gmail.com)
 */
public interface FeedRepository extends MongoRepository<GoogleFeedDomain, String>{

    public List<GoogleFeedDomain> findByCityName(String cityName);
}
