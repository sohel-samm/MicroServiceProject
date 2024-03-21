package com.lcwd.rating.ratingservice.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lcwd.rating.ratingservice.entities.Rating;

public interface RatingRepository extends MongoRepository<Rating,String> {
    //custome finder methods
    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);

}
