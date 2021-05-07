package com.nodamu.petch.repositories.property;

import com.nodamu.petch.models.property.Reviews;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author profnick
 * 3/25/21
 **/

@Repository
public interface ReviewsRepository extends MongoRepository<Reviews,String> {
}
