package com.nodamu.petch.repositories.users;

import com.nodamu.petch.models.users.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author profnick
 * 3/25/21
 **/

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    User findByEmail(String email);
}
