package com.example.springboot.repository;

import com.example.springboot.model.User;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;
@Repository
@Document(collection = "users")
@EnableMongoRepositories
public interface UserRepository extends MongoRepository<User,String> {
    Optional<User> getUserByUsername(String username);

}

