package com.nasifproject.pcbuilder.reviews;

import com.nasifproject.pcbuilder.PcBuilds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;


@Service
public class ReviewService {
    @Autowired
    private ReviewRepository repository;

    @Autowired
    private MongoTemplate mongoTemplate;
    public Review createReview(String reviewBody, String buildid){
       Review review =repository.insert(new Review(reviewBody));


       //template to perform an update call on PcBuilds class in reviewIds option

        mongoTemplate.update(PcBuilds.class)
                .matching(Criteria.where("buildid").is(buildid))
                  .apply(new Update().push("reviewIds").value(review.getId()))
                  .first();
        return review;
    }
}
