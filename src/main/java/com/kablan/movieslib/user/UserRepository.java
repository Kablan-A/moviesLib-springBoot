package com.kablan.movieslib.user;

import com.kablan.movieslib.user.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, ObjectId> {
    Optional<User> findUserByEMail(String eMail);
}
