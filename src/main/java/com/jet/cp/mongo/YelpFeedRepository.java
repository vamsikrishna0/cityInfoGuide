package com.jet.cp.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

import com.jet.cp.yelp.domain.YelpFeedDomain;


public interface YelpFeedRepository extends MongoRepository<YelpFeedDomain, String> {

     public List<YelpFeedDomain> findByCityName(String cityName);
}
