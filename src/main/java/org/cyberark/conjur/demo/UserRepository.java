package org.cyberark.conjur.demo;

/**
 * @author bnasslahsen
 */

import org.springframework.data.mongodb.repository.MongoRepository;
public interface UserRepository extends MongoRepository<User, Integer> {
}