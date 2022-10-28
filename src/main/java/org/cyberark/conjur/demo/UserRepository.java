package org.cyberark.conjur.demo;

/**
 * @author bnasslahsen
 */

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * The interface User repository.
 */
public interface UserRepository extends MongoRepository<User, Integer> {
}