package com.lcwd.rating.ratingservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lcwd.rating.ratingservice.entities.Rating;
import com.lcwd.rating.ratingservice.repositories.RatingRepository;

public interface RatingService {

   
    //create ratong
    Rating create(Rating rating);

    //get all rating

    List<Rating> getAllRating();


    //get all rating by userid
    List<Rating> getAllRatingByUser(String userId);


    //get all rating by hotelid
    List<Rating> getAllRatingByHotel(String hotelId);
    
}
