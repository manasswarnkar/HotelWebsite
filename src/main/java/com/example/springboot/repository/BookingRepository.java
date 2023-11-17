package com.example.springboot.repository;

import com.example.springboot.model.HotelBooking;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Document(collection = "bookings")
@EnableMongoRepositories
public interface BookingRepository extends MongoRepository<HotelBooking,String> {
    HotelBooking saveBooking();
}
