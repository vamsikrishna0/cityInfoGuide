package com.jet.cp.mongo;

import org.springframework.stereotype.Service;

import com.jet.cp.google.domain.GoogleFeedDomain;
import com.jet.cp.yelp.domain.YelpFeedDomain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Title: DBFeedService.java
 * Description: DBFeedService.java<br>
 * Description: <br>
 * Created: 17-Mar-2016<br>
 * Copyright: Copyright (c) 2015<br>
 * @author Teja Sasank Gorthi (jet.sasank@gmail.com)
 */
@Service
public class DBFeedService {
    @Autowired
    private FeedRepository repository;

    @Autowired
    private YelpFeedRepository yelpFeedRepository;

    public List<GoogleFeedDomain> getGoogleFeed(String location) {
        return repository.findByCityName(location);
    }

    public void saveGoogleFeed(GoogleFeedDomain domain){
         repository.save(domain);
    }

    public void clearGoogleFeedCache() {
       repository.deleteAll();
    }
    public void saveYelpFeed(YelpFeedDomain domain) {
       yelpFeedRepository.save(domain);
    }

    public List<YelpFeedDomain> getYelpFeed(String location) {
        return yelpFeedRepository.findByCityName(location);
    }

    public void clearYelpFeedCache() {
         yelpFeedRepository.deleteAll();
    }
}
