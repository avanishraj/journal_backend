package com.avanish.journalApp.repository;
import com.avanish.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserServiceRepository extends MongoRepository<User, ObjectId> {
}
