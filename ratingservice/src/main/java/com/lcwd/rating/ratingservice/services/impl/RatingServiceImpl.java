package com.lcwd.rating.ratingservice.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.rating.ratingservice.entities.Rating;
import com.lcwd.rating.ratingservice.repositories.RatingRepository;
import com.lcwd.rating.ratingservice.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService {


     @Autowired
     private RatingRepository ratingRepository;


    @Override
    public Rating create(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRating() {
    
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getAllRatingByUser(String userId) {
        return ratingRepository.findByUserId(userId);   
    
    }

    @Override
    public List<Rating> getAllRatingByHotel(String hotelId) {
    
        return ratingRepository.findByHotelId(hotelId);
    }
    
}
