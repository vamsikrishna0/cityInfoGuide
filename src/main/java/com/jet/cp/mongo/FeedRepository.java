package com.jet.cp.mongo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jet.cp.google.domain.GoogleFeedDomain;

public interface FeedRepository extends MongoRepository<GoogleFeedDomain, String>{

    public List<GoogleFeedDomain> findByCityName(String cityName);
}
